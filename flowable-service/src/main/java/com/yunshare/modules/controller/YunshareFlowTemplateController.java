package com.yunshare.modules.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.yunshare.core.mp.support.Condition;
import com.yunshare.core.mp.support.Query;
import com.yunshare.core.tool.api.Res;
import com.yunshare.modules.dto.FlowTemplateDTO;
import com.yunshare.modules.dto.FlowTemplateListDTO;
import com.yunshare.modules.dto.FlowTemplatePageDTO;
import com.yunshare.modules.service.IYunshareFlowTemplateService;
import com.yunshare.modules.vo.YunshareFlowTemplateListVO;
import com.yunshare.modules.vo.YunshareFlowTemplateVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>流程模板-控制器</p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/17 下午2:30
 */
@RestController
@RequestMapping("v1/flow/template/")
@ApiSort(3)
@Api(value = "流程-模板", tags = "流程-模板")
public class YunshareFlowTemplateController {
	@Resource
	private IYunshareFlowTemplateService service;

	@ApiOperation("保存流程模板")
	@ApiOperationSupport(order = 1)
	@PostMapping("submit")
	public Res<FlowTemplateDTO> submit(@RequestBody @Validated FlowTemplateDTO input) {
		return service.submit(input);
	}

	@ApiOperation("更新状态[上、下线模板]")
	@ApiOperationSupport(order = 2)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "模板ID", required = true),
		@ApiImplicitParam(name = "status", value = "状态 1-上线 2-下线", required = true)
	})
	@PutMapping("online_or_offline/{id}/{status}")
	public Res<Boolean> onlineOrOffline(@PathVariable Long id, @PathVariable Integer status) {
		return service.updateStatus(id, status);
	}

	@ApiOperation("流程模板分页")
	@ApiOperationSupport(order = 3)
	@GetMapping("page")
	public Res<IPage<YunshareFlowTemplateListVO>> page(FlowTemplatePageDTO input, Query query) {
		return Res.data(service.page(Condition.getPage(query), input));
	}

	@ApiOperation("流程模板详情")
	@ApiOperationSupport(order = 4)
	@GetMapping("detail/{id}")
	public Res<FlowTemplateDTO> detail(@PathVariable Long id) {
		return Res.data(service.detail(id));
	}


	/**
	 * <p>获取模板唯一性</p>
	 *
	 * @param title  模板名称
	 * @param typeId 类型ID
	 * @return {@link Res<YunshareFlowTemplateVO>}
	 * @author lzx@yuyuda.com
	 * @since 2023/3/28 16:07
	 */
	@ApiOperation("获取模板唯一性")
	@ApiOperationSupport(order = 4)
	@GetMapping("getUniqueTemplate")
	public Res<YunshareFlowTemplateVO> getUniqueTemplate(@RequestParam String title, @RequestParam Long typeId) {
		return Res.data(service.getUniqueTemplate(title, typeId));
	}

	@ApiOperation("模板分组列表")
	@ApiOperationSupport(order = 5)
	@GetMapping("group_list")
	public Res<Map<String, List<YunshareFlowTemplateVO>>> groupList(String title) {
		return Res.data(service.list(title));
	}

	/**
	 * <p>获取流程模板列表</p >
	 *
	 * @param input 入参对象
	 * @return java.util.List<com.yunshare.modules.vo.yunshareFlowTemplateListVO>
	 * @author lzx@yuyuda.com
	 * @since 2023/2/2 10:51
	 **/
	@ApiOperation("获取流程模板列表")
	@ApiOperationSupport(order = 6)
	@PostMapping("list")
	public Res<List<YunshareFlowTemplateListVO>> flowTemplateList(@RequestBody FlowTemplateListDTO input) {
		return Res.data(service.flowTemplateList(input));
	}
}

