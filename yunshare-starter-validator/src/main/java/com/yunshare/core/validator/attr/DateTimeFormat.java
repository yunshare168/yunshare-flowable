package com.yunshare.core.validator.attr;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>@DateTimeFormat</p>
 *
 * @author liuzhixian@369zhy.com
 * @since 2023/9/5 下午2:29
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DateTimeFormat extends Base {

    private static final long serialVersionUID = 1069087558237928597L;

    private String format;
}
