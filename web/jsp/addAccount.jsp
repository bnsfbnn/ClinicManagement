<!--
 * Copyright(C) 2022, FPT University
 * CMS
 * CLINIC MANAGEMENT SYSTEM
 *
 * Record of change:
 * DATE            Version          AUTHOR           DESCRIPTION
 * 2022-02-08      1.0              HuongHTT         First Implement 
/-->
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
                <th>Role</th>
                <th>Username</th> 
                <th>Email</th>
                <th>Fullname</th>
                <th>Date</th>
                <th>Gender</th>
                <th>Phone</th>
                <th>Address</th>
                <th>Add</th>
            </tr>
            <form action="../CreateAccountController" method="POST">
                <tr>
                    <td style="text-align: center; border: 1px solid" >
                        <input name="roleId" type="number">
                    </td>
                    <td style="text-align: center; border: 1px solid">
                        <input name="username">
                    </td>
                    <td style="text-align: center; border: 1px solid">
                        <input name="email" type="email">
                    </td>
                    <td style="text-align: center; border: 1px solid">
                        <input name="fullName" type="text">
                    </td>
                    <td style="text-align: center; border: 1px solid">
                        <input name="date" type="date">
                    </td>
                    <td style="text-align: center; border: 1px solid" >
                        <input name="gender">
                    </td>     
                    <td style="text-align: center; border: 1px solid" >
                        <input name="phone">
                    </td>
                    <td style="text-align: center; border: 1px solid" >
                        <input name="address">
                    </td>

                    <td style="text-align: center; border: 1px solid" class="btn-success">
                        <a href="">
                            <button type="submit" class="btn btn-primary">Add</button>
                        </a>
                    </td>
                </tr>
            </form>
        </table>
</html>
