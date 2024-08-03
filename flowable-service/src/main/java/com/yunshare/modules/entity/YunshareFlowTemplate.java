package com.yunshare.modules.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yunshare.core.mp.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 工单模板实体类
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/10
 */
@Data
@TableName("yunshare_flow_template")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "yunshareFlowTemplate对象", description = "工单模板")
public class YunshareFlowTemplate extends BaseEntity {

	private static final long serialVersionUID = -72807224581234184L;

	/**
	 * 模板类型ID
	 */
	@ApiModelProperty("模板类型ID")
	private Long typeId;
	/**
	 * 模板名称
	 */
	@ApiModelProperty("模板名称")
	private String title;
	/**
	 * 模板图标
	 */
	@ApiModelProperty("模板图标")
	private String image;
	/**
	 * 模板描述
	 */
	@ApiModelProperty("模板描述")
	private String remark;
	/**
	 * 企业ID: 平台0 企业端为企业ID
	 */
	@ApiModelProperty("企业ID: 平台0 企业端为企业ID")
	private Long corpId;
	/**
	 * 表单ID
	 */
	@ApiModelProperty("表单ID")
	private Long formTemplateId;
	/**
	 * 模板状态: 1上线 2下线
	 */
	@ApiModelProperty("模板状态: 1上线 2下线")
	private Integer templateStatus;
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

	@ApiModelProperty("bpmn XML字符串")
	private String bpmnXml;

	@ApiModelProperty("流程节点json")
	private String nodeConfig;

	@ApiModelProperty("分类名称")
	@TableField(exist = false)
	private String typeTitle;

	@ApiModelProperty("消息通知配置")
	private String msgNotice;

	@ApiModelProperty("是否来自平台: 1-是,0-否")
	private Integer fromPlatform;

}
