/*
 * Copyright(C) 2022, FPT University
 * CMS
 * CLINIC MANAGEMENT SYSTEM
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-08      1.0                 tungnt           First Implement 
 */
package controller;

import static config.Configuration.PAGE_SIZE;
import dao.ExaminationDAO;
import dao.impl.ExaminationDAOImpl;
import entity.Examination;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * -This class uses function getExamninationByUserId in
 * <code>dao.impl.ExaminationDAOImpl</code> to get list of
 * <code>entity.Examination</code>. It's a <code>java.util.ArrayList</code>
 * object
 *
 * @author Nguyen Thanh Tung
 */
public class ViewExaminationHistoryController extends HttpServlet {

    /**
     * -Use function getExamninationByUserId in
     * <code>dao.impl.ExaminationDAOImpl</code> to get list of
     * <code>entity.Examination</code>. It's a <code>java.util.ArrayList</code>
     * object
     *
     * -Set parameters: examination<br>
     * -Finally forward user to the <code>viewReservationDetailPopup.jsp</code>
     * page. Processes requests for both HTTP <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response is
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int customerId = (request.getParameter("customerId") != null) ? Integer.parseInt(request.getParameter("customerId").trim()) : -1;
            int currentPage = request.getParameter("currentPage") != null ? Integer.parseInt(request.getParameter("currentPage").trim()) : 1;
            ExaminationDAO examinationDAO = new ExaminationDAOImpl();
            int numberOfExamination = examinationDAO.countExamninationByUserId(customerId);
            int numberOfPage = (numberOfExamination % PAGE_SIZE == 0) ? numberOfExamination / PAGE_SIZE : numberOfExamination / PAGE_SIZE + 1;
            ArrayList<Examination> examination = examinationDAO.getExamninationByUserId(customerId, PAGE_SIZE, currentPage);
            request.setAttribute("customerId", customerId);
            request.setAttribute("currentPage", currentPage);
            request.setAttribute("numberOfPage", numberOfPage);
            request.setAttribute("examination", examination);
            request.getRequestDispatcher("jsp/components/viewExaminationHistoryPopup.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("errorMessage", "Kh??ng th??? t???i d??? li???u t??? c?? s??? d??? li???u");
            request.setAttribute("exceptionMessage", e.getMessage());
            request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
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
