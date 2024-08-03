package com.yunshare.core.validator.hasvalue;

import com.yunshare.core.tool.utils.Func;
import com.yunshare.core.validator.annotations.HasValue;
import com.yunshare.core.validator.iface.IValidateHasValueType;

/**
 * <p>枚举验证</p>
 *
 * @author lzx@yunshare.com
 * @since 2023/4/8 下午9:47
 */
public class EnumsValidator implements IValidateHasValueType {
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
        String s = Func.toStr(object);
        return hasValue.enums().contains(s);
    }
}
