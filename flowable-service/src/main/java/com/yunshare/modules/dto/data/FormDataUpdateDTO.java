package com.yunshare.modules.dto.data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 表单编辑实体类
 *
 * @author lzx@yuyuda.com
 * @since 2022-09-28 11:51:56
 */
@Data
@ApiModel(value = "FormDataUpdateDTO", description = "公共服务-表单编辑实体类")
public class FormDataUpdateDTO implements Serializable {

	private static final long serialVersionUID = -1L;

	@ApiModelProperty(value = "表单值ID")
	@NotNull(message = "表单值ID不能为空")
	private Long formDataId;

	@ApiModelProperty(value = "表单数据")
	@NotBlank(message = "表单数据不能为空")
	private String formData;

}
