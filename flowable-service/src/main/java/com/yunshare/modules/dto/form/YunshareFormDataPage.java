package com.yunshare.modules.dto.form;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 公共服务-表单记录值分页
 *
 * @author lzx@yuyuda.com
 * @since 2022-09-28 11:51:56
 */
@Data
@ApiModel(value = "yunshareFormDataPage", description = "公共服务-表单记录值分页")
public class YunshareFormDataPage implements Serializable {

	private static final long serialVersionUID = -1L;

	/**
	 * 企业ID
	 */
	@ApiModelProperty(value = "企业ID")
	@JsonSerialize(using = ToStringSerializer.class)
	private Long corpId;
	/**
	 * 表单ID
	 */
	@ApiModelProperty(value = "表单ID")
	@JsonSerialize(using = ToStringSerializer.class)
	private Long templateId;
	/**
	 * 表单业务号
	 */
	@ApiModelProperty(value = "表单业务号")
	private String templateNo;
	/**
	 * 表单分类，数据字典
	 */
	@ApiModelProperty(value = "表单分类，数据字典")
	private String templateType;
}
