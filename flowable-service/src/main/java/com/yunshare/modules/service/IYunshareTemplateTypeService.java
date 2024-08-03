package com.yunshare.modules.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yunshare.core.mp.service.YunshareService;
import com.yunshare.modules.dto.TemplateTypeDTO;
import com.yunshare.modules.dto.TemplateTypePageDTO;
import com.yunshare.modules.entity.YunshareTemplateType;
import com.yunshare.modules.vo.YunshareTemplateTypeShortVO;
import com.yunshare.modules.vo.YunshareTemplateTypeVO;

import java.util.List;

/**
* 工单模板类型(yunshareTemplateType)服务
*
* @author lzx@yuyuda.com
* @since 2023/1/9
*/
public interface IYunshareTemplateTypeService extends YunshareService<YunshareTemplateType> {
	/**
	 * <p>分页</p>
	 *
	 * @param page 分页
	 * @param input 搜索信息
	 * @return IPage<com.yunshare.modules.vo.yunshareTemplateTypeVO>
	 * @author lzx@yuyuda.com
	 * @since 2023/1/9 1:19 下午
	 */
	IPage<YunshareTemplateTypeVO> page(IPage<YunshareTemplateTypeVO> page, TemplateTypePageDTO input);

	/**
	 * <p>选择列表</p>
	 *
	 * @return java.util.List<com.yunshare.modules.vo.yunshareTemplateTypeShortVO>
	 * @author lzx@yuyuda.com
	 * @since 2023/1/9 1:19 下午
	 */
	List<YunshareTemplateTypeShortVO> select();

	/**
	 * <p>新增</p>
	 *
	 * @param input 新增信息
	 * @return com.yunshare.modules.model.yunshareTemplateType
	 * @author lzx@yuyuda.com
	 * @since 2023/1/9 1:11 下午
	 */
	YunshareTemplateType add(TemplateTypeDTO input);

	/**
	 * <p>更新</p>
	 *
	 * @param input 更新信息
	 * @return com.yunshare.modules.model.yunshareTemplateType
	 * @author lzx@yuyuda.com
	 * @since 2023/1/9 1:12 下午
	 */
	YunshareTemplateType update(TemplateTypeDTO input);

	/**
	 * <p>详情</p>
	 *
	 * @param id 类型ID
	 * @return com.yunshare.modules.vo.YunshareTemplateTypeVO
	 * @author lzx@yuyuda.com
	 * @since 2023/1/9 1:13 下午
	 */
	YunshareTemplateTypeVO detail(Long id);
}

