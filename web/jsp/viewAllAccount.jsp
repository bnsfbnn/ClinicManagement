<!--
 * Copyright(C) 2022, FPT University
 * CMS
 * CLINIC MANAGEMENT SYSTEM
 *
 * Record of change:
 * DATE            Version          AUTHOR           DESCRIPTION
 * 2022-03-10      1.0              HuongHTT         First Implement 
/-->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.css">
        <script src="https://kit.fontawesome.com/069a201b18.js" crossorigin="anonymous"></script>        
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script><title>Account Management</title>
        <link href="./assets/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
        <c:if test="${checkDelete != null}">
            <c:if test="${checkDelete == true}">
                <script>
                    $(document).ready(function () {
                        swal("Xóa tài khoản thành công !", "success");
                    });
                </script>
            </c:if>
            <c:if test="${checkDelete == false}">
                <script>
                    $(document).ready(function () {
                        swal("Xóa tài khoản không thành công !", "error");
                    });
                </script>
            </c:if>
        </c:if>

        <c:if test="${checkAdd != null}">
            <c:if test="${checkAdd == true}">
                <script>
                    $(document).ready(function () {
                        swal("Thêm tài khoản thành công !", "success");
                    });
                </script>
            </c:if>
            <c:if test="${checkAdd == false}">
                <script>
                    $(document).ready(function () {
                        swal("Thêm tài khoản không thành công !", "error");
                    });
                </script>
            </c:if>
        </c:if>

        <c:if test="${checkUpdate != null}">
            <c:if test="${checkUpdate == true}">
                <script>
                    $(document).ready(function () {
                        swal("Xóa tài khoản thành công !", "success");
                    });
                </script>
            </c:if>
            <c:if test="${checkUpdate == false}">
                <script>
                    $(document).ready(function () {
                        swal("Xóa tài khoản không thành công !", "error");
                    });
                </script>
            </c:if>
        </c:if>
    </head>
    <header>
        <jsp:include page="./components/adminHeader.jsp" />
    </header>
    <body>
        <div class="container-fluid">
            <div class="row">
                <h2 class="col-lg-10 mx-auto justify-content-end" >Account Management</h2>
            </div>

            <div class="row">
                <div class="col-md-10 mx-auto">
                    <nav class="navbar navbar-light bg-light justify-content-between">
                        <button class="btn btn-primary btn-xs" data-title="Add" data-toggle="modal" data-target="#add" >Thêm tài khoản
                        </button>
                        <div style="color: red">
                            ${message}
                        </div>
                        <form class="form-inline" action="GetAllAccountController" method="GET">
                            <input class="form-control mr-sm-2"name="search" type="search" placeholder="Tìm kiếm" aria-label="Tìm kiếm" value="${search}">
                            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Tìm kiếm</button>
                        </form>
                    </nav>
                    <table id="datatable" class="table table-striped table-bordered mx-auto" cellspacing="0" width="70%">
                        <tr>
                            <th>ID</th>
                            <th>Tài Khoản</th>
                            <th>Email</th>
                            <th>Họ tên</th>
                            <th>Chức vụ</th>
                            <th>View</th>
                            <th>Update</th>
                            <th>Delete</th>
                        </tr>
                        <c:forEach var="user" items="${users.data}">
                            <tr>
                                <td>${user.userId}</td>
                                <td>${user.username}</td>
                                <td>${user.email}</td>
                                <td>${user.fullName}</td>
                                <td>${user.role}</td>
                                <td>
                                    <button class="btn btn-primary btn-xs" data-title="Edit" data-toggle="modal" data-target="#view${user.userId}" >
                                        <i class="fa-solid fa-eye"></i>
                                    </button>
                                </td>
                                <td>
                                    <button class="btn btn-primary btn-xs" data-toggle="modal" data-target="#edit${user.userId}" >
                                        <i class="fa-solid fa-pen"></i>
                                    </button>

                                </td>
                                <td>
                                    <button class="btn btn-danger btn-xs" data-toggle="modal" data-target="#delete${user.userId}" >
                                        <i class="fa-solid fa-trash-can"></i>
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>

                    </table>
                    <nav aria-label="Page navigation example">
                        <c:if test="${users.totalItem == 0}">
                            <div class="col-12">
                                <p class="text-center">Không có dữ liệu</p>
                            </div>
                        </c:if>
                        <c:if test="${users.totalPage > 1}">
                            <div class="row">
                                <div class="col-12 text-center">
                                    <ul>
                                        <c:if test="${users.currentPage > 1}">
                                            <a class="btn btn-light" href="GetAllAccountController?page=${users.currentPage-1}">Trang trước</a>
                                        </c:if>
                                        <c:forEach var="pageNumber" begin="1" end="${users.totalPage}" step="1">
                                            <c:if test="${users.currentPage == pageNumber}">
                                                <a class="btn btn-success" href="#">${pageNumber}</a>
                                            </c:if>
                                            <c:if test="${users.currentPage != pageNumber}">
                                                <a class="btn btn-light" href="GetAllAccountController?page=${pageNumber}&search=${search}">${pageNumber}</a>
                                            </c:if>
                                        </c:forEach>
                                        <c:if test="${users.currentPage < users.totalPage}">
                                            <a class="btn btn-light" href="GetAllAccountController?page=${users.currentPage+1}&search=${search}">Trang sau</a>
                                        </c:if>
                                    </ul>
                                </div>
                            </div>
                        </c:if>
                    </nav>
                </div>

            </div>
        </div>


        <div class="modal fade" id="add">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title custom_align" id="Heading">Thêm tài khoản</h4>


                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form  id="myForm" action="../ClinicManagement/CreateAccountController" method="GET  ">
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="inputRole">Chức vụ</label>
                                    <select id="inputRole" class="form-control" name="roleId" contenteditable="Chọn chức vụ">
                                        <!--<option selected>Chọn chức vụ</option>-->
                                        <option value="1">Admin</option>
                                        <option value="2">Manager</option>
                                        <option value="3">Doctor</option>
                                        <option value="4">Customer</option>
                                    </select>                                    
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="inputAccount">Tài khoản</label>
                                    <input type="text" class="form-control" name="username" required maxlength="20" >
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="inputAccount">Mật khẩu</label>
                                <input type="text" class="form-control" name="password" value="123456" readonly>
                            </div>

                            <div class="form-group">
                                <label>Họ và tên</label>
                                <input type="text" class="form-control" name="fullName" required maxlength="20" 
                            </div>
                            <div class="form-group">
                                <label>Email</label>
                                <input type="email" class="form-control" name="email" required maxlength="20">
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label>Địa chỉ</label>
                                    <input type="text" class="form-control" name="address" required maxlength="20" >
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Số điện thoại</label>
                                    <input type="tel" class="form-control" name="phone" required maxlength="20" pattern="[0][0-9]{9}">

                                </div>
                                <div class="form-group col-md-6">
                                    <label>Ngày sinh</label>
                                    <input type="date" class="form-control" id="inputBirthDate" name="date" required>
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Giới tính</label>
                                    <select id="inputGender" class="form-control" name="gender" >
                                        <option selected>Chọn giới tính</option>
                                        <option value="1">Nam</option>
                                        <option value="2">Nữ</option>
                                    </select>
                                </div>
                            </div>
                            <div class="modal-footer ">
                                <button type="submit" class="btn btn-primary btn-xs btn-lg col-md-6" style="width: 100%;">Lưu</button>
                                <button type="reset" onclick="myFunction()" class="btn btn-danger btn-lg col-md-6" style="width: 100%;">Làm mới</button>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- /.modal-content --> 
            </div>
            <!-- /.modal-dialog --> 
        </div>
    </div>
    <c:forEach var="user" items="${users.data}">
        <div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="view" aria-hidden="true" id="view${user.userId}">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">                   
                        <h4 class="modal-title custom_align" id="Heading">Chi tiết tài khoản</h4>

                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>

                    </div>
                    <div class="modal-body">
                        <form>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="inputRole">Chức vụ</label>
                                    <input type="text" class="form-control" name="inputRole" value="${user.role}" readonly>
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="inputAccount">Tài khoản</label>
                                    <input type="text" class="form-control" name="inputAccount" value="${user.username}" readonly>
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Họ và tên</label>
                                <input type="text" class="form-control" name="inputName" value="${user.fullName}" readonly>
                            </div>
                            <div class="form-group">
                                <label>Email</label>
                                <input type="email" class="form-control" name="inputEmail" value="${user.email}" readonly>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label>Địa chỉ</label>
                                    <input type="text" class="form-control" name="inputAddress" value="${user.address}" readonly>
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Số điện thoại</label>
                                    <input type="text" class="form-control" name="inputPhone" value="${user.phone}" readonly>

                                </div>
                                <div class="form-group col-md-6">
                                    <label>Ngày sinh</label>
                                    <input type="date" class="form-control" name="date" value="${user.birthDate}" readonly>
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Giới tính</label>
                                    <input type="text" class="form-control" id="inputGender" value="${user.gender == "true" ? "Nam" : "Nữ"}" readonly>
                                </div>
                            </div>
                        </form>
                    </div>

                </div>
                <!-- /.modal-content --> 
            </div>
            <!-- /.modal-dialog --> 
        </div>
        <form action="DeleteAccountController">
            <div hidden>
                <input name="id" value="${user.userId}">
            </div>
            <div class="modal fade" id="delete${user.userId}">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title custom_align" id="Heading">Xóa tài khoản</h4>

                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div class="alert alert-danger"><span class="glyphicon glyphicon-warning-sign"></span>Bạn chắc chắn muốn xóa tài khoản ${user.username} này chứ?</div>
                        </div>
                        <div class="modal-footer ">
                            <button type="submit" class="btn btn-success" ><span class="glyphicon glyphicon-ok-sign"></span> Có</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Không</button>
                        </div>
                    </div>
                    <!-- /.modal-content --> 
                </div>
                <!-- /.modal-dialog --> 
            </div>
        </form>

        <div class="modal fade" id="edit${user.userId}">
            <div class="modal-dialog">
                <form action="UpdateAccountController" method="GET">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title custom_align" id="Heading">Chỉnh sửa tài khoản</h4>

                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="inputRole">Chức vụ</label>
                                    <select id="inputRole" class="form-control" name="roleId" value="${user.role}">
                                        <option value="1">Admin</option>
                                        <option value="2">Manager</option>
                                        <option value="3">Doctor</option>
                                        <option value="4">Customer</option>
                                    </select>                                    
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="inputAccount">Tài khoản</label>
                                    <input type="text" class="form-control" required maxlength="20" name="username" value="${user.username}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Họ và tên</label>
                                <input type="text" class="form-control"required maxlength="20" name="fullName" value="${user.fullName}">
                            </div>
                            <div class="form-group">
                                <label>Email</label>
                                <input type="email" class="form-control"required maxlength="30" name="email" value="${user.email}">
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label>Địa chỉ</label>
                                    <input type="text" class="form-control"required maxlength="30" name="address" value="${user.address}">
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Số điện thoại</label>
                                    <input type="tel" class="form-control"required maxlength="15" name="phone" value="${user.phone}" pattern="[0][0-9]{9}">

                                </div>
                                <div class="form-group col-md-6">
                                    <label>Ngày sinh</label>
                                    <input type="date" class="form-control" name="date" required id="inputBirthDate" value="${user.birthDate}">
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Giới tính</label>
                                    <select id="inputGender" class="form-control" name="gender" value="${user.gender == "true" ? "Nam" : "Nữ"}">
                                        <option value="1">Nam</option>
                                        <option value="2">Nữ</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="form-group col-md-6" hidden>
                            <input type="text" class="form-control" name="userId" id="inputBirthDate" value="${user.userId}">
                        </div>
                        <div class="modal-footer ">
                            <button type="submit" class="btn btn-primary btn-xs btn-lg col-md-6" style="width: 100%;">Lưu</button>
                            <button type="button" data-dismiss="modal" aria-label="Close" class="btn btn-danger btn-lg col-md-6" style="width: 100%;">Hủy</button>
                        </div>
                    </div>
                </form>

                <!-- /.modal-content --> 
            </div>
            <!-- /.modal-dialog --> 
        </div>
    </c:forEach>
    <script src="./assets/js/jquery-3.6.0.min.js" crossorigin="anonymous"></script>
    <script src="./assets/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script language="JavaScript" src="https://code.jquery.com/jquery-1.11.1.min.js" type="text/javascript"></script>
    <script language="JavaScript" src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js" type="text/javascript"></script>
    <script language="JavaScript" src="https://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.js" type="text/javascript"></script>
    <script src="./assets/js/jquery-3.6.0.min.js" crossorigin="anonymous"></script>
    <script src="./assets/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>

    <script>
                                    function myFunction() {
                                        document.getElementById("myForm").reset();
                                    }
    </script>
</body>

</html>
