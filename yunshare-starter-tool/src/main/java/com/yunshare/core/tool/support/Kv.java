
package com.yunshare.core.tool.support;

import com.yunshare.core.tool.utils.Func;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 链式map
 *
 * @author jong
 */
public class Kv extends LinkedCaseInsensitiveMap<Object>  {

	private static final long serialVersionUID = 362498820763181267L;

	private Kv() {
		super();
	}


	/**
	 * 创建Kv
	 *
	 * @return Kv
	 */
	public static Kv create() {
		return new Kv();
	}

	public static <K, V> HashMap<K, V> newMap() {
		return new HashMap<>(16);
	}

	/**
	 * 设置列
	 *
	 * @param attr  属性
	 * @param value 值
	 * @return 本身
	 */
	public Kv set(String attr, Object value) {
		this.put(attr, value);
		return this;
	}

	/**
	 * 设置全部
	 *
	 * @param map 属性
	 * @return 本身
	 */
	public Kv setAll(Map<? extends String, ?> map) {
		if (map != null) {
			this.putAll(map);
		}
		return this;
	}

	/**
	 * 设置列，当键或值为null时忽略
	 *
	 * @param attr  属性
	 * @param value 值
	 * @return 本身
	 */
	public Kv setIgnoreNull(String attr, Object value) {
		if (attr != null && value != null) {
			set(attr, value);
		}
		return this;
	}

	public Object getObj(String key) {
		return super.get(key);
	}

	/**
	 * 获得特定类型值
	 *
	 * @param <T>          值类型
	 * @param attr         字段名
	 * @param defaultValue 默认值
	 * @return 字段值
	 */
	@SuppressWarnings("unchecked")
	public <T> T get(String attr, T defaultValue) {
		final Object result = get(attr);
		return (T) (result != null ? result : defaultValue);
	}

	/**
	 * 获得特定类型值
	 *
	 * @param attr 字段名
	 * @return 字段值
	 */
	public String getStr(String attr) {
		return Func.toStr(get(attr), null);
	}

	/**
	 * 获得特定类型值
	 *
	 * @param attr 字段名
	 * @return 字段值
	 */
	public Integer getInt(String attr) {
		return Func.toInt(get(attr), -1);
	}

	/**
	 * 获得特定类型值
	 *
	 * @param attr 字段名
	 * @return 字段值
	 */
	public Long getLong(String attr) {
		return Func.toLong(get(attr), -1L);
	}

	/**
	 * 获得特定类型值
	 *
	 * @param attr 字段名
	 * @return 字段值
	 */
	public Float getFloat(String attr) {
		return Func.toFloat(get(attr), null);
	}

	public Double getDouble(String attr) {
		return Func.toDouble(get(attr), null);
	}


	/**
	 * 获得特定类型值
	 *
	 * @param attr 字段名
	 * @return 字段值
	 */
	public Boolean getBool(String attr) {
		return Func.toBoolean(get(attr), null);
	}

	/**
	 * 获得特定类型值
	 *
	 * @param attr 字段名
	 * @return 字段值
	 */
	public byte[] getBytes(String attr) {
		return get(attr, null);
	}

	/**
	 * 获得特定类型值
	 *
	 * @param attr 字段名
	 * @return 字段值
	 */
	public Date getDate(String attr) {
		return get(attr, null);
	}

	/**
	 * 获得特定类型值
	 *
	 * @param attr 字段名
	 * @return 字段值
	 */
	public Time getTime(String attr) {
		return get(attr, null);
	}

	/**
	 * 获得特定类型值
	 *
	 * @param attr 字段名
	 * @return 字段值
	 */
	public Timestamp getTimestamp(String attr) {
		return get(attr, null);
	}

	/**
	 * 获得特定类型值
	 *
	 * @param attr 字段名
	 * @return 字段值
	 */
	public Number getNumber(String attr) {
		return get(attr, null);
	}

	@Override
	public Kv clone() {
		Kv clone = new Kv();
		clone.putAll(this);
		return clone;
	}

}
