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
    <title>Đăng Ký</title>
</head>
<body>

    <legend>New to WebApp? Sign up!</legend>
    <form accept-charset="UTF-8" action="<c:url value='/Dang-ky'/>" method="post">
        <c:if test="${not empty message}">
            <div class="alert alert-${alter}">
                    ${message}
            </div>
        </c:if>
        <input class="span3" name="name" placeholder="Full Name" type="text">
        <input class="span3" name="username" placeholder="Username" type="text">
        <input class="span3" name="password" pattern=".{8,}" placeholder="Password" type="password">
        <input type="hidden" value="2" name="id_role"/>
        <input type="hidden" value="sign_up" name="action"/>
        <input type="hidden" value="success" name="check"/>
        <button class="btn btn-warning" type="submit">Sign up for WebApp</button>
    </form>

</body>
</html>
