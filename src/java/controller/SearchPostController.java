/*
 * Copyright(C) 20022, FPT University
 * CMS:
 * Clinic Management System
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-28     1.0                 TrangCT          Controller Search Post
 */
package controller;

import dao.PostDAO;
import dao.impl.PostDAOImpl;
import entity.PostEntity;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <h1>Search Post Controller </h1>
 * Controller to search post. Method process data form PostDAO and
 * forward data to file view
 * <p>
 *
 *
 * @author TrangCT
 * @version 1.0
 * @since 2022-02-28
 */
public class SearchPostController extends HttpServlet {

    /**
     * -Use function searchPost in
     * <code>dao.impl.PostDAOImpl</code> to get all service
     * <code>java.util.List</code> object that contains a series of
     * <code>entity.PostEntity</code><br>

     * -Set parameters: posts, search<br/>
     * -Finally forward user to the <code>home.jsp</code>
     * page. Processes requests for both HTTP <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response is
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String search = request.getParameter("search");
        PostDAO postDAO = new PostDAOImpl();
        List<PostEntity> posts = postDAO.searchPost(search.trim());
        request.setAttribute("posts", posts);
        request.setAttribute("search", search);
        request.getRequestDispatcher("./jsp/home.jsp").forward(request, response);
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
