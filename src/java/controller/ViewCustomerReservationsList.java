/*
 * Copyright(C) 20022, FPT University
 * CMS:
 * Clinic Management System
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-22     1.0                 TrangCT          Controller View Customer Reservation List
 */
package controller;

import dao.ReservationDAO;
import dao.impl.ReservationDAOImpl;
import entity.CustomerReservation;
import entity.ReservationDTO;
import entity.Pagination;
import entity.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <h1>View Customer Reservation Detail </h1>
 * Controller to view customer reservation list. Method process data form
 * FeedbackDAO and forward data to file view
 * <p>
 *
 *
 * @author TrangCT
 * @version 1.0
 * @since 2022-02-22
 */
public class ViewCustomerReservationsList extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            request.getRequestDispatcher("./jsp/login.jsp").forward(request, response);
        } else {
            String page = (request.getParameter("page") == null)?"1":request.getParameter("page");
            int pageIndex = 1;
            if (page != null) {// check page if not null
                try {
                    //convert page(string) to pageIndex(int)
                    pageIndex = Integer.parseInt(page);
                    if (pageIndex == -1) {
                        pageIndex = 0;
                    }
                } catch (NumberFormatException e) {
                    //default pageIndex = 1
                    pageIndex = 0;
                }
                int pageSize = 5; // default page size
                ReservationDAO reservationDAO = new ReservationDAOImpl();
                Pagination<CustomerReservation> reservations = reservationDAO.getAllCustomerReservation(pageIndex, pageSize, user.getUserId());
                request.setAttribute("reservations", reservations);
                request.getRequestDispatcher("./jsp/viewAllCustomerReservation.jsp").forward(request, response);
            }
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
