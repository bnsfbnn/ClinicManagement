/*
 * Copyright(C) 20022, FPT University
 * CMS:
 * Clinic Management System
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-08      1.0                 TrangCT          Controller Service List
 */

package controller;

import dao.ServiceDAO;
import dao.impl.ServiceDAOImpl;
import entity.Pagination;
import entity.Service;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <h1>Service List Controller</h1>
 * Controller to view service detail. Method process data form ServiceDAO and 
 * forward data to file view
 * <p>
 * 
 * 
 * @author TrangCT
 * @version 1.0
 * @since 2022-02-08
 */
public class ServiceController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     * Get list services and pagging
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws NumberFormatException if page is not integer
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // get value of query string page
        String page = request.getParameter("page");
        int pageIndex = 0;
        int pageSize = 6; // default page size
        if (page != null) {// check page if not null
            try {
                //convert page(string) to pageIndex(int)
                pageIndex = Integer.parseInt(page);
                if(pageIndex == 1){
                    pageIndex = 0;
                }
               else if (pageIndex == -1) {
                    pageIndex = 0;
                }
                else {
                    pageIndex = (pageIndex-1) * pageSize ;
                }
            } catch (NumberFormatException e) { 
                //default pageIndex = 1
                pageIndex = 0;
            }
        }
        ServiceDAO serviceDAO = new ServiceDAOImpl();
        //List service with pageIndex and pageSize
        Pagination<Service> services
                = serviceDAO.getAllService(pageIndex, pageSize);
        //set atrribute services with values serviece (Pagination<Services>)
        request.setAttribute("services", services);
        //forwatd request and response to serviceList.jsp
        request.getRequestDispatcher("./jsp/serviceList.jsp").forward(request, response);
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
