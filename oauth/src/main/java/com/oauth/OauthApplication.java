package com.oauth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@EnableDiscoveryClient
@SpringBootApplication
@EnableOAuth2Client
@MapperScan("com.oauth.mapper")
public class OauthApplication {
    public static void main(String[] args) {
        SpringApplication.run(OauthApplication.class);
    }
}
