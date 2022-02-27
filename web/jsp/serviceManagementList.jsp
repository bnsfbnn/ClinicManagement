

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Service</title>
        <link href="./assets/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.2/css/all.css" />
        <link href="./assets/themes/krajee-fas/theme.css" media="all" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="./assets/css/select2.min.css" />
        <link rel="stylesheet" href="./assets/css/select2-bootstrap-5-theme.min.css" />
        <link rel="stylesheet" href="./assets/css/custom.css" />
        <link href="./assets/css/header.css" rel="stylesheet" type="text/css"/>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <!-- Bootstrap Icon -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
        <link rel="stylesheet" href="./assets/service/style.css">
    </head>
    <body>
        <div class="container" id="service-container">
            <!-- Header -->
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarClinicHeader" aria-controls="navbarClinicHeader" aria-expanded="false"
                            aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarClinicHeader">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="nav-link" aria-current="page" href="#">Trang chủ</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" href="#">Quản lý dịch vụ</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Quản lý phản hồi</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link p-0" href="#">Xem tất cả lịch khám bệnh</a>
                            </li>
                        </ul>
                        <div class="avatar">
                            <img src="https://gw.alipayobjects.com/zos/rmsportal/BiazfanxmamNRoxxVxka.png" alt="avatar">
                        </div>
                    </div>
                </div>
            </nav>

            <h1 id="title">
                Dach sách dịch vụ
            </h1>

            <div class="wrapper">
                <button id="add-btn" type="button" class="btn btn-light mb-3" data-bs-toggle="modal"
                        data-bs-target="#addServiceModal">
                    <i class="bi bi-plus-circle-fill"></i>
                    Thêm dịch vụ
                </button>

                <!-- Table -->
                <table class="table table-bordered align-middle" id="table-services">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Mã ID</th>
                            <th scope="col">Tên dịch vụ</th>
                            <th scope="col">Tóm tắt dịch vụ</th>
                            <th scope="col">Thao tác</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${services.data}" var="service"  varStatus="counter" >
                            <tr>
                                <th scope="row">${counter.count}</th>
                                <td>${service.serviceId}</td>
                                <td>${service.serviceName}</td>
                                <td class="service-desc">${service.serviceBrief}</td>
                                <td>
                                    <div class="action">
                                        <button class="btn-only-ic" data-bs-target="#detailServiceModal">
                                            <a href="ServiceManagementDetailController?Id=${service.serviceId}" class="bi bi-eye-fill"></a>
                                        </button>
                                        <button class="btn-only-ic" data-bs-toggle="modal" data-bs-target="#editServiceModal">
                                            <i class="bi bi-pencil-fill"></i>

                                        </button>
                                        <button class="btn-only-ic" data-bs-toggle="modal" data-bs-target="#deleteServiceModal">
                                            <i class="bi bi-trash-fill"></i>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>

                    </tbody>
                </table>

                <!-- Pagination -->
                <div class="pagi-wrapper">
                    <c:if test="${services.totalPage > 1}">
                        <div class="row">
                            <div class="col-12 text-center">
                                <ul>
                                    <c:if test="${services.currentPage > 1}">
                                        <a class="btn btn-light" href="${requestScope['javax.servlet.forward.request_uri']}?page=${restaurants.currentPage-1}">Trang trước</a>
                                    </c:if>
                                    <c:forEach var="pageNumber" begin="1" end="${services.totalPage}" step="1">
                                        <c:if test="${services.currentPage == pageNumber}">
                                            <a class="btn btn-success" href="#">${pageNumber}</a>
                                        </c:if>
                                        <c:if test="${services.currentPage != pageNumber}">
                                            <a class="btn btn-light" href="${requestScope['javax.servlet.forward.request_uri']}?page=${pageNumber}">${pageNumber}</a>
                                        </c:if>
                                    </c:forEach>
                                    <c:if test="${services.currentPage < services.totalPage}">
                                        <a class="btn btn-light" href="${requestScope['javax.servlet.forward.request_uri']}?page=${services.currentPage+1}">Trang sau</a>
                                    </c:if>
                                </ul>
                            </div>
                        </div>
                    </c:if>
                </div>

                <!-- Detail Service Modal -->
                <div class="modal fade" id="detailServiceModal" data-bs-keyboard="false" tabindex="-1" aria-hidden="true">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <div class="non-block"></div>
                                <h5 class="modal-title" id="staticBackdropLabel">Chi tiết dịch vụ</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <div class="container-fluid">
                                    <form class="row g-3">
                                        <div class="pe-5 col-6">
                                            <div class="row mb-3">
                                                <label for="serviceCode" class="col-4 col-form-label">Mã dịch vụ</label>
                                                <div class="col-8">
                                                    <span class="form-control-plaintext">
                                                        SVCS001
                                                    </span>
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <label for="serviceName" class="col-4 col-form-label">Tên dịch vụ</label>
                                                <div class="col-8">
                                                    <span class="desc-text form-control-plaintext">
                                                        Chuyên khoa mắt
                                                    </span>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <label for="serviceDesc" class="col-4 col-form-label">Mô tả</label>
                                                <div class="col-8">
                                                    <span class="form-control-plaintext">
                                                        Cung cấp dịch vụ khám và điều trị toàn diện các bệnh lý về mắt
                                                        asdasd
                                                    </span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="ps-5 col-6">
                                            <div class="row">
                                                <div class="col-7 col-form-label">
                                                    Bác sĩ
                                                </div>
                                            </div>
                                            <div class="row list-doctors">
                                                <div class="list-doctors-scroll">

                                                    <div class="doctor-card px-0">
                                                        <div class="img-cover">
                                                            <img src="https://via.placeholder.com/60" alt="">
                                                        </div>
                                                        <div class="d-flex flex-column my-2 mx-4">
                                                            Nguyễn Bác Sĩ
                                                            username: bacsing
                                                        </div>
                                                    </div>

                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Add Service Modal -->
                <div class="modal fade" id="addServiceModal" data-bs-keyboard="false" tabindex="-1"
                     aria-labelledby="staticBackdropLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <div class="non-block"></div>
                                <h5 class="modal-title" id="staticBackdropLabel">Thêm dịch vụ</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <div class="container-fluid">
                                    <form class="row g-3">
                                        <div class="pe-5 col-6">
                                            <div class="row mb-3">
                                                <label for="serviceCode" class="col-4 col-form-label">Mã dịch vụ</label>
                                                <div class="col-8">
                                                    <input type="text" class="form-control" name="service_code"
                                                           id="serviceCode" placeholder="SVCS999">
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <label for="serviceName" class="col-4 col-form-label">Tên dịch vụ</label>
                                                <div class="col-8">
                                                    <input type="text" class="form-control" name="service_name"
                                                           id="serviceName" placeholder="Chuyên khoa mắt">
                                                </div>
                                            </div>
                                            <div class="row">
                                                <label for="serviceDesc" class="col-4 col-form-label">Mô tả</label>
                                                <div class="col-8">
                                                    <textarea class="form-control" name="service_desc" id="serviceDesc"
                                                              rows="3"></textarea>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="ps-5 col-6">
                                            <div class="row">
                                                <div class="col-7 col-form-label">
                                                    Bác sĩ
                                                </div>
                                                <button id="add-btn" type="button" class="btn btn-light col-5"
                                                        data-bs-toggle="modal" data-bs-target="#selectDoctorModal"
                                                        data-bs-select="add">
                                                    Thêm bác sĩ
                                                    <i class="bi bi-plus-circle-fill ms-1"></i>
                                                </button>
                                            </div>
                                            <div class="row list-doctors">
                                                <div class="list-doctors-scroll">
                                                    <div class="doctor-card px-0">
                                                        <div class="img-cover">
                                                            <img src="https://via.placeholder.com/60" alt="">
                                                        </div>
                                                        <div class="d-flex flex-column my-2 mx-3">
                                                            <span>Nguyễn Bác Sĩ</span>
                                                            <span>username: bacsing</span>
                                                        </div>
                                                        <button class="btn-only-ic" data-bs-toggle="modal"
                                                                data-bs-target="#deleteDoctorModal" data-bs-delete="add">
                                                            <i class="bi bi-dash-circle-fill"></i>
                                                        </button>
                                                    </div>
                                                    <div class="doctor-card px-0">
                                                        <div class="img-cover">
                                                            <img src="https://via.placeholder.com/60" alt="">
                                                        </div>
                                                        <div class="d-flex flex-column my-2 mx-3">
                                                            <span>Nguyễn Bác Sĩ</span>
                                                            <span>username: bacsing</span>
                                                        </div>
                                                        <button class="btn-only-ic" data-bs-toggle="modal"
                                                                data-bs-target="#deleteDoctorModal" data-bs-delete="add">
                                                            <i class="bi bi-dash-circle-fill"></i>
                                                        </button>
                                                    </div>
                                                    <div class="doctor-card px-0">
                                                        <div class="img-cover">
                                                            <img src="https://via.placeholder.com/60" alt="">
                                                        </div>
                                                        <div class="d-flex flex-column my-2 mx-3">
                                                            <span>Nguyễn Bác Sĩ</span>
                                                            <span>username: bacsing</span>
                                                        </div>
                                                        <button class="btn-only-ic" data-bs-toggle="modal"
                                                                data-bs-target="#deleteDoctorModal" data-bs-delete="add">
                                                            <i class="bi bi-dash-circle-fill"></i>
                                                        </button>
                                                    </div>
                                                    <div class="doctor-card px-0">
                                                        <div class="img-cover">
                                                            <img src="https://via.placeholder.com/60" alt="">
                                                        </div>
                                                        <div class="d-flex flex-column my-2 mx-3">
                                                            <span>Nguyễn Bác Sĩ</span>
                                                            <span>username: bacsing</span>
                                                        </div>
                                                        <button class="btn-only-ic" data-bs-toggle="modal"
                                                                data-bs-target="#deleteDoctorModal" data-bs-delete="add">
                                                            <i class="bi bi-dash-circle-fill"></i>
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-auto mx-auto text-center">
                                            <button type="submit" class="btn btn-primary">Thêm dịch vụ</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Edit Service Modal -->
                <div class="modal fade" id="editServiceModal">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <div class="non-block"></div>
                                <h5 class="modal-title" id="staticBackdropLabel">Chỉnh sửa dịch vụ</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <div class="container-fluid">
                                    <form class="row g-3">
                                        <div class="pe-5 col-6">
                                            <div class="row mb-3">
                                                <label for="serviceCode" class="col-4 col-form-label">Mã dịch vụ</label>
                                                <div class="col-8">
                                                    <input type="text" class="form-control" name="service_code"
                                                           id="serviceCode" placeholder="SVCS999" value="SVCS001">
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <label for="serviceName" class="col-4 col-form-label">Tên dịch vụ</label>
                                                <div class="col-8">
                                                    <input type="text" class="form-control" name="service_name"
                                                           id="serviceName" placeholder="Chuyên khoa mắt"
                                                           value="Chuyên khoa mắt">
                                                </div>
                                            </div>
                                            <div class="row">
                                                <label for="serviceDesc" class="col-4 col-form-label">Mô tả</label>
                                                <div class="col-8">
                                                    <textarea class="form-control" name="service_desc" id="serviceDesc"
                                                              rows="3"></textarea>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="ps-5 col-6">
                                            <div class="row">
                                                <div class="col-7 col-form-label">
                                                    Bác sĩ
                                                </div>
                                                <button id="add-btn" type="button" class="btn btn-light col-5"
                                                        data-bs-toggle="modal" data-bs-target="#selectDoctorModal"
                                                        data-bs-select="edit">
                                                    Thêm bác sĩ
                                                    <i class="bi bi-plus-circle-fill ms-1"></i>
                                                </button>
                                            </div>
                                            <div class="row list-doctors">
                                                <div class="list-doctors-scroll">
                                                    <div class="doctor-card px-0">
                                                        <div class="img-cover">
                                                            <img src="https://via.placeholder.com/60" alt="">
                                                        </div>
                                                        <div class="d-flex flex-column my-2 mx-3">
                                                            <span>Nguyễn Bác Sĩ</span>
                                                            <span>username: bacsing</span>
                                                        </div>
                                                        <button class="btn-only-ic" data-bs-toggle="modal"
                                                                data-bs-target="#deleteDoctorModal" data-bs-delete="edit">
                                                            <i class="bi bi-dash-circle-fill"></i>
                                                        </button>
                                                    </div>
                                                    <div class="doctor-card px-0">
                                                        <div class="img-cover">
                                                            <img src="https://via.placeholder.com/60" alt="">
                                                        </div>
                                                        <div class="d-flex flex-column my-2 mx-3">
                                                            <span>Nguyễn Bác Sĩ</span>
                                                            <span>username: bacsing</span>
                                                        </div>
                                                        <button class="btn-only-ic" data-bs-toggle="modal"
                                                                data-bs-target="#deleteDoctorModal" data-bs-delete="edit">
                                                            <i class="bi bi-dash-circle-fill"></i>
                                                        </button>
                                                    </div>
                                                    <div class="doctor-card px-0">
                                                        <div class="img-cover">
                                                            <img src="https://via.placeholder.com/60" alt="">
                                                        </div>
                                                        <div class="d-flex flex-column my-2 mx-3">
                                                            <span>Nguyễn Bác Sĩ</span>
                                                            <span>username: bacsing</span>
                                                        </div>
                                                        <button class="btn-only-ic" data-bs-toggle="modal"
                                                                data-bs-target="#deleteDoctorModal" data-bs-delete="edit">
                                                            <i class="bi bi-dash-circle-fill"></i>
                                                        </button>
                                                    </div>
                                                    <div class="doctor-card px-0">
                                                        <div class="img-cover">
                                                            <img src="https://via.placeholder.com/60" alt="">
                                                        </div>
                                                        <div class="d-flex flex-column my-2 mx-3">
                                                            <span>Nguyễn Bác Sĩ</span>
                                                            <span>username: bacsing</span>
                                                        </div>
                                                        <button class="btn-only-ic" data-bs-toggle="modal"
                                                                data-bs-target="#deleteDoctorModal" data-bs-delete="edit">
                                                            <i class="bi bi-dash-circle-fill"></i>
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-auto mx-auto text-center">
                                            <button type="submit" class="btn btn-primary">Lưu thay đổi</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Delete Service Modal -->
            <div class="modal fade" id="deleteServiceModal" data-bs-keyboard="false" tabindex="-1"
                 aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered modal-delete">
                    <div class="modal-content">
                        <div class="modal-header justify-content-center">
                            <h5 class="modal-title" id="staticBackdropLabel">Thông báo</h5>
                        </div>
                        <div class="modal-body text-center">
                            Bạn có muốn xóa dịch vụ chuyên khoa mắt không?
                        </div>
                        <div class="modal-footer">
                            <button class="btn btn-light" data-bs-target="#deleteServiceModal" data-bs-toggle="modal">
                                Không</button>
                            <button class="btn btn-primary" data-bs-target="#deleteServiceModal" data-bs-toggle="modal">
                                Có</button>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Select Doctor Modal -->
            <div class="modal fade" id="selectDoctorModal" data-bs-keyboard="false" tabindex="-1"
                 aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog modal-doctor">
                    <div class="modal-content">
                        <div class="modal-header">
                            <div class="non-block"></div>
                            <h5 class="modal-title" id="staticBackdropLabel">Chọn bác sĩ</h5>
                            <button type="button" class="btn-close select-dismiss" data-bs-toggle="modal"
                                    aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <div class="list-doctors">
                                <div class="list-doctors-scroll">
                                    <div class="doctor-card px-0 active">
                                        <div class="img-cover">
                                            <img src="https://via.placeholder.com/60" alt="">
                                        </div>
                                        <div class="d-flex flex-column my-2 mx-3">
                                            <span>Nguyễn Bác Sĩ</span>
                                            <span>username: bacsing</span>
                                        </div>
                                        <button class="btn-checked">
                                            <i class="bi bi-check-circle-fill"></i>
                                        </button>
                                    </div>
                                    <div class="doctor-card px-0 active">
                                        <div class="img-cover">
                                            <img src="https://via.placeholder.com/60" alt="">
                                        </div>
                                        <div class="d-flex flex-column my-2 mx-3">
                                            <span>Nguyễn Bác Sĩ</span>
                                            <span>username: bacsing</span>
                                        </div>
                                        <button class="btn-checked">
                                            <i class="bi bi-check-circle-fill"></i>
                                        </button>
                                    </div>
                                    <div class="doctor-card px-0">
                                        <div class="img-cover">
                                            <img src="https://via.placeholder.com/60" alt="">
                                        </div>
                                        <div class="d-flex flex-column my-2 mx-3">
                                            <span>Nguyễn Bác Sĩ</span>
                                            <span>username: bacsing</span>
                                        </div>
                                        <button class="btn-checked">
                                            <i class="bi bi-check-circle-fill"></i>
                                        </button>
                                    </div>
                                    <div class="doctor-card px-0">
                                        <div class="img-cover">
                                            <img src="https://via.placeholder.com/60" alt="">
                                        </div>
                                        <div class="d-flex flex-column my-2 mx-3">
                                            <span>Nguyễn Bác Sĩ</span>
                                            <span>username: bacsing</span>
                                        </div>
                                        <button class="btn-checked">
                                            <i class="bi bi-check-circle-fill"></i>
                                        </button>
                                    </div>
                                </div>
                            </div>
                            <div class="col-auto mx-auto text-center">
                                <button type="submit" class="btn btn-primary select-dismiss"
                                        data-bs-toggle="modal">Thêm</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Delete Doctor Modal -->
            <div class="modal fade" id="deleteDoctorModal" data-bs-keyboard="false" tabindex="-1"
                 aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered modal-delete">
                    <div class="modal-content">
                        <div class="modal-header justify-content-center">
                            <h5 class="modal-title" id="staticBackdropLabel">Thông báo</h5>
                        </div>
                        <div class="modal-body text-center">
                            Bạn có muốn xóa "Nguyễn Bác Sĩ" khỏi dịch vụ "Chuyên khoa mắt" không?
                        </div>
                        <div class="modal-footer">
                            <button class="btn btn-light delete-dismiss" data-bs-toggle="modal">
                                Không</button>
                            <button class="btn btn-primary delete-dismiss" data-bs-toggle="modal">
                                Có</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <!-- Bootstrap Bundle -->
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
                integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

        <script src="./assets/service/index.js"></script>

        <script src="./assets/js/jquery-3.6.0.min.js" crossorigin="anonymous"></script>
        <script src="./assets/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="./assets/js/star-rating.js" type="text/javascript"></script>
        <script src="./assets/themes/krajee-fas/theme.js" type="text/javascript"></script>
        <script src="./assets/js/select2.full.min.js"></script>
        <script src="./assets/js/custom.js"></script>
    </body>
    <footer>
        <jsp:include page="./components/footer.jsp" />
    </footer>
</html>
