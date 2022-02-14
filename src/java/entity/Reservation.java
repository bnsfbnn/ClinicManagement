/*
 * Copyright(C) 2022, FPT University
 * CMS
 * CLINIC MANAGEMENT SYSTEM
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-08      1.0                 tungnt           First Implement 
 */
package entity;

import java.sql.Date;
import java.sql.Time;

/**
 * The class contains attributes and getter,setter for information of [User]
 * object <br>
 * The getter will throw an attribute of [User] object<br>
 * The setter will set an attribute of [User] object<br>
 *
 * @author Nguyen Thanh Tung
 */
public class Reservation {

    private int reservationId;
    private User customer;
    private Service service;
    private ServicePackage servicePackage;
    private User confirmedDoctor;
    private Date requestExaminationDate;
    private Time requestExaminationTime;
    private Date confirmedExaminationDate;
    private Time confirmedExaminationTime;
    private Date reservationDate;
    private String reservationStatus;
    private String medicalRequest;

    /**
     * Create an instance of <code>Reservation</code> object
     */
    public Reservation() {
    }

    /**
     * Create an instance of <code>Reservation</code> object with value of
     * attributes of <code>Reservation</code>
     *
     * @param reservationId the value of reservationId attribute. It's a
     * <code>java.lang.int</code> object
     * @param customer the value of customer attribute. It's a
     * <code>java.lang.User</code> object
     * @param service the value of service attribute. It's a
     * <code>java.lang.Service</code> object
     * @param servicePackage the value of servicePackage attribute. It's a
     * <code>java.lang.servicePackage</code> object
     * @param confirmedDoctor the value of confirmedDoctor attribute. It's a
     * <code>java.lang.User</code> object
     * @param requestExaminationDate the value of requestExaminationDate
     * attribute. It's a <code>java.lang.Date</code> object
     * @param requestExaminationTime the value of requestExaminationTime
     * attribute. It's a <code>java.lang.Time</code> object
     * @param confirmedExaminationDate the value of confirmedExaminationDate
     * attribute. It's a <code>java.sql.Date</code> object
     * @param confirmedExaminationTime the value of confirmedExaminationTime
     * attribute. It's a <code>java.lang.Time</code> object
     * @param reservationDate the value of reservationDate attribute. It's a
     * <code>java.lang.Date</code> object
     * @param reservationStatus the value of reservationStatus attribute. It's a
     * <code>java.lang.String</code> object
     * @param medicalRequest the value of medicalRequest attribute. It's a
     * <code>java.lang.String</code> object
     */
    public Reservation(int reservationId, User customer, Service service, ServicePackage servicePackage, User confirmedDoctor, Date requestExaminationDate, Time requestExaminationTime, Date confirmedExaminationDate, Time confirmedExaminationTime, Date reservationDate, String reservationStatus, String medicalRequest) {
        this.reservationId = reservationId;
        this.customer = customer;
        this.service = service;
        this.servicePackage = servicePackage;
        this.confirmedDoctor = confirmedDoctor;
        this.requestExaminationDate = requestExaminationDate;
        this.requestExaminationTime = requestExaminationTime;
        this.confirmedExaminationDate = confirmedExaminationDate;
        this.confirmedExaminationTime = confirmedExaminationTime;
        this.reservationDate = reservationDate;
        this.reservationStatus = reservationStatus;
        this.medicalRequest = medicalRequest;
    }

    /**
     * Return the value of reservationId attribute of the
     * <code>Reservation</code> object.
     */
    public int getReservationId() {
        return reservationId;
    }

    /**
     * Set reservationId value of the <code>Reservation</code> object.
     *
     * @param reservationId is a <code>java.lang.int</code> this value is the id
     * of the reservation.
     */
    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    /**
     * Return the value of reservationId attribute of the
     * <code>Reservation</code> object.
     */
    public User getCustomer() {
        return customer;
    }

    /**
     * Set customer value of the <code>Reservation</code> object.
     *
     * @param customer is a <code>java.lang.User</code> this value is the
     * customer of the reservation.
     */
    public void setCustomer(User customer) {
        this.customer = customer;
    }

    /**
     * Return the value of service attribute of the <code>Reservation</code>
     * object.
     */
    public Service getService() {
        return service;
    }

    /**
     * Set customer value of the <code>Reservation</code> object.
     *
     * @param service is a <code>java.lang.Service</code> this value is the
     * service of the reservation.
     */
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
