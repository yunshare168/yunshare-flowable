package com.yunshare.modules.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yunshare.core.mp.service.YunshareServiceImpl;
import com.yunshare.core.tool.exception.ServiceException;
import com.yunshare.core.tool.utils.BeanUtil;
import com.yunshare.core.tool.utils.IntPool;
import com.yunshare.core.tool.utils.ObjectUtil;
import com.yunshare.modules.dto.TemplateTypeDTO;
import com.yunshare.modules.dto.TemplateTypePageDTO;
import com.yunshare.modules.entity.YunshareTemplateType;
import com.yunshare.modules.mapper.YunshareTemplateTypeMapper;
import com.yunshare.modules.service.IYunshareTemplateTypeService;
import com.yunshare.modules.vo.YunshareTemplateTypeShortVO;
import com.yunshare.modules.vo.YunshareTemplateTypeVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 工单模板类型(yunshareTemplateType)服务是实现
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/9
 */
@Service
public class YunshareTemplateTypeServiceImpl extends YunshareServiceImpl<YunshareTemplateTypeMapper, YunshareTemplateType> implements IYunshareTemplateTypeService {

	/**
	 * <p>分页</p>
	 *
	 * @param page  分页
	 * @param input 搜索信息
	 * @return IPage<com.yunshare.modules.vo.yunshareTemplateTypeVO>
	 * @author lzx@yuyuda.com
	 * @since 2023/1/9 1:19 下午
	 */
	@Override
	public IPage<YunshareTemplateTypeVO> page(IPage<YunshareTemplateTypeVO> page, TemplateTypePageDTO input) {
		return this.baseMapper.page(page, input);
	}

	/**
	 * <p>选择列表</p>
	 *
	 * @return java.util.List<com.yunshare.modules.vo.yunshareTemplateTypeShortVO>
	 * @author lzx@yuyuda.com
	 * @since 2023/1/9 1:19 下午
	 */
	@Override
	public List<YunshareTemplateTypeShortVO> select() {
		return this.baseMapper.select();
	}

	/**
	 * <p>新增</p>
	 *
	 * @param input 新增信息
	 * @return com.yunshare.modules.model.yunshareTemplateType
	 * @author lzx@yuyuda.com
	 * @since 2023/1/9 1:11 下午
	 */
	@Override
	public YunshareTemplateType add(TemplateTypeDTO input) {
		YunshareTemplateType existType = getExistType(input.getTitle());
		if (ObjectUtil.isNotEmpty(existType)) {
			throw new ServiceException("类型名称不能重复!");
		}
		YunshareTemplateType templateType = new YunshareTemplateType();
		BeanUtils.copyProperties(input, templateType);
		this.save(templateType);

		return templateType;
	}

	/**
	 * <p>更新</p>
	 *
	 * @param input 更新信息
	 * @return com.yunshare.modules.model.yunshareTemplateType
	 * @author lzx@yuyuda.com
	 * @since 2023/1/9 1:12 下午
	 */
	@Override
	public YunshareTemplateType update(TemplateTypeDTO input) {
		YunshareTemplateType templateType = this.getById(input.getId());
		if (ObjectUtil.isEmpty(templateType)) {
			throw new ServiceException("模板类型不存在");
		}
		YunshareTemplateType existType = getExistType(input.getTitle());
		if (ObjectUtil.isNotEmpty(existType) && !existType.getId().equals(input.getId())) {
			throw new ServiceException("类型名称不能重复!");
		}
		BeanUtils.copyProperties(input, templateType);
		this.updateById(templateType);

		return templateType;
	}

	/**
	 * <p>详情</p>
	 *
	 * @param id 类型ID
	 * @return com.yunshare.modules.vo.yunshareTemplateTypeVO
	 * @author lzx@yuyuda.com
	 * @since 2023/1/9 1:13 下午
	 */
	@Override
	public YunshareTemplateTypeVO detail(Long id) {
		YunshareTemplateType templateType = this.getById(id);
		if (ObjectUtil.isEmpty(templateType)) {
			throw new ServiceException("模板类型不存在");
		}
		return BeanUtil.copy(templateType, YunshareTemplateTypeVO.class);
	}

	/**
	 * <p>根据名称获取类型</p>
	 *
	 * @param title 名称
	 * @return com.yunshare.modules.model.yunshareTemplateType
	 * @author lzx@yuyuda.com
	 * @since 2023/1/9 1:13 下午
	 */
	private YunshareTemplateType getExistType(String title) {
		LambdaQueryWrapper<YunshareTemplateType> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(YunshareTemplateType::getTitle, title)
			.eq(YunshareTemplateType::getIsDeleted, IntPool.ZERO)
			.select(YunshareTemplateType::getId, YunshareTemplateType::getTitle, YunshareTemplateType::getSort);

		return this.getOne(wrapper);
	}
}
