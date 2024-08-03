package com.yunshare.core.engine.comparison.functions;

import cn.hutool.core.util.ReflectUtil;
import com.yunshare.core.engine.comparison.functions.extension.*;
import com.yunshare.core.enums.ColumnValueType;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 函数调用支持
 *
 * @author lzx@yuyuda.com
 * @since 2023/4/6 16:16
 */
@Slf4j
@Component
public class FuncKit {

    /**
     * <p>解析表达式，并调用函数得到执行结果</p>
     *
     * @param valueType 调用类型
     * @param leftValue 左边知道
     * @return 解析结果
     * @author lzx@yuyuda.com
     * @since 2023/4/6 16:21
     */
    @SneakyThrows
    public boolean resolve(Object leftValue, String valueType, String symbol, String... rightValues) {
        if (leftValue == null || rightValues == null || rightValues.length == 0) {
            return false;
        }
        ColumnValueType type = ColumnValueType.valueOf(valueType);
        IFunc func;
        if (ColumnValueType.NUMBER == type) {
            func = new NumberExtension();
        } else if (ColumnValueType.STRING == type) {
            func = new StringExtension();
        } else if (ColumnValueType.DATE == type) {
            func = new DateExtension();
        } else if (ColumnValueType.DATE_RANGE == type) {
            func = new DateRangeExtension();
        } else {
            //使用默认执行器
            func = new DefaultExtension();
        }
        Method method = ReflectUtil.getMethodByNameIgnoreCase(func.getClass(), symbol);
        if (method == null) {
            log.warn("找不到条件执行器方法:" + symbol);
            return false;
        }
        return (boolean) method.invoke(func, leftValue, rightValues);
    }

}
