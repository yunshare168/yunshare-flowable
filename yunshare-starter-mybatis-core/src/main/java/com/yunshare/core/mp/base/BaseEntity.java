package com.yunshare.core.mp.base;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.yunshare.core.tool.utils.DateUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

/**
 * 基础实体类
 *
 * @author lzx@yuyuda.com
 */
@Data
public class BaseEntity implements Serializable {
	/**
	 * 主键id
	 */
	@Column(name = "id")
	@JsonSerialize(using = ToStringSerializer.class)
	@TableId(value = "id", type = IdType.ASSIGN_ID)
	@ApiModelProperty(value = "id")
	private Long id;

	/**
	 * 创建人
	 */
	@Column(name = "create_user")
	@JsonSerialize(using = ToStringSerializer.class)
	@ApiModelProperty(value = "创建用户ID")
	private Long createUser;

	/**
	 * 创建部门
	 */
	@Column(name = "create_dept")
	@JsonSerialize(using = ToStringSerializer.class)
	@ApiModelProperty(value = "创建部门ID")
	private Long createDept;

	/**
	 * 创建时间
	 */
	@Column(name = "create_time")
	@DateTimeFormat(pattern = DateUtil.PATTERN_DATETIME)
	@JsonFormat(pattern = DateUtil.PATTERN_DATETIME)
	@ApiModelProperty(value = "创建时间")
	private Date createTime;

	/**
	 * 更新人
	 */
	@Column(name = "update_user")
	@JsonSerialize(using = ToStringSerializer.class)
	@ApiModelProperty(value = "更新用户ID")
	private Long updateUser;

	/**
	 * 更新时间
	 */
	@Column(name = "update_time")
	@DateTimeFormat(pattern = DateUtil.PATTERN_DATETIME)
	@JsonFormat(pattern = DateUtil.PATTERN_DATETIME)
	@ApiModelProperty(value = "更新时间")
	private Date updateTime;

	/**
	 * 状态[0:未删除,1:删除]
	 */
	@Column(name = "is_deleted")
	@TableLogic
	@ApiModelProperty(value = "逻辑删除")
	private Integer isDeleted;
}
