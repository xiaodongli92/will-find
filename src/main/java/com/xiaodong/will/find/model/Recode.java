package com.xiaodong.will.find.model;

/**
 * 一条记录
 */
public class Recode {

    private int num;

    private String time;

    private int rid;

    private String device;

    private int regularBuy;

    private User user;

    @Override
    public String toString() {
        return "Recode{" +
                "num=" + num +
                ", time='" + time + '\'' +
                ", rid=" + rid +
                ", device='" + device + '\'' +
                ", regularBuy=" + regularBuy +
                ", user=" + user +
                '}';
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public int getRegularBuy() {
        return regularBuy;
    }

    public void setRegularBuy(int regularBuy) {
        this.regularBuy = regularBuy;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
