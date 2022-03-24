/*
 * Copyright(C) 20022, FPT University
 * CMS:
 * Clinic Management System
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-28      1.0                 TrangCT          Post Dao Ipml
 */
package dao.impl;

import context.DBContext;
import dao.PostDAO;
import entity.PostEntity;
import entity.ServicePackage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <h1>Post DAO</h1>
 * Data access object connect database and access data. - count : count list
 * post - getAllPost : get list post  - getById : get
 * get post by id
 * searchPost: search post for title post 
 * <p>
 *
 
 */
public class PostDAOImpl extends DBContext implements PostDAO {
    
    /**
     * - Get all post of post
     *
     * @return a list of <code>PostEntity</code> objects. <br>
     * -It is a <code>java.util.ArrayList</code> object
     * @throws SQLException
     */

    @Override
    public List<PostEntity> getAllPost() {
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<PostEntity> posts = new ArrayList<>();
        try {

            connecion = getConnection();
            preparedStatement = connecion.prepareStatement("select * from posts");

            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                PostEntity p = new PostEntity();
                p.setId(rs.getInt("id"));
                p.setUserId(rs.getInt("user_id"));
                p.setTitle(rs.getString("title"));

                String summary = rs.getString("summary");
                if (summary.length() > 250) {
                    summary = summary.substring(0, 250) + "...";
                }
                p.setSummary(summary);
                p.setContent(rs.getString("content"));
                p.setCreateDate(rs.getDate("create_date"));
                p.setCreateTime(rs.getTime("create_time"));
                p.setPostImage(rs.getString("post_images"));
                posts.add(p);
            }
        } catch (Exception ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResultSet(rs);
            closePreparedStatement(preparedStatement);
            closeConnection(connecion);
        }
        return posts;
    }
   /**
     * - Search Post for title post 
     *
     * @return a list of <code>PostEntity</code> objects. <br>
     * -It is a <code>java.util.ArrayList</code> object
     * @throws SQLException
     */
    @Override
    public List<PostEntity> searchPost(String value) {
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<PostEntity> posts = new ArrayList<>();
        try {

            connecion = getConnection();
            preparedStatement = connecion.prepareStatement("select * from posts where title like N'%" + value + "%'");
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                PostEntity p = new PostEntity();
                p.setId(rs.getInt("id"));
                p.setUserId(rs.getInt("user_id"));
                p.setTitle(rs.getString("title"));
                String summary = rs.getString("summary");
                if (summary.length() > 250) {
                    summary = summary.substring(0, 250) + "...";
                }
                p.setSummary(summary);
                p.setContent(rs.getString("content"));
                p.setCreateDate(rs.getDate("create_date"));
                p.setCreateTime(rs.getTime("create_time"));
                p.setPostImage(rs.getString("post_images"));
                posts.add(p);
            }
        } catch (Exception ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResultSet(rs);
            closePreparedStatement(preparedStatement);
            closeConnection(connecion);
        }
        return posts;
    }
 /**
     * Method: Get Post By Id - Get and return data of post by an id
     *
     * @param id
     * @return post Post
     */
    @Override
    public PostEntity getPostById(int id) {
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<PostEntity> posts = new ArrayList<>();
        try {

            connecion = getConnection();
            preparedStatement = connecion.prepareStatement("select * from posts where id = ?");
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                PostEntity p = new PostEntity();
                p.setId(rs.getInt("id"));
                p.setUserId(rs.getInt("user_id"));
                p.setTitle(rs.getString("title"));
                p.setSummary(rs.getString("summary"));
                p.setContent(rs.getString("content"));
                p.setCreateDate(rs.getDate("create_date"));
                p.setCreateTime(rs.getTime("create_time"));
                p.setPostImage(rs.getString("post_images"));
                return p;
            }
        } catch (Exception ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResultSet(rs);
            closePreparedStatement(preparedStatement);
            closeConnection(connecion);
        }
        return null;
    }

}
