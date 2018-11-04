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
    <%String path = application.getContextPath(); %>
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
        <c:forEach items="${applicationScope.list }" var = "list">
        <tr>
            <td>${list.getProductNum() }</td>
            <td>${list.getProductName() }</td>
            <td>${list.getProductInfo() }</td>
            <td>${list.getProductPrice() }</td>
            <td>${list.getProductCategory() }</td>
            <td>${list.getProductPicture() }.jpg</td>
            <td>${list.getProductBrand() }</td>
        </tr>
        </c:forEach>
    </table>
    <form action ="?command=productDelete" method = "post">
        삭제할 상품번호 입력 : <input type ="text" name = "proNum"/><input type ="submit" value ="삭제"/>
    </form>
    
    
    <hr>
    
	<h3>상품추가</h3>
    <form action = "?command=productInsert" method = "post">
	    상품이름 : <input type = "text" name = "proName"><br/>
	    상품정보 : <input type = "text" name = "proInfo"><br/>
	    상품가격 : <input type = "text" name = "proPrice"><br/>
	    카테고리 : <input type = "text" name = "proCategory"><br/>
	    사진이름 : <input type = "text" name = "proPicture"><br/>
	    브랜드 : <input type = "text" name = "proBrand"><br/>
	    <input type = "submit" value ="추가"/>
	    <input type = "reset" value ="리셋"/>
    </form>
    
    <hr>
    
    <h3>상품수정</h3>
     <form action = "?command=productUpdate" method = "post">
        상품이름 : <input type = "text" name = "proName"><br/>
        상품정보 : <input type = "text" name = "proInfo"><br/>
        상품가격 : <input type = "text" name = "proPrice"><br/>
        카테고리 : <input type = "text" name = "proCategory"><br/>
        사진이름 : <input type = "text" name = "proPicture"><br/>
        브랜드 : <input type = "text" name = "proBrand"><br/>
        <input type = "submit" value ="수정"/>
        <input type = "reset" value ="리셋"/>
    </form>
    
    
</body>
</html>