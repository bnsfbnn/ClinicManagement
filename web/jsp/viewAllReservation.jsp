<!--
 * Copyright(C) 2022, FPT University
 * CMS
 * CLINIC MANAGEMENT SYSTEM
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-08      1.0                 tungnt           First Implement 
/-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="/WEB-INF/functions.tld" prefix="f" %>
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

        <!--Start main content-->
        <div class="">
            <div class="container-fluid p-0">
                <div class="row justify-content-center mt-3 mr-0">
                    <h4>Danh sách tất cả lịch khám bệnh</h4>
                </div>
                <form id="myForm" action="${pageContext.request.contextPath}/viewAllReservationController" method="POST">
                    <div class="row justify-content-end mt-3 mr-4">
                        <div class="mx-4">
                            <select name="serviceId" id="serviceId" class="form-control">
                                <option value="-1">Tất cả dịch vụ</option>
                                <c:forEach items="${services}" var="i">
                                    <option value="${i.serviceId}" ${(serviceId ne null and serviceId eq i.serviceId) ? "selected":""}>${i.serviceName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="row justify-content-end mt-3 mr-0">
                        <div class="mr-5">
                            <input type="text" class="form-control" id="datepicker" name="viewDay">
                        </div>
                        <div class="mr-5">
                            <button type="button" class="btn btn-primary px-4" id="today">Today</button>
                        </div>
                    </div>
                </form>
                <div class="container-fluid mt-3 m-0 p-0">
                    <div class="table-responsive overflow-auto">
                        <table class="table table-bordered text-center ">
                            <tr>
                                <th  scope="col" class="bg-light"></th>
                                    <c:forEach var="i" items="${doctors}">
                                    <th scope="col" class="bg-dark text-white">${i.fullName}<br/>(07:00AM-05:00PM)</th>
                                    </c:forEach>
                            </tr>
                            <c:forEach begin="7" end="16" step="1" var="k">
                                <c:choose>
                                    <c:when test="${k eq 12}">
                                        <tr>
                                            <td class="bg-light text-dark m-0 p-0">12:00</td>
                                            <c:forEach var="i" items="${doctors}">
                                                <td class="bg-light text-dark m-0 p-0">12:00</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-light text-dark m-0 p-0">15</td>
                                            <c:forEach var="i" items="${doctors}">
                                                <td class="bg-light text-dark m-0 p-0">12:15</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-light text-dark m-0 p-0">30</td>
                                            <c:forEach var="i" items="${doctors}">
                                                <td class="bg-light text-dark m-0 p-0">12:30</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-light text-dark m-0 p-0">45</td>
                                            <c:forEach var="i" items="${doctors}">
                                                <td class="bg-light text-dark m-0 p-0">12:45</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-light text-dark m-0 p-0">60</td>
                                            <c:forEach var="i" items="${doctors}">
                                                <td class="bg-light text-dark m-0 p-0">13:00</td>
                                            </c:forEach>
                                        </tr>
                                    </c:when>
                                    <c:when test="${k ne 12 and k lt 10}">
                                        <tr>
                                            <td class="bg-light text-dark m-0 p-0">${k}:00</td>
                                            <c:forEach var="i" items="${doctors}">
                                                <td class="bg-light text-dark m-0 p-0">${k}:00</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-white text-dark m-0 p-0">15</td>
                                            <c:forEach var="i" items="${doctors}">
                                                <td class="bg-white text-dark m-0 p-0" id="${i.userId}-0${k}:00:00">${k}:15</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-white text-dark m-0 p-0">30</td>
                                            <c:forEach var="i" items="${doctors}">
                                                <td class="bg-white text-dark m-0 p-0" id="${i.userId}-0${k}:15:00">${k}:30</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-white text-dark m-0 p-0">45</td>
                                            <c:forEach var="i" items="${doctors}">
                                                <td class="bg-white text-dark m-0 p-0" id="${i.userId}-0${k}:30:00">${k}:40</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-white text-dark m-0 p-0">60</td>
                                            <c:forEach var="i" items="${doctors}">
                                                <td class="bg-white text-dark m-0 p-0" id="${i.userId}-0${k}:45:00">${k+1}:00</td>
                                            </c:forEach>
                                        </tr>
                                    </c:when>
                                    <c:when test="${k ne 12 and (k gt 10 or k eq 10)}">
                                        <tr>
                                            <td class="bg-light text-dark m-0 p-0">${k}:00</td>
                                            <c:forEach var="i" items="${doctors}">
                                                <td class="bg-light text-dark m-0 p-0">${k}:00</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-white text-dark m-0 p-0">15</td>
                                            <c:forEach var="i" items="${doctors}">
                                                <td class="bg-white text-dark m-0 p-0" id="${i.userId}-${k}:00:00">${k}:15</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-white text-dark m-0 p-0">30</td>
                                            <c:forEach var="i" items="${doctors}">
                                                <td class="bg-white text-dark m-0 p-0" id="${i.userId}-${k}:15:00">${k}:30</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-white text-dark m-0 p-0">45</td>
                                            <c:forEach var="i" items="${doctors}">
                                                <td class="bg-white text-dark m-0 p-0" id="${i.userId}-${k}:30:00">${k}:40</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-white text-dark m-0 p-0">60</td>
                                            <c:forEach var="i" items="${doctors}">
                                                <td class="bg-white text-dark m-0 p-0" id="${i.userId}-${k}:45:00">${k+1}:00</td>
                                            </c:forEach>
                                        </tr>
                                    </c:when>
                                </c:choose>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
            <!--End main content-->
        </div>
        <!--Import js lib-->
        <script src="./assets/js/jquery-3.6.0.min.js" type="text/javascript"></script>
        <script src="./assets/js/popper.js" type="text/javascript"></script>
        <script src="./assets/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="./assets/js/jquery-ui.min.js" type="text/javascript"></script>
        <!--Import js code-->
        <script>
            function submitForm() {

            }
            $(document).ready(function () {
                //set date picker
                $("#datepicker").datepicker({
                    changeMonth: true,
                    changeYear: true,
                    maxDate: '+6D',
                });
                var viewDay = "${viewDay}";
                var dd1 = viewDay.split("-")[2];
                var mm1 = viewDay.split("-")[1];
                var yyyy1 = viewDay.split("-")[0];
                viewDay = mm1 + '/' + dd1 + '/' + yyyy1;
                $("#datepicker").val(viewDay); //set date want to view for datepicker
            <c:forEach items="${reservations}" var="i" varStatus="status">
                var raw_confirmedExaminationTime = '${i.confirmedExaminationTime}';
                var confirmedExaminationTime = raw_confirmedExaminationTime.split(":")[0] + "\\:" + raw_confirmedExaminationTime.split(":")[1] + "\\:" + raw_confirmedExaminationTime.split(":")[2];
                var confirmDoctorId = '${i.confirmedDoctor.userId}';
                var idProperties = confirmDoctorId + '-' + confirmedExaminationTime;
                $("#" + idProperties).text("");
                var reservationStatus = '${i.confirmedDoctor.userId}';
                $("#" + idProperties).append("<div class=\"rounded bg-primary text-white m-0 p-0\"><b>${i.customer.fullName}</b><br/><b>Dịch vụ:  </b><i>${i.service.serviceName}</i></div>");
            </c:forEach>
            });
            //set today for datepicker
            $("#today").click(function () {
                var today = new Date();
                var dd = String(today.getDate()).padStart(2, '0');
                var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
                var yyyy = today.getFullYear();
                today = yyyy + '-' + mm + '-' + dd;
                $("#datepicker").val(today);
                document.getElementById("myForm").submit();
            });
            $("#datepicker").datepicker({
                onSelect: function () {
                    var raw_viewDay = $('#datepicker').val();
                    var mm = raw_viewDay.split("/")[0];
                    var dd = raw_viewDay.split("/")[1];
                    var yyyy = raw_viewDay.split("/")[2];
                    var viewDay = yyyy + '-' + mm + '-' + dd;
                    $('#datepicker').val(viewDay);
                    document.getElementById("myForm").submit();
                }
            });
        </script>
    </body>
</html>
