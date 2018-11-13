<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	border: 1px solid #333;
	width: 500px;
	border-spacing:0px;
}

th {
	background-color: #333;
	color: lightgrey;
}

tr, td, th {
	border: 0.5px solid lightgrey;
}
</style>
</head>
<body>
	<h3>배송상태 조회</h3>
	<table>
		<tr>
			<th>상품명</th>
			<td colspan="3">${param.proName }</td>
		<tr>
		<tr>
			<th>주문번호</th>
			<td>${param.orderNum }</td>
			<th>배송번호</th>
			<td>${param.basongNum }</td>
		</tr>
		<tr>
			<th>배송사</th>
			<td>${param.company }</td>
			<th>송장번호</th>
			<td width="100px">${param.invoiceNum }</td>
		</tr>
		<tr>
			<th>배송지</th>
			<td colspan="3">${param.basongAddr }</td>
		</tr>
		<tr>
			<th>배송지 연락처</th>
			<td colspan="3">${param.basongPhone }</td>
		</tr>
		<tr>
			<th>배송시작일</th>
			<td>${param.basongDate }</td>
			<th>배송상태</th>
			<td>
			<c:choose>
					<c:when test="${param.status eq 0 }">
						<strong>배송준비</strong>
					</c:when>
					<c:when test="${param.status eq 1 }">
						<strong>배송시작</strong>
                        </c:when>
					<c:when test="${basongStatus eq 2 }">
						<strong>배송중</strong>
                        </c:when>
					<c:otherwise/>
				</c:choose>
		   </td>
		</tr>
	</table>

</body>
</html>