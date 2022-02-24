<%-- 
 * Copyright(C) 2022, FPT University
 * CMS
 * CLINIC MANAGEMENT SYSTEM
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-08      1.0                 tungnt           First Implement 
--%>

<%@page import="entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body class="m-0 p-0">
        <!--Start header-->
        <header class="navbar navbar-expand-lg navbar-light navbar-floating navbar-sticky">
            <div class="p-2">
                <a href="#">
                    <img src="./assets/images/logo.png" alt="" width="30" height="30">
                </a>
            </div>
            <div>
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link py-3" href="#">Dịch vụ<span class="sr-only">(current)</span></a>
                    </li>
                    <li class=nav-item">
                        <a class="nav-link py-3" href="#">Phản hồi</a>
                    </li>
                </ul>
            </div>
            <div class="dropdown ml-auto">
                <a class="avatar avatar-md p-0 show" href="" href="#" id="profileDropdown" role="button" data-bs-auto-close="outside" data-bs-display="static" data-bs-toggle="dropdown" aria-expanded="true">
                    <%
                        User user = (User) request.getSession().getAttribute("user");
                        if (user != null) {
                            String username = user.getUsername();
                            String ava = user.getAvatarImage();
                            String email = user.getAvatarImage();
                        }
                    %>
                    <img height="45" class="avatar-img rounded-circle" src="./assets/images/avatar01.jpg" alt="avatar">
                </a>
                    <ul class="dropdown-menu dropdown-animation shadow pt-3 show dropdown-menu-right" aria-labelledby="profileDropdown" data-bs-popper="none" style="">
                    <!-- Profile info -->
                    <li class="px-3">
                        <div class="d-flex align-items-center">
                            <!-- Avatar -->
                            <div class="avatar me-3">
                                <img height="40" class="avatar-img rounded-circle shadow" src="./assets/images/avatar01.jpg" alt="avatar">
                            </div>
                            <div>
                                <a class="h6" href="#">Lori Ferguson</a>
                                <p class="small m-0">example@gmail.com</p>
                            </div>
                        </div>
                        <hr>
                    </li>
                    <!-- Links -->
                    <li><a class="dropdown-item" href="#"><i class="bi bi-person fa-fw me-2"></i>Edit Profile</a></li>
                    <li><a class="dropdown-item" href="#"><i class="bi bi-gear fa-fw me-2"></i>Account Settings</a></li>
                    <li><a class="dropdown-item" href="#"><i class="bi bi-info-circle fa-fw me-2"></i>Help</a></li>
                    <li><a class="dropdown-item bg-danger-soft-hover" href="#"><i class="bi bi-power fa-fw me-2"></i>Sign Out</a></li>
                    <li> <hr class="dropdown-divider"></li>
                    <!-- Dark mode switch END -->
                </ul>
            </div>
            <!--End header-->
        </header>
    </body>
</html>