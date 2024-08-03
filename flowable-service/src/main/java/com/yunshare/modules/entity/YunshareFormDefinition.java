package com.yunshare.modules.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>流程表单模板关联表</p>
 *
 * @author lzx@yuyuda.com
 * @version 1.0
 * @since 2023/3/9 18:25
 */
@Data
@ApiModel(value = "yunshareFormDefinition",description = "流程表单模板关联表")
@TableName(value = "yunshare_form_definition")
public class YunshareFormDefinition implements Serializable {

	/**
	 * 主键id
	 **/
	@JsonSerialize(using = ToStringSerializer.class)
	@TableId(value = "id",type = IdType.ASSIGN_ID)
	@ApiModelProperty("主键id")
	private Long id;

	/**
	 * 表单模板id
	 */
	@ApiModelProperty("表单模板id")
	private Long formId;

	/**
	 * 流程模板ID
	 */
	@ApiModelProperty("流程模板ID")
	private Long flowTemplateId;

	/**
	 * 流程定义ID
	 */
	@ApiModelProperty("流程定义ID")
	private String processDefinitionId;

	/**
	 * 流程定义key
	 */
	@ApiModelProperty("流程定义key")
	private String processDefinitionKey;

	/**
	 * 表单分类，数据字典
	 */
	@ApiModelProperty("表单分类，数据字典")
	private String formType;

	/**
	 * 表单标题
	 */
	@ApiModelProperty("表单标题")
	private String formTitle;

	/**
	 * 表单配置
	 */
	@ApiModelProperty("表单配置")
	private String formJson;

	/**
	 * 是否开启评论: 1开启 0未开启
	 */
	@ApiModelProperty("是否开启评论: 1开启 0未开启")
	private Integer isOpenComment;
	/**
	 * 是否开启满意度评价: 1开启 0未开启
	 */
	@ApiModelProperty("是否开启满意度评价: 1开启 0未开启")
	private Integer isOpenEvaluate;
}
