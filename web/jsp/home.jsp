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
        <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Dashboard - SB Admin</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="./assets/css/home.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
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
        .card-img-top1{
            height: 210px !important;
        }
        .col-8 .card{
            margin-left: 20px;
        }
    </style>
    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="index.html">Start Bootstrap</a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                <div class="input-group">
                    <input class="form-control" type="text" placeholder="Search for..." aria-label="Search for..." aria-describedby="btnNavbarSearch" />
                    <button class="btn btn-primary" id="btnNavbarSearch" type="button"><i class="fas fa-search"></i></button>
                </div>
            </form>
            <!-- Navbar-->
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#!">Settings</a></li>
                        <li><a class="dropdown-item" href="#!">Activity Log</a></li>
                         <li><a class="dropdown-item" href="./jsp/user_profile.jsp">Profile</a></li>
                        <li><hr class="dropdown-divider" /></li>
                        <li><a class="dropdown-item" href="../ClinicManagement/LogoutController">Logout</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">Core</div>
                            <a class="nav-link" href="index.html">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                Dashboard
                            </a>
                            <div class="sb-sidenav-menu-heading">Interface</div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Layouts
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="layout-static.html">Static Navigation</a>
                                    <a class="nav-link" href="layout-sidenav-light.html">Light Sidenav</a>
                                </nav>
                            </div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                                <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                                Pages
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseAuth" aria-expanded="false" aria-controls="pagesCollapseAuth">
                                        Authentication
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="pagesCollapseAuth" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="login.html">Login</a>
                                            <a class="nav-link" href="register.html">Register</a>
                                            <a class="nav-link" href="password.html">Forgot Password</a>
                                        </nav>
                                    </div>
                                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseError" aria-expanded="false" aria-controls="pagesCollapseError">
                                        Error
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="pagesCollapseError" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="401.html">401 Page</a>
                                            <a class="nav-link" href="404.html">404 Page</a>
                                            <a class="nav-link" href="500.html">500 Page</a>
                                        </nav>
                                    </div>
                                </nav>
                            </div>
                            <div class="sb-sidenav-menu-heading">Addons</div>
                            <a class="nav-link" href="charts.html">
                                <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                                Charts
                            </a>
                            <a class="nav-link" href="tables.html">
                                <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                                Tables
                            </a>
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Logged in as:</div>
                        Start Bootstrap
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="content text-white ">
                <h2>Tìm bác sĩ, bệnh viện dễ dàng hơn</h2>
                <p>Chủ động đặt lịch hẹn thông minh và được chăm sóc tận tình</p>
                <input type="text" placeholder="Nhập tên bác sĩ, bệnh viện, dịch vụ?">
        </div>
        <div class="container-fluid mt-3">
            <div>
                <h5 >Dịch vụ của chúng tôi</h5>
            </div>
            <div class="d-flex justify-content-around mt-3">
            <div class="card" style="width: 18rem;">
  <img class="card-img-top" src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/bac-si_02156a3d_6d43_476f_8d12_7d10e6d3795e.png" alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title">Bác sĩ</h5>
    <p class="card-text">Đặt khám trực tiếp tới đội ngũ bác sĩ của ISOFTCARE có trình độ chuyên môn cao, nhiều năm kinh nghiệm, giàu y đức, giúp bạn hoàn toàn chủ động lựa chọn thời gian khám.</p>
  </div>
</div>
              <div class="card" style="width: 18rem;">
  <img class="card-img-top" src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/benh-vien_3af5757b_be9b_4a39_9948_6d2062b72316.png" alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title">Bệnh viện</h5>
    <p class="card-text">Đặt khám theo gói dịch vụ chất lượng, dịch vụ xét nghiệm và chuẩn đoán hình ảnh hiện đại tới từ các đối tác bệnh viện hàng đầu ,tuyến Trung Ương của ISOFTCARE.</p>
  </div>
</div>
              <div class="card" style="width: 18rem;">
  <img class="card-img-top" src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/cam-nang_9ec6df99_ba08_4015_b679_2459308c5e26.png" alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title">Cẩm nang</h5>
    <p class="card-text">Với lượng bài đăng phong phú, chuyên mục Cẩm nang y tế cung cấp cho bạn nhiều kiến thức bổ ích về sức khỏe, mang tính thực tiễn áp dụng vào.</p>
  </div>
</div>
              <div class="card" style="width: 18rem;">
  <img class="card-img-top" src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/cong-dong_15c2ee3e_0448_4635_ac97_645a84969848.png" alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title">Cộng đồng</h5>
    <p class="card-text">Cộng đồng y tế đông đảo với sự tham gia của các bác sĩ đầu ngành tới từ nhiều lĩnh vực, hỗ trợ giải đáp các thắc mắc của bạn trong mọi khía cạnh sức khỏe.</p>
  </div>
</div>
                <div class="card" style="width: 18rem;">
  <img class="card-img-top" src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/bac-si_02156a3d_6d43_476f_8d12_7d10e6d3795e.png" alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title">Bác sĩ</h5>
    <p class="card-text">Đặt khám trực tiếp tới đội ngũ bác sĩ của ISOFTCARE có trình độ chuyên môn cao, nhiều năm kinh nghiệm, giàu y đức, giúp bạn hoàn toàn chủ động lựa chọn thời gian khám.</p>
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
                    <h3>Bác sĩ nổi bật</h3>
                    <br>
                    <p>Đặt khám trực tiếp tới đội ngũ bác sĩ của ISOFHCARE có trình độ chuyên môn cao, nhiều năm kinh nghiệm, giàu y đức, giúp bạn hoàn toàn chủ động lựa chọn thời gian khám</p>
                    <img src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/bac-si-noi-bat_3aafb5a5_e84b_4be0_bf87_4689b981e5d7.png">
                </div>
                <div class="col-8 d-flex justify-content-around">
                    <div class="card" style="width: 18rem;">
  <img class="card-img-top1" src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/bac-si_02156a3d_6d43_476f_8d12_7d10e6d3795e.png" alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title">Bác sĩ</h5>
    <p class="card-text">Đặt khám trực tiếp tới đội ngũ bác sĩ của ISOFTCARE có trình độ chuyên môn cao, nhiều năm kinh nghiệm, giàu y đức, giúp bạn hoàn toàn chủ động lựa chọn thời gian khám.</p>
  </div>
</div>
                    <div class="card" style="width: 18rem;">
  <img class="card-img-top1" src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/bac-si_02156a3d_6d43_476f_8d12_7d10e6d3795e.png" alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title">Bác sĩ</h5>
    <p class="card-text">Đặt khám trực tiếp tới đội ngũ bác sĩ của ISOFTCARE có trình độ chuyên môn cao, nhiều năm kinh nghiệm, giàu y đức, giúp bạn hoàn toàn chủ động lựa chọn thời gian khám.</p>
  </div>
</div>
                    <div class="card" style="width: 18rem;">
  <img class="card-img-top1" src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/bac-si_02156a3d_6d43_476f_8d12_7d10e6d3795e.png" alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title">Bác sĩ</h5>
    <p class="card-text">Đặt khám trực tiếp tới đội ngũ bác sĩ của ISOFTCARE có trình độ chuyên môn cao, nhiều năm kinh nghiệm, giàu y đức, giúp bạn hoàn toàn chủ động lựa chọn thời gian khám.</p>
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
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="./assets/js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="./assets/demo/chart-area-demo.js"></script>
        <script src="./assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="./assets/js/datatables-simple-demo.js"></script>
    </body>
</html>
