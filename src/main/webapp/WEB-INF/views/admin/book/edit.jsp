<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/common/taglib.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trang chủ</title>

	<link rel="stylesheet" href="/admin/assets/css/bootstrap.min.css" >
    <link rel="stylesheet" href="/admin/assets/font-awesome/4.2.0/css/font-awesome.min.css" >
    <link rel="stylesheet" href="/admin/assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />
    <script src="/admin/assets/js/ace-extra.min.js"></script>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
   	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script type='text/javascript' src="/admin/js/jquery-2.2.3.min.js" ></script>
    <script src="/admin/assets/js/jquery.2.1.1.min.js"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    

     
      <!-- sweetalert -->
	 <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css">
      
</head>
<body class="no-skin">
	<script type="text/javascript">
	var caterogyList = [];
	var authorList = [];
	var publisherList = [];
	var id = null;
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
		if(id != null){
			loadCategory();
			loadPublisher();
			loadAuthor();
			loadBookFindId(id);
			var str= "";
			str += "<i class='ace-icon fa fa-check bigger-110'></i>Chỉnh sửa"
			document.getElementById('btnAdd').innerHTML = str;
		}else{
			loadCategory();
			loadPublisher();
			loadAuthor();	
		}
		
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
				var str ="";
				$('#name').val(book.name);
				$('#title').val(book.title);
				$('#price').val(book.price);
				$("#idCategory").val(book.category.id).attr('selected','selected');
			 	$('#idAuthor').val(book.authors.id).attr('selected','selected');
				$('#idPublisher').val(book.publishers.id).attr('selected','selected');
			 	$('#id').val(book.id);
			 	$('#number').val(book.number);
				console.log(book);
			},
			error : function(error) {
				
			}
		});
	}
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
				$.each(caterogyList,function(i,item){
					str +=  "<option value ='"+ item.id +"'> "+ item.name +" </option>";	
				});
				document.getElementById('idCategory').innerHTML = str;
			},
			error : function(error) {
				
			}
		});
	}
	 function loadPublisher() {
			$.ajax({
				url : '/api/pubblisherList',
				type : 'GET',
				contentType : 'application/json',
				data : JSON.stringify(),
				dataType : 'json',
				success : function(result) {		
					publisherList = result;
					var str ="";
					$.each(publisherList,function(i,item){
						str +=  "<option value ='"+ item.id +"'> "+ item.name +" </option>"
					});
					document.getElementById('idPublisher').innerHTML = str;
				},
				error : function(error) {
					
				}
			});
		}
	 function loadAuthor() {
			$.ajax({
				url : '/api/authorList',
				type : 'GET',
				contentType : 'application/json',
				data : JSON.stringify(),
				dataType : 'json',
				success : function(result) {		
					authorList = result;
					var str ="";
					$.each(authorList,function(i,item){
						str +=  "<option value ='"+ item.id +"'> "+ item.name +" </option>"
					});
					document.getElementById('idAuthor').innerHTML = str;
				},
				error : function(error) {
					
				}
			});
		}

	</script>
	<!-- header -->
    <%@ include file="/common/admin/header.jsp" %>
    <!-- header -->
	
	<div class="main-container" id="main-container">
		<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
		</script>
		<!-- header -->
    	<%@ include file="/common/admin/menu.jsp" %>
    	<!-- header -->
		
	
<!-- /.main-content -->
		
		
		<div class="main-content">
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

					<li><a href="#">Forms</a></li>
					<li class="active">Form Elements</li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<c:if test="${not empty message}">
							<div class="alert alert-${alert}">${message}</div>
						</c:if>
							<form class="form-horizontal" role="form" id="formSubmit" enctype="multipart/form-data">
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Tên sách </label>

										<div class="col-sm-9">
											<input type="text" id="name"  name="name" onblur="checkName();" placeholder="Tên sách" class="col-xs-10 col-sm-5" />
											<span style="color: red;" id="errorName"></span>	
										</div>
										
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1"> Tiêu đề </label>

										<div class="col-sm-9">
											<input type="text" id="title" name="title" onblur="checkTitle();" placeholder="Tiêu đề" class="col-xs-10 col-sm-5" />
											<span style="color: red;" id="errorTitle"></span>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1"> Chọn ảnh </label>

										<div class="col-sm-9">
											<input type="file" id="image" name="image"  placeholder="Tiêu đề" class="col-xs-10 col-sm-5" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">Giá thành: </label>

										<div class="col-sm-9">
											<input type="number" id="price" name="price"  placeholder="Giá tiền..." class="col-xs-10 col-sm-5" />
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-2"> Thể loại </label>

										<div class="col-sm-9">
												<select  id="idCategory" name="idCategory"  data-placeholder="Chọn thể loại sách...">	
												</select>
										</div>
									</div>


									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-3"> Nhà xuất bản </label>

										<div class="col-sm-9">
												<select  id="idPublisher" name="idPublisher" data-placeholder="Chọn nhà xuất bản...">	
												</select>
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-4">Tác giả </label>

										<div class="col-sm-9">
												<select  id="idAuthor"  name="idAuthor" data-placeholder="Chọn tác giả...">	
												</select>
										</div>
									</div>
									<input type="hidden" id="id" name="id">
									<input type="hidden" id="number" name="number" >  
								</form>
									<div class="clearfix form-actions">
										<div class="col-md-offset-3 col-md-9">
											<button class="btn btn-info" type="button" id="btnAdd">
												<i class="ace-icon fa fa-check bigger-110"></i>
												Thêm
											</button>

											&nbsp; &nbsp; &nbsp;
											<button class="btn" type="reset" id="btnReset">
												<i class="ace-icon fa fa-undo bigger-110"></i>
												Reset
											</button>
										</div>
									</div>
					</div>
				</div>
			</div>
		</div>
	</div>
		<!-- footer -->
    	<%@ include file="/common/admin/footer.jsp" %>
    	<!-- footer -->
    	
    	<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse display">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
	</div>
	
	
	<script type="text/javascript">
	function checkName() {
		var name = document.getElementById('name').value;
		var error = document.getElementById('errorName');
		if(name == ''|| name==null){
			error.innerHTML="Tên sách không được để trống!";
		}else {
			error.innerHTML="";
			return name;
		}
	}
	  function checkTitle() {
		var title = document.getElementById('title').value;
		var error = document.getElementById('errorTitle');
		if(title == ''|| title ==null){
			error.innerHTML="Tiêu đề không được để trống!";
		}else {
			error.innerHTML="";
			return title;
		}
		} 
	var data = {};
	
	var id = $('#id').val();
	
	$('#image').change(function () {
		
	    var files = $(this)[0].files[0];
	    if (files != undefined) {
            var reader = new FileReader();
            reader.onload = function(e) {
                data["base64"] = e.target.result;
                data["name"] = files.name;
              
            };
            reader.readAsDataURL(files);
		}
	    console.log(data);
    });
	$('#btnAdd').click(function(e) {
		e.preventDefault();
		if(checkName() && checkTitle()){
		var formData = $('#formSubmit').serializeArray();
		
		$.each(formData, function(i, v) {
			data["" + v.name + ""] = v.value;
		});	
		console.log(data);
		if(id != null){
			updateBook(data,image);
		}else{
			data['number']=0;
			addBook(data);
		}
		}else{
			alert("Vui lòng kiểm tra lại thông tin đã nhập !!!");
		}  
	});
	$('#btnReset').click(function(e) {
		$('#name').val("");
		$('#title').val("");
			
	});
	
	function addBook(data) {
		$.ajax({
			url : '/api/book',
			type : 'POST',
			contentType : 'application/json',
			data : JSON.stringify(data),
			dataType : 'json',
			success : function(result) {
				 window.location.href = "/bookshop/admin/book/update?id="+result.id+"&message=insert_success";
			},
			error : function(error) {
			}
		});
	}
	function updateBook(data) {
		$.ajax({
			url : '/api/book/'+ $('#id').val(),
			type : 'PUT',
			contentType : 'application/json',
			data : JSON.stringify(data),
			dataType : 'json',
			success : function(result) {
				 window.location.href = "/bookshop/admin/book/update?id="+result.id+"&message=update_success";
			},
			error : function(error) {
			}
		});
	}	
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
