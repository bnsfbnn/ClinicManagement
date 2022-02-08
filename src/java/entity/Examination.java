/*
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author Thanh Tung
 */
public class Examination {
    private int examinationId;
    private int reservationId;
    private int doctorId;
    private String examinationDisgnosis;
    private Date examinationTime;

    public Examination() {
    }

    public Examination(int examinationId, int reservationId, int doctorId, String examinationDisgnosis, Date examinationTime) {
        this.examinationId = examinationId;
        this.reservationId = reservationId;
        this.doctorId = doctorId;
        this.examinationDisgnosis = examinationDisgnosis;
        this.examinationTime = examinationTime;
    }

    public int getExaminationId() {
        return examinationId;
    }

    public void setExaminationId(int examinationId) {
        this.examinationId = examinationId;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getExaminationDisgnosis() {
        return examinationDisgnosis;
    }

    public void setExaminationDisgnosis(String examinationDisgnosis) {
        this.examinationDisgnosis = examinationDisgnosis;
    }

    public Date getExaminationTime() {
        return examinationTime;
    }

    public void setExaminationTime(Date examinationTime) {
        this.examinationTime = examinationTime;
    }
    
}
