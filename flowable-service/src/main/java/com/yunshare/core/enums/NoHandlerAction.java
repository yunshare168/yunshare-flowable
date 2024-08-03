package com.yunshare.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>审批人为空时</p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/19 下午6:26
 */
@Getter
@AllArgsConstructor
public enum NoHandlerAction {
	/**
	 * 默认值，有操作人
	 */
	SOMEONE("SOMEONE", ""),
	/**
	 * 不允许创建，驳回
	 */
	NO_CREATE("NO_CREATE", "noCreateHandler"),
	/**
	 * 自动通过
	 */
	AUTO("AUTO", "autoHandler"),
	/**
	 * 转交管理员
	 */
	TRANSFER_ADMIN("TRANSFER_ADMIN", "transferAdminHandler");
	private final String type;
	private final String beanId;
}
