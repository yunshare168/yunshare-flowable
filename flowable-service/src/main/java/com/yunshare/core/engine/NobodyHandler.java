package com.yunshare.core.engine;

import com.yunshare.modules.dto.bpm.NodeConfig;

import java.util.Map;

/**
 * <p>没有审批人处理</p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/30 下午1:48
 */
public interface NobodyHandler {
	/**
	 * <p>没有审批人节点处理</p>
	 * @param node 节点
	 * @return java.util.Map<java.lang.String,java.lang.Object>
	 * @author lzx@yuyuda.com
	 * @since 2023/1/30 下午1:52
	 */
	Map<String, Object> handle(NodeConfig node);
}
