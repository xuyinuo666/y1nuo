package com.order.service.impl;

import com.order.entity.OmsOrderOperateHistory;
import com.order.mapper.OmsOrderOperateHistoryMapper;
import com.order.service.IOmsOrderOperateHistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单操作记录表。当订单状态发生改变时，用于记录订单的操作信息。 服务实现类
 * </p>
 *
 * @author y1nuo
 * @since 2023-01-10
 */
@Service
public class OmsOrderOperateHistoryServiceImpl extends ServiceImpl<OmsOrderOperateHistoryMapper, OmsOrderOperateHistory> implements IOmsOrderOperateHistoryService {

}
