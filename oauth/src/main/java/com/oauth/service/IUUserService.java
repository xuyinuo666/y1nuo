package com.oauth.service;

import com.oauth.entity.UUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.oauth.po.UserPo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author y1nuo
 * @since 2023-01-05
 */
public interface IUUserService extends IService<UUser> {
    UserPo getUserByUserCode(String userCode);
}
