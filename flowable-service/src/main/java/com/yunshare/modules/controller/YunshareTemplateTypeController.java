package com.yunshare.modules.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.yunshare.core.mp.support.Condition;
import com.yunshare.core.mp.support.Query;
import com.yunshare.core.tool.api.Res;
import com.yunshare.modules.dto.TemplateTypeDTO;
import com.yunshare.modules.dto.TemplateTypePageDTO;
import com.yunshare.modules.entity.YunshareTemplateType;
import com.yunshare.modules.service.IYunshareTemplateTypeService;
import com.yunshare.modules.vo.YunshareTemplateTypeShortVO;
import com.yunshare.modules.vo.YunshareTemplateTypeVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
* 工单模板类型控制器
*
* @author lzx@yuyuda.com
* @since 2023/1/9
*/
@RestController
@RequestMapping("v1/template_type")
@ApiSort(1)
@Api(value = "流程-模板类型", tags = "流程-模板类型")
public class YunshareTemplateTypeController {
   /**
    * 服务对象
    */
   @Resource
   private IYunshareTemplateTypeService service;

	/**
	 * <p>分页</p>
	 *
	 * @param input 查询信息
     * @param query 分页信息
	 * @return IPage<com.yunshare.modules.vo.yunshareTemplateTypeVO>>
	 * @author lzx@yuyuda.com
	 * @since 2023/1/9 1:32 下午
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "分页")
	public Res<IPage<YunshareTemplateTypeVO>> page(TemplateTypePageDTO input, Query query) {
		IPage<YunshareTemplateTypeVO> pages = service.page(Condition.getPage(query), input);
		return Res.data(pages);
	}

	/**
	 * <p>下拉列表</p>
	 *
	 * @return java.util.List<com.yunshare.modules.vo.yunshareTemplateTypeShortVO>
	 * @author lzx@yuyuda.com
	 * @since 2023/1/9 1:32 下午
	 */
	@GetMapping("/select")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "下拉列表")
	public Res<List<YunshareTemplateTypeShortVO>> select() {
		return Res.data(service.select());
	}

   /**
    * <p>详情</p>
    *
    * @param id id
    * @return com.yunshare.core.tool.api.Res<com.yunshare.modules.vo.yunshareTemplateTypeVO>
    * @author lzx@yuyuda.com
    * @since 2023/1/9 1:28 下午
    */
   @GetMapping("/{id}")
   @ApiOperationSupport(order = 2)
   @ApiOperation(value = "详情", notes = "传入id")
   public Res<YunshareTemplateTypeVO> detail(@PathVariable("id") Long id) {
       return Res.data(service.detail(id));
   }

   /**
    * <p>新增</p>
    *
    * @param entity 新增数据
    * @return com.yunshare.core.tool.api.Res<com.yunshare.modules.model.yunshareTemplateType>
    * @author lzx@yuyuda.com
    * @since 2023/1/9 5:56 下午
    */
   @PostMapping("/add")
   @ApiOperationSupport(order = 3)
   @ApiOperation(value = "新增", notes = "传入entity")
   public Res<YunshareTemplateType> add(@Valid @RequestBody TemplateTypeDTO entity) {
       return Res.data(service.add(entity));
   }

	/**
	 * <p>更新</p>
	 *
	 * @param entity 更新数据
	 * @return com.yunshare.core.tool.api.Res<com.yunshare.modules.model.yunshareTemplateType>
	 * @author lzx@yuyuda.com
	 * @since 2023/1/9 5:56 下午
	 */
	@PutMapping("/update")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "更新", notes = "传入entity")
	public Res<YunshareTemplateType> update(@Valid @RequestBody TemplateTypeDTO entity) {
		return Res.data(service.update(entity));
	}

}

