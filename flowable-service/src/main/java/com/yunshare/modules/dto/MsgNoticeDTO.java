package com.yunshare.modules.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 消息通知
 *
 * @author lzx@yuyuda.com
 * @since 2023/8/1 10:43
 */
@Data
public class MsgNoticeDTO implements Serializable {
    @ApiModelProperty("渠道ID")
    private String channelId;
    @ApiModelProperty("发送渠道")
    private String sendChannel;
    @ApiModelProperty("消息模板")
    private String msgCode;
}
