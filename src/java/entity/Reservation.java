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
    private User customer;
    private Service service;
    private ServicePackage servicePackage;
    private User confirmedDoctor;
    private Date requestExaminationTime1;
    private Date requestExaminationTime2;
    private Date confirmedExaminationTime;
    private Date reservationTime;
    private String reservationStatus;
    private String medicalRequest;

    public Reservation() {
    }

    public Reservation(int reservationId, User customer, Service service, ServicePackage servicePackage, User confirmedDoctor, Date requestExaminationTime1, Date requestExaminationTime2, Date confirmedExaminationTime, Date reservationTime, String reservationStatus, String medicalRequest) {
        this.reservationId = reservationId;
        this.customer = customer;
        this.service = service;
        this.servicePackage = servicePackage;
        this.confirmedDoctor = confirmedDoctor;
        this.requestExaminationTime1 = requestExaminationTime1;
        this.requestExaminationTime2 = requestExaminationTime2;
        this.confirmedExaminationTime = confirmedExaminationTime;
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

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public ServicePackage getServicePackage() {
        return servicePackage;
    }

    public void setServicePackage(ServicePackage servicePackage) {
        this.servicePackage = servicePackage;
    }

    public User getConfirmedDoctor() {
        return confirmedDoctor;
    }

    public void setConfirmedDoctor(User confirmedDoctor) {
        this.confirmedDoctor = confirmedDoctor;
    }

    public Date getRequestExaminationTime1() {
        return requestExaminationTime1;
    }

    public void setRequestExaminationTime1(Date requestExaminationTime1) {
        this.requestExaminationTime1 = requestExaminationTime1;
    }

    public Date getRequestExaminationTime2() {
        return requestExaminationTime2;
    }

    public void setRequestExaminationTime2(Date requestExaminationTime2) {
        this.requestExaminationTime2 = requestExaminationTime2;
    }

    public Date getConfirmedExaminationTime() {
        return confirmedExaminationTime;
    }

    public void setConfirmedExaminationTime(Date confirmedExaminationTime) {
        this.confirmedExaminationTime = confirmedExaminationTime;
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
