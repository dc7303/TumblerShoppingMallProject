<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
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


<form name=updateForm method=post action="frontQna" onSubmit="return checkValid()">

<input type="hidden" name="command" value="qnaUpdate">
<input type='hidden' name='qnaBoardQno' value="${dto.qnaBoardQno}">

<div class='form-group row'>
<label for='noticeTitle' class='col-sm-2 col-form-label'>제목</label>
<div class='col-sm-10'>
<input class='form-control' id='qnaBoardSubject' type='text' name='qnaBoardSubject' value='${dto.qnaBoardSubject}'>
</div>
</div>

<div class='form-group row'>
<label for='noticeDescription' class='col-sm-2 col-form-label'>공지내용</label>
<div class='col-sm-10'>
<textarea rows="10" cols="50" class='form-control' id='qnaBoardContent' name='qnaBoardContent' >${dto.qnaBoardContent}
</textarea>
</div>
</div>
	
<div class='form-group row'>
<div class='col-sm-10'>
<input type="submit" value="수정하기" class='btn btn-primary btn-sm my-new'/>
<a href="frontNotice?command=qnaSelectAll"><input type="button" value="목록" class='btn btn-primary btn-sm my-new'/></a>

</div>
</div>
</form>

<footer>
</footer>
</div>


</BODY>
</HTML>



<!-- 수정전 -->
<%@ page info="게시판 수정하기" contentType="text/html;charset=UTF-8" %>

<HTML>
<HEAD>
<link rel="stylesheet" href="css/style.css">

<SCRIPT >
function checkValid() {
	var f = window.document.qnaUpdateForm;
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
 
}

</SCRIPT>

</HEAD>

<BODY>


<form name=qnaUpdateForm method=post action="qna" onSubmit="return checkValid()">
    <input type="hidden" name="command" value="qnaUpdate" >
    <input type='hidden' name='qnaBoardQno' value="${dto.qnaBoardQno}">
	<table align="center" cellpadding="5" cellspacing="1" width="600" border="1">
    <tr>
        <td width="1220" height="20" colspan="2" bgcolor="#00cc00">
            <p align="center"><font color="white" size="3"><b>  게시물 수정하기</b></font></p>
        </td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">제목</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="qnaBoardSubject" size="30"
		 value="${dto.qnaBoardSubject}"></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">내용</span></b></p>
        </td>
        <td width="450" height="20" ><b><span style="font-size:9pt;">
		<input type=text name="qnaBoardContent" size="30"
		 value="${dto.qnaBoardContent}"></span></b></td>
    </tr>
    
 <!--  
    <tr>
        <td width="150" height="20" >
            <p align="right"><b><span style="font-size:9pt;">비밀번호</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;"><input type=password name="password" size="12"> 
            (비밀번호가 맞아야 수정이 가능합니다.)</span></b></td>
    </tr>
    -->
    <tr>
        <td width="450" height="20" colspan="2" align="center"><b><span style="font-size:9pt;">
		<input type="submit" value="수정하기"> <input type="reset" value="다시쓰기"></span></b></td>
    </tr>
</table>
</form>
<hr>
<div align=right><span style="font-size:9pt;">&lt;<a href="${path}/qna?command=list">리스트로 돌아가기</a>&gt;</span></div>
</BODY>
</HTML>










