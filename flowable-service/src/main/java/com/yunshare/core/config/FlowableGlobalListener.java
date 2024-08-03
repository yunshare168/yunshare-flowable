package com.yunshare.core.config;

import com.yunshare.core.listener.FlowCreateListener;
import com.yunshare.core.listener.TaskCompletedListener;
import lombok.RequiredArgsConstructor;
import org.flowable.common.engine.api.delegate.event.FlowableEngineEventType;
import org.flowable.common.engine.api.delegate.event.FlowableEventDispatcher;
import org.flowable.spring.SpringProcessEngineConfiguration;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * <p>全局监听器</p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/3/27 14:10
 */
@Configuration
@RequiredArgsConstructor
public class FlowableGlobalListener implements ApplicationListener<ContextRefreshedEvent> {

	private final SpringProcessEngineConfiguration configuration;
	private final TaskCompletedListener taskEndListener;
	private final FlowCreateListener flowCreateListener;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		FlowableEventDispatcher dispatcher = configuration.getEventDispatcher();
		dispatcher.addEventListener(taskEndListener, FlowableEngineEventType.TASK_COMPLETED,FlowableEngineEventType.PROCESS_CANCELLED);
		dispatcher.addEventListener(flowCreateListener, FlowableEngineEventType.PROCESS_CREATED);
	}
}
