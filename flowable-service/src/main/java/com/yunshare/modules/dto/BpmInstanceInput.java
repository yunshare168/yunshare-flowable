package com.yunshare.modules.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import java.io.Serializable;

/**
 * @author lzx@yuyuda.com
 * @since 2022/9/30 14:36
 */
@Data
@ApiOperation(value = "流程实例数据", notes = "获取流程实例相关数据，包含实例信息，业务数据，表单权限、表单数据、表单内容等")
public class BpmInstanceInput implements Serializable {
	@ApiModelProperty("流程实例ID")
	private String instanceId;
	@ApiModelProperty("模板Id")
	private Long templateId;
	@ApiModelProperty("流程节点ID")
	private String taskId;
	@ApiModelProperty("获取开始表单")
	private Boolean startForm;
}
