package com.yunshare.core.validator.attr;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>@Max</p>
 *
 * @author liuzhixian@369zhy.com
 * @since 2023/9/5 下午2:29
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Max extends Base {

    private static final long serialVersionUID = 3250764268938833353L;

    private int value;
}