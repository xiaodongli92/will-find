package com.xiaodong.will.find.model.pojo;

import javax.persistence.*;

/**
 * 每一条记录
 */
@Entity
@Table(name = "RECORD")
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增长
    private long id = 0 ;

    @Column(length = 20)
    private String period;

    @Column
    private Integer num;

    @Column(length = 30)
    private String time;

    @Column
    private Integer rid;

    @Column(length = 128)
    private String device;

    @Column
    private Integer regularBuy;

    @Column(length = 128)
    private String uid;

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", period='" + period + '\'' +
                ", num=" + num +
                ", time='" + time + '\'' +
                ", rid=" + rid +
                ", device='" + device + '\'' +
                ", regularBuy=" + regularBuy +
                ", uid='" + uid + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public Integer getRegularBuy() {
        return regularBuy;
    }

    public void setRegularBuy(Integer regularBuy) {
        this.regularBuy = regularBuy;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
