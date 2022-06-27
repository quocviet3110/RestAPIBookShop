<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/common/taglib.jsp" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shop bán sách tốt!</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap">
    <link rel="stylesheet" href="/web/assets/css/grid.css">
    <link rel="stylesheet" href="/web/assets/css/base.css">
    <link rel="stylesheet" href="/web/assets/css/style.css">
    <link rel="stylesheet" href="/web/assets/css/responsive.css">

    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
   	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src='/paging/jquery.twbsPagination.js'></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<script type="text/javascript">
	var caterogyList = [];
	$(document).ready(function(){
		loadCategory();	
	});
	function loadCategory() {
		$.ajax({
			url : '/api/categoryList',
			type : 'GET',
			contentType : 'application/json',
			data : JSON.stringify(),
			dataType : 'json',
			success : function(result) {		
				caterogyList = result;
				var str ="";
				str += "<div id='button-nav'>";
				$.each(caterogyList,function(i,item){
					 str +=  "<li class='category-item category-item--active'>";
					 str += "<button  class='category-item__link btn js-btn-category'>"+item.name+"</button></li>";	
			
				});
				 str +="</div>"
				document.getElementById('idCategory').innerHTML = str;
			},
			error : function(error) {
				
			}
		});
	}
</script>
    <!-- Dựng khung web -->
    <div class="app">
        <!-- header -->
    	<%@ include file="/common/web/header.jsp" %>
  	 <!-- header -->
        <div class="app__container">
            <div class="grid wide">
                <div class="row  app__content">
                    <div class="col l-2 m-0 c-0">
                        <nav class="category">
                            <h3 class="category__heading">
                                Danh mục sách
                            </h3>
                            <ul class="category-list" id="idCategory">
                            </ul>
                        </nav>
                    </div>
    
                    <div class="col l-10 m-12 c-12">
                        <div class="home-filter hide-on-mobile-tablet">
                            <span class="home-filter__label" >Sắp xếp theo</span>
                            <button id="txtSearch"  name="txtSearch" class="home-filter__btn btn">Phổ biến</button>
                            <button id="sortById"  class="home-filter__btn btn btn--primary">Mới nhất</button>
                            <button class="home-filter__btn btn">Bán chạy</button>

                            <div class="select-input">
                                <span class="select-input__label">Giá</span>
                                <i class="select-input__icon fas fa-angle-down"></i>

                                <!-- List option -->
                                <ul class="select-input__list">
                                    <li class="select-input__item">
                                        <button id="sortByPriceASC" class="select-input__link">Giá: Thấp đến cao </buton>
                                    </li>
                                    <li class="select-input__item">
                                        <button id="sortByPriceDEC"  class="select-input__link" >Giá: Cao đến thấp</button>
                                    </li>
                                </ul>
                            </div>

                            <div class="home-filter__page">
                                <span class="home-filter__page-num">
                                    <span class="home-filter__page-current">1</span>/14
                                </span>

                                <div class="home-filter__page-control">
                                    <a href="#" class="home-filter__page-btn home-filter__page-btn--disabled">
                                        <i class="home-filter__page-icon fas fa-angle-left"></i>
                                    </a>
                                    <a href="#" class="home-filter__page-btn">
                                        <i class="home-filter__page-icon fas fa-angle-right"></i>
                                    </a>
                                </div>
                            </div>
                        </div>

                        <div class="home-product">
                            <div class="row sm-gutter" id="listBook"> 
                               
                            </div>
                        </div>
                        <ul class="pagination" id="pagination"></ul>
                    </div>
                </div>
            </div>
        </div>

        <%@ include file="/common/web/footer.jsp" %>
    </div>
    
    <script type="text/javascript">
    var bookList = [];
    var text;
	$(document).ready(function(){
		 var load = function (keyword,page,sortBy,sortName) {
		 $.ajax({
				url : '/api/bookList',
				type : 'GET',
				contentType : 'application/json',
				data: { page: page , limit:10, keyword:keyword,sortBy:sortBy,sortName:sortName},
				dataType : 'json',
				success : function(result) {		
					bookList = result.listResult;
					var totalPages  = result.totalPage;
					var currentPage  = result.page;	
					var str ="";
					$.each(bookList,function(i,item){
						str +=  "<div class='col l-2-4 m-4 c-6'>";
						str += "<a class='home-product-item' href='/bookshop/bookDetail?id="+item.id+"'>"
						str += "<div class='home-product-item__img' style='background-image: url("+item.urlImage+");'></div>"
						str+= "<h4 class='home-product-item__name'>"+item.name+"</h4>";
						str+= "<div class='home-product-item__price'>"+
                        	"<span class='home-product-item__price-old'>"+(item.price+50000)+"</span>"+
                        	"<span class='home-product-item__price-current'>"+item.price+"đ</span></div>";
						str+= "<div class='home-product-item__action'>"+
                            "<span class='home-product-item__like home-product-item__like--liked'>"+
                            "<i class='home-product-item__like-icon-empty far fa-heart></i>"+
                        	"<i class='home-product-item__like-icon-fill fas fa-heart'></i></span>";
						str+= "<div class='home-product-item__rating'>"+
                        "<i class='home-product-item__star--gold fas fa-star'></i>"+
                        "<i class='home-product-item__star--gold fas fa-star'></i>"+
                        "<i class='home-product-item__star--gold fas fa-star'></i>"+
                        "<i class='home-product-item__star--gold fas fa-star'></i>"+
                        "<i class='fas fa-star'></i></div>"+
                    	"<span class='home-product-item__sold'>88 đã bán</span></div>";
						str+="<div class='home-product-item__origin'>"+
                        "<span class='home-product-item__brand'>Whoo</span>"+
                        "<span class='home-product-item__origin-name'>Nhật Bản</span></div>"+
                    	"<div class='home-product-item__favourite'>"+
                        "<i class='fas fa-check'></i>"+
                        "<span>Yêu thích</span> </div>"+
                    	"<div class='home-product-item__sale-off'>"+
                        "<span class='home-product-item__sale-off-persent'>10%</span>"+
                        "<span class='home-product-item__sale-off-label'>GIẢM</span></div> </a></div>";
					});
					document.getElementById('listBook').innerHTML = str;
					 $(function() {
							window.pagObj = $('#pagination').twbsPagination({
								totalPages : totalPages,
								visiblePages : 5,
								startPage : currentPage,
								onPageClick: function (evt, page) {
									var keyword = document.getElementById("txtSearch").value;
									 if (keyword != "") {
						                   load(keyword, page,null,null); 
						               }
						               else {
						                   load(null, page,null,null);
						               }

								 }
								
							});
						}); 
				}
		 
			});
		 }
		
		 $("#sortById").click(function () {
              load(null, 1,"id","dec");            
         });
		 $("#sortByPriceASC").click(function () {
             load(null, 1,"price","asc");            
        });
		 $("#sortByPriceDEC").click(function () {
             load(null, 1,"price","dec");            
        });
		 $("#search").click(function () {
			 var keyword = document.getElementById("txtSearch").value;
             if (keyword != "") {
                 load(keyword, 1,null,null);
             }
             else {
                 load(null, 1,null,null);
             }
              
         });
		//load trang đầu tiên
		 load(null,1,null,null);
		 var  btnCategorys = document.getElementsByClassName('js-btn-category');
		 console.log(btnCategorys); 
	    for (let btnCategory of btnCategorys) {
	       btnCategory.onclick = async function () {
	       		/* console.log(btnCategory); 
	               text = await btnCategory.innerHTML;
	               console.log(text); */
	               await test();
	       }
	 
	    }
	});	
		

   function test(){
	   console.log("123")
   }
    </script>
</body>
</html>