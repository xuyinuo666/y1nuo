package com.order.service.impl;

import com.order.entity.OmsOrderItem;
import com.order.mapper.OmsOrderItemMapper;
import com.order.service.IOmsOrderItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单商品信息表。订单中包含的商品信息，一个订单中会有多个订单商品信息。 服务实现类
 * </p>
 *
 * @author y1nuo
 * @since 2023-01-10
 */
@Service
public class OmsOrderItemServiceImpl extends ServiceImpl<OmsOrderItemMapper, OmsOrderItem> implements IOmsOrderItemService {

}
