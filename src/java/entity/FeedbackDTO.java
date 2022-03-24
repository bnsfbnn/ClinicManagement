/*
 * Copyright(C) 20022, FPT University
 * CMS:
 * Clinic Management System
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-28     1.0                 TrangCT          FeedbackDTO Implement
 */
package entity;

import java.sql.Date;

/**
 * <h1>FeedbackDTO </h1>
 * storage data of a feedback
 * <p>
 *
 *
 * @author TrangCT
 * @version 1.0
 * @since 2022-02-28
 */
public class FeedbackDTO {

    private int feedbackId;
    private String customer;
    private String username;
    private String service;
    private String examination;
    private String feedbackContent;
    private Date feedbackTime;
    private int examinationId;
    private int serviceId;

    /**
     * Creates a service with specified parameters.
     *
     * @param feedbackId
     * @param customer
     * @param service
     * @param examination
     * @param examinationId
     * @param serviceId
     * @param feedbackContent
     * @param feedbackTime
     */
    public FeedbackDTO(int feedbackId, String customer, String service, String examination, String feedbackContent, Date feedbackTime, int examinationId, int serviceId) {
        this.feedbackId = feedbackId;
        this.customer = customer;
        this.service = service;
        this.examination = examination;
        this.feedbackContent = feedbackContent;
        this.feedbackTime = feedbackTime;
        this.examinationId = examinationId;
        this.serviceId = serviceId;
    }

    /**
     * Creates a feedback with no parameter
     */
    public FeedbackDTO() {
    }

    /**
     * Get feedback id
     *
     * @return feedbackid integer
     */
    public int getFeedbackId() {
        return feedbackId;
    }

    /**
     * Set feedbackId
     *
     * @param feedbackId
     */

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    /**
     * Get customer
     *
     * @return customer integer
     */
    public String getCustomer() {
        return customer;
    }

    /**
     * Set customer
     *
     * @param customer
     */
    public void setCustomer(String customer) {
        this.customer = customer;
    }

    /**
     * Get service
     *
     * @return service String
     */
    public String getService() {
        return service;
    }

    /**
     * Set service
     *
     * @param service
     */
    public void setService(String service) {
        this.service = service;
    }

    /**
     * Get examination
     *
     * @return examination String
     */
    public String getExamination() {
        return examination;
    }

    /**
     * Set examination
     *
     * @param examination
     */
    public void setExamination(String examination) {
        this.examination = examination;
    }

    /**
     * Get feedbackContent
     *
     * @return feedbackContent String
     */
    public String getFeedbackContent() {
        return feedbackContent;
    }

    /**
     * Set feedbackContent
     *
     * @param feedbackContent
     */
    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent;
    }

    /**
     * Get feedbackTime
     *
     * @return feedbackTime Date
     */
    public Date getFeedbackTime() {
        return feedbackTime;
    }

    /**
     * Set feedbackTime
     *
     * @param feedbackTime
     */
    public void setFeedbackTime(Date feedbackTime) {
        this.feedbackTime = feedbackTime;
    }

    /**
     * Get username
     *
     * @return username String
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set username
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get examinationId
     *
     * @return examinationId integer
     */
    public int getExaminationId() {
        return examinationId;
    }

    /**
     * Set examinationId
     *
     * @param examinationId
     */
    public void setExaminationId(int examinationId) {
        this.examinationId = examinationId;
    }

    /**
     * Get serviceId
     *
     * @return serviceId integer
     */
    public int getServiceId() {
        return serviceId;
    }

    /**
     * Set serviceId
     *
     * @param serviceId
     */
    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

}
