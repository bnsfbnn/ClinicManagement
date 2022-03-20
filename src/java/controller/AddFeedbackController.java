/*
 * Copyright(C) 20022, FPT University
 * CMS:
 * Clinic Management System
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-03-08     1.0                 TrangCT          Controller Add Feedback 
 */
package controller;

import dao.FeedbackDAO;
import dao.impl.FeedbackDAOImpl;
import entity.Feedback;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
 * <h1>Add Feedback Controller </h1>
 * Controller to add feedback. Method process data form FeedbackDAO and forward
 * data to file view
 * <p>
 *
 *
 * @author TrangCT
 * @version 1.0
 * @since 2022-03-08
 */
public class AddFeedbackController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            request.getRequestDispatcher("./jsp/login.jsp").forward(request, response);
            return;
        }
        int serviceId = Integer.parseInt(request.getParameter("serviceId"));
        int examinationId = Integer.parseInt(request.getParameter("examinationId"));
        String content = request.getParameter("content");
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        Feedback feedback = new Feedback();
        feedback.setCustomerId(user.getUserId());
        feedback.setExaminationId(examinationId);
        feedback.setFeedbackContent(content);
        feedback.setServiceId(serviceId);
        feedback.setFeedbackTime(date);

        FeedbackDAO feedbackDAO = new FeedbackDAOImpl();
        feedbackDAO.addFeedback(feedback);
        ViewFeedBackListController controller = new ViewFeedBackListController();
        controller.processRequest(request, response);

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
            Logger.getLogger(AddFeedbackController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AddFeedbackController.class.getName()).log(Level.SEVERE, null, ex);
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