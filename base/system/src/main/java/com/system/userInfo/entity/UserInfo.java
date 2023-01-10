package com.system.userInfo.entity;

import lombok.Data;
import java.io.Serializable;

@Data
public class UserInfo implements Serializable {
    private Long id; //用户id
    private String username;//用户名
}
