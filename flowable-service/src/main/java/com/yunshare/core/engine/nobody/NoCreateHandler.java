package com.yunshare.core.engine.nobody;

import com.yunshare.core.constant.ProcessConstant;
import com.yunshare.core.engine.NobodyHandler;
import com.yunshare.modules.dto.bpm.NodeConfig;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.yunshare.core.constant.ProcessConstant.NOBODY;
import static com.yunshare.core.constant.ProcessConstant.NOBODY_VAL;

/**
 * <p>不允许创建</p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/30 下午1:50
 */
@Component
public class NoCreateHandler implements NobodyHandler {
	@Override
	public Map<String, Object> handle(NodeConfig node) {
		Map<String, Object> map = new HashMap<>(2);
		map.put(ProcessConstant.PASS_KEY, false);
		map.put(NOBODY_VAL, NOBODY);
		return map;
	}
}
