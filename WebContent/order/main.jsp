<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <a href = "orderInsert.jsp">주문하기(Insert)</a></br>
    <a href = "../frontOrder?command=orderSelectAll">주문 전체조회(selectAll)</a></br>
    <form action = "../frontOrder?command=orderByUserId" method = "post">
        아이디로 조회하기 : <br/>
        <input type = "text" name = "userId" value = "dong"/>
        <input type = "submit" value = "조회"/>
    </form>
    <form action = "../frontOrder?command=orderByOrdernum" method = "post">
        주문번호로 조회하기 : <br/>
        <input type = "text" name = "orderNum" value = "25"/>
        <input type = "submit" value = "조회"/>
    </form>
    삭제할 주문 번호 입력 : <br/>
    <a href = "delete.jsp">삭제하기(delete)</a>
</body>
</html>