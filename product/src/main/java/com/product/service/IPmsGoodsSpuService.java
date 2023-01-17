package com.product.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.product.bo.PmsGoodsSpuBo;
import com.product.entity.PmsGoodsSpu;

import java.util.List;

/**
 * <p>
 * spu表（Standard Product Unit, 标准产品单元） 服务类
 * </p>
 *
 * @author y1nuo
 * @since 2023-01-10
 */
public interface IPmsGoodsSpuService extends IService<PmsGoodsSpu> {
    List<PmsGoodsSpuBo> getAllSpuByBrandId(Long brandId);

    List<PmsGoodsSpuBo> getProductInfoByIdList(List<Long> idList);

    Boolean decrementStock();
}
