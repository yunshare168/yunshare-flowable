package com.yunshare.core.engine.creator;

import com.yunshare.core.engine.NodeHandler;
import org.springframework.stereotype.Component;

/**
 * <p>流程根节点生成器</p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/19 下午2:33
 */
@Component
public class RootHandler extends AbstractNodeHandler implements NodeHandler {

	@Override
	public String getNodeIdPrefix() {
		return null;
	}
}
