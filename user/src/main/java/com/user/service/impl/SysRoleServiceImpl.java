package com.user.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.user.entity.SysRole;
import com.user.mapper.SysRoleMapper;
import com.user.po.RolePo;
import com.user.service.ISysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    @Override
    public List<RolePo> allRoleList() {
        List<SysRole> list = this.list();
        return BeanUtil.copyToList(list,RolePo.class);
    }
}
