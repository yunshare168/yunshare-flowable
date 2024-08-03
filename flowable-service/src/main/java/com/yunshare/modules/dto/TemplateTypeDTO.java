package com.yunshare.modules.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * <p>
 * 工单模板类型
 * </p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/9
 */
@Data
public class TemplateTypeDTO implements Serializable {

	private static final long serialVersionUID = 838463315481283406L;

	/**
	 * id
	 */
	@ApiModelProperty("id,编辑必传,创建不传")
	private Long id;

	/**
	 * 类型名称
	 */
	@ApiModelProperty("类型名称")
	@NotBlank(message = "类型名称不能为空")
	private String title;

	/**
	 * 排序
	 */
	@ApiModelProperty("排序:数字越大越靠前")
	@Min(value = 0, message = "排序最小值是0")
	@Max(value = 255, message = "排序最大值是255")
	private Integer sort;
}
