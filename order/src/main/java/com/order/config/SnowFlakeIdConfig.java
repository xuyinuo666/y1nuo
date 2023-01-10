package com.order.config;

import cn.hutool.core.lang.generator.SnowflakeGenerator;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "snowflake")
@Data
public class SnowFlakeIdConfig {

    private Long machineId;

    private Long dataCenterId;

    @Bean
    public SnowflakeGenerator snowflakeGenerator(){
        return new SnowflakeGenerator(1,dataCenterId);
    }

}
