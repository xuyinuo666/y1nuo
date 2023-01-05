package com.oauth.service;

import com.oauth.entity.SysUserRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.oauth.po.UserRolePo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author y1nuo
 * @since 2023-01-05
 */
public interface ISysUserRoleService extends IService<SysUserRole> {
    List<UserRolePo> getUserRoleByUserId(Long userId);
}
