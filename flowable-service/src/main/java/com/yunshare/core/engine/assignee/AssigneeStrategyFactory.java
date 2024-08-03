package com.yunshare.core.engine.assignee;

import com.yunshare.core.engine.AssigneeHandler;
import com.yunshare.core.tool.exception.ServiceException;
import com.yunshare.core.tool.utils.SpringUtil;
import com.yunshare.modules.dto.bpm.NodeConfig;
import org.flowable.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * <p>审批人查找策略工厂</p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/30 下午1:13
 */
@Component
public class AssigneeStrategyFactory {

	/**
	 * <p>查询用户列表</p>
	 * @param node 当前节点
	 * @param execution 执行对象
	 * @param all 所有节点数据
	 * @return java.util.List<java.lang.String>
	 * @author lzx@yuyuda.com
	 * @since 2023/1/30 下午1:35
	 */
	public List<String> findUsers(NodeConfig node, DelegateExecution execution, NodeConfig all) {
		String beanId = node.getMemberType().getBeanId();
		AssigneeHandler handler = SpringUtil.getBean(beanId);
		if (Objects.isNull(handler)) {
			throw new ServiceException(String.format("审批人处理器没有配置， beanId=[%s]", beanId));
		}
		return handler.userList(node, execution, all);
	}
}
