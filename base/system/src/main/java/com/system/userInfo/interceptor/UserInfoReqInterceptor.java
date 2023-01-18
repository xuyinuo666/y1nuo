package com.system.userInfo.interceptor;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONObject;
import com.alibaba.fastjson.JSON;
import com.system.userInfo.entity.UserInfo;
import com.system.userInfo.utils.UserInfoContext;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserInfoReqInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        UserInfo user = UserInfoContext.getUser();
        if (ObjectUtil.isNotNull(user)){
            JSONObject userInfoJb = new JSONObject();
            userInfoJb.put("id",user.getId());
            userInfoJb.put("user_name",user.getUsername());
            requestTemplate.header("user", JSON.toJSONString(userInfoJb));
        }
    }
}
