/*
 * Copyright(C) 2022, FPT University
 * CMS
 * CLINIC MANAGEMENT SYSTEM
 *
 * Record of change:
 * DATE            Version          AUTHOR           DESCRIPTION
 * 2022-02-08      1.0              HuongHTT         First Implement 
 */
package dao.impl;

import context.DBContext;
import dao.UserDAO;
import entity.Account;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thanh Tung
 */
public class UserDAOImpl extends DBContext implements UserDAO {

    /**
     * Logger for system
     */
    private static Logger logger = Logger.getLogger(UserDAOImpl.class.getName());
/*
    * Get all user from database. 
    * 
    * @return a list of <code>User</code> objects. It is
    * a <code>java.util.List</code> object 
    */
    @Override
    public User login(String username, String password) {
        logger.log(Level.INFO, "Login Controller");
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            connecion = getConnection();
            // Get data
            preparedStatement = connecion.prepareStatement("select * from users c join roles r on c.role_id = r.role_id where username = ? and password = ?");
            preparedStatement.setNString(1, username);
            preparedStatement.setNString(2, password);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setRoleId(rs.getInt("role_id"));
                user.setServiceId(rs.getInt("service_id"));
                user.setUsername(username);
                user.setEmail(rs.getString("email"));
                user.setPassword(password);
                user.setFullName(rs.getString("full_name"));
                user.setBirthDate(rs.getDate("birth_date"));
                user.setGender(rs.getBoolean("gender"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setAvatarImage(rs.getString("avatar_image"));
                return user;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResultSet(rs);
            closePreparedStatement(preparedStatement);
            closeConnection(connecion);
        }
        return null;
    }

    /*
    * Get all accounts from database. 
    * 
    * @return a list of <code>Account</code> objects. It is
    * a <code>java.util.List</code> object 
    */
    @Override
    public List<Account> getAllAccount() {
        logger.log(Level.INFO, "Login Controller");
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<Account> users = new ArrayList<>();
        try {
            connecion = getConnection();
            // Get data
            preparedStatement = connecion.prepareStatement("select * from users c join roles r on c.role_id = r.role_id");
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Account user = new Account();
                user.setUserId(rs.getInt("user_id"));
                user.setRole(rs.getString("role_name"));
                user.setServiceId(rs.getInt("service_id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setFullName(rs.getString("full_name"));
                user.setBirthDate(rs.getDate("birth_date"));
                user.setGender(rs.getBoolean("gender"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setAvatarImage(rs.getString("avatar_image"));
                users.add(user);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResultSet(rs);
            closePreparedStatement(preparedStatement);
            closeConnection(connecion);
        }
        return users;
    }

    @Override
    public void deleteAccount(int id) {
        logger.log(Level.INFO, "Delete account with id");
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connecion = getConnection();
            // Get data
            preparedStatement = connecion.prepareStatement("delete from users where user_id = ?;");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connecion);
        }
    }

    @Override
    public void updateAccount(User user) {

        logger.log(Level.INFO, "Delete account with id");
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connecion = getConnection();
            // Get data
            preparedStatement = connecion.prepareStatement("delete from users where user_id = ?;");
//            preparedStatement.setInt(1, id);
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




