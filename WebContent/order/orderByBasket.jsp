<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h4>장바구니 주문하기</h4>
    <form action = "../frontOrder?command=orderInsertByBasket" method = "post">
        <input type = "text" name = "userId" value = "dong"/>
        <input type = "text" name = "comment" value = "대충해줘"/><br>
        택배 식별 번호는 시퀀스처리<br/>
        company(string) : <input type = "text" name = "company"/></br>
        shipnum(String) : <input type = "text" name = "shipNum"/></br>
        addr(string) : <input type = "text" name = "addr"/></br>
        phone(string) : <input type = "text" name = "phone"/></br>
        배송일자는 sysdate</br>
        주문번호는 상위 TB_ORDER테이블 입력값으로<br/>
        <input type = "submit" value = "주문하기"/>
        
    </form>
</body>
</html>