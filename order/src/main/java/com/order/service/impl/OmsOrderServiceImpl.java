package com.order.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.order.bo.OrderBo;
import com.order.bo.ProductBo;
import com.order.entity.OmsOrder;
import com.order.mapper.OmsOrderMapper;
import com.order.openfeign.ProductFeign;
import com.order.po.ProductPo;
import com.order.service.IOmsOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

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
    public boolean checkOrderApprove(OrderBo orderBo) {
        List<Long> prodIds = orderBo.getProductBoList().stream().map(ProductBo::getProductId).collect(Collectors.toList());
        List<JSONObject> productPos = productFeign.getProductInfoByIdList(prodIds);
        return true;
    }

    @Override
    public boolean addOrder(OrderBo orderBo) {
        return checkOrderApprove(orderBo);
    }
}
