package com.example.atom.model;

public class PagingModel {
    private int totalListNum;
    private int firstPageNo;
    private int lastPageNo;
    private int startPageNo = 1;
    private int endPageNo;
    private Integer curPageNo;
    private int pageSize;
    private boolean prevPage;
    private boolean nextPage;

    public boolean isPrevPage() {
        return prevPage;
    }

    public void setPrevPage(boolean prevPage) {
        this.prevPage = prevPage;
    }

    public boolean isNextPage() {
        return nextPage;
    }

    public void setNextPage(boolean nextPage) {
        this.nextPage = nextPage;
    }

    public int getStartPageNo() {
        return startPageNo;
    }

    public void setStartPageNo(int startPageNo) {
        this.startPageNo = startPageNo;
    }

    public int getEndPageNo() {
        return endPageNo;
    }

    public void setEndPageNo(int endPageNo) {
        this.endPageNo = endPageNo;
    }

    public int getTotalListNum() {
        return totalListNum;
    }

    public void setTotalListNum(int totalListNum) {
        this.totalListNum = totalListNum;
    }

    public int getFirstPageNo() {
        return firstPageNo;
    }

    public void setFirstPageNo(int firstPageNo) {
        this.firstPageNo = firstPageNo;
    }

    public int getLastPageNo() {
        return lastPageNo;
    }

    public void setLastPageNo(int lastPageNo) {
        this.lastPageNo = lastPageNo;
    }

    public Integer getCurPageNo() {
        return curPageNo;
    }

    public void setCurPageNo(Integer curPageNo) {
        this.curPageNo = curPageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }




}
