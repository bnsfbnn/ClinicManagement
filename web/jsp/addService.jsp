<!--
 * Copyright(C) 20022, FPT University
 * CMS:
 * Clinic Management System
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-26      1.0                 MinhVT           Add Service 
 -->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Service</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="./assets/css/style.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="../assets/styles/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <link href="../assets/styles/jquery-ui.structure.min.css" rel="stylesheet" type="text/css"/>
        <link href="../assets/styles/jquery-ui.theme.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <table style="margin-left: auto; margin-right: auto; border: 1px solid">
            <tr>
                <th>Tên dịch vụ</th>
                <th>Tóm tắt</th>
                <th>Mô tả</th>
                <th>Hình ảnh</th>
                <th>Add</th>
            </tr>
            <form action="../AddServiceController" method="POST">
                <tr>
                    <td style="text-align: center; border: 1px solid" >
                        <input name="serviceName">
                    </td>
                    <td style="text-align: center; border: 1px solid">
                        <input name="serviceBrief">
                    </td>
                    <td style="text-align: center; border: 1px solid">
                        <input name="serviceDescription">
                    </td>
                    <td style="text-align: center; border: 1px solid">
                        <input name="serviceImage">
                    </td>
                    <td style="text-align: center; border: 1px solid" class="btn-success">
                        <a href="">
                            <button type="submit" class="btn btn-primary">Add</button>
                        </a>
                    </td>
                </tr>
            </form>
        </table>
    </body>
</html>
