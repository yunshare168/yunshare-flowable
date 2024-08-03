package com.yunshare.core.engine.comparison.functions.extension;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 字符串
 *
 * @author lzx@yuyuda.com
 * @since 2023/4/6 16:09
 */
public class StringExtension extends DefaultExtension {

	@Override
	public boolean eq(Object leftValue, String... rightValue) {
		if (leftValue instanceof Collection) {
			//判断list是否相等
			List<String> leftValues = ((Collection<?>) leftValue).stream().map(String::valueOf).collect(Collectors.toList());
			List<String> rightValues = Arrays.asList(rightValue);
			return leftValues.size() == rightValues.size() && leftValues.containsAll(rightValues);
		}
		return super.eq(leftValue, rightValue);
	}
}
