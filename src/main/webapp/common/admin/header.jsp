<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div id="navbar" class="navbar navbar-default  ace-save-state">
    <div class="navbar-container ace-save-state" id="navbar-container">
        <div class="navbar-header pull-left">
            <a href="<c:url value='/admin'/> " class="navbar-brand">
                <small>
                    <i class="fa fa-leaf"></i>
                    Trang quản trị
                </small>
            </a>
        </div>
        </div>
        <div class="navbar-buttons navbar-header pull-right collapse navbar-collapse" role="navigation">
            <ul class="nav ace-nav">
            	<%-- <security:authorize access="isAnonymous()">
            	<a data-toggle="dropdown"  class="dropdown-toggle" >
                       Đăng nhập
                    </a>
                    </li>
            	</security:authorize>
            	<security:authorize access="isAuthenticated()">
                <li class="light-blue dropdown-modal">
                    <a data-toggle="dropdown"  class="dropdown-toggle" >
                      Xin chào, <%=SecurityUtils.getPrincipal().getFullname()%> 
                    </a>
                    </li>
                    --%>
                  <li class="light-blue dropdown-modal">
                        <a href='<c:url value="/admin-inforTeacher"/>'>                       
                           Thông Tin Cá Nhân
                        </a>
                  </li>
                   <li class="light-blue dropdown-modal">
                        <a href='<c:url value="/bookshop/login"/>'>
                            <i class="ace-icon fa fa-power-off"></i>
                            Thoát
                        </a>
                   </li>
                 <%--   </security:authorize> --%>
            </ul>
        </div>
    </div>