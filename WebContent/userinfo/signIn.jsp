<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<link rel='stylesheet' href='bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='css/style1.css'>
<meta charset="UTF-8">
<title>로그인</title>
<style>
h1 {
	text-align: center;
	font-size: 50px;
}

h1 b {
	color: #333;
}

div {margin: 20px;}

.id .pw .button{margin: 10px;}

.id input{height: 35px; width: 220px}
.pw input{height: 35px; width: 220px}

.button input{
		height: 35px; 
		width: 260px; 
		background-color: #333; 
		color: white;}

</style>
</head>
<body>
<center>
	<h1><b>Login</b></h1>


	<div class="id">
		ID  &nbsp;<input type="text" name="id" />
	</div>

	<div class="pw">
		PW <input type="password" name="password"/>
	</div>
	
	
    <div class="button">
    
	<input TYPE="button"
		
		value="SIGN UP" onclick="location.href=''">

    </div>
    </center>

</body>
</html>