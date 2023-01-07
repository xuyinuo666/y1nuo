package com.user.service;

import com.user.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.user.po.RolePo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author y1nuo
 * @since 2023-01-07
 */
public interface ISysRoleService extends IService<SysRole> {
    List<RolePo> allRoleList();
}
