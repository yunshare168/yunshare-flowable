package com.yunshare.modules.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.yunshare.core.enums.MemberType;
import com.yunshare.modules.dto.bpm.NodeOrg;
import com.yunshare.modules.dto.task.CommentDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 流程历史信息
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/28 15:05
 */
@Data
public class FlowHistoric implements Serializable {

	/**
	 * 创建时间
	 */
	@ApiModelProperty("创建时间")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Date createTime;
	/**
	 * 结束时间
	 */
	@ApiModelProperty("结束时间")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Date endTime;
	/**
	 * 签收时间
	 */
	@ApiModelProperty("签收时间")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Date claimTime;
	/**
	 * 历史活动ID
	 */
	@ApiModelProperty("历史活动ID")
	private String historyActivityId;
	/**
	 * 历史活动流程
	 */
	@ApiModelProperty("历史活动流程")
	private String historyActivityName;
	/**
	 * 历史活动耗时
	 */
	@ApiModelProperty("历史活动耗时")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String historyActivityDurationTime;

	@ApiModelProperty("活动类型")
	private String activityType;

	@ApiModelProperty("当前节点审批人类型")
	private MemberType approvalType;
	/**
	 * 评论
	 */
	@ApiModelProperty("评论")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<CommentDTO> comment;

	/**
	 * 组织人员信息
	 */
	@ApiModelProperty("节点组织人员")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<NodeOrg> assigneeList;

	@ApiModelProperty("任务处理状态")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String status;

	/**
	 * 流程执行状态
	 */
	@ApiModelProperty("流程执行动作")
	private String processAction;

	/**
	 * 多人审批时采用的审批方式 SEQUENTIAL依次审批 AND_SIGN会签 OR_SIGN或签
	 */
	@ApiModelProperty("多人审批时采用的审批方式 SEQUENTIAL依次审批 AND_SIGN会签 OR_SIGN或签")
	private String examineMode;

	public FlowHistoric() {
		assigneeList = new ArrayList<>(10);
	}

	public void addAssignee(NodeOrg assignee) {
		if (assignee == null) {
			return;
		}
		this.assigneeList.add(assignee);
	}

}
