package com.yunshare.modules.service.impl;

import com.yunshare.core.mp.service.YunshareServiceImpl;
import com.yunshare.modules.entity.YunshareFlowCc;
import com.yunshare.modules.mapper.YunshareFlowCcMapper;
import com.yunshare.modules.service.IYunshareFlowCcService;
import org.springframework.stereotype.Service;

/**
 * 流程抄送表(yunshareFlowCc)表服务实现类
 *
 * @author makejava
 * @since 2023-01-29 17:54:52
 */
@Service
public class YunshareFlowCcServiceImpl extends YunshareServiceImpl<YunshareFlowCcMapper, YunshareFlowCc> implements IYunshareFlowCcService {


    @Override
    public long ccCount(String corpId, String userId) {
        return getBaseMapper().ccCount(corpId, userId);
    }

}
