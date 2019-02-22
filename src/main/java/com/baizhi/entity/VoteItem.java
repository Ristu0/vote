package com.baizhi.entity;

public class VoteItem {
    private Integer viId;
    private String vuUserId;
    private Integer vsId;
    private Integer voId;

    public VoteItem() {
        super();
    }

    public VoteItem(Integer viId, String vuUserId, Integer vsId, Integer voId) {
        super();
        this.viId = viId;
        this.vuUserId = vuUserId;
        this.vsId = vsId;
        this.voId = voId;
    }

    public Integer getViId() {
        return this.viId;
    }

    public void setViId(Integer viId) {
        this.viId = viId;
    }

    public String getVuUserId() {
        return this.vuUserId;
    }

    public void setVuUserId(String vuUserId) {
        this.vuUserId = vuUserId;
    }

    public Integer getVsId() {
        return this.vsId;
    }

    public void setVsId(Integer vsId) {
        this.vsId = vsId;
    }

    public Integer getVoId() {
        return this.voId;
    }

    public void setVoId(Integer voId) {
        this.voId = voId;
    }

}
