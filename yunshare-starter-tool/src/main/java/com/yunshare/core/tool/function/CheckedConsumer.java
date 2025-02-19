

package com.yunshare.core.tool.function;

import org.springframework.lang.Nullable;

/**
 * 受检的 Consumer
 *
 * @author lzx@yuyuda.com
 */
@FunctionalInterface
public interface CheckedConsumer<T> {

	/**
	 * Run the Consumer
	 *
	 * @param t T
	 * @throws Throwable UncheckedException
	 */
	@Nullable
	void accept(@Nullable T t) throws Throwable;

}
