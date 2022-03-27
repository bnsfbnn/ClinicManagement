/*
 * Copyright(C) 2022, FPT University
 * CMS
 * CLINIC MANAGEMENT SYSTEM
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-11      1.0                 namnv           First Implement 
 */
package controller;

import dao.PostDAO;
import dao.UserDAO;
import dao.impl.PostDAOImpl;
import dao.impl.UserDAOImpl;
import entity.PostEntity;
import entity.User;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * * -This class uses function getUser in <code>dao.impl.UserDAOImpl</code> to
 * get an <code>java.util.String</code> object that contains a series of
 * <code>entity.User</code>
 *
 * @author Nguyen Thanh Tung
 */
public class HomeController extends HttpServlet {

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
        User user1 = (User) session.getAttribute("user");
        if (user1 == null) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            UserDAO userDAO = new UserDAOImpl();
            User user = userDAO.login(username.trim(), password.trim());
            if (user != null) {
                session = request.getSession();
                session.setAttribute("user", user);
                PostDAO postDAO = new PostDAOImpl();
                List<PostEntity> posts = postDAO.getAllPost();
                request.setAttribute("posts", posts);
                if (user.getRoleId() == 1) {
                    request.getRequestDispatcher("GetAllAccountController").forward(request, response);
                } else if (user.getRoleId() == 2) {
                    response.sendRedirect("viewAllReservation");
                } else if (user.getRoleId() == 3) {
                    response.sendRedirect("viewMyReservation");
                } else {
                    request.getRequestDispatcher("./jsp/home.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("message", "Tên đăng nhập hoặc mật khẩu không đúng!!!");
                request.getRequestDispatcher("./jsp/login.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("./jsp/home.jsp").forward(request, response);
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