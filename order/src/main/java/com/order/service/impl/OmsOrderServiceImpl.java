package com.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.order.bo.OrderBo;
import com.order.entity.OmsOrder;
import com.order.mapper.OmsOrderMapper;
import com.order.openfeign.ProductFeign;
import com.order.service.IOmsOrderService;
import org.springframework.stereotype.Service;
import res.BaseResponse;

import javax.annotation.Resource;

/**
 * <p>
 * 订单表。订单表，需要注意的是订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单。 服务实现类
 * </p>
 *
 * @author y1nuo
 * @since 2023-01-10
 */
@Service
public class OmsOrderServiceImpl extends ServiceImpl<OmsOrderMapper, OmsOrder> implements IOmsOrderService {
    @Resource
    private ProductFeign productFeign;
    @Override
    public BaseResponse<Boolean> addOrder(String uniqueId) {
        return productFeign.noticeProduct(uniqueId);
    }
}
