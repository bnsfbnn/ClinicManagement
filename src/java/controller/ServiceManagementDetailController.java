/*
 * Copyright(C) 20022, FPT University
 * CMS:
 * Clinic Management System
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-08      1.0                 MinhVT          Controller Service Management Detail
 */
package controller;

import dao.ServiceDAO;
import dao.UserDAO;
import dao.impl.ServiceDAOImpl;
import dao.impl.UserDAOImpl;
import entity.Account;
import entity.Doctor;
import entity.Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <h1>Service List Controller</h1>
 * Controller to view service management detail. Method process data form ServiceDAO and 
 * forward data to file view
 * <p>
 * 
 * 
 * @author MinhVT
 * @version 1.0
 * @since 2022-02-08
 */
public class ServiceManagementDetailController extends HttpServlet {

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
        int id = Integer.parseInt(request.getParameter("Id"));
        ServiceDAO serviceDAO = new ServiceDAOImpl();
        Service service = serviceDAO.getById(id);

        UserDAO userDAO = new UserDAOImpl();
        List<Doctor> doctors = userDAO.getDoctorByServiceId(service.getServiceId());
        request.setAttribute("service", service);
        request.setAttribute("doctors", doctors);
        List<Doctor> allDoctors = userDAO.getAllDoctor();
        request.setAttribute("allDoctors", allDoctors);
        request.getRequestDispatcher("./jsp/editService.jsp").forward(request, response);
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
