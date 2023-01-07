package com.user.service;

import com.user.entity.SysPermission;
import com.baomidou.mybatisplus.extension.service.IService;
import com.user.po.PermissionPo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author y1nuo
 * @since 2023-01-07
 */
public interface ISysPermissionService extends IService<SysPermission> {

    List<PermissionPo> getPermissionByPermissionId(List<Long> permissionIdList);

}
