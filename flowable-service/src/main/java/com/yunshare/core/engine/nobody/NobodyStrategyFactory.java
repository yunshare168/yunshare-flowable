package com.yunshare.core.engine.nobody;

import com.yunshare.core.engine.NobodyHandler;
import com.yunshare.core.tool.exception.ServiceException;
import com.yunshare.core.tool.utils.SpringUtil;
import com.yunshare.modules.dto.bpm.NodeConfig;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

/**
 * <p>无处理人策略工厂</p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/30 下午1:49
 */
@Component
public class NobodyStrategyFactory {

	public Map<String, Object> nobody(NodeConfig node) {
		String beanId = node.getNoHandlerAction().getBeanId();
		NobodyHandler handler = SpringUtil.getBean(beanId);
		if (Objects.isNull(handler)) {
			throw new ServiceException(String.format("无审批人处理器没有配置， beanId=[%s]", beanId));
		}
		return handler.handle(node);
	}
}
