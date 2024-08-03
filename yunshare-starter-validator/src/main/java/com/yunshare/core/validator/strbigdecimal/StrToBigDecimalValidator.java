package com.yunshare.core.validator.strbigdecimal;

import com.yunshare.core.validator.annotations.StrToBigDecimal;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

/**
 * <p>字符串转BigDecimal验证</p>
 *
 * @author lzx@yuyuda.com
 * @version 1.0
 * @since 2023/3/6 15:19
 */
public class StrToBigDecimalValidator implements ConstraintValidator<StrToBigDecimal, String> {
	private StrToBigDecimal strToBigDecimal;
	@Override
	public void initialize(StrToBigDecimal constraintAnnotation) {
		this.strToBigDecimal = constraintAnnotation;
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (StringUtils.isEmpty(value)){
			return true;
		}
		try {
			BigDecimal decimal = new BigDecimal(value);
			int result1 = decimal.compareTo(new BigDecimal(strToBigDecimal.min()));
			int result2 = decimal.compareTo(new BigDecimal(strToBigDecimal.max()));
			if (result1 > 0 && result2 < 0){
				return true;
			}
		}catch (NumberFormatException e){
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("注册资本参数非数字类型").addBeanNode().addConstraintViolation();
			return false;
		}
		String expression = "^(([1-9]{1}\\d*)|(0{1}))(\\.\\d{0,6})?$";
		if (!value.matches(expression)){
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("注册资本参数最多不能超过6位小数").addBeanNode().addConstraintViolation();
			return false;
		}

		return false;
	}

}
