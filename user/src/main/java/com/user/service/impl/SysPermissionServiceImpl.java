package com.user.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.user.entity.SysPermission;
import com.user.mapper.SysPermissionMapper;
import com.user.po.PermissionPo;
import com.user.service.ISysPermissionService;
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
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements ISysPermissionService {

    @Override
    public List<PermissionPo> getPermissionByPermissionId(List<Long> permissionIdList) {
        if (CollectionUtil.isEmpty(permissionIdList)) {
            return new ArrayList<>();
        }
        List<SysPermission> list = this.lambdaQuery().in(SysPermission::getId, permissionIdList).list();

        return BeanUtil.copyToList(list,PermissionPo.class);
    }
}
