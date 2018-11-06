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
    
    tr, th, td{
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
     <a href = "../frontOrder?command=orderSelectAll"><h3>총 주문내역 보기</h3></a>
     <br/>
     <h3>상품 주문 입력</h3>
     <form action = "../frontOrder?command=orderInsert" method = "post">
        상품 :
        <select name = "proNum"> 
            <c:forEach items = "${applicationScope.list }" var = "list">
                <option value = "${list.getProductNum() }">${list.getProductName() }</option>
            </c:forEach>
        </select><br/>
        배송번호 : <input type = "text" name ="basongNum"/><br/>
        주문수량 :
        <select name = "proQuantity">
            <c:forEach begin="1" end="10" var = "i" >
                <option value = "${i }">${i }</option>
            </c:forEach>
        </select><br/>
        상품옵션 : <input type = "text" name = "option"/><br/>
        배송받을 주소 : <input type = "text" name = "basongAddr"/><br/>
        주문자 번호 : <input type = "text" name = "basongPhone"/><br/>
        배송 요구사항 : <input type = "text" name = "coment"/><br/>
        결제 여부 : <input type = "text" name = "payment"/><br/>
        <input type = "submit" value = "주문하기"/>
        <input type = "reset" value = "리셋"/>
     </form>
     <hr/>
     <h3>장바구니 프로세서</h3>
     <table>
        <tr>
        </tr>
     </table>
     <a href = "../frontOrder?command=orderSelectAll"><h3>총 주문내역 보기</h3></a>
</body>
</html>