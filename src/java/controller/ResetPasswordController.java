/*
 * Copyright(C) 2022, FPT University
 * CMS
 * CLINIC MANAGEMENT SYSTEM
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-03-15      1.0                 namnv           First Implement 
 */
package controller;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * * -This class uses function getReservations in
 * <code>dao.impl.reservationDAOImpl</code> to get an
 * <code>java.util.ArrayList</code> object that contains a series of
 * <code>entity.Reservation</code>
 *
 * @author Nguyen Van Nam
 */
public class ResetPasswordController extends HttpServlet {

    /**
     * -Use function getReservations in <code>dao.impl.ReservationDAOImpl</code>
     * to get an <code>java.util.ArrayList</code> object that contains a series
     * of <code>entity.Reservation</code><br>
     * -Use function getDoctorsHasReservation in
     * <code>dao.impl.ReservationDAOImpl</code> to get an
     * <code>java.util.ArrayList</code> object that contains a series of
     * <code>entity.User</code><br> represent for a doctor -Use function
     * getServices in <code>dao.impl.ServiceDAOImpl</code> to get an
     * <code>java.util.ArrayList</code> object that contains a series of
     * <code>entity.Service</code><br>
     *
     * -Set parameters: viewDay, doctors, services, reservations<br>
     * -Finally forward user to the <code>viewAllReservation.jsp</code> page.
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response is
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String password = request.getParameter("password");
        String rePassword = request.getParameter("re-password");
        String code = request.getParameter("code");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        request.setAttribute("password", password);
        request.setAttribute("codePass", code);
        request.setAttribute("rePassword", rePassword);
        String codeSended = session.getAttribute("code").toString();
        if (!codeSended.equals(code)) {
            request.setAttribute("messageReset", "Code không chính xác!!!");
            request.getRequestDispatcher("./jsp/setPassword.jsp").forward(request, response);
            return;
        }
        if (!password.equals(rePassword)) {
            request.setAttribute("messageReset", "Mật khẩu không khớp!!!");
            request.getRequestDispatcher("./jsp/setPassword.jsp").forward(request, response);
            return;
        }
        UserDAO userDAO = new UserDAOImpl();
        userDAO.updatePassword(user.getUsername(), rePassword);
        session.invalidate();
        request.setAttribute("messageReset", "Cập nhật mật khẩu thành công!!!");
        request.getRequestDispatcher("./jsp/setPassword.jsp").forward(request, response);

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
        processRequest(request, response);
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
        processRequest(request, response);
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
