<%-- 
    Document   : confirmDialog
    Created on : Feb 28, 2022, 2:29:06 AM
    Author     : Thanh Tung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="rơw">
            <h6 class="col-lg-12">Bạn có chắc chắn hủy lịch đặt chỗ của bệnh nhân này với lý do bệnh nhân không đến ?</h5>
        </div>
        <div class="rơw mx-auto">
            <form id="frm" action="${pageContext.request.contextPath}/cancelReservation" method="POST">
                <input type="number" name="reservationId" value="${reservationId}" hidden="false"/>
            </form>
            <button type="button" class="btn btn-success" onclick="$('#frm').submit();">Có</button>
            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#viewDetailReservationPopup" data-dismiss="modal">Không</button>
        </div>
    </body>
</html>