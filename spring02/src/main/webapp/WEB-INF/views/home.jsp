<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<%@ include file="include/header.jsp"%>
</head>
<body>
	<%@ include file="include/menu.jsp"%>
	<!-- 로그인 성공했을 때 환영 메시지 출력 -->
	<%-- <c:if test="${sessionScope.userid != null }">
	<h2>
	${sessionScope.name} ( ${sessionScope.userid} )
	님의 방문을 환영합니다. 
	</h2>
</c:if>

	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>
<%=application.getRealPath("/") %>	
</body>
</html>
 --%>
<style type="text/css">
    .jumbotron {
	background-image: url('images/pic.jpg');
	background-size: cover;
	text-shadow: black 0.1em 0.1em 0.1em;
	color: white;
}
</style>
	<div class="container">
		<div class="jumbotron">
			<h1 class="text-center">SPRING</h1>
			<p class="text-center" style="color: white; size: 30px">framework</p>
			<p class="text-center">
				<a class="btn btn-primary btn-lg" href="${path}/member/register.do" role="button">회원가입하러 가기</a>
			</p>
		</div>
		<div class="row">
			<div class="col-md-4">
				<h4>일반계정로그인</h4>
				<p>아이디는 kim 비번은 1234입니다</p>
				<p>
					<a class="btn btn-default" data-target="modal" data-toggle="modal">자세히
						알아보기</a>
				</p>
			</div>
			<div class="col-md-4">
				<h4>관리자 계정로그인</h4>
				<p>아이디는 admin 비번은 admin입니다</p>
				<p>
					<a class="btn btn-default" href="#">자세히 알아보기</a>
				</p>
			</div>
			<div class="col-md-4">
				<h4>코딩부스터의 특징</h4>
				<p>코딩부스터는 타사이트와</p>
				<p>
					<a class="btn btn-default" href="#">자세히 알아보기</a>
				</p>
			</div>
		</div>
		<hr>
	</div>
	<footer style="background-color: #000000; color: #ffffff">
		<div class="container">
			<br />
			<div class="row">
				<div class="col-sm-12" style="text-align: center; color: white;">
					<h5>Copyright &copy; 2017</h5>
					<h5>김형중(Hyungjueng Kim)</h5>
				</div>
				<!-- <div class="col-sm-4">
				<h4>대표자소개</h4>
				<p>....</p>
			</div> -->
			</div>
		</div>
	</footer>