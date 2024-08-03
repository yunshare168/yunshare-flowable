package com.yunshare.core.listener;

import com.yunshare.core.constant.ProcessConstant;
import com.yunshare.core.engine.assignee.AssigneeStrategyFactory;
import com.yunshare.core.engine.nobody.NobodyStrategyFactory;
import com.yunshare.core.engine.utils.BpmnUtil;
import com.yunshare.core.engine.utils.NodeIdUtil;
import com.yunshare.core.enums.AutoTask;
import com.yunshare.core.enums.NoHandlerAction;
import com.yunshare.core.tool.exception.ServiceException;
import com.yunshare.core.tool.jackson.JsonUtil;
import com.yunshare.core.tool.utils.CollectionUtil;
import com.yunshare.core.tool.utils.SpringUtil;
import com.yunshare.modules.dto.bpm.BpmModelInput;
import com.yunshare.modules.dto.bpm.NodeConfig;
import lombok.extern.slf4j.Slf4j;
import org.flowable.bpmn.model.Process;
import org.flowable.bpmn.model.UserTask;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.yunshare.core.constant.ProcessConstant.*;

/**
 * <p>会签监听器</p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/30 上午10:58
 */
@Slf4j
@Component
public class CounterSignListener implements ExecutionListener {

	@Override
	public void notify(DelegateExecution execution) {
		String currentActivityId = execution.getCurrentActivityId();
		// Process process = ProcessCache.getCache().getProcess(execution.getProcessDefinitionId());
		Process process = null;
		UserTask userTask = (UserTask) process.getFlowElement(currentActivityId);
		String mc = process.getAttributeValue(ProcessConstant.FLOW_EXT_NAMESPACE, ProcessConstant.FLOW_EXT_NAME);
		BpmModelInput bpmModelInput = JsonUtil.parse(mc, BpmModelInput.class);
		NodeConfig nodeConfig = bpmModelInput.getNodeConfig();
		String variable = userTask.getId().concat(ProcessConstant.ASSIGNEE_LIST);
		List users = (List) execution.getVariable(variable);
		// 只有当users为空时才处理，否则不处理
		if (CollectionUtil.isEmpty(users)) {
			String nodeId = NodeIdUtil.removePrefix(currentActivityId);
			// 查询任务当前节点
			NodeConfig currNode = BpmnUtil.getCurrNode(nodeConfig, nodeId);
			if (Objects.isNull(currNode)) {
				throw new ServiceException("没有审批节点，流程异常");
			}
			AssigneeStrategyFactory strategyFactory = SpringUtil.getBean(AssigneeStrategyFactory.class);
			List<String> assigneeList = strategyFactory.findUsers(currNode, execution, nodeConfig);
			// 查询如果没有审批人的赋值
			if (!currNode.getNoHandlerAction().getType().equals(NoHandlerAction.SOMEONE.getType())) {
				NobodyStrategyFactory nobodyStrategyFactory = SpringUtil.getBean(NobodyStrategyFactory.class);
				Map<String, Object> nobody = nobodyStrategyFactory.nobody(currNode);
				assigneeList.add(nobody.get(NOBODY_VAL).toString());
				if ((Boolean) nobody.get(ProcessConstant.PASS_KEY)) {
					execution.setVariable(ProcessConstant.PASS_KEY, nobody.get(ProcessConstant.PASS_KEY));
				}
			}
			// 如果节点配置了自动通过
			if (currNode.getAutoTask().getKey().equals(AutoTask.AUTO.getKey())) {
				execution.setVariable(AUTO_TASK, AutoTask.AUTO.getKey());
				assigneeList.add(AUTO);
			}
			// 如果还是没有人，则自动通过
			if (CollectionUtil.isEmpty(assigneeList)) {
				assigneeList.add(NOBODY);
				execution.setVariable(ProcessConstant.PASS_KEY, true);
			}
			execution.setVariable(variable, assigneeList);
		}
	}
}
