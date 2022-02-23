<!--
 * Copyright(C) 2022, FPT University
 * CMS
 * CLINIC MANAGEMENT SYSTEM
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-08      1.0                 tungnt           First Implement 
/-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
        <link href="./assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="./assets/css/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container-fuild">
            <div class="row-fuild justify-content-center">
                <img class="d-block mx-auto my-5 py-5" src="./assets/images/error.png" alt=""/>
                <h1 class="d-flex justify-content-center">${errorMessage}</h1>
            </div>
        </div>
    </body>
    <!--Import js lib-->
    <script src="./assets/js/jquery-3.6.0.min.js" type="text/javascript"></script>
    <script src="./assets/js/popper.js" type="text/javascript"></script>
    <script src="./assets/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="./assets/js/jquery-ui.min.js" type="text/javascript"></script>
</html>
