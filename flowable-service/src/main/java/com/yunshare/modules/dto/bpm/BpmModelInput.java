package com.yunshare.modules.dto.bpm;

import com.yunshare.modules.dto.MsgNoticeDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * <p>bpmn表单、流程节点前端对象</p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/16 下午1:01
 */
@Data
@ApiModel(value = "BpmModelInput", description = "bpmn表单、流程节点前端对象")
public class BpmModelInput  implements Serializable {

	private static final long serialVersionUID = -3097474873948835763L;

	@ApiModelProperty("表单模板id")
	@NotNull(message = "请设置表单模板id")
	private Long formTemplateId;

	@ApiModelProperty(value = "流程名称", hidden = true)
	private String workFlowDef;

	@ApiModelProperty("发起人权限")
	private List<NodeOrg> startPermission;

	@ApiModelProperty("流程节点配置")
	@Valid
	private NodeConfig nodeConfig;

	@ApiModelProperty(value = "流程定义key", hidden = true)
	private String processDefinitionKey;


	@ApiModelProperty("消息通知配置")
	private List<MsgNoticeDTO> msgNotice;

}
