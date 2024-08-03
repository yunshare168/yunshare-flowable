package com.yunshare.core.mp.support;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunshare.core.tool.support.Kv;
import com.yunshare.core.tool.utils.BeanUtil;
import com.yunshare.core.tool.utils.Func;
import com.yunshare.core.tool.utils.StringUtil;

import java.util.Map;

/**
 * 分页工具
 *
 * @author lzx@yuyuda.com
 */
public class Condition {

    /**
     * 转化成mybatis plus中的Page
     *
     * @param query            查询条件
     * @param camelToUnderline 驼峰转下划线
     * @return IPage
     */
    public static <T> IPage<T> getPage(Query query, boolean camelToUnderline) {
        Page<T> page = new Page<>(Func.toInt(query.getPage(), 1), Func.toInt(query.getLimit(), 10));
        String[] ascArr = Func.toStrArray(query.getAscs());
        for (String asc : ascArr) {
            page.addOrder(OrderItem.asc(StringUtil.cleanIdentifier(camelToUnderline ? StringUtil.humpToUnderline(asc) : asc)));
        }
        String[] descArr = Func.toStrArray(query.getDescs());
        for (String desc : descArr) {
            page.addOrder(OrderItem.desc(StringUtil.cleanIdentifier(camelToUnderline ? StringUtil.humpToUnderline(desc) : desc)));
        }
        return page;
    }

    /**
     * 转化成mybatis plus中的Page
     *
     * @param query 查询条件
     * @return IPage
     */
    public static <T> IPage<T> getPage(Query query) {
        return getPage(query, true);
    }

    /**
     * 获取mybatis plus中的QueryWrapper
     *
     * @param entity 实体
     * @param <T>    类型
     * @return QueryWrapper
     */
    public static <T> QueryWrapper<T> getQueryWrapper(T entity) {
        return new QueryWrapper<>(entity);
    }

    /**
     * 获取mybatis plus中的QueryWrapper
     *
     * @param query            查询条件
     * @param clazz            实体类
     * @param <T>              类型
     * @return QueryWrapper
     */
    public static <T> QueryWrapper<T> getQueryWrapper(Map<String, Object> query, Class<T> clazz) {
        Kv exclude = Kv.create().set("current", "current").set("size", "size").set("page", "page").set("limit", "limit").set("ascs", "ascs").set("descs", "descs");
        return getQueryWrapper(query, exclude, clazz);
    }

    /**
     * 获取mybatis plus中的QueryWrapper
     *
     * @param query            查询条件
     * @param exclude          排除的查询条件
     * @param clazz            实体类
     * @param <T>              类型
     * @return QueryWrapper
     */
    public static <T> QueryWrapper<T> getQueryWrapper(Map<String, Object> query, Map<String, Object> exclude, Class<T> clazz) {
        exclude.forEach((k, v) -> query.remove(k));
        QueryWrapper<T> qw = new QueryWrapper<>();
        qw.setEntity(BeanUtil.newInstance(clazz));
        SqlKeyword.buildCondition(query, qw);
        return qw;
    }

}
