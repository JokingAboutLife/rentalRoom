package com.gxust.edu.rental_room.query;

public class BaseQuery {
    //当前页数
    private Integer currentPageNum = 1;
    //每页显示条数
    private Integer pageSize = 10;
    //排序方式
    private String sortOrder;
    //是否分页
    private boolean paging = true;

    public Integer getCurrentPageNum() {
        return currentPageNum;
    }

    public void setCurrentPageNum(Integer currentPageNum) {
        this.currentPageNum = currentPageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public boolean isPaging() {
        return paging;
    }

    public void setPaging(boolean paging) {
        this.paging = paging;
    }
}
