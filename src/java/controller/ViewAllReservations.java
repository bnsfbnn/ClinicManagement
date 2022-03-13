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

import dao.impl.ReservationDAOImpl;
import dao.impl.ServiceDAOImpl;
import entity.Reservation;
import entity.Service;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.Utils;

/**
 * * -This class uses function getReservations in
 * <code>dao.impl.reservationDAOImpl</code> to get an
 * <code>java.util.ArrayList</code> object that contains a series of
 * <code>entity.Reservation</code>
 *
 * @author Nguyen Thanh Tung
 */
public class ViewAllReservations extends HttpServlet {

    /**
     * -Use function getReservations in <code>dao.impl.ReservationDAOImpl</code> to
     * get an <code>java.util.ArrayList</code> object that contains a series of
     * <code>entity.Reservation</code><br>
     * -Use function getDoctorsHasReservation in <code>dao.impl.ReservationDAOImpl</code> to
     * get an <code>java.util.ArrayList</code> object that contains a series of
     * <code>entity.User</code><br> represent for a doctor
     * -Use function getServices in <code>dao.impl.ServiceDAOImpl</code> to
     * get an <code>java.util.ArrayList</code> object that contains a series of
     * <code>entity.Service</code><br> 
     * 
     * -Set parameters: viewDay, doctors, services, reservations<br>
     * -Finally forward user to the <code>viewAllReservation.jsp</code> page. Processes
     * requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response is
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String viewDay = Utils.getToday();
            ReservationDAOImpl reservationDAO = new ReservationDAOImpl();
            ServiceDAOImpl serviceDAO = new ServiceDAOImpl();
            ArrayList<Reservation> reservations = reservationDAO.getReservationsByDay(viewDay);
            ArrayList<User> doctors = reservationDAO.getDoctorsHasReservation();
            ArrayList<Service> services = serviceDAO.getServices();
            request.setAttribute("viewDay", viewDay);
            request.setAttribute("doctors", doctors);
            request.setAttribute("services", services);
            request.setAttribute("reservations", reservations);
            request.getRequestDispatcher("./jsp/viewAllReservation.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
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
