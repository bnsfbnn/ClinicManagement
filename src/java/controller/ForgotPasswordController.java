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

import config.EmailUtility;
import dao.UserDAO;
import dao.impl.UserDAOImpl;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletContext;
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
public class ForgotPasswordController extends HttpServlet {

    private String host;
    private String port;
    private String pass;
    private String userMail;

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
        String email = request.getParameter("email");
        UserDAO userDAO = new UserDAOImpl();
        User user = userDAO.getUserByEmail(email);
        if (user == null) {
            request.setAttribute("message", "Email không tồn tại!!!");
            request.getRequestDispatcher("./jsp/forgotPass.jsp").forward(request, response);
            return;
        }
        ServletContext context = getServletContext();
        userMail = context.getInitParameter("user");
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        pass = context.getInitParameter("pass");
        String resultMessage = "";
        Random rand = new Random();
        String code = String.format("%04d", rand.nextInt(10000));
        HttpSession session = request.getSession();
        session.setAttribute("code", code);
        try {
            EmailUtility.sendEmail(host, port, userMail, pass, email, "Quên mật khẩu!!!",
                    code);
            resultMessage = "The e-mail was sent successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "There were an error: " + ex.getMessage();
        } finally {
            request.setAttribute("Message", resultMessage);
            session.setAttribute("user", user);
            request.getRequestDispatcher("./jsp/setPassword.jsp").forward(request, response);
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
