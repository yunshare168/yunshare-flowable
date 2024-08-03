package com.yunshare.core.enums;

/**
 * <p>
 * 消息通知状态
 * </p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/3/16
 */
public enum DealStatus {
	/**
	 * 状态类型
	 */
	HAVE_SEND(1, "已经发送"),
	RECEIVE_SUCCESS(2, "接收成功"),
	RECEIVE_FAILED(3, "接收失败");

	private final int type;
	private final String desc;

	DealStatus(int type, String desc) {
		this.type = type;
		this.desc = desc;
	}

	public Integer getType() {
		return type;
	}

	public String getDesc() {
		return desc;
	}
}
