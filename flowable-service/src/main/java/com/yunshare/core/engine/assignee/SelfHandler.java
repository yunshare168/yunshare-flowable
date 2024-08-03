package com.yunshare.core.engine.assignee;

import com.yunshare.core.constant.ProcessConstant;
import com.yunshare.core.engine.AssigneeHandler;
import com.yunshare.core.tool.utils.StringUtil;
import com.yunshare.modules.dto.bpm.NodeConfig;
import org.flowable.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>创建人自己</p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/30 下午1:20
 */
@Component
public class SelfHandler implements AssigneeHandler {
	@Override
	public List<String> userList(NodeConfig node, DelegateExecution execution, NodeConfig all) {
		String variable = (String) execution.getVariable(ProcessConstant.START_USER_VAL);
		List<String> userList = new ArrayList<>(1);
		if (StringUtil.hasText(variable)) {
			userList.add(variable);
		}
		return userList;
	}
}
