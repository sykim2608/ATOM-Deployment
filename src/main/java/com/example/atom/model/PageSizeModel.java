package com.example.atom.model;

/**
 * Page Size 모델.
 * @author sykim@ntels.com
 */
public class PageSizeModel {
    /**
     * 페이지 내 출력할 데이터 리스트 수
     */
    public static int pageSize = 10;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

}
