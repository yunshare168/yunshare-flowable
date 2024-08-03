package com.yunshare.core.validator.hasvalue;

import com.yunshare.core.validator.annotations.HasValue;
import com.yunshare.core.validator.enums.ValidateTypeEnum;
import com.yunshare.core.validator.iface.IValidateHasValueType;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>无值不验证，有值即验证规则</p>
 *
 * @author lzx@yunshare.com
 * @since 2023/4/8 下午5:21
 */
public class HasValueValidator implements ConstraintValidator<HasValue, Object> {

    private HasValue hasValue;

    private static final Map<ValidateTypeEnum, IValidateHasValueType> MAP = new ConcurrentHashMap<>();

    static {
        MAP.put(ValidateTypeEnum.LENGTH, new LengthValidator());
        MAP.put(ValidateTypeEnum.SIZE, new SizeValidator());
        MAP.put(ValidateTypeEnum.DATE, new DateValidator());
        MAP.put(ValidateTypeEnum.JSON, new JsonValidator());
        MAP.put(ValidateTypeEnum.REGEP, new PatternValidator());
        MAP.put(ValidateTypeEnum.ENUMS, new EnumsValidator());
        MAP.put(ValidateTypeEnum.POSITIVE, new PositiveValidator());
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if (Objects.isNull(o) || StringUtils.isEmpty(o)) {
            return true;
        }
        IValidateHasValueType validator = MAP.get(hasValue.type());
        return validator.validator(o, hasValue);
    }

    @Override
    public void initialize(HasValue hasValue) {
        this.hasValue = hasValue;
    }
}
