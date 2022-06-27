<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>Login V18</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" type="image/png" href="/login/images/icons/favicon.ico"/>
	<link rel="stylesheet" type="text/css" href="/login/vendor/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="/login/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="/login/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
	<link rel="stylesheet" type="text/css" href="/login/vendor/animate/animate.css">	
	<link rel="stylesheet" type="text/css" href="/login/vendor/css-hamburgers/hamburgers.min.css">
	<link rel="stylesheet" type="text/css" href="/login/vendor/animsition/css/animsition.min.css">
	<link rel="stylesheet" type="text/css" href="/login/vendor/select2/select2.min.css">
	<link rel="stylesheet" type="text/css" href="/login/vendor/daterangepicker/daterangepicker.css">
	<link rel="stylesheet" type="text/css" href="/login/css/util.css">
	<link rel="stylesheet" type="text/css" href="/login/css/main.css">
	<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
   	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
       <script src="/admin/assets/js/jquery.2.1.1.min.js"></script>
    
</head>
<body style="background-color: #666666;">
	
	<div class="limiter">
	<c:if test="${not empty message}">
		<div class="alert alert-${alert}">${message}</div>
	</c:if>
	<c:if test="${param.incorrectAccount != null}">
					<div class="alert alert-danger">	
							Username or password incorrect
					</div>
				</c:if>
				<c:if test="${param.accessDenied != null}">
					<div class="alert alert-danger">	
							you Not authorize
					</div>
	</c:if>
		<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form validate-form">
					<span class="login100-form-title p-b-43">
						Login to continue
					</span>
					
					
					<div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
						<input class="input100" type="text" id="username">
						<span class="focus-input100"></span>
						<span class="label-input100">Tài khoản</span>
					</div>
					
					
					<div class="wrap-input100 validate-input" data-validate="Password is required">
						<input class="input100" type="password" id="password">
						<span class="focus-input100"></span>
						<span class="label-input100">Mật khẩu</span>
					</div>

					<div class="flex-sb-m w-full p-t-3 p-b-32">
						<div class="contact100-form-checkbox">
							<input class="input-checkbox100" id="ckb1" type="checkbox" name="remember-me">
							<label class="label-checkbox100" for="ckb1">
								Remember me
							</label>
						</div>

						<div>
							<a href="#" class="txt1">
								Forgot Password?
							</a>
						</div>
					</div>
			

					<div class="container-login100-form-btn">
						<button class="login100-form-btn" id="btnLogin1">
							Đăng nhập
						</button>
					</div>
					
					<div class="text-center p-t-46 p-b-20">
						<span class="txt2">
							or sign up using
						</span>
					</div>

					<div class="login100-form-social flex-c-m">
						<a href="#" class="login100-form-social-item flex-c-m bg1 m-r-5">
							<i class="fa fa-facebook-f" aria-hidden="true"></i>
						</a>

						<a href="#" class="login100-form-social-item flex-c-m bg2 m-r-5">
							<i class="fa fa-twitter" aria-hidden="true"></i>
						</a>
					</div>
				</form>

				<div class="login100-more" style="background-image: url('/login/images/bg-01.jpg');">
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	 var username;
	 var password;
	 var user=[];
	 var loginRequest={};
	 document.addEventListener('DOMContentLoaded',function (){
		 $("#btnLogin1").click(function () { 	
		        username = document.getElementById('username').value;
		       	password = document.getElementById('password').value;
		       	loginRequest['username']=username;
		       	loginRequest['password']=password;
		       	loadLogin(loginRequest);
		       
		     }); 
		 function loadLogin(loginRequest){
			$.ajax({
					url : "/api/auth/signin",
					type : 'POST',
					contentType : 'application/json',
					data : JSON.stringify(loginRequest),
					dataType : 'json',
					success : function(result) {
						user=result;
						if(result.roles[0]=="USER"){
						localStorage.setItem("username",result.username);
						localStorage.setItem("jwt",result.jwt);
						window.location.href = "/bookshop/trang-chu";
						}else{	
							localStorage.setItem("username",result.username);
							localStorage.setItem("jwt",result.jwt);
							window.location.href = "/bookshop/admin";
						}

					},
					error : function(error) {
						window.location.href = "/bookshop/login?message=login_error";
					}
				});
			}
	 });
	 
	
	</script>
	<script src="/login/vendor/jquery/jquery-3.2.1.min.js"></script>
	<script src="/login/vendor/animsition/js/animsition.min.js"></script>
	<script src="/login/vendor/bootstrap/js/popper.js"></script>
	<script src="/login/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="/login/vendor/select2/select2.min.js"></script>
	<script src="/login/vendor/daterangepicker/moment.min.js"></script>
	<script src="/login/vendor/daterangepicker/daterangepicker.js"></script>
	<script src="/login/vendor/countdowntime/countdowntime.js"></script>
	<script src="/login/js/main.js"></script>

</body>
</html>