/*
 * Copyright(C) 2022, FPT University
 * CMS
 * CLINIC MANAGEMENT SYSTEM
 *
 * Record of change:
 * DATE            Version          AUTHOR           DESCRIPTION
 * 2022-02-08      1.0              HuongHTT         First Implement 
 */
package controller;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import entity.Account;
import entity.Pagination;
import entity.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This class uses <code>dao.impl.UserDAOImpl</code> functions:<br>
 * getAllAccount to get all account from database.
 *
 * Bugs: none
 *
 * @author Hoang Thi Thu Huong
 */
public class GetAllAccountController extends HttpServlet {

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
    /**
     * Use function getAllAccount in <code>dao.impl.UserDAOImpl</code> to get a
     * <code>java.util.List</code> object that contains a series of
     * <code>entity.Account</code><br>
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            String page = request.getParameter("page");
            String search = request.getParameter("search");
            if (search == null) {
                search = "";
            }
            int pageIndex = 1;
            if (page != null) {
                try {
                    pageIndex = Integer.parseInt(page);
                    if (pageIndex == -1) {
                        pageIndex = 1;
                    }
                } catch (Exception e) {
                    pageIndex = 1;
                }
            } else {
                pageIndex = 1;
            }
            int pageSize = 10;
            UserDAO userDAO = new UserDAOImpl();
            Pagination<Account> users = userDAO.getAllAccount(pageIndex, pageSize, search);
            request.setAttribute("users", users);
            request.setAttribute("search", search);
            request.getRequestDispatcher("./jsp/viewAllAccount.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("HomeController").forward(request, response);
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
