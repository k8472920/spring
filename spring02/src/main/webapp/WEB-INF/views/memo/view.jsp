<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<!-- include libraries(jQuery, bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 

<!-- include summernote css/js-->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.6/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.6/summernote.js"></script>

<script type="text/javascript">
$(function(){
	$("#memo").summernote({
		width: 800,
		height: 150
	});
	
	$("#btnUpdate").click(function(){
		document.form1.action = "${path}/memo/update/${vo.idx}";
		document.form1.submit();
	});
	$("#btnDelete").click(function(){
		if(confirm("삭제하시겠습니까?")){ 
			document.form1.action = "${path}/memo/delete/${vo.idx}";
		  document.form1.submit();
		}
	});
});
</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>메모 보기</h2>
<form method="post" name="form1">
<table border="1" width="500px">
  <tr>
    <td>번호</td>
    <td>${vo.idx}</td>
  </tr>
  <tr>
    <td>이름</td>
    <td><input name="writer" value="${vo.writer}"></td>
  </tr>
  <tr>
    <td>메모</td>
    <td><%-- <input name="memo" value="${vo.memo}"
    	size="50"> --%>
<textarea name="memo" id="memo">${vo.memo}</textarea>    	
    </td>
  </tr>
  <tr align="center">
    <td colspan="2">
      <input type="hidden" name="idx" value="${vo.idx}">
      <input type="button" id="btnUpdate" value="수정">
      <input type="button" id="btnDelete" value="삭제">
    </td>
  </tr>
</table>
</form>
</body>
</html>
