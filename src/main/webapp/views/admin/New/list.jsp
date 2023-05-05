<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-song"/>
<c:url var="Songurl" value="/admin-new"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sach nhạc</title>
</head>
<body>
	<div class="main-content">
	<form action="<c:url value='/admin-new'/>" id = "formSubmit" method="get">

			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
								chủ</a></li>
					</ul>
					<!-- /.breadcrumb -->
				</div>
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<div class="widget-box table-filter">
								<div class="table-btn-controls">
<%--									<div class="pull-right tableTools-container">--%>
										<div class="dt-buttons btn-overlap btn-group">
											<a flag="info"
											   class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
											   data-toggle="tooltip" title='Thêm bài viết'
											   href='<c:url value="/admin-new?type=edit"/>'> <span>
													<i class="fa fa-plus-circle bigger-110 purple"></i>
											</span>
											</a>
											<button id="btnDelete" type="button"
													class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
													data-toggle="tooltip" title='Xóa bài viết'>
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
											<th>id_music</th>
											<th>id_author</th>
											<th>id_category</th>
											<th>name</th>
											<th>description</th>
											<th>Edit</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="item" items="${model_song.list_item}">
											<tr>
												<td><input type="checkbox" name="" id="checksong_${item.id_music}" value="${item.id_music}"></td>
												<td>${item.id_music}</td>
												<td>${item.id_author}</td>
												<td>${item.id_category}</td>
												<td>${item.name}</td>
												<td>${item.filemusic}</td>
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
																data-toggle="tooltip" title='Chỉnh sửa bài viết'
																href='<c:url value="/admin-new?type=edit&id_music=${item.id_music}"/>'>
															<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
														</a>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<ul class="pagination" id="pagination"></ul>
								<input type="hidden" value="" id="page" name="page" />
								 <input type="hidden" value="" id="maxpage" name="maxpage" />
								<input type="hidden" value="" id="sortName" name="sortName" />
								<input type="hidden" value="" id="sortBy" name="sortBy" />
								 <input type="hidden" value="" id="type" name="type" />
							</div>
						</div>
					</div>
				</div>
			</div>
	</form>
	</div>
	<!-- /.main-content -->
	<script type="text/javascript">
		var currentpage = ${model_song.page};
		var visiblepage = ${model_song.maxpage};
		var totalpage = ${model_song.totalpage};
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
						$('#sortName').val('id_author');
						$('#sortBy').val('DESC');
						$('#type').val('list');
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
			deletesong(data);
		});

		function deletesong(data){
			$.ajax({
				url:'${APIurl}', // api muốn gọi về
				type:'DELETE', // kiểu dữ liệu mapping api
				contentType:'application/json', // kiểu dữ liệu từ clinet về server
				data:JSON.stringify(data), // chuyển từ javascript object sang json
				// dataType: 'json', // dữ liệu giả veef cho client là json
				success: function (result){
					window.location.href = "${Songurl}?type=list&page=1&maxpage=2";
				},
				error: function (error){
					console.log(error);
				}
			});
		}


	</script>
</body>
</html>