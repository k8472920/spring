<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp"%>
<!-- include libraries(jQuery, bootstrap) -->
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script>
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>

<!-- include summernote css/js-->
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.6/summernote.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.6/summernote.js"></script>
<script>
	$(function() {
		//id가 memo인 태그에 summernote 적용	
		$("#memo").summernote({
			width : 800,
			height : 150
		});
	});
	function memo_view(idx) {
		// 15번 글이라면 /memo/view/15 로 넘어감
		// location.href="${path}/memo/view?idx="+idx;
		// REST(REpresentative State Transfer)
		// RESTful
		// 고유의 주소
		location.href = "${path}/memo/view/" + idx;
	}
</script>
</head>
<body>
	<%@ include file="../include/menu.jsp"%>
	<h2>메모장</h2>
	<form method="post" action="${path}/memo/insert.do">
		이름 : <input name="writer" size="10"><br> 메모 :
		<!-- <input name="memo" size="40"> -->
		<textarea id="memo" name="memo"></textarea>
		<input type="submit" value="확인">
	</form>

	<table border="1" style="width: 500px;">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>메모</th>
			<th>날짜</th>
		</tr>
		<c:forEach var="row" items="${list}">
			<tr>
				<td>${row.idx}</td>
				<td>${row.writer}</td>
				<td><a href="#" onclick="memo_view('${row.idx}')">${row.memo}</a></td>
				<td><fmt:formatDate value="${row.post_date}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>

