package com.order.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 订单退货申请表。主要用于存储会员退货申请信息，需要注意的是订单退货申请表的四种状态：0->待处理；1->退货中；2->已完成；3->已拒绝。 前端控制器
 * </p>
 *
 * @author y1nuo
 * @since 2023-01-10
 */
@Controller
@RequestMapping("/oms-order-return-apply")
public class OmsOrderReturnApplyController {

}
