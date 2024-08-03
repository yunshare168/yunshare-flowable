package com.yunshare.modules.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yunshare.core.mp.mapper.YunshareMapper;
import com.yunshare.modules.dto.form.YunshareFormDataPage;
import com.yunshare.modules.entity.YunshareFormData;
import com.yunshare.modules.vo.YunshareFormDataVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 公共服务-表单记录值(yunshareFormData)
 *
 * @author lzx@yuyuda.com
 * @since 2022-09-28 11:51:58
 */
@Mapper
public interface YunshareFormDataMapper extends YunshareMapper<YunshareFormData> {

	/**
	 * <p>详情</p>
	 *
	 * @param id 主键
	 * @return com.yunshare.common.vo.yunshareFormDataVO
	 * @author lzx@yuyuda.com
	 * @since 2022/9/29 15:08
	 */
	YunshareFormDataVO detail(@Param("id") Long id);


	/**
	 * <p>根据id获取表单值记录</p >
	 *
	 * @param id 表单值记录id
	 * @return com.yunshare.modules.model.yunshareFormData
	 * @author lzx@yuyuda.com
	 * @since 2023/1/10 17:11
	 *
	 **/
	YunshareFormData getFormDataById(Long id);

	/**
	 * <p>分页</p>
	 *
	 * @param page   分页参数
	 * @param entity 实体
	 * @return com.baomidou.mybatisplus.core.metadata.IPage<com.yunshare.common.vo.yunshareFormDataVO>
	 * @author lzx@yuyuda.com
	 * @since 2022/10/8 11:33
	 */
	IPage<YunshareFormDataVO> pageList(IPage<YunshareFormDataVO> page, @Param("entity") YunshareFormDataPage entity);

}
