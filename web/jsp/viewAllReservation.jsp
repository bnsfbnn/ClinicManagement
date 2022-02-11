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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8;">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Clinic Management System</title>
        <link href="../assets/styles/styles.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="../assets/styles/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <link href="../assets/styles/jquery-ui.structure.min.css" rel="stylesheet" type="text/css"/>
        <link href="../assets/styles/jquery-ui.theme.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <!--Import header-->
        <%@include file="components/header.jsp" %>

        <!--Start main content-->
        <div class="">
            <div class="container-fluid p-0">
                <div class="row justify-content-center mt-3 mr-0">
                    <h1>Danh sách tất cả lịch khám bệnh</h1>
                </div>
                <div class="row justify-content-end mt-3 mr-0">
                    <div class="mx-4">
                        <select class="form-control">
                            <option>Tất cả các dịch vụ</option>
                            <option>Option 2</option>
                            <option>Option 3</option>
                        </select>
                    </div>
                    <div class="mr-5">
                        <input type="text" class="form-control" id="datepicker">
                    </div>
                </div>
                <div class="row justify-content-end mt-3 mr-0">
                    <div class="mr-5">
                        <button type="button" class="btn btn-primary px-4">Today</button>
                    </div>
                </div>
                <div class="container-fluid mt-3 m-0 p-0">
                    <div class="table-responsive">
                        <table class="table table-bordered text-center ">
                            <thead>
                                <tr>
                                    <th scope="col" class="bg-light"></th>
                                    <th scope="col" class="bg-dark text-white">Nguyễn Bác Sĩ<br/>(07:00AM-05:00PM)</th>
                                    <th scope="col" class="bg-dark text-white">Nguyễn Bác Sĩ<br/>(07:00AM-05:00PM)</th>
                                    <th scope="col" class="bg-dark text-white">Nguyễn Bác Sĩ<br/>(07:00AM-05:00PM)</th>
                                    <th scope="col" class="bg-dark text-white">Nguyễn Bác Sĩ<br/>(07:00AM-05:00PM)</th>
                                    <th scope="col" class="bg-dark text-white">Nguyễn Bác Sĩ<br/>(07:00AM-05:00PM)</th>
                                    <th scope="col" class="bg-dark text-white">Nguyễn Bác Sĩ<br/>(07:00AM-05:00PM)</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td class="bg-light text-dark">07:00AM</td>
                                    <td class="bg-light text-secondary">07:00AM</td>
                                    <td class="bg-light text-secondary">07:00AM</td>
                                    <td class="bg-light text-secondary">07:00AM</td>
                                    <td class="bg-light text-secondary">07:00AM</td>
                                    <td class="bg-light text-secondary">07:00AM</td>
                                    <td class="bg-light text-secondary">07:00AM</td>
                                </tr>
                                <tr>
                                    <td class="bg-white text-dark">15</td>
                                    <td class="bg-white text-secondary">07:15AM</td>
                                    <td class="bg-white text-secondary">07:15AM</td>
                                    <td class="bg-white text-secondary">07:15AM</td>
                                    <td class="bg-white text-secondary">07:15AM</td>
                                    <td class="bg-white text-secondary">07:15AM</td>
                                    <td class="bg-white text-secondary">07:15AM</td>
                                </tr>
                                <tr>
                                    <td class="bg-white text-dark">30</td>
                                    <td class="bg-white text-secondary">07:30AM</td>
                                    <td class="bg-white text-secondary">07:30AM</td>
                                    <td class="bg-white text-secondary">07:30AM</td>
                                    <td class="bg-white text-secondary">07:30AM</td>
                                    <td class="bg-white text-secondary">07:30AM</td>
                                    <td class="bg-white text-secondary">07:30AM</td>
                                </tr>
                                <tr>
                                    <td class="bg-white text-dark">45</td>
                                    <td class="bg-white text-secondary">07:45AM</td>
                                    <td class="bg-white text-secondary">07:45AM</td>
                                    <td rowspan="2" class="bg-white text-white">
                                        <div class="bg-primary m-0 rounded">
                                            <b>username</b>: benhnhan1<br/>
                                            <b class="text-white">Nguyễn Bệnh Nhân</b><br/>
                                            <i>Xét nghiệm (30 phút)</i>
                                        </div>
                                    </td>
                                    <td class="bg-white text-secondary">07:45AM</td>
                                    <td class="bg-white text-secondary">07:45AM</td>
                                    <td class="bg-white text-secondary">07:45AM</td>
                                </tr>
                                <tr>
                                    <td class="bg-white text-dark">60</td>
                                    <td class="bg-white text-secondary">08:00AM</td>
                                    <td class="bg-white text-secondary">08:00AM</td>
                                    <td class="bg-white text-secondary">08:00AM</td>
                                    <td class="bg-white text-secondary">08:00AM</td>
                                    <td class="bg-white text-secondary">08:00AM</td>
                                </tr>
                                <tr>
                                    <td class="bg-light text-dark">08:00AM</td>
                                    <td class="bg-light text-secondary">08:00AM</td>
                                    <td class="bg-light text-secondary">08:00AM</td>
                                    <td class="bg-light text-secondary">08:00AM</td>
                                    <td class="bg-light text-secondary">08:00AM</td>
                                    <td class="bg-light text-secondary">08:00AM</td>
                                    <td class="bg-light text-secondary">08:00AM</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <!--End main content-->
        </div>
        <!--Import js lib-->
        <script src="../assets/scripts/jquery-3.6.0.min.js" type="text/javascript"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="../assets/scripts/jquery-ui.min.js" type="text/javascript"></script>
        <!--Import js code-->
        <script>
            $("#datepicker").datepicker({
                changeMonth: true,
                changeYear: true,
                maxDate: '+7D',
            });
        </script>
    </body>
</html>
