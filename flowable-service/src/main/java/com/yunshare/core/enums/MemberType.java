package com.yunshare.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>审批成员类型</p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/19 下午6:05
 */
@Getter
@AllArgsConstructor
public enum MemberType {
	// 审批人设置 START_NODE_ALL所有人 ORG按组织 SELF_CHOICE发起人自选 SELF发起人自己 PREV上一节点操作人
	START_NODE_ALL("START_NODE_ALL", "startNodeAllHandler"),
	ORG("ORG", "orgHandler"),
	SELF_CHOICE("SELF_CHOICE", "selfChoiceHandler"),
	SELF("SELF", "selfHandler"),
	PREV("PREV", "prevHandler");

	private final String type;
	private final String beanId;
}
