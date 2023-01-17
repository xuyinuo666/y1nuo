package com.order.service;

import com.order.bo.OrderBo;
import com.order.entity.OmsOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import res.BaseResponse;

/**
 * <p>
 * 订单表。订单表，需要注意的是订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单。 服务类
 * </p>
 *
 * @author y1nuo
 * @since 2023-01-10
 */
public interface IOmsOrderService extends IService<OmsOrder> {

    BaseResponse<Boolean> addOrder(String uniqueId);
}
