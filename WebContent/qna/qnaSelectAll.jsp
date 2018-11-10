<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

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
</head>
<body>

<jsp:include page="../nav.jsp"></jsp:include>

<div class='container'>
 <center>
  <h3>공   지</h3>
</center>


<nav class="navbar navbar-light justify-content-between">
  <a href='qna/qnaInsert.jsp' class='btn btn-primary btn-sm'>추가</a>
  <form class="form-inline">
    <input id="words" name="words"
           class="form-control form-control-sm mr-sm-2" type="search"
           placeholder="검색" aria-label="Search">
    <button id="searchBtn" class="btn btn-sm btn-outline-success my-2 my-sm-0"
            type="button">Search</button>
  </form>
</nav>

<table id="list" class='table table-hover'>
<thead>
<tr>
    <th>번호</th><th>제목</th><th>등록일</th><th>작성자</th>
</tr>
</thead>

<tbody>
	<c:forEach items="${requestScope.list}" var="item">
		    <tr>
		            <td>${item.qnaBoardQno}</td> 
					<td><a href="frontQna?command=qnaRead&qnaBoardQno=${item.qnaBoardQno}">
					  ${item.qnaBoardSubject}</a></td>
                     <td> ${item.qnaBoardDate}</td>
                     <td>${item.qnaBoardUserId}</td>
		    </tr>
    </c:forEach>
</tbody>
</table>

<nav aria-label="Page navigation">
  <ul class="pagination justify-content-center">
    <li class="page-item">
        <a id="prevBtn" class="page-link" tabindex="-1">이전</a></li>
        
    <li class="page-item">
        <a id="currBtn" class="page-link" href="#">1</a></li>
    
    <li class="page-item ">
        <a id="nextBtn" class="page-link" tabindex="0">다음</a></li>
  </ul>
</nav>
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





