package com.yunshare.core.engine.comparison.functions.extension;

import com.yunshare.core.tool.utils.Func;

import java.math.BigDecimal;

/**
 * 数字
 *
 * @author lzx@yuyuda.com
 * @since 2023/4/6 16:09
 */
public class NumberExtension extends DefaultExtension {

    @Override
    public boolean eq(Object leftValue, String... rightValue) {
        return parseNumber(leftValue).compareTo(new BigDecimal(rightValue[0])) == 0;
    }

    @Override
    public boolean gt(Object leftValue, String... rightValue) {
        return parseNumber(leftValue).compareTo(new BigDecimal(rightValue[0])) > 0;
    }

    @Override
    public boolean ge(Object leftValue, String... rightValue) {
        return parseNumber(leftValue).compareTo(new BigDecimal(rightValue[0])) >= 0;
    }

    @Override
    public boolean lt(Object leftValue, String... rightValue) {
        return parseNumber(leftValue).compareTo(new BigDecimal(rightValue[0])) < 0;
    }

    @Override
    public boolean le(Object leftValue, String... rightValue) {
        return parseNumber(leftValue).compareTo(new BigDecimal(rightValue[0])) <= 0;
    }

    @Override
    public boolean ne(Object leftValue, String... rightValue) {
        return parseNumber(leftValue).compareTo(new BigDecimal(rightValue[0])) != 0;
    }

    @Override
    public boolean between(Object leftValue, String... rightValue) {
        boolean result1 = parseNumber(leftValue).compareTo(new BigDecimal(rightValue[0])) > 0;
        boolean result2 = parseNumber(leftValue).compareTo(new BigDecimal(rightValue[1])) < 0;
        return result1 && result2;
    }


    /**
     * <p>转换成数字</p>
     *
     * @param leftValue 值
     * @return {@link Number}
     * @author lzx@yuyuda.com
     * @since 2023/7/14 10:04
     */
    public BigDecimal parseNumber(Object leftValue) {
        return new BigDecimal(Func.toStr(leftValue, "0"));
    }

}
