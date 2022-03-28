/*
 * Copyright(C) 2022, FPT University
 * CMS
 * CLINIC MANAGEMENT SYSTEM
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-11      1.0                 namnv           First Implement 
 */
package controller;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * * -This class uses function createAccount in
 * <code>dao.impl.UserIml</code> to get an
 * <code>java.util.ArrayList</code> object that contains a series of
 * <code>entity.User</code>
 *
 * @author Nguyen Van Nam
 */
public class RegisterForCustomerController extends HttpServlet {
    /**
     * -Use function createAccount in <code>dao.impl.UserIml</code> to
     * get an <code>java.util.ArrayList</code> object that contains a series of
     * <code>entity.User</code><br>
     
     * 
     * -Set parameters: username, email, password, repassword, fullname, phone, address, date<br>
     * -Finally forward user to the <code>viewAllReservation.jsp</code> page. Processes
     * requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response is
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username").trim();
        String email = request.getParameter("email").trim();
        String password = request.getParameter("password").trim();
        String rePassword = request.getParameter("re-password").trim();
        
        String fullName = request.getParameter("fullName").trim();
        
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        
        String date = request.getParameter("date").trim();
        format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
        java.util.Date jdate = format.parse(date);
        java.util.Date today = new java.util.Date();
        String phone = request.getParameter("phone").trim();
        String address = request.getParameter("address").trim();
        
        HttpSession session = request.getSession();
        
        session.setAttribute("username", username);
        session.setAttribute("username", username);
        session.setAttribute("email", email);
        session.setAttribute("password", password);
        session.setAttribute("rePassword", rePassword);
        session.setAttribute("fullName", fullName);
        session.setAttribute("phone", phone);
        session.setAttribute("address", address);
                session.setAttribute("date", date);

        
        session.removeAttribute("messageRegister");
        if (jdate.after(today)) {
            session.setAttribute("messageRegister", "Ngày sinh không lớn hơn ngày hiện tại!!!");
            response.sendRedirect("./jsp/Register.jsp");
            return;
        }
        
        if (!password.equals(rePassword)) {
            session.setAttribute("messageRegister", "Mật khẩu không khớp!!!");
            response.sendRedirect("./jsp/Register.jsp");
            return;
        }
        
        java.sql.Date sdate = new java.sql.Date(jdate.getTime());
        request.setAttribute("date", sdate);
        
        int check = Integer.parseInt(request.getParameter("gender").trim());
        boolean gender;
        if (check == 1) {
            gender = true;
        } else {
            gender = false;
        }
        
        User user = new User(4, 0, username, email, password, fullName, sdate, gender, phone, address, "", 0);
        UserDAO userDAO = new UserDAOImpl();
        
        if (userDAO.checkAccount(username)) {
            session.setAttribute("messageRegister", "Tên đăng nhập đã tồn tại!!!");
        } else {
            userDAO.createAccount(user);
            session.setAttribute("messageRegister", "Đăng kí tài khoản thành công!!!");
        }
        response.sendRedirect("./jsp/Register.jsp");
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(RegisterForCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(RegisterForCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
