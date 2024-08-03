package com.yunshare.core.tool.api;

import java.io.Serializable;

/**
 * 业务代码接口
 *
 * @author lzx@yuyuda.com
 */
public interface IResultCode extends Serializable {

	/**
	 * <p>获取消息</p>
	 * @return  java.lang.String
	 * @author lzx@yuyuda.com
	 * @since 2024/8/2 下午1:08
	 */
	String getMessage();

	/**
	 * <p>获取状态码</p>
	 * @return  int
	 * @author lzx@yuyuda.com
	 * @since 2024/8/2 下午1:08
	 */
	int getCode();

}
