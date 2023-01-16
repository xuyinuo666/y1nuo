package com.system.config;

import cn.hutool.core.lang.generator.SnowflakeGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SystemConfig {
    @Value("${machine-id}")
    private Long machineId;
    @Value("${data-center-id}")
    private Long dataCenterId;
    @Bean
    public SnowflakeGenerator snowflakeGenerator(){
        return new SnowflakeGenerator(machineId,dataCenterId);
    }
}
