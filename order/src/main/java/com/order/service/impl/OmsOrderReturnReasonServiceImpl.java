package com.order.service.impl;

import com.order.entity.OmsOrderReturnReason;
import com.order.mapper.OmsOrderReturnReasonMapper;
import com.order.service.IOmsOrderReturnReasonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单退货原因表。用于会员退货时选择退货原因。 服务实现类
 * </p>
 *
 * @author y1nuo
 * @since 2023-01-10
 */
@Service
public class OmsOrderReturnReasonServiceImpl extends ServiceImpl<OmsOrderReturnReasonMapper, OmsOrderReturnReason> implements IOmsOrderReturnReasonService {

}
