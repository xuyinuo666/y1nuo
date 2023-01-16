package com.product.controller;


import com.product.po.PmsGoodsSpuPo;
import com.product.service.IPmsGoodsSpuService;
import com.product.vo.PmsGoodsSpuVo;
import com.system.dto.PmsGoodsSpuDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import res.BaseResponse;
import utils.ConvertUtils;

import javax.annotation.Resource;
import java.util.List;

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
    private IPmsGoodsSpuService spuService;
    @GetMapping("/getAllSpuByBrandId")
    public BaseResponse getAllSpuBySkuNo(@RequestParam Long brandId){
        List<PmsGoodsSpuPo> allSpu = spuService.getAllSpuByBrandId(brandId);
        List<PmsGoodsSpuVo> goodsSpuVos = ConvertUtils.convert(allSpu, PmsGoodsSpuVo.class);
        return BaseResponse.success(goodsSpuVos);
    }

    @GetMapping("/getProductInfoByIdList")
    public BaseResponse getProductInfoByIdList(@RequestParam List<Long> productIdList){
        List<PmsGoodsSpuPo> allSpu = spuService.getProductInfoByIdList(productIdList);
        List<PmsGoodsSpuDto> goodsSpuVos = ConvertUtils.convert(allSpu, PmsGoodsSpuDto.class);
        int a = 1/ 0;
        return BaseResponse.success(goodsSpuVos);
    }
}
