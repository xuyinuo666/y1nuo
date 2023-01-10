package com.product.service;

import com.product.entity.PmsGoodsSpu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.product.po.PmsGoodsSpuPo;

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
    List<PmsGoodsSpuPo> getAllSpuByBrandId(Long brandId);

    List<PmsGoodsSpuPo> getProductInfoByIdList(List<Long> idList);
}
