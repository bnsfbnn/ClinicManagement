/*
 * Copyright(C) 20022, FPT University
 * CMS:
 * Clinic Management System
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-08      1.0                 MinhVT          Controller Service Management List
 */
package controller;

import dao.ServiceDAO;
import dao.UserDAO;
import dao.impl.ServiceDAOImpl;
import dao.impl.UserDAOImpl;
import entity.Doctor;
import entity.ServiceDTO;
import entity.Pagination;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <h1>Service List Controller</h1>
 * Controller to view service management list. Method process data form
 * ServiceDAO and forward data to file view
 * <p>
 *
 *
 * @author MinhVT
 * @version 1.0
 * @since 2022-02-08
 */
public class ServiceManagementController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods. Get list services and pagging
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws NumberFormatException if page is not integer
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String page = request.getParameter("page");
        if (page != null) {
            request.getSession().setAttribute("page", page);
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

        int pageSize = 5;
        ServiceDAO serviceDAO = new ServiceDAOImpl();
        if (request.getSession().getAttribute("page") != null) {
            pageIndex = Integer.parseInt(request.getSession().getAttribute("page").toString());
        }
        Pagination<ServiceDTO> services
                = serviceDAO.getAllService(pageIndex, pageSize);
        UserDAO userDAO = new UserDAOImpl();

        List<Doctor> doctors = userDAO.getAllDoctor();

        for (ServiceDTO s : services.getData()) {
            for (Doctor d : doctors) {
                if (d.getServiceId() == s.getServiceId()) {
                    s.getDoctors().add(d);
                }
            }
        }

        request.setAttribute("doctors", doctors);
        request.setAttribute("services", services);

        request.getRequestDispatcher("./jsp/serviceManagementList.jsp").forward(request, response);
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