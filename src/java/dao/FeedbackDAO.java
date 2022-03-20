package dao;

import entity.FeedbackDTO;
import entity.Feedback;
import entity.Pagination;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author TrangCT
 */
public interface FeedbackDAO {

    Pagination<FeedbackDTO> getAllFeedback(int pageIndex, int pageSize, String time);

    void addFeedback(Feedback feedback);

    Pagination<FeedbackDTO> getAllFeedback(int pageIndex, int pageSize, int service, String time);

    List<Date> getAllDate();

}