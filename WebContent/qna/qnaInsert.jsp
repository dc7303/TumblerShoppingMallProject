<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA 게시판</title>
<script src="${conPath}/lib/jquery-3.3.1.min.js"></script>
<script src="${conPath}/lib/SemanticUI/semantic.min.js"></script>
<link rel="stylesheet" type="text/css" href="${conPath}/lib/SemanticUI/semantic.min.css">
<SCRIPT language=javascript>
function checkValid() {
	var f = window.document.writeForm;
	
	if ( f.qnaBoardSubject.value == "") {
	    alert( "제목을 입력해 주세요." );
	    f.qnaBoardSubject.focus();
		return false;
    }
	if ( f. qnaBoardContent.value == "" ) {
		alert( "내용을 입력해 주세요." );
		f. qnaBoardContent.focus();
		return false;
	}
	if ( f.qnaBoardPwd.value == "" ) {
		alert( "비밀번호를 입력해 주세요." );
		f.qnaBoardPwd.focus();
		return false;
	}
	if ( f.qnaBoardUserId.value == "" ) {
        alert( "아이디를 입력해 주세요." );
        f.qnaBoardUserId.focus();
        return false;
    }
	
	
    return true;
}
</SCRIPT>
<style>
 .table-container {
  	width :65%;
  	margin-left: 17%;
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
<h3>QnA 등 록</h3>
</center>

<div class="table-container ">
<form class="ui form"  name="writeForm" method="post" action="../frontQna?command=qnaInsert"  onSubmit='return checkValid()' enctype="multipart/form-data">
  <div class="field">
    <label>제목</label>
    <input type="text" id='qnaBoardSubject' type='text' name='qnaBoardSubject'>
  </div>
  
  <div class="field">
    <label>내용</label>
    <textarea rows="10" cols="50" class='form-control' id='qnaBoardContent' name='qnaBoardContent' ></textarea>
  </div>
  
    <div class="field">
    <label>비밀번호</label>
    <input type="text" id='qnaBoardPwd' type='password' name='qnaBoardPwd'>
  </div>

    <div class="field">
    <label>사진</label>
    <input type="file" class='form-control' id='qnaBoardPhoto' type='file' name='qnaBoardPhoto'>
  </div>
  <button type="submit" class="ui black basic button floatRight">Write</button>
</form>
</div>

<jsp:include page="../footer.jsp"/>


</body>
</html>










