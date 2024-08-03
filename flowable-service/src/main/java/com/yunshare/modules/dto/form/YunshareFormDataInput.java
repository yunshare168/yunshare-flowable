package com.yunshare.modules.dto.form;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 公共服务-表单记录值实体类
 *
 * @author lzx@yuyuda.com
 * @since 2022-09-28 11:51:56
 */
@Data
@TableName("yunshare_form_data")
@ApiModel(value = "yunshareFormDataInput", description = "公共服务-表单记录值")
public class YunshareFormDataInput implements Serializable {

	private static final long serialVersionUID = 782854527228281471L;

	@ApiModelProperty("主键id,新增不传、编辑必传")
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;

	/**
	 * 企业ID
	 */
	@ApiModelProperty(value = "企业ID", hidden = true)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long corpId;

	/**
	 * 表单ID
	 */
	@ApiModelProperty(value = "表单ID,新增必传,编辑不传")
	@JsonSerialize(using = ToStringSerializer.class)
	private Long templateId;

	/**
	 * 表单业务号
	 */
	@ApiModelProperty(value = "表单业务号")
	@NotBlank(message = "表单业务号不能为空")
	private String templateNo;

	/**
	 * 表单数据
	 */
	@ApiModelProperty(value = "表单数据", required = true)
	@NotBlank(message = "表单数据不能为空")
	private String templateData;

}
