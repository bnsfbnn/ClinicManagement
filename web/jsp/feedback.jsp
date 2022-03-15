<%-- 
    Document   : feedback
    Created on : Mar 08, 2022, 10:34:50 AM
    Author     : TrangCT
--%>
<!DOCTYPE html>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"> 
        <link href="../assets/css/header.css" rel="stylesheet" type="text/css"/>
        <title>Document</title>
        <style>
            @media (min-width: 576px) {
                .container {
                    max-width: 540px;
                }
            }

            @media (min-width: 768px) {
                .container {
                    max-width: 720px;
                }
            }

            @media (min-width: 992px) {
                .container {
                    max-width: 960px;
                }
            }

            @media (min-width: 1200px) {
                .container {
                    max-width: 1140px;
                }
            }

            @media (min-width: 1500px) {
                .container {
                    max-width: 1440px;
                }
            }

            @media (min-width: 1600px) {
                .container {
                    max-width: 1560px;
                }
            }

            .container {
                padding-top: 20px
            }

            .fs-12-b {
                font-size: 12px;
                font-weight: bold;
            }

            .fs-12-i {
                font-size: 12px;
                font-style: italic;
            }

            .fs-12 {
                font-size: 12px;
            }

            .item {
                background: white;
                border: 1px solid #e6e6e6;
                margin-bottom: 20px;
                box-shadow: 2px 2px 7px;
                border-radius: 5px;
            }

            .item_container {
                padding: 20px;
                display: flex;
            }

            .item_container img {
                width: 24px;
                height: 24px;
                border-radius: 50%;
                margin-top: 3px;
                margin-right: 10px;
            }

            .item_header {
                display: flex;
                width: 100%;
                justify-content: space-between;
            }

            .item__content {
                border: 1px solid #e6e6e6;
                margin-top: 10px;
                border-radius: 5px;
                padding: 10px;
            }

            .item__feedback {
                border: 1px solid #e6e6e6;
                margin-top: 10px;
                padding: 10px;
                border-radius: 5px;
                background: #F2F5F7
            }

            .service {
                background: white;
                border: 1px solid #e6e6e6;
                margin-bottom: 20px;
                box-shadow: 2px 2px 7px;
                border-radius: 5px;
            }
        </style>
    </head>
    <header>
        <jsp:include page="./components/customerHeader.jsp" />
    </header>
    <body>
        <div class="container">
            <h5 style="margin-bottom: 20px;">Đánh giá dịch vụ</h5>
            <div class="row">
                <div class="col-lg-8">
                    <ul style="list-style: none; padding:0;">
                        <c:forEach items="${feedbacks.data}" var="feedback" varStatus="counter" >
                            <li class="item">
                                <div class="item_container">
                                    <img src="../assets/images/logo-gg-new.png">
                                    <div>
                                        <div class="item_header">
                                            <div style="display: flex; flex-direction:column">
                                                <span class="fs-12-b">${feedback.customer}</span>
                                                <div>
                                                    <span class="fs-12-i">Dịch vụ:</span>
                                                    <span class="fs-12-b">${feedback.service}</span>
                                                </div>
                                            </div>
                                            <time class="fs-12">${feedback.feedbackTime}</time>
                                        </div>
                                        <div class="item__content">
                                            ${feedback.feedbackContent}
                                        </div>
                                    </div>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
                <div class="col-lg-4">
                    <div class="service">
                        <h6 style="margin:10px">Dịch vụ</h6>
                        <div style="margin-top:10px; margin-left:40px;">
                            <input type="checkbox" id="1">
                            <label for="1">Chuyên khoa mắt</label><br>
                            <input type="checkbox" id="2">
                            <label for="1">Chuyên khoa Tai, Mũi, Họng</label><br>
                            <input type="checkbox" id="3">
                            <label for="1">Chuyên khoa Tim Mạch</label><br>
                            <input type="checkbox" id="4">
                            <label for="1">Chuyên khoa Tiêu Hóa</label><br>
                            <input type="checkbox" id="5">
                            <label for="1">Chuyên khoa Da liễu</label><br>
                            <input type="checkbox" id="6">
                            <label for="1">Xét nghiệm</label><br>
                            <input type="checkbox" id="7">
                            <label for="1">Tầm soát ung thư</label><br>
                            <input type="checkbox" id="8">
                            <label for="1">Tiêm chủng</label><br>

                        </div>
                        <div style="text-align: center; margin-top:10px; margin-bottom:15px"><button type="button"
                                                                                                     class="btn btn-primary" style="width: 100px">Lọc</button></div>
                    </div>
                </div>
            </div>

        </div>
        <div class="pagi-wrapper">
            <c:if test="${feedbacks.totalPage > 1}">
                <div class="row">
                    <div class="col-12 text-center">
                        <ul>
                            <c:if test="${feedbacks.currentPage > 1}">
                                <a class="btn btn-light" href="ViewFeedBackListController?page=${feedbacks.currentPage-1}">Trang trước</a>
                            </c:if>
                            <c:forEach var="pageNumber" begin="1" end="${feedbacks.totalPage}" step="1">
                                <c:if test="${feedbacks.currentPage == pageNumber}">
                                    <a class="btn btn-success" href="#">${pageNumber}</a>
                                </c:if>
                                <c:if test="${feedbacks.currentPage != pageNumber}">
                                    <a class="btn btn-light" href="ViewFeedBackListController?page=${pageNumber}">${pageNumber}</a>
                                </c:if>
                            </c:forEach>
                            <c:if test="${feedbacks.currentPage < feedbacks.totalPage}">
                                <a class="btn btn-light" href="ViewFeedBackListController?page=${services.currentPage+1}">Trang sau</a>
                            </c:if>
                        </ul>
                    </div>
                </div>
            </c:if>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
                integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous">
        </script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
                integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous">
        </script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
                integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous">
        </script>
    </body>

</html>