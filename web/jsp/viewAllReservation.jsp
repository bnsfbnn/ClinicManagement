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
        <link href="./assets/css/viewAllReservation.css" rel="stylesheet" type="text/css"/>
        <link href="./assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="./assets/css/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <link href="./assets/css/jquery-ui.structure.min.css" rel="stylesheet" type="text/css"/>
        <link href="./assets/css/jquery-ui.theme.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <!--Import header-->
        <%@include file="components/header.jsp" %>

        <!--Start main content-->
        <div class="">
            <div class="container-fluid p-0">
                <div class="row justify-content-center mt-3 mr-0">
                    <h1>Danh sách tất cả lịch khám bệnh</h1>
                </div>
                <div class="row justify-content-end mt-3 mr-0">
                    <div class="mx-4">
                        <select name="serviceId" class="form-control">
                            <option value="-1">Tất cả dịch vụ</option>
                            <c:forEach items="${services}" var="i">
                                <option value="${ca.id}" <c:if test="${requestScope.categoryFilter==ca.id}">selected="selected"</c:if>>${ca.category}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mr-5">
                        <input type="text" class="form-control" id="datepicker">
                    </div>
                </div>
                <div class="row justify-content-end mt-3 mr-0">
                    <div class="mr-5">
                        <button type="button" class="btn btn-primary px-4" id="today">Today</button>
                    </div>
                </div>
                <div class="container-fluid mt-3 m-0 p-0">
                    <div class="table-responsive overflow-auto">
                        <table class="table table-bordered text-center ">
                            <tr>
                                <th  scope="col" class="bg-light"></th>
                                    <c:forEach var="i" items="${doctors}">
                                    <th scope="col" class="bg-dark text-white">${i.fullName}<br/>(07:00AM-05:00PM)</th>
                                    </c:forEach>
                            </tr>

                            <c:forEach var="k" begin="7" end="16" step="1">
                                <c:choose>
                                    <c:when test="${k == 12}">
                                        <tr>
                                            <td class="bg-light text-dark">${k}:00</td>
                                            <c:forEach var="i" items="${doctors}">
                                                <td class="bg-light text-dark">${k}:00</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-light text-dark">15</td>
                                            <c:forEach var="i" items="${doctors}">
                                                <td class="bg-light text-dark">${k}:15</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-light text-dark">30</td>
                                            <c:forEach var="i" items="${doctors}">
                                                <td class="bg-light text-dark">${k}:30</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-light text-dark">45</td>
                                            <c:forEach var="i" items="${doctors}">
                                                <td class="bg-light text-dark">${k}:45</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-light text-dark">60</td>
                                            <c:forEach var="i" items="${doctors}">
                                                <td class="bg-light text-dark">${k + 1}:00</td>
                                            </c:forEach>
                                        </tr>
                                    </c:when>
                                    <c:when test="${k ne 12 and k lt 10}">
                                        <tr>
                                            <td class="bg-light text-dark">${k}:00</td>
                                            <c:forEach var="i" items="${doctors}">
                                                <td class="bg-light text-dark">${k}:00</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-white text-dark">15</td>
                                            <c:set var="count" value="0" scope="page"/>
                                            <c:set var="time" value="0${k}:00:00" scope="page"/>
                                            <c:forEach var="i" items="${doctors}">
                                                <c:forEach var="j" items="${reservations}">
                                                    <c:if test="${(j.confirmedExaminationTime eq time) and (j.confirmedExaminationDate eq today) and (i.userId == j.confirmedDoctor.userId)}">
                                                        <c:set var="count" value="${count + 1}" scope="page"/>
                                                        <td class="m-0 p-0"><div class="rounded bg-primary text-white m-0 p-0"><b>${j.customer.fullName}</b><br/><i>${j.service.serviceName}</i></div></td>
                                                                </c:if>
                                                            </c:forEach>
                                                        </c:forEach>
                                                        <c:forEach begin="${count}" end="${doctors.size()-1}">
                                                <td class="bg-white text-dark">${k}:15</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-white text-dark">30</td>
                                            <c:set var="count" value="0" scope="page"/>
                                            <c:set var="time" value="0${k}:15:00" scope="page"/>
                                            <c:forEach var="i" items="${doctors}">
                                                <c:forEach var="j" items="${reservations}">
                                                    <c:if test="${(j.confirmedExaminationTime eq time) and (j.confirmedExaminationDate eq today) and (i.userId == j.confirmedDoctor.userId)}">
                                                        <c:set var="count" value="${count + 1}" scope="page"/>
                                                        <td class="m-0 p-0"><div class="rounded bg-primary text-white m-0 p-0"><b>${j.customer.fullName}</b><br/><i>${j.service.serviceName}</i></div></td>
                                                                </c:if>
                                                            </c:forEach>
                                                        </c:forEach>
                                                        <c:forEach begin="${count}" end="${doctors.size()-1}">
                                                <td class="bg-white text-dark">${k}:30</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-white text-dark">45</td>
                                            <c:set var="count" value="0" scope="page"/>
                                            <c:set var="time" value="0${k}:30:00" scope="page"/>
                                            <c:forEach var="i" items="${doctors}">
                                                <c:forEach var="j" items="${reservations}">
                                                    <c:if test="${(j.confirmedExaminationTime eq time) and (j.confirmedExaminationDate eq today) and (i.userId == j.confirmedDoctor.userId)}">
                                                        <c:set var="count" value="${count + 1}" scope="page"/>
                                                        <td class="m-0 p-0"><div class="rounded bg-primary text-white m-0 p-0"><b>${j.customer.fullName}</b><br/><i>${j.service.serviceName}</i></div></td>
                                                                </c:if>
                                                            </c:forEach>
                                                        </c:forEach>
                                                        <c:forEach begin="${count}" end="${doctors.size()-1}">
                                                <td class="bg-white text-dark">${k}:45</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-white text-dark">60</td>
                                            <c:set var="count" value="0" scope="page"/>
                                            <c:set var="time" value="0${k}:45:00" scope="page"/>
                                            <c:forEach var="i" items="${doctors}">
                                                <c:forEach var="j" items="${reservations}">
                                                    <c:if test="${(j.confirmedExaminationTime eq time) and (j.confirmedExaminationDate eq today) and (i.userId == j.confirmedDoctor.userId)}">
                                                        <c:set var="count" value="${count + 1}" scope="page"/>
                                                        <td class="m-0 p-0"><div class="rounded bg-primary text-white m-0 p-0"><b>${j.customer.fullName}</b><br/><i>${j.service.serviceName}</i></div></td>
                                                                </c:if>
                                                            </c:forEach>
                                                        </c:forEach>
                                                        <c:forEach begin="${count}" end="${doctors.size()-1}">
                                                <td class="bg-white text-dark">${k + 1}:00</td>
                                            </c:forEach>
                                        </tr>
                                    </c:when>
                                    <c:when test="${k ne 12 and (k gt 10 or k eq 10)}">
                                        <tr>
                                            <td class="bg-light text-dark">${k}:00</td>
                                            <c:forEach var="i" items="${doctors}">
                                                <td class="bg-light text-dark">${k}:00</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-white text-dark">15</td>
                                            <c:set var="count" value="0" scope="page"/>
                                            <c:set var="time" value="${k}:00:00" scope="page"/>
                                            <c:forEach var="i" items="${doctors}">
                                                <c:forEach var="j" items="${reservations}">
                                                    <c:if test="${(j.confirmedExaminationTime eq time) and (j.confirmedExaminationDate eq today) and (i.userId == j.confirmedDoctor.userId)}">
                                                        <c:set var="count" value="${count + 1}" scope="page"/>
                                                        <td class="m-0 p-0"><div class="rounded bg-primary text-white m-0 p-0"><b>${j.customer.fullName}</b><br/><i>${j.service.serviceName}</i></div></td>
                                                                </c:if>
                                                            </c:forEach>
                                                        </c:forEach>
                                                        <c:forEach begin="${count}" end="${doctors.size()-1}">
                                                <td class="bg-white text-dark">${k}:15</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-white text-dark">30</td>
                                            <c:set var="count" value="0" scope="page"/>
                                            <c:set var="time" value="${k}:15:00" scope="page"/>
                                            <c:forEach var="i" items="${doctors}">
                                                <c:forEach var="j" items="${reservations}">
                                                    <c:if test="${(j.confirmedExaminationTime eq time) and (j.confirmedExaminationDate eq today) and (i.userId == j.confirmedDoctor.userId)}">
                                                        <c:set var="count" value="${count + 1}" scope="page"/>
                                                        <td class="m-0 p-0"><div class="rounded bg-primary text-white m-0 p-0"><b>${j.customer.fullName}</b><br/><i>${j.service.serviceName}</i></div></td>
                                                                </c:if>
                                                            </c:forEach>
                                                        </c:forEach>
                                                        <c:forEach begin="${count}" end="${doctors.size()-1}">
                                                <td class="bg-white text-dark">${k}:30</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-white text-dark">45</td>
                                            <c:set var="count" value="0" scope="page"/>
                                            <c:set var="time" value="${k}:30:00" scope="page"/>
                                            <c:forEach var="i" items="${doctors}">
                                                <c:forEach var="j" items="${reservations}">
                                                    <c:if test="${(j.confirmedExaminationTime eq time) and (j.confirmedExaminationDate eq today) and (i.userId == j.confirmedDoctor.userId)}">
                                                        <c:set var="count" value="${count + 1}" scope="page"/>
                                                        <td class="m-0 p-0"><div class="rounded bg-primary text-white m-0 p-0"><b>${j.customer.fullName}</b><br/><i>${j.service.serviceName}</i></div></td>
                                                                </c:if>
                                                            </c:forEach>
                                                        </c:forEach>
                                                        <c:forEach begin="${count}" end="${doctors.size()-1}">
                                                <td class="bg-white text-dark">${k}:45</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-white text-dark">60</td>
                                            <c:set var="count" value="0" scope="page"/>
                                            <c:set var="time" value="${k}:45:00" scope="page"/>
                                            <c:forEach var="i" items="${doctors}">
                                                <c:forEach var="j" items="${reservations}">
                                                    <c:if test="${(j.confirmedExaminationTime eq time) and (j.confirmedExaminationDate eq today) and (i.userId == j.confirmedDoctor.userId)}">
                                                        <c:set var="count" value="${count + 1}" scope="page"/>
                                                        <td class="m-0 p-0 "><div class="rounded bg-primary text-white m-0 p-0"><b>${j.customer.fullName}</b><br/><i>${j.service.serviceName}</i></div></td>
                                                                </c:if>
                                                            </c:forEach>
                                                        </c:forEach>
                                                        <c:forEach begin="${count}" end="${doctors.size()-1}">
                                                <td class="bg-white text-dark">${k + 1}:00</td>
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
            var today = new Date();
            var dd = String(today.getDate()).padStart(2, '0');
            var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
            var yyyy = today.getFullYear();
            today = mm + '/' + dd + '/' + yyyy;
            $("#datepicker").val(today);
            $("#datepicker").datepicker({
                changeMonth: true,
                changeYear: true,
                maxDate: '+6D',
            });
            $("#today").click(function () {
                $("#datepicker").val(today);
            });
        </script>
    </body>
</html>
