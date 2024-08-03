package com.yunshare.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>比较计算类型</p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/2/10 下午5:57
 */
@Getter
@AllArgsConstructor
public enum CalSymbol {
	// EQ==, GT>, GE>=, LT<, LE<=, IN包含, B 0<x<2,AB 0<=x<2, BA 0<x<=2, ABA 0<=x<=2
	EQ("EQ", "eq"),
	GT("GT", "gt"),
	GE("GE", "ge"),
	LT("LT", "lt"),
	LE("LE", "le"),
	IN("IN", "in"),
	BETWEEN("BETWEEN", "between"),
	B("B", "b"),
	AB("AB", "ab"),
	BA("BA", "ba"),
	ABA("ABA", "aba");

	private final String key;
	private final String beanId;
}
