package com.yunshare.modules.dto.data;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 表单记录创建实体类
 *
 * @author lzx@yuyuda.com
 * @since 2022-09-28 11:51:56
 */
@Data
@ApiModel(value = "FormDataCreateDTO", description = "公共服务-表单记录创建实体类")
public class FormDataCreateDTO implements Serializable {

	private static final long serialVersionUID = 782854527228281471L;

	@ApiModelProperty(value = "企业ID")
	@JsonSerialize(using = ToStringSerializer.class)
	@NotNull(message = "企业ID不能为空")
	private Long corpId;

	@ApiModelProperty(value = "表单ID")
	@JsonSerialize(using = ToStringSerializer.class)
	@NotNull(message = "表单ID不能为空")
	private Long formId;

	@ApiModelProperty(value = "表单业务号")
	@NotBlank(message = "表单业务号不能为空")
	@Length(max = 64, message = "表单业务号最大支持64个字")
	private String processInstanceId;

	@ApiModelProperty(value = "表单数据")
	@NotBlank(message = "表单数据不能为空")
	private String formData;

}
