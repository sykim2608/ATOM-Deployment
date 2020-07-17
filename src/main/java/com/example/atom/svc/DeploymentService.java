package com.example.atom.svc;

import com.example.atom.model.DeploymentGroup;
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
     * @param deploymentId 삭제 할 Deployment Group 아이디
     * @throws Exception
     */
    void deleteList(String deploymentId) throws Exception;
}
