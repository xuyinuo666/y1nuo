package com.order.mapper;

import com.order.entity.OmsOrderOperateHistory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 订单操作记录表。当订单状态发生改变时，用于记录订单的操作信息。 Mapper 接口
 * </p>
 *
 * @author y1nuo
 * @since 2023-01-10
 */
@Mapper
public interface OmsOrderOperateHistoryMapper extends BaseMapper<OmsOrderOperateHistory> {

}
