package com.yunshare.core.engine.creator;

import com.yunshare.modules.dto.bpm.NodeConfig;
import org.flowable.bpmn.model.BpmnModel;
import org.flowable.bpmn.model.Process;
import org.flowable.bpmn.model.SequenceFlow;

import java.util.List;

/**
 * <p>构造节点参数对象</p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/19 下午2:38
 */
public class NodeInput {
	/**
	 * 起始ID
	 */
	private String resourceId;
	/**
	 * 目标ID
	 */
	private String targetId;
	/**
	 * 节点对象
	 */
	private NodeConfig nodeConfig;
	/**
	 * bpmnModel
	 */
	private BpmnModel bpmnModel;
	/**
	 * process
	 */
	private Process process;

	/**
	 * sequenceFlows
	 */
	private List<SequenceFlow> sequenceFlows;

	public NodeInput(String resourceId, String targetId, NodeConfig nodeConfig, BpmnModel bpmnModel, Process process, List<SequenceFlow> sequenceFlows) {
		this.resourceId = resourceId;
		this.targetId = targetId;
		this.nodeConfig = nodeConfig;
		this.bpmnModel = bpmnModel;
		this.process = process;
		this.sequenceFlows = sequenceFlows;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

	public NodeConfig getNodeConfig() {
		return nodeConfig;
	}

	public void setNodeConfig(NodeConfig nodeConfig) {
		this.nodeConfig = nodeConfig;
	}

	public BpmnModel getBpmnModel() {
		return bpmnModel;
	}

	public void setBpmnModel(BpmnModel bpmnModel) {
		this.bpmnModel = bpmnModel;
	}

	public Process getProcess() {
		return process;
	}

	public void setProcess(Process process) {
		this.process = process;
	}

	public List<SequenceFlow> getSequenceFlows() {
		return sequenceFlows;
	}

	public void setSequenceFlows(List<SequenceFlow> sequenceFlows) {
		this.sequenceFlows = sequenceFlows;
	}
}
