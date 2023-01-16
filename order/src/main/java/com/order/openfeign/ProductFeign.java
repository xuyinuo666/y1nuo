package com.order.openfeign;
import com.order.openfeign.hystrix.ProductHystrix;
import com.system.dto.PmsGoodsSpuDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import res.BaseResponse;

import java.util.List;

@FeignClient(value = "product",fallback = ProductHystrix.class)
public interface ProductFeign {
    @GetMapping("/product/getProductInfoByIdList")
    BaseResponse getProductInfoByIdList(@RequestParam List<Long> productIdList);


}
