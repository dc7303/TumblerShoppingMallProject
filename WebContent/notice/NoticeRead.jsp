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
function sendUpdate(){//수정폼
	document.requestForm.command.value ="noticeupdateForm";
	document.requestForm.submit();
}

function sendDelete(){//삭제

	document.requestForm.command.value ="noticeDelete";
	document.requestForm.submit();
}
</script>
</head>




<div class='container'>

  <center>
<h3>공 지 확 인</h3>
</center>



<form name="requestForm" method=post action ="frontNotice">

<div class='form-group row'>
<label for='noticeTitle' class='col-sm-2 col-form-label'>등록번호</label>
<div class='col-sm-10'>
<input class='form-control' id='noticeTitle' type='text' name='no' value="${noticeDto.noticeBoardNum}" readonly="readonly">
</div>
</div>


<div class='form-group row'>
<label for='noticeTitle' class='col-sm-2 col-form-label'>공지제목</label>
<div class='col-sm-10'>
<input class='form-control' id='noticeTitle' type='text' name='title' value='${noticeDto.noticeBoardSubject}'  readonly="readonly">
</div>
</div>

<div class='form-group row'>
<label for='noticeDescription' class='col-sm-2 col-form-label'>공지내용</label>
<div class='col-sm-10'>
<textarea rows="10" cols="50" class='form-control' id='noticeDescription' name='content'  ' readonly="readonly">${noticeDto.noticeBoardContent}
</textarea>
</div>
</div>

<div class='form-group row'>
<label for='noticeTitle' class='col-sm-2 col-form-label'>공지날짜</label>
<div class='col-sm-10'>

</div>
</div>

<div class='form-group row'>
<div class='col-sm-10'>
<input type=hidden name="command" value="">
<input type=hidden name="noticeBoardNum" value="${noticeDto.noticeBoardNum}">
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

