package com.yunshare.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>逻辑符号</p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/18 上午10:06
 */
@Getter
@AllArgsConstructor
public enum LogicalSymbol {
	/**
	 * 与
	 */
	AND("AND", "&&"),
	/**
	 * 会签
	 */
	OR("OR", "||");

	private final String key;
	private final String value;
}
