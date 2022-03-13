/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.FeedbackDTO;
import entity.Feedback;
import entity.Pagination;

/**
 *
 * @author Thanh Tung
 */
public interface FeedbackDAO {

    Pagination<FeedbackDTO> getAllFeedback(int pageIndex, int pageSize);
    
    void addFeedback(Feedback feedback);
    
}
