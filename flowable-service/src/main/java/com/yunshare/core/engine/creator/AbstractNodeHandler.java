package com.yunshare.core.engine.creator;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.yunshare.core.constant.ProcessConstant;
import com.yunshare.core.engine.NodeHandler;
import com.yunshare.core.engine.comparison.ComparisonStrategyFactory;
import com.yunshare.core.enums.ExamineModeEnum;
import com.yunshare.core.enums.NodeType;
import com.yunshare.core.tool.exception.ServiceException;
import com.yunshare.core.tool.utils.SpringUtil;
import com.yunshare.core.tool.utils.StringUtil;
import com.yunshare.modules.dto.bpm.NodeConfig;
import org.flowable.bpmn.model.*;
import org.flowable.common.engine.impl.util.CollectionUtil;
import org.flowable.engine.delegate.BaseExecutionListener;
import org.flowable.task.service.delegate.BaseTaskListener;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import static org.flowable.bpmn.model.ImplementationType.IMPLEMENTATION_TYPE_DELEGATEEXPRESSION;

/**
 * <p>节点处理抽象类</p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/19 下午7:10
 */
public abstract class AbstractNodeHandler implements NodeHandler {
	/**
	 * 审批人参数
	 */
	private static final String ASSIGNEE_STRING = "assignee";

	/**
	 * <p>创建动作</p>
	 *
	 * @param input 参数
	 * @return java.lang.String
	 * @author lzx@yuyuda.com
	 * @since 2023/1/19 下午2:46
	 */
	@Override
	public String node(NodeInput input) {
		UserTask userTask = new UserTask();
		NodeConfig nodeConfig = input.getNodeConfig();
		userTask.setName(nodeConfig.getNodeName());
		userTask.setId(ProcessConstant.USER_TASK_ID.concat(String.valueOf(nodeConfig.getNodeId())));
		input.getProcess().addFlowElement(userTask);
		// 创建事件监听
		List<FlowableListener> taskListeners = new ArrayList<>();
		FlowableListener taskListener = new FlowableListener();
		// 事件类型
		taskListener.setEvent(BaseTaskListener.EVENTNAME_CREATE);
		// 监听器类型
		taskListener.setImplementationType(IMPLEMENTATION_TYPE_DELEGATEEXPRESSION);
		// 设置监听器的类型是delegateExpression，这样可以在实现类注入Spring bean.
		taskListener.setImplementation("${taskCreatedListener}");
		taskListeners.add(taskListener);
		userTask.setTaskListeners(taskListeners);
		// 如果不是根节点，需要做多实例
		boolean b = !input.getNodeConfig().getNodeType().getNodeType().equals(NodeType.ROOT.getNodeType());
		if (b) {
			String examineMode = input.getNodeConfig().getExamineMode().getValue();
			if (StringUtil.isEmpty(examineMode)) {
				throw new ServiceException("审批方式不能为空");
			}
			// 写入审批人EL表达式
			userTask.setAssignee("${assignee}");
			// 设置多实例属性
			userTask.setLoopCharacteristics(this.getCounterSign(input, userTask));
		}
		// 连线, 需要连线才连
		if (input.getNodeConfig() != null && Boolean.TRUE.equals(input.getNodeConfig().getIsNeedSequenceFlow())) {
			input.setTargetId(userTask.getId());
			SequenceFlow sequenceFlow = this.connect(input);
			input.getProcess().addFlowElement(sequenceFlow);
		}
		return userTask.getId();
	}

	/**
	 * <p>获取会签信息</p>
	 *
	 * @return org.flowable.bpmn.model.MultiInstanceLoopCharacteristics
	 * @author lzx@yuyuda.com
	 * @since 2023/1/30 上午9:47
	 */
	private MultiInstanceLoopCharacteristics getCounterSign(NodeInput input, UserTask userTask) {
		MultiInstanceLoopCharacteristics characteristics = new MultiInstanceLoopCharacteristics();
		String examineMode = input.getNodeConfig().getExamineMode().getValue();
		// 设置并行执行(每个审批人可以同时执行）
		characteristics.setSequential(false);
		// 如果是或签
		if (examineMode.equals(ExamineModeEnum.OR_SIGN.getValue())) {
			//只要一个人审核不通过，或者一人审核通过流程结束
			characteristics.setCompletionCondition("${!pass || nrOfCompletedInstances/nrOfInstances > 0}");
		} else {
			//只要一个审核为不通过流程结束
			characteristics.setCompletionCondition("${!pass}");
		}
		// 依次审批
		if (examineMode.equals(ExamineModeEnum.SEQUENTIAL.getValue())) {
			characteristics.setSequential(true);
		}
		// 设置会签监听器
		List<FlowableListener> counterListeners = new LinkedList<>();
		FlowableListener taskListener = new FlowableListener();
		taskListener.setEvent(BaseExecutionListener.EVENTNAME_START);
		// 监听器类型
		taskListener.setImplementationType(IMPLEMENTATION_TYPE_DELEGATEEXPRESSION);
		// 监听器的类型是delegateExpression，这样可以在实现类注入Spring bean.
		taskListener.setImplementation("${counterSignListener}");
		counterListeners.add(taskListener);
		userTask.setExecutionListeners(counterListeners);
		characteristics.setInputDataItem(userTask.getId().concat("assigneeList"));
		// 迭代集合
		characteristics.setElementVariable(ASSIGNEE_STRING);
		// 循环次数获取方法，可以按照一定的百分比进行
		return characteristics;
	}

	/**
	 * <p>创建节点连线</p>
	 *
	 * @param input 参数
	 * @return org.flowable.bpmn.model.SequenceFlow
	 * @author lzx@yuyuda.com
	 * @since 2023/1/19 下午7:17
	 */
	@Override
	public SequenceFlow connect(NodeInput input) {
		SequenceFlow flow = new SequenceFlow();
		flow.setId(ProcessConstant.SEQUENCE_FLOW_ID.concat(IdWorker.getIdStr()));
		flow.setSourceRef(input.getResourceId());
		flow.setTargetRef(input.getTargetId());
		// 处理表达式
		ComparisonStrategyFactory comparisonStrategyFactory = SpringUtil.getBean(ComparisonStrategyFactory.class);
		String expression = comparisonStrategyFactory.expression(input);
		if (input.getNodeConfig() != null && CollectionUtil.isNotEmpty(input.getNodeConfig().getConditionExpressions())) {
			flow.setConditionExpression(expression);
		}
		input.getSequenceFlows().add(flow);
		return flow;
	}

	/**
	 * <p>绘制网关</p>
	 *
	 * @param gateway   网关
	 * @param input     参数
	 * @param gatewayId 网关ID
	 * @author lzx@yuyuda.com
	 * @since 2023/1/28 下午11:05
	 */
	@Override
	public void drawGateway(Gateway gateway, NodeInput input, String gatewayId) {
		// 网关
		gateway.setId(gatewayId);
		gateway.setName(input.getNodeConfig().getNodeName());
		input.getProcess().addFlowElement(gateway);
		// 网关连线
		input.setTargetId(gatewayId);
		// 绘制分支
		List<NodeConfig> conditionNodes = input.getNodeConfig().getConditionNodes();
		boolean isConditionNode = CollectionUtil.isNotEmpty(conditionNodes);
		//判断是否存在条件节点，并且上一个节点不等于网关时，设置连线到网关的条件为null
		if (isConditionNode && !input.getResourceId().contains(ProcessConstant.EXCLUSIVE_GATEWAY_ID)&&!input.getResourceId().contains(ProcessConstant.PARALLEL_GATEWAY_ID)) {
			//防止前端在当前连线到网关上传入条件
			input.getNodeConfig().setConditionExpressions(null);
		}
		input.getProcess().addFlowElement(this.connect(input));
		if (isConditionNode) {
			// 与并行网关子节点平等的子节点，即连在网关节点后的节点
			NodeConfig parallelChildNode = input.getNodeConfig().getChildNode();
			String currNodeId = "";
			for (NodeConfig element : conditionNodes) {
				// 创建网关到任务节点
				NodeConfig childNode = element.getChildNode();
				if (Objects.nonNull(childNode) && Objects.nonNull(childNode.getNodeId())) {
					childNode.setConditionExpressions(element.getConditionExpressions());
					input.setNodeConfig(childNode);
					input.setResourceId(gatewayId);
					NodeStrategyFactory nodeStrategyFactory = SpringUtil.getBean(NodeStrategyFactory.class);
					currNodeId = nodeStrategyFactory.creator(input);
				} else {
					currNodeId = gatewayId;
					if (input.getNodeConfig() != null) {
						input.getNodeConfig().setConditionExpressions(element.getConditionExpressions());
					}
				}
				// 绘制网关节点合并后还有节点，绘制网关节点合并后到子节点的连线
				if (Objects.nonNull(parallelChildNode)) {
					input.setResourceId(currNodeId);
					NodeHandler nodeHandler = SpringUtil.getBean(parallelChildNode.getNodeType().getBeanId());
					input.setTargetId(nodeHandler.getNodeIdPrefix().concat(parallelChildNode.getNodeId()));
					SequenceFlow sequenceFlow = this.connect(input);
					input.getProcess().addFlowElement(sequenceFlow);
				} else {
					// 绘制网关任务到结束点
					input.setResourceId(currNodeId);
					input.setTargetId(ProcessConstant.END_EVENT_ID);
					SequenceFlow sequenceFlow = this.connect(input);
					input.getProcess().addFlowElement(sequenceFlow);
				}
			}
			// 绘制网关节点合并后还有节点
			if (Objects.nonNull(parallelChildNode)) {
				input.setNodeConfig(parallelChildNode);
				parallelChildNode.setIsNeedSequenceFlow(false);
				NodeStrategyFactory nodeStrategyFactory = SpringUtil.getBean(NodeStrategyFactory.class);
				currNodeId = nodeStrategyFactory.creator(input);

				// 绘制网关任务到结束点
				input.setResourceId(currNodeId);
				input.setTargetId(ProcessConstant.END_EVENT_ID);
				SequenceFlow sequenceFlow = this.connect(input);
				input.getProcess().addFlowElement(sequenceFlow);
			}
		}
	}
}
