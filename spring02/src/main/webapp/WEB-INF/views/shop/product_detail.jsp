<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp"%>
</head>
<body>
	<%@ include file="../include/menu.jsp"%>
	<table>
		<tr>
			<td><img src="${path}/images/${vo.picture_url}" width="300px"
				height="300px" /></td>

			<td align="center">
				<table>
					<tr>
						<td>상품명</td>
						<td>${vo.product_name}</td>
					</tr>
					<tr>
						<td>가격</td>
						<td>${vo.price}</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>${vo.description}</td>
					</tr>
					<tr>
						<td colspan="2">
							<form name="form1" method="post"
								action="${path}/shop/cart/insert.do">
								<input type="hidden" name="product_id" value="${vo.product_id}" />
								<select name="amount" id="">
									<c:forEach begin="1" end="10" var="i">
										<option value="${i}">${i}</option>
									</c:forEach>
								</select> &nbsp;개 <input type="submit" value="장바구니에 담기" />
							</form>

						</td>


					</tr>

				</table>

			</td>
		</tr>

	</table>

</body>
</html>