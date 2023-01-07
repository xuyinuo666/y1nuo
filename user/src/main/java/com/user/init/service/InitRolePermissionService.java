package com.user.init.service;

import com.redis.util.RedisUtils;
import com.user.init.InitDataService;
import com.user.po.PermissionPo;
import com.user.po.RolePermissionPo;
import com.user.po.RolePo;
import com.user.service.ISysPermissionService;
import com.user.service.ISysRolePermissionService;
import com.user.service.ISysRoleService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InitRolePermissionService implements InitDataService {
    @Resource
    private RedisUtils redisUtils;

    @Resource
    private ISysRoleService roleService;
    @Resource
    private ISysRolePermissionService rolePermissionService;
    @Resource
    private ISysPermissionService permissionService;

    @Override
    public void initData() {
        List<RolePo> rolePos = roleService.allRoleList();

        List<Long> roleIdList = rolePos.stream().map(RolePo::getId).collect(Collectors.toList());

        List<RolePermissionPo> rolePermissionList= rolePermissionService.getRolePermissionListByRoleIdList(roleIdList);

        List<Long> permissionIdList = rolePermissionList.stream().map(RolePermissionPo::getPermissionId).collect(Collectors.toList());

        List<PermissionPo> permission = permissionService.getPermissionByPermissionId(permissionIdList);


    }

    @Override
    public void afterPropertiesSet() throws Exception {
        initData();
    }
}
