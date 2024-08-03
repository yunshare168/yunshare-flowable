package com.yunshare.core.engine.creator;

import com.yunshare.core.constant.ProcessConstant;
import com.yunshare.core.engine.NodeHandler;
import com.yunshare.modules.dto.bpm.NodeConfig;
import org.flowable.bpmn.model.ExclusiveGateway;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * <p>流程排他网关生成器</p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/19 下午2:33
 */
@Component
public class RouterHandler extends AbstractNodeHandler implements NodeHandler {
	@Resource
	private NodeStrategyFactory nodeStrategyFactory;

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
		NodeConfig nodeConfig = input.getNodeConfig();
		String startId = this.getNodeIdPrefix().concat(String.valueOf(nodeConfig.getNodeId()));
		super.drawGateway(new ExclusiveGateway(), input, startId);
		return startId;
	}

	@Override
	public String getNodeIdPrefix() {
		return ProcessConstant.EXCLUSIVE_GATEWAY_ID;
	}
}
