package com.yunshare.modules.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.yunshare.core.constant.ProcessConstant;
import com.yunshare.core.engine.creator.NodeStrategyFactory;
import com.yunshare.core.engine.utils.BpmnUtil;
import com.yunshare.core.mp.service.YunshareServiceImpl;
import com.yunshare.core.tool.api.Res;
import com.yunshare.core.tool.exception.ServiceException;
import com.yunshare.core.tool.jackson.JsonUtil;
import com.yunshare.core.tool.utils.BeanUtil;
import com.yunshare.core.tool.utils.IntPool;
import com.yunshare.core.tool.utils.StringUtil;
import com.yunshare.modules.dto.FlowTemplateDTO;
import com.yunshare.modules.dto.FlowTemplateListDTO;
import com.yunshare.modules.dto.FlowTemplatePageDTO;
import com.yunshare.modules.dto.MsgNoticeDTO;
import com.yunshare.modules.dto.bpm.NodeConfig;
import com.yunshare.modules.entity.YunshareFlowTemplate;
import com.yunshare.modules.mapper.YunshareFlowTemplateMapper;
import com.yunshare.modules.service.IYunshareFlowTemplateService;
import com.yunshare.modules.vo.YunshareFlowTemplateListVO;
import com.yunshare.modules.vo.YunshareFlowTemplateVO;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.flowable.bpmn.converter.BpmnXMLConverter;
import org.flowable.bpmn.model.BpmnModel;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.yunshare.core.constant.ProcessConstant.SUFFIX;

/**
 * 工单模板(yunshareFlowTemplate)服务是实现
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/10
 */
@Slf4j
@Service
public class YunshareFlowTemplateServiceImpl extends YunshareServiceImpl<YunshareFlowTemplateMapper, YunshareFlowTemplate> implements IYunshareFlowTemplateService {
    @Resource
    private RepositoryService repositoryService;
    @Resource
    private NodeStrategyFactory nodeStrategyFactory;


    /**
     * <p>分页</p>
     *
     * @param page  分页信息
     * @param input 搜索
     * @return IPage<com.yunshare.modules.vo.yunshareFlowTemplateVO>
     * @author lzx@yuyuda.com
     * @since 2023/1/10 4:00 下午
     */
    @Override
    public IPage<YunshareFlowTemplateListVO> page(IPage<YunshareFlowTemplateListVO> page, FlowTemplatePageDTO input) {
        return this.baseMapper.page(page, input);
    }

    /**
     * <p>获取模板列表</p>
     *
     * @param title 搜索
     * @return java.util.Map<java.lang.String, java.util.List < com.yunshare.modules.vo.yunshareFlowTemplateShortVO>>
     * @author lzx@yuyuda.com
     * @since 2023/1/10 4:17 下午
     */
    @Override
    public Map<String, List<YunshareFlowTemplateVO>> list(String title) {
        return null;
    }

    /**
     * <p>保存流程模板</p>
     *
     * @param input 参数
     * @return com.yunshare.core.tool.api.R<com.yunshare.modules.dto.FlowTemplateDTO>
     * @author lzx@yuyuda.com
     * @since 2023/1/17 下午1:12
     */
    @SneakyThrows
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Res<FlowTemplateDTO> submit(FlowTemplateDTO input) {
        Long corpId = 0L;
		Integer fromPlatform = 0;
        //获取是否更新操作
        boolean update = input.getId() != null;
        //验证模板名称
        this.verifyTemplateName(input, corpId);
        YunshareFlowTemplate template = new YunshareFlowTemplate();
        BeanUtils.copyProperties(input, template);
        template.setCorpId(corpId);
		template.setFromPlatform(fromPlatform);
        template.setMsgNotice(input.msgNoticeToString());
        template.setTemplateStatus(IntPool.TWO);
        // 如果是修改，不需要生成ID，如果是新增则需要生成ID，因为ID需要传入流程引擎中
        template.setId(update ? input.getId() : IdWorker.getId(template));
        input.setId(template.getId());
        input.setProcessDefinitionKey(ProcessConstant.FLOWABLE_ID + template.getId());
        input.setWorkFlowDef(input.getTitle());
        // 流程模板处理
        if (Objects.nonNull(input.getNodeConfig())) {
            BpmnModel bpmnModel = nodeStrategyFactory.buildBpmnModel(input);
            template.setBpmnXml(new String(new BpmnXMLConverter().convertToXML(bpmnModel)));
        }
        template.setNodeConfig(JsonUtil.toJson(input.getNodeConfig()));
        boolean success = update ? this.updateById(template) : this.save(template);
        if (Boolean.TRUE.equals(success)) {
            return Res.data(input);
        } else {
            return Res.fail("模板保存失败!");
        }
    }

    /**
     * <p>详情</p>
     *
     * @param id id
     * @return com.yunshare.modules.vo.yunshareFlowTemplateInfoVO
     * @author lzx@yuyuda.com
     * @since 2023/1/10 4:00 下午
     */
    @Override
    public FlowTemplateDTO detail(Long id) {
        YunshareFlowTemplate template = this.getById(id);
        if (template==null) {
            throw new ServiceException("模板不存在");
        }
        FlowTemplateDTO dto = new FlowTemplateDTO();
        BeanUtil.copy(template, dto);
        NodeConfig nodeConfig = JsonUtil.parse(template.getNodeConfig(), NodeConfig.class);
        dto.setNodeConfig(nodeConfig);
        if (StringUtil.isNotBlank(template.getMsgNotice())){
            dto.setMsgNotice(JsonUtil.parseArray(template.getMsgNotice(), MsgNoticeDTO.class));
        }
        return dto;
    }

    /**
     * <p>更新状态[上、下线模板]</p>
     *
     * @param id     模板ID
     * @param status 状态 1-上线 2-下线
     * @return com.yunshare.core.tool.api.R<java.lang.Boolean>
     * @author lzx@yuyuda.com
     * @since 2023/1/17 下午1:32
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Res<Boolean> updateStatus(Long id, Integer status) {
        Integer[] statusEnum = new Integer[]{IntPool.ONE, IntPool.TWO};
        if (!Arrays.asList(statusEnum).contains(status)) {
            return Res.fail("状态错误");
        }
        long corpId = 0L;
        Long templateCorpId = 0L;
        // 上线流程模板，需要部署bpmn
        if (status == IntPool.ONE) {
            // 查询流程模板
            YunshareFlowTemplate flowTemplate = this.getById(id);
            String bpmnXml = flowTemplate.getBpmnXml();
            if (Objects.isNull(bpmnXml)) {
                return Res.fail("模板没有流程节点配置，不能上线");
            }
            // 部署流程
            BpmnModel bpmnModel = BpmnUtil.getBpmnModel(bpmnXml);
            String category = flowTemplate.getTypeId().toString();
            Deployment deployment = repositoryService.createDeployment()
                    .name(flowTemplate.getTitle())
                    .category(category)
                    .tenantId(Long.toString(corpId))
                    .addBpmnModel(flowTemplate.getTitle() + SUFFIX, bpmnModel)
                    .deploy();
            ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(deployment.getId()).singleResult();
            if (Objects.isNull(processDefinition)) {
                throw new ServiceException("部署失败,未找到流程");
            }
            //设置流程类型
            repositoryService.setProcessDefinitionCategory(processDefinition.getId(), category);
            //部署表单
            //清除合同模板
        }
        //更新模板状态
        boolean success = this.lambdaUpdate()
                .set(YunshareFlowTemplate::getTemplateStatus, status)
                .eq(YunshareFlowTemplate::getCorpId, templateCorpId)
                .eq(YunshareFlowTemplate::getId, id).update();
        return success ? Res.success(status == IntPool.ONE ? "上线成功" : "下线成功") : Res.fail("变更失败");
    }

    /**
     * <p>获取流程模板列表</p >
     *
     * @param input 入参对象
     * @return java.util.List<com.yunshare.modules.vo.yunshareFlowTemplateListVO>
     * @author lzx@yuyuda.com
     * @since 2023/2/2 10:51
     **/
    @Override
    public List<YunshareFlowTemplateListVO> flowTemplateList(FlowTemplateListDTO input) {
        Long corpId = 0L;
		Integer fromPlatform = 0;
		input.setFromPlatform(fromPlatform);
        input.setCorpId(corpId);
        return this.baseMapper.flowTemplateList(input);
    }

    @Override
    public YunshareFlowTemplateVO getUniqueTemplate(String title, Long typeId) {
        Long corpId = 0L;
        YunshareFlowTemplate template = this.lambdaQuery().eq(YunshareFlowTemplate::getCorpId, corpId)
                .eq(YunshareFlowTemplate::getTypeId, typeId)
                .eq(YunshareFlowTemplate::getTitle, title).last("limit 1").one();
        return template != null ? BeanUtil.copy(template, YunshareFlowTemplateVO.class) : null;
    }

    /**
     * <p>验证模板名称是否重复</p>
     *
     * @param input 模板信息
     * @author lzx@yuyuda.com
     * @since 2023/1/10 4:13 下午
     */
    private void verifyTemplateName(FlowTemplateDTO input, Long corpId) {
        if (input.getId() != null) {
            YunshareFlowTemplate template = this.getById(input.getId());
            if (template == null) {
                throw new ServiceException("模板不存在，编辑失败");
            }
            //模板名称 、 模板分类被变更，校验名称是否重复
            if (Objects.equals(input.getTitle(), template.getTitle()) && Objects.equals(input.getTypeId(), template.getTypeId())) {
                return;
            }
        }
        int count = this.lambdaQuery()
			.eq(YunshareFlowTemplate::getCorpId, corpId)
			.eq(YunshareFlowTemplate::getTypeId, input.getTypeId())
			.eq(YunshareFlowTemplate::getTitle, input.getTitle()).count();
        if (count > 0) {
            throw new ServiceException(String.format("模板名称[%s]已存在", input.getTitle()));
        }
    }
}
