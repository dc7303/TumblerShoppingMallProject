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
    
    <hr/>
    <h3>상품 수정하기</h3>
    <h5>수정할 주문번호, 상품번호, 유저아이디는 유효성 체크를 위한 입력이고 실제 수정되는 부분은 배송번호부터 이하 수정됩니다.</h5>
    <form action = "?command=orderUpdate" method = "post">
        수정할 주문 번호 : <input type = "text" name = "orderNum"/><br/>
        상품번호 : <input type = "text" name = "proNum"/><br/>
        유저아이디 : <input type = "text" name = "userId" value = "${sessionScope.userDTO.getUserId() }"/><br/>
        배송번호 : <input type = "text" name = "basongNum"/><br/>
        상품수량 : <select name = "quantity">
            <c:forEach begin="1" end="10" var="i">
                <option value = "${i }">${i }</option>
            </c:forEach>
        </select><br/>
        상품옵션 : <input type = "text" name = "option"/><br/>
        배송주소 : <input type = "text" name = "basongAddr"/><br/>
        배송핸드폰 : <input type = "text" name = "basongPhone"/><br/>
        기타사항 : <input type = "text" name = "coment"/><br/>
        주문상태 : <input type = "text" name = "payment"/><br/>
        <input type = "submit" value = "수정"/><input type = "reset" value ="리셋"/>
    </form>
</body>
</html>