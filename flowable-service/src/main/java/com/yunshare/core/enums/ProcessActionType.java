package com.yunshare.core.enums;

/**
 * @author lzx@yuyuda.com
 * @since 2022/10/9 09:20
 */
public enum ProcessActionType {
	/**
	 * 流程操作类型
	 */
	SAVE("保存", "taskSaveActionHandler"),
	START("启动", "instanceStartActionHandler"),
	AGREE("同意", "taskAgreeActionHandler"),
	TRANSACT("办理", "taskTransactActionHandler"),
	OPPOSE("反对", "taskOpposeActionHandler"),
	REJECT("驳回", "taskRejectActionHandler"),
	REJECT_START("驳回发起人", "taskReject2StartActionHandler"),
	COMMENT("评论", "taskCommentActionHandler"),
	RECOVER("撤销", "instanceDeleteActionHandler"),
	TASK_OPINION("审批历史", "instanceTaskOpinionActionHandler"),
	FLOW_IMAGE("流程图", "instanceImageActionHandler"),
	PRINT("打印", "instancePrintActionHandler"),
	MANUAL_END("人工终止", "instanceManualEndActionHandler"),
	LOCK("锁定", "taskLockActionHandler"),
	UNLOCK("解锁", "taskUnlockActionHandler"),
	TURN("转办", "taskTurnActionHandler"),
	REMINDER("催办", "instanceReminderActionHandler"),
	WITHDRAW("撤回", "instanceWithdrawActionHandler"),
	ADD_SIGN("加签", "addSignActionHandler"),
	END("流程结束", "null"),
	TASK_CLAIM("任务签收", "taskClaimActionHandler"),
	TASK_UN_CLAIM("任务取消签收", "taskUnClaimActionHandler"),
	TASK_DELETE("任务删除", "taskDeleteActionHandler"),


	;


	private String des = "";
	private String beanId = "";

	ProcessActionType(String name, String beanId) {
		this.des = name;
		this.beanId = beanId;
	}

	public String getDes() {
		return des;
	}

	public String getBeanId() {
		return beanId;
	}
}
