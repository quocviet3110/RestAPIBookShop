<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
	<link rel="stylesheet" href="/web/bookdetail/style.css">
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
   	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src='/paging/jquery.twbsPagination.js'></script>
    

</head>
</head>
    <body>
        <div class="app">
           <%@ include file="/common/web/header.jsp" %>

            <div class="app__container">
                <div class="grid wide">
                    <!-- Product -->
                    <div class="main__product" id="bookDetail">
                        
                       
                    </div>

                    <!-- Thông tin chi tiết -->
                    <div class="detailinfo">
                        <div class="detailinfo__heading">THÔNG TIN CHI TIẾT</div>

                        <div class="detailinfo__items">
                            <div class="colorGray pt-4 pb-4">Nhà xuất bản: NXB Phụ Nữ Việt Nam</div>
                            <div class="mt-8 pt-4 pb-4">Ngày xuất bản: 08/03/2022</div>
                            <div class="mt-8 pt-4 pb-4 colorGray">Nhà phát hành: SkyBooks</div>
                            <div class="mt-8 pt-4 pb-4">Kích thước: 11.0 x 17.0 x 2.0 cm</div>
                            <div class="mt-8 pt-4 pb-4 colorGray">Số trang: 152 trang</div>
                            <div class="mt-8 pt-4 pb-4">Trọng lượng: 500 gram</div>
                        </div>
                    </div>

                    <!-- Sản phẩm tương tự -->
                    <div class="productalmostlike">
                        <div class="productalmostlike__heading">Sản phẩm tương tự</div>
                        <div class="row sm-gutter" id="listBook">
             			</div>
             		</div>
             		
                    <!-- Comment -->
                    <div class="wrapper-comment" id="commentList">
                        <div class="heading-comment">Bình luận
                          <span class="total-comment">(3)</span>
                          
                        </div>
                    </div>
                </div>
            </div>
           
        </div>
         <%@ include file="/common/web/footer.jsp" %>
	 <script type="text/javascript">
	 var id = null;
	    var bookList = [];
	    var commentList=[];
		$(document).ready(function(){
			var url = window.location.search;
			function getUrlVars(url) {
			    var vars = {};
			    var parts = url.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
			        vars[key] = value;
			    });
			    return vars;
			}
			id = getUrlVars(url)['id'];
			loadBookFindId(id);
			loadCommentFindIdBook(id);
		});
		function loadBookFindId(id) {
			$.ajax({
				url : '/api/book/'+id,
				type : 'GET',
				contentType : 'application/json',
				data : JSON.stringify(),
				dataType : 'json',
				success : function(result) {		
					book = result;
					var idCategory= book.idCategory;
					var str ="";
						str  += "<div class='main__product-img' style='background-image: url("+book.urlImage+");'></div>";
						str += "<div class='main__product-info'> <h1 class='main__product-name'> "+book.name+"</h1>";
						str += "<h3 class='main__product-price'> Giá thành:"+book.price+" đ</h3>";
						str += "<p class='main__product-desc'>"+book.title+"</p>";
						str += "<p class='main__product-desc'> Tác giả: "+book.authors.name+"</p>";
						str += "<p class='main__product-desc'> Số lượng tồn: "+book.number+"</p>";
						str += "<div class='orderquantity__wrapper'>"+
	                   			"<div class='quantitylabel'>Số lượng</div>"+
	                    		"<div class='orderquantity'>"+
	                        	"<button class='btn'>-</button>"+
	                        	"<input type='text' id='number' value='1' class='inputquantity'>"+
	                        	"<button class='btn'>+</button></div></div>";
	                    str += "<button class='btn btn--primary' id='btnAdd' style='background-color:green !important' >Thêm vào giỏ hàng</button>"; 
	                    str += "<button class='btn btn--primary'>Chọn mua</button>";
					document.getElementById('bookDetail').innerHTML = str;
					loadBookFindIdCategory(idCategory);
				},
				error : function(error) {
					
				}
			});
		}
		function loadCommentFindIdBook(id) {
			$.ajax({
				url : '/api/comment/'+id,
				type : 'GET',
				contentType : 'application/json',
				data : JSON.stringify(),
				dataType : 'json',
				success : function(result) {		
					commentList = result.listResult;
					console.log(commentList);
					var str ="";
					str += "<div class='gen-comment'>";
					str += "<div class='heading-comment'>Bình luận<span class='total-comment'>(3)</span></div>";
					str +="<div class='form-comment'>";
					str +="<input type='text' class='input-comment' placeholder='Bạn muốn bình luận ...'>";
					str +="<button type='button' id='btnAddComment' class='btn'>Gửi</button> </div></div>";
              
					$.each(commentList,function(i,item){
						str+= "<div class='wrapper-img'>"+
	                    	"<img class='img-commenter' src='data:image/png;base64,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' alt=''></div>";
						str+="<div class='info-comment'><div class='name-commenter> "+item.customerComment.name+" </div>"+
	               			 +"<div class='date-comment'>"+item.date+"</div>"+
	               				"<div class='content-comment'>"+item.content+"</div> </div> </div>";				
					});
					document.getElementById('commentList').innerHTML = str;
				},
				error : function(error) {
					
				}
			});
		}
		function loadBookFindIdCategory(idCategory) {
			$.ajax({
				url : '/api/bookList/'+idCategory,
				type : 'GET',
				contentType : 'application/json',
				data : JSON.stringify(),
				dataType : 'json',
				success : function(result) {		
					bookList = result.listResult;
					var str ="";
					$.each(bookList,function(i,item){
						str +=  "<div class='col l-2-4 m-4 c-6'>";
						str += "<a class='home-product-item' href='/bookshop/bookDetail?id="+item.id+"'>"
						str += "<div class='home-product-item__img' style='background-image: url("+item.urlImage+");'></div>"
						str+= "<h4 class='home-product-item__name'>"+item.name+"</h4>";
						str+= "<div class='home-product-item__price'>"+
	                    	"<span class='home-product-item__price-old'>"+item.name+"</span>"+
	                    	"<span class='home-product-item__price-current'>999.000đ</span></div>";
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
				},
				error : function(error) {
					
				}
			});
		}
		var comment={};
		$('#btnAddComment').click(function(e) {
		         event.preventDefault();
		         console.log("a");
		        comment['username']= localStorage.getItem('username');
		        comment['idBook']=id;
		        comment['content']=document.getElementById('contentComment').value;
		        addCommet(comment);
		});
	 function addComment(comment) {
  		$.ajax({
  			url : '/api/comment',
  			type : 'POST',
  			contentType : 'application/json',
  			data : JSON.stringify(comment),
  			dataType : 'json',
  			success : function(result) {
  				 console.log("Thành Công");
  			},
  			error : function(error) {
  			}
  		});
  	}
	 var data={};
	 $('#btnAdd').click(function(e) {
			e.preventDefault();		
			data['idBook']=id;
			data['username']= localStorage.getItem('username');
			data['number']=document.getElementById('number').value;
			addCart(data)
		});
        
         function addCart(data) {
     		$.ajax({
     			url : '/api/cart',
     			type : 'POST',
     			contentType : 'application/json',
     			data : JSON.stringify(data),
     			dataType : 'json',
     			success : function(result) {
     				 console.log("Thành Công");
     			},
     			error : function(error) {
     			}
     		});
     	}
         </script>
    </body>
</html>