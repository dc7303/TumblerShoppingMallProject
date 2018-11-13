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
<h3>상 품 등 록</h3>
</center>

<div class="table-container ">
<form class="ui form"  name="writeForm" method="post" action="../frontProduct?command=productproductInsert"  onSubmit='return checkValid()' enctype="multipart/form-data">
  <div class="field">
  
  <div class="field">
    <label>제품명 </label>
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
  
  
  
  
  <button type="submit" class="ui black basic button floatRight">상품등록</button>
</form>
</div>

<jsp:include page="../footer.jsp"/>


</body>
</html>










