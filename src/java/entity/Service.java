/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Thanh Tung
 */
public class Service {
    private int serviceId;
    private String serviceName;
    private String serviceBrief;
    private String serviceDescription;
    private String serviceImage;

    public Service() {
    }

    public Service(String serviceName) {
        this.serviceName = serviceName;
    }
    
    public Service(int serviceId, String serviceName, String serviceBrief, String serviceDescription, String serviceImage) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceBrief = serviceBrief;
        this.serviceDescription = serviceDescription;
        this.serviceImage = serviceImage;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceBrief() {
        return serviceBrief;
    }

    public void setServiceBrief(String serviceBrief) {
        this.serviceBrief = serviceBrief;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public String getServiceImage() {
        return serviceImage;
    }

    public void setServiceImage(String serviceImage) {
        this.serviceImage = serviceImage;
    }
    
}
