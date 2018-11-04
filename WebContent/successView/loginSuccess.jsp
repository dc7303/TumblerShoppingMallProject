<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%
    String contextPath = application.getContextPath();
    %>
    로그인 성공<br/>
    수정하실 항목을 입력하세요.
    <form action = "${contextPath }/frontUserInfo?command=userUpdate" method = "post">
        ID : <input type = "text" name = "userId" value = "${sessionScope.userId }"/><br/>
        PW : <input type = "password" name = "userPwd"/><br/>
        NAME : <input type = "text" name = "userName"/><br/>
        BIRTH : <input type = "text" name = "userBirth"/><br/>
        ADDR : <input type = "text" name = "userAddr"/><br/>
        EMAIL : <input type = "text" name = "userEmail1"/>@<input type = "text" name = "userEmail2"/><br/>
        <input type = "submit" value ="수정하기"/><input type ="reset" value ="리셋"/>
    </form>
</body>
</html>