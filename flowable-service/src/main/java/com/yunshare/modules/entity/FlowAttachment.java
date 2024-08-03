package com.yunshare.modules.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author lzx@yuyuda.com
 * @since 2023/2/10 10:52
 */
@Data
@TableName("ACT_HI_ATTACHMENT")
public class FlowAttachment {

	@TableId(value = "ID_",type = IdType.ASSIGN_UUID)
	private String id;
	@TableField("REV_")
	private String rev;
	@TableField("USER_ID_")
	private String userId;
	@TableField("NAME_")
	private String name;
	@TableField("DESCRIPTION_")
	private String description;
	@TableField("TYPE_")
	private String type;
	@TableField("TASK_ID_")
	private String taskId;
	@TableField("PROC_INST_ID_")
	private String procInstId;
	@TableField("URL_")
	private String url;
	@TableField("CONTENT_ID_")
	private String contentId;
	@TableField("TIME_")
	private Date time;
	@ApiModelProperty("评论ID")
	@TableField("COMMENT_ID_")
	private String commentId;
}
