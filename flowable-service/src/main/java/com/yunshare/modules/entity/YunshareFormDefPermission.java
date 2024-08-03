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
@TableName(value = "yunshare_form_def_permission")
@Data
public class YunshareFormDefPermission implements Serializable {

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
    /**
     * 流程节点id
     */
    @ApiModelProperty("流程节点id")
    private String nodeId;

    /**
     * 权限
     */
    @ApiModelProperty("流程表单权限数据")
    private String permission;

    /**
     * 流程定义id
     */
    @ApiModelProperty("流程定义id")
    private String processDefinitionId;

}
