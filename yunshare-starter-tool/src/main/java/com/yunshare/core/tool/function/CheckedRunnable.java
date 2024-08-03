

package com.yunshare.core.tool.function;

/**
 * 受检的 runnable
 *
 * @author lzx@yuyuda.com
 */
@FunctionalInterface
public interface CheckedRunnable {

	/**
	 * Run this runnable.
	 *
	 * @throws Throwable CheckedException
	 */
	void run() throws Throwable;

}
