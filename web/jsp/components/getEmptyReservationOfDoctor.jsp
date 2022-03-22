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
    <select name="confirmedExaminationTime" id="confirmedExaminationTime" class="form-control">
        <option value="-1">Giờ</option>
        <c:forEach begin="7" end="16" step="1" var="k">
            <c:choose>
                <c:when test="${k eq 12}">
                    <option style="background-color: gainsboro" disabled="disabled" value="12:00:00">12:00:00</option>
                </c:when>
                <c:when test="${k ne 12 and k lt 10}">
                    <c:set var = "var" scope = "page" value = "0${k}:00:00"/>
                    <c:forEach begin="0" end="${timeSchedule.size()}" step="1" var="m">
                        <c:set var="done" value="false" />
                        <c:if test="${timeSchedule[0] eq var}">
                            <c:set var="done" value="true" />
                        </c:if>
                    </c:forEach>
                    <c:choose>
                        <c:when test="${done eq true}">
                            <option style="background-color: gainsboro" disabled="disabled" value="${var}">${var}</option>
                        </c:when>
                        <c:when test="${done ne true}">
                            <option value="${var}">${var}</option>
                        </c:when>
                    </c:choose>
                </c:when>
                <c:when test="${k ne 12 and (k gt 10 or k eq 10)}">
                    <c:set var = "var" scope = "page" value = "${k}:00:00"/>
                    <c:forEach begin="0" end="${timeSchedule.size()}" step="1" var="m">
                        <c:set var="done" value="false" />
                        <c:if test="${timeSchedule[0] eq var}">
                            <c:set var="done" value="true" />
                        </c:if>
                    </c:forEach>
                    <c:choose>
                        <c:when test="${done eq true}">
                            <option style="background-color: gainsboro" disabled="disabled" value="${var}">${var}</option>
                        </c:when>
                        <c:when test="${done ne true}">
                            <option value="${var}">${var}</option>
                        </c:when>
                    </c:choose>
                </c:when>
            </c:choose>
        </c:forEach>
    </select>
</html>
