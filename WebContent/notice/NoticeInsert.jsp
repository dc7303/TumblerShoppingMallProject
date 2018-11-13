<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 게시판</title>
<script src="${conPath}/lib/jquery-3.3.1.min.js"></script>
<script src="${conPath}/lib/SemanticUI/semantic.min.js"></script>
<link rel="stylesheet" type="text/css" href="${conPath}/lib/SemanticUI/semantic.min.css">
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
<h3>공 지 등 록</h3>
</center>

<div class="table-container ">
<form class="ui form" name="writeForm" method="post" action="../frontNotice?command=noticeInsert"  onSubmit='return checkValid()'>
  <div class="field">
    <label>title</label>
    <input type="text" name="title" placeholder="title">
  </div>
  
  <div class="field">
    <label>Text</label>
    <textarea rows="10" cols="50" name="content"></textarea>
  </div>

  
  <button type="submit" class="ui black basic button floatRight">Write</button>
</form>
</div>

<jsp:include page="../footer.jsp"/>


</body>
</html>






















