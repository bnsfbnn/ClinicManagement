<%-- 
    Document   : home
    Created on : Feb 23, 2022, 8:15:14 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <style>
        .content{
            background-image: url("https://isofhcare.com/_next/static/banner.png");
            height: 482px;
            text-align: center;
            padding-top: 160px;
        }
        .content input{
            width: 700px;
            height: 50px;
            boder:3px;
            border-color: #00ba99;
            border-style: solid;
            border-radius: 10px;
            padding:10px;
            text-color:#00ba99;
        }
    </style>
    <jsp:include page="../components/header.jsp" />

    <body>

        <div class="content text-white ">
                <h2>Tìm bác sĩ, bệnh viện dễ dàng hơn</h2>
                <p>Chủ động đặt lịch hẹn thông minh và được chăm sóc tận tình</p>
                <input type="text" placeholder="Nhập tên bác sĩ, bệnh viện, dịch vụ">
        </div>
        
    </body>
</html>
