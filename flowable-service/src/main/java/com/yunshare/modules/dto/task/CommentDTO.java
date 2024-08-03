package com.yunshare.modules.dto.task;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 评论
 *
 * @author lzx@yuyuda.com
 * @since 2023/2/10 09:54
 */
@Data
public class CommentDTO implements Serializable {

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty("评论信息")
    private String message;

    @ApiModelProperty("定位信息，json")
    private String location;

    @ApiModelProperty("评论类型")
    private String messageType;

    @ApiModelProperty(value = "日期")
    @DateTimeFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    private Date time;

    @ApiModelProperty(hidden = true)
    private String taskId;

    @ApiModelProperty("附件")
    private List<AttachmentDTO> attachments;

    public CommentDTO() {
    }

    public CommentDTO(String message) {
        this.message = message;
    }
}
