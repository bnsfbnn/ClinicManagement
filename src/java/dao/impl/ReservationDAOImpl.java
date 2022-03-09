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
import entity.CustomerReservation;
import entity.Pagination;
import entity.Reservation;
import entity.ReservationDTO;
import entity.Service;
import entity.User;
import entity.ServicePackage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
     * @throws Exception
     */
    @Override
    public ArrayList<Reservation> getReservationsByDay(String viewDay, int serviceId) throws SQLException, Exception {
        ArrayList<Reservation> result = new ArrayList<>();
        String sql = "SELECT DISTINCT reservations.reservation_id,\n"
                + "                users.[user_id],\n"
                + "                users.[username],\n"
                + "                users.full_name,\n"
                + "                services.service_id,\n"
                + "                services.service_name,\n"
                + "                reservations.package_id,\n"
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
                + "WHERE reservations.confirmed_examination_date = ? \n";

        if (serviceId != -1) {
            sql += " AND reservations.service_id = ? ";
        }

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getConnection(); //get connection
            ps = con.prepareStatement(sql);
            ps.setString(1, viewDay);
            if (serviceId != -1) {
                ps.setInt(2, serviceId);
            }
            rs = ps.executeQuery();
            /**
             * set attributes for reservation from result set then add its to
             * result list
             */
            while (rs.next()) {
                Reservation reservation = new Reservation();
                User customer = new User(rs.getInt("user_id"), rs.getString("username"), rs.getString("full_name"));
                Service service = new Service(rs.getInt("service_id"), rs.getString("service_name"));
                ServicePackage servicePackage = new ServicePackage(rs.getInt("package_id"), rs.getString("package_title"), rs.getString("examination_duration"));
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
            throw ex;
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
     * @return a list of <code>User</code> objects. <br>
     * -It is a <code>java.util.ArrayList</code> object
     * @throws SQLException
     * @throws Exception
     */
    @Override
    public ArrayList<User> getDoctorsHasReservation(String viewDay, int serviceId) throws SQLException, Exception {
        ArrayList<User> result = new ArrayList<>();
        String sql = "SELECT DISTINCT users.user_id as doctor_id, users.username as doctor_username, users.full_name as doctor_full_name\n"
                + "FROM reservations\n"
                + "LEFT JOIN users ON reservations.confirmed_doctor_id = users.user_id \n"
                + "WHERE (users.username IS NOT NULL OR users.full_name IS NOT NULL) AND reservations.confirmed_examination_date = ?";
        if (serviceId != -1) {
            sql += " AND reservations.service_id = ? ";
        }
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getConnection(); //get connection
            ps = con.prepareStatement(sql);
            ps.setString(1, viewDay);
            if (serviceId != -1) {
                ps.setInt(2, serviceId);
            }
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
            throw ex;
        } finally {
            this.closeResultSet(rs);
            this.closePreparedStatement(ps);
            this.closeConnection(con);
        }
        return result;
    }

    /**
     * - Get reservation information by doctor id
     *
     * @return a list of <code>Reservation</code> objects. <br>
     * -It is a <code>java.util.ArrayList</code> object
     * @throws SQLException
     * @throws Exception
     */
    @Override
    public ArrayList<Reservation> getReservationByDoctorId(int doctorId, String startWeek, String endWeek) throws SQLException, Exception {
        ArrayList<Reservation> result = new ArrayList<>();
        String sql = "SELECT DISTINCT reservations.reservation_id,\n"
                + "                users.[user_id],\n"
                + "                users.[username],\n"
                + "                users.full_name,\n"
                + "                services.service_id,\n"
                + "                services.service_name,\n"
                + "                reservations.package_id,\n"
                + "                packages.package_title,\n"
                + "                packages.examination_duration,\n"
                + "                doctors.doctor_id,\n"
                + "                doctors.doctor_username,\n"
                + "                doctors.doctor_full_name,\n"
                + "                reservations.request_examination_date,\n"
                + "                reservations.request_examination_time,\n"
                + "                reservations.confirmed_examination_date,\n"
                + "                reservations.confirmed_examination_time,\n"
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
                + "WHERE doctors.doctor_id = ? AND reservations.confirmed_examination_date >= ? AND reservations.confirmed_examination_date <= ?";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getConnection(); //get connection
            ps = con.prepareStatement(sql);
            ps.setInt(1, doctorId);
            ps.setString(2, startWeek);
            ps.setString(3, endWeek);
            rs = ps.executeQuery();
            /**
             * set attributes for doctors from result set then add its to result
             * list
             */
            while (rs.next()) {
                Reservation reservation = new Reservation();
                User customer = new User(rs.getInt("user_id"), rs.getString("username"), rs.getString("full_name"));
                Service service = new Service(rs.getInt("service_id"), rs.getString("service_name"));
                ServicePackage servicePackage = new ServicePackage(rs.getInt("package_id"), rs.getString("package_title"), rs.getString("examination_duration"));
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
            throw ex;
        } finally {
            this.closeResultSet(rs);
            this.closePreparedStatement(ps);
            this.closeConnection(con);
        }
        return result;
    }

    @Override
    public Reservation getReservationById(int reservationId) throws SQLException, Exception {
        Reservation result = new Reservation();
        String sql = "SELECT reservations.reservation_id,\n"
                + "       reservations.customer_id,\n"
                + "       reservations.service_id,\n"
                + "       reservations.package_id,\n"
                + "       reservations.confirmed_doctor_id,\n"
                + "       reservations.request_examination_date,\n"
                + "       reservations.request_examination_time,\n"
                + "       reservations.confirmed_examination_date,\n"
                + "       reservations.reservation_date,\n"
                + "       reservations.confirmed_examination_time,\n"
                + "       reservations.reservation_status,\n"
                + "       reservations.medical_request,\n"
                + "       users.user_id,\n"
                + "       users.email,\n"
                + "       users.full_name,\n"
                + "       users.birth_date,\n"
                + "       users.gender,\n"
                + "       users.phone,\n"
                + "       users.address,\n"
                + "	  services.service_name,\n"
                + "	  packages.package_title,\n"
                + "	  packages.examination_duration\n"
                + "FROM reservations\n"
                + "INNER JOIN users ON reservations.customer_id = users.user_id\n"
                + "INNER JOIN services ON reservations.service_id = services.service_id\n"
                + "INNER JOIN packages ON reservations.package_id = packages.package_id\n"
                + "where reservations.reservation_id = ?";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getConnection(); //get connection
            ps = con.prepareStatement(sql);
            ps.setInt(1, reservationId);
            rs = ps.executeQuery();
            /**
             * set attributes for doctors from result set then add its to result
             * list
             */
            while (rs.next()) {
                User customer = new User(rs.getInt("user_id"), rs.getString("email"), rs.getString("full_name"), rs.getDate("birth_date"), rs.getBoolean("gender"), rs.getString("phone"), rs.getString("address"));
                Service service = new Service(rs.getInt("service_id"), rs.getString("service_name"));
                ServicePackage servicePackage = new ServicePackage(rs.getInt("package_id"), rs.getString("package_title"), rs.getString("examination_duration"));
                User doctor = new User(rs.getInt("confirmed_doctor_id"), "", "");
                result.setReservationId(rs.getInt("reservation_id"));
                result.setCustomer(customer);
                result.setService(service);
                result.setServicePackage(servicePackage);
                result.setConfirmedDoctor(doctor);
                result.setRequestExaminationDate(rs.getDate("request_examination_date"));
                result.setRequestExaminationTime(rs.getTime("request_examination_time"));
                result.setConfirmedExaminationDate(rs.getDate("confirmed_examination_date"));
                result.setConfirmedExaminationTime(rs.getTime("confirmed_examination_time"));
                result.setReservationDate(rs.getDate("reservation_date"));
                result.setReservationStatus(rs.getString("reservation_status"));
                result.setMedicalRequest(rs.getString("medical_request"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (Exception ex) {
            Logger.getLogger(ReservationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } finally {
            this.closeResultSet(rs);
            this.closePreparedStatement(ps);
            this.closeConnection(con);
        }
        return result;
    }

    /**
     * - Update reservation status
     *
     * @param reservationId is a <code>java.lang.int</code> object used to update
     * reservation by reservationId
     * @param reservationStatus is a <code>java.lang.String</code> object used to update
     * reservation by reservationStatus
     * @return a list of <code>Reservation</code> objects. <br>
     * -It is a <code>java.util.ArrayList</code> object
     * @throws SQLException when <code>java.sql.SQLException</code> occurs.
     * @throws Exception when <code>java.sql.Exception</code> occurs.
     */
    @Override
    public int updateReservationStatusById(int reservationId, String reservationStatus) throws SQLException, Exception {
        int check = 0;
        String sql = "UPDATE reservations\n"
                + "   SET reservation_status = ?\n"
                + " WHERE reservations.reservation_id = ?";
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = getConnection(); //get connection
            ps = con.prepareStatement(sql);
            ps.setString(1, reservationStatus);
            ps.setInt(2, reservationId);
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReservationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (Exception ex) {
            Logger.getLogger(ReservationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } finally {
            this.closePreparedStatement(ps);
            this.closeConnection(con);
        }
        return check;
    }

    public int count(int id) {
        Connection connecion = null;
        PreparedStatement countPreparedStatement = null;
        ResultSet countResultSet = null;
        try {
            connecion = getConnection();
                        String sql = "";
            if (id > 0) {
                sql = "SELECT COUNT(*) FROM (\n"
                        + " select DISTINCT r.reservation_id, p.examination_duration, p.package_title, p.price, s.service_name, r.reservation_status, r.medical_request, r.request_examination_date, r.confirmed_examination_date from reservations r join services s\n"
                        + "  on r.service_id = s.service_id\n"
                        + "  join packages p\n"
                        + "  on r.package_id = p.package_id and r.customer_id = ?\n"
                        + ") AS derived;";
            } else {
                sql = "SELECT COUNT(*) FROM (\n"
                        + " select DISTINCT r.reservation_id, p.examination_duration, p.package_title, p.price, s.service_name, r.reservation_status, r.medical_request, r.request_examination_date, r.confirmed_examination_date from reservations r join services s\n"
                        + "  on r.service_id = s.service_id\n"
                        + "  join packages p\n"
                        + "  on r.package_id = p.package_id\n"
                        + ") AS derived;";
            }
            countPreparedStatement = connecion.prepareStatement(sql);
            if (id > 0) {
                countPreparedStatement.setInt(1, id);
            }
            countResultSet = countPreparedStatement.executeQuery();
            if (countResultSet.next()) {
                // get and return count total services
                return countResultSet.getInt(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(countResultSet);
            closePreparedStatement(countPreparedStatement);
            closeConnection(connecion);
        }
        return 0;
    }

    @Override
    public Pagination<CustomerReservation> getAllCustomerReservation(int pageIndex, int pageSize, int id) {
        Pagination<CustomerReservation> pagination = new Pagination<>();
        List<CustomerReservation> customerReservations = new ArrayList<>();
        String sql = "  SELECT * FROM (SELECT DISTINCT ROW_NUMBER() OVER ( ORDER BY r.confirmed_examination_date )\n"
                + "                    AS RowNum, r.reservation_id,  p.examination_duration, p.package_title, p.price, s.service_name, r.reservation_status, r.medical_request, r.request_examination_date, r.confirmed_examination_date from reservations r join services s\n"
                + "  on r.service_id = s.service_id\n"
                + "  join packages p\n"
                + "  on r.package_id = p.package_id and r.customer_id = ?) \n"
                + "                    AS RowConstrainedResult\n"
                + "                    WHERE   RowNum >= ?\n"
                + "                  AND RowNum <= ?\n"
                + "                    ORDER BY RowNum";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getConnection(); //get connection
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, (pageIndex - 1) * pageSize);
            ps.setInt(3, (pageIndex - 1) * pageSize + pageSize);
            rs = ps.executeQuery();
            /**
             * set attributes for doctors from result set then add its to result
             * list
             */
            int totalItem = count(id); // count total service
            pagination.setCurrentPage(pageIndex);
            pagination.setItemPerPage(pageSize);
            pagination.setTotalItem(totalItem);
            while (rs.next()) {
                CustomerReservation reservation = new CustomerReservation();
                reservation.setId(rs.getInt("reservation_id"));
                reservation.setExaminationDuration(rs.getString("examination_duration"));
                reservation.setPackageTitle(rs.getString("package_title"));
                reservation.setPrice(rs.getFloat("price"));
                reservation.setServiceName(rs.getString("service_name"));
                reservation.setReservationStatus(rs.getString("reservation_status"));
                reservation.setMedicalRequest(rs.getString("medical_request"));
                reservation.setRequestExaminationDate(rs.getDate("request_examination_date"));
                reservation.setConfirmedExaminationDate(rs.getDate("confirmed_examination_date"));
                customerReservations.add(reservation);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
        pagination.setData(customerReservations);
        return pagination;
    }

    @Override
    public CustomerReservation getCustomerReservationById(int id) {
        Pagination<CustomerReservation> pagination = new Pagination<>();
        String sql = "  select DISTINCT r.reservation_id, p.examination_duration, p.package_title, p.price, s.service_name, r.reservation_status, r.medical_request, r.request_examination_date, r.confirmed_examination_date from reservations r join services s\n"
                + "  on r.service_id = s.service_id\n"
                + "  join packages p\n"
                + "  on r.package_id = p.package_id and r.reservation_id = ? ";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getConnection(); //get connection
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            /**
             * set attributes for doctors from result set then add its to result
             * list
             */
            int totalItem = count(0); // count total service
            while (rs.next()) {
                CustomerReservation reservation = new CustomerReservation();
                reservation.setId(rs.getInt("reservation_id"));
                reservation.setExaminationDuration(rs.getString("examination_duration"));
                reservation.setPackageTitle(rs.getString("package_title"));
                reservation.setPrice(rs.getFloat("price"));
                reservation.setServiceName(rs.getString("service_name"));
                reservation.setReservationStatus(rs.getString("reservation_status"));
                reservation.setMedicalRequest(rs.getString("medical_request"));
                reservation.setRequestExaminationDate(rs.getDate("request_examination_date"));
                reservation.setConfirmedExaminationDate(rs.getDate("confirmed_examination_date"));
                return reservation;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
        return null;
    }

    @Override
    public void bookReservation(ReservationDTO reservation) {
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connecion = getConnection();
            // Get data
            preparedStatement = connecion.prepareStatement("insert into reservations (customer_id,reservation_date,medical_request , "
                    + "reservation_status, service_id, package_id)\n"
                    + "  values (?,?,?,?,?,?)");
            preparedStatement.setInt(1, reservation.getId());
            preparedStatement.setDate(2, reservation.getRequestDate());
            preparedStatement.setString(3, reservation.getCustomerRequest());
            preparedStatement.setString(4, "Chờ duyệt");
            preparedStatement.setInt(5, 1);
            preparedStatement.setInt(6, 1);
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connecion);
        }
    }
}
