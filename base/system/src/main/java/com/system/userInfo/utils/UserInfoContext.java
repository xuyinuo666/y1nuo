package com.system.userInfo.utils;

import com.system.userInfo.entity.UserInfo;

public class UserInfoContext {
    private static ThreadLocal<UserInfo> userInfo = new ThreadLocal<>();

    public static UserInfo getUser() {
        return (UserInfo) userInfo.get();
    }

    public static void setUser(UserInfo user) {
        userInfo.set(user);
    }

    public static void remove(){
        userInfo.remove();
    }
}
