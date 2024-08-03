package com.yunshare.core.domain;

import com.yunshare.core.domain.form.BpmForm;
import com.yunshare.core.domain.form.Button;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 流程实例，流程任务数据信息
 *
 * @author lzx@yuyuda.com
 * @since 2022/9/30 14:23
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class FlowData extends BpmProcessInstance implements Serializable {

	@ApiModelProperty("流程当前节点表单")
	private BpmForm form;

	@ApiModelProperty("流程自定义表单业务数据")
	private Map<String, Object> data;

	@ApiModelProperty("流程自定义表单 字段权限")
	private String permission;

	@ApiModelProperty("流程自定义表单 初始化数据，可用于子表数据复制赋值")
	private Map<String, Object> initData;

	@ApiModelProperty("流程 当前节点按钮信息")
	private List<Button> getButtonList;

	@ApiModelProperty("是否开启评论: 1开启 0未开启")
	private Integer openComment;

	@ApiModelProperty("是否开启满意度评价: 1开启 0未开启")
	private Integer openEvaluate;

	@ApiModelProperty("开启当前节点位置获取")
	private Boolean openLocation=false;

}
