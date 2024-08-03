package com.yunshare.core.validator.annotations;

import com.yunshare.core.validator.enums.ValidateTypeEnum;
import com.yunshare.core.validator.hasvalue.HasValueValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>无值时不较验，有值后需要较验</p>
 * @author liuzhixian@369zhy.com
 * @since 2023/4/8 下午5:20
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = HasValueValidator.class)
public @interface HasValue {

    String message() default "";

    ValidateTypeEnum type() default ValidateTypeEnum.LENGTH;

    int min() default 0;

    int max() default 0;

    String regep() default "";

    String enums() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
