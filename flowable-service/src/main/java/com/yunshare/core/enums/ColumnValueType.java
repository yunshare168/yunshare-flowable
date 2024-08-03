package com.yunshare.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>表单值的类型</p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/2/10 上午11:50
 */
@Getter
@AllArgsConstructor
public enum ColumnValueType {
	// STRING字符串 NUMBER数字 DATE日期 DATE_RANGE日期范围
	STRING("STRING"),
	NUMBER("NUMBER"),
	DATE("DATE"),
	DATE_RANGE("DATE_RANGE");

	private final String type;
}
