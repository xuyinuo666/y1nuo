package com.user.init;

import com.redis.util.RedisUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


public interface InitDataService extends InitializingBean {
    void initData();
}
