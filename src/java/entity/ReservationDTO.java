/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author dell
 */
public class ReservationDTO {
    private int id;
    
    private Date requestDate;

    private String customerRequest;

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public String getCustomerRequest() {
        return customerRequest;
    }

    public void setCustomerRequest(String customerRequest) {
        this.customerRequest = customerRequest;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
