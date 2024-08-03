package com.yunshare.modules.dto.form;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>表单禁用与恢复入参对象</p>
 *
 * @author lzx@yuyuda.com
 * @version 1.0
 * @since 2023/1/12 13:27
 */
@Data
@ApiModel(value = "yunshareFormTemplateModifyStatus",description = "表单禁用与恢复入参对象")
public class YunshareFormTemplateModifyStatus implements Serializable {

	@ApiModelProperty("表单id")
	@JsonSerialize(using = ToStringSerializer.class)
	@NotNull(message = "表单id不能为空")
	private Long id;

	/**
	 * 状态，1-正常，2-禁用
	 */
	@ApiModelProperty(value = "状态，1-正常，2-禁用")
	@NotNull(message = "状态不能为空")
	@Max(value = 2,message = "表单状态：必须是1或2")
	@Min(value = 1,message = "表单状态：必须是1或2")
	private Integer templateStatus;

}
