package com.example.atom.dao;

import com.example.atom.model.DeploymentGroup;
import com.example.atom.model.ModifyModel;
import com.example.atom.model.SearchModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * MyBatis Mapper 인터페이스.
 * @author sykim@ntels.com
 */
@Mapper
@Repository
public interface DeployMapper {
    /**
     * DeploymentGroup 정보 조회
     * @return Deployment Group 정보
     * @throws Exception
     */
    List<DeploymentGroup> getList() throws Exception;

    /**
     * DeploymentGroup 정보 삭제
     * @param id 삭제 할 Deployment Service 아이디
     * @throws Exception
     */
    void deleteList(String id) throws Exception;

    /**
     * DeploymentGroup 정보 등록
     * @param deploymentGroup 등록할 Deployment Group 정보
     * @throws Exception
     */
    void addList(DeploymentGroup deploymentGroup) throws Exception;

    /**
     * DeploymentGroup 정보 변경
     * @param modifyModel 변경할 Deployment Group 정보
     * @throws Exception
     */
    void modifyList(ModifyModel modifyModel) throws Exception;

    /**
     * DeploymentGroup 정보 검색
     * @param searchModel 검색할 Deployment Group 정보
     * @return 검색된 Deployment Group 정보
     * @throws Exception
     */
    List<DeploymentGroup> findList(SearchModel searchModel) throws Exception;
}
