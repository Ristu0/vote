package com.baizhi.entity;

public class VoteUser {
    private Integer vuUserId;
    private Integer vuVersion;
    private String vuUserName;
    private String vuPassword;
    private Integer vuStatus;

    public VoteUser() {
        super();
    }

    public VoteUser(Integer vuUserId, Integer vuVersion, String vuUserName, String vuPassword, Integer vuStatus) {
        super();
        this.vuUserId = vuUserId;
        this.vuVersion = vuVersion;
        this.vuUserName = vuUserName;
        this.vuPassword = vuPassword;
        this.vuStatus = vuStatus;
    }

    public Integer getVuUserId() {
        return this.vuUserId;
    }

    public void setVuUserId(Integer vuUserId) {
        this.vuUserId = vuUserId;
    }

    public Integer getVuVersion() {
        return this.vuVersion;
    }

    public void setVuVersion(Integer vuVersion) {
        this.vuVersion = vuVersion;
    }

    public String getVuUserName() {
        return this.vuUserName;
    }

    public void setVuUserName(String vuUserName) {
        this.vuUserName = vuUserName;
    }

    public String getVuPassword() {
        return this.vuPassword;
    }

    public void setVuPassword(String vuPassword) {
        this.vuPassword = vuPassword;
    }

    public Integer getVuStatus() {
        return this.vuStatus;
    }

    public void setVuStatus(Integer vuStatus) {
        this.vuStatus = vuStatus;
    }

}
