package com.example.atom.svc;

import com.example.atom.model.DeploymentGroup;
import com.example.atom.model.PagingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PagingServiceImpl implements PagingService {

    @Autowired
    DeploymentService deploymentService;

    @Override
    public PagingModel createPaging(Integer curPageNo) throws Exception {
        PagingModel pagingModel = new PagingModel();

        if(curPageNo == null) {
            pagingModel.setCurPageNo(1);
        }
        else {
            pagingModel.setCurPageNo(curPageNo);
        }

        //page Size 처리 (수정해야함)**
        pagingModel.setPageSize(10);

        //total Count 계산
        List<DeploymentGroup> list = deploymentService.getList();
        int totalCnt = list.size();
        pagingModel.setTotalListNum(totalCnt);


        //Start Page 계산
        int startPage = ((pagingModel.getCurPageNo() - 1) / 5) * 5 + 1;
        pagingModel.setStartPageNo(startPage);

        //Last Page 계산
        int lastPage = 0;
        if(pagingModel.getTotalListNum() % pagingModel.getPageSize() == 0) {
            lastPage = pagingModel.getTotalListNum() / pagingModel.getPageSize();
        }
        else {
            lastPage = pagingModel.getTotalListNum() / pagingModel.getPageSize() + 1;
        }
        pagingModel.setLastPageNo(lastPage);

        //End Page 계산
        int num = (((pagingModel.getCurPageNo() - 1) / 5) + 1) * 5;
        if(pagingModel.getLastPageNo() < 5) {
            pagingModel.setEndPageNo(pagingModel.getLastPageNo());
        }
        else if(pagingModel.getLastPageNo() > num) {
            pagingModel.setEndPageNo(num);
        }
        else {
            pagingModel.setEndPageNo(pagingModel.getLastPageNo());
        }


        //이전 페이지 확인
        if(pagingModel.getStartPageNo() > 5 ) {
            pagingModel.setPrevPage(true);
        }
        else {
            pagingModel.setPrevPage(false);
        }

        //다음 페이지 확인
        if(pagingModel.getEndPageNo() < pagingModel.getLastPageNo()) {
            pagingModel.setNextPage(true);
        }
        else {
            pagingModel.setNextPage(false);
        }

        return pagingModel;
    }
}
