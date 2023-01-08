package com.user.init;

import org.springframework.beans.factory.InitializingBean;


public interface InitDataService extends InitializingBean {
    void initData();
}
