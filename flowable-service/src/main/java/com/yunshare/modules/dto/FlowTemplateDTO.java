package com.yunshare.modules.dto;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.yunshare.core.tool.jackson.JsonUtil;
import com.yunshare.modules.dto.bpm.BpmModelInput;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * 流程模板
 * </p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/10
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class FlowTemplateDTO extends BpmModelInput implements Serializable {

    private static final long serialVersionUID = 838413315481283406L;

    /**
     * id
     */
    @ApiModelProperty("id,编辑必传,创建不传")
    private Long id;
    /**
     * 模板名称
     */
    @ApiModelProperty("模板名称")
    @NotBlank(message = "模板名称不能为空")
    private String title;
    /**
     * 模板类型ID
     */
    @ApiModelProperty("模板类型ID")
    @NotNull(message = "请选择模板类型")
    private Long typeId;
    /**
     * 创建人ID
     */
    @ApiModelProperty("创建人ID")
    private Long createUser;
    /**
     * 创建用户信息
     */
    @ApiModelProperty(value = "创建用户信息")
    private String createUserName;
    /**
     * 模板图标
     */
    @ApiModelProperty("模板图标")
    @NotBlank(message = "模板图标不能为空")
    private String image;
    /**
     * 模板描述
     */
    @ApiModelProperty("模板描述")
    @NotBlank(message = "模板描述不能为空")
    private String remark;
    /**
     * 企业ID: 平台0 企业端为企业ID
     */
    @ApiModelProperty("企业ID: 平台0 企业端为企业ID")
    private Long corpId;

    /**
     * 是否开启评论: 1开启 0未开启
     */
    @ApiModelProperty("是否开启评论: 1开启 0未开启")
    private Integer isOpenComment;
    /**
     * 是否开启满意度评价: 1开启 0未开启
     */
    @ApiModelProperty("是否开启满意度评价: 1开启 0未开启")
    private Integer isOpenEvaluate;

    public String msgNoticeToString() {
        return CollectionUtils.isNotEmpty(super.getMsgNotice()) ? JsonUtil.toJson(super.getMsgNotice()) : null;
    }

}
