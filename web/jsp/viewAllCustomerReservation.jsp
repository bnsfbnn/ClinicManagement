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
        <link href="../assets/styles/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <link href="../assets/styles/jquery-ui.structure.min.css" rel="stylesheet" type="text/css"/>
        <link href="../assets/styles/jquery-ui.theme.min.css" rel="stylesheet" type="text/css"/>
        <title>Account Management</title>
    </head>
    <header>
        <jsp:include page="./components/customerHeader.jsp" />
    </header>
    <body>
        <h1 style="text-align: center">Reservation List</h1>
        <div class="row mt-3">

            <table style="margin-left: auto; margin-right: auto; border: 1px solid">
                <tr>
                    <th>Dịch vụ</th>
                    <th>Gói</th>
                    <th>Giá tiền</th>
                    <th>Trạng thái</th>
                    <th>Action</th>
                </tr>
                <c:forEach var="reservation" items="${reservations.data}">
                    <tr>
                        <td style="text-align: center; border: 1px solid" >
                            ${reservation.serviceName}
                        </td>
                        <td style="text-align: center; border: 1px solid">
                            ${reservation.packageTitle}
                        </td>
                        <td style="text-align: center; border: 1px solid">
                            ${reservation.price}
                        </td>
                        <td style="text-align: center; border: 1px solid">
                            ${reservation.reservationStatus}
                        </td>

                        <td style="text-align: center; border: 1px solid">
                            <button class="btn-only-ic">
                                <a href="ViewCustomerReservationDetail?id=${reservation.id}">View Detail</a>
                            </button>
                            <!--<button type="button" class="btn btn-success" onclick="myFunction('${user.userId}')">View Detail</button>-->
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <c:if test="${reservations.totalItem == 0}">
            <div class="col-12">
                <p class="text-center">Không có dữ liệu</p>
            </div>
        </c:if>
        <c:if test="${reservations.totalPage > 1}">
            <div class="row">
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

        <script>
        </script>
        <script src="./assets/js/jquery-3.6.0.min.js" crossorigin="anonymous"></script>
        <script src="./assets/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="./assets/js/star-rating.js" type="text/javascript"></script>
        <script src="./assets/themes/krajee-fas/theme.js" type="text/javascript"></script>
        <script src="./assets/js/select2.full.min.js"></script>
        <script src="./assets/js/custom.js"></script>

    </body>
    <footer>
        <jsp:include page="./components/footer.jsp" />
    </footer>
</html>