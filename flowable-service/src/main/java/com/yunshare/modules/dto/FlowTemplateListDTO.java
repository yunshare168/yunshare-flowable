package com.yunshare.modules.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 模版列表
 * </p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/10
 */
@Data
public class FlowTemplateListDTO implements Serializable {

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
	 * 企业ID: 默认拉平台 传值企业ID拉企业端
	 */
	@ApiModelProperty("企业ID: 默认拉平台 传值企业ID拉企业端")
	private Long corpId;

	@ApiModelProperty("是否来自平台: 1-是,0-否")
	private Integer fromPlatform;
}
