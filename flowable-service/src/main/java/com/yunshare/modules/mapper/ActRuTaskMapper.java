package com.yunshare.modules.mapper;

import com.yunshare.core.mp.mapper.YunshareMapper;
import com.yunshare.modules.entity.ActRuTask;

/**
 * (ActRuTask)
 *
 * @author lzx@yuyuda.com
 * @since 2023-12-07 11:47:55
 */
public interface ActRuTaskMapper extends YunshareMapper<ActRuTask> {


    /**
     * <p>查询企业待办总数</p>
     *
     * @param cropId 企业ID
     * @return {@link long}
     * @author lzx@yuyuda.com
     * @since 2023/12/7 11:52
     */
    Long todoTotalCount(Long cropId);
}
