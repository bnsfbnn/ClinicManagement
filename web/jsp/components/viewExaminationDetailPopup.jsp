<%-- 
 * Copyright(C) 2022, FPT University
 * CMS
 * CLINIC MANAGEMENT SYSTEM
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-08      1.0                 tungnt           First Implement 
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="/WEB-INF/functions.tld" prefix="f" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <div class="col-lg-12">
            <c:choose>
                <c:when test="${addNew == 0}">
                    <label for="examinationDisgosis"><h6>Chuẩn đoán</h6></label>
                    <textarea class="form-control" id="examinationDisgosis" rows="8" disabled></textarea>
                    <label for="examinationPrescription"><h6>Đơn thuốc</h6></label>
                    <textarea class="form-control" id="examinationPrescription" rows="8" disabled></textarea>
                </c:when>
                <c:when test="${addNew == 1}">
                    <label for="examinationDisgosis"><h6>Chuẩn đoán</h6></label>
                    <textarea class="form-control" id="examinationDisgosis" rows="8" disabled></textarea>
                    <label for="examinationPrescription"><h6>Đơn thuốc</h6></label>
                    <textarea class="form-control" id="examinationPrescription" rows="8" disabled></textarea>
                    <br/>
                    <button type="button" class="btn btn-primary btn-block my-2>Đã khám xong</button>
                </c:when>
            </c:choose>
    </body>
</html>