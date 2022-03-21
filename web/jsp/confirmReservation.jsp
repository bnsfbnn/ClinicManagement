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
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8;">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Clinic Management System</title>
        <link href="./assets/css/header.css" rel="stylesheet" type="text/css"/>
        <link href="./assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="./assets/css/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <link href="./assets/css/jquery-ui.structure.min.css" rel="stylesheet" type="text/css"/>
        <link href="./assets/css/jquery-ui.theme.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <!--Import header-->
        <%@include file="components/managerHeader.jsp" %>
        <div class="container-fluid p-0">
            <div class="row justify-content-center mt-3 mr-0">
                <h4>Duyệt lịch đặt chỗ</h4>
            </div>
        </div>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-6 text-center mb-5">
                    <h2 class="heading-section">Table #09</h2>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="table-wrap">
                        <table class="table align-middle mb-0 bg-white">
                            <thead class="bg-light">
                                <tr>
                                    <th>Name</th>
                                    <th>Title</th>
                                    <th>Status</th>
                                    <th>Position</th>
                                    <th>Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>
                                        <div class="d-flex align-items-center">
                                            <div class="ms-3">
                                                <p class="fw-bold mb-1">John Doe</p>
                                                <p class="text-muted mb-0">john.doe@gmail.com</p>
                                            </div>
                                        </div>
                                    </td>
                                    <td>
                                        <p class="fw-normal mb-1">Software engineer</p>
                                        <p class="text-muted mb-0">IT department</p>
                                    </td>
                                    <td>
                                        <span class="badge badge-success rounded-pill">Active</span>
                                    </td>
                                    <td>Senior</td>
                                    <td>
                                        <button type="button" class="btn btn-link btn-sm btn-rounded">
                                            Edit
                                        </button>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <!--Import js lib-->
        <script src="./assets/js/jquery-3.6.0.min.js" type="text/javascript"></script>
        <script src="./assets/js/popper.js" type="text/javascript"></script>
        <script src="./assets/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="./assets/js/jquery-ui.min.js" type="text/javascript"></script>
    </body>
</html>
