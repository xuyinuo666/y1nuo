package com.order.openfeign.hystrix;

import com.order.openfeign.ProductFeign;
import com.system.hystrix.GlobalHystrix;
import org.springframework.stereotype.Component;
import res.BaseResponse;

import java.util.List;
@Component
public class ProductHystrix implements ProductFeign, GlobalHystrix {
    @Override
    public BaseResponse getProductInfoByIdList(List<Long> productIdList) {
        return this.fallback();
    }
}
