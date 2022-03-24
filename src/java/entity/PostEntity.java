/*
 * Copyright(C) 20022, FPT University
 * CMS:
 * Clinic Management System
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-28     1.0                 TrangCT          Post Entity  Implement
 */
package entity;

import java.sql.Date;
import java.sql.Time;

/**
 * <h1>PostEntity </h1>
 * storage data of a post
 * <p>
 *
 *
 * @author TrangCT
 * @version 1.0
 * @since 2022-02-28
 */
public class PostEntity {
    private int id;
    private int userId;
    private String title;
    private String summary;
    private String content;
    private Date createDate;
    private String postImage;
    private Time createTime;

     /**
     * Create an instance of <code>PostEntity</code> object with value of
     * attributes of <code>Post</code>
     *
     *@param id the value of id attribute. It's a
     * <code>java.lang.int</code> object
     * @param userId the value of user id attribute. It's a
     * <code>java.lang.int</code> object
     * @param title the value of post tile. It's a
     * <code>java.lang.Title</code> object
     * @param summary the value of summary post attribute. It's a
     * <code>java.lang.summary</code> object
     * @param content the value of content post attribute. It's a
     * <code>java.lang.content</code> object
     * @param createDate the value of createDate attribute. It's a
     * <code>java.lang.Date</code> object
     * @param postImage the value of reservationStatus attribute. It's a
     * <code>java.lang.String</code> object
       */
    public PostEntity(int id, int userId, String title, String summary, String content, Date createDate, String postImage) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.createDate = createDate;
        this.postImage = postImage;
    }
     /**
     * Create an instance of <code>PostEntity</code> object
     */

    public PostEntity() {
    }
    /**
     * Return the value of ID attribute of the
     * <code>PostEntity</code> object.
     */
    public int getId() {
        return id;
    }
/**
     * Set id value of the <code>PostEntity</code> object.
     *
     * @param id is a <code>java.lang.int</code> this value is the
     * id of the <code>PostEntity</code> object.
     */
    public void setId(int id) {
        this.id = id;
    }
  /**
     * @return  the value of userId attribute of the
     * <code>PostEntity</code> object.
     */
    public int getUserId() {
        return userId;
    }
/**
     * Set user id value of the <code>PostEntity</code> object.
     *
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
  /**
     * Return the value of title attribute of the
     * <code>PostEntity</code> object.
     */
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
  /**
     * Return the value of summary attribute of the
     * <code>PostEntity</code> object.
     */
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
  /**
     * Return the value of content attribute of the
     * <code>PostEntity</code> object.
     */
    public String getContent() {
        return content;
    }
 /**
     * Set content
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }
  /**
     * Return the value of createDate attribute of the
     * <code>PostEntity</code> object.
     */
    public Date getCreateDate() {
        return createDate;
    }
     /**
     * Set createDate
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
      /**
     * Return the value of post image attribute of the
     * <code>PostEntity</code> object.
     */

    public String getPostImage() {
        return postImage;
    }
    /**
     * Set postImage
     * @param postImage
     */
    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }

      /**
     * Return the value of createTime attribute of the
     * <code>PostEntity</code> object.
     */
    public Time getCreateTime() {
        return createTime;
    }
    /**
     * Set createTime
     * @param createTime
     */
    public void setCreateTime(Time createTime) {
        this.createTime = createTime;
    }
    
    
}
