package com.order.mapper;

import com.order.entity.OmsOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 订单表。订单表，需要注意的是订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单。 Mapper 接口
 * </p>
 *
 * @author y1nuo
 * @since 2023-01-10
 */
@Mapper
public interface OmsOrderMapper extends BaseMapper<OmsOrder> {

}
