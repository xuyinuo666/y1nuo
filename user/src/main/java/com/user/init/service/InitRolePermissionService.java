package com.user.init.service;

import com.redis.util.RedisUtils;
import com.user.init.InitDataService;
import com.user.po.PermissionPo;
import com.user.po.RolePermissionPo;
import com.user.po.RolePo;
import com.user.service.ISysPermissionService;
import com.user.service.ISysRolePermissionService;
import com.user.service.ISysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
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

        Map<Long, String> collect1 = rolePos.stream().collect(Collectors.toMap(RolePo::getId, RolePo::getRoleCode));

        List<Long> roleIdList = rolePos.stream().map(RolePo::getId).collect(Collectors.toList());

        List<RolePermissionPo> rolePermissionList= rolePermissionService.getRolePermissionListByRoleIdList(roleIdList);

        List<Long> permissionIdList = rolePermissionList.stream().map(RolePermissionPo::getPermissionId).collect(Collectors.toList());

        List<PermissionPo> permission = permissionService.getPermissionByPermissionId(permissionIdList);

        Map<Long, String> collect = permission.stream().collect(Collectors.toMap(PermissionPo::getId, PermissionPo::getUrl));

        Map<Long, Long> roleIdPerIdMap = rolePermissionList.stream().collect(Collectors.toMap(RolePermissionPo::getRoleId, RolePermissionPo::getPermissionId));

        for (Long roleId : roleIdList) {
            Long aLong = roleIdPerIdMap.get(roleId);
            String per = collect.get(aLong);
            String role = collect1.get(aLong);
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        initData();
    }
}
