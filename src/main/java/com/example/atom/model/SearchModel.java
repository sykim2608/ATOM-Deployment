package com.example.atom.model;

/**
 * DeploymentGroup 검색 Ajax 요청에 대한 Request Body 모델.
 * @author sykim@ntels.com
 */
public class SearchModel {
    /**
     * 서비스 아이디
     */
    private String serviceId;
    /**
     * 서비스 명
     */
    private String serviceName;
    /**
     * 서비스 아키텍처
     */
    private String architecture;
    /**
     * 서비스 상태
     */
    private String status;


    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getArchitecture() {
        return architecture;
    }

    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
