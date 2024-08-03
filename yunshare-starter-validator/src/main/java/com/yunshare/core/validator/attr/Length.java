package com.yunshare.core.validator.attr;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>@Length</p>
 *
 * @author liuzhixian@369zhy.com
 * @since 2023/9/5 下午2:29
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Length extends Base {

    private static final long serialVersionUID = -7329076122391398292L;

    private int min;

    private int max;
}
