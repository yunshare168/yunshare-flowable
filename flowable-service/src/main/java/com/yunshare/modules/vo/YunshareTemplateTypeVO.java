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
* 工单模板类型视图类
*
* @author lzx@yuyuda.com
* @since 2023/1/9
*/
@Data
@ApiModel(value = "yunshareTemplateTypeVO对象", description = "工单模板类型")
public class YunshareTemplateTypeVO implements Serializable {

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

	/**
	 * 排序
	 */
	@ApiModelProperty("排序:数字越大越靠前")
	private Integer sort;

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

