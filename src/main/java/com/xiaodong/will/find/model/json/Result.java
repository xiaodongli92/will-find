package com.xiaodong.will.find.model.json;

import java.util.List;

/**
 * 数据
 */
public class Result {

    private int pageSize;

    private int totalCnt;

    private int pageNum;

    private List<Period> list;

    @Override
    public String toString() {
        return "Result{" +
                "pageSize=" + pageSize +
                ", totalCnt=" + totalCnt +
                ", pageNum=" + pageNum +
                ", list=" + list +
                '}';
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(int totalCnt) {
        this.totalCnt = totalCnt;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public List<Period> getList() {
        return list;
    }

    public void setList(List<Period> list) {
        this.list = list;
    }
}
