package com.yunshare.core.domain;

import com.yunshare.core.tool.utils.StringUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

import static com.yunshare.core.constant.ProcessConstant.FLOWABLE_ID;

/**
 * 流程定义信息
 *
 * @author lzx@yuyuda.com
 * @since 2022/9/30 10:40
 */
@Data
public class BpmProcess implements Serializable {
	/**
	 * 模板ID
	 */
	@ApiModelProperty("模板ID")
	private String templateId;
	/**
	 * 流程实例ID
	 */
	@ApiModelProperty("流程实例ID")
	private String processInstanceId;
	/**
	 * 流程ID
	 */
	@ApiModelProperty("流程ID")
	private String processDefinitionId;
	/**
	 * 流程标识
	 */
	@ApiModelProperty("流程标识")
	private String processDefinitionKey;
	/**
	 * 流程名
	 */
	@ApiModelProperty("流程名")
	private String processDefinitionName;
	/**
	 * 流程版本
	 */
	@ApiModelProperty("流程版本")
	private int processDefinitionVersion;
	/**
	 * 流程说明
	 */
	@ApiModelProperty("流程说明")
	private String processDefinitionDesc;

	public String getTemplateId() {
		return StringUtil.removePrefix(this.getProcessDefinitionKey(), FLOWABLE_ID);
	}
}
