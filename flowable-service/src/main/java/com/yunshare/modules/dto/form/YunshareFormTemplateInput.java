package com.yunshare.modules.dto.form;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 公共服务-表单实体
 *
 * @author lzx@yuyuda.com
 * @since 2022-09-28 11:18:09
 */
@Data
@TableName("yunshare_form")
@ApiModel(value = "yunshareFormTemplateInput", description = "公共服务-表单实体")
public class YunshareFormTemplateInput implements Serializable {

	private static final long serialVersionUID = 994064939630885237L;

	@ApiModelProperty("主键id,新增不传,编辑必传")
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;

	/**
	 * 企业ID
	 */
	@ApiModelProperty(value = "企业ID", hidden = true)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long corpId;
	/**
	 * 表单分类，数据字典
	 */
	@ApiModelProperty(value = "表单分类，数据字典", required = true)
	@NotBlank(message = "表单分类不能为空")
	@Length(max = 20,message = "表单分类长度不能超过20个字符")
	private String templateType;
	/**
	 * 表单标题
	 */
	@ApiModelProperty(value = "表单标题", required = true)
	@NotBlank(message = "表单标题不能为空")
	@Length(max = 100, min = 1, message = "表单标题必须在1-100个字之间")
	private String templateTitle;
	/**
	 * 表单值
	 */
	@ApiModelProperty(value = "表单值", required = true)
	@NotBlank(message = "表单值不能为空")
	private String templateHtml;

}
