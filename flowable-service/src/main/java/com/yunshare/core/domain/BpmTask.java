package com.yunshare.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.yunshare.core.domain.form.FormFieldValue;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 任务相关信息
 *
 * @author lzx@yuyuda.com
 * @since 2022/9/30 10:30
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BpmTask extends BpmProcessInstance implements Serializable {

    /**
     * 任务名称
     */
    @ApiModelProperty("任务名")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String taskName;
    /**
     * 任务定义Key
     */
    @ApiModelProperty("任务定义Key")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String taskDefinitionKey;
    /**
     * 任务执行人编号
     */
    @ApiModelProperty("任务执行人编号")
    private String assignee;
    /**
     * 任务执行人名称
     */
    @ApiModelProperty("任务执行人名称")
    private String assigneeName;
    /**
     * 流程分类
     */
    @ApiModelProperty("流程分类")
    private String category;
    /**
     * 结束时间
     */
    @ApiModelProperty("结束时间")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Date endTime;
    /**
     * 签收时间
     */
    @ApiModelProperty("签收时间")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Date claimTime;

    /**
     * 历史任务流程实例ID 查看流程图会用到
     */
    @ApiModelProperty("历史任务流程实例ID")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String historyProcessInstanceId;

    /**
     * 历史任务结束时间
     */
    @ApiModelProperty("历史任务结束时间")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Date historyTaskEndTime;
    /**
     * 历史活动耗时
     */
    @ApiModelProperty("活动耗时")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String durationTime;
    /**
     * 业务绑定ID
     */
    @ApiModelProperty("业务绑定ID")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String businessId;
    /**
     * 任务状态
     */
    @ApiModelProperty("任务状态")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String status;

    /**
     * 流程参数
     */
    @ApiModelProperty("流程全局参数")
    @JsonIgnore
    private Map<String, Object> variables;

    /**
     * 字段值
     */
    @ApiModelProperty("字段值")
    private List<FormFieldValue> fieldValue;

}
