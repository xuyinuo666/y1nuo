package com.oauth.config;

import com.oauth.security.service.CustomUserDetailsService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Base64Utils;

import java.util.Base64;

/**
 * @author liuyongtao
 * @create 2019-05-21 10:11
 */
@Configuration
public class AppBeanConfig {

    @Bean
    @ConditionalOnMissingBean(UserDetailsService.class)
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("987dc66e-bf0e-4e2b-baca-75abc058070a");
        System.out.println(111);
    }
}
