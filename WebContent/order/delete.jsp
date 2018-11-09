<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = "../frontOrder?command=orderDelete" method="post">
    <input type = "text" name = "orderNum" value = "${param.orderNum }"/>
    <input type = "submit" value = "삭제"/>
</form>
</body>
</html>