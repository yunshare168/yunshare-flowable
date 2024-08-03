package com.yunshare.core.engine.assignee;

import com.yunshare.core.engine.AssigneeHandler;
import com.yunshare.core.enums.OrgEnum;
import com.yunshare.core.tool.utils.CollectionUtil;
import com.yunshare.modules.dto.bpm.NodeConfig;
import com.yunshare.modules.dto.bpm.NodeOrg;
import org.assertj.core.util.Lists;
import org.flowable.engine.delegate.DelegateExecution;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>操作人员抽象类</p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/2/3 下午2:53
 */
public abstract class AbstractAssignee implements AssigneeHandler {
	@Override
	public List<String> userList(NodeConfig node, DelegateExecution execution, NodeConfig all) {
		List<NodeOrg> nodeList = node.getNodeOrgList();
		if (CollectionUtil.isNotEmpty(nodeList)) {
			return new ArrayList<>(0);
		}
		// 用户
		List<String> userIds = nodeList.stream().filter(e -> e.getOrgEnum().getType().equals(OrgEnum.USER.getType()))
			.map(NodeOrg::getId).collect(Collectors.toList());
		//部门下的用户
		// userIds.addAll(this.getUserListByDept(nodeList));
		//角色下的用户
		// userIds.addAll(this.getUserListByRole(nodeList));
		return userIds;
	}

	/**
	 * <p>根据部门ID 设置用户信息</p>
	 *
	 * @param orgList 部门选择节点
	 * @author lzx@yuyuda.com
	 * @since 2023/3/6 17:34
	 */
	private List<String> getUserListByDept(List<NodeOrg> orgList) {
		// 部门
		/*List<Long> depIds = orgList.stream().filter(e -> e.getOrgEnum().getType().equals(OrgEnum.DEPT.getType()))
			.map(NodeOrg::getId).map(Long::valueOf).collect(Collectors.toList());
		if (CollectionUtil.isEmpty(depIds)) {
			return Collections.emptyList();
		}
		IEsCorpUserService esCorpUser = SpringUtil.getBean(EsCorpUserServiceImpl.class);
		List<EsUserIndex> userIndexList = esCorpUser.userListByDeptId(depIds.toArray(new Long[0]));
		if (CollectionUtil.isEmpty(userIndexList)) {
			return Collections.emptyList();
		}
		return userIndexList.stream()
			.map(EsUserIndex::getId)
			.collect(Collectors.toList())
			.stream().map(String::valueOf)
			.collect(Collectors.toList());*/
		return Lists.emptyList();
	}

	/**
	 * <p>根据角色ID设置用户</p>
	 *
	 * @param roleList 角色选择节点
	 * @author lzx@yuyuda.com
	 * @since 2023/3/6 17:35
	 */
	private List<String> getUserListByRole(List<NodeOrg> roleList) {
		// 角色
		/*List<Long> roleIds = roleList.stream().filter(e -> e.getOrgEnum().getType().equals(OrgEnum.ROLE.getType()))
			.map(NodeOrg::getId).map(Long::valueOf).collect(Collectors.toList());
		if (CollectionUtil.isEmpty(roleIds)) {
			return Collections.emptyList();
		}
		IEsCorpUserService esCorpUser = SpringUtil.getBean(EsCorpUserServiceImpl.class);
		List<EsUserIndex> userIndexList = esCorpUser.userListByRoleId(roleIds.toArray(new Long[0]));
		if (CollectionUtil.isEmpty(userIndexList)) {
			return Collections.emptyList();
		}
		return userIndexList.stream()
			.map(EsUserIndex::getId)
			.collect(Collectors.toList())
			.stream()
			.map(String::valueOf)
			.collect(Collectors.toList());*/
		return Lists.emptyList();
	}
}
