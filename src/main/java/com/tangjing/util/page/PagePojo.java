package com.tangjing.util.page;

import java.util.List;
import java.util.Map;

/**
 * Describe:
 * User:tangjing
 * Date:2017/3/6
 * Time:下午12:45
 */

public class PagePojo<T> {


    private int                 pages;          //总页数
    private int                 page;           //当前页
    private int                 nums;           //每页显示条数
    private int                 start;          //起始条
    private int                 end;            //结束条
    private int                 totalNums;      //总条数
    private int                 groups;         //连续显示分页数
    private Map<String, Object> paramMap;       //查询参数
    private List<T>             datas;          //查询结果

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getNums() {
        return nums;
    }

    public void setNums(int nums) {
        this.nums = nums;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getTotalNums() {
        return totalNums;
    }

    public void setTotalNums(int totalNums) {
        this.totalNums = totalNums;
    }

    public int getGroups() {
        return groups;
    }

    public void setGroups(int groups) {
        this.groups = groups;
    }

    public Map<String, Object> getParamMap() {
        return paramMap;
    }

    public void setParamMap(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    //组装前端分页控件所需参数
    public void init(int totalNums) {
        setTotalNums(totalNums);
        this.pages = this.totalNums%this.nums==0?this.totalNums/this.nums:this.totalNums/this.nums+1;
        this.start = (this.page - 1) * this.getNums();
        this.end = this.page * this.getNums();
        if (page > 10)
            this.groups = 10;
        else {
            if (page > 5)
                this.groups = 5;
            else
                this.groups = 1;
        }
    }
}


