<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp"%>
</head>
<body>
	<table style="width: 700px;">
		<%
			pageContext.setAttribute("newLineChar", "\n");
		%>
		<c:forEach var="row" items="${list}">
			<!-- 공백문자 처리 -->
			<c:set var="str"
				value="${fn:replace(row.replytext,'  ','&nbsp;&nbsp;') }" />
			<!-- 줄바꿈 처리 -->
			<c:set var="str" value="${fn:replace(str,newLineChar,'<br>') }" />
			<tr>
				<td>${row.name}(<fmt:formatDate value="${row.regdate}"
						pattern="yyyy-MM-dd a HH:mm:ss" /> )<br> <%-- ${row.replytext} --%>
					${str} <!-- 본인이 작성한 댓글만 수정 기능 표시 -->
					 <c:if test="${sessionScope.userid == row.replyer }">
						<input type="button" id="btnDelete" value="삭제">
					</c:if>
				</td>
			</tr>
		</c:forEach>

		<!-- 페이지 나누기 -->
		<%-- <tr>
			<td><c:if test="${pager.curBlock > 1}">
					<a href="javascript:listReply('${pager.prevPage}')"> [이전]</a>&nbsp;
	        </c:if> <c:forEach var="num" begin="${pager.blockBegin}"
					end="${pager.blockEnd}">
					<c:choose>
						<c:when test="${num == pager.curPage}">
							<!-- 현재 페이지 -->
		    ${num}&nbsp;
		  </c:when>
						<c:otherwise>
							<!-- 현재 페이지가 아닐 때 -->
							<a href="javascript:listReply('${num}')">${num}</a>&nbsp;
		  </c:otherwise>
					</c:choose>
				</c:forEach> <c:if test="${pager.curBlock <= pager.totBlock}">
					<a href="javascript:listReply('${pager.nextPage}')"> [다음]</a>&nbsp;
	</c:if></td>
		</tr> --%>
	</table>
</body>
</html>






