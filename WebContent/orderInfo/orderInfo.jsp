<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
    border: 1px solid #333;
    width: 500px;
}

th {
    background-color: #333;
    color: lightgrey;
}

tr, td, th {
    border: 1px solid #333;
}
</style>
</head>
<body>
  <h3>주문 상품 정보</h3>
  <table>
    <tr>
      <th>주문번호</th>
      <td>${param.orderNum }</td>
    </tr>
    <tr>
      <th>주문일</th>
      <td>${param.detailDate }</td>
    </tr>
    <tr>
      <th>상품이름</th>
      <td>${param.proName }</td>
    </tr>
    <tr>
      <th>상품가격</th>
      <td><fmt:formatNumber>${param.detailPrice }</fmt:formatNumber>원</td>
    </tr>
    <tr>
      <th>주문수량</th>
      <td>${param.detailQuantity }</td>
    </tr>
    <tr>
      <th>주문옵션</th>
      <td>${param.detailOption }</td>
    </tr>
    <tr>
      <td colspan="2">상품이미지 들어갈 예정<img src ="${picture }"></td>
    </tr>
  </table>
</body>
</html>