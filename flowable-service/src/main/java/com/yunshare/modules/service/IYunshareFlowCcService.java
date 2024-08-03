package com.yunshare.modules.service;

import com.yunshare.core.mp.service.YunshareService;
import com.yunshare.modules.entity.YunshareFlowCc;

/**
 * 流程抄送接口
 *
 * @author lzx
 */
public interface IYunshareFlowCcService extends YunshareService<YunshareFlowCc> {

    /**
     * <p>统计抄送给用户的数量</p>
     *
     * @param corpId 企业ID
     * @param userId 用户ID
     * @return {@link long}
     * @author lzx@yuyuda.com
     * @since 2023/7/13 09:53
     */
    long ccCount(String corpId, String userId);
}
