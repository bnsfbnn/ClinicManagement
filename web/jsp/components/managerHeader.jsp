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
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <body>
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
                        <a class="nav-link py-3" href="./viewAllReservation">Xem tất danh sách đặt chỗ<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link py-3" href="#">Xác nhận lịch đặt chỗ</a>
                    </li>
                    <li class=nav-item">
                        <a class="nav-link py-3" href="#">Quản lý dịch vụ</a>
                    </li>
                    <li class=nav-item">
                        <a class="nav-link py-3" href="#">Quản lý Phản hồi</a>
                    </li>
                    <li class=nav-item">
                        <a class="nav-link py-3" href="#">Duyệt lịch đặt chỗ</a>
                    </li>
                </ul>
            </div>
            <!--End header-->
            <div class="dropdown ml-auto">
                <a class="avatar avatar-md p-0" href="#" id="profileDropdown" role="button" data-bs-auto-close="outside" data-bs-display="static" data-bs-toggle="dropdown" aria-expanded="true">
                    <%
                        User user = (User) request.getSession().getAttribute("user");
                    %>
                    <img height="45" class="avatar-img rounded-circle" src="./assets/images/${user.avatarImage}" alt="avatar">
                </a>
                <ul class="dropdown-menu dropdown-animation shadow pt-3 dropdown-menu-right" aria-labelledby="profileDropdown" data-bs-popper="none" style="">
                    <!-- Profile info -->
                    <li class="px-3">
                        <div class="d-flex align-items-center">
                            <!-- Avatar -->
                            <div class="avatar me-3">
                                <img height="40" class="avatar-img rounded-circle shadow" href="" src="./assets/images/${user.avatarImage}" alt="avatar">
                            </div>
                            <div>
                                <a class="h6">${user.fullName}</a>
                                <p class="small m-0">${user.email}</p>
                            </div>
                        </div>
                        <hr>
                    </li>
                    <!-- Links -->
                    <li><a class="dropdown-item bg-danger-soft-hover" href="./LogoutController"><i class="bi bi-power fa-fw me-2"></i>Đăng xuất</a></li>
                    <li> <hr class="dropdown-divider"></li>
                    <!-- Dark mode switch END -->
                </ul>
            </div>
        </header>
    </body>
</html>