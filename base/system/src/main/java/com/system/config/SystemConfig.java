package com.system.config;

import cn.hutool.core.lang.generator.SnowflakeGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class SystemConfig {
    @Value("${machine-id}")
    private Long machineId;
    @Value("${data-center-id}")
    private Long dataCenterId;

    @Bean
    public SnowflakeGenerator snowflakeGenerator() {
        return new SnowflakeGenerator(machineId, dataCenterId);
    }

    @Bean
    public ThreadPoolTaskExecutor threadPoolExecutor() {
        int processors = Runtime.getRuntime().availableProcessors();
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(processors);//核心线程大小
        taskExecutor.setMaxPoolSize(processors * 2);//最大线程大小
        taskExecutor.setQueueCapacity(500);//队列最大容量
        //当提交的任务个数大于QueueCapacity，就需要设置该参数，但spring提供的都不太满足业务场景，可以自定义一个，也可以注意不要超过QueueCapacity即可
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        taskExecutor.setAwaitTerminationSeconds(10);
        taskExecutor.setThreadNamePrefix("y1-Thread-");
        taskExecutor.initialize();
        return taskExecutor;
    }
}
