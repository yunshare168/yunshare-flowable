package com.yunshare.core.mp.plugins;

import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.yunshare.core.mp.intercept.QueryInterceptor;
import lombok.Setter;
import lombok.SneakyThrows;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.core.Ordered;

/**
 * 拓展分页拦截器
 *
 * @author lzx@yuyuda.com
 */
@Setter
public class CustomPaginationInterceptor extends PaginationInnerInterceptor implements Ordered {

	/**
	 * 查询拦截器
	 */
	private QueryInterceptor[] queryInterceptors;

	@SneakyThrows
	@Override
	public boolean willDoQuery(Executor executor, MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler, BoundSql boundSql) {
		QueryInterceptorExecutor.exec(queryInterceptors, executor, ms, parameter, rowBounds, resultHandler, boundSql);
		return super.willDoQuery(executor, ms, parameter, rowBounds, resultHandler, boundSql);
	}

	@Override
	public int getOrder() {
		return LOWEST_PRECEDENCE;
	}
}
