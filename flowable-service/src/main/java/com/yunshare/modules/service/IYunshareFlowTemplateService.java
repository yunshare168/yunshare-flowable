package com.yunshare.modules.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yunshare.core.mp.service.YunshareService;
import com.yunshare.core.tool.api.Res;
import com.yunshare.modules.dto.FlowTemplateDTO;
import com.yunshare.modules.dto.FlowTemplateListDTO;
import com.yunshare.modules.dto.FlowTemplatePageDTO;
import com.yunshare.modules.entity.YunshareFlowTemplate;
import com.yunshare.modules.vo.YunshareFlowTemplateListVO;
import com.yunshare.modules.vo.YunshareFlowTemplateVO;

import java.util.List;
import java.util.Map;

/**
 * 工单模板(yunshareFlowTemplate)服务
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/10
 */
public interface IYunshareFlowTemplateService extends YunshareService<YunshareFlowTemplate> {
	/**
	 * <p>分页</p>
	 *
	 * @param page  分页信息
	 * @param input 搜索
	 * @return IPage<com.yunshare.modules.vo.yunshareFlowTemplateVO>
	 * @author lzx@yuyuda.com
	 * @since 2023/1/10 4:00 下午
	 */
	IPage<YunshareFlowTemplateListVO> page(IPage<YunshareFlowTemplateListVO> page, FlowTemplatePageDTO input);

	/**
	 * <p>获取模板分组列表</p>
	 *
	 * @param title 搜索
	 * @return java.util.Map<java.lang.String, java.util.List < com.yunshare.modules.vo.yunshareFlowTemplateShortVO>>
	 * @author lzx@yuyuda.com
	 * @since 2023/1/10 4:17 下午
	 */
	Map<String, List<YunshareFlowTemplateVO>> list(String title);

	/**
	 * <p>保存流程模板</p>
	 *
	 * @param input 参数
	 * @return com.yunshare.core.tool.api.R<com.yunshare.modules.dto.FlowTemplateDTO>
	 * @author lzx@yuyuda.com
	 * @since 2023/1/17 下午1:12
	 */
	Res<FlowTemplateDTO> submit(FlowTemplateDTO input);

	/**
	 * <p>详情</p>
	 *
	 * @param id id
	 * @return com.yunshare.modules.dto.FlowTemplateDTO
	 * @author lzx@yuyuda.com
	 * @since 2023/1/17 下午9:30
	 */
	FlowTemplateDTO detail(Long id);

	/**
	 * <p>更新状态[上、下线模板]</p>
	 *
	 * @param id     模板ID
	 * @param status 状态 1-上线 2-下线
	 * @return com.yunshare.core.tool.api.Res<java.lang.Boolean>
	 * @author lzx@yuyuda.com
	 * @since 2023/1/17 下午1:32
	 */
	Res<Boolean> updateStatus(Long id, Integer status);

	/**
	 * <p>获取流程模板列表</p >
	 *
	 * @param input 入参对象
	 * @return java.util.List<com.yunshare.modules.vo.yunshareFlowTemplateListVO>
	 * @author lzx@yuyuda.com
	 * @since 2023/2/2 10:51
	 **/
	List<YunshareFlowTemplateListVO> flowTemplateList(FlowTemplateListDTO input);

	/**
	 * <p>根据title查询唯一模板</p>
	 *
	 * @param title  标题名称
	 * @param typeId 分类
	 * @return {@link YunshareFlowTemplateVO}
	 * @author lzx@yuyuda.com
	 * @since 2023/3/28 15:56
	 */
	YunshareFlowTemplateVO getUniqueTemplate(String title, Long typeId);
}

