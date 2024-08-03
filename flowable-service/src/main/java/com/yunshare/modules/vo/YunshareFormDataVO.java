package com.yunshare.modules.vo;

import com.yunshare.modules.entity.YunshareFormData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* 公共服务-表单记录值视图类
*
* @author lzx@yuyuda.com
* @since 2022-09-28 11:51:58
*/
@Data
@EqualsAndHashCode(callSuper = true)
public class YunshareFormDataVO extends YunshareFormData {

	/**
	 * 表单标题
	 */
	@ApiModelProperty(value = "表单标题")
	private String formTitle;
	/**
	 * 表单值
	 */
	@ApiModelProperty(value = "表单值")
	private String formHtml;

	/**
	 * 表单类型
	 */
	@ApiModelProperty(value = "表单类型")
	private String formType;

}

