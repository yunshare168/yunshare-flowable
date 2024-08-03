package com.yunshare.modules.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author lzx@yuyuda.com
 * @since 2022/9/28 14:00
 */
@Data
public class BpmModelDTO implements Serializable {
	@ApiModelProperty(value = "模型ID")
	private String id;
	@ApiModelProperty("版本号")
	private Integer version;
	@ApiModelProperty(value = "模型名称", required = true)
	@NotNull(message = "模型名称不能为空")
	private String name;
	@ApiModelProperty(value = "模型分类", required = true)
	@NotNull(message = "分类不能为空")
	private String category;
	@ApiModelProperty(value = "模型Key", required = true)
	@NotNull(message = "模型key不能为空")
	private String modelKey;
	@ApiModelProperty(value = "描述")
	private String description;
	@ApiModelProperty(value = "模型设计xml")
	private String modelEditorXml;
}
