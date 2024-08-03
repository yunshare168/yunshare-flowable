package com.yunshare.core.domain.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lzx@yuyuda.com
 * @since 2023/7/11 17:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormFieldValue implements Serializable {
    @ApiModelProperty("标题")
    private String label;
    @ApiModelProperty("值")
    private Object value;
    @ApiModelProperty("组件类型")
    private String widgetType;
}
