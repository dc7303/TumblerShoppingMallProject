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
    
    tr, th, td {
        border:1px solid black;
    }
</style>
</head>
<body>
    <table>
        <tr>
            <th>주문번호</th>
            <th>상품번호</th>
            <th>유저아이디</th>
            <th>배송번호</th>
            <th>수량</th>
            <th>옵션</th>
            <th>배송주소</th>
            <th>배송연락망</th>
            <th>기타사항</th>
            <th>주문상태</th>
        </tr>
        <c:forEach items = "${requestScope.orderList }" var ="list">
            <tr>
                <td>${list.getOrderNum()}</td>
                <td>${list.getOrderProductNum()}</td>
                <td>${list.getOrderUserId()}</td>
                <td>${list.getBasongNum()}</td>
                <td>${list.getOrderQuantity()}</td>
                <td>${list.getOrderOption()}</td>
                <td>${list.getBasongAddr()}</td>
                <td>${list.getBasongPhone()}</td>
                <td>${list.getComent()}</td>
                <td>${list.getPayment()}</td>
            </tr>
        </c:forEach>
    </table>
    <form action ="${applicationScope.contextPath }/frontOrder?command=orderDelete" method="post">
    삭제할 주문 번호 : <input type = "text" name = "orderNum"/>
    <input type = "submit" value ="삭제"/>
    </form>
</body>
</html>