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

import dao.ReservationDAO;
import dao.impl.ReservationDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.Utils;

/**
 * -Use function updateReservationStatusById in
 * <code>dao.impl.ReservationDAOImpl</code> to update reservation status of
 * <code>entity.Reservation</code>.
 *
 * @author Nguyen Thanh Tung
 */
public class CancelReceiveReservationController extends HttpServlet {

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
            int reservationId = (request.getParameter("reservationId") != null) ? Integer.parseInt(request.getParameter("reservationId").trim()) : -1;
            int cancelReceiveReservation = (request.getParameter("cancelReceiveReservation") != null) ? Integer.parseInt(request.getParameter("cancelReceiveReservation").trim()) : 0;
            request.setAttribute("cancelReceiveReservation", cancelReceiveReservation);
            request.setAttribute("reservationId", reservationId);
            request.getRequestDispatcher("jsp/components/confirmDialog.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("errorMessage", "Kh??ng th??? t???i d??? li???u t??? c?? s??? d??? li???u");
            request.setAttribute("exceptionMessage", e.getMessage());
            request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
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
            int reservationId = (request.getParameter("reservationId") != null) ? Integer.parseInt(request.getParameter("reservationId").trim()) : -1;
            String reservationStatus = "Ch??? duy???t";
            ReservationDAO reservationDAO = new ReservationDAOImpl();
            reservationDAO.cancelReceiveReservationById(reservationId, reservationStatus, Utils.getToday());
            response.sendRedirect("viewMyReservation");
        } catch (Exception e) {
            request.setAttribute("errorMessage", "Kh??ng th??? t???i d??? li???u t??? c?? s??? d??? li???u");
            request.setAttribute("exceptionMessage", e.getMessage());
            request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
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
