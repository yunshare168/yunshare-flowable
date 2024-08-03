package com.yunshare.core.tool.beans;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

/**
 * bean map key，提高性能
 *
 * @author lzx@yuyuda.com
 */
@EqualsAndHashCode
@AllArgsConstructor
public class BeanMapKey {
	private final Class type;
	private final int require;
}
