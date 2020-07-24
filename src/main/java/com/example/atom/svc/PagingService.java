package com.example.atom.svc;

import com.example.atom.model.PagingModel;

/**
 * 페이징 처리 인터페이스.
 * @author sykim@ntels.com
 */
public interface PagingService {
    /**
     * 페이지 인덱스에 따른 데이터를 제공하기 위한 페이징 요소 처리
     * @param curPageNo 현재 페이지 번호
     * @return 현재 페이지의 페이징 모델 정보
     * @throws Exception
     */
    PagingModel createPaging(Integer curPageNo) throws Exception;
}
