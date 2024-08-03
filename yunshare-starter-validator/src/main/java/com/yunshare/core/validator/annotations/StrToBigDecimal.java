package com.yunshare.core.validator.annotations;

import com.yunshare.core.validator.strbigdecimal.StrToBigDecimalValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>字符串转BigDecimal验证</p>
 *
 * @author lzx@yuyuda.com
 * @version 1.0
 * @since 2023/3/6 15:16
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StrToBigDecimalValidator.class)
public @interface StrToBigDecimal {

	String message() default "超出范围";

	String min() default "";

	String max() default "";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
