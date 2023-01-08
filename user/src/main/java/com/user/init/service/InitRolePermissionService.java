package com.user.init.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.redis.util.RedisUtils;
import com.user.init.InitDataService;
import com.user.po.PermissionPo;
import com.user.po.RolePermissionPo;
import com.user.po.RolePo;
import com.user.service.ISysPermissionService;
import com.user.service.ISysRolePermissionService;
import com.user.service.ISysRoleService;
import constant.RedisCst;
import org.springframework.stereotype.Service;
import vo.PermissionVo;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
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
        // role
        List<RolePo> rolePos = roleService.allRoleList();

        List<Long> roleIdList = rolePos.stream().map(RolePo::getId).collect(Collectors.toList());

        // rolePer
        List<RolePermissionPo> rolePermissionList = rolePermissionService.getRolePermissionListByRoleIdList(roleIdList);

        List<Long> permissionIdList = rolePermissionList.stream().map(RolePermissionPo::getPermissionId).collect(Collectors.toList());

        // per
        List<PermissionPo> permission = permissionService.getPermissionByPermissionId(permissionIdList);

        Map<String, List<PermissionVo>> roleMap = new HashMap<>();

        Map<Long, List<RolePermissionPo>> roleIdPerListMap = rolePermissionList.stream().collect(Collectors.groupingBy(RolePermissionPo::getRoleId));

        Map<Long, PermissionPo> perIdUrlMap = permission.stream().collect(Collectors.toMap(PermissionPo::getId, Function.identity()));

        rolePos.forEach(rolePo -> {
            String roleCode = rolePo.getRoleCode();
            List<RolePermissionPo> rolePermissionPos = roleIdPerListMap.get(rolePo.getId());
            List<PermissionVo> res  = new ArrayList<>();
            rolePermissionPos.forEach(rolePermissionPo -> {
                Long permissionId = rolePermissionPo.getPermissionId();
                PermissionPo permissionPo = perIdUrlMap.get(permissionId);
                PermissionVo permissionVo = BeanUtil.copyProperties(permissionPo, PermissionVo.class);
                res.add(permissionVo);
            });
            roleMap.put(roleCode,res);
        });
        redisUtils.setHash(RedisCst.ROLE_PERMISSION_KEY, roleMap);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        initData();
    }
}
