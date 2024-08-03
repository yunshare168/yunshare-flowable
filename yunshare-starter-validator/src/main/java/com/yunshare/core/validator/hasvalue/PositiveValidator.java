package com.yunshare.core.validator.hasvalue;

import com.yunshare.core.validator.annotations.HasValue;
import com.yunshare.core.validator.iface.IValidateHasValueType;

/**
 * PositiveValidator is
 *
 * @author tangli
 * @since 2023/06/27 15:22
 */
public class PositiveValidator implements IValidateHasValueType {
    @Override
    public boolean validator(Object object, HasValue hasValue) {
        if (object instanceof Number) {
            return ((Number) object).doubleValue() > 0.0;
        }
        return false;
    }
}
