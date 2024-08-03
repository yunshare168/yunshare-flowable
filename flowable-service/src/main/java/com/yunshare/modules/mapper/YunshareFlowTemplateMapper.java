package com.yunshare.modules.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yunshare.core.mp.mapper.YunshareMapper;
import com.yunshare.modules.dto.FlowTemplateListDTO;
import com.yunshare.modules.dto.FlowTemplatePageDTO;
import com.yunshare.modules.entity.YunshareFlowTemplate;
import com.yunshare.modules.vo.YunshareFlowTemplateListVO;
import com.yunshare.modules.vo.YunshareFlowTemplateVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 工单模板(yunshareFlowTemplate)
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/10
 */
public interface YunshareFlowTemplateMapper extends YunshareMapper<YunshareFlowTemplate> {
	/**
	 * <p>分页</p>
	 *
	 * @param page  分页
	 * @param input 搜索
	 * @return com.baomidou.mybatisplus.core.metadata.IPage<com.yunshare.modules.vo.yunshareFlowTemplateListVO>
	 * @author lzx@yuyuda.com
	 * @since 2023/1/10 3:14 下午
	 */
	IPage<YunshareFlowTemplateListVO> page(IPage<YunshareFlowTemplateListVO> page, @Param("input") FlowTemplatePageDTO input);

	/**
	 * <p>获取流程模板列表</p >
	 *
	 * @param input 入参对象
	 * @return java.util.List<com.yunshare.modules.vo.yunshareFlowTemplateListVO>
	 * @author lzx@yuyuda.com
	 * @since 2023/2/2 10:51
	 **/
	List<YunshareFlowTemplateListVO> flowTemplateList(@Param("input") FlowTemplateListDTO input);

	/**
	 * <p>查询企业启用的流程模板</p>
	 *
	 * @param corpId       企业ID
	 * @param title        筛选名称
	 * @param fromPlatform 是否来自平台: 1-是,0-否
	 * @return {@link List<   YunshareFlowTemplateVO  >}
	 * @author lzx@yuyuda.com
	 * @since 2023/2/15 11:22
	 */
	List<YunshareFlowTemplateVO> list(@Param("corpId") Long corpId, @Param("title") String title, @Param("fromPlatform") Integer fromPlatform);


}
