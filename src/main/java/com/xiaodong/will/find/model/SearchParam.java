package com.xiaodong.will.find.model;

import java.io.Serializable;

/**
 * @Description: 查询参数
 * @Author: lixiaodong@souyidai.com
 * @CreateDate: 2016/6/22
 */
public class SearchParam implements Serializable {

    private static final long serialVersionUID = -5809782578272943990L;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

    @Override
    public String toString() {
        return "SearchParam{" +
                "startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
