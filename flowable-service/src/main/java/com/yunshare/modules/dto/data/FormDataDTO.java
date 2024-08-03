package com.yunshare.modules.dto.data;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 表单记录值视图类
 *
 * @author lzx@yuyuda.com
 * @since 2022-09-28 11:51:58
 */
@Data
public class FormDataDTO implements Serializable {

	@ApiModelProperty(value = "表单ID")
	@JsonSerialize(using = ToStringSerializer.class)
	private Long formId;

	@ApiModelProperty(value = "表单类型(数据字典)")
	private String formType;

	@ApiModelProperty(value = "表单数据")
	private String formData;

	@ApiModelProperty(value = "表单标题")
	private String formTitle;

	@ApiModelProperty(value = "表单值")
	private String formHtml;

}

