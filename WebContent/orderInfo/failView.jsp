<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.errorDiv{
			width: 300px;
	}

</style>
</head>
<body>
  <h3>${requsetScope.errorMsg }</h3>
  <div class="errorDiv">
  <img src="${conPath}/img/error.png">
  </div>
</body>
</html>