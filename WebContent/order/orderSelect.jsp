<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    table {
        border:1px solid black;
    }
    
    tr, th, td{
        border:1px solid black;
        text-align:center;
    }
    
    th {
        background-color:lightblue;
    }
</style>
</head>
<body>
    <table>
        <tr>
            <th>주문번호</th>
            <th>유저아이디</th>
            <th>주문일</th>
            <th>가격</th>
            <th>기타</th>
            <th>디테일번호</th>
            <th>상품번호</th>
            <th>상세가격</th>
            <th>옵션</th>
            <th>수량</th>
            <th>상세주문일</th>
            <th>배송번호</th>
            <th>배송회사</th>
            <th>송장번호</th>
            <th>배송주소</th>
            <th>휴대폰번호</th>
            <th>배송시작일</th>
            <th>배송상태</th>
        </tr>
	    <c:forEach items = "${requestScope.orderList }" var = "list">
	        <tr>
	           <td>${list.getOrderNum() }</td>
	           <td>${list.getOrderUserId() }</td>
	           <td>${list.getOrderDate() }</td>p
	           <td>${list.getOrderPrice() }</td>
	           <td>${list.getOrderComment() }</td>
	           <td>${list.getDetailDTO().getOrderDetailNum() }</td>
	           <td>${list.getDetailDTO().getProductNum() }</td>
	           <td>${list.getDetailDTO().getOrderDetailPrice() }</td>
	           <td>${list.getDetailDTO().getOrderDetailQuantity() }</td>
	           <td>${list.getDetailDTO().getOrderDetailOption() }</td>
	           <td>${list.getDetailDTO().getOrderDetailDate() }</td>
	           <td>${list.getBasongDTO().getBasongNum() }</td>
	           <td>${list.getBasongDTO().getBasongCompany() }</td>
	           <td>${list.getBasongDTO().getBasongInvoiceNum() }</td>
	           <td>${list.getBasongDTO().getBasongAddr() }</td>
	           <td>${list.getBasongDTO().getBasongPhone() }</td>
	           <td>${list.getBasongDTO().getBasongDate() }</td>
	           <td>${list.getBasongDTO().getBasongStatus() }</td>
	        </tr>
	    </c:forEach>
    </table>
</body>
</html>