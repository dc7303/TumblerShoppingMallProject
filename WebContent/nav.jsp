<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="ko">

<head>
	<title>header</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script type="text/javascript" src="https:code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="js/common.js"></script>
	<link rel="stylesheet" type="text/css" href="css/basic.css">
</head>

<body>
	<div class="container">
		<div class="header_menu_bar">

			<span id="logo">
				<a href="#none" >
					 Tumbler
				</a>
			</span>

			<span id="sign" >
				<!-- login.jsp 연걸 -->
				<a href="#" onclick="window.open('index.html', 'Login', 'width=550 height=500')">
				로그인&nbsp;
				</a>

				<a>/</a>

				<!--singup.jsp 연걸 -->
				<a href="#" onclick="window.open('index.html', 'signup', 'width=550 height=500')">
				&nbsp;회원가입
				</a>
			</span>

		<br><br>

			<span>
				<!--notice.jsp 연걸 -->
				<a href="#none">
				공지사항
				</a>
			</span>

			<span>
				<!--productlist.jsp 연걸 -->
				<a href="#none">
					PRODUCT
				</a>
			</span>

			<span>
					<!-- mypage.jsp 연걸 -->
				<a href="#none">
				마이페이지
				</a>
			</span>

			<span>
				<a href="#none">
				Q'n'A 게시판
				</a>
			</span>
		</div>


</body>

</html>
