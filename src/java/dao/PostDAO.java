/*
 * Copyright(C) 20022, FPT University
 * CMS:
 * Clinic Management System
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-28      1.0                 TrangCT          Post DAO 
 */
package dao;

import entity.PostEntity;
import java.util.List;

/**
 * <h1>Post DAO</h1>
 * Interface PostDAO. Method access and return data. Its method is implements
 * by PostDAOIpml class
 * <p>
 *
 *
 * @author TrangCT
 * @version 1.0
 * @since 2022-02-28
 */
public interface PostDAO {
    /**
     * - Get all post  
     *
     * @return a list of <code>PostEntity</code> objects. <br>
     * -It is a <code>java.util.ArrayList</code> object
     * @throws SQLException when <code>java.sql.SQLException</code> occurs.
     */
    List<PostEntity> getAllPost();
     /**
     * Search post for title 
     *
     * @param value
    
     * @return list services
     */
   
    List<PostEntity> searchPost(String value);
    /**
     * Get post by id
     *
     * @param id
     * @return post
     */

    PostEntity getPostById(int id);
}
