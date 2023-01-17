package com.product.controller;


import cn.hutool.core.date.LocalDateTimeUtil;
import com.alibaba.fastjson.JSONObject;
import com.product.bo.PmsGoodsSpuBo;
import com.product.service.IPmsGoodsSpuService;
import com.product.vo.PmsGoodsSpuVo;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.*;
import res.BaseResponse;
import utils.ConvertUtils;

import javax.annotation.Resource;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * spu表（Standard Product Unit, 标准产品单元） 前端控制器
 * </p>
 *
 * @author y1nuo
 * @since 2023-01-10
 */
@RestController
@RequestMapping("/product")
public class PmsGoodsSpuController {
    @Resource
    private ThreadPoolTaskExecutor taskExecutor;
    @Resource
    private IPmsGoodsSpuService spuService;

    @Resource
    private RedissonClient redissonClient;

    @GetMapping("/getAllSpuByBrandId")
    public BaseResponse getAllSpuBySkuNo(@RequestParam Long brandId) {
        List<PmsGoodsSpuBo> allSpu = spuService.getAllSpuByBrandId(brandId);
        List<PmsGoodsSpuVo> goodsSpuVos = ConvertUtils.convert(allSpu, PmsGoodsSpuVo.class);
        return BaseResponse.success(goodsSpuVos);
    }

    @GetMapping("/getProductInfoByIdList")
    public BaseResponse getProductInfoByIdList(@RequestParam List<Long> productIdList) {
        List<PmsGoodsSpuBo> allSpu = spuService.getProductInfoByIdList(productIdList);
        List<PmsGoodsSpuVo> goodsSpuVos = ConvertUtils.convert(allSpu, PmsGoodsSpuVo.class);
        return BaseResponse.success(goodsSpuVos);
    }

    @PostMapping("/decrementStock")
    public BaseResponse<Boolean> decrementStock() {
        spuService.decrementStock();
        return BaseResponse.success(111);
    }
}
