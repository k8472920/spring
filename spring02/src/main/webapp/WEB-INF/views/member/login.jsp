<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../include/header.jsp"%>
<script type="text/javascript">

$(document).ready(function() {
	

	$("#login-form").submit(function() {
		if ($("#userid").val().length < 1) {
			alert("아이디를 입력하세요.");
			$("#userid").focus();
			return false;
		}
		if ($("#passwd").val().length < 1) {
			alert("비밀번호를 입력하세요.");
			$("#passwd").focus();
			return false;
		}
	});
	
});

</script>
<style type="text/css">
#body {
    padding-top: 90px;
}
.panel-login {
	border-color: #ccc;
	-webkit-box-shadow: 0px 2px 3px 0px rgba(0, 0, 0, 0.2);
	-moz-box-shadow: 0px 2px 3px 0px rgba(0, 0, 0, 0.2);
	box-shadow: 0px 2px 3px 0px rgba(0, 0, 0, 0.2);
}

.panel-login>.panel-heading {
	color: #00415d;
	background-color: #fff;
	border-color: #fff;
	text-align: center;
}

.panel-login>.panel-heading a {
	text-decoration: none;
	color: #666;
	font-weight: bold;
	font-size: 15px;
	-webkit-transition: all 0.1s linear;
	-moz-transition: all 0.1s linear;
	transition: all 0.1s linear;
}

.panel-login>.panel-heading a.active {
	color: #029f5b;
	font-size: 30px;
}

.panel-login>.panel-heading hr {
	margin-top: 10px;
	margin-bottom: 0px;
	clear: both;
	border: 0;
	height: 1px;
	background-image: -webkit-linear-gradient(left, rgba(0, 0, 0, 0),
		rgba(0, 0, 0, 0.15), rgba(0, 0, 0, 0));
	background-image: -moz-linear-gradient(left, rgba(0, 0, 0, 0),
		rgba(0, 0, 0, 0.15), rgba(0, 0, 0, 0));
	background-image: -ms-linear-gradient(left, rgba(0, 0, 0, 0),
		rgba(0, 0, 0, 0.15), rgba(0, 0, 0, 0));
	background-image: -o-linear-gradient(left, rgba(0, 0, 0, 0),
		rgba(0, 0, 0, 0.15), rgba(0, 0, 0, 0));
}

.panel-login input[type="text"], .panel-login input[type="email"],
	.panel-login input[type="password"] {
	height: 45px;
	border: 1px solid #ddd;
	font-size: 16px;
	-webkit-transition: all 0.1s linear;
	-moz-transition: all 0.1s linear;
	transition: all 0.1s linear;
}

.panel-login input:hover, .panel-login input:focus {
	outline: none;
	-webkit-box-shadow: none;
	-moz-box-shadow: none;
	box-shadow: none;
	border-color: #ccc;
}

.btn-login {
	background-color: #59B2E0;
	outline: none;
	color: #fff;
	font-size: 14px;
	height: auto;
	font-weight: normal;
	padding: 14px 0;
	text-transform: uppercase;
	border-color: #59B2E6;
}

.btn-login:hover, .btn-login:focus {
	color: #fff;
	background-color: #53A3CD;
	border-color: #53A3CD;
}

.forgot-password {
	text-decoration: underline;
	color: #888;
}

.forgot-password:hover, .forgot-password:focus {
	text-decoration: underline;
	color: #666;
}

.btn-register {
	background-color: #1CB94E;
	outline: none;
	color: #fff;
	font-size: 14px;
	height: auto;
	font-weight: normal;
	padding: 14px 0;
	text-transform: uppercase;
	border-color: #1CB94A;
}

.btn-register:hover, .btn-register:focus {
	color: #fff;
	background-color: #1CA347;
	border-color: #1CA347;
}
</style>

<%@ include file="../include/menu.jsp"%>

<div class="container" id="body">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-login">
				<div class="panel-heading">
					<div class="row" >
						<div class="col-xs-12" >
							<a href="#" class="active" id="login-form-link" >로그인</a>
						</div>
						<!-- <div class="col-xs-6">
							<a href="#" id="register-form-link">회원가입</a>
						</div> -->
					</div>
					<hr>
				</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-12">
							<form id="login-form" method="post" role="form" action="${path}/member/login_check.do" style="display: block;">
								<div class="form-group">
									<input type="text" name="userid" id="userid" tabindex="1"
										class="form-control" placeholder="아이디" value="">
								</div>
								<div class="form-group">
									<input type="password" name="passwd" id="passwd" tabindex="2"
										class="form-control" placeholder="비밀번호">
								</div>
								<!-- <div class="form-group text-center">
									<input type="checkbox" tabindex="3" class="" name="remember"
										id="remember"> <label for="remember"> 아이디 저장</label>
								</div> -->
								<div class="form-group">
									<div class="row">
										<div class="col-sm-6 col-sm-offset-3">
											<input type="submit" id="btnLogin" tabindex="4"
												class="form-control btn btn-login" value="로그인">
										</div>
									</div>
								</div>
								<div style="text-align: center">
										<c:if test="${message == 'error' }">
											<div style="color: red;">아이디 또는 비밀번호가 일치하지 않습니다.</div>
										</c:if> <c:if test="${message == 'logout' }">
											<div style="color: blue;">로그아웃되었습니다.</div>
										</c:if> <c:if test="${param.message == 'nologin' }">
											<div style="color: blue;">로그인하신 후 사용하세요.</div>
										</c:if>
								</div>  <br />
								<div class="form-group">
									<div class="row">
										<div class="col-lg-12">
											<div class="text-center">
												<a href="${path}/member/forgot.do" tabindex="5"
													class="forgot-password">비밀번호를 잊어버리셧나요?</a>
											</div>
										</div>
									</div>
								</div>
							</form>
							
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
