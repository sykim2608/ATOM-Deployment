package com.example.atom.svc;

import com.example.atom.model.PagingModel;

public interface PagingService {
    PagingModel createPaging(Integer curPageNo) throws Exception;
}