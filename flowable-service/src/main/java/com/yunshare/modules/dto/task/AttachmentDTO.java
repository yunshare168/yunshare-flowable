package com.yunshare.modules.dto.task;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author lzx@yuyuda.com
 * @since 2023/2/10 09:53
 */
@Data
public class AttachmentDTO  implements Serializable {
	@ApiModelProperty("附件类型")
	private String attachmentType;
	@ApiModelProperty("附件名称")
	private String attachmentName;
	@ApiModelProperty("附件描述")
	private String attachmentDescription;
	@ApiModelProperty("附件地址")
	private String url;
}
