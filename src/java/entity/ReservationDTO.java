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

    private int id;
    
    private Date requestDate;

    private String customerRequest;

    /**
     * Get requestDate
     *
     * @return  requestDate date 
     */
    public Date getRequestDate() {
        return requestDate;
    }
     /**
     * Set requestDate
     *
     * @param requestDate
     */

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }
     /**
     * Get CustomerRequest
     *
     * @return  customerRequest String
     */
    public String getCustomerRequest() {
        return customerRequest;
    }
    /**
     * Set customerRequest
     *
     * @param customerRequest
     */

    public void setCustomerRequest(String customerRequest) {
        this.customerRequest = customerRequest;
    }
     /**
     * Get id
     *
     * @return  id  int
     */

    public int getId() {
        return id;
    }

    /**
     * Set id
     *
     * @param id
     */

    public void setId(int id) {
        this.id = id;
    }

}
