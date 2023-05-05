<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="sidebar" class="sidebar                  responsive                    ace-save-state">
    <script type="text/javascript">
        try{ace.settings.loadState('sidebar')}catch(e){}
    </script>
    <div class="sidebar-shortcuts">
        <div class="sidebar-shortcuts-large">
            <button class="btn btn-success">
                <i class="ace-icon fa fa-signal"></i>
            </button>

            <button class="btn btn-info">
                <i class="ace-icon fa fa-pencil"></i>
            </button>

            <button class="btn btn-warning">
                <i class="ace-icon fa fa-users"></i>
            </button>

            <button class="btn btn-danger">
                <i class="ace-icon fa fa-cogs"></i>
            </button>
        </div>
        <div class="sidebar-shortcuts-mini">
            <span class="btn btn-success"></span>

            <span class="btn btn-info"></span>

            <span class="btn btn-warning"></span>

            <span class="btn btn-danger"></span>
        </div>
    </div>
    <ul class="nav nav-list">
        <li >
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-list"></i>
                <span class="menu-text"></span>
                Quản lý nhạc
                <b class="arrow fa fa-angle-down"></b>
            </a>
            <b class="arrow"></b>
            <ul class="submenu">
                <li>
<%--                    <c:url var="listURL" value="/admin-new">--%>
<%--                        <c:param name="page" value="1"/>--%>
<%--                        <c:param name="maxpage" value="2"/>--%>
<%--                        <c:param name="sortName" value="id_author"/>--%>
<%--                        <c:param name="sortBy" value="DESC"/>--%>
<%--                        <c:param name="type" value="list"/>--%>
<%--                    </c:url>--%>
<%--                    <a href='${listURL}' >--%>
<%--                        <i class="menu-icon fa fa-caret-right"></i>--%>
<%--                        DS nhạc--%>
<%--                    </a>--%>

                        <a href='<c:url value="/admin-rank?page=1&maxpage=2&sortName=amount_add&sortBy=DESC&type=list"/>'>
                            <i class="menu-icon fa fa-caret-right"></i>
                            Bảng xếp hạng
                        </a>

                          <a href='<c:url value="/admin-category?page=1&maxpage=2&sortName=id_category&sortBy=DESC&type=list"/>'>
                               <i class="menu-icon fa fa-caret-right"></i>
                                DS thể loại
                          </a>

                          <a href='<c:url value="/admin-author?page=1&maxpage=2&sortName=id_author&sortBy=DESC&type=list"/>'>
                                <i class="menu-icon fa fa-caret-right"></i>
                                DS tác giả
                          </a>

                           <a href='<c:url value="/admin-new?page=1&maxpage=2&sortName=id_author&sortBy=DESC&type=list"/>'>
                                  <i class="menu-icon fa fa-caret-right"></i>
                                DS nhạc
                           </a>
                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
    </ul>
    <div class="sidebar-toggle sidebar-collapse">
        <i class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
    </div>
</div>