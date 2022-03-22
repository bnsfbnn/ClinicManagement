/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

/**
 *
 * @author Nguyen Van Nam
 */
public class RegisterForCustomerController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
     response.setContentType("text/html;charset=UTF-8");
request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username").trim();
        String email = request.getParameter("email").trim();
        String password = request.getParameter("password").trim();
        String rePassword = request.getParameter("re-password").trim();
        if (!password.equals(rePassword)) {
            request.setAttribute("message", "Password not match");
            request.getRequestDispatcher("./jsp/Register.jsp").forward(request, response);
            return;
        }
        String fullName = request.getParameter("fullName").trim();

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        String date = request.getParameter("date").trim();
        format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
        java.util.Date jdate = format.parse(date);
        java.sql.Date sdate = new java.sql.Date(jdate.getTime());

        int check = Integer.parseInt(request.getParameter("gender").trim());
        boolean gender;
        if (check == 1) {
            gender = true;
        } else {
            gender = false;
        }
        String phone = request.getParameter("phone").trim();
        String address = request.getParameter("address").trim();

        User user = new User(4, 0, username, email, password, fullName, sdate, gender, phone, address, "", 0);
        UserDAO userDAO = new UserDAOImpl();
        if (userDAO.login(username, password) != null) {
            request.setAttribute("message", "Username existed");
            request.getRequestDispatcher("./jsp/Register.jsp").forward(request, response);
        } else {
            userDAO.createAccount(user);
            request.getRequestDispatcher("./jsp/login.jsp").forward(request, response);
        }
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
