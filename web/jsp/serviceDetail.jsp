<!--
 * Copyright(C) 20022, FPT University
 * CMS:
 * Clinic Management System
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-08      1.0                 TrangCT          Controller Service Detail
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="./assets/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.2/css/all.css" />
        <link href="./assets/themes/krajee-fas/theme.css" media="all" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="./assets/css/select2.min.css" />
        <link rel="stylesheet" href="./assets/css/select2-bootstrap-5-theme.min.css" />
        <link rel="stylesheet" href="./assets/css/custom.css" />
        <link href="./assets/css/header.css" rel="stylesheet" type="text/css"/>
    </head>
    <style>
        .price{
            font-size: 25px;
        }
        .rounded{
            background-color: lightgrey;
        }
       
    </style>
    <body>
        <jsp:include page="./components/customerHeader.jsp" />
        <div class="container-fuild">
            <div class="row-fluid mb-5">
                <img class="col-lg-12 p-0" src="./assets/images/banner.jpg" alt="Banner"/>
            </div>
            <div class="row my-5">
                <div class="col-md-8 mx-auto p-5 rounded">
                    <h2 class="text-white">Giới thiệu về ${service.serviceName}</h2>
                    <div class="row">
                        <div class="col-md-6 mt-5">
                            <img src="./assets/images/${service.serviceImage}" class="d-block w-100">
                        </div>
                        <div class="col-md-6 mt-5 p-5">
                            <h5 class="text-white">${service.serviceDescription}</h5>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row my-5 d-flex justify-content-center">
                <c:set var = "count" scope = "page" value = "0"/>
                <c:forEach var="i" items="${packages}">
                    <c:set var = "count" scope = "page" value = "${count+1}"/>

                    <div class="card ml-3 mr-3" style="width: 18rem;">
                        <img class="card-img-top"  src="./assets/images/gói ${count}.png" alt="Card image cap">
                        <div class="card-body">
                            <b class="card-title">${i.packageTitle}</b>
                            <span><b>Thời gian khám: </b><span class="font-italic">${i.examinationDuration}</span></span>
                            <br>
                            <span class="justify-content-center"><b>Giá: </b><span class="font-weight-bold text-primary price mb-3">${i.price} VND</h3></span>
                            <a href="./jsp/bookAReservation.jsp?serviceId=${service.serviceId}&packageId=${i.packageId}" class="button">
                                <button type="button" class="btn btn-primary w-75 mt-4">Đăng ký</button>
                            </a>

                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <%@include file="components/footer.jsp" %>
        <script src="./assets/js/jquery-3.6.0.min.js" crossorigin="anonymous"></script>
        <script src="./assets/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="./assets/js/star-rating.js" type="text/javascript"></script>
        <script src="./assets/themes/krajee-fas/theme.js" type="text/javascript"></script>
        <script src="./assets/js/select2.full.min.js"></script>
        <script src="./assets/js/custom.js"></script>
    </body>
</html>