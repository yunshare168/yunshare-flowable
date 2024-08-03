package com.yunshare.core.constant;

/**
 * 缓存常量
 *
 * @author lzx@yuyuda.com
 * @since 2023/7/24 17:10
 */
public interface FlowCacheConstant {

    /**
     * 流程缓存
     */
    String FLOW_CACHE = "flow";
    /**
     * 流程历史数据
     */
    String HISTORY_DATA = "flow:history_data";
    /**
     * 节点表单权限
     */
    String NODE_PERMISSION = "flow:node_permission";
    /**
     * 流程定义bpmModel
     */
    String PROCESS_DEFINITION_BPMN_MODEL = "flow:process_definition_bpmn_model";

    /**
     * 流程定义
     */
    String PROCESS_DEFINITION = "flow:process_definition";

    /**
     * 获取流程实例
     */
    String PROCESS_INSTANCE = "flow:process_instance";

    /**
     * 流程数据
     */
    String PROCESS_DATA = "flow:process_data";
}
