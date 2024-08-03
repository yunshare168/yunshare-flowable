package com.yunshare.core.mp.service;

import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.yunshare.core.mp.base.BaseEntity;
import com.yunshare.core.mp.injector.CustomSqlMethod;
import com.yunshare.core.mp.mapper.YunshareMapper;
import com.yunshare.core.tool.constant.SysConstant;
import com.yunshare.core.tool.utils.BeanUtil;
import com.yunshare.core.tool.utils.DateUtil;
import lombok.SneakyThrows;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * yunshareService 实现类（ 泛型：M 是 mapper 对象，T 是实体 ， PK 是主键泛型 ）
 *
 * @author lzx@yuyuda.com
 */
@Validated
public class YunshareServiceImpl<M extends YunshareMapper<T>, T extends BaseEntity> extends BaseServiceImpl<M, T> implements YunshareService<T> {

    @Override
    public T saveSelective(T entity) {
        this.resolveEntity(entity);
        return super.saveSelective(entity);
    }

    @Override
    public boolean save(T entity) {
        this.resolveEntity(entity);
        return super.save(entity);
    }

    @Override
    public boolean saveBatch(Collection<T> entityList, int batchSize) {
        entityList.forEach(this::resolveEntity);
        return super.saveBatch(entityList, batchSize);
    }

    @Override
    public T updateByIdSelective(T entity) {
        this.resolveEntity(entity);
        return super.updateByIdSelective(entity);
    }

    @Override
    public boolean updateById(T entity) {
        this.resolveEntity(entity);
        return super.updateById(entity);
    }


    @Override
    public boolean updateBatchById(Collection<T> entityList, int batchSize) {
        entityList.forEach(this::resolveEntity);
        return super.updateBatchById(entityList, batchSize);
    }

    @Override
    public boolean saveOrUpdate(T entity) {
        if (entity.getId() == null) {
            return this.save(entity);
        } else {
            return this.updateById(entity);
        }
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<T> entityList, int batchSize) {
        entityList.forEach(this::resolveEntity);
        return super.saveOrUpdateBatch(entityList, batchSize);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteLogic(@NotEmpty List<Long> ids) {
        List<T> list = new ArrayList<>();
        ids.forEach(id -> {
            T entity = BeanUtil.newInstance(currentModelClass());
            entity.setUpdateTime(DateUtil.now());
            entity.setId(id);
            list.add(entity);
        });
        return super.updateBatchById(list) && super.removeByIds(ids);
    }


    @Override
    public boolean saveIgnore(T entity) {
        return SqlHelper.retBool(baseMapper.insertIgnore(entity));
    }

    @Override
    public boolean saveReplace(T entity) {
        return SqlHelper.retBool(baseMapper.replace(entity));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveIgnoreBatch(Collection<T> entityList, int batchSize) {
        return saveBatch(entityList, batchSize, CustomSqlMethod.INSERT_IGNORE_ONE);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveReplaceBatch(Collection<T> entityList, int batchSize) {
        return saveBatch(entityList, batchSize, CustomSqlMethod.REPLACE_ONE);
    }

    @Override
    public T saveOrUpdateSelective(T entity) {
        if (entity.getId() == null) {
            return this.saveSelective(entity);
        } else {
            return this.updateByIdSelective(entity);
        }
    }

    private boolean saveBatch(Collection<T> entityList, int batchSize, CustomSqlMethod sqlMethod) {
        String sqlStatement = sqlStatement(sqlMethod);
        executeBatch(entityList, batchSize, (sqlSession, entity) -> sqlSession.insert(sqlStatement, entity));
        return true;
    }

    /**
     * 获取 sqlStatement
     *
     * @param sqlMethod ignore
     * @return sql
     */
    protected String sqlStatement(CustomSqlMethod sqlMethod) {
        return SqlHelper.table(currentModelClass()).getSqlStatement(sqlMethod.getMethod());
    }

    @SneakyThrows
    private void resolveEntity(T entity) {
        Date now = DateUtil.now();
        if (entity.getId() == null) {
            // 处理新增逻辑
            entity.setCreateTime(now);
        }
        // 处理通用逻辑
        entity.setUpdateTime(now);
        entity.setIsDeleted(SysConstant.DB_NOT_DELETED);
    }
}
