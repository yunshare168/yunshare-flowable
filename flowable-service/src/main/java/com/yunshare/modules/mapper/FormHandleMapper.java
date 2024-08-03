package com.yunshare.modules.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yunshare.modules.dto.data.FormDataDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * #数据字典表(BcDataDict)
 *
 * @author lzx@yuyuda.com
 * @since 2022-08-12 14:39:24
 */
@Mapper
public interface FormHandleMapper extends BaseMapper<FormDataDTO> {

	/**
	 * <p>查询表单数据</p>
	 *
	 * @param templateNo 表单业务号
	 * @return java.util.List<com.yunshare.from.FormDataDTO>
	 * @author lzx@yuyuda.com
	 * @since 2022/9/30 14:32
	 */
	List<FormDataDTO> queryFormData(@Param("templateNo") String templateNo);

	/**
	 * <p>查询表单数据(单条)</p>
	 *
	 * @param templateNo 表单业务号
	 * @return com.yunshare.from.FormDataDTO
	 * @author lzx@yuyuda.com
	 * @since 2022/10/8 17:39
	 */
	FormDataDTO queryByFormNo(@Param("templateNo") String templateNo);
}
