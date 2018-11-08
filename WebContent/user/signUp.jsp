<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
div #signup {
	flot: left;
	margin-left: 260px;
	height: 100%;
}

table {
	width: 300px;
	
}

td, th {
	padding: 10px;
	font-size: 20px;
}
</style>
<style type="text/css">
</style>

</head>
<body>
	<div id="menu">
		<jsp:include page="nav.jsp"></jsp:include>
	</div>

	<div id="signup">



		<form method="post" action="user">
			<table cellspacing="0" align="center">
				<caption>
					<h2>회원가입</h2>
				</caption>
				<input type="hidden" name="command" value="insert">
				<tr>
					<td width="100px">ID</td>
					<td width="400px"><input type="text" name="userId" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="userPwd" /></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="userName" /></td>
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
					<td colspan="2"
						style="text-align: center; background-color: #f3f3f3;"><input
						type="submit" value="가입" /> <input type="reset" value="취소" /></td>

				</tr>
			</table>
		</form>
	</div>


</body>
</html>