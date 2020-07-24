package com.example.atom.model;

/**
 * DeploymentGroup 삭제 Ajax 요청에 대한 Request Body 모델.
 * @author sykim@ntels.com
 */
public class DeleteModel {
    /**
     * 서비스 아이디
     */
    private String deploymentId;

    public String getDeploymentId() {
        return deploymentId;
    }

    public void setDeploymentId(String deploymentId) {
        this.deploymentId = deploymentId;
    }


}
