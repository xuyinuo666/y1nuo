package com.oauth.po;


import com.mybatis.base.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserPo extends BasePo implements Serializable {

    private String username;

    private String usercode;

    private String password;

    private String sex;

    private Date birthDate;

    private String phone;

    private String address;

    private String description;

    private String iconUrl;
}
