package com.yunshare.core.listener;

import com.yunshare.core.constant.ProcessConstant;
import com.yunshare.core.engine.assignee.AssigneeStrategyFactory;
import com.yunshare.core.engine.utils.BpmnUtil;
import com.yunshare.core.engine.utils.NodeIdUtil;
import com.yunshare.core.tool.exception.ServiceException;
import com.yunshare.core.tool.utils.CollectionUtil;
import com.yunshare.core.tool.utils.Func;
import com.yunshare.core.tool.utils.SpringUtil;
import com.yunshare.core.tool.utils.StringUtil;
import com.yunshare.modules.dto.FlowTemplateDTO;
import com.yunshare.modules.dto.bpm.NodeConfig;
import com.yunshare.modules.entity.YunshareFlowCc;
import com.yunshare.modules.service.IYunshareFlowCcService;
import com.yunshare.modules.service.IYunshareFlowTemplateService;
import com.yunshare.modules.service.impl.YunshareFlowCcServiceImpl;
import com.yunshare.modules.service.impl.YunshareFlowTemplateServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngines;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.flowable.engine.repository.ProcessDefinition;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * <p>抄送流程监听</p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/18 下午4:08
 */
@Slf4j
@Component
public class CcListener implements JavaDelegate {

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void execute(DelegateExecution execution) {
        // 查询流程定义信息
        String processDefinitionId = execution.getProcessDefinitionId();
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = engine.getRepositoryService();
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .processDefinitionId(processDefinitionId)
                .singleResult();
        String processDefinitionKey = processDefinition.getKey();
        String currentActivityId = execution.getCurrentActivityId();
        String nodeId = NodeIdUtil.removePrefix(currentActivityId);
        String processTemplateId = processDefinitionKey.replace(ProcessConstant.FLOWABLE_ID, "");
        // 从流程模板中找出抄送人列表
        IYunshareFlowTemplateService flowTemplateService = SpringUtil.getBean(YunshareFlowTemplateServiceImpl.class);
        FlowTemplateDTO detail = flowTemplateService.detail(Long.parseLong(processTemplateId));
        NodeConfig currNode = BpmnUtil.getCurrNode(detail.getNodeConfig(), nodeId);
        if (Objects.isNull(currNode)) {
            throw new ServiceException("抄送节点不存在， 请检查");
        }
        AssigneeStrategyFactory strategyFactory = SpringUtil.getBean(AssigneeStrategyFactory.class);
        List<String> ccUsers;
        // 查看抄送是否是发起人自选
        List<String> valCcUsers = execution.getVariable(currentActivityId.concat(ProcessConstant.ASSIGNEE_LIST), List.class);
        if (CollectionUtil.isNotEmpty(valCcUsers)) {
            ccUsers = valCcUsers;
        } else {
            ccUsers = strategyFactory.findUsers(currNode, execution, null);
        }
        if (CollectionUtil.isNotEmpty(ccUsers)) {
            String applyUserId = (String) execution.getVariable(ProcessConstant.START_USER_VAL);
            String applyClient = (String) execution.getVariable(ProcessConstant.APPLY_CLIENT);
            String applySn = (String) execution.getVariable(ProcessConstant.APPLY_SN);
            // 保存抄送记录
            IYunshareFlowCcService flowCcService = SpringUtil.getBean(YunshareFlowCcServiceImpl.class);
            List<YunshareFlowCc> entities = new LinkedList<>();
            ccUsers.forEach(item -> {
                YunshareFlowCc flowCc = new YunshareFlowCc();
                flowCc.setCorpId(Func.toLong(execution.getTenantId(), -1));
                flowCc.setUserId(Long.valueOf(item));
                flowCc.setFlowTemplateId(detail.getId());
                flowCc.setProcessDefinitionId(processDefinitionId);
                flowCc.setProcessInstanceId(execution.getProcessInstanceId());
                flowCc.setProcessDefinitionKey(processDefinitionKey);
                flowCc.setApplyUserId(StringUtil.hasText(applyUserId) ? Long.parseLong(applyUserId) : 0L);
                flowCc.setApplyClient(applyClient);
                flowCc.setApplySn(applySn);
                entities.add(flowCc);
            });
            boolean saveBatch = flowCcService.saveBatch(entities);
            if (Boolean.FALSE.equals(saveBatch)) {
                log.error(String.format("抄送异常， nodeId[%s], processDefinitionId[%s], processDefinitionKey[%s], processTemplateId[%s]",
                        execution.getCurrentActivityId(), processDefinitionId, processDefinitionKey, processTemplateId));
            } else {
                //更新索引
                //ProcessUtil.transactionCommitSync(EsSyncMessage.MsgEnum.CC, Collections.singleton(execution.getProcessInstanceId()));
            }
        } else {
            log.error(String.format("抄送异常， 抄送人为空， nodeId[%s], processDefinitionId[%s], processDefinitionKey[%s], processTemplateId[%s]",
                    execution.getCurrentActivityId(), processDefinitionId, processDefinitionKey, processTemplateId));
        }
    }
}
