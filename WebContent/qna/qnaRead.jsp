<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA 게시판</title>

<script src="${conPath}/lib/jquery-3.3.1.min.js"></script>
<script src="${conPath}/lib/SemanticUI/semantic.min.js"></script>
<link rel="stylesheet" type="text/css" href="${conPath}/lib/SemanticUI/semantic.min.css">


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
<h3>QnA 자세히보기</h3>
</center>


<div class="table-container ">
<form class="ui form" name="requestForm" method=post action ="frontQna">
<input type=hidden name="command" value="">
<input type=hidden name="qnaBoardQno" value="${dto.qnaBoardQno}">

  
  <div class="field">
    <label>유저아이디</label>
    <input type="text" id='qnaBoardUserId' type='text' name='qnaBoardUserId' value='${dto.qnaBoardUserId}'  readonly="readonly">
  </div>
  
  <div class="field">
    <label>내용</label>
    <textarea rows="10" cols="50" class='form-control' id='qnaBoardContent' name='qnaBoardContent'  ' readonly="readonly">${dto.qnaBoardContent}
	</textarea>
  </div>
  
   <div class="field">
    <label>등록일</label>
    <input type="text" class='form-control' id='qnaBoardDate' type='text' name='qnaBoardDate' value='${dto.qnaBoardDate}'  readonly="readonly">
  </div>
  
   <div class="field">
    <label>비밀번호</label>
    <input type="password" id='qnaBoardPwd' type='password' name='qnaBoardPwd' >
  </div>
   <div class="field">
    <label>사진</label>
		<div class='col-sm-10'>
        	<img src="${pageContext.request.contextPath}/qna/save/${dto.qnaBoardPhoto}" alt="img" />
	</div>  
</div>




<input type=button value="삭제하기" onClick="sendDelete()" class='ui black basic button floatRight'>
  <input type=button value="수정하기" onClick="sendUpdate()" class='ui black basic button floatRight'>
</form>
</div>
<jsp:include page="../footer.jsp"/>

</body>
</html>

