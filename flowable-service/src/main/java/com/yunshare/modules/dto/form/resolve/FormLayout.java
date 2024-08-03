package com.yunshare.modules.dto.form.resolve;

import lombok.Data;

import java.util.List;

/**
 * 表单布局
 *
 * @author lzx@yuyuda.com
 * @since 2023/7/11 16:43
 */
@Data
public class FormLayout {

    private String size;
    private String layout;
    private List<FormWidgets> widgets;
}
