package com.yunshare.core.engine.comparison.functions.extension;

import com.yunshare.core.engine.comparison.functions.IFunc;
import com.yunshare.core.tool.utils.Func;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 默认执行
 *
 * @author lzx@yuyuda.com
 * @since 2023/4/6 16:06
 */
public class DefaultExtension implements IFunc {

	@Override
	public boolean eq(Object leftValue, String... rightValue) {
		return Objects.equals(Func.toStr(leftValue), rightValue[0]);
	}

	@Override
	public boolean gt(Object leftValue, String... rightValue) {
		return Func.toStr(leftValue).compareTo(rightValue[0]) > 0;
	}

	@Override
	public boolean ge(Object leftValue, String... rightValue) {
		return Func.toStr(leftValue).compareTo(rightValue[0]) >= 0;
	}

	@Override
	public boolean lt(Object leftValue, String... rightValue) {
		return Func.toStr(leftValue).compareTo(rightValue[0]) < 0;
	}

	@Override
	public boolean le(Object leftValue, String... rightValue) {
		return Func.toStr(leftValue).compareTo(rightValue[0]) <= 0;
	}

	@Override
	public boolean in(Object leftValue, String... rightValue) {
		if (leftValue instanceof String) {
			return Arrays.asList(rightValue).contains(Func.toStr(leftValue));
		}
		if (leftValue instanceof List) {
			for (Object o : (List<?>) leftValue) {
				if (Arrays.asList(rightValue).contains(Func.toStr(o))) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean ne(Object leftValue, String... rightValue) {
		return !Objects.equals(Func.toStr(leftValue), rightValue[0]);
	}

	@Override
	public boolean between(Object leftValue, String... rightValue) {
		int result1 = Func.toStr(leftValue).compareTo(rightValue[0]);
		int result2 = Func.toStr(leftValue).compareTo(rightValue[1]);
		return result1 > 0 && result2 < 0;
	}
}
