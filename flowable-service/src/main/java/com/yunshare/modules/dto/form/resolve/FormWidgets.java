package com.yunshare.modules.dto.form.resolve;

import lombok.Data;

/**
 * 组件列表
 *
 * @author lzx@yuyuda.com
 * @since 2023/7/11 16:44
 */
@Data
public class FormWidgets {

    /**
     * 字段
     */
    private String field;
    /**
     * 字段名称
     */
    private String label;
    /**
     * 字段options
     */
    private Object options;
    /**
     * 组件类型
     */
    private String widgetType;
}
