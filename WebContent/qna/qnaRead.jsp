<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 게시판</title>
<!--  부트스트랩 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel='stylesheet' href='${pageContext.request.contextPath}/lib/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/style1.css'>


<SCRIPT language=javascript>
function sendUpdate(){ //수정폼
	document.requestForm.command.value ="qnaUpdateForm";
	document.requestForm.submit();
}

function sendDelete(){ //삭제
	if(document.requestForm.qnaBoardPwd.value==""){
			alert("삭제를 위한 비밀번호를 입력해주세요.");
			document.requestForm.qnaBoardPwd.focus();
			return;
	}
	document.requestForm.command.value ="qnaDelete";
	document.requestForm.submit();
}
</script>
</head>




<div class='container'>

  <center>
<h3>QnA 자세히보기</h3>
</center>



<form name="requestForm" method=post action ="frontQna">
<input type=hidden name="command" value="">
<input type=hidden name="qnaBoardQno" value="${dto.qnaBoardQno}">

<div class='form-group row'>
<label for='noticeTitle' class='col-sm-2 col-form-label'>유저아이디</label>
<div class='col-sm-10'>
<input class='form-control' id='qnaBoardUserId' type='text' name='qnaBoardUserId' value='${dto.qnaBoardUserId}'  readonly="readonly">
</div>
</div>


<div class='form-group row'>
<label for='noticeTitle' class='col-sm-2 col-form-label'>제목</label>
<div class='col-sm-10'>
<input class='form-control' id='qnaBoardSubject' type='text' name='qnaBoardSubject' value='${dto.qnaBoardSubject}'  readonly="readonly">
</div>
</div>

<div class='form-group row'>
<label for='noticeDescription' class='col-sm-2 col-form-label'>내용</label>
<div class='col-sm-10'>
<textarea rows="10" cols="50" class='form-control' id='qnaBoardContent' name='qnaBoardContent'  ' readonly="readonly">${dto.qnaBoardContent}
</textarea>
</div>
</div>


<div class='form-group row'>
<label for='noticeTitle' class='col-sm-2 col-form-label'>등록일</label>
<div class='col-sm-10'>
<input class='form-control' id='qnaBoardDate' type='text' name='qnaBoardDate' value='${dto.qnaBoardDate}'  readonly="readonly">
</div>
</div>

<div class='form-group row'>
<label for='noticeTitle' class='col-sm-2 col-form-label'>비밀번호</label>
<div class='col-sm-10'>
<input class='form-control' id='qnaBoardPwd' type='password' name='qnaBoardPwd' >
</div>
</div>



<div class='form-group row'>
<label for='noticeTitle' class='col-sm-2 col-form-label'>사진</label>
<div class='col-sm-10'>
        	<img src="${pageContext.request.contextPath}/qna/save/${dto.qnaBoardPhoto}" alt="img" />
</div>
</div>




<div class='form-group row'>
<div class='col-sm-10'>
<input type=button value="수정하기" onClick="sendUpdate()" class='btn btn-primary btn-sm my-new'>
<input type=button value="삭제하기" onClick="sendDelete()" class='btn btn-primary btn-sm my-new'>				
</div>
</div>


</form>

<footer>
</footer>
</div>


</body>
</html>
