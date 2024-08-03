package com.yunshare.modules.mapper;

import com.yunshare.core.mp.mapper.YunshareMapper;
import com.yunshare.modules.entity.YunshareFormDefField;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * 表单字段
 *
 * @author lzx@yuyuda.com
 * @since 2023/7/11 15:47
 */
public interface YunshareFormDefFieldMapper extends YunshareMapper<YunshareFormDefField> {

    /**
     * <p>查询表单字段</p>
     *
     * @param definitionIds 流程定义ID
     * @param widgetType    组件类型
     * @return {@link List< YunshareFormDefField >}
     * @author lzx@yuyuda.com
     * @since 2023/7/12 09:43
     */
    List<YunshareFormDefField> queryFormDefFieldByDefinitionId(@Param("items") Set<String> definitionIds, @Param("type") Set<String> widgetType);

}




