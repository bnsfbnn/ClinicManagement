/*
 * Copyright(C) 2022, FPT University
 * CMS
 * CLINIC MANAGEMENT SYSTEM
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-08      1.0                 MinhVT           First Implement 
 */
package controller;

import dao.ServiceDAO;
import dao.impl.ServiceDAOImpl;
import entity.Pagination;
import entity.Service;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <h1>Service Management Controller</h1>
 * Controller to view service management. Method process data form ServiceDAO and 
 * forward data to file view
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
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // get value of query string page
        String page = request.getParameter("page");    
        int pageIndex = 1;
        if (page != null) {// check page if not null
            try {
                //convert page(string) to pageIndex(int)
                pageIndex = Integer.parseInt(page);
                if (pageIndex == -1) {
                    pageIndex = 1;
                }
            } catch (Exception e) {
                //default pageIndex = 1
                pageIndex = 1;
            }
        }
        else {
            pageIndex = 1;
        }
                
        int pageSize = 5;// default page size
        ServiceDAO serviceDAO = new ServiceDAOImpl();
        //List service with pageIndex and pageSize
        Pagination<Service> services
                = serviceDAO.getAllService(pageIndex, pageSize);
        //set atrribute services with values serviece (Pagination<Services>)
        request.setAttribute("services", services);
        //forwatd request and response to serviceManagementList.jsp
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
