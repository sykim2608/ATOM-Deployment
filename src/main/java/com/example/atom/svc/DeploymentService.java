package com.example.atom.svc;

import com.example.atom.model.DeploymentGroup;
import com.example.atom.model.ModifyModel;

import java.util.List;

/**
 * Deployment Group 데이터 처리 인터페이스.
 * @author sykim@ntels.com
 */
public interface DeploymentService {
    /**
     * 모든 Deployment Group 정보 조회
     * @return DeploymentGroup 정보
     */
    List<DeploymentGroup> getList() throws Exception;

    /**
     * Deployment Group 정보 삭제
     * @param deploymentId 삭제할 Deployment Group 아이디
     * @throws Exception
     */
    void deleteList(String deploymentId) throws Exception;

    /**
     * Deployment Group 정보 등록
     * @param deploymentGroup 등록할 Deployment Group 정보
     * @throws Exception
     */
    void addList(DeploymentGroup deploymentGroup) throws Exception;

    /**
     * Deployment Group 정보 변경
     * @param modifyModel 변경할 Deployment Group 정보
     * @throws Exception
     */
    void modifyList(ModifyModel modifyModel) throws Exception;
}
