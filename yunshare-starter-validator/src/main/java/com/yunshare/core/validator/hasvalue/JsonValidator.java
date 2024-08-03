package com.yunshare.core.validator.hasvalue;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunshare.core.tool.utils.StringPool;
import com.yunshare.core.validator.annotations.HasValue;
import com.yunshare.core.validator.iface.IValidateHasValueType;

import java.io.IOException;

/**
 * <p>json验证</p>
 *
 * @author lzx@yunshare.com
 * @since 2023/4/8 下午9:47
 */
public class JsonValidator implements IValidateHasValueType {
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
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonString = object.toString();
            if (jsonString.contains(StringPool.BACK_SLASH)) {
                jsonString = jsonString.replace(StringPool.BACK_SLASH, StringPool.EMPTY);
            }
            JsonParser parser = objectMapper.createParser(jsonString);
            objectMapper.readTree(parser);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
