package com.example.atom.model;

/**
 * 웹 페이징 처리를 위한 페이징 모델.
 * @author sykim@ntels.com
 */
public class PagingModel {
    /**
     * 총 Deployment Group 리스트 수
     */
    private int totalListNum;
    /**
     * 모든 페이지 중 첫 번째 페이지 번호
     */
    private int firstPageNo;
    /**
     * 모든 페이지 중 마지막 페이지 번호
     */
    private int lastPageNo;
    /**
     * 현재 페이지가 속한 block의 첫번째 페이지 번호
     */
    private int startPageNo = 1;
    /**
     * 현재 페이지가 속한 block의 마지막 페이지 번호
     */
    private int endPageNo;
    /**
     * 현재 페이지 번호
     */
    private Integer curPageNo;
    /**
     * 현재 페이지에 출력될 데이터 리스트 수
     */
    private int pageSize;
    /**
     * 현재 속한 페이지의 이전 페이지 block
     */
    private boolean prevPage;
    /**
     * 현재 속한 페이지의 다음 페이지 block
     */
    private boolean nextPage;
    /**
     * 이전 페이지 block의 첫번째 페이지 번호
     */
    private int prevPageIndex;

    /**
     * 다음 페이지 block의 첫번쨰 페이지 번호
     */
    private int nextPageIndex;


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

    public int getPrevPageIndex() {
        return prevPageIndex;
    }

    public void setPrevPageIndex(int prevPageIndex) {
        this.prevPageIndex = prevPageIndex;
    }

    public int getNextPageIndex() {
        return nextPageIndex;
    }

    public void setNextPageIndex(int nextPageIndex) {
        this.nextPageIndex = nextPageIndex;
    }

}
