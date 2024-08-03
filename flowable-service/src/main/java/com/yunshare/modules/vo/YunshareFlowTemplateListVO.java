package com.yunshare.modules.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 流程模板详情
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/10
 */
@Data
@ApiModel(value = "yunshareFlowTemplateListVO对象", description = "流程模板")
public class YunshareFlowTemplateListVO implements Serializable {

	private static final long serialVersionUID = 838463305481283481L;

	/**
	 * id
	 */
	@ApiModelProperty("id")
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;

	/**
	 * 模板名称
	 */
	@ApiModelProperty("模板名称")
	private String title;

	/**
	 * 模板图标
	 */
	@ApiModelProperty("模板图标")
	private String image;

	/**
	 * 描述
	 */
	@ApiModelProperty("描述")
	private String remark;

	/**
	 * 模板类型ID
	 */
	@ApiModelProperty("模板类型ID")
	@JsonSerialize(using = ToStringSerializer.class)
	private Long typeId;

	/**
	 * 模板类型名称
	 */
	@ApiModelProperty("模板类型名称")
	private String typeTitle;

	/**
	 * 模板状态: 1上线 2下线
	 */
	@ApiModelProperty("模板状态: 1上线 2下线")
	private Integer templateStatus;

	/**
	 * 创建时间
	 */
	@ApiModelProperty("创建时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/**
	 * 创建人ID
	 */
	@ApiModelProperty("创建人ID")
	@JsonSerialize(using = ToStringSerializer.class)
	private Long createUser;

	/**
	 * 创建用户信息
	 */
	@ApiModelProperty(value = "创建用户信息")
	private String createUserName;

}

