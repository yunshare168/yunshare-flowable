package com.yunshare.core.validator.attr;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>@Min</p>
 *
 * @author liuzhixian@369zhy.com
 * @since 2023/9/5 下午2:29
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Min extends Base {

    private static final long serialVersionUID = -8160500507277352753L;

    private int value;
}
