package com.yunshare.core.validator.attr;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * <p>@DecimalMin</p>
 *
 * @author liuzhixian@369zhy.com
 * @since 2023/9/5 下午2:29
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DecimalMin extends Base {

    private static final long serialVersionUID = 2395488876996454708L;

    private BigDecimal value;
}
