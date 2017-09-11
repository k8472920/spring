<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 상단 네비게이션 바 -->
<%@ include file="../include/header.jsp"%>
<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<!-- 브라우저가 좁아졋을때 나오는 버튼(클릭시 메뉴출력) -->
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">스프링 예제</a> 
		</div>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav-left">
				<li class="active"><a href="${path}">홈으로</a></li> 
				<li><a href="${path}/member/join.do">도로명주소</a></li>
				<li><a href="${path}/memo/list.do">한줄메모장</a></li>
				<li><a href="${path}/upload/uploadForm">업로드 테스트</a></li>
				<li><a href="${path}/upload/uploadAjax">업로드 테스트(ajax)</a></li>
				<li><a href="${path}/board/list.do">게시판</a></li>
				<li><a href="${path}/shop/product/list.do">상품목록</a></li>
				<c:if test="${sessionScope.userid != null }">
					<li><a href="${path}/shop/cart/list.do">장바구니</a></li>
				</c:if>
				<c:choose>
					<c:when test="${sessionScope.userid == null }">
						<li><a href="${path}/member/login.do">로그인</a></li>  
                      <li><a href="${path}/admin/login.do">관리자 로그인</a></li>
					</c:when>
					<c:otherwise>
  	                   ${sessionScope.name}님이 로그인중입니다.
  	                   <li><a href="${path}/member/logout.do">로그아웃</a></li>
					</c:otherwise>
				</c:choose>
				</ul>

			
		</div>
	</div>
</div>
