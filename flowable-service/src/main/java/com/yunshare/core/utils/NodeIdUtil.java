package com.yunshare.core.utils;

import com.yunshare.core.tool.utils.StringUtil;
import lombok.experimental.UtilityClass;

import static com.yunshare.core.constant.ProcessConstant.*;

/**
 * @author lzx@yuyuda.com
 * @since 2023/7/14 15:03
 */
@UtilityClass
public class NodeIdUtil {


    /**
     * <p>移除节点ID前缀</p>
     *
     * @param nodeId 节点ID
     * @return {@link String}
     * @author lzx@yuyuda.com
     * @since 2023/7/14 15:05
     */
    public String removePrefix(String nodeId) {
        if (StringUtil.isEmpty(nodeId)) {
            return nodeId;
        }
        if (nodeId.startsWith(USER_TASK_ID)) {
            nodeId = StringUtil.removePrefix(nodeId, USER_TASK_ID);
        }
        if (nodeId.startsWith(SERVICE_TASK_ID)) {
            nodeId = StringUtil.removePrefix(nodeId, SERVICE_TASK_ID);
        }
        if (nodeId.startsWith(EXCLUSIVE_GATEWAY_ID)) {
            nodeId = StringUtil.removePrefix(nodeId, EXCLUSIVE_GATEWAY_ID);
        }
        if (nodeId.startsWith(PARALLEL_GATEWAY_ID)) {
            nodeId = StringUtil.removePrefix(nodeId, PARALLEL_GATEWAY_ID);
        }
        return nodeId;
    }

}
