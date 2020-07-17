package com.example.atom.model;

import java.util.Date;

/**
 * DeploymentGroup 모델.
 * @author sykim@ntels.com
 */
public class DeploymentGroup {
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
    /**
     * 서비스 상태
     */
    private String status;
    /**
     * 생성 날짜
     */
    private Date date;


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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
