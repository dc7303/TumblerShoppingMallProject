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
			<a href="../index.jsp"><p>�����Һ�</p></a>
		</div>



		<!-- �޴��� ����  -->
		<nav>
		<ul id="navi">


			<li class="group">
				<div class="title">Notice</div>
				<ul class="sub">
					<li><a href="#"> �������� </a></li>
				</ul>
			</li>

			<li class="group">
				<div class="title">�Һ�</div>
				<ul class="sub">
					<li><a href="#"> �ӱ��� </a></li>
					<li><a href="#"> �����η��� </a></li>
					<li><a href="#"> �ݵ��� </a></li>
					<li><a href="#"> Ƽ </a></li>
				</ul>
			</li>

			<li class="group">
				<div class="title">Q&A�Խ���</div>
				<ul class="sub">
					<li><a href="#"> ���ֹ������� </a></li>
					<li><a href="#"> ���ǰԽ��� </a></li>
				</ul>
			</li>

			<li class="group">
				<div class="title">����������</div>
				<ul class="sub">
					<li><a href="#"> ��ٱ��� </a></li>
					<li><a href="#"> �ֹ���ȸ </a></li>
					<li><a href="#"> ȸ���������� </a></li>
				</ul>
			</li>

			<li class="login">
				<ul class="uesrinfo">
					<li><a href="${applicationScope.conPath }/signIn.jsp"> �α��� </a></li>
					<a>/</a>
					<li><a href="${applicationScope.conPath }/user/signUp.jsp"> ȸ������ </a></li>
				</ul>
			</li>
		</nav>
	</div>
	
	

	<!-- �޴��� �� -->


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