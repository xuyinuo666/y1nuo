package com.aop.aspectj;

import cn.hutool.core.lang.generator.SnowflakeGenerator;
import cn.hutool.core.util.StrUtil;
import com.aop.annotation.AddIdempotentParam;
import com.aop.annotation.DelIdempotentParam;
import com.aop.exception.IdempotentCheckException;
import com.redis.config.RedisReqUniqueScript;
import com.redis.util.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;

@Aspect
@Slf4j
public class IdempotentAspectj {
    /**
     * 用于SpEL表达式解析.
     */
    private SpelExpressionParser parser = new SpelExpressionParser();
    /**
     * 用于获取方法参数定义名字.
     */
    private DefaultParameterNameDiscoverer nameDiscoverer = new DefaultParameterNameDiscoverer();

    @Resource
    private RedisTemplate customRedisTemplate;

    @Resource
    private RedisUtils redisUtils;
    @Resource
    private DefaultRedisScript defaultRedisScript;
    @Resource
    private SnowflakeGenerator snowflakeGenerator;

    @Pointcut("@annotation(com.aop.annotation.Idempotent)")
    public void pointcut2() {

    }

    @Pointcut("@annotation(com.aop.annotation.AddIdempotentParam)")
    public void pointcut3() {

    }

    @Pointcut("@annotation(com.aop.annotation.DelIdempotentParam)")
    public void pointcut4() {

    }

    @Before(value = "pointcut2()")
    public void checkReqUnique() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String reqUniqueId = request.getHeader("reqUniqueId");
        if (StrUtil.isBlank(reqUniqueId)) {
            throw new IdempotentCheckException("缺少幂等性校验参数！");
        }

        Boolean execute = (Boolean) customRedisTemplate.execute(defaultRedisScript, Collections.singletonList(reqUniqueId));
        if (Boolean.FALSE.equals(execute)) {
            throw new IdempotentCheckException("重复提交！");
        }

    }

    @Before("pointcut3()")
    public void beforeOfReqAddUniqueParam(JoinPoint joinPoint) {

        MethodSignature sign = (MethodSignature) joinPoint.getSignature();
        Method method = sign.getMethod();

        AddIdempotentParam addIdempotentParam = method.getAnnotation(AddIdempotentParam.class);

        String value = addIdempotentParam.busUniqueId();
        String resV = generateKeyBySpEL(value, joinPoint);
        redisUtils.setObj(resV,1);
    }

    @Around(value = "pointcut4()")
    public void afterOfReqDelUniqueParam(ProceedingJoinPoint joinPoint) {

        MethodSignature sign = (MethodSignature) joinPoint.getSignature();
        Method method = sign.getMethod();

        DelIdempotentParam delIdempotentParam = method.getAnnotation(DelIdempotentParam.class);

        String value = delIdempotentParam.busUniqueId();

        String uniqueId = generateKeyBySpEL(value, joinPoint);
        String obj = redisUtils.getObj(uniqueId);
        if (StrUtil.isBlank(obj)){
            throw new RuntimeException("重复请求！");
        }
        try {
            joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }finally {
            redisUtils.del(uniqueId);
        }
    }


    public String generateKeyBySpEL(String spELString, JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String[] paramNames = nameDiscoverer.getParameterNames(methodSignature.getMethod());
        Expression expression = parser.parseExpression(spELString);
        EvaluationContext context = new StandardEvaluationContext();
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            context.setVariable(paramNames[i], args[i]);
        }
        return expression.getValue(context).toString();
    }
}
