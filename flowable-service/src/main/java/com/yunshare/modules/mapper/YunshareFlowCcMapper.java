package com.yunshare.modules.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yunshare.core.domain.BpmTaskQuery;
import com.yunshare.core.mp.mapper.YunshareMapper;
import com.yunshare.modules.entity.YunshareFlowCc;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author lzx
 * @Entity generator.domain.yunshareFlowCc
 */
@Mapper
public interface YunshareFlowCcMapper extends YunshareMapper<YunshareFlowCc> {
	/**
	 * <p>查询抄送给我的分页</p>
	 *
	 * @param page   分页参数
	 * @param param  查询参数
	 * @param cropId 企业ID
	 * @param userId 用户ID
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param asc    排序
	 * @return {@link IPage<  YunshareFlowCc >}
	 * @author lzx@yuyuda.com
	 * @since 2023/4/6 14:42
	 */
	IPage<YunshareFlowCc> ccPage(IPage<YunshareFlowCc> page, @Param("param") BpmTaskQuery param, @Param("corpId") Long cropId, @Param("userId") Long userId, @Param("startTime") String startTime, @Param("endTIme")String endTime, @Param("asc") boolean asc);

	/**
	 * <p>抄送给我的数量</p>
	 *
     * @param corpId 企业ID
     * @param userId 用户ID
	 * @return {@link int}
	 * @author lzx@yuyuda.com
	 * @since 2023/7/13 09:59
	 */
	int ccCount(@Param("corpId") String corpId,@Param("userId") String userId);
}
