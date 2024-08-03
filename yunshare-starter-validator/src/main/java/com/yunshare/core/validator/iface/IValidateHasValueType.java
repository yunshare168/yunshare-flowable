package com.yunshare.core.validator.iface;

import com.yunshare.core.validator.annotations.HasValue;

/**
 * <p>有值时才较验接口</p>
 *
 * @author lzx@yunshare.com
 * @since 2023/4/8 下午9:45
 */
public interface IValidateHasValueType {

    /**
     * <p>验证器</p>
     * @param object 值
     * @param hasValue 枚举对象
     * @return  boolean
     * @author liuzhixian@369zhy.com
     * @since 2023/4/8 下午10:13
     */
    boolean validator(Object object, HasValue  hasValue);
}
