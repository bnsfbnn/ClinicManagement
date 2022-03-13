/*
 * Copyright(C) 20022, FPT University
 * CMS:
 * Clinic Management System
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-22     1.0                 TrangCT          ReservationDTO  Implement
 */
package entity;

import java.sql.Date;
import java.sql.Time;

/**
 * <h1>ReservationDTO </h1>
 * storage data of a Reservation
 * <p>
 *
 *
 * @author TrangCT
 * @version 1.0
 * @since 2022-02-22
 */

public class ReservationDTO {

    private int reservationId;
    private int customer;
    private int service;
    private int servicePackage;
    private int confirmedDoctor;
    private Date requestExaminationDate;
    private Time requestExaminationTime;
    private Date confirmedExaminationDate;
    private Time confirmedExaminationTime;
    private Date reservationDate;
    private String reservationStatus;
    private String medicalRequest;

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    public int getService() {
        return service;
    }

    public void setService(int service) {
        this.service = service;
    }

    public int getServicePackage() {
        return servicePackage;
    }

    public void setServicePackage(int servicePackage) {
        this.servicePackage = servicePackage;
    }

    public int getConfirmedDoctor() {
        return confirmedDoctor;
    }

    public void setConfirmedDoctor(int confirmedDoctor) {
        this.confirmedDoctor = confirmedDoctor;
    }

    public Date getRequestExaminationDate() {
        return requestExaminationDate;
    }

    public void setRequestExaminationDate(Date requestExaminationDate) {
        this.requestExaminationDate = requestExaminationDate;
    }

    public Time getRequestExaminationTime() {
        return requestExaminationTime;
    }

    public void setRequestExaminationTime(Time requestExaminationTime) {
        this.requestExaminationTime = requestExaminationTime;
    }

    public Date getConfirmedExaminationDate() {
        return confirmedExaminationDate;
    }

    public void setConfirmedExaminationDate(Date confirmedExaminationDate) {
        this.confirmedExaminationDate = confirmedExaminationDate;
    }

    public Time getConfirmedExaminationTime() {
        return confirmedExaminationTime;
    }

    public void setConfirmedExaminationTime(Time confirmedExaminationTime) {
        this.confirmedExaminationTime = confirmedExaminationTime;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
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
