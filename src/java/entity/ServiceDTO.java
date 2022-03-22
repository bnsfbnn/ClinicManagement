/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import entity.Doctor;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Service </h1>
 * storage data of a service
 * <p>
 *
 *
 * @author TrangCT
 * @version 1.0
 * @since 2022-02-08
 */
public class ServiceDTO {

    private int serviceId;
    private String serviceName;
    private String serviceBrief;
    private String serviceDescription;
    private String serviceImage;
    private List<Doctor> doctors = new ArrayList<>();

    /**
     * Get service id
     *
     * @return serviceId integer
     */
    public int getServiceId() {
        return serviceId;
    }

    /**
     * Set service id
     *
     * @param serviceId
     */
    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    /**
     * Get service name
     *
     * @return serviceId string
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * Set service name
     *
     * @param serviceName
     */

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    /**
     * Get service brief
     *
     * @return serviceBrief string
     */
    public String getServiceBrief() {
        return serviceBrief;
    }
     /**
     * Set service brief
     *
     * @param serviceBrief
     */

    public void setServiceBrief(String serviceBrief) {
        this.serviceBrief = serviceBrief;
    }

    /**
     * Get service Description
     *
     * @return getServiceDescription string
     */
    public String getServiceDescription() {
        return serviceDescription;
    }
     /**
     * Set service brief
     *
     * @param serviceBrief
     */

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    /**
     * Get Service Image
     *
     * @return getServiceImage string
     */
    public String getServiceImage() {
        return serviceImage;
    }
     /**
     * Set service Image
     *
     * @param serviceImage
     */

    public void setServiceImage(String serviceImage) {
        this.serviceImage = serviceImage;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }
      /**
     * Set doctors
     * @param doctors
     */
    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

}
