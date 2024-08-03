package com.yunshare.core.engine.handler;

import com.yunshare.core.engine.ActionHandler;
import com.yunshare.modules.dto.ProcessActionResultDTO;
import com.yunshare.modules.dto.ProcessReqParamDTO;
import com.yunshare.modules.service.IYunshareFlowCcService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 撤销流程
 *
 * @author lzx@yuyuda.com
 * @since 2022/10/9 14:30
 */
@Component
public class InstanceDeleteActionHandler implements ActionHandler {
    @Resource
    private RuntimeService runtimeService;
    @Resource
    private IYunshareFlowCcService ccService;
    @Resource
    protected TaskService taskService;

    @Override
    public ProcessActionResultDTO execute(ProcessReqParamDTO param) {
        /*try {
            //更新流程业务状态
            this.updateBusinessStatus(param.getProcessInstanceId(), ProcessActionType.RECOVER.name());
            ProcessInstance instance = runtimeService.createProcessInstanceQuery().processInstanceId(param.getProcessInstanceId()).singleResult();
            if (instance != null) {
                //添加流程撤销备注
                taskService.addComment(null, param.getProcessInstanceId(), param.getAction().name(), "撤回");
                //流程撤销
                runtimeService.deleteProcessInstance(param.getProcessInstanceId(), param.getAction().name());
            } else {
                CommentDTO commentDTO = new CommentDTO();
                commentDTO.setMessage("撤回");
                //添加评论
                commentService.addComment(param.getProcessInstanceId(), param.getTaskId(), commentDTO, param.getAction().name());
                //流程已经结束，手动处理通知以及同步es
                //更新索引
                ProcessUtil.transactionCommitSync(EsSyncMessage.MsgEnum.UPDATE_INDEX, Collections.singleton(param.getProcessInstanceId()));
                //发送消息通知
                SpringUtil.publishEvent(new TransactionCommitNotifyEvent(param.getProcessInstanceId()));
            }
        } catch (Exception e) {
            throw new ServiceException("流程撤销失败");
        }
        //如果撤销成功，标记抄送的信息为撤销
        ccService.update(Wrappers.lambdaUpdate(YunshareFlowCc.class)
                .set(YunshareFlowCc::getIsWithdraw, SysConstant.DB_STATUS_NORMAL)
                .eq(YunshareFlowCc::getProcessInstanceId, param.getProcessInstanceId()));*/
        return null;
    }

}
