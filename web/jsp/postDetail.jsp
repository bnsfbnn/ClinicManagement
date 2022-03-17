<!--
 * Copyright(C) 20022, FPT University
 * CMS:
 * Clinic Management System
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-23      1.0                 NamNV          First Implement 
-->
<!DOCTYPE html>
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
        <jsp:include page="./components/customerHeader.jsp" />
    </header>
    <body>
        <div class="container-fluid m-0 p-0">
            <div id="layoutSidenav_content">
                <div class="row-fluid mb-3">
                    <img class="col-lg-12 p-0" src="./assets/images/banner.jpg" alt="Banner"/>
                </div>
                <div class="container-fluid mt-3">
                    <div>
                        <h5 >D?ch v? c?a ch�ng t�i</h5>
                    </div>
                    <div class="d-flex justify-content-around mt-3">
                        <div class="card" style="width: 18rem;">
                            <img id="images" class="card-img-top" src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/bac-si_02156a3d_6d43_476f_8d12_7d10e6d3795e.png" alt="Card image cap">
                            <div class="card-body">
                                <h5 class="card-title">B�c s?</h5>
                                <p class="card-text">??t kh�m tr?c ti?p t?i ??i ng? b�c s? c?a ISOFHCARE c� tr�nh ?? chuy�n m�n cao, nhi?u n?m kinh nghi?m, gi�u y ??c, gi�p b?n ho�n to�n ch? ??ng l?a ch?n th?i gian kh�m.</p>
                            </div>
                        </div>
                        <div class="card" style="width: 18rem;">
                            <img id="images" class="card-img-top" src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/benh-vien_3af5757b_be9b_4a39_9948_6d2062b72316.png" alt="Card image cap">
                            <div class="card-body">
                                <h5 class="card-title">B?nh vi?n</h5>
                                <p class="card-text">??t kh�m theo g�i d?ch v? ch?t l??ng, d?ch v? x�t nghi?m v� ch?n ?o�n h�nh ?nh hi?n ??i t?i t? c�c ??i t�c b?nh vi?n h�ng ??u, tuy?n Trung ??ng c?a ISOFHCARE.</p>
                            </div>
                        </div>
                        <div class="card" style="width: 18rem;">
                            <img id="images" class="card-img-top" src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/cam-nang_9ec6df99_ba08_4015_b679_2459308c5e26.png" alt="Card image cap">
                            <div class="card-body">
                                <h5 class="card-title">C?m nang</h5>
                                <p class="card-text">V?i l??ng b�i ??ng phong ph�, chuy�n m?c C?m nang y t? cung c?p cho b?n nhi?u ki?n th?c b? �ch v? s?c kh?e, mang t�nh th?c ti?n �p d?ng v�o.</p>
                            </div>
                        </div>
                        <div class="card" style="width: 18rem;">
                            <img id="images" class="card-img-top" src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/cong-dong_15c2ee3e_0448_4635_ac97_645a84969848.png" alt="Card image cap">
                            <div class="card-body">
                                <h5 class="card-title">C?ng ??ng</h5>
                                <p class="card-text">C?ng ??ng y t? ?�ng ??o v?i s? tham gia c?a c�c b�c s? ??u ng�nh t?i t? nhi?u l?nh v?c, h? tr? gi?i ?�p c�c th?c m?c c?a b?n trong m?i kh�a c?nh s?c kh?e.</p>
                            </div>
                        </div>
                        <div class="card" style="width: 18rem;">
                            <img id="images" class="card-img-top" src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/bac-si_02156a3d_6d43_476f_8d12_7d10e6d3795e.png" alt="Card image cap">
                            <div class="card-body">
                                <h5 class="card-title">B�c s?</h5>
                                <p class="card-text">??t kh�m tr?c ti?p t?i ??i ng? b�c s? c?a ISOFHCARE c� tr�nh ?? chuy�n m�n cao, nhi?u n?m kinh nghi?m, gi�u y ??c, gi�p b?n ho�n to�n ch? ??ng l?a ch?n th?i gian kh�m.</p>
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
                            <p class="font-weight-bold">B�c s? n?i b?t</p>
                            <br>
                            <p>??t kh�m tr?c ti?p t?i ??i ng? b�c s? c?a ISOFHCARE c� tr�nh ?? chuy�n m�n cao, nhi?u n?m kinh nghi?m, gi�u y ??c, gi�p b?n ho�n to�n ch? ??ng l?a ch?n th?i gian kh�m</p>
                            <img src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/bac-si-noi-bat_3aafb5a5_e84b_4be0_bf87_4689b981e5d7.png">
                        </div>
                        <div class="col-8 d-flex justify-content-around">
                            <div class="card" style="width: 18rem;">
                                <img id="images" class="card-img-top" src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/bac-si_02156a3d_6d43_476f_8d12_7d10e6d3795e.png" alt="Card image cap">
                                <div class="card-body">
                                    <h5 class="card-title">B�c s?</h5>
                                    <p class="card-text">??t kh�m tr?c ti?p t?i ??i ng? b�c s? c?a ISOFHCARE c� tr�nh ?? chuy�n m�n cao, nhi?u n?m kinh nghi?m, gi�u y ??c, gi�p b?n ho�n to�n ch? ??ng l?a ch?n th?i gian kh�m.</p>
                                </div>
                            </div>
                            <div class="card" style="width: 18rem;">
                                <img id="images" class="card-img-top" src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/bac-si_02156a3d_6d43_476f_8d12_7d10e6d3795e.png" alt="Card image cap">
                                <div class="card-body">
                                    <h5 class="card-title">B�c s?</h5>
                                    <p class="card-text">??t kh�m tr?c ti?p t?i ??i ng? b�c s? c?a ISOFHCARE c� tr�nh ?? chuy�n m�n cao, nhi?u n?m kinh nghi?m, gi�u y ??c, gi�p b?n ho�n to�n ch? ??ng l?a ch?n th?i gian kh�m.</p>
                                </div>
                            </div>
                            <div class="card" style="width: 18rem;">
                                <img id="images" class="card-img-top" src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/bac-si_02156a3d_6d43_476f_8d12_7d10e6d3795e.png" alt="Card image cap">
                                <div class="card-body">
                                    <h5 class="card-title">B�c s?</h5>
                                    <p class="card-text">??t kh�m tr?c ti?p t?i ??i ng? b�c s? c?a ISOFHCARE c� tr�nh ?? chuy�n m�n cao, nhi?u n?m kinh nghi?m, gi�u y ??c, gi�p b?n ho�n to�n ch? ??ng l?a ch?n th?i gian kh�m.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row-fluid my-5">
                        <div class="col-lg-12"></div>
                        <h1>Tin T?c</h1>
                       
                        <div class="row d-flex justify-content-center my-1">
                            <h2>BV H?NG NG?C K� K?T BI�N B?N H?P T�C V?I ?SQ H�N QU?C, HI?P H?I NG??I H�N T?I H� N?I V? VI?C H? TR? Y T? CHO B?NH NH�N H�N QU?C M?C COVID-19</h2>
                        </div>
                        <div class="row border-dark my-1">
                            
                        </div>
                        <div class="row d-flex justify-content-start">
                            <b><i>Nguy?n V?n B - 2022-19-10 07:00:00</i></b>
                        </div>
                        <div class="row d-flex justify-content-end">
                            <p>BV H?NG NG?C K� K?T BI�N B?N H?P T�C V?I ?SQ H�N QU?C, HI?P H?I NG??I H�N T?I H� N?I V? VI?C H? TR? Y T? CHO B?NH NH�N H�N QU?C M?C COVID-19</p>
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
