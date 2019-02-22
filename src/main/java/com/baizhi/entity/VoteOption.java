package com.baizhi.entity;

public class VoteOption {
    private Integer voId;
    private Integer vsId;
    private String voOption;
    private Integer voOrder;

    public VoteOption() {
        super();
    }

    public VoteOption(Integer voId, Integer vsId, String voOption, Integer voOrder) {
        super();
        this.voId = voId;
        this.vsId = vsId;
        this.voOption = voOption;
        this.voOrder = voOrder;
    }

    public Integer getVoId() {
        return this.voId;
    }

    public void setVoId(Integer voId) {
        this.voId = voId;
    }

    public Integer getVsId() {
        return this.vsId;
    }

    public void setVsId(Integer vsId) {
        this.vsId = vsId;
    }

    public String getVoOption() {
        return this.voOption;
    }

    public void setVoOption(String voOption) {
        this.voOption = voOption;
    }

    public Integer getVoOrder() {
        return this.voOrder;
    }

    public void setVoOrder(Integer voOrder) {
        this.voOrder = voOrder;
    }

}
