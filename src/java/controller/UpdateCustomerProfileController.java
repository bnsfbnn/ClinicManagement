/*
 * Copyright(C) 2022, FPT University
 * CMS
 * CLINIC MANAGEMENT SYSTEM
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-03-8      1.0                 namnv           First Implement 
 */
package controller;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import entity.User;
import java.io.IOException;
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
 * * -This class uses function updateAccount in <code>dao.impl.UserIml</code>
 * to update an <code>java.util.ArrayList</code> object that contains a series
 * of <code>entity.User</code>
 *
 * @author Nguyen Van Nam
 */
public class UpdateCustomerProfileController extends HttpServlet {

    /**
     * -Use function updateAccount in <code>dao.impl.UserIml</code> to get an
     * <code>java.util.ArrayList</code> object that contains a series of
     * <code>entity.User</code><br>
     *
     *
     * -Set parameters: viewDay, doctors, services, reservations<br>
     * -Finally forward user to the <code>user_profile.jsp</code> page.
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
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
        String email = request.getParameter("email").trim();
        String fullName = request.getParameter("fullName").trim();
        String phone = request.getParameter("phone").trim();
        String address = request.getParameter("address").trim();
        int id = Integer.parseInt(request.getParameter("id"));

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        String date = request.getParameter("date").trim();
        format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
        java.util.Date jdate = format.parse(date);
        java.sql.Date sdate = new java.sql.Date(jdate.getTime());
        HttpSession session = request.getSession();
        java.util.Date today = new java.util.Date();

        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("./jsp/login.jsp");
            return;
        }
        user.setAddress(address);
        user.setEmail(email);
        user.setPhone(phone);
        user.setFullName(fullName);
        user.setBirthDate(sdate);

        session.setAttribute("user", user);

        session.removeAttribute("messageProfile");
        if (jdate.after(today)) {
            session.setAttribute("error", true);
            session.setAttribute("messageProfile", "Ngày sinh không lớn hơn ngày hiện tại!!!");
            response.sendRedirect("./jsp/user_profile.jsp");
            return;
        }

        UserDAO userDAO = new UserDAOImpl();
        userDAO.updateAccount(user);
        session.setAttribute("error", false);
        session.setAttribute("messageProfile", "Cập nhật thành công!!!");
        response.sendRedirect("./jsp/user_profile.jsp");

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
            Logger.getLogger(UpdateCustomerProfileController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UpdateCustomerProfileController.class.getName()).log(Level.SEVERE, null, ex);
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
