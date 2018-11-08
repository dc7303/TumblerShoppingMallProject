<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h4>테이블 셋팅 상품 : 1   스타벅스텀블러 예쁨  10000   텀블러 a   스타벅스    100 18/11/08</h4>
    <h4>유저정보 : dong    최동철 123 910507  010-1111-1111   경기도양주   dc@gmail.com    0   0   18/11/08</h4>
    
    
    <h1>주문하기 - TEST</h1>
    <form action = "../frontOrder?command=orderInsert" method = "post">
        <h3>TB_ORDER Table</h3>
        주문번호는 시퀀스처리<br/>
        userId(String) : <input type = "text" name = "userId" value ="dong"/><br/>
        결제일자는 sysdate처리</br>
        주문 가격 정보는 쿼리문으로 해결<br/>
        orther(String) : <input type = "text" name = "orther"/><br/>

        <h3>TB_DETAIL Table</h3>
        디테일 번호는 시퀀스 처리 <br/>
        주문번호는 상위 TB_ORDER테이블 입력값으로<br/>
        pno(int) : <input type = "text" name = "proNum" value ="21"/></br>
        가격은 쿼리문으로 해결<br/>
        amount(int) : <input type = "text" name = "amount"/></br>
        d_option(String) : <input type = "text" name = "option"/></br>
        주문일자는 sysdate처리</br>
        
        <h3>TB_DELIVERY</h3>
        택배 식별 번호는 시퀀스처리<br/>
        company(string) : <input type = "text" name = "company"/></br>
        shipnum(String) : <input type = "text" name = "shipNum"/></br>
        addr(string) : <input type = "text" name = "addr"/></br>
        phone(string) : <input type = "text" name = "phone"/></br>
        배송일자는 sysdate</br>
        주문번호는 상위 TB_ORDER테이블 입력값으로<br/>
        <input type = "submit" value = "insert"/><input type ="reset" value = "reset"/>
    </form>
</body>
</html>