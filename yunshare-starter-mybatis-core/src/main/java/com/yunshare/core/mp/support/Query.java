package com.yunshare.core.mp.support;

import com.yunshare.core.tool.utils.StringUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 分页工具
 *
 * @author lzx@yuyuda.com
 */
@Data
@Accessors(chain = true)
@ApiModel(description = "查询条件")
public class Query {

    /**
     * 当前页
     */
    @ApiModelProperty(value = "当前页")
    private Integer page;

    /**
     * 每页的数量
     */
    @ApiModelProperty(value = "每页的数量")
    private Integer limit;

    /**
     * 正排序规则
     */
    @ApiModelProperty(value = "升序排序字段")
    private String ascs;

    /**
     * 倒排序规则
     */
    @ApiModelProperty(value = "降序排序字段")
    private String descs;

    /**
     * 设置默认倒序排序字段
     *
     * @param descs
     */
    public void setDefaultDescs(String descs) {
        if (StringUtil.isBlank(this.descs)){
            this.descs = descs;
        }
    }

    /**
     * 设置默认升序序排序字段
     *
     * @param ascs
     */
    public void setDefaultAscs(String ascs) {
        if (StringUtil.isBlank(this.ascs)){
            this.ascs = ascs;
        }
    }
}
