package com.yunshare.core.engine.creator;

import com.yunshare.core.constant.ProcessConstant;
import com.yunshare.core.engine.NodeHandler;
import com.yunshare.core.enums.NodeType;
import com.yunshare.core.tool.exception.ServiceException;
import com.yunshare.core.tool.jackson.JsonUtil;
import com.yunshare.core.tool.utils.SpringUtil;
import com.yunshare.modules.dto.bpm.BpmModelInput;
import com.yunshare.modules.dto.bpm.NodeConfig;
import org.assertj.core.util.Lists;
import org.flowable.bpmn.BpmnAutoLayout;
import org.flowable.bpmn.model.Process;
import org.flowable.bpmn.model.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * <p>流程节点生成策略工厂</p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/19 下午4:38
 */
@Component
public class NodeStrategyFactory {
	/**
	 * <p>构建bpmn对象</p>
	 *
	 * @param input 构建bpmn模板输入参数
	 * @return org.flowable.bpmn.model.BpmnModel
	 * @author lzx@yuyuda.com
	 * @since 2023/1/17 上午11:28
	 */
	public BpmnModel buildBpmnModel(BpmModelInput input) {
		BpmnModel bpmnModel = new BpmnModel();
		Process process = new Process();
		bpmnModel.addProcess(process);
		List<SequenceFlow> sequenceFlows = Lists.newArrayList();
		process.setId(input.getProcessDefinitionKey());
		process.setName(input.getWorkFlowDef());
		StartEvent startEvent = new StartEvent();
		startEvent.setId(ProcessConstant.START_EVENT_ID);
		process.addFlowElement(startEvent);
		ExtensionAttribute extensionAttribute = new ExtensionAttribute();
		extensionAttribute.setName(ProcessConstant.FLOW_EXT_NAME);
		extensionAttribute.setNamespace(ProcessConstant.FLOW_EXT_NAMESPACE);
		extensionAttribute.setValue(JsonUtil.toJson(input));
		process.addAttribute(extensionAttribute);
		NodeConfig nodeConfig = input.getNodeConfig();
		NodeInput nodeInput = new NodeInput(startEvent.getId(), "", nodeConfig, bpmnModel, process, sequenceFlows);
		//默认最后一个节点ID为开始节点
		String lastNode = startEvent.getId();
		//排除root节点
		if (nodeConfig.getNodeType() == NodeType.ROOT && nodeConfig.getChildNode() != null) {
			nodeInput.setNodeConfig(nodeConfig.getChildNode());
			// 节点构建
			lastNode = this.creator(nodeInput);
		}
		EndEvent endEvent = new EndEvent();
		endEvent.setId(ProcessConstant.END_EVENT_ID);
		process.addFlowElement(endEvent);
		// 检查因为网关存在时，不再绘制最后一条线，因为已经绘制
		boolean hasEndEventId = false;
		List<SequenceFlow> checkExistEndEventIds = nodeInput.getSequenceFlows();
		for (SequenceFlow sequenceFlow : checkExistEndEventIds) {
			if (sequenceFlow.getTargetRef().equals(ProcessConstant.END_EVENT_ID)) {
				hasEndEventId = true;
				break;
			}
		}
		if (Boolean.FALSE.equals(hasEndEventId)) {
			NodeHandler handler = SpringUtil.getBean(RootHandler.class);
			nodeInput.setResourceId(lastNode);
			nodeInput.setTargetId(endEvent.getId());
			process.addFlowElement(handler.connect(nodeInput));
		}
		new BpmnAutoLayout(bpmnModel).execute();
		return bpmnModel;
	}

	/**
	 * <p>节点创建器</p>
	 *
	 * @param input 参数
	 * @return java.lang.String
	 * @author lzx@yuyuda.com
	 * @since 2023/1/19 下午5:38
	 */
	public String creator(NodeInput input) {
		String beanId = input.getNodeConfig().getNodeType().getBeanId();
		NodeHandler handler = SpringUtil.getBean(beanId);
		if (Objects.isNull(handler)) {
			throw new ServiceException(String.format("nodeType beanId[%s]不存在", beanId));
		}
		String currNodeId = handler.node(input);
		input.setResourceId(currNodeId);
		if (input.getNodeConfig() == null) {
			return currNodeId;
		}
		// 如果还有子节点，继续往下执行
		NodeConfig nextNode = input.getNodeConfig().getChildNode();
		input.setNodeConfig(nextNode);
		if (Objects.nonNull(nextNode) && Objects.nonNull(nextNode.getNodeId())) {
			return creator(input);
		}
		return currNodeId;
	}
}
