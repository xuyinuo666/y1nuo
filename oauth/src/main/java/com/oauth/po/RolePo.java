package com.oauth.po;

import com.mybatis.base.BasePo;
import lombok.Data;

import java.io.Serializable;

@Data
public class RolePo extends BasePo implements Serializable {
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色CODE
     */
    private String roleCode;
    /**
     * 角色描述
     */
    private String description;
}
