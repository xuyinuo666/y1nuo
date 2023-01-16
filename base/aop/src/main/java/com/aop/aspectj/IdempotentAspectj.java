package com.aop.aspectj;

import cn.hutool.core.util.StrUtil;
import com.aop.exception.IdempotentCheckException;
import com.redis.config.RedisReqUniqueScript;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collections;

@Aspect
@Slf4j
public class IdempotentAspectj {

    @Resource
    private RedisTemplate customRedisTemplate;
    @Resource
    private DefaultRedisScript defaultRedisScript;


    @Pointcut("@annotation(com.aop.annotation.Idempotent)")
    public void pointcut2(){

    }
    @Before(value = "pointcut2()")
    public void checkReqUnique() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String reqUniqueId = request.getHeader("reqUniqueId");
        if (StrUtil.isBlank(reqUniqueId)){
            throw new IdempotentCheckException("缺少幂等性校验参数！");
        }

        Boolean execute = (Boolean) customRedisTemplate.execute(defaultRedisScript, Collections.singletonList(reqUniqueId));
        if (Boolean.FALSE.equals(execute)){
            throw new IdempotentCheckException("重复提交！");
        }

    }
}
