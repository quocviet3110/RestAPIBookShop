<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Giỏ hàng</title>
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
    <link rel="stylesheet" href="/web/cart/main.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
	<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css">
</head>

<body>

<script type="text/javascript">
	var username = localStorage.getItem('username');
	var cartList = [];
	$(document).ready(function(){
		loadCartList();	
	});
	function loadCartList() {
		$.ajax({
			url : '/api/cart/'+username,
			type : 'GET',
			contentType : 'application/json',
			data : JSON.stringify(),
			dataType : 'json',
			success : function(result) {		
				cartList = result.listResult;
				console.log(cartList);
				var str ="";

				$.each(cartList,function(i,item){
					str +=  "<div class='row mt-10 verticalrow bgrow'>";
					str +=	"<div class='col l-4'>";
					str +=	"<div class='shoppingcart__heading'> <input type='checkbox' id='checkbox_"+item.id + "' value='"+item.id+"'>";
					str +=   "<img src='"+item.bookCart.urlImage+"' alt='' class='shoppingcart__item-img'>";
					str +=    "<div class='shoppingcart__label'>"+item.bookCart.name+"</div>";
					str +=  "</div>";
					str +=  "</div>";
                    str += "<div class='col l-8'>";
                    str += "<div class='row'>";
                    str += "<div class='col l-3'>";
                    str +=    "<div class='shoppingcart__headings'>"+item.bookCart.price+"</div>";
                    str +=    "</div>";
                    str +=    "<div class='col l-4'>";
                    str +=     "<div class='orderquantity shoppingcart__headings'>";
                    str +=     "<button class='btnSL'>-</button>";
                    str +=     "<input type='text' value='"+item.number+"' class='inputquantity'>";
                    str +=     "<button class='btnSL'>+</button></div></div>";
                    str +=	" <div class='col l-4'><div class='shoppingcart__headings'> "+item.bookCart.price*item.number+"đ</div>";
                    str+= 	"</div>";
                    str+=	"<div class='col l-1'>";
                    str+=	"<button type='button' class='shoppingcart__headings'onclick='warningBeforeDelete()'>";
                    str+=    "<i class='far fa-trash-can'></i>";
                    str+= 	"</button>";
                    str +=	"</div>";           
                    str +=   "</div>";
                    str += "</div>";
                    str += "</div>";
				});
				document.getElementById('idCart').innerHTML = str;
			},
			error : function(error) {
				
			}
		});
	}
</script>
    <div class="app">
       <%@ include file="/common/web/header.jsp" %>
        <div class="app__container">
            <div class="grid wide">
                <div class="row app__content">
                    <div class="col l-9">
                        <div class="shoppingcart">
                            <div class="row bgrow">
                                <div class="col l-4">
                                    <div class="shoppingcart__heading">
                                        <input type="checkbox">
                                        <div class="shoppingcart__label">Tất cả ()</div>
                                    </div>
                                </div>

                                <div class="col l-8">
                                    <div class="row">
                                        <div class="col l-3">
                                            <div class="shoppingcart__headings">Đơn giá</div>
                                        </div>
                                        <div class="col l-4">
                                            <div class="shoppingcart__headings">Số lượng</div>
                                        </div>
                                        <div class="col l-4">
                                            <div class="shoppingcart__headings">Thành tiền</div>
                                        </div>
                                        <div class="col l-1">
                                            <div class="shoppingcart__headings">
                                                <i class="far fa-trash-can"></i>
                                            </div>
                                        </div>
                                    </div>
                                </div>                      
                            </div>
							 <div id="idCart"></div>
                            </div>
                            </div>
                    <div class="col l-3">
                        <div class="paymentinfo">
                            <div class="customerinfo">
                                <div class="customerinfo__heading">Thông tin khách hàng</div>
                                <div class="customerinfo__label">Họ tên:
                                    <span class="customerinfo__content">
                                        Đổ Gia Lãm
                                    </span>
                                </div>
                                <div class="customerinfo__label">Sđt:
                                    <span class="customerinfo__content">
                                        0123456789
                                    </span>
                                </div>
                                <div class="customerinfo__label">Địa chỉ:
                                    <span class="customerinfo__content">
                                        97 Man Thiện Phường 9, Quận 9, TPHCM
                                    </span>
                                </div>
                            </div>

                            <div class="payment">
                                <div class="payment__heading">Chi phí thanh toán</div>
                                <div class="payment__label">Tổng cộng:
                                    <span class="payment__content">
                                        Vui lòng chọn sản phẩm
                                    </span>
                                </div>
                            </div>

                            <button class="btn" id="btnBuyProduct">Mua hàng</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
       <%@ include file="/common/web/footer.jsp" %>
    </div>
    <script type="text/javascript">
    var data = {};
    var ids ={};
    $("#btnBuyProduct").click(function() {
		var data = {};
		ids = $('input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
		data['ids'] = ids;
		data['username'] = localStorage.getItem('username');
		console.log(data);
		
	});
    function warningBeforeDelete() {
		swal({
		  title: "Xác nhận xóa",
		  text: "Bạn có chắc chắn muốn xóa hay không",
		  type: "warning",
		  showCancelButton: true,
		  confirmButtonClass: "btn-success",
		  cancelButtonClass: "btn-danger",
		  confirmButtonText: "Xác nhận",
		  cancelButtonText: "Hủy bỏ",
		},
		function(isConfirm) {
		  if (isConfirm) {
			  ids = $('input[type=checkbox]:checked').map(function () {
		            return $(this).val();
		        }).get();
				deleteCart(ids);
				console.log(ids);
		  }
		});
	}  
	function deleteCart(ids) {
		$.ajax({
		url : '/api/cart',
		type : 'DELETE',
		contentType : 'application/json',
		data : JSON.stringify(ids),
		success : function(result) {
				window.location.href = "/bookshop/cart";	
		}
		});
	}
    </script>
</body>

</html>