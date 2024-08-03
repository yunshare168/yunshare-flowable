package com.yunshare.core.engine.assignee;

import com.yunshare.core.engine.AssigneeHandler;
import com.yunshare.core.enums.MemberType;
import com.yunshare.core.enums.NodeType;
import com.yunshare.modules.dto.bpm.NodeConfig;
import org.flowable.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.yunshare.core.constant.ProcessConstant.MEMBER_TYPE;
import static com.yunshare.core.constant.ProcessConstant.MEMBER_TYPE_CC;


/**
 * <p>创建人自选</p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/30 下午1:20
 */
@Component
public class SelfChoiceHandler implements AssigneeHandler {
	@Override
	public List<String> userList(NodeConfig node, DelegateExecution execution, NodeConfig all) {
		if (node.getNodeType().getNodeType().equals(NodeType.CC.getNodeType())) {
			// 如果是抄送节点
			execution.setVariable(MEMBER_TYPE_CC, MemberType.SELF_CHOICE.getType());
		} else {
			// 除抄送外的其他模式
			execution.setVariable(MEMBER_TYPE, MemberType.SELF_CHOICE.getType());
		}
		return new ArrayList<>(0);
	}
}
