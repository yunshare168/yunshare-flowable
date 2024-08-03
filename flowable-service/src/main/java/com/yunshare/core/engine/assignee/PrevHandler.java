package com.yunshare.core.engine.assignee;

import com.yunshare.core.engine.AssigneeHandler;
import com.yunshare.core.engine.utils.BpmnUtil;
import com.yunshare.core.engine.utils.NodeIdUtil;
import com.yunshare.core.enums.NodeType;
import com.yunshare.modules.dto.bpm.NodeConfig;
import org.assertj.core.util.Lists;
import org.flowable.bpmn.model.BpmnModel;
import org.flowable.bpmn.model.FlowNode;
import org.flowable.bpmn.model.SequenceFlow;
import org.flowable.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>上一节点处理人</p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/30 下午1:20
 */
@Component
public class PrevHandler extends AbstractAssignee implements AssigneeHandler {

    @Override
    public List<String> userList(NodeConfig node, DelegateExecution execution, NodeConfig all) {
       /* String currentActivityId = execution.getCurrentActivityId();
        BpmnModel bpmnModel = ProcessCache.getCache().getBpmModel(execution.getProcessDefinitionId());
        FlowNode flowNode = (FlowNode) bpmnModel.getFlowElement(currentActivityId);
        SequenceFlow sequenceFlow = flowNode.getIncomingFlows().get(0);
        String prevNodeId = NodeIdUtil.removePrefix(sequenceFlow.getSourceRef());
        NodeConfig prevNode = BpmnUtil.getCurrNode(all, prevNodeId);
        //判断是否符合查找条件,遇到上一节点是网关是继续往上一节点查找
        boolean bool = prevNode != null && (NodeType.ROUTER == prevNode.getNodeType() || NodeType.PARALLEL == prevNode.getNodeType());
        if (bool) {
            flowNode = (FlowNode) bpmnModel.getFlowElement(sequenceFlow.getSourceRef());
            prevNode = prevNode(flowNode, bpmnModel, all);
        }
        assert prevNode != null;
        //如果上一个节点是办理，从流程变量中获取用户ID
        if (node.getNodeType() == NodeType.DEAL_TASK) {
            String nodeId = ProcessConstant.USER_TASK_ID + prevNodeId + ProcessConstant.ASSIGNEE_LIST;
            List<String> userIds = (List<String>) execution.getVariable(nodeId);
            return userIds == null ? new ArrayList<>(10) : userIds;
        }
        return super.userList(prevNode, execution, null);*/
        return Lists.emptyList();
    }

    /**
     * <p>获取上一节点为任务</p>
     *
     * @return {@link NodeConfig}
     * @author lzx@yuyuda.com
     * @since 2023/7/14 15:16
     */
    private NodeConfig prevNode(FlowNode flowNode, BpmnModel bpmnModel, NodeConfig all) {
        SequenceFlow sequenceFlow = flowNode.getIncomingFlows().get(0);
        String prevNodeId = NodeIdUtil.removePrefix(sequenceFlow.getSourceRef());
        NodeConfig prevNode = BpmnUtil.getCurrNode(all, prevNodeId);
        //判断是否符合查找条件,遇到上一节点是网关是继续往上一节点查找
        boolean bool = prevNode != null && (NodeType.ROUTER == prevNode.getNodeType() || NodeType.PARALLEL == prevNode.getNodeType());
        if (bool) {
            flowNode = (FlowNode) bpmnModel.getFlowElement(sequenceFlow.getSourceRef());
            prevNode = prevNode(flowNode, bpmnModel, all);
        }
        return prevNode;
    }
}
