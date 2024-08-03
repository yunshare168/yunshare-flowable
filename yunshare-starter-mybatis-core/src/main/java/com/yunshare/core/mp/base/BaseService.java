
package com.yunshare.core.mp.base;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashMap;
import java.util.List;

/**
 * 基础业务接口
 *
 * @param <T>
 * @author lzx@yuyuda.com
 */
public interface BaseService<T> extends IService<T> {


    /**
     * 保存对象成功，并返回保存的对象，否则返回null
     *
     * @param entity
     * @return
     */
    T saveSelective(T entity);

    /**
     * 更新对象成功，并返回更新的对象，否则返回null
     *
     * @param entity
     * @return
     */
    T updateByIdSelective(T entity);

    /**
     * 查询单个对象
     *
     * @param entity 根据实体信息查询单个对象
     * @return
     */
    T getOne(T entity);


    /**
     * 返回单个对象
     *
     * @param params 根据map参数查询单个对象
     * @return
     */
    T getOne(HashMap<String, Object> params);

    /**
     * 查询list
     *
     * @param entity 根据实体信息查询List
     * @return
     */
    List<T> list(T entity);


    /**
     * 返回List
     *
     * @param params 根据map参数查询List
     * @return
     */
    List<T> list(HashMap<String, Object> params);


    /**
     * 分页查询
     *
     * @param page   分页对象
     * @param entity 传入对象进行条件筛选
     * @return
     */
    IPage<T> page(IPage<T> page, T entity);

    /**
     * 分页查询
     *
     * @param page   分页对象
     * @param params 传入map查询条件
     * @return
     */
    IPage<T> page(IPage<T> page, HashMap<String, Object> params);

}
