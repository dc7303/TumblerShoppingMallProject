<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%String contextPath = application.getAttribute("contextPath").toString(); %>
    <form action = "${contextPath }/frontUserInfo?command=userSignIn" method = "post">
        ID : <input type = "text"  name = "userId"/><br/>
        PW : <input type = "password" name = "userId"><br/>
        <input type = "submit" value = "SignIn"/></br>
    </form>
    <a href = "/user/signIn.jsp"><strong>회원가입</strong></a>
</body>
</html>