package com.order.service;

import com.order.entity.OmsOrderReturnApply;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 订单退货申请表。主要用于存储会员退货申请信息，需要注意的是订单退货申请表的四种状态：0->待处理；1->退货中；2->已完成；3->已拒绝。 服务类
 * </p>
 *
 * @author y1nuo
 * @since 2023-01-10
 */
public interface IOmsOrderReturnApplyService extends IService<OmsOrderReturnApply> {

}
