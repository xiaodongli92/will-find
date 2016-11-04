package com.xiaodong.will.find.model.json;

import com.xiaodong.will.find.model.pojo.User;

/**
 * 一条记录
 */
public class Period {

    private String period;

    private int num;

    private String time;

    private int rid;

    private String device;

    private int regularBuy;

    private User user;

    private String uid;

    @Override
    public String toString() {
        return "Period{" +
                "period='" + period + '\'' +
                ", num=" + num +
                ", time='" + time + '\'' +
                ", rid=" + rid +
                ", device='" + device + '\'' +
                ", regularBuy=" + regularBuy +
                ", user=" + user +
                ", uid='" + uid + '\'' +
                '}';
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
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
