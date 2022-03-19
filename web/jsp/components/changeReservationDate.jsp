<!--
 * Copyright(C) 2022, FPT University
 * CMS
 * CLINIC MANAGEMENT SYSTEM
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-24      1.0                 tungnt           First Implement 
/-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <dl id="dataList" class="row ml-auto mb-5">
            <dt class="col-sm-7">Dịch vụ:</dt>
            <dd class="col-sm-5">${reservation.service.serviceName}</dd>
            <dt class="col-sm-7">Bác sĩ:</dt>
            <dd class="col-sm-5" id="doctorId" value="${doctor.userId}">${doctor.fullName}</dd>
            <dt class="col-sm-7">Gói:</dt>
            <dd class="col-sm-5">${reservation.servicePackage.packageTitle}</dd>
            <dt class="col-sm-7">Thời gian khám bệnh:</dt>
            <dd class="col-sm-5">${reservation.servicePackage.examinationDuration}</dd>
            <dt class="col-sm-7">Ngày khám bệnh: </dt>
            <dd class="col-sm-5">${reservation.confirmedExaminationDate} ${reservation.confirmedExaminationTime}</dd>
            <dt class="col-sm-7">Yêu cầu y tế:</dt>
            <dd class="col-sm-5">${(reservation.medicalRequest ne null) ? reservation.medicalRequest : "Không có"}</dd>
            <div class="w-50 my-2 mx-auto row border-bottom"></div>
            <dt class="col-sm-7">Chọn ngày hẹn mới</dt>
            <dd><input type="text" class="form-control" id="datepickerPopup" name="reservation.confirmedExaminationDate"></dd>
            <dt class="col-sm-7">Chọn thời gian khám bệnh</dt>
            <dd id="newTime"></dd>
        </dl>
        <button></button>
        <script>
            $("#datepickerPopup").datepicker({
                firstDay: 1,
                changeMonth: true,
                minDate: '+0D',
                maxDate: '+6D',
                onSelect: function () {
                    var id = $("#doctorId").attr('value');
                    var date = $("#datepickerPopup").val();
                    $.ajax({
                        url: "${pageContext.request.contextPath}/changeReservationDate",
                        type: "post",
                        dataType: "text",
                        data: {
                            doctorId: id,
                            date: date
                        },
                        success: function (result) {
                            $("#newTime").html(result);
                        }
                    });
                },
            });
        </script>
    </body>
</html>
