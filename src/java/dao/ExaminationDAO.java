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

import entity.Examination;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * This class is an interface contains methods of Examination
 *
 * @author Nguyễn Thanh Tùng
 */
public interface ExaminationDAO {

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
    public ArrayList<Examination> getExamninationByUserId(int userId) throws SQLException, Exception;
}
