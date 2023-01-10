package com.order.openfeign;
import com.alibaba.fastjson.JSONObject;
import com.order.po.ProductPo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "product",path = "/product")
public interface ProductFeign {
    @GetMapping("/getProductInfoByIdList")
    List<JSONObject> getProductInfoByIdList(@RequestParam List<Long> productIdList);


}
