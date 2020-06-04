package com.yize.www.springbootvue.utils;

import java.util.List;

public class PageModel {
    //默认第一页
    private Integer pageNum =1;
    //显示几条数据
    private int pageCount =5;
    //总数
    private Long pageTotal;
    //页码最大值（总页数）
    private int maxPageNum;

    private List rows ;

    private int start ;
    //从第几条开始(比如第3页就是当前页减去1 = 2 乘显示数量10条 = 20；从下标20开始显示)
    //              第4页         减去1 = 3 乘显示数量10条 = 30；从下标30开始 （以此类推）
    public int getStart() {
        return (pageNum - 1) * pageCount;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setPageTotal(long pageTotal) {
        this.pageTotal = pageTotal;
        //计算最大页码数
        maxPageNum = (int)((pageTotal + pageCount - 1) / pageCount);
        //maxPageNum = (int) (pageTotal%pageCount==0?pageTotal/pageCount:pageTotal/pageCount+1);
        //解决pageNum初始化问题
        if (pageNum < 1)pageNum=1;
        if (pageNum > maxPageNum) pageNum = maxPageNum;
    }
    public int getMaxPageNum() {
        return maxPageNum;
        //return (getPageTotal() + getPageCount() - 1) / getPageCount();
    }


    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public long getPageTotal() {
        return pageTotal;
    }

    public void setMaxPageNum(int maxPageNum) {
        this.maxPageNum = maxPageNum;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }





}
