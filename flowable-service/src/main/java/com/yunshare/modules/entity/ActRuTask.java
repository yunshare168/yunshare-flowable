package com.yunshare.modules.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 运行任务表
 *
 * @author lzx@yuyuda.com
 * @since 2023-12-07 11:47:54
 */
@Data
@TableName("ACT_RU_TASK")
@ApiModel(value = "ActRuTask对象", description = "对象")
public class ActRuTask implements Serializable {

    private static final long serialVersionUID = -84342390155076896L;
    @TableId(
            value = "ID_",
            type = IdType.NONE
    )
    private String id;
    @TableField("REV_")
    private Integer rev;
    @TableField("EXECUTION_ID_")
    private String executionId;
    @TableField("PROC_INST_ID_")
    private String procInstId;
    @TableField("PROC_DEF_ID_")
    private String procDefId;
    @TableField("TASK_DEF_ID_")
    private String taskDefId;
    @TableField("SCOPE_ID_")
    private String scopeId;
    @TableField("SUB_SCOPE_ID_")
    private String subScopeId;
    @TableField("SCOPE_TYPE_")
    private String scopeType;
    @TableField("SCOPE_DEFINITION_ID_")
    private String scopeDefinitionId;
    @TableField("PROPAGATED_STAGE_INST_ID_")
    private String propagatedStageInstId;
    @TableField("NAME")
    private String name;
    @TableField("PARENT_TASK_ID_")
    private String parentTaskId;
    @TableField("DESCRIPTION")
    private String description;
    @TableField("TASK_DEF_KEY_")
    private String taskDefKey;
    @TableField("OWNER")
    private String owner;
    @TableField("ASSIGNEE")
    private String assignee;
    @TableField("DELEGATION")
    private String delegation;
    @TableField("PRIORITY")
    private Integer priority;
    @TableField("CREATE_TIME_")
    private LocalDateTime createTime;
    @TableField("DUE_DATE_")
    private LocalDateTime dueDate;
    @TableField("CATEGORY")
    private String category;
    @TableField("SUSPENSION_STATE_")
    private Integer suspensionState;
    @TableField("TENANT_ID_")
    private String tenantId;
    @TableField("FORM_KEY_")
    private String formKey;
    @TableField("CLAIM_TIME_")
    private LocalDateTime claimTime;
    @TableField("IS_COUNT_ENABLED_")
    private Integer isCountEnabled;
    @TableField("VAR_COUNT_")
    private Integer varCount;
    @TableField("ID_LINK_COUNT_")
    private Integer idLinkCount;
    @TableField("SUB_TASK_COUNT_")
    private Integer subTaskCount;


}
