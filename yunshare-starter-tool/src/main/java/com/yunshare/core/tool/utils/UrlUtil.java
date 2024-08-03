
package com.yunshare.core.tool.utils;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;

/**
* @description: url处理工具类
* @author: lzx@yuyuda.com
* @date: 2022/3/30 14:24
*/
public class UrlUtil extends org.springframework.web.util.UriUtils {

	/**
	 * url 编码
	 *
	 * @param source source
	 * @return sourced String
	 */
	public static String encode(String source) {
		return encode(source, Charsets.UTF_8);
	}

	/**
	 * url 解码
	 *
	 * @param source source
	 * @return decoded String
	 */
	public static String decode(String source) {
		return decode(source, Charsets.UTF_8);
	}

	/**
	 * url 编码
	 *
	 * @param source  url
	 * @param charset 字符集
	 * @return 编码后的url
	 */
	@Deprecated
	public static String encodeURL(String source, Charset charset) {
		return UrlUtil.encode(source, charset.name());
	}

	/**
	 * url 解码
	 *
	 * @param source  url
	 * @param charset 字符集
	 * @return 解码url
	 */
	@Deprecated
	public static String decodeURL(String source, Charset charset) {
		return UrlUtil.decode(source, charset.name());
	}

	/**
	 * 获取url路径
	 *
	 * @param uriStr 路径
	 * @return url路径
	 */
	public static String getPath(String uriStr) {
		URI uri;

		try {
			uri = new URI(uriStr);
		} catch (URISyntaxException var3) {
			throw new RuntimeException(var3);
		}

		return uri.getPath();
	}

}
