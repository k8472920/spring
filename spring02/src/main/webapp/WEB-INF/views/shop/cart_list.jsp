<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp"%>
<script>
     $(function(){
    	$("#btnList").click(function(){
    		location.href="${path}/shop/product/list.do";
    	});
    	
    	$("#btnDelete").click(function(){
    		if(confirm("장바구니를 비우시겠습니까?")){
    			location.href="${path}/shop/cart/deleteAll.do";
    			
    			
    		}
    	});
    	
     });

</script>

</head>
<body>
	<%@ include file="../include/menu.jsp"%>
	<h2>장바구니</h2>
	<c:choose>
		<c:when test="${map.count} ==0 ">
		</c:when>

		<c:otherwise>
			<form action="${path}/shop/cart/update.do" id="form1" name="form1"
				method="post">
				<table border="1" width="500px" >

					<tr>
						<td>상품명</td>
						<td>단가</td>
						<td>수량</td>
						<td>금액</td>
						<td>&nbsp;</td>
					</tr>
					<c:forEach var="row" items="${map.list}">
						<tr>
							<td>${row.product_name}</td>
							<td>${row.price}</td>
							<td>
			    <input type="number" style="width: 30px;" min="0" max="100" name="amount" value="${row.amount}"/>
			    <input type="hidden" name="product_id" value="${row.product_id }" />				
							
							</td>
							<td>${row.money}</td>
							<td><a href="${path}/shop/cart/delete.do?cart_id=${row.cart_id}">삭제</a></td>
						</tr>
					</c:forEach>
					<tr>
					   <td colspan="5" align="right">
					      장바구니 금액 합계 : <fmt:formatNumber value="${map.sumMoney}" pattern="###,###"/>  <br /> 
                                              배송료 : ${map.fee} <br />      	
                                              총합계 : <fmt:formatNumber value="${map.sum}" pattern="###,###"/>        				   
					   </td>
					
					</tr>
				</table>
				<button id=btnUpdate>수정</button>
				
			</form>
		</c:otherwise>
	</c:choose>
	
	<button type="button" id="btnDelete">장바구니 비우기</button>
	<button type="button" id="btnList">상품목록</button>
	
</body>
</html>