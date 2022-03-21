<!--
 * Copyright(C) 20022, FPT University
 * CMS:
 * Clinic Management System
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-28      1.0                 TrangCT          Post Detail
-->
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="./assets/css/style.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="../assets/styles/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <link href="../assets/styles/jquery-ui.structure.min.css" rel="stylesheet" type="text/css"/>
        <link href="../assets/styles/jquery-ui.theme.min.css" rel="stylesheet" type="text/css"/>
        <title>Clinic Management</title>
        <link href="./assets/css/header.css" rel="stylesheet" type="text/css"/>
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
        .card{
            padding:20px;
        }
        #images{
            border-radius: 50%;
            width: 140px;
            height: 140px;
            margin: 0 auto;
        }
        .card{
            text-align: center;
        }
        h5{
            margin-left: 45px;
        }
        .content-page img{
            width: 100%;
            margin-top: 20px;
        }
        .content-infor{
            margin-left: 200px;
            margin-right: 200px;
        }
        .col-4 img{
            height: 400px;
        }
    </style>
    <header>
        <%--<jsp:include page="./components/customerHeader.jsp" />--%>
    </header>
    <body>
        <div class="container-fluid m-0 p-0">
            <div id="layoutSidenav_content">
                <div class="row-fluid mb-3">
                    <img class="col-lg-12 p-0" src="./assets/images/banner.jpg" alt="Banner"/>
                </div>
                <div class="container-fluid mt-3">
                    <div>
                        <h5 >D?ch v? c?a chï¿½ng tï¿½i</h5>
                    </div>
                    <div class="d-flex justify-content-around mt-3">
                        <div class="card" style="width: 18rem;">
                            <img id="images" class="card-img-top" src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/bac-si_02156a3d_6d43_476f_8d12_7d10e6d3795e.png" alt="Card image cap">
                            <div class="card-body">
                                <h5 class="card-title">Bï¿½c s?</h5>
                                <p class="card-text">??t khï¿½m tr?c ti?p t?i ??i ng? bï¿½c s? c?a ISOFHCARE cï¿½ trï¿½nh ?? chuyï¿½n mï¿½n cao, nhi?u n?m kinh nghi?m, giï¿½u y ??c, giï¿½p b?n hoï¿½n toï¿½n ch? ??ng l?a ch?n th?i gian khï¿½m.</p>
                            </div>
                        </div>
                        <div class="card" style="width: 18rem;">
                            <img id="images" class="card-img-top" src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/benh-vien_3af5757b_be9b_4a39_9948_6d2062b72316.png" alt="Card image cap">
                            <div class="card-body">
                                <h5 class="card-title">B?nh vi?n</h5>
                                <p class="card-text">??t khï¿½m theo gï¿½i d?ch v? ch?t l??ng, d?ch v? xï¿½t nghi?m vï¿½ ch?n ?oï¿½n hï¿½nh ?nh hi?n ??i t?i t? cï¿½c ??i tï¿½c b?nh vi?n hï¿½ng ??u, tuy?n Trung ??ng c?a ISOFHCARE.</p>
                            </div>
                        </div>
                        <div class="card" style="width: 18rem;">
                            <img id="images" class="card-img-top" src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/cam-nang_9ec6df99_ba08_4015_b679_2459308c5e26.png" alt="Card image cap">
                            <div class="card-body">
                                <h5 class="card-title">C?m nang</h5>
                                <p class="card-text">V?i l??ng bï¿½i ??ng phong phï¿½, chuyï¿½n m?c C?m nang y t? cung c?p cho b?n nhi?u ki?n th?c b? ï¿½ch v? s?c kh?e, mang tï¿½nh th?c ti?n ï¿½p d?ng vï¿½o.</p>
                            </div>
                        </div>
                        <div class="card" style="width: 18rem;">
                            <img id="images" class="card-img-top" src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/cong-dong_15c2ee3e_0448_4635_ac97_645a84969848.png" alt="Card image cap">
                            <div class="card-body">
                                <h5 class="card-title">C?ng ??ng</h5>
                                <p class="card-text">C?ng ??ng y t? ?ï¿½ng ??o v?i s? tham gia c?a cï¿½c bï¿½c s? ??u ngï¿½nh t?i t? nhi?u l?nh v?c, h? tr? gi?i ?ï¿½p cï¿½c th?c m?c c?a b?n trong m?i khï¿½a c?nh s?c kh?e.</p>
                            </div>
                        </div>
                        <div class="card" style="width: 18rem;">
                            <img id="images" class="card-img-top" src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/bac-si_02156a3d_6d43_476f_8d12_7d10e6d3795e.png" alt="Card image cap">
                            <div class="card-body">
                                <h5 class="card-title">Bï¿½c s?</h5>
                                <p class="card-text">??t khï¿½m tr?c ti?p t?i ??i ng? bï¿½c s? c?a ISOFHCARE cï¿½ trï¿½nh ?? chuyï¿½n mï¿½n cao, nhi?u n?m kinh nghi?m, giï¿½u y ??c, giï¿½p b?n hoï¿½n toï¿½n ch? ??ng l?a ch?n th?i gian khï¿½m.</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="content-page">
                    <img src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/kit-test-nhanh-covid-tai-nha-isofhcare-jpg_99fa2328_f5d7_4eb8_8561_ae5a4c49c9be.png"/>
                </div>
                <div class="content-infor mt-5">
                    <div class="row container-fluid">
                        <div class="col-4">
                            <p class="font-weight-bold">Bï¿½c s? n?i b?t</p>
                            <br>
                            <p>xxxxx</p>
                            <img src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/bac-si-noi-bat_3aafb5a5_e84b_4be0_bf87_4689b981e5d7.png">
                        </div>
                        <div class="col-8 d-flex justify-content-around">
                            <div class="card" style="width: 18rem;">
                                <img id="images" class="card-img-top" src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/bac-si_02156a3d_6d43_476f_8d12_7d10e6d3795e.png" alt="Card image cap">
                                <div class="card-body">
                                    <h5 class="card-title">xxxx
                                    <p class="card-text">x.</p>
                                </div>
                            </div>
                            <div class="card" style="width: 18rem;">
                                <img id="images" class="card-img-top" src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/bac-si_02156a3d_6d43_476f_8d12_7d10e6d3795e.png" alt="Card image cap">
                                <div class="card-body">
                                    <h5 class="card-title">Bï¿½c s?</h5>
                                    <p class="card-text">??t khï¿½m tr?c ti?p t?i ??i ng? bï¿½c s? c?a ISOFHCARE cï¿½ trï¿½nh ?? chuyï¿½n mï¿½n cao, nhi?u n?m kinh nghi?m, giï¿½u y ??c, giï¿½p b?n hoï¿½n toï¿½n ch? ??ng l?a ch?n th?i gian khï¿½m.</p>
                                </div>
                            </div>
                            <div class="card" style="width: 18rem;">
                                <img id="images" class="card-img-top" src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/bac-si_02156a3d_6d43_476f_8d12_7d10e6d3795e.png" alt="Card image cap">
                                <div class="card-body">
                                    <h5 class="card-title">Bï¿½c s?</h5>
                                    <p class="card-text">gian khï¿½m.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row-fluid my-5">
                        <div class="col-lg-12"></div>
                        <h1>Tin Tức</h1>
                        <div class="row d-flex justify-content-center my-1">
                            <h2>${post.title}</h2>
                        </div>
                        <div class="row border-dark my-1">
                            ${post.summary}
                        </div>
                        <div class="row d-flex justify-content-start">
                            <b><i>${user} : ${post.createDate} : ${post.createTime}</i></b>
                        </div>
                        <div class="row d-flex justify-content-end">
                            <p>${post.content}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <footer>
        <jsp:include page="./components/footer.jsp" />
    </footer>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script src="./assets/js/scripts.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
    <script src="./assets/demo/chart-area-demo.js"></script>
    <script src="./assets/demo/chart-bar-demo.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
    <script src="./assets/js/datatables-simple-demo.js"></script>
</html>
