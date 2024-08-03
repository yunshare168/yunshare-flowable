package com.yunshare.core.tool.beans;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * copy key
 *
 * @author lzx@yuyuda.com
 */
@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class BeanCopierKey {
	private final Class<?> source;
	private final Class<?> target;
	private final boolean useConverter;
	private final boolean nonNull;
}
