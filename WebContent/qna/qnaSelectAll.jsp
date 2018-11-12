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
<link rel='stylesheet' href='${conPath}/css/common.css'>
<link rel='stylesheet' href='${conPath}/css/basic.css'>
<link rel="stylesheet" type="text/css" href="${conPath}/lib/SemanticUI/semantic.min.css">
<style>
  .table-container {
  	width :600px;
  	margin-left: 250px;
	margin-top : 135px;
	margin-bottom: 200px;
  }	
  
  .table-container a{
  		float:right;
  }
  .trTable td{
  	text-align:center;
  }
</style>
</head>
<body>

<jsp:include page="../nav.jsp"></jsp:include>

<div class='container'>
 <center>
  <h3>QnA게시판</h3>
</center>


<div class='table-container'>
<table class="ui celled padded table">
  <thead >
    <tr><th class="single line">번호</th><th>제목</th><th>등록일</th><th>작성자</th>
  </tr>
  </thead>
  <tbody>

	<c:forEach items="${requestScope.list}" var="item">
		    <tr class="trTable">
		            <td>${item.qnaBoardQno}</td> 
					<td><a href="frontQna?command=qnaRead&qnaBoardQno=${item.qnaBoardQno}">
					  ${item.qnaBoardSubject}</a></td>
                     <td> ${item.qnaBoardDate}</td>
                     <td>${item.qnaBoardUserId}</td>
		    </tr>
    </c:forEach>
  </tbody>
  <tfoot>
  
    <tr>
    <th colspan="4">
            <div class="ui right floated pagination menu">
        <a class="icon item" id="prevBtn">
          <i class="left chevron icon"></i>
        </a>
        
        <a  id="currBtn"  class="item">1</a>
        
        <a class="icon item" id="nextBtn">
          <i class="right chevron icon"></i>
        </a>
	</div>
    </th>
  </tr>
  </tfoot>
</table>
    <a href='qna/qnaInsert.jsp' ><button class="ui black basic button">Write</button></a>

</div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>

<script type="text/javascript">
var currPageNo = 1;
var pageNo = parseInt(${pageNo});
var lastPageNo = parseInt(${lastPageNo});

// 이전버튼을 누르면 -1 처리한다
$('#prevBtn').click(function(){
    location.href="frontQna?command=noticeSelectAll&pageNo="+(currPageNo - 1);
});

// 다음버튼을 누르면 +1 처리한다
$('#nextBtn').click(function() {
	location.href="frontQna?command=noticeSelectAll&pageNo="+(currPageNo + 1);
});

//document.ready시 page가 1이면 이전버튼 disabled

$(function(){
	if (pageNo == 1) {
	    $("#prevBtn").parent().addClass("disabled");
	} else {
		$("#prevBtn").parent().removeClass("disabled");
	}
	
	//자바에서 값이 없다면 다음버튼 disable
	if (lastPageNo == pageNo) {
	    $("#nextBtn").parent().addClass("disabled");
	} else {
	    $("#nextBtn").parent().removeClass("disabled");
	}

});

//페이지를 자바에서 계산해서 프론트에 저장
currPageNo = ${pageNo};
//페이지를 자바에서 계산해서 버튼에 추가
$('#currBtn').html(currPageNo);

</script>



</body>
</html>





