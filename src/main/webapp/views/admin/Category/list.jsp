<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-category"/>
<c:url var="Cateurl" value="/admin-category"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách thể loại</title>

	<!------ Include the above in your HEAD tag ---------->

</head>
<body>
	<div class="main-content">


			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
								chủ</a></li>
					</ul>
					<!-- /.breadcrumb -->
				</div>
				<form class="page-content">
					<div class="row">
						<div class="col-xs-12">
<%--							<div class="container">--%>
								<div class="row">
									<div class="span12">
										<form  action="<c:url value='/admin-category'/>" method="get" class="">
											<div class="">
												<input type="text" class="" placeholder="Search by name" name="name" >
												<input type="hidden" class=""  name="type" value="search">
												<input type="hidden" value="1" id="" name="page" />
												<input type="hidden" value="2" id="" name="maxpage" />

<%--												<i class="fa fa-search" aria-hidden="true"></i>--%>
<%--												<input type="submit" value="Đăng nhập" class="btn float-right login_btn">--%>
												<button id="btnsearch" type="submit">
												<span> <i class="fa fa-search" aria-hidden="true"></i>
												</span>
												</button>
											</div>
										</form>
									</div>
								</div>
<%--							</div>--%>
							<div class="widget-box table-filter">
								<div class="table-btn-controls">
<%--									<div class="pull-right tableTools-container">--%>
										<div class="dt-buttons btn-overlap btn-group">
											<a flag="info"
											   class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
											   data-toggle="tooltip" title='Thêm thể loại'
											   href='<c:url value="/admin-category?type=edit"/>'> <span>
													<i class="fa fa-plus-circle bigger-110 purple"></i>
											</span>
											</a>
											<button id="btnDelete" type="button"
													class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
													data-toggle="tooltip" title='Xóa thể loại'>
												<span> <i class="fa fa-trash-o bigger-110 pink"></i>
												</span>
											</button>
											<button id="btnIncrease" type="button"
													class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
													data-toggle="tooltip" title='Sắp xếp tăng dần'>
												<span> <i class="fa fa-caret-square-o-up" aria-hidden="true"></i>
												</span>
											</button>

											<button id="btnDecrease" type="button"
													class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
													data-toggle="tooltip" title='Sắp xếp giảm dần'>
												<span> <i class="fa fa-caret-square-o-down" aria-hidden="true"></i>
												</span>
											</button>
<%--										</div>--%>
									</div>
								</div>
							</div>
					<div class="row">
						<div class="col-xs-12">
							<div class="table-responsive">

								<table class="table table-bordered">
									<thead>
										<tr>
											<th><input type="checkbox" name="" id="check"></th>
											<th>id_category</th>
											<th>name</th>
											<th>description</th>

										</tr>
									</thead>
									<tbody>
										<c:forEach var="item" items="${model_song.list_item}">
											<tr>
												<td><input type="checkbox" name="" id="check_${item.id_category}" value="${item.id_category}"></td>
												<td>${item.id_category}</td>
												<td>${item.name}</td>
												<td>${item.description}</td>

												<td>
<%--													<c:url var="editURL" value="/admin-new">--%>
<%--														<c:param name="type" value="edit"/>--%>
<%--														<c:param name="id_music" value="${item.id_muic}"/>--%>
<%--													</c:url>--%>
<%--													<a--%>
<%--													   class="btn btn-sm btn-primary btn-edit"--%>
<%--													   data-toggle="tooltip" title='Chỉnh sửa bài viết'--%>
<%--													   href='${editURL}'>--%>
<%--														<i class="fa fa-pencil-square-o" aria-hidden="true"></i>--%>
<%--													</a>--%>
														<a
																class="btn btn-sm btn-primary btn-edit"
																data-toggle="tooltip" title='Chỉnh sửa thể loại'
																href='<c:url value="/admin-category?type=edit&id_category=${item.id_category}"/>'>
															<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
														</a>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<form action="<c:url value='/admin-category'/>" id = "formSubmit" method="get">
								<ul class="pagination" id="pagination"></ul>
								<input type="hidden" value="" id="page" name="page" />
								 <input type="hidden" value="" id="maxpage" name="maxpage" />
								<input type="hidden" value="" id="sortName" name="sortName" />
								<input type="hidden" value="" id="sortBy" name="sortBy" />
								 <input type="hidden" value="" id="type" name="type" />
								<input type="hidden" value="" id="search"	name="name">
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>

	</div>
	<!-- /.main-content -->
	<script type="text/javascript">
		var currentpage = ${model_song.page};
		var visiblepage = ${model_song.maxpage};
		var totalpage = ${model_song.totalpage};
		var typepage= '${model_song.type}';
		var namepage = '${model_song.name}'
		var limit = 2;
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages :totalpage,
				visiblePages : 10,
				startPage : currentpage,
				onPageClick : function(event, page) {
					if(currentpage != page){
						console.info(page + ' (from options)');
						$('#maxpage').val(limit);
						$('#page').val(page);
						$('#sortName').val('id_category');
						$('#sortBy').val('DESC');
						$('#type').val(typepage);
						$('#search').val(namepage);
						$('#formSubmit').submit();

;					}

				}
			});
		});

		$("#btnDelete").click(function(){
			var data={};
			var ids = $('tbody input[type=checkbox]:checked').map(function() {
				return $(this).val();
			}).get();
			data['ids'] = ids;
			deletecategory(data);
		});
		function deletecategory(data){
			$.ajax({
				url:'${APIurl}', // api muốn gọi về
				type:'DELETE', // kiểu dữ liệu mapping api
				contentType:'application/json', // kiểu dữ liệu từ clinet về server
				data:JSON.stringify(data), // chuyển từ javascript object sang json
				// dataType: 'json', // dữ liệu giả veef cho client là json
				success: function (result){
						window.location.href = "${Cateurl}?type=list&page=1&maxpage=2";
				},
				error: function (error){
					console.log(error);
				}
			});
		}
		<%--$("#buttonsearch").click(function(){--%>
		<%--	var se = $('#search').val();--%>
		<%--	window.location.href = "${Cateurl}?type=search?&page=1&maxpage=2&name=${se}";--%>
		<%--});--%>
	</script>
</body>
</html>