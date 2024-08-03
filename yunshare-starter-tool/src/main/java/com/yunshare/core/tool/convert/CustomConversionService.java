package com.yunshare.core.tool.convert;

import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.lang.Nullable;
import org.springframework.util.StringValueResolver;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 类型 转换 服务，添加了 IEnum 转换
 *
 * @author lzx@yuyuda.com
 */
public class CustomConversionService extends ApplicationConversionService {
	@Nullable
	private static final AtomicReference<CustomConversionService> SHARED_INSTANCE = new AtomicReference<>();

	public CustomConversionService() {
		this(null);
	}

	public CustomConversionService(@Nullable StringValueResolver embeddedValueResolver) {
		super(embeddedValueResolver);
		super.addConverter(new EnumToStringConverter());
		super.addConverter(new StringToEnumConverter());
	}

	/**
	 * Return a shared default application {@code ConversionService} instance, lazily
	 * building it once needed.
	 * <p>
	 * Note: This method actually returns an {@link CustomConversionService}
	 * instance. However, the {@code ConversionService} signature has been preserved for
	 * binary compatibility.
	 * @return the shared {@code ConversionService} instance (never{@code null})
	 */
	public static GenericConversionService getInstance() {
		CustomConversionService sharedInstance = Objects.requireNonNull(CustomConversionService.SHARED_INSTANCE).get();
		if (sharedInstance == null) {
			synchronized (CustomConversionService.class) {
				sharedInstance = CustomConversionService.SHARED_INSTANCE.get();
				if (sharedInstance == null) {
					sharedInstance = new CustomConversionService();
					CustomConversionService.SHARED_INSTANCE.set(sharedInstance) ;
				}
			}
		}
		return sharedInstance;
	}

}
