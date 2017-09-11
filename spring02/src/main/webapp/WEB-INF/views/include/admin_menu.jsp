<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<nav class="navbar navbar-inverse"> 
		<div class="cotainer-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
				data-target="#bs-example-navbar-collape-1" aria-extended="false">
				<span class="sr-only"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#none">관리자 페이지</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
		<div class="collapsed navbar-collapse" id="bs-example-navbar-collape-1">
			<ul class="nav navbar-nav">
				<li class=""><a href="${path}/pdf/list.do">PDF 출력 <span class="sr-only"></span></a></li>
				<li class=""><a href="${path}/email/write.do">이메일발송 </a></li>
				<li class=""><a href="${path}/shop/product/list.do">상품목록 </a></li>
				<li class=""><a href="${path}/shop/product/write.do">상품등록 </a></li>
				<li class="dropdown">
					<a href="#" class="dropdown.toggle" data-toggle="dropdown" role="button"
					aria-haspopup="true" aria-expanded="false">구글차트 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="${path}/chart/chart1.do">구글차트(Json)</a></li>
						<li><a href="${path}/chart/chart2.do">구글차트(db연동)</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a href="#" class="dropdown.toggle" data-toggle="dropdown" role="button"
					aria-haspopup="true" aria-expanded="false">JFree차트 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="${path}/jchart/chart1.do">JFree차트(PNG)</a></li>
						<li><a href="${path}/jchart/chart2.do">JFree차트(PDF)</a></li>
					</ul>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right ">
				<li class="dropdown">
					<a href="#" class="dropdown.toggle" data-toggle="dropdown" role="button"
					aria-haspopup="true" aria-expanded="false">접속하기 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<c:choose>
							<c:when test="${sessionScope.admin_userid == null }">
								<li><a href="${path}/member/login.do">로그인</a></li>
								<li><a href="${path}/admin/login.do">관리자 로그인</a></li>
							</c:when>
							<c:otherwise>
  	                   ${sessionScope.name}님이 로그인중입니다.
  	                   <li><a href="${path}/admin/logout.do">로그아웃</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</nav>
