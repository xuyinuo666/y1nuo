package com.oauth.security.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.oauth.po.RolePo;
import com.oauth.po.UserPo;
import com.oauth.po.UserRolePo;
import com.oauth.security.vo.SecurityUser;
import com.oauth.service.ISysRoleService;
import com.oauth.service.ISysUserRoleService;
import com.oauth.service.IUUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 查询登陆用户信息
 *
 * @author LiuYongTao
 * @date 2018/11/20 15:19
 */
@Slf4j
@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private IUUserService userService;
    @Autowired
    private ISysUserRoleService userRoleService;
    @Autowired
    private ISysRoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String usercode) throws UsernameNotFoundException {
        log.info("查询用户：{} 的信息...", usercode);
        Set<GrantedAuthority> authorities = new HashSet<>();
        if (StrUtil.isEmpty(usercode)) {
            throw new UsernameNotFoundException("用户名不能为空！");
        }

        // 查询用户信息
        UserPo user = userService.getUserByUserCode(usercode);

        if (user == null) {
            log.error("用户：{}，不存在！", usercode);
            throw new UsernameNotFoundException("用户：" + usercode + "，不存在");
        }
        if (!user.getValidInd()) {
            throw new UsernameNotFoundException("用户：" + usercode + "，被锁定");
        }
        // 查询角色信息
        List<UserRolePo> userRolePos = userRoleService.getUserRoleByUserId(user.getId());
        if (CollectionUtils.isEmpty(userRolePos)) {
            log.error("用户：{}，未分配角色！", usercode);
            throw new UsernameNotFoundException("用户：" + usercode + "，未分配角色");
        }

        List<Long> roleIdList = userRolePos.stream().map(UserRolePo::getRoleId).collect(Collectors.toList());
        List<RolePo> rolePoList = roleService.getRoleByRoleIdList(roleIdList);

        if (CollectionUtil.isEmpty(rolePoList)){
            throw new UsernameNotFoundException("用户：" + usercode + "，未分配权限");
        }
        rolePoList.forEach(rolePo -> authorities.add(new SimpleGrantedAuthority(rolePo.getRoleCode())));

        return new SecurityUser(user, authorities);
    }
}
