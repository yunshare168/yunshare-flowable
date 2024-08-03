package com.yunshare.core.validator.attr;

import com.yunshare.core.validator.enums.ValidateTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>@HasValue</p>
 *
 * @author liuzhixian@369zhy.com
 * @since 2023/9/5 下午2:29
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class HasValue extends Base {

    private static final long serialVersionUID = 4205701344564241631L;

    private ValidateTypeEnum type;

    private int min;

    private int max;

    private String regep;

    private String enums;
}
