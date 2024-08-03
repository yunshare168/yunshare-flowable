package com.yunshare.modules.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 *	流程模板
 * </p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/10
 */
@Data
public class FlowTemplatePageDTO implements Serializable {

	private static final long serialVersionUID = 838513315481283406L;

	/**
	 * 模板名称
	 */
	@ApiModelProperty("模板名称")
	private String title;

	/**
	 * 模板类型ID
	 */
	@ApiModelProperty("模板类型ID")
	private Long typeId;

	/**
	 * 模板状态: 1上线 2下线
	 */
	@ApiModelProperty("模板状态: 1上线 2下线")
	private Integer templateStatus;

	/**
	 * 创建开始时间
	 */
	@ApiModelProperty("创建开始时间")
	private String startTime;

	/**
	 * 创建结束时间
	 */
	@ApiModelProperty("创建结束时间")
	private String endTime;

	/**
	 * 企业ID: 平台0 企业端为企业ID
	 */
	@ApiModelProperty(value = "企业ID: 平台0 企业端为企业ID", hidden = true)
	private Long corpId;

	@ApiModelProperty(value = "是否来自平台: 1-是,0-否", hidden = true)
	private Integer fromPlatform;
}
