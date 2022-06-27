<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
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
    <link rel="stylesheet" href="/web/cart/main.css">
	<link rel="stylesheet" href="/web/order/main.css">	
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
   	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
<script type="text/javascript">

var username = localStorage.getItem('username');
var orderList = [];
$(document).ready(function(){
	loadOrderList();	
});
function loadOrderList() {
	$.ajax({
		url : '/api/findAllByIdCustomer/'+username,
		type : 'GET',
		contentType : 'application/json',
		data : JSON.stringify(),
		dataType : 'json',
		success : function(result) {		
			orderList = result;
			console.log(orderList);
			var str ="";
			$.each(orderList,function(i,item){
				$.each(item.listOrder,function(j,orderDetail){
				str+="<div class='row'>";
				str+="<div class='col l-3'>";
				str+="<div class='shoppingcart__heading'>";
				str+="<img src='"+orderDetail.bookOrder.urlImage+"' alt='' class='shoppingcart__item-img'>";
				str+="<div class='shoppingcart__label'>"+orderDetail.bookOrder.name+"</div>";
				str+="</div>";
				str+="</div>";
				str+="<div class='col l-3'>";
				str+="<div class='shoppingcart__label'>"+orderDetail.number+"</div>";
				str+="</div>";
				str+="<div class='col l-3'>";
				str+="<div class='shoppingcart__label'>"+item.status+"</div>";
				str+="</div>";
				str+="<div class='col l-3'>";
				str+="<div class='shoppingcart__label'>"+orderDetail.bookOrder.price*orderDetail.number+" đồng </div>";
				str+="</div>";
				
				str+="</div>";
				});
			});
			document.getElementById('orderList').innerHTML = str;
		},
		error : function(error) {
			
		}
	});
}
</script>

    <!-- Dựng khung web -->
    <div class="app">
         <%@ include file="/common/web/header.jsp" %>

        <div class="app__container">
            <div class="heading-order">Đơn hàng của tôi</div>
            <div class="grid wide">
                <div class="row  app__content">
                    <div class="col l-2 m-0 c-0">
                        <nav class="category">
                            <h3 class="category__heading">
                                Danh mục sách
                            </h3>
            
                            <ul class="category-list">
                                <li class="category-item category-item--active">
                                    <a href="#" class="category-item__link">Khoa học</a>
                                </li>
                                <li class="category-item">
                                    <a href="#" class="category-item__link">Giải trí</a>
                                </li>
                                <li class="category-item">
                                    <a href="#" class="category-item__link">Thám hiểm</a>
                                </li>
                            </ul>
                        </nav>
                    </div>

                    <div class="col l-10 m-12 c-12">                        
                        <div class="shoppingcart">
                            <div class="row bgrow">
                                <div class="col l-12">
                                    <div class="row">
                                        <div class="col l-3">
                                            <div class="shoppingcart__headings">Đơn hàng</div>
                                        </div>
                                        <div class="col l-3">
                                            <div class="shoppingcart__headings">Số lượng</div>
                                        </div>
                                        <div class="col l-3">
                                            <div class="shoppingcart__headings">Trạng thái</div>
                                        </div>
                                        <div class="col l-3">
                                            <div class="shoppingcart__headings">Tổng tiền</div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row mt-10 verticalrow bgrow">
                                <div class="col l-12">
                                   <div id="orderList"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

       <%@ include file="/common/web/footer.jsp" %>
    </div>
</body>
</html>