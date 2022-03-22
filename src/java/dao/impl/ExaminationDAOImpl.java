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

import static config.Configuration.PAGE_SIZE;
import context.DBContext;
import dao.ExaminationDAO;
import entity.Examination;
import entity.Reservation;
import entity.Service;
import entity.ServicePackage;
import entity.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * -The class contains method get information relate to Examination<br>
 * -The method will throw an object of <code>java.lang.Exception</code> class if
 * there is any error occurring when reading data false.<br>
 *
 * @author Nguyễn Thanh Tùng
 */
public class ExaminationDAOImpl extends DBContext implements ExaminationDAO {

    /**
     * - Get full information about a examination (such as customer information,
     * service information, package information, all examination information)
     *
     * @param userId is a <code>java.lang.int</code> object used to get
     * examination by userId
     *
     * @return a list of <code>Examination</code> objects. <br>
     * -It is a <code>java.util.ArrayList</code> object
     * @throws SQLException when <code>java.sql.SQLException</code> occurs.
     * @throws Exception when <code>java.sql.Exception</code> occurs.
     */
    @Override
    public ArrayList<Examination> getExamninationByUserId(int userId, int PAGE_SIZE, int currentPage) throws SQLException, Exception {
        ArrayList<Examination> result = new ArrayList<>();
        String sql = "SELECT * FROM (SELECT services.service_name,\n"
                + "      packages.package_title,\n"
                + "      users.full_name,\n"
                + "     reservations.reservation_status,\n"
                + "      examinations.examination_disgnosis,\n"
                + "       examinations.examination_prescription,\n"
                + "	  examinations.examination_date,\n"
                + "	  reservations.reservation_id,\n"
                + "	  examinations.examination_id,\n"
                + "	  ROW_NUMBER() OVER (ORDER BY examinations.examination_date DESC) AS row_num\n"
                + "FROM examinations\n"
                + "INNER JOIN reservations ON examinations.reservation_id = reservations.reservation_id\n"
                + "INNER JOIN users ON examinations.doctor_id = users.user_id\n"
                + "INNER JOIN packages ON reservations.package_id = packages.package_id\n"
                + "INNER JOIN services ON users.service_id = services.service_id\n"
                + "WHERE reservations.customer_id = ?) as [examination]\n"
                + "WHERE row_num >= ? * (? - 1) + 1\n"
                + "AND row_num <= ? * ?";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getConnection(); //get connection
            ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setInt(2, PAGE_SIZE);
            ps.setInt(3, currentPage);
            ps.setInt(4, PAGE_SIZE);
            ps.setInt(5, currentPage);
            rs = ps.executeQuery();
            /**
             * set attributes for reservation from result set then add its to
             * result list
             */
            while (rs.next()) {
                Examination examination = new Examination();
                Reservation reservation = new Reservation(new Service(rs.getString("service_name")), new ServicePackage(rs.getString("package_title")), rs.getString("reservation_status"));
                User doctor = new User(rs.getString("full_name"));
                examination.setExaminationId(rs.getInt("examination_id"));
                examination.setExaminationId(rs.getInt("reservation_id"));
                examination.setReservation(reservation);
                examination.setDoctor(doctor);
                examination.setExaminationDisgnosis(rs.getString("examination_disgnosis"));
                examination.setExaminationPrescription(rs.getString("examination_prescription"));
                examination.setExaminationDate(rs.getDate("examination_date"));
                result.add(examination);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExaminationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (Exception ex) {
            Logger.getLogger(ExaminationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } finally {
            this.closeResultSet(rs);
            this.closePreparedStatement(ps);
            this.closeConnection(con);
        }
        return result;
    }

    /**
     * - Get full information about a examination (such as customer information,
     * service information, package information, all examination information)
     *
     * @param examinationId is a <code>java.lang.int</code> object used to get
     * examination by examinationId
     *
     * @return a <code>Examination</code> objects. <br>
     * @throws SQLException when <code>java.sql.SQLException</code> occurs.
     * @throws Exception when <code>java.sql.Exception</code> occurs.
     */
    @Override
    public Examination getExamninationById(int examinationId) throws SQLException, Exception {
        Examination result = new Examination();
        String sql = "SELECT services.service_name,\n"
                + "       packages.package_title,\n"
                + "       users.full_name,\n"
                + "       reservations.reservation_status,\n"
                + "       examinations.examination_disgnosis,\n"
                + "       examinations.examination_prescription,\n"
                + "	   examinations.examination_date,\n"
                + "	   reservations.reservation_id,\n"
                + "	   examinations.examination_id\n"
                + "FROM examinations\n"
                + "INNER JOIN reservations ON examinations.reservation_id = reservations.reservation_id\n"
                + "INNER JOIN users ON examinations.doctor_id = users.user_id\n"
                + "INNER JOIN packages ON reservations.package_id = packages.package_id\n"
                + "INNER JOIN services ON users.service_id = services.service_id\n"
                + "WHERE examinations.examination_id = ?";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getConnection(); //get connection
            ps = con.prepareStatement(sql);
            ps.setInt(1, examinationId);
            rs = ps.executeQuery();
            /**
             * set attributes for reservation from result set then add its to
             * result list
             */
            while (rs.next()) {
                Reservation reservation = new Reservation(new Service(rs.getString("service_name")), new ServicePackage(rs.getString("package_title")), rs.getString("reservation_status"));
                User doctor = new User(rs.getString("full_name"));
                result.setExaminationId(rs.getInt("examination_id"));
                result.setExaminationId(rs.getInt("reservation_id"));
                result.setReservation(reservation);
                result.setDoctor(doctor);
                result.setExaminationDisgnosis(rs.getString("examination_disgnosis"));
                result.setExaminationPrescription(rs.getString("examination_prescription"));
                result.setExaminationDate(rs.getDate("examination_date"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExaminationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (Exception ex) {
            Logger.getLogger(ExaminationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } finally {
            this.closeResultSet(rs);
            this.closePreparedStatement(ps);
            this.closeConnection(con);
        }
        return result;
    }

    /**
     * - insert new examination after execute examination
     *
     * @param reservationId is a <code>java.lang.int</code> object used to add
     * new examination
     * @param doctorId is a <code>java.lang.int</code> object used to add new
     * examination
     * @param examinationDisgosis is a <code>java.lang.String</code> object used
     * to add new examination
     * @param examinationPrescription is a <code>java.lang.String</code> object
     * used to add new examination
     *
     * @return a <code>Examination</code> objects. <br>
     * @throws SQLException when <code>java.sql.SQLException</code> occurs.
     * @throws Exception when <code>java.sql.Exception</code> occurs.
     */
    @Override
    public int insertNewExamination(int reservationId, int doctorId, String examinationDisgosis, String examinationPrescription, Date examinationDate) throws SQLException, Exception {
        int check = 0;
        String sql = "INSERT INTO [dbo].[examinations]\n"
                + "           ([reservation_id]\n"
                + "           ,[doctor_id]\n"
                + "           ,[examination_disgnosis]\n"
                + "           ,[examination_prescription]\n"
                + "           ,[examination_date])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = getConnection(); //get connection
            ps = con.prepareStatement(sql);
            ps.setInt(1, reservationId);
            ps.setInt(2, doctorId);
            ps.setString(3, examinationDisgosis);
            ps.setString(4, examinationPrescription);
            ps.setDate(5, examinationDate);
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ExaminationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (Exception ex) {
            Logger.getLogger(ExaminationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } finally {
            this.closePreparedStatement(ps);
            this.closeConnection(con);
        }
        return check;
    }

    @Override
    public int countExamninationByUserId(int userId) throws SQLException, Exception {
        int number = -1;
        String sql = "SELECT Count(examinations.examination_id) as nOE\n"
                + "FROM examinations\n"
                + "INNER JOIN reservations ON examinations.reservation_id = reservations.reservation_id\n"
                + "INNER JOIN users ON examinations.doctor_id = users.user_id\n"
                + "INNER JOIN packages ON reservations.package_id = packages.package_id\n"
                + "INNER JOIN services ON users.service_id = services.service_id\n"
                + "WHERE reservations.customer_id = ?";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getConnection(); //get connection
            ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            /**
             * set attributes for reservation from result set then add its to
             * result list
             */
            while (rs.next()) {
                number = rs.getInt("nOE");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExaminationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (Exception ex) {
            Logger.getLogger(ExaminationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } finally {
            this.closeResultSet(rs);
            this.closePreparedStatement(ps);
            this.closeConnection(con);
        }
        return number;
    }
}
