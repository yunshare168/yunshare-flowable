package com.yunshare.core.engine.creator;

import com.yunshare.core.constant.ProcessConstant;
import com.yunshare.core.engine.NodeHandler;
import com.yunshare.modules.dto.bpm.NodeConfig;
import org.flowable.bpmn.model.ParallelGateway;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * <p>流程并行网关生成器</p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/19 下午2:33
 */
@Component
public class ParallelHandler extends AbstractNodeHandler implements NodeHandler {
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
		String parallelGatewayId = this.getNodeIdPrefix().concat(String.valueOf(nodeConfig.getNodeId()));
		super.drawGateway(new ParallelGateway(), input, parallelGatewayId);
		return parallelGatewayId;
	}

	@Override
	public String getNodeIdPrefix() {
		return ProcessConstant.PARALLEL_GATEWAY_ID;
	}
}
