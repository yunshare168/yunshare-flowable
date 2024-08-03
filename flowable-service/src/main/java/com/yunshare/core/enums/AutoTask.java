package com.yunshare.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>任务是否自动</p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/31 下午4:29
 */
@Getter
@AllArgsConstructor
public enum AutoTask {
	/**
	 * 非自动，默认方式
	 */
	NOT_AUTO("NOT_AUTO"),
	/**
	 * 自动
	 */
	AUTO("AUTO");

	private String key;
}
