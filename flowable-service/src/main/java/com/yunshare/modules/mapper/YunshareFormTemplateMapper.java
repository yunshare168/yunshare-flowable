package com.yunshare.modules.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yunshare.modules.dto.form.YunshareFormTemplatePageInput;
import com.yunshare.modules.entity.YunshareFormTemplate;
import org.apache.ibatis.annotations.Mapper;

/**
* 公共服务-表单(yunshareForm)
*
* @author lzx@yuyuda.com
* @since 2022-09-28 11:18:11
*/
@Mapper
public interface YunshareFormTemplateMapper extends BaseMapper<YunshareFormTemplate> {
	/**
	 * <p>表单分页列表</p >
	 *
	 * @param page 分页结果对象
	 * @param input 分页入参对象
	 * @return com.yunshare.core.tool.api.R<com.baomidou.mybatisplus.core.metadata.IPage<com.yunshare.modules.model.yunshareForm>>
	 * @author lzx@yuyuda.com
	 * @since 2023/1/11 14:12
	 *
	 **/
	IPage<YunshareFormTemplate> pageList(IPage<YunshareFormTemplate> page, YunshareFormTemplatePageInput input);

}
