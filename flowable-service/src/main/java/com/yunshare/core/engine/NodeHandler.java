package com.yunshare.core.engine;

import com.yunshare.core.engine.creator.NodeInput;
import org.flowable.bpmn.model.Gateway;
import org.flowable.bpmn.model.SequenceFlow;

/**
 * <p>流程json转bpmn对象处理器</p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/19 下午2:10
 */
public interface NodeHandler {

	/**
	 * <p>创建动作</p>
	 *
	 * @param input 参数
	 * @return java.lang.String
	 * @author lzx@yuyuda.com
	 * @since 2023/1/19 下午2:46
	 */
	String node(NodeInput input);

	/**
	 * <p>创建节点连线</p>
	 *
	 * @param input 参数
	 * @return org.flowable.bpmn.model.SequenceFlow
	 * @author lzx@yuyuda.com
	 * @since 2023/1/19 下午7:17
	 */
	SequenceFlow connect(NodeInput input);

	/**
	 * <p>绘制网关</p>
	 *
	 * @param gateway   网关
	 * @param input     参数
	 * @param gatewayId 网关ID
	 * @author lzx@yuyuda.com
	 * @since 2023/1/28 下午11:05
	 */
	void drawGateway(Gateway gateway, NodeInput input, String gatewayId);

	/**
	 * <p>获取节点前缀</p>
	 *
	 * @return {@link String}
	 * @author lzx@yuyuda.com
	 * @since 2023/3/28 12:32
	 */
	String getNodeIdPrefix();
}
