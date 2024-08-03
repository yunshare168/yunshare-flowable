package com.yunshare.modules.dto;

import com.yunshare.modules.dto.bpm.NodeOrg;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 前端节点审批人
 *
 * @author lzx@yuyuda.com
 * @since 2023/3/15 10:47
 */
@Data
public class AssigneeDTO implements Serializable {
	@ApiModelProperty("节点ID")
	private String taskId;
	@ApiModelProperty("审批人员信息")
	public List<NodeOrg> assigneeList;
}
