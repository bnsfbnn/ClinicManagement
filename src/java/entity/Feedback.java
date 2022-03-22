/*
 * Copyright(C) 20022, FPT University
 * CMS:
 * Clinic Management System
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-28     1.0                 TrangCT          Feedback Implement
 */
package entity;

import java.sql.Date;

/**
 * <h1>Feedback </h1>
 * storage data of a feedback
 * <p>
 *
 *
 * @author TrangCT
 * @version 1.0
 * @since 2022-02-08
 */
public class Feedback {

    private int feedbackId;
    private int customerId;
    private int serviceId;
    private int examinationId;
    private String feedbackContent;
    private Date feedbackTime;

    /**
     * Creates a service with specified parameters.
     *
     * @param feedbackId
     * @param customerId
     * @param serviceId
     * @param examinationId
     * @param feedbackContent
     * @param feedbackTime
     */

    public Feedback(int feedbackId, int customerId, int serviceId, int examinationId, String feedbackContent, Date feedbackTime) {
        this.feedbackId = feedbackId;
        this.customerId = customerId;
        this.serviceId = serviceId;
        this.examinationId = examinationId;
        this.feedbackContent = feedbackContent;
        this.feedbackTime = feedbackTime;
    }

    /**
     * Creates a feedback with no parameter
     */
    public Feedback() {
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
     * Get customer Id
     *
     * @return customerId integer
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * Set customerId
     *
     * @param customerId
     */

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * Get service id
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
     * Set feedbackContent
     *
     * @param feedbackContent
     */
    public void setFeedbackTime(Date feedbackTime) {
        this.feedbackTime = feedbackTime;
    }

}
