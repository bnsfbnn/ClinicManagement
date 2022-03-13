
package dao;

import entity.FeedbackDTO;
import entity.Feedback;
import entity.Pagination;

/**
 *
 * @author TrangCT
 */
public interface FeedbackDAO {

    Pagination<FeedbackDTO> getAllFeedback(int pageIndex, int pageSize);
    
    void addFeedback(Feedback feedback);
    
}