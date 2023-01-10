package com.system.userInfo.filter;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.system.userInfo.entity.UserInfo;
import com.system.userInfo.utils.UserInfoContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@Component
public class UserInfoFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        this.initUserInfo((HttpServletRequest) servletRequest);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    private void initUserInfo(HttpServletRequest servletRequest) {
        String userStr = servletRequest.getHeader("user");
        if (StrUtil.isNotBlank(userStr)) {

            JSONObject userInfoJsonObject = JSONObject.parseObject(userStr);
            UserInfo userInfo = new UserInfo();

            Long id = userInfoJsonObject.getLong("id");
            if (id != null) {
                userInfo.setId(id);
            }
            String username = userInfoJsonObject.getString("user_name");
            if (StrUtil.isNotBlank(username)) {
                userInfo.setUsername(username);
            }
            UserInfoContext.setUser(userInfo);
        }

    }

    @Override
    public void destroy() {
        UserInfoContext.remove();
    }
}
