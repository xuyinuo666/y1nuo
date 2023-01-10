package com.order.controller;


import com.system.userInfo.entity.UserInfo;
import com.system.userInfo.utils.UserInfoContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import res.BaseResponse;

/**
 * <p>
 * 订单表。订单表，需要注意的是订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单。 前端控制器
 * </p>
 *
 * @author y1nuo
 * @since 2023-01-10
 */
@RestController
@RequestMapping("/order")
public class OmsOrderController {
    @PostMapping("/test")
    public BaseResponse test(){
        UserInfo user = UserInfoContext.getUser();
        return BaseResponse.success("111");
    }
}
