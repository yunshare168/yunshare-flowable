package com.yunshare.core.engine.comparison.functions.extension;

import com.yunshare.core.tool.utils.DateUtil;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

/**
 * 时间区间
 *
 * @author lzx@yuyuda.com
 * @since 2023/4/6 16:09
 */
public class DateRangeExtension extends DefaultExtension {

	@Override
	public boolean eq(Object leftValue, String... rightValue) {
		return getDays(leftValue) == Integer.parseInt(rightValue[0]);
	}

	@Override
	public boolean gt(Object leftValue, String... rightValue) {
		return getDays(leftValue) > Integer.parseInt(rightValue[0]);
	}

	@Override
	public boolean ge(Object leftValue, String... rightValue) {
		return getDays(leftValue) >= Integer.parseInt(rightValue[0]);
	}

	@Override
	public boolean lt(Object leftValue, String... rightValue) {
		return getDays(leftValue) < Integer.parseInt(rightValue[0]);
	}

	@Override
	public boolean le(Object leftValue, String... rightValue) {
		return getDays(leftValue) <= Integer.parseInt(rightValue[0]);
	}

	@Override
	public boolean ne(Object leftValue, String... rightValue) {
		return getDays(leftValue) != Integer.parseInt(rightValue[0]);
	}

	@Override
	public boolean between(Object leftValue, String... rightValue) {
		int days = getDays(leftValue);
		return days>Integer.parseInt(rightValue[0])   && days < Integer.parseInt(rightValue[1]);
	}

	/**
	 * <p>获取两个日期的相差天数</p>
	 *
	 * @param leftValue 左边参数
	 * @return {@link int}
	 * @author lzx@yuyuda.com
	 * @since 2023/4/6 17:35
	 */
	private int getDays(Object leftValue) {
		if (!(leftValue instanceof Collection)) {
			return 0;
		}
		List<String> data = (List<String>) leftValue;
		String startDateStr = data.get(0);
		String endDateStr = data.get(1);
		BigDecimal days = DateUtil.betweenDays(startDateStr, endDateStr);
		return days.intValue();
	}

}
