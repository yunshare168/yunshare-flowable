package com.yunshare.core.engine.comparison;

import com.yunshare.core.engine.creator.NodeInput;
import com.yunshare.core.tool.utils.CollectionUtil;
import com.yunshare.core.tool.utils.StringPool;
import com.yunshare.modules.dto.bpm.ConditionExpression;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

import static com.yunshare.core.constant.ProcessConstant.END_EXPRESSION;
import static com.yunshare.core.constant.ProcessConstant.START_EXPRESSION;


/**
 * <p>比较算符策略工厂</p>
 *
 * @author lzx@yuyuda.com
 * @since 2023/2/11 上午12:50
 */
@Component
public class ComparisonStrategyFactory {

	private final static String EXPRESSION_CLASS = "funcKit.";
	private final static String EXECUTE_METHOD = EXPRESSION_CLASS+"resolve";

	/**
	 * <p>生成表达式</p>
	 *
	 * @param input 参数对象
	 * @return java.lang.String
	 * @author lzx@yuyuda.com
	 * @since 2023/2/11 上午1:07
	 */
	public String expression(NodeInput input) {
		if (Objects.isNull(input.getNodeConfig())) {
			return StringPool.EMPTY;
		}
		StringBuilder expBuilder = new StringBuilder();
		List<ConditionExpression> conditionExpressions = input.getNodeConfig().getConditionExpressions();
		if (CollectionUtil.isNotEmpty(conditionExpressions)) {
			int size = conditionExpressions.size();
			expBuilder.append(START_EXPRESSION);
			for (int i = 0; i < conditionExpressions.size(); i++) {
				//创建表达式
				expBuilder.append(this.createExpression(conditionExpressions.get(i)));
				if (i < size - 1) {
					expBuilder.append(conditionExpressions.get(i).getLogicalSymbol().getValue());
				}
			}
			expBuilder.append(END_EXPRESSION);
		}
		return expBuilder.toString();
	}

	/**
	 * <p>构建表达式</p>
	 *
	 * @param expression 条件
	 * @return {@link String}
	 * @author lzx@yuyuda.com
	 * @since 2023/4/6 15:30
	 */
	public String createExpression(ConditionExpression expression) {
		StringJoiner expr = new StringJoiner(",");
		expr.add(expression.getColumn());
		expr.add("\"" + expression.getColumnValueType().name() + "\"");
		expr.add("\"" + expression.getCalSymbol().name() + "\"");
		expression.getRightValue().forEach(e -> expr.add("\"" + e + "\""));
		//funcKit.resolve(param1,param1,param1,....)
		return EXECUTE_METHOD.concat(StringPool.LEFT_BRACKET).concat(expr.toString()).concat(StringPool.RIGHT_BRACKET);
	}

}
