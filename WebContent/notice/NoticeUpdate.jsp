<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 게시판</title>
<!--  부트스트랩 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel='stylesheet' href='${pageContext.request.contextPath}/lib/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/style1.css'>
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

</HEAD>

<BODY>


<div class='container'>
  <center>
<h3>공 지 등 록</h3>
</center>


<form name=updateForm method=post action="${path}/frontNotice" onSubmit="return checkValid()">

<input type="hidden" name="command" value="noticeUpdate" >
<input type='hidden' name='NoticeNum' value="${noticeDto.getNoticeBoardNum()}">

<div class='form-group row'>
<label for='noticeTitle' class='col-sm-2 col-form-label'>공지제목</label>
<div class='col-sm-10'>
<input class='form-control' id='noticeTitle' type='text' name='title' value='${noticeDto.noticeBoardSubject}'>
</div>
</div>

<div class='form-group row'>
<label for='noticeDescription' class='col-sm-2 col-form-label'>공지내용</label>
<div class='col-sm-10'>
<textarea rows="10" cols="50" class='form-control' id='noticeDescription' name='content' >${noticeDto.noticeBoardContent}
</textarea>
</div>
</div>
	
<div class='form-group row'>
<div class='col-sm-10'>
<input type="submit" value="수정하기" class='btn btn-primary btn-sm my-new'/>
<a href="${path}/frontNotice?command=noticeSelectAll"><input type="button" value="목록" class='btn btn-primary btn-sm my-new'/></a>

</div>
</div>
</form>

<footer>
</footer>
</div>


</BODY>
</HTML>







