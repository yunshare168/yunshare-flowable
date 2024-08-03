package com.yunshare.modules.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 模板类型
 * </p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/12
 */
@Data
public class YunshareTemplateTypeShortVO implements Serializable {
	private static final long serialVersionUID = 838463315481283481L;

	/**
	 * id
	 */
	@ApiModelProperty("类型id")
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;

	/**
	 * 类型名称
	 */
	@ApiModelProperty("类型名称")
	private String title;
}
