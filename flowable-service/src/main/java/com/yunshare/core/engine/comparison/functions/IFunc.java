package com.yunshare.core.engine.comparison.functions;

/**
 * 执行函数
 *
 * @author lzx@yuyuda.com
 * @since 2023/4/6 15:55
 */
public interface IFunc {

	/**
	 * <p>左边的值等于右边的值</p>
	 *
	 * @param leftValue  左边值
	 * @param rightValue 右边值
	 * @return {@link boolean}
	 * @author lzx@yuyuda.com
	 * @since 2023/4/6 15:58
	 */
	boolean eq(Object leftValue, String... rightValue);

	/**
	 * <p>大于:左边的值大于右边的值</p>
	 *
	 * @param leftValue  左边值
	 * @param rightValue 右边值
	 * @return {@link boolean}
	 * @author lzx@yuyuda.com
	 * @since 2023/4/6 16:00
	 */
	boolean gt(Object leftValue, String... rightValue);

	/**
	 * <p>大于等于:左边的值大于等于右边的值</p>
	 *
	 * @param leftValue  左边值
	 * @param rightValue 右边值
	 * @return {@link boolean}
	 * @author lzx@yuyuda.com
	 * @since 2023/4/6 16:00
	 */
	boolean ge(Object leftValue, String... rightValue);

	/**
	 * <p>小于:左边的值小于右边的值</p>
	 *
	 * @param leftValue  左边值
	 * @param rightValue 右边值
	 * @return {@link boolean}
	 * @author lzx@yuyuda.com
	 * @since 2023/4/6 16:00
	 */
	boolean lt(Object leftValue, String... rightValue);

	/**
	 * <p>小于等于<=:左边的值小于等于右边的值</p>
	 *
	 * @param leftValue  左边值
	 * @param rightValue 右边值
	 * @return {@link boolean}
	 * @author lzx@yuyuda.com
	 * @since 2023/4/6 16:00
	 */
	boolean le(Object leftValue, String... rightValue);

	/**
	 * <p>存在：左边的值存在右边值</p>
	 *
	 * @param leftValue  左边值
	 * @param rightValue 右边值
	 * @return {@link boolean}
	 * @author lzx@yuyuda.com
	 * @since 2023/4/6 16:00
	 */
	boolean in(Object leftValue, String... rightValue);

	/**
	 * <p>不等于：左边的值不在右边条件中</p>
	 *
	 * @param leftValue  左边值
	 * @param rightValue 右边值
	 * @return {@link boolean}
	 * @author lzx@yuyuda.com
	 * @since 2023/4/6 16:00
	 */
	boolean ne(Object leftValue, String... rightValue);

	/**
	 * <p>区间不包含收尾</p>
	 *
	 * @param leftValue  左边值
	 * @param rightValue 右边值
	 * @return {@link boolean}
	 * @author lzx@yuyuda.com
	 * @since 2023/4/6 16:00
	 */
	boolean between(Object leftValue, String... rightValue);
}
