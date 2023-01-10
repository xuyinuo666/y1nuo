package com.product.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.product.entity.PmsGoodsSpu;
import com.product.mapper.PmsGoodsSpuMapper;
import com.product.po.PmsGoodsSpuPo;
import com.product.service.IPmsGoodsSpuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * spu表（Standard Product Unit, 标准产品单元） 服务实现类
 * </p>
 *
 * @author y1nuo
 * @since 2023-01-10
 */
@Service
public class PmsGoodsSpuServiceImpl extends ServiceImpl<PmsGoodsSpuMapper, PmsGoodsSpu> implements IPmsGoodsSpuService {

    @Override
    public List<PmsGoodsSpuPo> getAllSpuByBrandId(Long brandId) {
        if (brandId==null || brandId<0){
            return new ArrayList<>();
        }
        return BeanUtil.copyToList(this.lambdaQuery().eq(PmsGoodsSpu::getBrandId,brandId).list(),PmsGoodsSpuPo.class);
    }

    @Override
    public List<PmsGoodsSpuPo> getProductInfoByIdList(List<Long> idList) {
        if (CollectionUtil.isEmpty(idList)){
            return new ArrayList<>();
        }
        return BeanUtil.copyToList(this.lambdaQuery().in(PmsGoodsSpu::getId,idList).list(),PmsGoodsSpuPo.class);
    }
}
