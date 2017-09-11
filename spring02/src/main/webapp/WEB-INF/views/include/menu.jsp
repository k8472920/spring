<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-inverse">
	<div class="cotainer-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collape-1"
				aria-extended="false">
				<span class="sr-only"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${path}">Spring</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
		<div class="collapsed navbar-collapse"
			id="bs-example-navbar-collape-1">
			<ul class="nav navbar-nav">
				<li class=""><a href="${path}/member/join.do">도로명주소 <span
						class="sr-only"></span></a></li>
				<li class=""><a href="${path}/memo/list.do">한줄메모장 </a></li>
				<li class=""><a href="${path}/board/list.do">게시판 </a></li>
				<li class=""><a href="${path}/shop/product/list.do">상품목록</a></li>
				<li class="dropdown"><a href="#" class="dropdown.toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">업로드 테스트 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="${path}/upload/uploadForm">일반방식</a></li>
						<li><a href="${path}/upload/uploadAjax">Ajax 방식</a></li>
					</ul></li>
				<c:if test="${sessionScope.userid != null }">
					<li class=""><a href="${path}/shop/cart/list.do">장바구니</a></li>
				</c:if>
			</ul>
			<!-- <form class="navbar-form navbar-left">
				<div class="form-group">
					<input type="text" name="" class="form-group" placeholder="내용을 입력하세요">
				</div>
				<button type="submit" class="btn btn-default">검색</button>
			</form> -->
			<ul class="nav navbar-nav navbar-right ">
			           <c:if test="${sessionScope.userid != null }">
			           <li><a href="" style="color: violet">${sessionScope.name}님이 로그인중입니다.</a></li>
  	                   <li><a href="${path}/member/logout.do">로그아웃</a></li>
  	                   </c:if>
				<li class="dropdown"><a href="#" class="dropdown.toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"
					style="color: white">접속하기 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						
							<c:if test="${sessionScope.userid == null }">
								<li><a href="${path}/member/login.do">로그인</a></li>
								<li><a href="${path}/admin/login.do">관리자 로그인</a></li>
								<li><a href="${path}/member/register.do">회원가입</a></li>
							</c:if>
					</ul>
					   
				</li>
			</ul>
		</div>
	</div>


</nav>