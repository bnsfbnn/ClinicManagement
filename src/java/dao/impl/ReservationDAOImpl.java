/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 *
 * @author Thanh Tung
 */
public class ReservationDAOImpl extends DBContext implements ReservationDAO {

    @Override
    public ArrayList<Reservation> getReservations() throws SQLException {
        ArrayList<Reservation> result = new ArrayList<>();
        String sql = "SELECT reservations.reservation_id,\n"
                + "       users.[username],\n"
                + "       users.full_name,\n"
                + "       services.service_name,\n"
                + "       packages.package_title,\n"
                + "       packages.examination_duration,\n"
                + "       doctors.doctor_username,\n"
                + "       doctors.doctor_full_name,\n"
                + "       reservations.request_examination_time_1,\n"
                + "       reservations.request_examination_time_2,\n"
                + "       reservations.confirmed_examination_time,\n"
                + "       reservations.reservation_time,\n"
                + "       reservations.reservation_status,\n"
                + "       reservations.medical_request\n"
                + "FROM reservations\n"
                + "INNER JOIN services ON reservations.service_id = services.service_id\n"
                + "INNER JOIN users ON reservations.customer_id = users.[user_id]\n"
                + "INNER JOIN packages ON reservations.package_id = packages.package_id\n"
                + "INNER JOIN\n"
                + "  (SELECT users.username AS doctor_username,\n"
                + "          users.full_name AS doctor_full_name,\n"
                + "          users.user_id AS doctor_id\n"
                + "   FROM reservations\n"
                + "   LEFT JOIN users ON reservations.confirmed_doctor_id = users.user_id) AS doctors ON reservations.confirmed_doctor_id = doctors.doctor_id";
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
                User customer = new User(rs.getString("username"), rs.getString("full_name"));
                Service service = new Service(rs.getString("service_name"));
                ServicePackage servicePackage = new ServicePackage(rs.getString("package_title"), rs.getString("examination_duration"));
                User doctor = new User(rs.getString("doctor_username"), rs.getString("doctor_full_name"));
                reservation.setReservationId(rs.getInt("reservation_id"));
                reservation.setCustomer(customer);
                reservation.setService(service);
                reservation.setServicePackage(servicePackage);
                reservation.setConfirmedDoctor(doctor);
                reservation.setRequestExaminationTime1(rs.getDate("request_examination_time_1"));
                reservation.setRequestExaminationTime2(rs.getDate("request_examination_time_2"));
                reservation.setConfirmedExaminationTime(rs.getDate("confirmed_examination_time"));
                reservation.setReservationTime(rs.getDate("reservation_time"));
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

    @Override
    public ArrayList<User> getDoctorsHasReservation() throws SQLException {
        ArrayList<User> result = new ArrayList<>();
        String sql = "SELECT DISTINCT doctors.doctor_username,\n"
                + "				doctors.doctor_full_name\n"
                + "FROM reservations\n"
                + "INNER JOIN (SELECT users.username as doctor_username, users.full_name as doctor_full_name, users.user_id as doctor_id\n"
                + "			FROM     reservations \n"
                + "			LEFT JOIN users ON reservations.confirmed_doctor_id = users.user_id) AS doctors ON reservations.confirmed_doctor_id = doctors.doctor_id";
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
                User doctor = new User(rs.getString("doctor_username"), rs.getString("doctor_full_name"));
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

    @Override
    public ArrayList<Service> getServices() throws SQLException {
        ArrayList<Service> result = new ArrayList<>();
        String sql = "SELECT [service_id]\n"
                + "      ,[service_name]\n"
                + "      ,[service_brief]\n"
                + "      ,[service_description]\n"
                + "      ,[service_image]\n"
                + "  FROM [CMS].[dbo].[services]";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getConnection(); //get connection
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            /**
             * set attributes for services from result set then add its to
             * result list
             */
            while (rs.next()) {
                Service service = new Service(rs.getInt("service_id"), rs.getString("service_name"), rs.getString("service_brief"), rs.getString("service_description"), rs.getString("service_image"));
                result.add(service);
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
