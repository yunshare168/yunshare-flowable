package com.yunshare.core.mp.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.yunshare.core.mp.base.BaseService;
import com.yunshare.core.mp.support.Condition;
import org.springframework.validation.annotation.Validated;

import java.util.HashMap;
import java.util.List;

/**
 * 业务封装基础类
 *
 * @param <M> mapper
 * @param <T> model
 * @author lzx@yuyuda.com
 */
@Validated
public class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements BaseService<T> {

    @Override
    public T saveSelective(T entity) {
        boolean success = SqlHelper.retBool(getBaseMapper().insert(entity));
        return success ? entity : null;
    }

    @Override
    public T updateByIdSelective(T entity) {
        boolean success = SqlHelper.retBool(getBaseMapper().updateById(entity));
        return success ? entity : null;
    }

    @Override
    public T getOne(T entity) {
        return getBaseMapper().selectOne(Condition.getQueryWrapper(entity));
    }

    @Override
    public T getOne(HashMap<String, Object> params) {
        return getBaseMapper().selectOne(Condition.getQueryWrapper(params, getEntityClass()));
    }

    @Override
    public List<T> list(T entity) {
        return getBaseMapper().selectList(Condition.getQueryWrapper(entity));
    }

    @Override
    public List<T> list(HashMap<String, Object> params) {
        return getBaseMapper().selectList(Condition.getQueryWrapper(params, getEntityClass()));
    }

    @Override
    public IPage<T> page(IPage<T> page, T entity) {
        return getBaseMapper().selectPage(page, Condition.getQueryWrapper(entity));
    }

    @Override
    public IPage<T> page(IPage<T> page, HashMap<String, Object> params) {
        return getBaseMapper().selectPage(page, Condition.getQueryWrapper(params, getEntityClass()));
    }

}
