package com.yunshare.core.validator.attr;

import com.yunshare.core.validator.group.ValidGroup;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>注解属性基类</p>
 *
 * @author liuzhixian@369zhy.com
 * @since 2023/9/5 下午2:21
 */
@Data
public class Base implements Serializable {

    private static final long serialVersionUID = 3610297678804461715L;

    /**
     * 提示消息
     */
    private String message;

    /**
     * 验证分组
     */
    private ValidGroup groups;
}
