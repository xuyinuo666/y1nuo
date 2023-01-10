package com.order.mapper;

import com.order.entity.OmsOrderItem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 订单商品信息表。订单中包含的商品信息，一个订单中会有多个订单商品信息。 Mapper 接口
 * </p>
 *
 * @author y1nuo
 * @since 2023-01-10
 */
@Mapper
public interface OmsOrderItemMapper extends BaseMapper<OmsOrderItem> {

}
