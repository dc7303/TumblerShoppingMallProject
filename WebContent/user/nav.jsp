<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.11.1.js">
	
</script>

</head>
<body>
	<!-- logo -->
	<div id="wrap">

		<div class="main_logo">
			<a href="../index.jsp"><p>지성텀블러</p></a>
		</div>



		<!-- 메뉴바 시작  -->
		<nav>
		<ul id="navi">


			<li class="group">
				<div class="title">Notice</div>
				<ul class="sub">
					<li><a href="#"> 공지사항 </a></li>
				</ul>
			</li>

			<li class="group">
				<div class="title">텀블러</div>
				<ul class="sub">
					<li><a href="#"> 머그컵 </a></li>
					<li><a href="#"> 스테인레스 </a></li>
					<li><a href="#"> 콜드컵 </a></li>
					<li><a href="#"> 티 </a></li>
				</ul>
			</li>

			<li class="group">
				<div class="title">Q&A게시판</div>
				<ul class="sub">
					<li><a href="#"> 자주묻는질문 </a></li>
					<li><a href="#"> 문의게시판 </a></li>
				</ul>
			</li>

			<li class="group">
				<div class="title">마이페이지</div>
				<ul class="sub">
					<li><a href="#"> 장바구니 </a></li>
					<li><a href="#"> 주문조회 </a></li>
					<li><a href="#"> 회원정보수정 </a></li>
				</ul>
			</li>

			<li class="login">
				<ul class="uesrinfo">
					<li><a href="${applicationScope.conPath }/signIn.jsp"> 로그인 </a></li>
					<a>/</a>
					<li><a href="${applicationScope.conPath }/user/signUp.jsp"> 회원가입 </a></li>
				</ul>
			</li>
		</nav>
	</div>
	
	

	<!-- 메뉴바 끝 -->


	<script>
		$(".sub").hide();
		$("div.title").click(function() {
			if ($(this).next().css("display") == "none") {
				$(".sub").slideUp("slow");
			}
			$(this).next().slideDown("slow");
		});
	</script>

</body>
</html>