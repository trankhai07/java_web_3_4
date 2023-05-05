<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title><dec:title default="Trang chủ" /></title>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- css -->
	<link rel="icon" href="<c:url value='template/web/assets/img/icon-home/small-logo.svg'/>" type="image/gif" sizes="16x16">
    <!-- reset css -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
    <!-- css grid để kết hợp chia khung và responsive -->
    <link rel="stylesheet" href="<c:url value='template/web/assets/css/grid.css'/>">
    <!-- css mấy cái chung ban đầu -->
    <link rel="stylesheet" href="<c:url value = 'template/web/assets/css/base.css'/>">
    <!-- css chính -->
    <link rel="stylesheet" href="<c:url value = 'template/web/assets/css/main.css'/>">
    <!-- css để responsive trên các thiết bị -->
    <link rel="stylesheet" href="<c:url value='template/web/assets/css/responsive.css'/>">
    <!-- nếu trình duyệt IE < 9 thì comment dưới sẽ thành code chạy dc, code scrip dước có chức năng để chạy dc media-query để responsive trên trình chuyệt thấp IE < 9 -->
    <!--[if lt IE 9]>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.1/respond.js"></script>
    <![endif]-->
    <!-- dùng google font roboto -->
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
    <!-- icon fontawesome -->
    <link rel="stylesheet" href="<c:url value='template/web/assets/fonts/fontawesome-free-5.15.3-web/css/all.min.css'/>" >
</head>
<body>
	

	<div class="main" style="background-image: url(template/web/assets/img/background-theme/backroundThemes/0.svg);">
		<div class="grid">
			<%@ include file="/common/web/header.jsp"%>
			<dec:body/>
		</div>
	     
		<!-- footer -->
		<%@ include file="/common/web/footer.jsp"%>
		<!-- footer -->
	</div>
	
	 <div id="toast">
		 <c:if test="${ not empty check_up}">
			 <div class="toast__item">
				 <i class="fa-solid fa-circle-exclamation"></i>
				 <span>Đăng nhập thành công!</span>
			 </div>
		 </c:if>
    </div>

	<script src="<c:url value = 'template/web/assets/javascript/main.js'/>" ></script>

</body>
</html>