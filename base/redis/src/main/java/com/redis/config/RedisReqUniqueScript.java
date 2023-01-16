package com.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;

@Configuration
public class RedisReqUniqueScript {

    @Bean
    public DefaultRedisScript<Boolean> checkReqUnique() {
        DefaultRedisScript<Boolean> defaultRedisScript = new DefaultRedisScript<>();
        defaultRedisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("lua/redisScript.lua")));
        defaultRedisScript.setResultType(Boolean.class);
        return defaultRedisScript;
    }
}