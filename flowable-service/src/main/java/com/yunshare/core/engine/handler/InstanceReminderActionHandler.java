package com.yunshare.core.engine.handler;

import com.yunshare.core.engine.ActionHandler;
import com.yunshare.modules.dto.ProcessActionResultDTO;
import com.yunshare.modules.dto.ProcessReqParamDTO;
import org.springframework.stereotype.Component;

/**
 * 流程催办
 *
 * @author lzx@yuyuda.com
 * @since 2022/10/9 14:36
 */
@Component
public class InstanceReminderActionHandler implements ActionHandler {
	@Override
	public ProcessActionResultDTO execute(ProcessReqParamDTO param) {
		return null;
	}
}
