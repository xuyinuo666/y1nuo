package com.oauth.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.oauth.entity.SysUserRole;
import com.oauth.mapper.SysUserRoleMapper;
import com.oauth.po.UserRolePo;
import com.oauth.service.ISysUserRoleService;
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
 * @since 2023-01-05
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {

    @Override
    public List<UserRolePo> getUserRoleByUserId(Long userId) {
        if (ObjectUtil.isNull(userId)){
            return new ArrayList<>();
        }
        List<SysUserRole> sysUserRoles = this.lambdaQuery().eq(SysUserRole::getUserId, userId).list();

        return BeanUtil.copyToList(sysUserRoles, UserRolePo.class);
    }
}
