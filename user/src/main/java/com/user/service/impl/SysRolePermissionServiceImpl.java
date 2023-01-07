package com.user.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.user.entity.SysRolePermission;
import com.user.mapper.SysRolePermissionMapper;
import com.user.po.RolePermissionPo;
import com.user.service.ISysRolePermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author y1nuo
 * @since 2023-01-07
 */
@Service
public class SysRolePermissionServiceImpl extends ServiceImpl<SysRolePermissionMapper, SysRolePermission> implements ISysRolePermissionService {

    @Override
    public List<RolePermissionPo> getRolePermissionListByRoleIdList(List<Long> roleIdList) {
        if (CollectionUtil.isEmpty(roleIdList)){
            return new ArrayList<>();
        }
        List<SysRolePermission> list = this.lambdaQuery().in(SysRolePermission::getRoleId, roleIdList).list();
        return BeanUtil.copyToList(list,RolePermissionPo.class);
    }
}
