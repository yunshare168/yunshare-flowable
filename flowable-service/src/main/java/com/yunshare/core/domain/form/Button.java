package com.yunshare.core.domain.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 按钮
 *
 * @author lzx@yuyuda.com
 * @since 2022/9/30 14:31
 */
@Data
public class Button implements Serializable {

	@ApiModelProperty("按钮名字")
	private String name = "";
	@ApiModelProperty("按钮标识")
	private String alias = "";
	@ApiModelProperty("按钮提交前置js脚本")
	private String beforeScript = "";
	@ApiModelProperty("按钮提交后置js脚本")
	private String afterScript = "";
	@ApiModelProperty("按钮后台权限 groovy脚本")
	private String groovyScript = "";
	@ApiModelProperty("按钮对应控制器后端处理器更多配置信息页")
	private String configPage = "";
}
