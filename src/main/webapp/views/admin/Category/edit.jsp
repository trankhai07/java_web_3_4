<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-category"/>
<%--<c:url var ="NewURL" value="/admin-new"/>--%>
<html>
<head>
  <title>Chỉnh thể loại</title>
</head>
<body>
<div class="main-content">
  <div class="main-content-inner">
    <div class="breadcrumbs" id="breadcrumbs">
      <script type="text/javascript">
        try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
      </script>
      <ul class="breadcrumb">
        <li>
          <i class="ace-icon fa fa-home home-icon"></i>
          <a href="<c:url value="/admin-home"/>">Trang chủ</a>
        </li>
        <li class="active">Chỉnh sửa thể loại</li>
      </ul><!-- /.breadcrumb -->
    </div>
    <div class="page-content">
      <div class="row">
        <div class="col-xs-12">
          <c:if test="${not empty messageResponse}">
            <div class="alert alert-${alert}">
                ${messageResponse}
            </div>
          </c:if>
<%--          <form id="formSubmit">--%>
<%--            <div class="form-group">--%>
<%--              <label class="col-sm-3 control-label no-padding-right">id_music</label>--%>
<%--              <div class="col-sm-9">--%>
<%--                  <input type="text" class="form-control" id="id_music" name="id_music" value="">--%>
<%--              </div>--%>
<%--            </div>--%>

            <form id="formSubmit">

                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right">Thể loại</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="name" name="name" value="${model_song.name}">
                    </div>
                </div>

                <br/>
                <br/>
                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right">Mô tả chi tiết</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="description" name="description" value="${model_song.description}">
                    </div>
                </div>

                <br/>
                <br/>

                <div class="form-group">

                    <div class="col-sm-12">
                        <c:if test="${not empty model_song.id_category}">
                            <input type="button" class="btn btn-white btn-warning btn-bold" id="btnAddorUpdate" name="" value="Cập nhật thể loại">
                        </c:if>

                        <c:if test="${empty model_song.id_category}">
                            <input type="button" class="btn btn-white btn-warning btn-bold" id="btnAddorUpdate" name="" value="Thêm mới thể loại">
                        </c:if>
                    </div>
                </div>
                <input type ="hidden" id="id_category" name="id_category" value="${model_song.id_category}">
            </form>


        </div>
      </div>
    </div>
  </div>
</div>
<script>
    // jquery
    $('#btnAddorUpdate').click(function (e){
        e.preventDefault();// submit vào trong đc mặc định
        // var author_name = $('#author_name').val();
        // var categorycode = $('#categorycode').val();
        // var name = $('#name').val();
        // var filemusic = $('#filemusic').val();

        var data = {};
        var formData = $('#formSubmit').serializeArray();
        $.each(formData,function (i,v) { // v: include name and value of input
            data[""+v.name+""] = v.value;
        });

        var id_category = $('#id_category').val();
        if(id_category == ""){
            addSong(data);
        }else{
            updateSong(data);
        }
    });

    function addSong(data){
        $.ajax({
            url:'${APIurl}', // api muốn gọi về
            type:'POST', // kiểu dữ liệu mapping api
            contentType:'application/json', // kiểu dữ liệu từ clinet về server
            data:JSON.stringify(data), // chuyển từ javascript object sang json
            dataType: 'json', // dữ liệu giả veef cho client là json
            success: function (result){
                console.log(result);
            },
            error: function (error){
                console.log(error);
            }
        });
    }
    function updateSong(data){
        $.ajax({
            url:'${APIurl}',
            type:'PUT',
            contentType:'application/json',
            data: JSON.stringify(data), // convert to javascript object from Json
            dataType: 'json',
            success: function (result){
                console.log(result);
            },
            error: function (error){
                console.log(error);
            }
        });
    }
</script>
</body>
</html>
