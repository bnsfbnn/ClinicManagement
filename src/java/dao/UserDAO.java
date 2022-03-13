/*
 * Copyright(C) 2022, FPT University
 * CMS
 * CLINIC MANAGEMENT SYSTEM
 *
 * Record of change:
 * DATE            Version          AUTHOR           DESCRIPTION
 * 2022-02-08      1.0              HuongHTT         First Implement 
 */
package dao;

import entity.Account;
import entity.Pagination;
import entity.User;

/**
 * This is an interface contains methods of <code>User</code> object<br>
 *
 * Bugs: none
 *
 * @author Hoang Thi Thu Huong
 */
public interface UserDAO {

    User login(String username, String password);

    /**
     * - Get all account with infomation
     *
     * @param pageIndex
     * @param pageSize
     * @return a list of <code>Account</code> objects. <br>
     * -It is a <code>java.util.List</code> object
     * @throws SQLException when <code>java.sql.SQLException</code> occurs.
     */
    Pagination<Account> getAllAccount(int pageIndex, int pageSize);

    /**
     * Delete a <code>entity.Account</code> entity by id.
     *
     * @param id is id of an account that will be deleted.
     */
    void deleteAccount(int id);
    
    void updateAccount(User user);
    
    void createAccount (User user);
    
    void addDoctorForService(int doctor, int service);
    
    void updateAccountByAdmin(User user);
     
    User getUserById(int id);
}
