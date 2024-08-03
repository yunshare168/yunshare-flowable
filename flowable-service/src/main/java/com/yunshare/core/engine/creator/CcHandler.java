package com.yunshare.core.engine.creator;

import com.yunshare.core.constant.ProcessConstant;
import com.yunshare.core.engine.NodeHandler;
import org.flowable.bpmn.model.ServiceTask;
import org.springframework.stereotype.Component;

/**
 * <p>流程节点抄送任务生成</p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/19 下午2:33
 */
@Component
public class CcHandler extends AbstractNodeHandler implements NodeHandler {

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
		ServiceTask serviceTask = new ServiceTask();
		serviceTask.setName(input.getNodeConfig().getNodeName());
		serviceTask.setId(this.getNodeIdPrefix().concat(input.getNodeConfig().getNodeId()));
		serviceTask.setImplementationType("class");
		serviceTask.setImplementation("com.yunshare.core.listener.CcListener");
		input.getProcess().addFlowElement(serviceTask);
		// 连线, 需要连线才连
		if (input.getNodeConfig()!=null&&Boolean.TRUE.equals(input.getNodeConfig().getIsNeedSequenceFlow())) {
			input.setTargetId(serviceTask.getId());
			input.getProcess().addFlowElement(super.connect(input));
		}
		return serviceTask.getId();
	}

	@Override
	public String getNodeIdPrefix() {
		return ProcessConstant.SERVICE_TASK_ID;
	}
}
