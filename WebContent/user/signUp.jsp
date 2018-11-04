<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%String path = application.getContextPath(); %>
    ${contextPath }/frontUserInfo?command=userSignIn
    <form action = "../frontUserInfo?command=userSignUp" method = "post">
        ID : <input type = "text" name = "userId"></br>
        PW : <input type = "password" name = "userPwd"></br>
        NAME : <input type = "text" name = "userName"></br>
        BIRTH : <input type = "text" name = "userBirth"></br>
        ADDR : <input type = "text" name = "userAddr"></br>
        EMAIL : <input type = "text" name = "userEmail1">@<input type = "text" name = "userEmail2"></br></br>
        <input type = "submit" value = "가입"></br>
        <input type = "reset" name = "취소"></br>
    </form>

</body>
</html>