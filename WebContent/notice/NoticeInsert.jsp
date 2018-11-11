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
    return true;
}
</SCRIPT>

</head>
<body>



<div class='container'>

  <center>
<h3>공 지 등 록</h3>
</center>


<form name="writeForm" method="post" action="../frontNotice?command=noticeInsert"  onSubmit='return checkValid()'>

<div class='form-group row'>
<label for='noticeTitle' class='col-sm-2 col-form-label'>공지제목</label>
<div class='col-sm-10'>
<input class='form-control' id='noticeTitle' type='text' name='title'>
</div>
</div>

<div class='form-group row'>
<label for='noticeDescription' class='col-sm-2 col-form-label'>공지내용</label>
<div class='col-sm-10'>
<textarea rows="10" cols="50" class='form-control' id='noticeDescription' name='content' >
</textarea>
</div>
</div>

<div class='form-group row'>
<div class='col-sm-10'>
<button id="addBtn" type="submit" class='btn btn-primary btn-sm my-new'>추가</button>
</div>
</div>
</form>

<footer>
</footer>
</div>


</body>
</html>






















