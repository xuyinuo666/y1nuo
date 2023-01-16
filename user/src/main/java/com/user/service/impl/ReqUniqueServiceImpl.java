package com.user.service.impl;

import cn.hutool.core.lang.generator.SnowflakeGenerator;
import com.redis.util.RedisUtils;
import com.user.service.ReqUniqueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class ReqUniqueServiceImpl implements ReqUniqueService {
    @Resource
    private SnowflakeGenerator snowflakeGenerator;
    @Resource
    private RedisUtils redisUtils;
    @Override
    public Long genUniqueId() {
        Long next = snowflakeGenerator.next();
        redisUtils.setObj(next.toString(),1,1L,TimeUnit.MINUTES);
        return next;
    }
}
