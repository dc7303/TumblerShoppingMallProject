<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel='stylesheet' href='bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='css/style1.css'>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>



table {
    margin-left: 10px;
	width: 440px;
}

td, th {
	padding: 10px;
	font-size: 15px;
}
tr td input { height: 35px; width: 220px}

.setbutton {
		height: 30px; 
		width: 60px; 
		background-color: #333; 
		color: white;}
</style>
<style type="text/css">
</style>

</head>
<body>
<center>

	<div id="signup">

		<form method="post" action="../frontUserInfo">
			<table cellspacing="0" align="center">
				<caption>
					<h2>회원가입</h2>
				</caption>
				<input type="hidden" name="command" value="userSignUp">
				<tr>
					<td >ID</td>
					<td ><input type="text" name="userId" /></td>
				</tr>

				<tr>
					<td>Name</td>
					<td><input type="text" name="userName" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="userPwd" /></td>
				</tr>
				<tr>
					<td>생일</td>
					<td><input type="text" name="userBirth" /></td>
				</tr>

				<tr>
					<td>전화번호</td>
					<td><input type="text" name="userPhone" /></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="userAddr" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" name="userEmail" /></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center; ">
					<input class="setbutton" type="submit" value="가입" /> 
					<input class="setbutton" type="reset" value="취소"  />
					</td>
				</tr>
			</table>
		</form>
	</div>


</center>
</body>
</html>