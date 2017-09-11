<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp"%>
<%-- <%@ include file="../include/session_check.jsp" %> --%>
<script src="${path}/ckeditor/ckeditor.js"></script>
<script>
function product_delete(){
	
	if(confirm("삭제하시겠습니까?")){
	   document.form1.action="${path}/shop/product/delete.do";
	   document.form1.submit();
		
	}
	
}


function product_update() {
	var product_name = document.form1.product_name.value;
	var price = document.form1.price.value;
	var description = document.form1.description.value;
	if (product_name == "") {
		alert("상품명을 입력하세요.");
		document.form1.product_name.focus();
		return;
	}
	if (price == "") {
		alert("가격을 입력하세요.");
		document.form1.price.focus();
		return;
	}
/* 	if (description == "") {
		alert("상품설명을 입력하세요.");
		document.form1.description.focus();
		return;
	} */
	document.form1.action 
		= "${path}/shop/product/update.do";
	document.form1.submit();
}
</script>
</head>

<body>
<%@ include file="../include/admin_menu.jsp"%>
<h2>상품 등록</h2>
<!-- 첨부파일을 보낼 때 : method="post"
enctype="multipart/form-data" -->
<form id="form1" name="form1" method="post"
	enctype="multipart/form-data">
<table>
	<tr>
		<td>상품명</td>
		<td><input name="product_name" value="${vo.product_name }"></td>
	</tr>
	<tr>
		<td>가격</td>
		<td><input name="price" value="${vo.price }"></td>
	</tr>
	<tr>
		<td>상품설명</td>
		<td><textarea rows="5" cols="60" name="description"id="description">${vo.description }</textarea>
<script>
// id가 description인 태그를 ckeditor로 변경
//CKEDITOR.replace("description");
CKEDITOR.replace("description",{
	filebrowserUploadUrl : "${path}/imageUpload.do"
}); 
</script>			
		</td>
	</tr>
	<tr>
		<td>상품이미지</td>
		<td> <img src="${path}/images/${vo.picture_url}" width="300px" height="300px" />
		<br />
		<input type="file" name="file1">
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
		    <input type="hidden" name="product_id" value="${vo.product_id }" />		
		    <input type="button" value="수정" onclick="product_update()">
		    <input type="button" value="삭제" onclick="product_delete()"/> 
			<input type="button" value="목록" onclick="location.href='${path}/admin/product/list.do';">
		</td>
	</tr>
</table>
</form>
</body>
</html>