/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author Thanh Tung
 */
public class FeedbackReply {
    private int feedbackReplyId;
    private int feedbackId;
    private String feedbackReplyContent;
    private Date feedbackReplyTime;

    public FeedbackReply() {
    }

    public FeedbackReply(int feedbackReplyId, int feedbackId, String feedbackReplyContent, Date feedbackReplyTime) {
        this.feedbackReplyId = feedbackReplyId;
        this.feedbackId = feedbackId;
        this.feedbackReplyContent = feedbackReplyContent;
        this.feedbackReplyTime = feedbackReplyTime;
    }

    public int getFeedbackReplyId() {
        return feedbackReplyId;
    }

    public void setFeedbackReplyId(int feedbackReplyId) {
        this.feedbackReplyId = feedbackReplyId;
    }

    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getFeedbackReplyContent() {
        return feedbackReplyContent;
    }

    public void setFeedbackReplyContent(String feedbackReplyContent) {
        this.feedbackReplyContent = feedbackReplyContent;
    }

    public Date getFeedbackReplyTime() {
        return feedbackReplyTime;
    }

    public void setFeedbackReplyTime(Date feedbackReplyTime) {
        this.feedbackReplyTime = feedbackReplyTime;
    }
    
}
