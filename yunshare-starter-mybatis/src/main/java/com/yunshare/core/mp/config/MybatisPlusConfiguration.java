
package com.yunshare.core.mp.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.InnerInterceptor;
import com.yunshare.core.mp.injector.CustomSqlInjector;
import com.yunshare.core.mp.intercept.QueryInterceptor;
import com.yunshare.core.mp.plugins.CustomPaginationInterceptor;
import com.yunshare.core.mp.plugins.SqlLogInterceptor;
import com.yunshare.core.mp.props.MybatisPlusProperties;
import com.yunshare.core.mp.resolver.PageArgumentResolver;
import com.yunshare.core.tool.utils.ObjectUtil;
import lombok.AllArgsConstructor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * mybatis-plus 配置
 *
 * @author lzx@yuyuda.com
 */
@Configuration(proxyBeanMethods = false)
@AllArgsConstructor
@MapperScan("com.yunshare.**.mapper.**")
@EnableConfigurationProperties(MybatisPlusProperties.class)
public class MybatisPlusConfiguration implements WebMvcConfigurer {


    /**
     * 自定义分页拦截器
     */
    @Bean
    @ConditionalOnMissingBean(CustomPaginationInterceptor.class)
    public CustomPaginationInterceptor customPaginationInterceptor(ObjectProvider<QueryInterceptor[]> queryInterceptors,
                                                                   MybatisPlusProperties mybatisPlusProperties) {
        // 配置分页拦截器
        CustomPaginationInterceptor paginationInterceptor = new CustomPaginationInterceptor();
        // 配置自定义查询拦截器
        QueryInterceptor[] queryInterceptorArray = queryInterceptors.getIfAvailable();
        if (ObjectUtil.isNotEmpty(queryInterceptorArray)) {
            AnnotationAwareOrderComparator.sort(queryInterceptorArray);
            paginationInterceptor.setQueryInterceptors(queryInterceptorArray);
        }
        paginationInterceptor.setMaxLimit(mybatisPlusProperties.getPageLimit());
        paginationInterceptor.setOverflow(mybatisPlusProperties.getOverflow());
        paginationInterceptor.setOptimizeJoin(mybatisPlusProperties.getOptimizeJoin());
        return paginationInterceptor;
    }

    /**
     * mybatis-plus 拦截器集合
     */
    @Bean
    @ConditionalOnBean(InnerInterceptor.class)
    @ConditionalOnMissingBean(MybatisPlusInterceptor.class)
    public MybatisPlusInterceptor mybatisPlusInterceptor(List<InnerInterceptor> innerInterceptorList) {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.setInterceptors(innerInterceptorList);
        return interceptor;
    }

    /**
     * sql 日志
     */
    @Bean
    public SqlLogInterceptor sqlLogInterceptor(MybatisPlusProperties mybatisPlusProperties) {
        return new SqlLogInterceptor(mybatisPlusProperties);
    }

    /**
     * sql 注入
     */
    @Bean
    @ConditionalOnMissingBean(ISqlInjector.class)
    public ISqlInjector sqlInjector() {
        return new CustomSqlInjector();
    }

    /**
     * page 解析器
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new PageArgumentResolver());
    }

}

