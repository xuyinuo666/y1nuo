package com.order.mapper;

import com.order.entity.OmsOrderReturnReason;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 订单退货原因表。用于会员退货时选择退货原因。 Mapper 接口
 * </p>
 *
 * @author y1nuo
 * @since 2023-01-10
 */
@Mapper
public interface OmsOrderReturnReasonMapper extends BaseMapper<OmsOrderReturnReason> {

}
