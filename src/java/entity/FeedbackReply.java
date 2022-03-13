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

    private int id;
    private int feedback;
    private String content;
    private Date date;

    public FeedbackReply(int id, int feedback, String content, Date date) {
        this.id = id;
        this.feedback = feedback;
        this.content = content;
        this.date = date;
    }

    public FeedbackReply() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFeedback() {
        return feedback;
    }

    public void setFeedback(int feedback) {
        this.feedback = feedback;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    

}
