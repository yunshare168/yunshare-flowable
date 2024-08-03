package com.yunshare.core.validator.attr;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>@StrToBigDecimal</p>
 *
 * @author liuzhixian@369zhy.com
 * @since 2023/9/5 下午2:29
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class StrToBigDecimal extends Base {

    private static final long serialVersionUID = 3949289215017515136L;

    private int min;

    private int max;
}
