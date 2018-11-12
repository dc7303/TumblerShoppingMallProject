<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ko">

<head>
	<title>header</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="${applicationScope.conPath }/css/basic.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
  <script>
    $(function(){
      $('a[name=noLogIn]').on("click", function(){
        alert('로그인 후 이용해주세요.');
      });
      
      function windowSignIn(){
        window.open('user/signIn.jsp', 'signIn', 'width=550 height=500')
    }
    
    function windowSignUp(){
        window.open('user/signUp.jsp', 'signup', 'width=550 height=500')
    }
    });
  </script>

<body>
	<div class="container">
		<div class="header_menu_bar">

			<span id="logo">
				<a href="index.html" >
					 Tumbler
				</a>
			</span>
			<span id="sign" >
			   <c:choose>
			     <c:when test ="${sessionScope.userDTO == null }">
					<!-- login.jsp 연걸 -->
					<a href="#" onclick="window.open('user/signIn.jsp', 'Login', 'width=550 height=500')">
					로그인&nbsp;
					</a>
	
					<!--singup.jsp 연걸 -->
					<a href="#" onclick="window.open('user/signUp.jsp', 'signup', 'width=550 height=500')">
					&nbsp;회원가입
					</a>
				</c:when>
				<c:otherwise>
				  <a href='${applicationScope.conPath }/frontUserInfo?command=userSignOut'>&nbsp;로그아웃</a>
				  <a>/</a>
				  <a href='${applicationScope.conPath }/frontBasket?command=basketByUserID&flag=no'>&nbsp;장바구니</a>
				</c:otherwise>
			  </c:choose>
			</span>

		<br><br>

			<span>
				<!--notice.jsp 연걸 -->
				<a href="${applicationScope.conPath }/frontNotice?command=noticeSelectAll">
				공지사항
				</a>
			</span>

			<span>
				<!--productlist.jsp 연걸 -->
				<a href="${applicationScope.conPath }/frontProduct?command=productSelectAll">
					PRODUCT
				</a>
			</span>

			<span>
					<!-- mypage.jsp 연걸 -->
			    <c:choose>
			      <c:when test="${sessionScope.userDTO != null }">
					<a href="${applicationScope.conPath }/frontOrder?command=orderByUserId&basongFlag=use">
					마이페이지
					</a>
				  </c:when>
				  <c:otherwise>
				    <a href="#" name = "noLogIn">
                    마이페이지
                    </a>
				  </c:otherwise>
				</c:choose>
			</span>

			<span>
				<a href="${applicationScope.conPath }/frontQna?command=qnaSelectAll">
				QnA 게시판
				</a>
			</span>
		</div>


</body>

</html>