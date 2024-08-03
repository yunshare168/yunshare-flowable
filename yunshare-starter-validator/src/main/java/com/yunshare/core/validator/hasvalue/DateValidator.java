package com.yunshare.core.validator.hasvalue;

import com.yunshare.core.validator.annotations.HasValue;
import com.yunshare.core.validator.iface.IValidateHasValueType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>日期验证</p>
 *
 * @author lzx@yunshare.com
 * @since 2023/4/8 下午9:47
 */
public class DateValidator implements IValidateHasValueType {
    /**
     * <p>验证器</p>
     *
     * @param object   值
     * @param hasValue 枚举对象
     * @return boolean
     * @author liuzhixian@369zhy.com
     * @since 2023/4/8 下午10:13
     */
    @Override
    public boolean validator(Object object, HasValue hasValue) {
        return object instanceof Date || object instanceof LocalDate || object instanceof LocalDateTime;
    }
}
