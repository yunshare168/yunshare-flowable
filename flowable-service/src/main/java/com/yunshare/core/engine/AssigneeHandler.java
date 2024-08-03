package com.yunshare.core.engine;

import com.yunshare.modules.dto.bpm.NodeConfig;
import org.flowable.engine.delegate.DelegateExecution;

import java.util.List;

/**
 * <p>审批人查找处理器</p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/30 下午1:12
 */
public interface AssigneeHandler {
	/**
	 * <p>查询用户列表</p>
	 * @param node 当前节点
	 * @param execution 执行对象
	 * @param all 所有节点数据
	 * @return java.util.List<java.lang.String>
	 * @author lzx@yuyuda.com
	 * @since 2023/1/30 下午1:34
	 */
	List<String> userList(NodeConfig node, DelegateExecution execution, NodeConfig all);
}
