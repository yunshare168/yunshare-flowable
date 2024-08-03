package com.yunshare.core.validator.annotations;

import com.yunshare.core.validator.datetime.DateTimeStrValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>时间字符串格式验证</p >
 *
 * @author lzx@yuyuda.com
 * @since 2022/4/10 6:43 下午
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateTimeStrValidator.class)
public @interface DateTimeFormat {

    String message() default "时间格式错误";

    String format() default "yyyy-MM-dd HH:mm:ss";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
