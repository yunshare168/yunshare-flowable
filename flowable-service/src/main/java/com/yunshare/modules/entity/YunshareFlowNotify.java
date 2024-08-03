package com.yunshare.modules.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
* 流程办理通知表实体类
*
* @author lzx@yuyuda.com
* @since 2023-03-15 11:08:42
*/
@Data
@TableName("yunshare_flow_notify")
@ApiModel(value = "yunshareFlowNotify对象", description = "流程办理通知表")
public class YunshareFlowNotify implements Serializable {

    private static final long serialVersionUID = 614612987129665210L;
	/**
	 * ID
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@TableId(value = "id",type = IdType.ASSIGN_ID)
	@ApiModelProperty("主键id")
	private Long id;
    /**
     * 流程实例ID
     */
    @ApiModelProperty("流程实例ID")
    private String instanceId;
    /**
     * 业务数据ID
     */
    @ApiModelProperty("业务数据ID")
    private String businessId;
    /**
     * 节点ID
     */
    @ApiModelProperty("节点ID")
    private String nodeId;
    /**
     * 请求地址
     */
    @ApiModelProperty("请求地址")
    private String requestUrl;
    /**
     * 请求参数
     */
    @ApiModelProperty("请求参数")
    private String requestParam;
    /**
     * 响应参数
     */
    @ApiModelProperty("响应参数")
    private String responseParam;
    /**
     * 响应错误代码
     */
    @ApiModelProperty("响应错误代码")
    private String responseErrorCode;
    /**
     * 是否结束 1结束 0未结束
     */
    @ApiModelProperty("是否结束 1结束 0未结束")
    private Integer isFinished;
    /**
     * 是否通过 1通过 0未通过
     */
    @ApiModelProperty("是否通过 1通过 0未通过")
    private Integer isPass;
    /**
     * 通知次数
     */
    @ApiModelProperty("通知次数")
    private Integer sendCount;
    /**
     * 处理状态 1已发送 2接收成功 3接收失败
     */
    @ApiModelProperty("处理状态 1已发送 2接收成功 3接收失败")
    private Integer dealStatus;
	/**
	 * 创建时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty("创建时间")
	private Date createTime;
	/**
	 * 更新时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty("更新时间")
	private Date updateTime;

}
