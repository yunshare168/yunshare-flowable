package com.yunshare.core.engine;

import com.yunshare.core.tool.utils.SpringUtil;
import com.yunshare.core.tool.utils.StringUtil;
import com.yunshare.modules.dto.ProcessActionResultDTO;
import com.yunshare.modules.dto.ProcessReqParamDTO;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 流程引擎执行处理器
 *
 * @author lzx@yuyuda.com
 * @since 2022/10/9 14:26
 */
public interface ActionHandler {

    /**
     * <p>执行方法</p>
     *
     * @param param 请求参数
     * @return 返回执行结果
     * @author lzx@yuyuda.com
     * @since 2022/10/9 14:29
     */
    ProcessActionResultDTO execute(ProcessReqParamDTO param);

    /**
     * <p>更新业务状态</p>
     *
     * @param processInstanceId 流程实例
     * @param status            状态
     * @author lzx@yuyuda.com
     * @since 2023/3/17 18:17
     */
    default void updateBusinessStatus(String processInstanceId, String status) {
        if (StringUtil.isBlank(processInstanceId)) {
            return;
        }
        JdbcTemplate jdbcTemplate = SpringUtil.getBean(JdbcTemplate.class);
        if (jdbcTemplate == null) {
            return;
        }
        //更新业务状态
        String sql = "update ACT_HI_PROCINST set BUSINESS_STATUS_ = ? where ID_ = ? ";
        jdbcTemplate.update(sql, status, processInstanceId);
    }

}
