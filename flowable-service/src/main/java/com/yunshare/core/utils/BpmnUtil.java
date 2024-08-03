package com.yunshare.core.utils;

import com.yunshare.modules.dto.bpm.NodeConfig;
import org.apache.commons.lang3.StringUtils;
import org.flowable.bpmn.converter.BpmnXMLConverter;
import org.flowable.bpmn.model.BpmnModel;
import org.flowable.common.engine.impl.util.io.StringStreamSource;
import org.flowable.editor.language.json.converter.BpmnJsonConverter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>bpmn工具类</p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/28 下午10:49
 */
public class BpmnUtil {
	private static final BpmnJsonConverter BPMN_JSON_CONVERTER = new BpmnJsonConverter();
	private static final BpmnXMLConverter BPMN_XML_CONVERTER = new BpmnXMLConverter();

	/**
	 * <p>xml转bpmnModel</p>
	 *
	 * @param xml xml
	 * @return org.flowable.bpmn.model.BpmnModel
	 * @author lzx@yuyuda.com
	 * @since 2023/1/17 下午1:41
	 */
	public static BpmnModel getBpmnModel(String xml) {
		return BPMN_XML_CONVERTER.convertToBpmnModel(new StringStreamSource(xml), false, false);
	}

	/**
	 * <p>bpmn转json</p>
	 *
	 * @param xml xml
	 * @return java.lang.String
	 * @author lzx@yuyuda.com
	 * @since 2023/1/17 下午2:24
	 */
	public static String getBpmnJson(String xml) {
		return BPMN_JSON_CONVERTER.convertToJson(getBpmnModel(xml)).toString();
	}

	/**
	 * <p>根据节点ID获取ID所在节点</p>
	 * @return com.yunshare.modules.dto.bpm.NodeConfig
	 * @author lzx@yuyuda.com
	 * @since 2023/1/31 下午3:31
	 */
	public static NodeConfig getCurrNode(NodeConfig childNode, String nodeId) {
		Map<String, NodeConfig> childNodeMap = new HashMap<>(15);
		if (StringUtils.isNotBlank(childNode.getNodeId())) {
			getChildNode(childNode, childNodeMap);
		}
		Set<String> set = childNodeMap.keySet();
		for (String s : set) {
			if (StringUtils.isNotBlank(s)) {
				if (s.equals(nodeId)) {
					return childNodeMap.get(s);
				}
			}
		}
		return null;
	}

	/**
	 * <p>处理子节点</p>
	 * @author lzx@yuyuda.com
	 * @since 2023/1/31 下午3:32
	 */
	private static void getChildNode(NodeConfig childNode, Map<String, NodeConfig> childNodeMap) {
		childNodeMap.put(childNode.getNodeId(), childNode);
		List<NodeConfig> conditionNodes = childNode.getConditionNodes();
		NodeConfig children = childNode.getChildNode();
		if (conditionNodes != null && conditionNodes.size() > 0) {
			for (NodeConfig conditionNode : conditionNodes) {
				if (StringUtils.isNotBlank(conditionNode.getNodeId())) {
					childNodeMap.put(conditionNode.getNodeId(), conditionNode);
					getChildNode(conditionNode, childNodeMap);
				}
			}
		}
		if (children != null) {
			childNodeMap.put(children.getNodeId(), children);
			getChildNode(children, childNodeMap);
		}
	}
}
