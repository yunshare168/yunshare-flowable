package com.yunshare.modules.dto;

import com.yunshare.core.enums.ProcessActionType;
import com.yunshare.modules.dto.task.CommentDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 流程请求参数
 *
 * @author lzx@yuyuda.com
 * @since 2022/10/9 11:38
 */
@Data
public class ProcessReqParamDTO implements Serializable {
    @ApiModelProperty("来源")
    private String applyClient;

    @ApiModelProperty("流程定义id")
    private String processDefinitionId;

    @ApiModelProperty("流程实例id")
    private String processInstanceId;

    @ApiModelProperty("流程任务id，流程任务处理时必须")
    private String taskId;

    @ApiModelProperty("流程业务主键。 URL表单，可以直接赋值调用rest接口启动流程")
    private String businessKey;

    @ApiModelProperty("流程操作")
    @NotNull(message = "流程操作不能为空")
    private ProcessActionType action;

    @ApiModelProperty("流程业务数据")
    private Map<String, Object> variables;

    @ApiModelProperty("前端节点人员设置")
    private List<AssigneeDTO> nodeAssignee;

    @ApiModelProperty("评论")
    private CommentDTO comment;

    @ApiModelProperty("用户ID（转办、委托）")
    private String assignee;

    public Map<String, Object> getVariables() {
        if (variables == null) {
            variables = new HashMap<>(10);
        }
        return variables;
    }

}
