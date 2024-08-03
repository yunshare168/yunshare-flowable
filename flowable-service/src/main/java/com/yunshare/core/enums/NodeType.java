package com.yunshare.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>流程节点类型</p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/19 下午2:15
 */
@Getter
@AllArgsConstructor
public enum NodeType {
	// 根节点[发起人节点]
	ROOT("ROOT", "rootHandler"),
	// 审批节点
	USER_TASK("USER_TASK", "taskHandler"),
	// 办理节点
	DEAL_TASK("DEAL_TASK", "dealTaskHandler"),
	// 抄送节点
	CC("CC", "ccHandler"),
	// 排他网关节点
	ROUTER("ROUTER", "routerHandler"),
	// 并行网关节点
	PARALLEL("PARALLEL", "parallelHandler");

	private final String nodeType;
	private final String beanId;
}
