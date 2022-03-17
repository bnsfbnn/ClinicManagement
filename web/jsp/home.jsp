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
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Clinic Management</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="./assets/css/home.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
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
        .container-fluid img{
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
                <main>
                    <div class="content text-white ">
                        <h2>Tìm bác s?, b?nh vi?n d? dàng h?n</h2>
                        <p>Ch? ??ng ??t l?ch h?n thông minh và ???c ch?m sóc t?n tình</p>
                        <input type="text" placeholder="Nh?p tên bác s?, b?nh vi?n, d?ch v?">
                    </div>
                    <div class="container-fluid mt-3">
                        <div>
                            <h5 >D?ch v? c?a chúng tôi</h5>
                        </div>
                        <div class="d-flex justify-content-around mt-3">
                            <div class="card" style="width: 18rem;">
                                <img class="card-img-top" src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/bac-si_02156a3d_6d43_476f_8d12_7d10e6d3795e.png" alt="Card image cap">
                                <div class="card-body">
                                    <h5 class="card-title">Bác s?</h5>
                                    <p class="card-text">??t khám tr?c ti?p t?i ??i ng? bác s? c?a ISOFHCARE có trình ?? chuyên môn cao, nhi?u n?m kinh nghi?m, giàu y ??c, giúp b?n hoàn toàn ch? ??ng l?a ch?n th?i gian khám.</p>
                                </div>
                            </div>
                            <div class="card" style="width: 18rem;">
                                <img class="card-img-top" src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/benh-vien_3af5757b_be9b_4a39_9948_6d2062b72316.png" alt="Card image cap">
                                <div class="card-body">
                                    <h5 class="card-title">B?nh vi?n</h5>
                                    <p class="card-text">??t khám theo gói d?ch v? ch?t l??ng, d?ch v? xét nghi?m và ch?n ?oán hình ?nh hi?n ??i t?i t? các ??i tác b?nh vi?n hàng ??u, tuy?n Trung ??ng c?a ISOFHCARE.</p>
                                </div>
                            </div>
                            <div class="card" style="width: 18rem;">
                                <img class="card-img-top" src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/cam-nang_9ec6df99_ba08_4015_b679_2459308c5e26.png" alt="Card image cap">
                                <div class="card-body">
                                    <h5 class="card-title">C?m nang</h5>
                                    <p class="card-text">V?i l??ng bài ??ng phong phú, chuyên m?c C?m nang y t? cung c?p cho b?n nhi?u ki?n th?c b? ích v? s?c kh?e, mang tính th?c ti?n áp d?ng vào.</p>
                                </div>
                            </div>
                            <div class="card" style="width: 18rem;">
                                <img class="card-img-top" src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/cong-dong_15c2ee3e_0448_4635_ac97_645a84969848.png" alt="Card image cap">
                                <div class="card-body">
                                    <h5 class="card-title">C?ng ??ng</h5>
                                    <p class="card-text">C?ng ??ng y t? ?ông ??o v?i s? tham gia c?a các bác s? ??u ngành t?i t? nhi?u l?nh v?c, h? tr? gi?i ?áp các th?c m?c c?a b?n trong m?i khía c?nh s?c kh?e.</p>
                                </div>
                            </div>
                            <div class="card" style="width: 18rem;">
                                <img class="card-img-top" src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/bac-si_02156a3d_6d43_476f_8d12_7d10e6d3795e.png" alt="Card image cap">
                                <div class="card-body">
                                    <h5 class="card-title">Bác s?</h5>
                                    <p class="card-text">??t khám tr?c ti?p t?i ??i ng? bác s? c?a ISOFHCARE có trình ?? chuyên môn cao, nhi?u n?m kinh nghi?m, giàu y ??c, giúp b?n hoàn toàn ch? ??ng l?a ch?n th?i gian khám.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="content-page">
                        <img src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/kit-test-nhanh-covid-tai-nha-isofhcare-jpg_99fa2328_f5d7_4eb8_8561_ae5a4c49c9be.png"
                    </div>
                    <div class="content-infor mt-5">
                        <div class="row container-fluid">
                            <div class="col-4">
                                <p class="font-weight-bold">Bác s? n?i b?t</p>
                                <br>
                                <p>??t khám tr?c ti?p t?i ??i ng? bác s? c?a ISOFHCARE có trình ?? chuyên môn cao, nhi?u n?m kinh nghi?m, giàu y ??c, giúp b?n hoàn toàn ch? ??ng l?a ch?n th?i gian khám</p>
                                <img src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/bac-si-noi-bat_3aafb5a5_e84b_4be0_bf87_4689b981e5d7.png">
                            </div>
                            <div class="col-8 d-flex justify-content-around">
                                <div class="card" style="width: 18rem;">
                                    <img class="card-img-top" src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/bac-si_02156a3d_6d43_476f_8d12_7d10e6d3795e.png" alt="Card image cap">
                                    <div class="card-body">
                                        <h5 class="card-title">Bác s?</h5>
                                        <p class="card-text">??t khám tr?c ti?p t?i ??i ng? bác s? c?a ISOFHCARE có trình ?? chuyên môn cao, nhi?u n?m kinh nghi?m, giàu y ??c, giúp b?n hoàn toàn ch? ??ng l?a ch?n th?i gian khám.</p>
                                    </div>
                                </div>
                                <div class="card" style="width: 18rem;">
                                    <img class="card-img-top" src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/bac-si_02156a3d_6d43_476f_8d12_7d10e6d3795e.png" alt="Card image cap">
                                    <div class="card-body">
                                        <h5 class="card-title">Bác s?</h5>
                                        <p class="card-text">??t khám tr?c ti?p t?i ??i ng? bác s? c?a ISOFHCARE có trình ?? chuyên môn cao, nhi?u n?m kinh nghi?m, giàu y ??c, giúp b?n hoàn toàn ch? ??ng l?a ch?n th?i gian khám.</p>
                                    </div>
                                </div>
                                <div class="card" style="width: 18rem;">
                                    <img class="card-img-top" src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/bac-si_02156a3d_6d43_476f_8d12_7d10e6d3795e.png" alt="Card image cap">
                                    <div class="card-body">
                                        <h5 class="card-title">Bác s?</h5>
                                        <p class="card-text">??t khám tr?c ti?p t?i ??i ng? bác s? c?a ISOFHCARE có trình ?? chuyên môn cao, nhi?u n?m kinh nghi?m, giàu y ??c, giúp b?n hoàn toàn ch? ??ng l?a ch?n th?i gian khám.</p>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2021</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script src="./assets/js/scripts.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
    <script src="./assets/demo/chart-area-demo.js"></script>
    <script src="./assets/demo/chart-bar-demo.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
    <script src="./assets/js/datatables-simple-demo.js"></script>
</body>
</html>
