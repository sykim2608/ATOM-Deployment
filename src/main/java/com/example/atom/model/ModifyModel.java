package com.example.atom.model;

/**
 * DeploymentGroup 변경 Ajax 요청에 대한 Request Body 모델
 * @author sykim@ntels.com
 */
public class ModifyModel {
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
     * 서비스 설명
     */
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
