package com.yunshare.core.enums;

/**
 * <p>多人审批时采用的审批方式</p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/18 上午10:06
 */
public enum ExamineModeEnum {
	/**
	 * 依次审批
	 */
	SEQUENTIAL("SEQUENTIAL"),
	/**
	 * 会签
	 */
	AND_SIGN("AND_SIGN"),
	/**
	 * 或签
	 */
	OR_SIGN("OR_SIGN");

	private String value;

	ExamineModeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
