package com.order.openfeign;

import com.aop.annotation.AddIdempotentParam;
import com.order.bo.OrderBo;
import com.order.openfeign.hystrix.ProductHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import res.BaseResponse;

@FeignClient(value = "product",fallback = ProductHystrix.class)
public interface ProductFeign {
    @PostMapping("/product/decrementStock")
    @AddIdempotentParam(busUniqueId = "#uniqueId")
    BaseResponse<Boolean> noticeProduct(@RequestParam String uniqueId);
}
