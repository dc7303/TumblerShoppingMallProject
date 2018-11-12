<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 게시판</title>
<!--  부트스트랩 -->
<script src="${conPath}/lib/jquery-3.3.1.min.js"></script>
<script src="${conPath}/lib/SemanticUI/semantic.min.js"></script>
<link rel="stylesheet" type="text/css" href="${conPath}/lib/SemanticUI/semantic.min.css">
<SCRIPT >
function checkValid() {
	var f = window.document.updateForm;

	if ( f.title.value == "" ) {
		alert( "제목을 입력해 주세요." );
		f.title.focus();
		return false;
	}
	if ( f.content.value == "" ) {
        alert( "설명을 입력해 주세요." );
        f.content.focus();
        return false;
    }
    
}

</SCRIPT>
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
</HEAD>

<BODY>

<jsp:include page="../nav.jsp"/>
<div class='container'>
  <center>
<h3>공 지 등 록</h3>
</center>


<div class="table-container ">
<form class="ui form" name=updateForm method=post action="frontNotice" onSubmit="return checkValid()">
<input type="hidden" name="command" value="noticeUpdate" >
<input type='hidden' name='NoticeNum' value="${noticeDto.getNoticeBoardNum()}">

  
  <div class="field">
    <label>제목</label>
    <input type="text" id='noticeTitle' type='text' name='title' value='${noticeDto.noticeBoardSubject}'>
  </div>
  
  <div class="field">
    <label>내용</label>
	<textarea rows="10" cols="50" class='form-control' id='noticeDescription' name='content' >${noticeDto.noticeBoardContent}
	</textarea>
  </div>

 <a href="frontNotice?command=noticeSelectAll"><input type=button value="목록으로" class='ui black basic button floatRight'></a>
<input type="submit" value="수정하기" class='ui black basic button floatRight'>
  
</form>
</div>

<jsp:include page="../footer.jsp"/>


</BODY>
</HTML>







