package com.yunshare.modules.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yunshare.core.mp.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 公共服务-表单记录值实体类
 *
 * @author lzx@yuyuda.com
 * @since 2022-09-28 11:51:56
 */
@Data
@TableName("yunshare_form_data")
@ApiModel(value = "yunshareFormData对象", description = "表单记录值")
public class YunshareFormData extends BaseEntity {

	private static final long serialVersionUID = 782854527228281471L;

	/**
	 * 企业ID
	 */
	@ApiModelProperty(value = "企业ID")
	private Long corpId;

	/**
	 * 表单ID
	 */
	@ApiModelProperty(value = "表单ID")
	private String businessKey;
	/**
	 * 表单ID
	 */
	@ApiModelProperty(value = "流程实例ID")
	private String processInstanceId;
	/**
	 * 表单数据
	 */
	@ApiModelProperty(value = "表单数据")
	private String formData;


}
