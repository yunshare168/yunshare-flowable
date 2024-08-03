package com.yunshare.modules.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.yunshare.core.tool.utils.StringPool;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>流程模板试图</p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/2/15 11:22
 */
@Data
public class YunshareFlowTemplateVO implements Serializable {

	/**
	 * 主键id
	 **/
	@JsonSerialize(using = ToStringSerializer.class)
	@ApiModelProperty("主键id")
	private Long id;

	/**
	 * 模板名称
	 */
	@ApiModelProperty("模板名称")
	private String title;

	/**
	 * 模板图标
	 */
	@ApiModelProperty("模板图标")
	private String image;

	/**
	 * 模板类型ID
	 */
	@ApiModelProperty("模板类型ID")
	@JsonSerialize(using = ToStringSerializer.class)
	private Long typeId;

	/**
	 * 模板类型名称
	 */
	@ApiModelProperty("模板类型名称")
	private String typeTitle;

	public String getTypeTitle() {
		return typeTitle==null? StringPool.EMPTY:typeTitle;
	}

	/**
	 * 模板描述
	 */
	@ApiModelProperty("模板描述")
	private String remark;

}

