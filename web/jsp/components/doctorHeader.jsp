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
                        <a class="nav-link py-3" href="#">Lịch hẹn của tôi<span class="sr-only">(current)</span></a>
                    </li>
                </ul>
            </div>
            <div class="ml-auto">
                <div class="avatar avatar-md p-0">
                    <img height="45" class="avatar-img rounded-circle" src="./assets/images/avatar03.jpg" alt="avatar">
                </div>
            </div>
            <!--End header-->
        </header>
    </body>
</html>