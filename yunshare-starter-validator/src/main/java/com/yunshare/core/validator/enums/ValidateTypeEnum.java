package com.yunshare.core.validator.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>较验类型枚举</p>
 *
 * @author lzx@yunshare.com
 * @since 2023/4/8 下午5:28
 */
@Getter
@AllArgsConstructor
public enum ValidateTypeEnum {
    // 长度模式
    LENGTH,
    // 集合大小模式
    SIZE,
    // 正则模式
    REGEP,
    // json模式
    JSON,
    // 日期模式
    DATE,
    // 枚举值
    ENUMS,
    // 正数
    POSITIVE
}
