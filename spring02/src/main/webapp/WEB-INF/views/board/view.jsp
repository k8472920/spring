<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp"%>
<script src="${path}/include/js/common.js"></script>
<script src="${path}/ckeditor/ckeditor.js"></script>
<script>
	$(function() {
		//목록 버튼 클릭
		$("#btnList").click(function() {
			location.href = "${path}/board/list.do";
		});

		//댓글 목록 출력
		listReply("1"); //responseText 방식
		//listReply2(); // json 방식
		//댓글 쓰기
		$("#btnReply").click(function() {
			reply();
		});
		//드래그 기본효과 막음
		$(".fileDrop").on("dragenter dragover", function(e) {
			e.preventDefault();
		});
		$(".fileDrop")
				.on(
						"drop",
						function(e) {
							e.preventDefault();
							//드롭한 파일을 폼데이터에 추가함
							var files = e.originalEvent.dataTransfer.files;
							var file = files[0];
							var formData = new FormData();
							//폼데이터에 추가
							formData.append("file", file);
							//processData: false  - header가 아닌 body로 전송		
							$
									.ajax({
										url : "${path}/upload/uploadAjax",
										data : formData,
										dataType : "text",
										processData : false,
										contentType : false,
										type : "post",
										success : function(data) { //콜백함수
											var fileInfo = getFileInfo(data); //첨부파일 정보
											var html = "<a href='"+fileInfo.getLink+"'>"
													+ fileInfo.fileName
													+ "</a><br>"; //첨부파일 링크
											html += "<input type='hidden' class='file' value='"+fileInfo.fullName+"'>"; //hidden 태그 추가
											$("#uploadedList").append(html); //div에 추가
										}
									});
						});

		listAttach(); //첨부파일 목록 로딩

		//첨부파일 삭제
		$("#uploadedList").on("click", ".file_del", function(e) {
			var that = $(this); //클릭한 태그
			$.ajax({
				type : "post",
				url : "${path}/upload/deleteFile",
				data : {
					fileName : $(this).attr("data-src")
				},
				dataType : "text",
				success : function(result) {
					if (result == "deleted") {
						that.parent("div").remove();
					}
				}
			});
		});

		$("#btnUpdate").click(
				function() {
					var str = "";
					$("#uploadedList .file").each(
							function(i) {
								str += "<input type='hidden' name='files[" + i
										+ "]' value='" + $(this).val() + "'>";
							});
					//폼에 hidden 태그들을 추가
					$("#form1").append(str);

					document.form1.action = "${path}/board/update.do";
					document.form1.submit();
				});
		$("#btnDelete").click(function() {
			if (confirm("삭제하시겠습니까?")) {
				document.form1.action = "${path}/board/delete.do";
				document.form1.submit();
			}
		});
	});
	function listAttach() {
		$
				.ajax({
					type : "post",
					url : "${path}/board/getAttach/${vo.bno}",
					success : function(list) {
						// list => json 형식의 데이터
						$(list).each(function() {
											var fileInfo = getFileInfo(this);
											var html = "<div><a href='"+fileInfo.getLink+"'>"
													+ fileInfo.fileName
													+ "</a>&nbsp;&nbsp;";
											html += "<a href='#' class='file_del' data-src='"+this+"'>[삭제]</a></div>";
											$("#uploadedList").append(html);
										});
					}
				});
	}
	function reply() {
		var replytext = $("#replytext").val(); //댓글 내용
		var bno = "${vo.bno}"; //게시물번호
		// var param = "replytext="+replytext+"&bno="+bno;	
		var param = {
			"replytext" : replytext,
			"bno" : bno
		};
		$.ajax({
			type : "post",
			url : "${path}/reply/insert.do",
			data : param,
			success : function() { //콜백함수
				alert("댓글이 등록되었습니다.");
				listReply("1");
			}
		});
	}
	//json 리턴 방식
	function listReply2() {
		$.ajax({
			type : "get",
			contentType : "application/json",
			url : "${path}/reply/list_json.do?bno=${vo.bno}",
			success : function(result) {
				console.log(result);
				var output = "<table>";
				for ( var i in result) {
					var repl = result[i].replytext;
					//   /정규표현식/g   global 검색		
					repl = repl.replace(/\n/gi, "<br>");
					repl = repl.replace(/  /gi, "&nbsp;&nbsp;");
					output += "<tr>";
					output += "<td>" + result[i].name;
					output += "(" + changeDate(result[i].regdate) + ")";
					output += "<br>" + repl;
					output += "</td></tr>";
				}
				output += "</table>";
				$("#listReply").html(output);
			}
		});

	}
	function changeDate(date) {
		//javascript 날짜 객체, parseInt() 숫자로 변환
		date = new Date(parseInt(date));
		year = date.getFullYear(); //4자리 연도
		month = date.getMonth();
		day = date.getDate();
		hour = date.getHours();
		minute = date.getMinutes();
		second = date.getSeconds();
		strDate = year + "-" + month + "-" + day + " " + hour + ":" + minute
				+ ":" + second;
		return strDate;
	}
	//responseText 방식
	function listReply(num) {
		$.ajax({
			type : "get",
			url : "${path}/reply/list.do?bno=${vo.bno}&curPage=" + num,
			success : function(result) {
				// 컨트롤러에서 뷰로 포워딩되어 출력된 responseText를
				// id가 listReply인 태그의 innertHTML영역에 출력시킴
				$("#listReply").html(result);
			}
		});
	}
</script>
<style>
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
		<h2>게시물 보기</h2> <br /> <br />
		<form id="form1" name="form1" method="post">
			<div>
				작성일자 :
				<fmt:formatDate value="${vo.regdate}"
					pattern="yyyy-MM-dd a HH:mm:ss" />
			</div>
			<div>조회수 : ${vo.viewcnt}</div>
			<div>이름 : ${vo.name}</div>
			<div>
				제목 : <input name="title" value="${vo.title}">
			</div>
			<div style="width: 60%;">
				내용 :
				<textarea rows="3" cols="80" name="content" id="content">${vo.content}</textarea>
			</div>
			<script>
				CKEDITOR.replace("content", {
					filebrowserUploadUrl : "${path}/imageUpload.do"
				});
			</script>

			<!-- 첨부파일 목록 -->
			<div id="uploadedList"></div> 
			<label > 첨부파일을 드래그앤드랍방식으로 회색 화면에 집어 넣으시면 파일첨부가 됩니다</label>
			<!-- 새로운 첨부파일을 올릴 영역 -->
			<div class="fileDrop"></div> <br /><br />
			<div>
				<input type="hidden" name="bno" value="${vo.bno}">
				<!-- 본인의 게시물만 수정,삭제 버튼 표시 -->
				<c:if test="${sessionScope.userid == vo.writer}">
					<button type="button" id="btnUpdate">수정</button>
					<button type="button" id="btnDelete">삭제</button>
				</c:if>
				<button type="button" id="btnList">목록</button>
			</div>
		</form>  
		<br />
		<!-- 댓글 작성 -->
		<c:if test="${sessionScope.userid != null }">
			<div class="container">
			 <div class="form-horizontal">
				<div class="form-group">
					<label>댓글:</label>
					<textarea class="form-control" rows="5" cols="60" id="replytext"
						name="replytext" placeholder="댓글을 작성하세요"></textarea>
					<br>
					<button type="submit" class="btn pull-right" id="btnReply">등록</button>
				</div>
                </div>
			</div>
		</c:if>




		<!-- 댓글 목록을 출력할 영역 -->
		<div id="listReply"></div>
	</div>
</body>
</html>












