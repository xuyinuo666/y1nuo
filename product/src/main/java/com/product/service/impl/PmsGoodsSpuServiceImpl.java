package com.product.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aop.annotation.DelIdempotentParam;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.product.bo.PmsGoodsSpuBo;
import com.product.entity.PmsGoodsSpu;
import com.product.mapper.PmsGoodsSpuMapper;
import com.product.service.IPmsGoodsSpuService;
import com.redis.util.RedisLockUtil;
import com.system.userInfo.utils.UserInfoContext;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 * spu表（Standard Product Unit, 标准产品单元） 服务实现类
 * </p>
 *
 * @author y1nuo
 * @since 2023-01-10
 */
@Service
public class PmsGoodsSpuServiceImpl extends ServiceImpl<PmsGoodsSpuMapper, PmsGoodsSpu> implements IPmsGoodsSpuService ,Runnable{
    @Resource
    private RedissonClient redissonClient;
    @Resource
    private ThreadPoolTaskExecutor taskExecutor;
    @Override
    public List<PmsGoodsSpuBo> getAllSpuByBrandId(Long brandId) {
        if (brandId == null || brandId < 0) {
            return new ArrayList<>();
        }
        return BeanUtil.copyToList(this.lambdaQuery().eq(PmsGoodsSpu::getBrandId, brandId).list(), PmsGoodsSpuBo.class);
    }

    @Override
    public List<PmsGoodsSpuBo> getProductInfoByIdList(List<Long> idList) {
        if (CollectionUtil.isEmpty(idList)) {
            return new ArrayList<>();
        }
        return BeanUtil.copyToList(this.lambdaQuery().in(PmsGoodsSpu::getId, idList).list(), PmsGoodsSpuBo.class);
    }

    @Override
    @DelIdempotentParam(busUniqueId = "123456")
    public Boolean decrementStock(){
        Long userId = UserInfoContext.getUser().getId();
        return true;
    }

    @Override
    public void run() {

    }
}
