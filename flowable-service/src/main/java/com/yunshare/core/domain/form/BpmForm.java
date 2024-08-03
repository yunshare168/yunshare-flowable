package com.yunshare.core.domain.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 表单数据
 *
 * @author lzx@yuyuda.com
 * @since 2022/9/30 14:24
 */
@Data
public class BpmForm implements Serializable {

	@ApiModelProperty("表单ID")
	private Long formId;
	@ApiModelProperty("表单名称描述")
	private String name;
	@ApiModelProperty("Inner 表单HTML 内容")
	private String formHtml;


}
