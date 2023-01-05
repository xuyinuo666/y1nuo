package com.oauth.po;

import com.mybatis.base.BasePo;
import lombok.Data;

import java.io.Serializable;

/**
 * user与role关联关系，多对多
 */
@Data
public class UserRolePo extends BasePo implements Serializable {
    // 用户id
    private Long userId;
    // 角色id
    private Long roleId;
}
