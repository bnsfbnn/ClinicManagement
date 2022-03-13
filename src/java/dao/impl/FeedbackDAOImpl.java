

package dao.impl;

import context.DBContext;
import dao.FeedbackDAO;
import entity.Account;
import entity.FeedbackDTO;
import entity.Feedback;
import entity.Pagination;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TrangCT
 */
public class FeedbackDAOImpl extends DBContext implements FeedbackDAO {

    @Override
    public Pagination<FeedbackDTO> getAllFeedback(int pageIndex, int pageSize) {
        Pagination<FeedbackDTO> pagination = new Pagination<>();
        List<FeedbackDTO> feedbacks = new ArrayList<>();
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connecion = getConnection();
            int totalItem = count(); // 
            pagination.setCurrentPage(pageIndex);
            pagination.setItemPerPage(pageSize);
            pagination.setTotalItem(totalItem);
            // Get data
            preparedStatement = connecion.prepareStatement(" SELECT * FROM  ( SELECT  ROW_NUMBER() OVER ( ORDER BY  f.feedback_id ) AS RowNum,  f.feedback_id, f.feedback_content, f.feedback_time, u.full_name, s.service_name, e.examination_prescription from feedbacks f join users u\n"
                    + "  on f.customer_id = u.user_id\n"
                    + "  join services s\n"
                    + "  on f.service_id = s.service_id\n"
                    + "  join examinations e\n"
                    + "  on f.examination_id = e.examination_id\n"
                    + "                          ) AS RowConstrainedResult\n"
                    + "                    WHERE   RowNum >= ?\n"
                    + "                       AND RowNum <= ?\n"
                    + "                    ORDER BY RowNum");
            preparedStatement.setInt(1, (pageIndex - 1) * pageSize);
            preparedStatement.setInt(2, (pageIndex - 1) * pageSize + pageSize);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                FeedbackDTO feedback = new FeedbackDTO();
                feedback.setCustomer(rs.getString("full_name"));
                feedback.setExamination(rs.getString("examination_prescription"));
                feedback.setFeedbackContent(rs.getString("feedback_content"));
                feedback.setService(rs.getString("service_name"));
                feedback.setFeedbackId(rs.getInt("feedback_id"));
                feedback.setFeedbackTime(rs.getDate("feedback_time"));
                feedback.setUsername(rs.getString("username"));
                feedbacks.add(feedback);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResultSet(rs);
            closePreparedStatement(preparedStatement);
            closeConnection(connecion);
        }
        pagination.setData(feedbacks);
        return pagination;
    }

    public int count() {
        Connection connecion = null;
        PreparedStatement countPreparedStatement = null;
        ResultSet countResultSet = null;
        try {
            connecion = getConnection();
            countPreparedStatement = connecion.prepareStatement("SELECT COUNT(feedback_id) AS id FROM feedbacks");
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
    public void addFeedback(Feedback feedback) {
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connecion = getConnection();
            // Get data
            preparedStatement = connecion.prepareStatement("  insert into feedbacks (customer_id, service_id, examination_id,feedback_content, feedback_time)\n"
                    + "  values (?,?,?,?, ?)");
            preparedStatement.setInt(1, feedback.getCustomerId());
            preparedStatement.setInt(1, feedback.getServiceId());
            preparedStatement.setInt(1, feedback.getExaminationId());
            preparedStatement.setString(4, feedback.getFeedbackContent());
            preparedStatement.setDate(5, feedback.getFeedbackTime());
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
