<!--
 * Copyright(C) 20022, FPT University
 * CMS:
 * Clinic Management System
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-22      1.0                 TrangCT        View Customer Reservation Detail 
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
        <h1 style="text-align: center">Reservation Detail</h1>
        <div class="row mt-3">

            <table style="margin-left: auto; margin-right: auto; border: 1px solid">
                <tr>
                    <th>Dịch vụ</th>
                    <th>Gói</th>
                    <th>Giá tiền</th>
                    <th>Trạng thái</th>
                    <th>Ngày đặt lịch</th>
                    <th>Đặt thành công</th>
                    <th>Yêu cầu y tế</th>
                </tr>
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
                        ${reservation.requestExaminationDate}
                    </td>
                    <td style="text-align: center; border: 1px solid">
                        ${reservation.confirmedExaminationDate}
                    </td>
                    <td style="text-align: center; border: 1px solid">
                        ${reservation.medicalRequest}
                    </td>
                </tr>
            </table>
        </div>
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
