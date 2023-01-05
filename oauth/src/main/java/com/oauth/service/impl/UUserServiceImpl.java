package com.oauth.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.oauth.entity.UUser;
import com.oauth.mapper.UUserMapper;
import com.oauth.po.UserPo;
import com.oauth.service.IUUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author y1nuo
 * @since 2023-01-05
 */
@Service
public class UUserServiceImpl extends ServiceImpl<UUserMapper, UUser> implements IUUserService {

    @Override
    public UserPo getUserByUserCode(String userCode) {
        UUser user = this.lambdaQuery().eq(StrUtil.isNotBlank(userCode), UUser::getUsercode, userCode).one();
        return BeanUtil.copyProperties(user,UserPo.class);
    }
}
