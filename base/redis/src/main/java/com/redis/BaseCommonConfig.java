package com.redis;

import com.redis.util.RedisLockUtil;
import com.redis.util.RedisUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuyongtao
 * @since 2021-2-3 11:32
 */
@Configuration
public class BaseCommonConfig {

    /**
     * redis分布式锁帮助类
     *
     * @author liuyongtao
     * @since 2021-2-3 11:40
     */
    @Bean
    public RedisLockUtil redissLockUtil() {
        return new RedisLockUtil();
    }

    /**
     * redis工具类
     *
     * @return {@link RedisUtils}
     * @author liuyongtao
     * @since 2021-2-3 11:40
     */
    @Bean
    public RedisUtils redisUtils() {
        return new RedisUtils();
    }
}
