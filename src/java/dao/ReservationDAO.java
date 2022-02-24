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
import entity.Service;
import entity.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

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
     * @param viewDay is a <code>java.lang.String</code> object used to
     * get reservation by date
     * @param serviceId is a <code>java.lang.String</code> object used to
     * get reservation by serviceId
     * @return a list of <code>Reservation</code> objects. <br>
     * -It is a <code>java.util.ArrayList</code> object
     * @throws SQLException when <code>java.sql.SQLException</code>
     * occurs.
     */
    public ArrayList<Reservation> getReservationsByDay(String viewDay, int serviceId) throws SQLException;

    /**
     * - Get doctor information about a reservation (such as doctorId, doctorUserName,
     * doctorFullName)
     *
     * @param viewDay is a <code>java.lang.String</code> object used to
     * get reservation by date
     * @param serviceId is a <code>java.lang.String</code> object used to
     * get reservation by serviceId
     * @return a list of <code>Reservation</code> objects. <br>
     * -It is a <code>java.util.ArrayList</code> object
     * @throws SQLException when <code>java.sql.SQLException</code>
     * occurs.
     */
    public ArrayList<User> getDoctorsHasReservation(String viewDay, int serviceId) throws SQLException;

}
