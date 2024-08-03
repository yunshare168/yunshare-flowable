package com.yunshare.core.engine.nobody;

import com.yunshare.core.constant.ProcessConstant;
import com.yunshare.core.engine.NobodyHandler;
import com.yunshare.modules.dto.bpm.NodeConfig;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>转交管理员</p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/30 下午1:50
 */
@Component
public class TransferAdminHandler implements NobodyHandler {
	@Override
	public Map<String, Object> handle(NodeConfig node) {
		// IEsCorpUserService esCorpUser = SpringUtil.getBean(EsCorpUserServiceImpl.class);
		// EsUserIndex adminUser = esCorpUser.getAdminUser(AuthUtil.getCorpId());
		Map<String, Object> map = new HashMap<>(1);
		map.put(ProcessConstant.PASS_KEY, false);
		// map.put(NOBODY_VAL, adminUser.getId());
		return map;
	}
}
