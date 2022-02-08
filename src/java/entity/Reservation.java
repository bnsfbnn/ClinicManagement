/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author Thanh Tung
 */
public class Reservation {
    private int reservationId;
    private int customerId;
    private int serviceId;
    private int packageId;
    private Date examinationTime1;
    private Date examinationTime2;
    private Date reservationTime;
    private String reservationStatus;
    private String medicalRequest;

    public Reservation() {
    }

    public Reservation(int reservationId, int customerId, int serviceId, int packageId, Date examinationTime1, Date examinationTime2, Date reservationTime, String reservationStatus, String medicalRequest) {
        this.reservationId = reservationId;
        this.customerId = customerId;
        this.serviceId = serviceId;
        this.packageId = packageId;
        this.examinationTime1 = examinationTime1;
        this.examinationTime2 = examinationTime2;
        this.reservationTime = reservationTime;
        this.reservationStatus = reservationStatus;
        this.medicalRequest = medicalRequest;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public Date getExaminationTime1() {
        return examinationTime1;
    }

    public void setExaminationTime1(Date examinationTime1) {
        this.examinationTime1 = examinationTime1;
    }

    public Date getExaminationTime2() {
        return examinationTime2;
    }

    public void setExaminationTime2(Date examinationTime2) {
        this.examinationTime2 = examinationTime2;
    }

    public Date getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(Date reservationTime) {
        this.reservationTime = reservationTime;
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
    
}
