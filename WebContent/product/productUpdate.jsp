<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
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
<div class='container'>
  <center>
<h3>QnA 수정</h3>
</center>

<div class="table-container ">

<form class="ui form"  name=updateForm method="post" action="frontProduct" onSubmit="return checkValid()" enctype="multipart/form-data">
  <input type="hidden" name="command" value="productUpdate">
<input type='hidden' name='pno' value="${dto.qnaBoardQno}">
  
  <div class="field">
    <label>제품명</label>
    <input type="text" id='pname' name='pname'>
  </div>
  
  <div class="field">
    <label>정보</label>
    <input type="text" id='info' name='info'>
  </div>
  
  
  <div class="field">
    <label>가격</label>
    <input type="text" id='price' name='price'>
  </div>
  
  
  <div class="field">
    <label>카테고리</label>
    <input type="text" id='category' name='category'>
  </div>
  
  
  <div class="field">
    <label>파일</label>
    <input type="file" id='file' name='file'>
  </div>
  
  <div class="field">
    <label>브랜드</label>
    <input type="text" id='brand' name='brand'>
  </div>
  
  <div class="field">
    <label>재고</label>
    <input type="text" id='stock'  name='stock'>
  </div>
  
<a href="frontProduct?command=productSelectAll"><input type=button value="목록으로" class='ui black basic button floatRight'></a>
<input type="submit" value="수정하기" class='ui black basic button floatRight'>
</form>
</div>

<jsp:include page="../footer.jsp"/>

</div>
</BODY>
</html>













