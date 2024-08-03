package com.yunshare.core.constant;

/**
 * <p>流程常量</p>
 *
 * @author lzx@yuyuda.com
 * @since 2022/9/30 11:33
 */
public interface ProcessConstant {

    String SUFFIX = ".bpmn20.xml";

    String ACTIVE = "active";

    String SUSPEND = "suspend";

    String STATUS_TODO = "todo";

    String STATUS_CLAIM = "claim";

    String STATUS_FINISHED = "finished";
    /**
     * 未完成
     */
    String STATUS_UNFINISHED = "unfinished";
    /**
     * 完成
     */
    String STATUS_FINISH = "finish";
    /**
     * 开始事件
     */
    String START_EVENT = "startEvent";
    /**
     * 结束事件
     */
    String END_EVENT = "endEvent";

    /**
     * 同意标识
     */
    String PASS_KEY = "pass";

    /**
     * 同意默认批复
     */
    String PASS_COMMENT = "同意";

    /**
     * Flowable前缀
     */
    String FLOWABLE_ID = "Flowable_";

    /**
     * 开始节点前缀
     */
    String START_EVENT_ID = "startEventNode_";

    /**
     * 结束节点前缀
     */
    String END_EVENT_ID = "endEventNode_";

    /**
     * 网关前缀
     */
    String EXCLUSIVE_GATEWAY_ID = "exclusiveGateway_";

    /**
     * 并行网关前缀
     */
    String PARALLEL_GATEWAY_ID = "parallelGateway_";

    /**
     * 抄送节点前缀
     */
    String SERVICE_TASK_ID = "serviceTask_";

    /**
     * 任务节点前缀
     */
    String USER_TASK_ID = "userTask_";

    /**
     * 系列流前缀
     */
    String SEQUENCE_FLOW_ID = "sequenceFlow_";

    /**
     * flowable扩展属性名
     */
    String FLOW_EXT_NAME = "MCloud";

    /**
     * 扩展属性命名空间
     */
    String FLOW_EXT_NAMESPACE = "http://flowable.org/bpmn";

    /**
     * 无人标识变量
     */
    String NOBODY_VAL = "NOBODY";

    /**
     * 无操作人标识
     */
    String NOBODY = "100000";

    /**
     * 设置自动通过标识
     */
    String AUTO = "100001";

    /**
     * 发起人变量
     */
    String START_USER_VAL = "START_USER";

    /**
     * <p>审批人列表变量</p>
     */
    String ASSIGNEE_LIST = "assigneeList";

    /**
     * 自动审批通过变量
     */
    String AUTO_TASK = "AutoTask";

    /**
     * 流程选择成员类型变量
     */
    String MEMBER_TYPE = "MEMBER_TYPE";

    /**
     * 抄送选择成员变量
     */
    String MEMBER_TYPE_CC = "MEMBER_TYPE_CC";

    /**
     * 申请客户端
     */
    String APPLY_CLIENT = "APPLY_CLIENT";

    /**
     * 系统生成，流程申请单号
     */
    String APPLY_SN = "APPLY_SN";

    /**
     * 表达式开始部分
     */
    String START_EXPRESSION = "${";

    /**
     * 表达式结束部分
     */
    String END_EXPRESSION = "}";

    /**
     * 表达式处理工具类
     */
    String EXPRESSION_CLASS = "expressionUtil.";

    /**
     * 流程动作
     */
    String PROCESS_ACTION = "PROCESS_ACTION";

    /**
     * 会签结束
     */
    String MI_END  = "MI_END";


}
