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
        <link href="../assets/css/header.css" rel="stylesheet" type="text/css"/>
    </head>
    <header>
        <jsp:include page="./components/customerHeader.jsp" />
    </header>
    <body>
        <div class="container-fluid m-0 p-0">
            <div class="row-fluid mb-3">
                <img class="col-lg-12 p-0" src="./assets/images/banner-sm.png" alt="Banner"/>
            </div>
            <div class="row mb-3">
                <div class="col-md-12">
                    <div id="gallerydetail" class="carousel slide" data-bs-ride="carousel">
                        <div class="carousel-inner">
                            <c:forEach items="${service.serviceImage}" var="image" varStatus="loop">
                                <div class="carousel-item ${loop.first?'active':''}">
                                    <!--<img src="${service.serviceImage}" class="d-block w-100">-->
                                    <img src="https://o.rada.vn/data/image/2020/05/08/ta-bac-si-dang-kham-benh.jpg" class="d-block w-100">

                                </div>                                
                            </c:forEach>
                        </div>
                        <div class="carousel-indicators">
                            <c:forEach items="${service.serviceImage}" var="image" varStatus="loop">
                                <img src="${service.serviceImage}" ${loop.first?'class="active"':''} data-bs-target="#gallerydetail" data-bs-slide-to="${loop.index}">
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row mb-3">
                <div class="col-12">
                    <h5 class="m-0 mb-2">
                        ${service.serviceName}
                    </h5>
                        <p class="text-secondary small"><i class="fas fa-map-marker-alt"></i> ${service.serviceBrief}</p>
                   

                    <div class="d-flex">
                        <div>  <img src="https://o.rada.vn/data/image/2020/05/08/ta-bac-si-dang-kham-benh.jpg" class="d-block"></div>
                        <div class="ml-3"> <p class="mb-0">Mô tả:</p>
                            <p>                    
                                ${service.serviceDescription}<br/></p>
                        </div>

                    </div>


                </div>
            </div>
        </div>
        <script src="./assets/js/jquery-3.6.0.min.js" crossorigin="anonymous"></script>
        <script src="./assets/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="./assets/js/star-rating.js" type="text/javascript"></script>
        <script src="./assets/themes/krajee-fas/theme.js" type="text/javascript"></script>
        <script src="./assets/js/select2.full.min.js"></script>
        <script src="./assets/js/custom.js"></script>
    </body>

</html>
