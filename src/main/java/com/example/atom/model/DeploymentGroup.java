package com.example.atom.model;

import java.util.Date;

public class DeploymentGroup {
    private String serviceId;
    private String serviceName;
    private String architecture;
    private String description;
    private String status;
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
