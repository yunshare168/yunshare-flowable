package com.yunshare.core.domain;

import com.yunshare.core.mp.support.Query;
import com.yunshare.core.tool.utils.StringUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.yunshare.core.constant.ProcessConstant.APPLY_CLIENT;
import static com.yunshare.core.constant.ProcessConstant.APPLY_SN;

/**
 * 任务查询
 *
 * @author lzx@yuyuda.com
 * @since 2022/9/30 10:30
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BpmTaskQuery  extends Query implements Serializable {

	/**
	 * 流程名
	 */
	@ApiModelProperty("流程名")
	private String processDefinitionName;
	/**
	 * 流程key
	 */
	@ApiModelProperty("流程Key")
	private String processDefinitionKey;
	/**
	 * 流程分类
	 */
	@ApiModelProperty("流程分类")
	private String category;

	/**
	 * 开始查询日期
	 */
	@ApiModelProperty("开始查询日期")
	private Date beginDate;
	/**
	 * 结束查询日期
	 */
	@ApiModelProperty("结束查询日期")
	private Date endDate;
	/**
	 * 流程申请单号
	 */
	@ApiModelProperty("流程申请单号")
	private String applySn;
	/**
	 * 流程来源</p>
	 */
	@ApiModelProperty("来源")
	private String applyClient;

	/**
	 * 业务Id
	 */
	@ApiModelProperty("业务ID")
	private String businessId;

	/**
	 * 流程参数
	 */
	private Map<String, Object> variables;

	public Map<String, Object> getVariables() {
		if (variables == null) {
			variables = new HashMap<>(10);
		}
		if (StringUtil.isNotBlank(getApplyClient())) {
			variables.put(APPLY_CLIENT, getApplyClient());
		}
		if (StringUtil.isNotBlank(getApplySn())) {
			variables.put(APPLY_SN.concat("_like"), getApplySn());
		}
		return variables;
	}

}
