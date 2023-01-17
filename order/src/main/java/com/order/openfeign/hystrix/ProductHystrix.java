package com.order.openfeign.hystrix;

import com.order.bo.OrderBo;
import com.order.dto.PmsGoodsSpuDto;
import com.order.openfeign.ProductFeign;
import com.system.hystrix.GlobalHystrix;
import org.springframework.stereotype.Component;
import res.BaseResponse;

import java.util.List;
@Component
public class ProductHystrix implements ProductFeign, GlobalHystrix {
    @Override
    public BaseResponse<Boolean> noticeProduct(String uniqueId) {
        return this.fallback();
    }
}
