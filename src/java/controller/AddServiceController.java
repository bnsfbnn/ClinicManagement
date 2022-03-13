/*
 * Copyright(C) 20022, FPT University
 * CMS:
 * Clinic Management System
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-26      1.0                 MinhVT          Controller Add Service
 */
package controller;

import dao.ServiceDAO;
import dao.UserDAO;
import dao.impl.ServiceDAOImpl;
import dao.impl.UserDAOImpl;
import entity.Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddServiceController extends HttpServlet {

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
        String[] ids = request.getParameter("list_doctors").split("-");
        List<Integer> idList = new ArrayList<>();
        
        if (ids != null) {
            for (String i : ids) {
                idList.add(Integer.parseInt(i));
            }
        }

        String serviceName = request.getParameter("service_name");
        String serviceBrief = request.getParameter("service_desc");
        Service service = new Service();
        service.setServiceName(serviceName);
        service.setServiceDescription(serviceBrief);
        ServiceDAO serviceDAO = new ServiceDAOImpl();
        serviceDAO.addService(service);

        UserDAO userDAO = new UserDAOImpl();
        int key = serviceDAO.getIdInserted();
        for (int k : idList) {
            userDAO.addDoctorForService(k, key);
        }

        ServiceManagementController controller = new ServiceManagementController();
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
