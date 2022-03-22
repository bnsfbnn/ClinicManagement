/*
 * Copyright(C) 20022, FPT University
 * CMS:
 * Clinic Management System
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-22      1.0                 TrangCT          FeedbackDAO 
 */
package dao;

import entity.FeedbackDTO;
import entity.Feedback;
import entity.Pagination;
import java.sql.Date;
import java.util.List;


public interface FeedbackDAO {

    Pagination<FeedbackDTO> getAllFeedback(int pageIndex, int pageSize, String time);

    void addFeedback(Feedback feedback);

    Pagination<FeedbackDTO> getAllFeedback(int pageIndex, int pageSize, int service, String time);

    /**
     * - Get all date  
     *
     * @return a list of <code>Date</code> objects. <br>
     * -It is a <code>java.util.ArrayList</code> object
     * @throws SQLException when <code>java.sql.SQLException</code> occurs.
     */
    List<Date> getAllDate();
      /**
     * - Get all feedback  of customer
     *
     * @param pageIndex integer
     * @param pageSize integer
     * @param id integer
     * @param time string
     * @return pagination Pagination 
     * Author: TrangCT
     */

    Pagination<FeedbackDTO> getAllCustomerFeedback(int pageIndex, int pageSize, String time, int id);
      /**
     * - Get all feedback  of customer
     *
     * @param pageIndex integer
     * @param pageSize integer
     * @param id integer
     * @param time string
     * @param service string
     * @return pagination Pagination 
     * Author: TrangCT
     */

    Pagination<FeedbackDTO> getAllCustomerFeedback(int pageIndex, int pageSize, int service, String time, int id);

}
