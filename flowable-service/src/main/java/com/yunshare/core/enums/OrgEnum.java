package com.yunshare.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>组织类型</p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/19 下午6:05
 */
@Getter
@AllArgsConstructor
public enum OrgEnum {
	// 人员类型
	USER("USER" ),
	ROLE("ROLE"),
	DEPT("DEPT");

	private final String type;
}
