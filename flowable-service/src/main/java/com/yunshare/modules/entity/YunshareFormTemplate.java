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
import java.time.LocalDateTime;

/**
* 公共服务-表单实体类
*
* @author lzx@yuyuda.com
* @since 2022-09-28 11:18:09
*/
@Data
@TableName("yunshare_form_template")
@ApiModel(value = "yunshare_form_template对象", description = "流程引擎服务-表单")
public class YunshareFormTemplate implements Serializable {

    private static final long serialVersionUID = 994064939630885237L;

	/**
	 * 主键id
	 **/
	@JsonSerialize(using = ToStringSerializer.class)
	@TableId(value = "id",type = IdType.ASSIGN_ID)
	@ApiModelProperty("主键id")
	private Long id;

	/**
	 * 企业ID
	 */
	@ApiModelProperty(value = "企业ID")
	@JsonSerialize(using = ToStringSerializer.class)
	private Long corpId;

	/**
	 * 创建用户ID
	 **/
	@JsonSerialize(using = ToStringSerializer.class)
	@ApiModelProperty("创建用户ID")
	private Long createUser;

	/**
	 * 更新用户ID
	 **/
	@JsonSerialize(using = ToStringSerializer.class)
	@ApiModelProperty("更新用户ID")
	private Long updateUser;

	/**
	 * 创建部门ID
	 **/
	@JsonSerialize(using = ToStringSerializer.class)
	@ApiModelProperty("创建部门ID")
	private Long createDept;

    /**
     * 发送状态，1-正常，2-禁用
     */
    @ApiModelProperty(value = "状态，1-正常，2-禁用")
    private Integer templateStatus;

    /**
     * 表单分类，数据字典
     */
    @ApiModelProperty(value = "表单分类，数据字典")
    private String templateType;
    /**
     * 表单标题
     */
    @ApiModelProperty(value = "表单标题")
    private String templateTitle;
    /**
     * 表单值
     */
    @ApiModelProperty(value = "表单Html值")
    private String templateHtml;

	/**
	 * 0-正常1-删除
	 */
	@ApiModelProperty("逻辑删除")
	private Integer isDeleted;

	/**
	 * 创建时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty("创建时间")
	private LocalDateTime createTime;
	/**
	 * 更新时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty("更新时间")
	private LocalDateTime updateTime;
}
