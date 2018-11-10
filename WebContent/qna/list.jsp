<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(document).on("click","input[type=button]",function(){
		//console.log($(this).parent().parent().find('td:eq(4)').text());
		var no = $(this).parent().parent().find('td:eq(5)').text()
		//console.log("qna?command=qnaDelete&qnaBoardUserId="+no);
		location.href="qna?command=qnaDelete&qnaBoardUserId="+no;
	});

</script>
<body>
\${pageContext.request.contextPath} = ${pageContext.request.contextPath}

<c:set var="path" value="${pageContext.request.contextPath}" scope="application"/>


<table align="center" border="0" cellpadding="5" cellspacing="2" width="100%" bordercolordark="white" bordercolorlight="black">
<caption>상품 LIST</caption>
	<colgroup>
		<col width="15%"/>
		<col width="25%"/>
		<col width="16%"/>
		<col width="16%"/>
		<col width="7%"/>
		<col width="7%"/>
		<col width="7%"/>
	</colgroup>
	<tr>
	<td bgcolor="#00cc00">
            <p align="center">
            <font color="white"><b><span style="font-size:9pt;">게시판번호</span></b></font></p>
            
        <td bgcolor="#00cc00">
            <p align="center">
            <font color="white"><b><span style="font-size:9pt;">제목</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">내용</span></b></font></p>
        </td>
        
         </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">등록날짜</span></b></font></p>
        </td>
        
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">비밀번호</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">유저아이디</span></b></font></p>
        </td>
         
    
        </td>
    </tr>
    
    <c:choose>
    <c:when test="${empty requestScope.list}">  <!-- select에서 나온 내용들을 list에 추가 -->
	
    </c:when>
    <c:otherwise>
	<c:forEach items="${requestScope.list}" var="item">
		    <tr onmouseover="this.style.background='#eaeaea'"
		        onmouseout="this.style.background='white'">
		        
		          <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${item.qnaBoardQno}</span></p>
		        </td>
		   
		        
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            <a href="qna?command=qnaRead&qnaBoardQno=${item.qnaBoardQno}">
		            ${item.qnaBoardSubject}</span></p>
		        </td>
		   
		        
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${item.qnaBoardContent}"</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${item.qnaBoardDate}</span></p>
		        </td>
		         
		         <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${item.qnaBoardPwd}</span></p>
		        </td>
		         <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">${item.qnaBoardUserId}</span></p>
		        </td>
		        <td colspan="5" align="center"> 
			<input type="button" value="삭제하기"  id="btn">
	     	</td>
		    
		     
		    </tr>
    </c:forEach>
	</c:otherwise>
    </c:choose>
</table>
<hr>
<div align=right>
<span style="font-size:9pt;">&lt;<a href="${path}/qna/write.html">글쓰기</a>&gt;</span></div>

<!-- 검색 -->
<form name="search" action="qna?command=qnaSelectBy" method="post" align="center">

 <select name="keyType">
   <option value="0">--선택--</option>
   <option value="qnaBoardQno">게시판번호</option>
   <option value="qnaBoardSubject">제목</option>
   <option value="qnaBoardContent">내용</option>
   
 </select>
 
<input type="text" name="keyWord"/>
<input type="submit" value="검색" />  

</form>

</body>
</html>







