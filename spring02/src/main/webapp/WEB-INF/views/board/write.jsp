<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp"%>
<script src="../include/js/common.js"></script>
<script src="${path}/ckeditor/ckeditor.js"></script>
<script type="text/javascript">
	$(function() {
		$(".fileDrop").on("dragenter dragover",function(e){
			e.preventDefault();
		});
		$(".fileDrop").on("drop",function(e){
			e.preventDefault();
			//드롭한 파일을 폼데이터에 추가함
			var files=e.originalEvent.dataTransfer.files;
			var file=files[0];
			var formData=new FormData();
			//폼데이터에 추가
			formData.append("file",file);
	//processData: false  - header가 아닌 body로 전송		
			$.ajax({
			  url: "${path}/upload/uploadAjax",
			  data: formData,
			  dataType: "text",
			  processData: false,
			  contentType: false,
			  type: "post",
			  success: function(data){ //콜백함수
	var fileInfo=getFileInfo(data); //첨부파일 정보
	var html="<a href='"+fileInfo.getLink+"'>"+
		fileInfo.fileName+"</a><br>"; //첨부파일 링크
	html+="<input type='hidden' class='file' value='"
		+fileInfo.fullName+"'>"; //hidden 태그 추가
	$("#uploadedList").append(html); //div에 추가
			  }
			});
		});
		
		
		$("#btnList").click(function() {
			location.href="${path}/board/list.do";
		});
		
		
		
		$("#btnSave").click(function() {
			var str="";
			$("#uploadedList .file").each(function(i){
	       str+="<input type='hidden' name='files["+i+"]' value='"+$(this).val()+"'>";
			});
			//폼에 hidden 태그들을 추가
			$("#form1").append(str);
			document.form1.submit();
		});
	});
</script>
<style type="text/css">
.fileDrop {
	width: 600px;
	height: 100px;
	border: 1px dotted gray;
	background-color: gray;
}
</style>
</head>
<body>
	<%@ include file="../include/menu.jsp"%>
	<div class="container">
	<h2>글쓰기</h2> <br /> <br />
	<form id="form1" name="form1" method="post"
		action="${path}/board/insert.do">
		<div>
			제목 <input name="title" id="title" size="80" placeholder="제목을 입력하세요">
		</div>
		<div style="width: 800px;">
			내용
			<textarea id="content" name="content" rows="3" cols="80" placeholder="내용을 입력하세요"></textarea>
			<script>
				CKEDITOR.replace("content", {
					filebrowserUploadUrl : "${path}/imageUpload.do"
				});
			</script>
		</div>
		<div>
			
			<label > 첨부파일을 드래그앤드랍방식으로 회색 화면에 집어 넣으시면 파일첨부가 됩니다</label>
			<!-- 첨부파일을 드래그할 영역 -->
			<div class="fileDrop"></div>
			<!-- 첨부파일 목록이 표시되는 영역 -->
			<div id="uploadedList"></div>
		</div>
		<div style="width: 700px; text-align: center;">
		
			<button type="button" id="btnList">리스트</button>
			<button type="button" id="btnSave">확인</button>
		</div>
	</form>
</div>
</body>
</html>