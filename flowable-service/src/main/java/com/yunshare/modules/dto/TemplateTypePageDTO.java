package com.yunshare.modules.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 *	工单模板类型
 * </p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/9
 */
@Data
public class TemplateTypePageDTO implements Serializable {

	private static final long serialVersionUID = 838463315481083406L;

	/**
	 * 类型名称
	 */
	@ApiModelProperty("类型名称")
	private String title;

	@ApiModelProperty("创建开始时间")
	private String startTime;

	@ApiModelProperty("创建结束时间")
	private String endTime;

}
