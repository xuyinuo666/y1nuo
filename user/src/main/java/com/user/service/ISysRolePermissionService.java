package com.user.service;

import com.user.entity.SysRolePermission;
import com.baomidou.mybatisplus.extension.service.IService;
import com.user.po.RolePermissionPo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author y1nuo
 * @since 2023-01-07
 */
public interface ISysRolePermissionService extends IService<SysRolePermission> {
    List<RolePermissionPo> getRolePermissionListByRoleIdList(List<Long> roleIdList);
}
