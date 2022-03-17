<!--
 * Copyright(C) 20022, FPT University
 * CMS:
 * Clinic Management System
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-22      1.0                 TrangCT          View All Customer Reservation 
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="./assets/css/style.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="./assets/styles/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <link href="./assets/styles/jquery-ui.structure.min.css" rel="stylesheet" type="text/css"/>
        <link href="./assets/styles/jquery-ui.theme.min.css" rel="stylesheet" type="text/css"/>
        <link href="./assets/css/header.css" rel="stylesheet" type="text/css"/>
        <title>Account Management</title>
    </head>
    <style>
        .list{
            background-color:#F0F0F0;

            padding: 20px;
            border-radius: 10px;
            width: 75%;
            margin: 0 auto;
            margin-top: 30px;

        }
        .infor{
            margin-left: 30px;
        }
        .feedback{
            padding:10px;
            background-color: red;
            border-radius: 10px;
            color: white;
            text-align: center;
            font-weight: bold;
        }
        .status{
            padding:10px;
            background-color: red;
            border-radius: 10px;
            color: white;
            text-align: center;
            font-weight: bold;
        }
        .modal {
            display: none; /* Hidden by default */
            position: fixed; /* Stay in place */
            z-index: 1; /* Sit on top */
            left: 0;
            top: 0;
            width: 100%; /* Full width */
            height: 100%; /* Full height */
            overflow: auto; /* Enable scroll if needed */
            background-color: rgb(0,0,0); /* Fallback color */
            background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
        }

        /* Modal Content/Box */
        .modal-content {
            background-color: #fefefe;
            margin: 15% auto; /* 15% from the top and centered */
            padding: 20px;
            border: 1px solid #888;
            width: 80%; /* Could be more or less, depending on screen size */
        }

        /* The Close Button */
        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }

        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }
        .item_header {
            display: flex;
            width: 100%;
            justify-content: space-between;
        }

        .item__content {
            border: 1px solid #e6e6e6;
            margin-top: 10px;
            border-radius: 5px;
            padding: 10px;
        }
    </style>
    <header>
        <jsp:include page="./components/customerHeader.jsp" />
    </header>
    <body>
        <div class="container-fluid m-0 p-0">
            <h3 style="margin-left:20px">Reservation List</h3>
            <div class="container-fluid">
                <c:forEach var="reservation" items="${reservations.data}">
                    <div class="row list">
                        <div class="d-flex col-8" style="margin-left:150px">
                            <div>
                                <img src="https://thumbs.dreamstime.com/z/doctor-medical-icon-cdr-187019168.jpg" style="width: 150px; height: 150px;">
                            </div>
                            <div class="infor col-4">
                                <p>Dịch vụ: <b>${reservation.serviceName}</b></p>
                                <p>Gói: <b>${reservation.packageTitle}</b></p>
                                <div class="row">
                                    <button class="btn btn-success mx-1">
                                        <a id="myBtn" style="color:white">Xem chi tiết</a>
                                    </button>
                                    <c:if test="${reservation.reservationStatus eq 'Đã khám'}">
                                        <button class="btn btn-primary mx-1">
                                            <a id="myBtn2" style="color:white">Phản hồi</a>
                                        </button>
                                    </c:if>
                                </div>
                                <!-- The Modal -->
                                <div id="myModal" class="modal">
                                    <!-- Modal content -->
                                    <div class="modal-content">
                                        <span class="close">&times;</span>
                                        <p>Dịch vụ: <b>${reservation.serviceName}</b></p>
                                        <p>Gói: <b>${reservation.packageTitle}</b></p>

                                        <p>Giá: <b> ${reservation.price} đ</b></p>
                                        <p class="status">${reservation.reservationStatus}</p>
                                        <h4>Chi tiết lịch đặt</h4>
                                        Ngày yêu cầu khám bệnh :${(reservation.requestExaminationDate != null)?reservation.requestExaminationDate:'Không có'}
                                        <br/>
                                        Ngày khám bệnh xác nhận :${(reservation.confirmedExaminationDate != null)?reservation.confirmedExaminationDate:'Chưa có'}
                                        <br/>
                                        Yêu cầu y tế :${(reservation.medicalRequest != "")?reservation.medicalRequest:'Không có yêu cầu y tế'}
                                    </div>
                                </div>

                                <div id="myModal2" class="modal">
                                    <!-- Modal content -->
                                    <div class="modal-content">
                                        <span class="close">&times;</span>
                                        <div class="row-fluid">
                                            <div class="form-group">
                                                <label for="feedbackContent"><b>Nội dung phản hồi</b></label>
                                                <textarea class="form-control" id="feedbackContent" rows="3"></textarea>
                                            </div>
                                            <button class="btn btn-primary float-right mt-3">Phản hồi</button>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                        <div style="margin-top:30px;">
                            <p>Giá: <b> ${reservation.price} đ</b></p>  
                            <p class="status"> ${reservation.reservationStatus}</p>
                        </div>

                    </div>
                </c:forEach>
                <c:if test="${reservations.totalItem == 0}">
                    <div class="col-12">
                        <p class="text-center">Không có dữ liệu</p>
                    </div>
                </c:if>
                <c:if test="${reservations.totalPage > 1}">
                    <div class="row mt-5">
                        <div class="col-12 text-center">
                            <ul>
                                <c:if test="${reservations.currentPage > 1}">
                                    <a class="btn btn-light" href="ViewCustomerReservationsList?page=${reservations.currentPage-1}">Trang trước</a>
                                </c:if>
                                <c:forEach var="pageNumber" begin="1" end="${reservations.totalPage}" step="1">
                                    <c:if test="${reservations.currentPage == pageNumber}">
                                        <a class="btn btn-success" href="#">${pageNumber}</a>
                                    </c:if>
                                    <c:if test="${reservations.currentPage != pageNumber}">
                                        <a class="btn btn-light" href="ViewCustomerReservationsList?page=${pageNumber}">${pageNumber}</a>
                                    </c:if>
                                </c:forEach>
                                <c:if test="${reservations.currentPage < reservations.totalPage}">
                                    <a class="btn btn-light" href="ViewCustomerReservationsList?page=${reservations.currentPage+1}">Trang sau</a>
                                </c:if>
                            </ul>
                        </div>
                    </div>
                </c:if>

                <script src="./assets/js/jquery-3.6.0.min.js" crossorigin="anonymous"></script>
                <script src="./assets/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
                <script src="./assets/js/star-rating.js" type="text/javascript"></script>
                <script src="./assets/themes/krajee-fas/theme.js" type="text/javascript"></script>
                <script src="./assets/js/select2.full.min.js"></script>
                <script src="./assets/js/custom.js"></script>
            </div>
        </div>
    </body>
    <footer>
        <jsp:include page="./components/footer.jsp" />
    </footer>
    <script>
        $("p:contains('Chờ duyệt')").css("background-color", "orange");
        $("p:contains('Đã khám')").css("background-color", "blue");
        $("p:contains('Đặt thành công')").css("background-color", "green");
// Get the modal
        var modal = document.getElementById("myModal");
        var modal2 = document.getElementById("myModal2");
// Get the button that opens the modal
        var btn = document.getElementById("myBtn");
        var btn2 = document.getElementById("myBtn2");
// Get the <span> element that closes the modal
        var span = document.getElementsByClassName("close")[0];
        var span2 = document.getElementsByClassName("close")[1];
// When the user clicks on the button, open the modal
        btn.onclick = function () {
            modal.style.display = "block";
        }
        btn2.onclick = function () {
            modal2.style.display = "block";
        }
// When the user clicks on <span> (x), close the modal
        span.onclick = function () {
            modal.style.display = "none";
        }
        span2.onclick = function () {
            modal2.style.display = "none";
        }
// When the user clicks anywhere outside of the modal, close it
        window.onclick = function (event) {
            if (event.target == modal) {
                modal.style.display = "none";
            }
            if (event.target == modal2) {
                modal2.style.display = "none";
            }
        }
    </script>
</html>
