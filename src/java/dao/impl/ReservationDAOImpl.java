/*
 * Copyright(C) 2022, FPT University
 * CMS
 * CLINIC MANAGEMENT SYSTEM
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-08      1.0                 tungnt           First Implement 
 */
package dao.impl;

import context.DBContext;
import dao.ReservationDAO;
import entity.Reservation;
import entity.Service;
import entity.User;
import entity.ServicePackage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * -The class contains method get information relate to Reservation<br>
 * -The method will throw an object of <code>java.lang.Exception</code> class if
 * there is any error occurring when reading data false.<br>
 *
 * @author Nguyễn Thanh Tùng
 */
public class ReservationDAOImpl extends DBContext implements ReservationDAO {

    /**
     * - Get full information about a reservation (such as customer information,
     * service information, package information, all reservation information)
     *
     * @return a list of <code>Reservation</code> objects. <br>
     * -It is a <code>java.util.ArrayList</code> object
     * @throws SQLException
     */
    
    @Override
    public ArrayList<Reservation> getReservations() throws SQLException {
        ArrayList<Reservation> result = new ArrayList<>();
        String sql = "SELECT DISTINCT reservations.reservation_id,\n"
                + "                users.[user_id],\n"
                + "                users.[username],\n"
                + "                users.full_name,\n"
                + "                services.service_name,\n"
                + "                packages.package_title,\n"
                + "                packages.examination_duration,\n"
                + "                doctors.doctor_id,\n"
                + "                doctors.doctor_username,\n"
                + "                doctors.doctor_full_name,\n"
                + "                reservations.request_examination_date,\n"
                + "                reservations.request_examination_time,\n"
                + "                reservations.confirmed_examination_date,\n"
                + "                reservations.confirmed_examination_time, \n"
                + "                reservations.reservation_date,\n"
                + "                reservations.reservation_status,\n"
                + "                reservations.medical_request\n"
                + "FROM reservations\n"
                + "INNER JOIN services ON reservations.service_id = services.service_id\n"
                + "INNER JOIN users ON reservations.customer_id = users.[user_id]\n"
                + "INNER JOIN packages ON reservations.package_id = packages.package_id\n"
                + "INNER JOIN\n"
                + "  (SELECT users.username AS doctor_username,\n"
                + "          users.full_name AS doctor_full_name,\n"
                + "          users.user_id AS doctor_id\n"
                + "   FROM reservations\n"
                + "   LEFT JOIN users ON reservations.confirmed_doctor_id = users.user_id) AS doctors ON reservations.confirmed_doctor_id = doctors.doctor_id\n"
                + "\n"
                + "";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getConnection(); //get connection
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            /**
             * set attributes for reservation from result set then add its to
             * result list
             */
            while (rs.next()) {
                Reservation reservation = new Reservation();
                User customer = new User(rs.getInt("user_id"), rs.getString("username"), rs.getString("full_name"));
                Service service = new Service(rs.getString("service_name"));
                ServicePackage servicePackage = new ServicePackage(rs.getString("package_title"), rs.getString("examination_duration"));
                User doctor = new User(rs.getInt("doctor_id"), rs.getString("doctor_username"), rs.getString("doctor_full_name"));
                reservation.setReservationId(rs.getInt("reservation_id"));
                reservation.setCustomer(customer);
                reservation.setService(service);
                reservation.setServicePackage(servicePackage);
                reservation.setConfirmedDoctor(doctor);
                reservation.setRequestExaminationDate(rs.getDate("request_examination_date"));
                reservation.setRequestExaminationTime(rs.getTime("request_examination_time"));
                reservation.setConfirmedExaminationDate(rs.getDate("confirmed_examination_date"));
                reservation.setConfirmedExaminationTime(rs.getTime("confirmed_examination_time"));
                reservation.setReservationDate(rs.getDate("reservation_date"));
                reservation.setReservationStatus(rs.getString("reservation_status"));
                reservation.setMedicalRequest(rs.getString("medical_request"));
                result.add(reservation);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (Exception ex) {
            Logger.getLogger(ReservationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            /**
             * close result set, prepared statement and connection by
             * corresponding order
             */
        } finally {
            this.closeResultSet(rs);
            this.closePreparedStatement(ps);
            this.closeConnection(con);
        }
        return result;
    }

    /**
     * - Get doctor information about a reservation (such as doctorId,
     * doctorUserName, doctorFullName)
     *
     * @return a list of <code>Reservation</code> objects. <br>
     * -It is a <code>java.util.ArrayList</code> object
     * @throws SQLException
     */
    @Override
    public ArrayList<User> getDoctorsHasReservation() throws SQLException {
        ArrayList<User> result = new ArrayList<>();
        String sql = "SELECT DISTINCT users.user_id as doctor_id, users.username as doctor_username, users.full_name as doctor_full_name\n"
                + "FROM     reservations\n"
                + "LEFT JOIN users ON reservations.confirmed_doctor_id = users.user_id WHERE users.username IS NOT NULL OR users.full_name IS NOT NULL";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getConnection(); //get connection
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            /**
             * set attributes for doctors from result set then add its to result
             * list
             */
            while (rs.next()) {
                User doctor = new User(rs.getInt("doctor_id"), rs.getString("doctor_username"), rs.getString("doctor_full_name"));
                result.add(doctor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (Exception ex) {
            Logger.getLogger(ReservationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            /**
             * close result set, prepared statement and connection by
             * corresponding order
             */
        } finally {
            this.closeResultSet(rs);
            this.closePreparedStatement(ps);
            this.closeConnection(con);
        }
        return result;
    }
}
