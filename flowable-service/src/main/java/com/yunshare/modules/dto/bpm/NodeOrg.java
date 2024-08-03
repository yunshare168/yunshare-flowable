package com.yunshare.modules.dto.bpm;

import com.yunshare.core.enums.OrgEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>节点组织人员</p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/15 下午11:36
 */
@Data
@ApiModel(value = "NodeOrg", description = "节点组织人员")
public class NodeOrg implements Serializable {

	private static final long serialVersionUID = 7684413917651735439L;

	@ApiModelProperty(value = "用户ID/部门ID/角色ID")
    private String id;

	@ApiModelProperty(value = "名称")
	private String name;

	@ApiModelProperty(value = "头像")
	private String avatar;

    @ApiModelProperty(value = "组织类型 USER用户 ROLE角色 DEPT部门")
	private OrgEnum orgEnum;

	public NodeOrg() {
	}

	public NodeOrg(String id, String name, String avatar, OrgEnum orgEnum) {
		this.id = id;
		this.name = name;
		this.avatar = avatar;
		this.orgEnum = orgEnum;
	}
}
