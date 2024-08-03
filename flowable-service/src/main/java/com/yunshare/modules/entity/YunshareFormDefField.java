package com.yunshare.modules.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 流程表单权限表
 *
 * @author lzx
 */
@TableName(value = "yunshare_form_def_field")
@Data
public class YunshareFormDefField implements Serializable {

    private static final long serialVersionUID = -6053085780031760586L;

    @JsonSerialize(
            using = ToStringSerializer.class
    )
    @TableId(
            value = "id",
            type = IdType.ASSIGN_ID
    )
    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("表单定义ID")
    private Long formDefinitionId;
    @ApiModelProperty("字段标识")
    private String field;
    @ApiModelProperty("字段名称")
    protected String label;
    @ApiModelProperty("字段类型")
    protected String widgetType;
    @ApiModelProperty("流程模板ID")
    private Long flowTemplateId;
    @ApiModelProperty("流程定义ID")
    private String processDefinitionId;
    @ApiModelProperty("流程定义key")
    private String processDefinitionKey;
}
