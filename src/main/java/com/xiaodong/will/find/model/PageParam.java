package com.xiaodong.will.find.model;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: 分页参数
 * @Author: lixiaodong@souyidai.com
 * @CreateDate: 2016/6/21
 */
public class PageParam implements Serializable {

    private static final long serialVersionUID = -5809782578272943999L;

    /**
     * 当前页
     */
    private int pageNo;

    /**
     * 每页显示条数 默认每页10条
     */
    private int pageSize = 10;

    /**
     * 排序
     */
    private String orderIdsStr = "createTime";

    /**
     * 总页数
     */
    private int totalPage;

    /**
     * 总条数
     */
    private long totalCount;

    /**
     * 查询结果
     */
    private List<?> results;

    /**
     * 查询前必须要执行此方法
     */
    public void init(){
        totalPage = (int) Math.ceil(totalCount / (float) pageSize);
        if (pageNo > totalPage - 1 || pageNo < 0) {
            pageNo = 0;
        }
    }

    /**
     * 查询开始
     * @return
     */
    public int getSkip(){
        return pageNo * pageSize;
    }

    /**
     * 不分页查询
     */
    public void notPage() {
        this.pageNo = 0;
        this.pageSize = 0;
    }

    @Override
    public String toString() {
        return "PageParam{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", orderIdsStr='" + orderIdsStr + '\'' +
                ", totalPage=" + totalPage +
                ", totalCount=" + totalCount +
                '}';
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderIdsStr() {
        return orderIdsStr;
    }

    public void setOrderIdsStr(String orderIdsStr) {
        this.orderIdsStr = orderIdsStr;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public List<?> getResults() {
        return results;
    }

    public void setResults(List<?> results) {
        this.results = results;
    }
}
