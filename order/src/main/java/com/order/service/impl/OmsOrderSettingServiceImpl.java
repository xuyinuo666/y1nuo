package com.order.service.impl;

import com.order.entity.OmsOrderSetting;
import com.order.mapper.OmsOrderSettingMapper;
import com.order.service.IOmsOrderSettingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单设置表。用于对订单的一些超时操作进行设置。 服务实现类
 * </p>
 *
 * @author y1nuo
 * @since 2023-01-10
 */
@Service
public class OmsOrderSettingServiceImpl extends ServiceImpl<OmsOrderSettingMapper, OmsOrderSetting> implements IOmsOrderSettingService {

}
