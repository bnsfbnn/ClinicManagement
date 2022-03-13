/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ReservationDAO;
import dao.impl.ReservationDAOImpl;
import entity.ReservationDTO;
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
 *
 * @author dell
 */
public class BookReservationController extends HttpServlet {

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
        int serviceId = Integer.parseInt(request.getParameter("serviceId").trim());
        int packageId = Integer.parseInt(request.getParameter("packageId").trim());
        response.setContentType("text/html;charset=UTF-8");
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String date1 = request.getParameter("date");
        format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
        java.util.Date jdate1 = format.parse(date1);
        java.sql.Date sdate1 = new java.sql.Date(jdate1.getTime());

        String reqeust = request.getParameter("request");

        ReservationDTO reservation = new ReservationDTO();
        reservation.setCustomerRequest(reqeust);
        reservation.setRequestDate(sdate1);
        reservation.setId(user.getUserId());
        reservation.setPackageId(packageId);
        reservation.setServiceId(serviceId);

        ReservationDAO reservationDAO = new ReservationDAOImpl();
        reservationDAO.bookReservation(reservation);
        ViewCustomerReservationsList controller = new ViewCustomerReservationsList();
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
            Logger.getLogger(BookReservationController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(BookReservationController.class.getName()).log(Level.SEVERE, null, ex);
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
