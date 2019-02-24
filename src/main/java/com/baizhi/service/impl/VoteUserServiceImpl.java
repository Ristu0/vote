package com.baizhi.service.impl;

import com.baizhi.dao.VoteUserDao;
import com.baizhi.entity.UserResult;
import com.baizhi.entity.VoteUser;
import com.baizhi.service.VoteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VoteUserServiceImpl implements VoteUserService {
    @Autowired
    private VoteUserDao voteUserDao;

    @Override
    public UserResult login(String username, String password) {
        UserResult userResult;
        VoteUser voteUser = voteUserDao.selectByName(username);
        if (voteUser==null){
            userResult = new UserResult(false,null);
        }else {
            if (password.equals(voteUser.getVuPassword())){
                userResult = new UserResult(true,voteUser);
            }else{
                userResult = new UserResult(false,null);
            }
        }
        return userResult;
    }

    @Override
    public UserResult regist(VoteUser user) {
        VoteUser voteUser = voteUserDao.selectByName(user.getVuUserName());
        UserResult result;
        if (voteUser==null){
            voteUserDao.insertVoteUser(user);
            VoteUser voteUser1 = voteUserDao.selectByName(user.getVuUserName());
            result = new UserResult(true,voteUser1);
            return result;
        }else {
            result = new UserResult(false,null);
            return result;
        }
    }
}