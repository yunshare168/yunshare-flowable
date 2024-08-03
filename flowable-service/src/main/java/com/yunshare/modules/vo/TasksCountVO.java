package com.yunshare.modules.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 统计任务数量
 *
 * @author lzx@yuyuda.com
 * @since 2023/7/13 09:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TasksCountVO implements Serializable {
    /**
     * 发起任务未完成数量
     */
    @ApiModelProperty("发起任务未完成数量")
    private Long sendUnfinishedCount;

    /**
     * 待处理任务数量
     */
    @ApiModelProperty("待处理任务数量")
    private Long todoCount;

    /**
     * 抄送任务数量
     */
    @ApiModelProperty("抄送任务数量")
    private Long ccCount;
}
