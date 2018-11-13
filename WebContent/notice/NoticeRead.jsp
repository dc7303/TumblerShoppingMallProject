<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 게시판</title>
<script src="${conPath}/lib/jquery-3.3.1.min.js"></script>
<script src="${conPath}/lib/SemanticUI/semantic.min.js"></script>
<link rel="stylesheet" type="text/css" href="${conPath}/lib/SemanticUI/semantic.min.css">

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
<style>
 .table-container {
  	width :600px;
  	margin-left: 250px;
	margin-top : 135px;
	margin-bottom: 200px;
  }	
  .floatRight{
  	float:right;
  }
</style>
</head>

<body>

<jsp:include page="../nav.jsp"/>

<div class='container'>

  <center>
<h3>공 지 확 인</h3>
</center>



<div class="table-container ">
<form class="ui form" name="requestForm" method=post action ="frontNotice">
<input type=hidden name="command" value="">
<input type=hidden name="noticeBoardNum" value="${noticeDto.noticeBoardNum}">

<input class='form-control' id='noticeTitle' type='text' name='no' value="${noticeDto.noticeBoardNum}" readonly="readonly">
  
  <div class="field">
    <label>제목</label>
    <input type="text" name="title" placeholder="title" name='title' value='${noticeDto.noticeBoardSubject}'  readonly="readonly">
  </div>
  
  <div class="field">
    <label>내용</label>
    <textarea rows="10" cols="50" class='form-control' id='noticeDescription' name='content'  readonly="readonly">${noticeDto.noticeBoardContent}
	</textarea>
  </div>

<input type=button value="삭제하기" onClick="sendDelete()" class='ui black basic button floatRight'>
  <input type=button value="수정하기" onClick="sendUpdate()" class='ui black basic button floatRight'>
</form>
</div>

</body>
</html>

