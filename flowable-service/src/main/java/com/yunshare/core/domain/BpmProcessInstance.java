package com.yunshare.core.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 流程实例信息
 *
 * @author lzx@yuyuda.com
 * @since 2022/9/30 10:40
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BpmProcessInstance extends BpmProcess implements Serializable {

	/**
	 * 流程实例名称
	 */
	@ApiModelProperty("流程实例名称")
	private String instanceName;

	/**
	 * 流程实例是否结束
	 */
	@ApiModelProperty("流程实例是否结束")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String processIsFinished;

	/**
	 * 是否通过
	 */
	@ApiModelProperty("是否通过")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private boolean isPass;

	/**
	 * 申请单号
	 */
	@ApiModelProperty("申请单号")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String applySn;

	/**
	 * 申请客户端
	 */
	@ApiModelProperty("申请客户端")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String applyClient;

	/**
	 * 创建时间
	 */
	@ApiModelProperty("创建时间")
	private Date createTime;

	/**
	 * 流程执行状态
	 */
	@ApiModelProperty("流程执行动作")
	private String processAction;

	/**
	 * 当前任务处理人
	 */
	@ApiModelProperty("当前任务处理人")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String currentAssignee;

	@ApiModelProperty("任务Id")
	private String taskId;

	@ApiModelProperty("节点类型")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String nodeType;

	@ApiModelProperty("节点标题")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String nodeTitle;

	/**
	 * 申请人
	 */
	@ApiModelProperty("申请人")
	private String applyUser;

	/**
	 * 申请人用户头像
	 */
	@ApiModelProperty("申请人用户头像")
	private String applyUserAvatar;
	/**
	 * 申请人用户ID
	 */
	@ApiModelProperty("申请用户ID")
	private String applyUserId;

}
