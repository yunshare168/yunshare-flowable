package com.yunshare.modules.dto.bpm;

import com.yunshare.core.enums.CalSymbol;
import com.yunshare.core.enums.ColumnValueType;
import com.yunshare.core.enums.LogicalSymbol;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>条件表达式</p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/1/16 下午4:25
 */
@Data
@ApiModel(value = "ConditionExpression", description = "条件表达式")
public class ConditionExpression implements Serializable {

	private static final long serialVersionUID = -3881995829213457944L;

	@ApiModelProperty(value = "表单组件ID")
	private String columnId;

	@ApiModelProperty(value = "STRING字符串 NUMBER数字 DATE日期 DATE_RANGE时间范围")
	private ColumnValueType columnValueType;

	@ApiModelProperty(value = "比较表达式")
	private CalSymbol calSymbol;

	@ApiModelProperty(value = "字段")
	private String column;

	@ApiModelProperty(value = "右侧值")
	private List<String> rightValue;

	@ApiModelProperty(value = "多条件间的逻辑符号， 与条件表达式对应, AND或者OR")
	private LogicalSymbol logicalSymbol;
}
