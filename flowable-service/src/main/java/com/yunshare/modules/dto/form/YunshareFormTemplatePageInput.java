package com.yunshare.modules.dto.form;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * <p>表单分页入参对象</p>
 *
 * @author lzx@yuyuda.com
 * @version 1.0
 * @since 2023/1/11 14:08
 */
@Data
@ApiModel(value = "yunshareFormTemplatePageInput",description = "表单分页入参对象")
public class YunshareFormTemplatePageInput implements Serializable {

	/**
	 * 企业ID
	 */
	@ApiModelProperty(value = "关键词搜索：表单名称")
	private String keyword;

	/**
	 * 状态，1-正常，2-禁用
	 */
	@ApiModelProperty(value = "状态，1-正常，2-禁用")
	@Max(value = 2,message = "表单状态：必须是1或2")
	@Min(value = 1,message = "表单状态：必须是1或2")
	private Integer templateStatus;

	/**
	 * 企业ID
	 */
	@ApiModelProperty(value = "企业ID,不传表示平台")
	@JsonSerialize(using = ToStringSerializer.class)
	private Long corpId;

	/**
	 * 表单分类，数据字典
	 */
	@ApiModelProperty(value = "表单分类，数据字典", required = true)
	@Length(max = 20,message = "表单分类长度不能超过20个字符")
	private String templateType;

}
