package com.order.mapper;

import com.order.entity.OmsOrderSetting;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 订单设置表。用于对订单的一些超时操作进行设置。 Mapper 接口
 * </p>
 *
 * @author y1nuo
 * @since 2023-01-10
 */
@Mapper
public interface OmsOrderSettingMapper extends BaseMapper<OmsOrderSetting> {

}
