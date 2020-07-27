package com.example.atom.svc;

import com.example.atom.dao.DeployMapper;
import com.example.atom.model.DeploymentGroup;
import com.example.atom.model.PageSizeModel;
import com.example.atom.model.PagingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 페이징 처리 클래스.
 * @author sykim@ntels.com
 */
@Service
public class PagingServiceImpl implements PagingService {
    /**
     * DeployMapper
     */
    @Autowired
    private DeployMapper mapper;

    /**
     * Deployment Service
     */
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

        //page Size 처리
        int pageSize = PageSizeModel.pageSize;
        pagingModel.setPageSize(pageSize);

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
        int blockLast = (((pagingModel.getCurPageNo() - 1) / 5) + 1) * 5;
        if(pagingModel.getLastPageNo() > blockLast) {
            pagingModel.setEndPageNo(blockLast);
        }
        else {
            pagingModel.setEndPageNo(pagingModel.getLastPageNo());
        }

        //이전 페이지 확인
        if(pagingModel.getStartPageNo() > 5 ) {
            pagingModel.setPrevPage(true);
            pagingModel.setPrevPageIndex(pagingModel.getStartPageNo() - 1);
        }
        else {
            pagingModel.setPrevPage(false);
        }

        //다음 페이지 확인
        if(pagingModel.getEndPageNo() < pagingModel.getLastPageNo()) {
            pagingModel.setNextPage(true);
            pagingModel.setNextPageIndex(pagingModel.getEndPageNo()+1);
        }
        else {
            pagingModel.setNextPage(false);
        }
        return pagingModel;
    }

}
