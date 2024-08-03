package com.yunshare.core.listener;

import com.yunshare.core.constant.ProcessConstant;
import com.yunshare.core.enums.ProcessActionType;
import com.yunshare.core.tool.utils.SpringUtil;
import lombok.SneakyThrows;
import org.flowable.common.engine.api.delegate.event.FlowableEvent;
import org.flowable.common.engine.api.delegate.event.FlowableEventListener;
import org.flowable.common.engine.impl.cfg.TransactionState;
import org.flowable.engine.HistoryService;
import org.flowable.engine.delegate.event.impl.FlowableEntityEventImpl;
import org.flowable.engine.history.HistoricProcessInstance;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * <p>流程创建监听器</p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/30 上午10:51
 */
@Component
public class FlowCreateListener implements FlowableEventListener {
    @Resource
    private HistoryService historyService;


    @Override
    public void onEvent(FlowableEvent event) {
        FlowableEntityEventImpl entityEvent = (FlowableEntityEventImpl) event;
        //生成索引
        //更新流程状态
        this.updateBusinessStatus(entityEvent.getProcessInstanceId());
    }

    @Override
    public boolean isFailOnException() {
        return false;
    }

    @Override
    public boolean isFireOnTransactionLifecycleEvent() {
        return true;
    }

    @Override
    public String getOnTransaction() {
        return TransactionState.COMMITTED.name();
    }


    /**
     * <p>更新业务状态</p>
     *
     * @param processInstanceId 流程实例
     * @author lzx@yuyuda.com
     * @since 2023/4/4 16:24
     */
    @SneakyThrows
    private void updateBusinessStatus(String processInstanceId) {
        HistoricProcessInstance processInstance = historyService.createHistoricProcessInstanceQuery().includeProcessVariables().processInstanceId(processInstanceId).singleResult();
        if (processInstance == null || processInstance.getEndTime() == null || processInstance.getBusinessStatus() != null) {
            return;
        }
        Boolean pass = (Boolean) processInstance.getProcessVariables().get(ProcessConstant.PASS_KEY);
        if (pass == null) {
            return;
        }
        //注册事务同步处理
        JdbcTemplate jdbcTemplate = SpringUtil.getBean(JdbcTemplate.class);
        if (jdbcTemplate == null) {
            return;
        }
        //更新业务状态
        String sql = "update ACT_HI_PROCINST set BUSINESS_STATUS_ = ? where ID_ = ? ";
        //判断是否通过，pass == true ？ 同意： 拒绝
        jdbcTemplate.update(sql, pass ? ProcessActionType.AGREE.name() : ProcessActionType.OPPOSE.name(), processInstanceId);
    }
}
