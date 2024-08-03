package com.yunshare.core.listener;

import lombok.extern.slf4j.Slf4j;
import org.flowable.common.engine.api.delegate.event.FlowableEngineEntityEvent;
import org.flowable.common.engine.api.delegate.event.FlowableEngineEventType;
import org.flowable.common.engine.api.delegate.event.FlowableEvent;
import org.flowable.common.engine.api.delegate.event.FlowableEventListener;
import org.flowable.common.engine.impl.cfg.TransactionState;
import org.flowable.engine.delegate.event.FlowableCancelledEvent;
import org.flowable.engine.delegate.event.impl.FlowableProcessCancelledEventImpl;
import org.flowable.task.service.impl.persistence.entity.TaskEntity;
import org.springframework.stereotype.Component;

/**
 * <p>流程完成监听</p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/7/12 17:34
 */
@Slf4j
@Component
public class TaskCompletedListener implements FlowableEventListener {


    @Override
    public void onEvent(FlowableEvent event) {
        String processInstanceId;
        TaskEntity taskEntity = null;
        //流程取消
        if (event.getType() == FlowableEngineEventType.PROCESS_CANCELLED) {
            FlowableCancelledEvent cancelledEvent = (FlowableProcessCancelledEventImpl) event;
            processInstanceId = cancelledEvent.getProcessInstanceId();
        } else {
            //任务完成
            taskEntity = (TaskEntity) ((FlowableEngineEntityEvent) event).getEntity();
            processInstanceId = taskEntity.getProcessInstanceId();
        }
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

}
