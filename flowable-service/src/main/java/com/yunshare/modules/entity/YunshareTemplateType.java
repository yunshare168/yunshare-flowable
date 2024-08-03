package com.yunshare.modules.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yunshare.core.mp.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* 工单模板类型实体类
*
* @author lzx@yuyuda.com
* @since 2023/1/9
*/
@Data
@TableName("yunshare_template_type")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "yunshareTemplateType对象", description = "工单模板类型")
public class YunshareTemplateType extends BaseEntity {

    private static final long serialVersionUID = 838463315481283486L;

    /**
     * 类型名称
     */
    @ApiModelProperty("类型名称")
    private String title;
    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private Integer sort;
}
