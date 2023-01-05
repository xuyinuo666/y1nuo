package com.oauth.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.oauth.entity.SysRole;
import com.oauth.mapper.SysRoleMapper;
import com.oauth.po.RolePo;
import com.oauth.service.ISysRoleService;
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
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    @Override
    public List<RolePo> getRoleByRoleIdList(List<Long> roleIdList) {
        if (CollectionUtil.isEmpty(roleIdList)){
            return new ArrayList<>();
        }
        return BeanUtil.copyToList(this.lambdaQuery().in(SysRole::getId,roleIdList).list(), RolePo.class);
    }
}
