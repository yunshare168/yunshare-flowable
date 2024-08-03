

package com.yunshare.core.tool.function;

import org.springframework.lang.Nullable;

/**
 * 受检的 Supplier
 *
 * @author lzx@yuyuda.com
 */
@FunctionalInterface
public interface CheckedSupplier<T> {

	/**
	 * Run the Supplier
	 *
	 * @return T
	 * @throws Throwable CheckedException
	 */
	@Nullable
	T get() throws Throwable;

}
