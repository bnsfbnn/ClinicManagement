/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Date;

public class CustomerReservation {

    private int id;
    private String examinationDuration;
    private String packageTitle;
    private float price;
    private String serviceName;
    private String reservationStatus;
    private String medicalRequest;
    private Date requestExaminationDate;
    private Date confirmedExaminationDate;

    public String getExaminationDuration() {
        return examinationDuration;
    }

    public void setExaminationDuration(String examinationDuration) {
        this.examinationDuration = examinationDuration;
    }

    public String getPackageTitle() {
        return packageTitle;
    }

    public void setPackageTitle(String packageTitle) {
        this.packageTitle = packageTitle;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public String getMedicalRequest() {
        return medicalRequest;
    }

    public void setMedicalRequest(String medicalRequest) {
        this.medicalRequest = medicalRequest;
    }

    public Date getRequestExaminationDate() {
        return requestExaminationDate;
    }

    public void setRequestExaminationDate(Date requestExaminationDate) {
        this.requestExaminationDate = requestExaminationDate;
    }

    public Date getConfirmedExaminationDate() {
        return confirmedExaminationDate;
    }

    public void setConfirmedExaminationDate(Date confirmedExaminationDate) {
        this.confirmedExaminationDate = confirmedExaminationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
