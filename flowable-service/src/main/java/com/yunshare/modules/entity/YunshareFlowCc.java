package com.yunshare.modules.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yunshare.core.mp.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 流程抄送表
 * @author lzx
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="yunshare_flow_cc")
@Data
@ApiModel(value = "yunshareFlowCc", description = "流程抄送表")
public class YunshareFlowCc extends BaseEntity {

	private static final long serialVersionUID = 2930825122986867666L;

	/**
	 * 企业ID
	 */
	@ApiModelProperty("企业ID")
	private Long corpId;

    /**
     * 抄送人ID
     */
    @ApiModelProperty("抄送人ID")
    private Long userId;

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
     * 流程实例ID
     */
    @ApiModelProperty("流程实例ID")
    private String processInstanceId;

    /**
     * 流程定义key
     */
    @ApiModelProperty("流程定义key")
    private String processDefinitionKey;

    @ApiModelProperty("申请人ID")
	private Long applyUserId;

    @ApiModelProperty("申请客户端")
    private String applyClient;

	@ApiModelProperty("流程申请单号")
	private String applySn;

	@ApiModelProperty("工单是否被撤回：0.正常1.撤回")
	private Integer isWithdraw;

    @ApiModelProperty("流程定义名称")
	@TableField(exist = false)
    private String processDefinitionName;

    @ApiModelProperty("模板类型名称")
	@TableField(exist = false)
    private String categoryName;

	@ApiModelProperty("模板类型id")
	@TableField(exist = false)
	private String categoryId;
}
