package com.yunshare.core.enums;

/**
 * 评论类型
 *
 * @author lzx@yuyuda.com
 * @since 2023/2/10 10:06
 */
public enum CommentTypeEnum {

	/**
	 * 评论类型
	 */
	OPINION("opinion", "处理意见"),
	COMMENT("comment", "评论"),

	;

	private final String type;
	private final String desc;

	CommentTypeEnum(String type, String desc) {
		this.type = type;
		this.desc = desc;
	}

	public String getType() {
		return type;
	}

	public String getDesc() {
		return desc;
	}
}
