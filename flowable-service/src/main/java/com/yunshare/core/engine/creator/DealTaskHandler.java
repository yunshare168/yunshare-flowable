package com.yunshare.core.engine.creator;

import com.yunshare.core.constant.ProcessConstant;
import com.yunshare.core.engine.NodeHandler;
import org.springframework.stereotype.Component;

/**
 * <p>流程办理节点生成器</p>
 * @author lzx@yuyuda.com
 * @since 2023/2/28 下午7:19
 */
@Component
public class DealTaskHandler extends AbstractNodeHandler implements NodeHandler {

	@Override
	public String getNodeIdPrefix() {
		return ProcessConstant.USER_TASK_ID;
	}
}
