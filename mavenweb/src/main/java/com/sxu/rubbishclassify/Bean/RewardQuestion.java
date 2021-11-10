package com.sxu.rubbishclassify.Bean;

public class RewardQuestion {
    private int id;
    private String url;
    private int recycle;
    private int harm;
    private int cook;
    private int other;
    private int unknow;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getRecycle() {
        return recycle;
    }

    public void setRecycle(int recycle) {
        this.recycle = recycle;
    }

    public int getHarm() {
        return harm;
    }

    public void setHarm(int harm) {
        this.harm = harm;
    }

    public int getCook() {
        return cook;
    }

    public void setCook(int cook) {
        this.cook = cook;
    }

    public int getOther() {
        return other;
    }

    public void setOther(int other) {
        this.other = other;
    }

    public int getUnknow() {
        return unknow;
    }

    public void setUnknow(int unknow) {
        this.unknow = unknow;
    }
}
