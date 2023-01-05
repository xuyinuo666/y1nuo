package com.oauth.service;

import com.oauth.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.oauth.po.RolePo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author y1nuo
 * @since 2023-01-05
 */
public interface ISysRoleService extends IService<SysRole> {
    List<RolePo> getRoleByRoleIdList(List<Long> roleIdList);
}
