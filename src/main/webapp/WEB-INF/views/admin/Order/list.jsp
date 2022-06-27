<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trang chủ</title>

<link rel="stylesheet" href="/admin/assets/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/admin/assets/font-awesome/4.2.0/css/font-awesome.min.css">
<link rel="stylesheet" href="/admin/assets/css/ace.min.css"
	class="ace-main-stylesheet" id="main-ace-style" />
<script src="/admin/assets/js/ace-extra.min.js"></script>
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type='text/javascript' src="/admin/js/jquery-2.2.3.min.js"></script>
<script src="/admin/assets/js/jquery.2.1.1.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


<script src='/paging/jquery.twbsPagination.js'></script>
<!-- sweetalert -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css">

</head>
<body class="no-skin">

	<!-- header -->
	<%@ include file="/common/admin/header.jsp"%>
	<!-- header -->

	<!-- <div class="main-container" id="main-container"> -->
	<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
		</script>
	<!-- header -->
	<%@ include file="/common/admin/menu.jsp"%>
	<!-- header -->


	<!-- /.main-content -->


	<div class="main-content">
		<form class="form-horizontal" role="form" id="formSubmit">
			<div class="main-content-inner">
				<div class="breadcrumbs" id="breadcrumbs">
					<script type="text/javascript">
					try {
						ace.settings.check('breadcrumbs', 'fixed')
					} catch (e) {
					}
				</script>

					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a>
						</li>

						<li><a href="#">Sách</a></li>
						<li class="active">Dánh sách</li>
					</ul>
					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">
							<div class="widget-box table-filter">
								<div class="table-btn-controls">
									<div class="pull-right tableTools-container">
										<div class="dt-buttons btn-overlap btn-group">
											
											
											
										</div>
									</div>
								</div>
							</div>
							<div class="card-header">
                        		Tìm kiếm:
                         	<input type="text" name="txtSearch" placeholder="Search!" style="height:30px" class="txtSearch"/>
                         	<button type="button" class="btn btn-warning" style="height:32px;line-height: 8px" id="search" >Tìm kiếm</button>
                    			</div>
                    			<br/>
								<!-- /.breadcrumb -->
							</div>
							<br/>

								 
									<table id="simple-table"
										class="table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<th>Mã hóa đơn</th>
												<th>Ngày</th>
												<th class="hidden-480">Khách hàng</th>
												<th class="hidden-480">Số điện thoại</th>
												<th class="hidden-480">Trạng thái</th>
												<th></th>
											</tr>
										</thead>

										<tbody id="tableBody">
											
										</tbody>
									</table>
									<ul class="pagination" id="pagination"></ul>
									<input type="hidden" id="page" name="page" /> <input
										type="hidden" id="limit" name="limit" />
								</div>
								<!-- /.span -->

							</div>

						</div>

					</div>
					
				</form>
				</div>
				
		<!-- footer -->
		<%@ include file="/common/admin/footer.jsp"%>
		<!-- footer -->

		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse display"> <i
			class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>



	<script type="text/javascript">
	$(document).ready(function(){
		 var load = function (keyword,page,sortBy,sortName) {
		 $.ajax({
				url : '/api/orderList',
				type : 'GET',
				contentType : 'application/json',
				data: { page: page , limit:6, keyword:keyword,sortBy:sortBy,sortName:sortName},
				dataType : 'json',
				success : function(result) {		
					var orderList = result.listResult;
					var totalPages  = result.totalPage;
					var currentPage  = result.page;	
					var str ="";
					$.each(orderList,function(i,item){
						str +=  "<tr>";
						str+= "<td>"+item.id+"</td>";
						str+= "<td>"+item.date+"</td>";
						str+= "<td>"+item.customerOrder.name+"</td>";
						str+= "<td>"+item.customerOrder.phone+"</td>";
						str+= "<td>"+item.status+"</td>";
						str+= "<td>";
						str+= "<div class='hidden-sm hidden-xs btn-group'> <a class='btn btn-sm btn-primary btn-edit' style='padding:1.7px 3.5px;text-align:center' data-toggle='tooltip' title='Cập nhật câu hỏi'+ href='/bookshop/admin/order/update?id="+item.id+"'>" 
						str+= "<i class='ace-icon fa fa-pencil bigger-120'></i></a> "
						str+="<a class='btn btn-sm btn-primary btn-edit' style='padding:1.7px 3.5px;text-align:center' data-toggle='tooltip' title='Cập nhật câu hỏi'+ href='/bookshop/admin/orderDetail/list?id="+item.id+"'>" 
						str+= "<i class='ace-icon fa fa-flag bigger-120'></i></a> </div>"
						str+="</td>";							
						str += "</tr>";
					});
					document.getElementById('tableBody').innerHTML = str;
					 $(function() {
							window.pagObj = $('#pagination').twbsPagination({
								totalPages : totalPages,
								visiblePages : 5,
								startPage : currentPage,
								onPageClick: function (evt, page) {
									 var keyword = $(".txtSearch").val();
									 console.log(keyword);
									 if (keyword != "") {
						                   load(keyword, page,"status","asc"); 
						               }
						               else {
						                   load(null, page,"status","asc");
						               }

								 }
								
							});
						}); 
				}
		 
			});
		 }
		 $("#search").click(function () {
             var keyword = $(".txtSearch").val();
             if (keyword != "") {
                 load(keyword, 1,"status","asc");
             }
             else {
                 load(null, 1,"status","asc");
             }
              
         });

		 load(null,1,"status","asc");

	});			 
	
	</script>


	<script src="/admin/ckeditor/ckeditor.js"></script>
	<script src="/admin/assets/js/bootstrap.min.js"></script>
	<script src="/admin/assets/js/jquery-ui.custom.min.js"></script>
	<script src="/admin/assets/js/jquery.ui.touch-punch.min.js"></script>
	<script src="/admin/assets/js/jquery.easypiechart.min.js"></script>
	<script src="/admin/assets/js/jquery.sparkline.min.js"></script>
	<script src="/admin/assets/js/jquery.flot.min.js"></script>
	<script src="/admin/assets/js/jquery.flot.pie.min.js"></script>
	<script src="/admin/assets/js/jquery.flot.resize.min.js"></script>
	<script src="/admin/assets/js/ace-elements.min.js"></script>
	<script src="/admin/assets/js/ace.min.js"></script>
	<script src="/admin/assets/js/bootstrap.min.js"></script>

	<!-- page specific plugin scripts -->
	<script src="/admin/assets/js/jquery-ui.min.js"></script>
</body>
</html>
