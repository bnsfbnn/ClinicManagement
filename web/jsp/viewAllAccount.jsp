<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="./assets/css/style.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="../assets/styles/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <link href="../assets/styles/jquery-ui.structure.min.css" rel="stylesheet" type="text/css"/>
        <link href="../assets/styles/jquery-ui.theme.min.css" rel="stylesheet" type="text/css"/>
        <title>Account Management</title>
    </head>
    <header>
        <jsp:include page="./components/customerHeader.jsp" />
    </header>
    <body>
        <h1 style="text-align: center">Account Management</h1>
        <div class="row mt-3">

            <table style="margin-left: auto; margin-right: auto; border: 1px solid">
                <tr>
                    <th>ID</th>
                    <th>Tài Khoản</th>
                    <th>Email</th>
                    <th>Họ tên</th>
                    <th>Ngày Sinh</th>
                    <th>Giới tính</th>
                    <th>Phone</th>
                    <th>Địa chỉ</th>
                    <th>Chức vụ</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
                <c:forEach var="user" items="${users.data}">
                    <tr>
                        <td style="text-align: center; border: 1px solid" >
                            <input value="${user.userId}" id="userId">
                        </td>
                        <td style="text-align: center; border: 1px solid">
                            <input value="${user.username}">
                        </td>
                        <td style="text-align: center; border: 1px solid">
                            <input value="${user.email}">
                        </td>
                        <td style="text-align: center; border: 1px solid">
                            <input value="${user.birthDate}">
                        </td>

                        <c:choose>
                            <c:when test="${user.gender == true}">
                                <td style="text-align: center; border: 1px solid">
                                    <input value="Male">
                                </td>
                            </c:when> 
                            <c:when test="${user.gender == false}">
                                <td style="text-align: center; border: 1px solid">
                                    <input value="FeMail">
                                </td>
                            </c:when> 
                        </c:choose>

                        <td style="text-align: center; border: 1px solid">
                            <input value="${user.username}">
                        </td>
                        <td style="text-align: center; border: 1px solid">
                            <input value="${user.phone}">
                        </td>
                        <td style="text-align: center; border: 1px solid">
                            <input value="${user.address}">
                        </td>
                        <td style="text-align: center; border: 1px solid">
                            <input value="${user.role}">
                        </td>
                        <td style="text-align: center; border: 1px solid" class="btn-success">
                            <a href="">
                                <button type="button" class="btn btn-primary">Update</button>
                            </a>
                        </td>
                        <td style="text-align: center; border: 1px solid">
                            <button type="button" class="btn btn-danger" onclick="myFunction('${user.userId}')">Deactivate</button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
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
                            <a class="btn btn-light" href="${requestScope['javax.servlet.forward.request_uri']}?page=${users.currentPage-1}">Trang trước</a>
                        </c:if>
                        <c:forEach var="pageNumber" begin="1" end="${users.totalPage}" step="1">
                            <c:if test="${users.currentPage == pageNumber}">
                                <a class="btn btn-success" href="#">${pageNumber}</a>
                            </c:if>
                            <c:if test="${users.currentPage != pageNumber}">
                                <a class="btn btn-light" href="${requestScope['javax.servlet.forward.request_uri']}?page=${pageNumber}">${pageNumber}</a>
                            </c:if>
                        </c:forEach>
                        <c:if test="${users.currentPage < users.totalPage}">
                            <a class="btn btn-light" href="${requestScope['javax.servlet.forward.request_uri']}?page=${users.currentPage+1}">Trang sau</a>
                        </c:if>
                    </ul>
                </div>
            </div>
        </c:if>
        <button class="btn btn-secondary">
            <a href="./jsp/addAccount.jsp">Add account</a>
        </button>


        <script>
            function myFunction(id) {
                console.log(id);
                let text = "Do you wannaa Deactivate user with ID : " + id;
                if (confirm(text) == true) {
                    document.location.href = "DeleteAccountController?id=" + id;
                }
            }
        </script>
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
