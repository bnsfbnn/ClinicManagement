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

import dao.ExaminationDAO;
import dao.ReservationDAO;
import dao.UserDAO;
import dao.impl.ReservationDAOImpl;
import dao.impl.UserDAOImpl;
import entity.Reservation;
import entity.User;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.Utils;

/**
 *
 * @author Nguyen Thanh Tung
 */
public class ChangeReservationDateController extends HttpServlet {

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
            ReservationDAO reservationDAO = new ReservationDAOImpl();
            UserDAO userDAO = new UserDAOImpl();
            Reservation reservation = reservationDAO.getReservationById(reservationId);
            User doctor = userDAO.getUserById(reservation.getConfirmedDoctor().getUserId());
            request.setAttribute("today", Utils.revertParseDateFormat(Utils.getToday()));
            request.setAttribute("doctor", doctor);
            request.setAttribute("reservation", reservation);
            request.getRequestDispatcher("jsp/components/changeReservationDate.jsp").forward(request, response);
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
            if (Boolean.parseBoolean(request.getParameter("getEmptyReservationOfDoctor")) == true) {
                int doctorId = (request.getParameter("doctorId") != null) ? Integer.parseInt(request.getParameter("doctorId").trim()) : -1;
                String date = (request.getParameter("date") != null) ? Utils.parseDateFormat(request.getParameter("date").trim()) : "";
                ReservationDAO reservationDAO = new ReservationDAOImpl();
                ArrayList<String> timeSchedule = reservationDAO.getTimeScheduleByDoctorId(doctorId, date);
                request.setAttribute("timeSchedule", timeSchedule);
                request.getRequestDispatcher("jsp/components/getEmptyReservationOfDoctor.jsp").forward(request, response);
            } else if (Boolean.parseBoolean(request.getParameter("getConfirmDialog")) == true) {
                int reservationId = (request.getParameter("reservationId") != null) ? Integer.parseInt(request.getParameter("reservationId").trim()) : -1;
                String confirmedExaminationDate = (request.getParameter("confirmedExaminationDate") != null) ? Utils.parseDateFormat(request.getParameter("confirmedExaminationDate").trim()) : "";
                String confirmedExaminationTime = (request.getParameter("confirmedExaminationTime") != null) ? request.getParameter("confirmedExaminationTime") : "";
                int getConfirmDialog = (Boolean.parseBoolean(request.getParameter("getConfirmDialog")) == true) ? 1 : 0;
                request.setAttribute("getConfirmDialog", getConfirmDialog);
                request.setAttribute("reservationId", reservationId);
                request.setAttribute("confirmedExaminationDate", confirmedExaminationDate);
                request.setAttribute("confirmedExaminationTime", confirmedExaminationTime);
                request.getRequestDispatcher("jsp/components/confirmDialog.jsp").forward(request, response);
            } else if (Boolean.parseBoolean(request.getParameter("changeReservationDate")) == true) {
                int reservationId = (request.getParameter("reservationId") != null) ? Integer.parseInt(request.getParameter("reservationId").trim()) : -1;
                String confirmedExaminationDate = (request.getParameter("confirmedExaminationDate") != null) ? request.getParameter("confirmedExaminationDate").trim() : "";
                String confirmedExaminationTime = (request.getParameter("confirmedExaminationTime") != null) ? request.getParameter("confirmedExaminationTime") : "";
                ReservationDAO reservationDAO = new ReservationDAOImpl();
                reservationDAO.updateReservationDateTimeById(reservationId, confirmedExaminationDate, confirmedExaminationTime);
                response.sendRedirect("viewMyReservation");
            }
        } catch (Exception e) {
            request.setAttribute("errorMessage", "Kh??ng th??? t???i d??? li???u t??? c?? s??? d??? li???u");
            request.setAttribute("exceptionMessage", e.getMessage());
            request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
        }
    }
}
