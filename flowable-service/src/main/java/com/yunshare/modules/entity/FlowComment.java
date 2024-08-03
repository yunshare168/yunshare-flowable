package com.yunshare.modules.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 流程评论
 *
 * @author lzx@yuyuda.com
 * @since 2023/2/10 10:52
 */
@Data
@TableName("ACT_HI_COMMENT")
public class FlowComment {

	@TableId(value = "ID_", type = IdType.ASSIGN_UUID)
	private String id;
	@TableField(value = "TYPE_")
	private String type;
	@TableField(value = "TIME_")
	private Date time;
	@TableField(value = "USER_ID_")
	private String userId;
	@TableField(value = "TASK_ID_")
	private String taskId;
	@TableField(value = "PROC_INST_ID_")
	private String procInstId;
	@TableField(value = "ACTION_")
	private String action;
	@TableField(value = "MESSAGE_")
	private String message;
	@TableField(value = "LOCATION_")
	private String location;
	@TableField(value = "FULL_MSG_")
	private byte[] fullMsg;
}
