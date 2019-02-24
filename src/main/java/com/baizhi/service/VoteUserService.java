package com.baizhi.service;

import com.baizhi.entity.UserResult;
import com.baizhi.entity.VoteUser;


public interface VoteUserService {
    /**
     * 用户登录
     *
     * @return
     */
    UserResult login(String username,String password);

    /**
     * 用户注册
     *
     * @return
     */
    UserResult regist(VoteUser user);

}