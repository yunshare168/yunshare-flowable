package com.yunshare.core.engine.handler;

import com.yunshare.core.engine.ActionHandler;
import com.yunshare.core.tool.exception.ServiceException;
import com.yunshare.modules.dto.ProcessActionResultDTO;
import com.yunshare.modules.dto.ProcessReqParamDTO;
import com.yunshare.modules.dto.bpm.NodeOrg;
import org.assertj.core.util.Lists;
import org.flowable.engine.RuntimeService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 流程启动处理器
 *
 * @author lzx@yuyuda.com
 * @since 2022/10/9 14:30
 */
@Component
public class InstanceStartActionHandler implements ActionHandler {
    // @Resource
    // private IEsCorpUserService userService;
    @Resource
    private RuntimeService runtimeService;

    @Override
    public ProcessActionResultDTO execute(ProcessReqParamDTO param) {
        String instanceId;
        try {
            /*ProcessDefinition definition = ProcessCache.getCache().getProcessDefinition(param.getProcessDefinitionId());
            if (definition == null) {
                throw new ServiceException("流程信息不存在，发起失败");
            }
            UserInfo user = AuthUtil.getUser();
            Map<String, Object> formData = new HashMap<>(param.getVariables());
            Map<String, Object> variables = param.getVariables();
            variables.put(ProcessConstant.START_USER_VAL, String.valueOf(user.getId()));
            variables.put(ProcessConstant.APPLY_SN, SeqKit.getApplySn());
            variables.put(ProcessConstant.APPLY_CLIENT, param.getApplyClient());
            //设置发起时节点审批选择人
            this.setNodeAssignee(param);
            //发起流程实例名称
            String processInstanceName = user.getName().concat("提交的").concat(definition.getName());
            //启动流程
            ProcessInstance instance = runtimeService.createProcessInstanceBuilder()
                    .processDefinitionId(param.getProcessDefinitionId())
                    .name(processInstanceName)
                    .variables(variables)
                    .businessKey(param.getBusinessKey()).start();
            instanceId = instance.getId();
            // 保存表单数据
            handleService.saveFormData(formData, param.getBusinessKey(), instanceId);*/
        } catch (Exception e) {
            throw new ServiceException("流程发起失败");
        }
        // return ProcessActionResultDTO.builder().processInstanceId(instanceId).build();
        return null;
    }


    /**
     * <p>设置节点审批人</p>
     *
     * @param param 参数
     * @author lzx@yuyuda.com
     * @since 2023/2/8 16:18
     */
    private void setNodeAssignee(ProcessReqParamDTO param) {
        /*NodeConfig nodeConfig = ProcessCache.getCache().getNodeConfig(param.getProcessDefinitionId());
        // 查询任务当前节点
        Map<String, Object> variables = param.getVariables();
        if (CollectionUtils.isNotEmpty(param.getNodeAssignee())) {
            param.getNodeAssignee().forEach(e -> {
                if (e.getTaskId() == null) {
                    return;
                }
                //判断当前流程节点是否是办理，并且审批人为上一节点审批时不处理前端提交的节点处理人
                NodeConfig currNode = BpmnUtil.getCurrNode(nodeConfig, NodeIdUtil.removePrefix(e.getTaskId()));
                if (currNode != null && NodeType.DEAL_TASK == currNode.getNodeType() && MemberType.PREV == currNode.getMemberType()) {
                    return;
                }
                variables.put(e.getTaskId().concat(ProcessConstant.ASSIGNEE_LIST), getUserIds(e.getAssigneeList()));
            });
        }*/
    }

    /**
     * <p>获取办理人信息</p>
     *
     * @param assigneeList 受理人信息
     * @return {@link List< Long>}
     * @author lzx@yuyuda.com
     * @since 2023/2/8 16:28
     */
    public List<String> getUserIds(List<NodeOrg> assigneeList) {
        /*List<String> userIds = assigneeList.stream().filter(e -> e.getOrgEnum() == OrgEnum.USER).map(NodeOrg::getId).collect(Collectors.toList());
        List<Long> deptIds = assigneeList.stream().filter(e -> e.getOrgEnum() == OrgEnum.DEPT).map(e -> Func.toLong(e.getId())).collect(Collectors.toList());
        List<EsUserIndex> esUserIndices = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(deptIds)) {
            List<EsUserIndex> esUser = userService.userListByDeptId(deptIds.toArray(new Long[0]));
            if (esUser != null) {
                esUserIndices.addAll(esUser);
            }
        }
        List<Long> roleIds = assigneeList.stream().filter(e -> e.getOrgEnum() == OrgEnum.ROLE).map(e -> Func.toLong(e.getId())).collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(roleIds)) {
            List<EsUserIndex> esUser = userService.userListByRoleId(roleIds.toArray(new Long[0]));
            if (esUser != null) {
                esUserIndices.addAll(esUser);
            }
        }
        List<String> esUserIds = esUserIndices.stream().map(e -> e.getId().toString()).collect(Collectors.toList());
        userIds.addAll(esUserIds);
        return userIds.stream().distinct().collect(Collectors.toList());*/
        return Lists.emptyList();
    }

}
