<%-- 
    Document   : header
    Created on : Feb 23, 2022, 3:37:02 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./assets/css/styles.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <style>
        
        ul li{
            list-style: none;
            margin-right: 20px

        }
                ul li a{
                    font-size: 20px
                }

        img{
            width: 200px;
        }
    </style>
    <body>
        <div class="header d-flex justify-content-around mt-3">
            <div class="header-logo">
                <a href=""> 
                    <img src="https://assets.grab.com/wp-content/uploads/sites/4/2019/04/03163033/Silver-Cross-Clinic-Logo.png">
                </a>
            </div>
            <div class="header-items mt-5">
                <ul class="d-flex">
                    <li >
                        <a href="">Trang chủ</a>
                    </li>
                    <li>
                        <a href="">aaa</a>
                    </li>
                    <li>
                        <a href="">aaa</a>
                    </li>
                     <li>
                        <a href="LogoutController">Đăng xuất</a>
                    </li>

                </ul>
            </div>

        </div>
    </body>
</html>
