package com.yunshare.core.engine.utils;

import com.yunshare.core.tool.utils.DateUtil;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

/**
 * <p>序列号生成 工具类</p>
 *
 * @author lzx@yuyuda.com
 * @since 2022/8/23 16:40
 */
public class SeqKit {

	private static final AtomicLong APPLY_SEQ = new AtomicLong(0L);


	/**
	 * 申请单号
	 */
	public static String getApplySn() {
		return String.format("%s%04d",  LocalDateTime.now().format(DateUtil.DATETIME_MINI_FORMATTER), (int) APPLY_SEQ.getAndIncrement() % 10000);
	}

}

