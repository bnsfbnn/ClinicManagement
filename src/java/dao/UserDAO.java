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

import entity.User;
import java.util.List;

/**
 * This is an interface contains methods of <code>User</code> object<br>
 * 
 * Bugs: none
 * @author Hoang Thi Thu Huong
 */
public interface UserDAO {

    User login(String username, String password);
    
    List<Account> getAllAccount();
    
    void deleteAccount(int id);
    
    void updateAccount(User user);
}
