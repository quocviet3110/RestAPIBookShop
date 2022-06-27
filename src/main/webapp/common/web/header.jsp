<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="header">
            <div class="grid wide">
                <div class="header__navbar">
                    <div class="header__navbar-logo">
                      <a href="/bookshop/trang-chu">BookShop</a>  
                    </div>

                    <div class="header__navbar-search">
                        <div class="header__search-input-wrap">
                            <input type="text" id="txtSearch"  name="txtSearch" class="header__search-input" placeholder="Nhập tên sách để tìm kiếm">
                            
                            <!-- Search history -->
                            <div class="header__search-history">
                                <h3 class="header__search-history-heading">Lịch sử tìm kiếm</h3>
                                <ul class="header__search-history-list">
                                    <li class="header__search-history-item">
                                        <a href="#">Hành trình về phương đông</a>
                                    </li>
                                    <li class="header__search-history-item">
                                        <a href="#">Tình yêu chiến tranh</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <button class="header__search-btn" id="search">
                            <i class="header__search-btn-icon fas fa-search"></i>
                        </button>
                    </div>

                    <div class="header__navbar-other">
                        <ul class="header__navbar-list">
                            
                            <!-- <li class="header__navbar-item">
                                <a href="#" class="header__navbar-link">
                                    <i class="far fa-bell header__navbar-item-icon"></i>
                                    
                                    THÔNG BÁO
                                </a>
                            </li> -->
                             
                            <li class="header__navbar-item">
                              <a href="/bookshop/cart" class="header__navbar-link">
                                    <div class="header__navbar-cart-common">
                                        <i class="fa fa-shopping-cart header__navbar-item-icon"></i>
             
                                        <span class="ml-4">GIỎ HÀNG</span>
                                    </div>

                                
                                </a>
                            </li>
                            <li class="header__navbar-item" >
                                <a href="/bookshop/order" class="header__navbar-link">
                                    <i class="far fa-registered header__navbar-item-icon"></i>
                                   HÓA ĐƠN</a>
                            </li>
                            <li class="header__navbar-item" id="infor">
                                <a href="#" class="header__navbar-link">
                                    <i class="far fa-registered header__navbar-item-icon"></i>
                                    ĐĂNG KÝ</a>
                            </li>
                            <li class="header__navbar-item" id="logOut">
                                <a href="/bookshop/login" class="header__navbar-link">
                                    <i class="fa fa-sign-in header__navbar-item-icon"></i>
                                    ĐĂNG NHẬP</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript">
        var username = localStorage.getItem('username');
        if(username != null){
        	str="";
        	str+= "<li class='header__navbar-item'>";
        	str+= "<a href='#' class='header__navbar-link'>";
        	str+= "<i class='far fa-registered header__navbar-item-icon'></i>";
        	str+= "Xin chào "+username+"</a>";
        	str+= "</li>";
        	document.getElementById('infor').innerHTML = str;
        	str="";
        	str+= "<li class='header__navbar-item'>";
        	str+= "<a href='/bookshop/login' class='header__navbar-link'>";
        	str+= "<i class='far fa-registered header__navbar-item-icon'></i>";
        	str+= "ĐĂNG XUẤT</a>";
        	str+= "</li>";
        	document.getElementById('logOut').innerHTML = str;
        }
        
        

		</script>
        