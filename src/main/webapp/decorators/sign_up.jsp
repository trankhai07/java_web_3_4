<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 4/26/2023
  Time: 12:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
  <meta charset="UTF-8">
  <title><<dec:title default="Trang chủ"/></title>
  <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
  <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
  <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
  <style>
    body{
      background-color: #c0dcff;
      width: 500px;
      height: 100%;
    }
    .span3.well{
      margin: 100px 400px;
    }

  </style>
</head>
<body>
<div class="span3 well">
  <dec:body/>
</div>

</body>
</html>
