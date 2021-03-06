<!--
 * Copyright(C) 20022, FPT University
 * CMS:
 * Clinic Management System
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-08      1.0                 TrangCT          List service
-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clinic Management</title>
        <link href="./assets/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.2/css/all.css" />
        <link href="./assets/themes/krajee-fas/theme.css" media="all" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="./assets/css/select2.min.css" />
        <link rel="stylesheet" href="./assets/css/select2-bootstrap-5-theme.min.css" />
        <link rel="stylesheet" href="./assets/css/custom.css" />
        <link href="./assets/css/header.css" rel="stylesheet" type="text/css"/>
    </head>
    <style>
        .card{
            border:none;
            margin-top: 10px
        }   
        .col-4{
            text-align: center
        }
    </style>
    <body>
        <%@include file="components/customerHeader.jsp" %>
        <div class="container-fluid m-0 p-0">
            <div class="row-fluid mb-3">
                <img class="col-lg-12 p-0" src="./assets/images/banner.jpg" alt="Banner"/>
            </div>
            <div class="row mt-3">
                <c:forEach items="${services.data}" var="service">
                    <div class="col-4 m-0 px-auto">
                        <div >
                            <img src="./assets/images/${service.serviceImage}" class="card-img-top w-50" alt="...">

                            <div class="card-body">
                                <h5 class="card-title m-0">${service.serviceName}</h5>
                                <p class="card-text text-secondary">M?? t???: ${service.serviceDescription}</p>
                            </div>
                        </div>
                        <a href="ServiceDetailController?Id=${service.serviceId}" class="btn btn-success mb-4">Xem th??m</a>
                    </div>
                </c:forEach>
                <c:if test="${services.totalItem == 0}">
                    <div class="col-12">
                        <p class="text-center">Kh??ng c?? d??? li???u</p>
                    </div>
                </c:if>
            </div>
            <c:if test="${services.totalPage > 1}">
                <div class="row">
                    <div class="col-12 text-center">
                        <ul>
                            <c:if test="${services.currentPage > 1}">
                                <a class="btn btn-light" href="${requestScope['javax.servlet.forward.request_uri']}?page=${services.currentPage-1}">Trang tr?????c</a>
                            </c:if>
                            <c:forEach var="pageNumber" begin="1" end="${services.totalPage}" step="1">
                                <c:if test="${services.currentPage == pageNumber}">
                                    <a class="btn btn-success" href="#">${pageNumber}</a>
                                </c:if>
                                <c:if test="${services.currentPage != pageNumber}">
                                    <a class="btn btn-light" href="${requestScope['javax.servlet.forward.request_uri']}?page=${pageNumber}">${pageNumber}</a>
                                </c:if>
                            </c:forEach>
                            <c:if test="${services.currentPage < services.totalPage}">
                                <a class="btn btn-light" href="${requestScope['javax.servlet.forward.request_uri']}?page=${services.currentPage+1}">Trang sau</a>
                            </c:if>
                        </ul>
                    </div>
                </div>
            </c:if>
        </div>
        <jsp:include page="./components/footer.jsp" />
        <script src="./assets/js/jquery-3.6.0.min.js" crossorigin="anonymous"></script>
        <script src="./assets/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="./assets/js/star-rating.js" type="text/javascript"></script>
        <script src="./assets/themes/krajee-fas/theme.js" type="text/javascript"></script>
        <script src="./assets/js/select2.full.min.js"></script>
        <script src="./assets/js/custom.js"></script>
    </body>
</html>