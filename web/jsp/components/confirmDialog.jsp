<!--
 * Copyright(C) 2022, FPT University
 * CMS
 * CLINIC MANAGEMENT SYSTEM
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-24      1.0                 tungnt           First Implement 
/-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <c:if test="${cancelReservation eq 1}">
        <div class="row">
            <h5 class="col-lg-12">Bạn có chắc chắn hủy lịch đặt chỗ của bệnh nhân này với lý  do bệnh nhân không đến ?</h5>
        </div>
                <div class="w-100 border-bottom my-5"></div>
        <div class="row mx-auto">
            <form id="frm" action="${pageContext.request.contextPath}/cancelReservation" method="POST">
                <input type="number" name="reservationId" value="${reservationId}" hidden="false"/>
            </form>
            <button type="button" class="btn btn-success mx-1" onclick="$('#frm').submit();">Có</button>
            <button type="button" class="btn btn-danger mx-1" data-toggle="modal" data-target="#viewDetailReservationPopup" data-dismiss="modal">Không</button>
        </div>
    </c:if>
    <c:if test="${cancelReceiveReservation eq 1}">
        <div class="row">
            <h5 class="col-lg-12">Bạn có chắc chắn muốn hủy nhận lịch đặt chỗ này với lý do bận và yêu cầu chuyển cho bác sĩ khác?</h5>
        </div>
        <div class="w-100 border-bottom my-5"></div>
        <div class="row mx-auto">
            <form id="frm" action="${pageContext.request.contextPath}/cancelReceiveReservation" method="POST">
                <input type="number" name="reservationId" value="${reservationId}" hidden="false"/>
            </form>
            <button type="button" class="btn btn-success mx-1" onclick="$('#frm').submit();">Có</button>
            <button type="button" class="btn btn-danger mx-1" data-toggle="modal" data-target="#viewDetailReservationPopup" data-dismiss="modal">Không</button>
        </div>
    </c:if>
</body>
</html>