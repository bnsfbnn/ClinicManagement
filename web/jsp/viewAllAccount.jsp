<!--
 * Copyright(C) 2022, FPT University
 * CMS
 * CLINIC MANAGEMENT SYSTEM
 *
 * Record of change:
 * DATE            Version          AUTHOR           DESCRIPTION
 * 2022-02-08      1.0              HuongHTT         First Implement 
/-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="./assets/css/style.css">
        <link href="../assets/css/header.css" rel="stylesheet" type="text/css"/>
        <title>Account Management</title>
    </head>
    <style>
        input{
            height: 45px;
            border:none;
            text-align: center;
        }
        table tr th{
            text-align: center
        }
    </style>
    <body>
        <!--Import header-->
        <%@include file="components/adminHeader.jsp" %>
        <h1 style="text-align: center">Account Management</h1>
        <table style="margin-left: auto; margin-right: auto; border: 1px solid">
            <tr>
                <th>ID</th>
                <th>Tài Khoản</th>
                <th>Email</th>
                <th>Họ tên</th>
                <th >Ngày Sinh</th>
                <th>Giới tính</th>
                <th>Phone</th>
                <th>Địa chỉ</th>
                <th>Chức vụ</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td style="text-align: center; border: 1px solid" >
                        <input value="${user.userId}" id="userId">
                    </td>
                    <td style="text-align: center; border: 1px solid">
                        <input value="${user.username}">
                    </td>
                    <td style="text-align: center; border: 1px solid">
                        <input value="${user.email}">
                    </td>
                    <td style="text-align: center; border: 1px solid">
                        <input value="${user.birthDate}">
                    </td>
                    <td style="text-align: center; border: 1px solid">
                        <input value="${user.gender}">
                    </td>
                    <td style="text-align: center; border: 1px solid">
                        <input value="${user.username}">
                    </td>
                    <td style="text-align: center; border: 1px solid">
                        <input value="${user.phone}">
                    </td>
                    <td style="text-align: center; border: 1px solid">
                        <input value="${user.address}">
                    </td>
                    <td style="text-align: center; border: 1px solid">
                        <input value="${user.role}">
                    </td>
                    <td style="text-align: center; border: 1px solid" class="btn-success">
                        <a href="">
                            <button type="button" class="btn btn-primary">Update</button>
                        </a>
                    </td>
                    <td style="text-align: center; border: 1px solid">
                        <button type="button" class="btn btn-danger" onclick="myFunction('${user.userId}')">Delete</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <script>
            function myFunction(id) {
                let text = "Do you wanna delete user with ID : " + id;
                if (confirm(text) == true) {
                    document.location.href = "DeleteAccountController?id=" + id;
                }
            }
        </script>

    </body>
</html>
