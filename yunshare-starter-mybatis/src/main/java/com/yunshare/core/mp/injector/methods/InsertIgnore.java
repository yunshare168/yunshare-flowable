package com.yunshare.core.mp.injector.methods;


import com.yunshare.core.mp.injector.CustomSqlMethod;

/**
 * 插入一条数据（选择字段插入）插入如果中已经存在相同的记录，则忽略当前新数据
 *
 * @author lzx@yuyuda.com
 */
public class InsertIgnore extends AbstractInsertMethod {

	public InsertIgnore() {
		super(CustomSqlMethod.INSERT_IGNORE_ONE);
	}
}
