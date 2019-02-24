package com.baizhi.entity;

import java.io.Serializable;

public class UserResult implements Serializable {
    private boolean login;
    private VoteUser user;

    public UserResult(){}
    public UserResult(boolean login, VoteUser user) {
        this.login = login;
        this.user = user;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public VoteUser getUser() {
        return user;
    }

    public void setUser(VoteUser user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserResult{" +
                "login=" + login +
                ", user=" + user +
                '}';
    }
}
