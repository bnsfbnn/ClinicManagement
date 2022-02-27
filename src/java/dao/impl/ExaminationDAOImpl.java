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
    public ArrayList<Examination> getExamninationByUserId(int userId) throws SQLException, Exception {
        ArrayList<Examination> result = new ArrayList<>();
        String sql = "SELECT services.service_name,\n"
                + "       packages.package_title,\n"
                + "       users.full_name,\n"
                + "       reservations.reservation_status,\n"
                + "       examinations.examination_disgnosis,\n"
                + "       examinations.examination_prescription,\n"
                + "	  examinations.examination_date,\n"
                + "	  reservations.reservation_id,\n"
                + "	  examinations.examination_id\n"
                + "FROM examinations\n"
                + "INNER JOIN reservations ON examinations.reservation_id = reservations.reservation_id\n"
                + "INNER JOIN users ON examinations.doctor_id = users.user_id\n"
                + "INNER JOIN packages ON reservations.package_id = packages.package_id\n"
                + "INNER JOIN services ON users.service_id = services.service_id\n"
                + "WHERE reservations.customer_id = ?\n"
                + "ORDER BY examination_date DESC";
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
}
