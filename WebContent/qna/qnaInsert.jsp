<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<c:set var="path" value="${pageContext.request.contextPath}" scope="application"/>

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

</head>
<body>



<div class='container'>

  <center>
<h3>QnA 등록</h3>
</center>


<form name="writeForm" method="post" action="../frontQna?command=qnaInsert"  onSubmit='return checkValid()' enctype="multipart/form-data">


<div class='form-group row'>
<label for='noticeTitle' class='col-sm-2 col-form-label'>제목</label>
<div class='col-sm-10'>
<input class='form-control' id='qnaBoardSubject' type='text' name='qnaBoardSubject'>
</div>
</div>

<div class='form-group row'>
<label for='qnaBoardContent' class='col-sm-2 col-form-label'>내용</label>
<div class='col-sm-10'>
<textarea rows="10" cols="50" class='form-control' id='qnaBoardContent' name='qnaBoardContent' >
</textarea>
</div>
</div>

<div class='form-group row'>
<label for='qnaBoardPwd' class='col-sm-2 col-form-label'>비밀번호</label>
<div class='col-sm-10'>
<input class='form-control' id='qnaBoardPwd' type='password' name='qnaBoardPwd'>
</div>
</div>


<div class='form-group row'>
<label for='qnaBoardPwd' class='col-sm-2 col-form-label'>파일</label>
<div class='col-sm-10'>
<input class='form-control' id='qnaBoardPhoto' type='file' name='qnaBoardPhoto'>
</div>
</div>





<div class='form-group row'>
<div class='col-sm-10'>

<button id="addBtn" type="submit" class='btn btn-primary btn-sm my-new'>추가</button>
<a href="../qna?command=qnaSelectAll"><button id="listBtn" type="button" class='btn btn-primary btn-sm my-new'>목록</button></a>

</div>
</div>
</form>

<footer>
</footer>
</div>


</body>
</html>










