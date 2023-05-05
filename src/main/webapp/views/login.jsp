<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 4/21/2023
  Time: 3:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <title>Đăng nhập</title>
</head>
<body>
<div class="d-flex justify-content-center h-100">
    <div class="card">
        <div class="card-header">
            <h3>Đăng nhập</h3>
            <div class="d-flex justify-content-end social_icon">
                <span><i class="fab fa-facebook-square"></i></span>
                <span><i class="fab fa-google-plus-square"></i></span>
                <span><i class="fab fa-twitter-square"></i></span>
            </div>
        </div>
        <div class="card-body">

            <form action="<c:url value='/Dang-nhap'/>" id = "formLogin" method="post">
                <c:if test="${not empty message}">
                    <div class="alert alert-${alter}">
                            ${message}
                    </div>
                </c:if>


                <div class="input-group form-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="fas fa-user"></i></span>
                    </div>
                    <input type="text" class="form-control" placeholder="Tên đăng nhập" name="username">

                </div>
                <div class="input-group form-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="fas fa-key"></i></span>
                    </div>
                    <input type="password" class="form-control" placeholder="Mật khẩu" name="password">
                </div>
                <div class="row align-items-center remember">
                    <input type="checkbox">Lưu lịch sử đăng nhập
                </div>
                <div class="form-group">
                    <input type="hidden" value="login" name="action"/>
                    <input type="hidden" value="success" name="check"/>
                    <input type="submit" value="Đăng nhập" class="btn float-right login_btn">
                </div>
            </form>
        </div>
        <div class="card-footer">
            <div class="d-flex justify-content-center links">
                Bạn không có mật khẩu?<a href="<c:url value='/Dang-ky?action=sign_up' />">Đăng ký</a>
            </div>
            <div class="d-flex justify-content-center">
                <a href="#">Quên mật khẩu?</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
