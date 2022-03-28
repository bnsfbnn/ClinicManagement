/*
 * Copyright(C) 2022, FPT University
 * CMS
 * CLINIC MANAGEMENT SYSTEM
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-03-15      1.0                 namnv           First Implement 
 */
package controller;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import entity.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * * -This class uses function updatePassword in
 * <code>dao.impl.</code> to get an
 * <code>java.util.ArrayList</code> object that contains a series of
 * <code>entity.User</code>
 *
 * @author Nguyen Van Nam
 */
public class ChangePasswordController extends HttpServlet {
/**
     * -Use function updatePassword in <code>dao.impl.UserIml</code> to
     * get an <code>java.util.ArrayList</code> object that contains a series of
     * <code>entity.User</code><br>
     
     * 
     * -Set parameters: oldPassword, newPassword, reNewPassword<br>
     * -Finally forward user to the <code>changePass.jsp</code> page. Processes
     * requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response is
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            request.getRequestDispatcher("./jsp/home.jsp").forward(request, response);
            return;
        }

        String oldPassword = request.getParameter("oldPassword").trim();
        String newPassword = request.getParameter("newPassword").trim();
        String reNewPassword = request.getParameter("reNewPassword").trim();
        session.setAttribute("oldPassword", oldPassword);
        session.setAttribute("newPassword", newPassword);
        session.setAttribute("reNewPassword", reNewPassword);

        if (!oldPassword.equals(user.getPassword())) {
            session.setAttribute("messageChangePass", "Mật khẩu hiện tại không chính xác!!!");
            response.sendRedirect("./jsp/changePass.jsp");
            return;
        }

        if (!newPassword.equals(reNewPassword)) {
            session.setAttribute("messageChangePass", "Mật khẩu không trùng khớp!!!");
            response.sendRedirect("./jsp/changePass.jsp");
            return;
        }

        UserDAO userDAO = new UserDAOImpl();
        userDAO.updatePassword(user.getUsername(), newPassword);
        session.removeAttribute("user");
        session.setAttribute("messageChangePass", "Thay đổi mật khẩu thành công!!!");
        response.sendRedirect("./jsp/changePass.jsp");

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
