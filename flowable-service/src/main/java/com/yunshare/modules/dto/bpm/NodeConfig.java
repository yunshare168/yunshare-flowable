package com.yunshare.modules.dto.bpm;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yunshare.core.enums.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

/**
 * <p>流程模板节点</p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/15 下午11:34
 */
@Data
@ApiModel(value = "NodeConfig", description = "流程模板节点")
public class NodeConfig implements Serializable {

	private static final long serialVersionUID = 9079172922301844935L;

	@ApiModelProperty(value = "节点ID", required = true)
	@NotEmpty(message = "节点ID不能为空")
	private String nodeId;

	@ApiModelProperty(value = "表单权限, json格式", required = true)
	private String formPermission;

    @ApiModelProperty(value = "节点名称", required = true)
	@NotEmpty(message = "节点名称不能为空")
    private String nodeName;

    @ApiModelProperty(value = "节点类型 ROOT根节点[发起人节点] USER_TASK审批节点 DEAL_TASK办理节点 CC抄送节点 ROUTER排他网关节点 PARALLEL并行网关节点", required = true)
    private NodeType nodeType;

    @ApiModelProperty("条件优先级")
    private String priorityLevel;

    @ApiModelProperty(value = "审批类型 NOT_AUTO非自动，默认方式； AUTO自动", required = true)
	private AutoTask autoTask;

    @ApiModelProperty(value = "审批人设置 ORG按组织 SELF_CHOICE发起人自选 SELF发起人自己 PREV上一节点操作人", required = true)
    private MemberType memberType;

    @ApiModelProperty(value = "多人审批时采用的审批方式 SEQUENTIAL依次审批 AND_SIGN会签 OR_SIGN或签", required = true)
    private ExamineModeEnum examineMode;

	@ApiModelProperty("节点组织人员")
	private List<NodeOrg> nodeOrgList;

    @ApiModelProperty(value = "审批人为空时 SOMEONE默认值有操作人 NO_CREATE不允许创建驳回 AUTO自动审批通过 TRANSFER_ADMIN转交给审核管理员", required = true)
    private NoHandlerAction noHandlerAction;

    @ApiModelProperty("子节点")
    private NodeConfig childNode;

    @ApiModelProperty("条件节点")
    private List<NodeConfig> conditionNodes;

    @ApiModelProperty("节点条件表达式列表")
    private List<ConditionExpression> conditionExpressions;

    @ApiModelProperty(value = "是否需要连线，主要处理网关合并判断", hidden = true)
    @JsonIgnore
	private Boolean isNeedSequenceFlow = true;

    @ApiModelProperty(value = "是否默认分支" )
    private Boolean isDefault = false;

    @ApiModelProperty("开启当前节点位置获取")
    private Boolean openLocation=false;
}
