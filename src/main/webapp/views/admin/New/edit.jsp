<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-song"/>
<%--<c:url var ="NewURL" value="/admin-new"/>--%>
<html>
<head>
  <title>Chỉnh sửa bài viết</title>
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
        <li class="active">Chỉnh sửa bài viết</li>
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
                    <label class="col-sm-3 control-label no-padding-right">author</label>
                    <div class="col-sm-9">
                        <select class="form-control" id="author_name" name="author_name">
                            <option value="">Chọn tác giả</option>
                            <c:forEach var="item" items="${authors}">
                                <option value="${item.name}"<c:if test="${item.id_author == model_song.id_author}">selected="selected"</c:if>>
                                        ${item.name}
                                </option>
                            </c:forEach>
                        </select>
                        <%--                <input type="text" class="form-control" id="id_author" name="id_author" value="">--%>
                    </div>
                </div>

                <br/>
                <br/>
                <br/>
                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right">category</label>
                    <div class="col-sm-9">
                        <select class="form-control" id="categorycode" name="categorycode">
                            <option value="">Chọn loại bài viết</option>
                            <c:forEach var="item" items="${categories}">
                                <option value="${item.name}" <c:if test="${item.id_category == model_song.id_category}">selected="selected"</c:if>>
                                        ${item.name}
                                </option>
                            </c:forEach>

                        </select>
                        <%--                <input type="text" class="form-control" id="id_category" name="id_category" value="">--%>
                    </div>
                </div>

                <br/>
                <br/>

                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right">Số lượt tải</label>
                    <div class="col-sm-9">

                        <select class="form-control" id="amount_add" name="amount_add">
                            <option value="">Chọn số lượt tải</option>
                            <c:forEach var="item" items="${rank_musics}">
                                <option value="${item.id_music}" <c:if test="${item.amount_add == model_song.amount_add}">selected="selected"</c:if>>
                                        ${item.amount_add}
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <br/>
                <br/>

                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right">name</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="name" name="name" value="${model_song.name}">
                    </div>
                </div>

                <br/>
                <br/>
                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right">filemusic</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="filemusic" name="filemusic" value="${model_song.filemusic}">
                    </div>
                </div>

                <br/>
                <br/>

                <div class="form-group">

                    <div class="col-sm-12">
                        <c:if test="${not empty model_song.id_music}">
                            <input type="button" class="btn btn-white btn-warning btn-bold" id="btnAddorUpdate" name="" value="Cập nhật nhạc">
                        </c:if>

                        <c:if test="${empty model_song.id_music}">
                            <input type="button" class="btn btn-white btn-warning btn-bold" id="btnAddorUpdate" name="" value="Thêm mới nhạc">
                        </c:if>
                    </div>
                </div>
                <input type ="hidden" id="id_music" name="id_music" value="${model_song.id_music}">
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
        $.each(formData,function (i,v) { // v: include name value of input
            data[""+v.name+""] = v.value;
        });

        var id_music = $('#id_music').val();
        if(id_music == ""){
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
