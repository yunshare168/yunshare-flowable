package com.yunshare.modules.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yunshare.core.mp.mapper.YunshareMapper;
import com.yunshare.modules.dto.TemplateTypePageDTO;
import com.yunshare.modules.entity.YunshareTemplateType;
import com.yunshare.modules.vo.YunshareTemplateTypeShortVO;
import com.yunshare.modules.vo.YunshareTemplateTypeVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* 工单模板类型(yunshareTemplateType)
*
* @author lzx@yuyuda.com
* @since 2023/1/9
*/
public interface YunshareTemplateTypeMapper extends YunshareMapper<YunshareTemplateType> {
	/**
	 * <p>分页</p>
	 *
	 * @param page 分页
     * @param input 搜索信息
	 * @return IPage<com.yunshare.modules.vo.yunshareTemplateTypeVO>
	 * @author lzx@yuyuda.com
	 * @since 2023/1/9 1:42 下午
	 */
	IPage<YunshareTemplateTypeVO> page(IPage<YunshareTemplateTypeVO> page, @Param("input") TemplateTypePageDTO input);

	/**
	 * <p>选择列表</p>
	 *
	 * @return java.util.List<com.yunshare.modules.vo.yunshareTemplateTypeShortVO>
	 * @author lzx@yuyuda.com
	 * @since 2023/1/9 1:19 下午
	 */
	List<YunshareTemplateTypeShortVO> select();
}
