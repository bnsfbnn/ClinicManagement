/*
 * Copyright(C) 2022, FPT University
 * CMS
 * CLINIC MANAGEMENT SYSTEM
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-08      1.0                 tungnt           First Implement 
 */
package dao;

import entity.Reservation;
import entity.User;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * This class is an interface contains methods of Reservation
 *
 * @author Nguyễn Thanh Tùng
 */
public interface ReservationDAO {

    /**
     * - Get full information about a reservation (such as customer information,
     * service information, package information, all reservation information)
     *
     * @param viewDay is a <code>java.lang.String</code> object used to get
     * reservation by date
     * @param serviceId is a <code>java.lang.String</code> object used to get
     * reservation by serviceId
     * @return a list of <code>Reservation</code> objects. <br>
     * -It is a <code>java.util.ArrayList</code> object
     * @throws SQLException when <code>java.sql.SQLException</code> occurs.
     * @throws Exception when <code>java.sql.Exception</code> occurs.
     */
    public ArrayList<Reservation> getReservationsByDay(String viewDay, int serviceId) throws SQLException, Exception;

    /**
     * - Get doctor information about a reservation (such as doctorId,
     * doctorUserName, doctorFullName)
     *
     * @param viewDay is a <code>java.lang.String</code> object used to get
     * reservation by date
     * @param serviceId is a <code>java.lang.String</code> object used to get
     * reservation by serviceId
     * @return a list of <code>User</code> objects. <br>
     * -It is a <code>java.util.ArrayList</code> object
     * @throws SQLException when <code>java.sql.SQLException</code> occurs.
     * @throws Exception when <code>java.sql.Exception</code> occurs.
     */
    public ArrayList<User> getDoctorsHasReservation(String viewDay, int serviceId) throws SQLException, Exception;

    /**
     * - Get reservation information by doctor id
     *
     * @param doctorId is a <code>java.lang.int</code> object used to get
     * reservation by doctorId
     * @param startWeek is a <code>java.lang.String</code> object used to get
     * reservation has confirmed reservation date greater startWeek
     * @param endWeek is a <code>java.lang.String</code> object used to get
     * reservation has confirmed reservation date lesser startWeek
     * @return a list of <code>Reservation</code> objects. <br>
     * -It is a <code>java.util.ArrayList</code> object
     * @throws SQLException when <code>java.sql.SQLException</code> occurs.
     * @throws Exception when <code>java.sql.Exception</code> occurs.
     */
    public ArrayList<Reservation> getReservationByDoctorId(int doctorId, String startWeek, String endWeek) throws SQLException, Exception;
    
    /**
     * - Get reservation information by reservation id
     *
     * @param reservationId is a <code>java.lang.int</code> object used to get
     * reservation by reservationId
     * @return a list of <code>Reservation</code> objects. <br>
     * -It is a <code>java.util.ArrayList</code> object
     * @throws SQLException when <code>java.sql.SQLException</code> occurs.
     * @throws Exception when <code>java.sql.Exception</code> occurs.
     */
    public Reservation getReservationById(int reservationId) throws SQLException, Exception;
    
    /**
     * - Update reservation status
     *
     * @param reservationId is a <code>java.lang.int</code> object used to get
     * reservation by reservationId
     * @return a list of <code>Reservation</code> objects. <br>
     * -It is a <code>java.util.ArrayList</code> object
     * @throws SQLException when <code>java.sql.SQLException</code> occurs.
     * @throws Exception when <code>java.sql.Exception</code> occurs.
     */
    public int updateReservationStatusById(int reservationId) throws SQLException, Exception;
}
