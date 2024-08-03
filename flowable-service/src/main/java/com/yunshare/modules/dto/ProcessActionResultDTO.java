package com.yunshare.modules.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 流程操作结果返回体
 *
 * @author lzx@yuyuda.com
 * @since 2023/7/17 14:05
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProcessActionResultDTO {

    @ApiModelProperty("流程实例id")
    private String processInstanceId;

}
