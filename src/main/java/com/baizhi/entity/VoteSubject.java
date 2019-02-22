package com.baizhi.entity;

public class VoteSubject {
    private Integer vsId;
    private String vsTitle;
    private Integer vsType;

    public VoteSubject() {
        super();
    }

    public VoteSubject(Integer vsId, String vsTitle, Integer vsType) {
        super();
        this.vsId = vsId;
        this.vsTitle = vsTitle;
        this.vsType = vsType;
    }

    public Integer getVsId() {
        return this.vsId;
    }

    public void setVsId(Integer vsId) {
        this.vsId = vsId;
    }

    public String getVsTitle() {
        return this.vsTitle;
    }

    public void setVsTitle(String vsTitle) {
        this.vsTitle = vsTitle;
    }

    public Integer getVsType() {
        return this.vsType;
    }

    public void setVsType(Integer vsType) {
        this.vsType = vsType;
    }

}
