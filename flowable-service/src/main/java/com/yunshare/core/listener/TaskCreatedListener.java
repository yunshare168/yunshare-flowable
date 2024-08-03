package com.yunshare.core.listener;

import com.yunshare.core.constant.ProcessConstant;
import com.yunshare.core.enums.AutoTask;
import com.yunshare.core.enums.CommentTypeEnum;
import com.yunshare.core.enums.ProcessActionType;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.delegate.TaskListener;
import org.flowable.task.service.delegate.DelegateTask;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import static com.yunshare.core.constant.ProcessConstant.AUTO_TASK;
import static com.yunshare.core.constant.ProcessConstant.NOBODY;

/**
 * <p>任务创建监听器</p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/30 上午10:51
 */
@Component
public class TaskCreatedListener implements TaskListener {
    @Resource
    private TaskService taskService;
    @Resource
    private RuntimeService runtimeService;

    @Override
    public void notify(DelegateTask delegateTask) {
        // 无审批人
        if (NOBODY.equals(delegateTask.getAssignee())) {
            Boolean passKey = (Boolean) delegateTask.getVariable(ProcessConstant.PASS_KEY);
            taskService.setVariableLocal(delegateTask.getId(), ProcessConstant.PROCESS_ACTION, Boolean.TRUE.equals(passKey) ? ProcessActionType.AGREE.name() : ProcessActionType.OPPOSE.name());
            if (Boolean.TRUE.equals(passKey)) {
                taskService.addComment(delegateTask.getId(), delegateTask.getProcessInstanceId(), CommentTypeEnum.OPINION.getType(), "审批人为空,自动通过");
                taskService.complete(delegateTask.getId());
            } else {
                taskService.addComment(delegateTask.getId(), delegateTask.getProcessInstanceId(), CommentTypeEnum.OPINION.getType(), "审批人为空,自动驳回");
                //解决循环依赖
                runtimeService.deleteProcessInstance(delegateTask.getProcessInstanceId(), "审批人为空,自动驳回");
            }
        }
        // 设置自动通过
        if (AutoTask.AUTO.getKey().equals(delegateTask.getVariable(AUTO_TASK))) {
            taskService.addComment(delegateTask.getId(), delegateTask.getProcessInstanceId(), CommentTypeEnum.OPINION.getType(), "流程设置了自动通过");
            taskService.setVariableLocal(delegateTask.getId(), ProcessConstant.PROCESS_ACTION, ProcessActionType.AGREE.name());
            taskService.complete(delegateTask.getId());
        }
    }


}
