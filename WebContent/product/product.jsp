<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	        <th>상품번호</th>
	        <th>상품이름</th>
	        <th>성품정보</th>
	        <th>가격</th>
	        <th>카테고리</th>
	        <th>사진파일이름</th>
	        <th>브랜드</th>
        </tr>
        <c:forEach items="${requestScope.list }" var = "list">
        <tr>
            <td>${list.getProductNum() }</td>
            <td>${list.getProductName() }</td>
            <td>${list.getProductInfo() }</td>
            <td>${list.getProductPrice() }</td>
            <td>${list.getProductCategory() }</td>
            <td>${list.getProductFicture() }.jpg</td>
            <td>${list.getProductBrand() }</td>
        </tr>
        </c:forEach>
    </table>
    
</body>
</html>