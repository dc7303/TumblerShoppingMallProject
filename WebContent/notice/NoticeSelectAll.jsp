<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

\${pageContext.request.contextPath} = ${pageContext.request.contextPath}

<c:set var="path" value="${pageContext.request.contextPath}" scope="application"/>

<link rel="stylesheet" href="${path}/css/style.css">

<table align="center" border="0" cellpadding="5" cellspacing="2" width="100%" bordercolordark="white" bordercolorlight="black">
<caption>공지사항</caption>
	<colgroup>
		<col width="10%"/>
		<col width="70%"/>
		<col width="16%"/>
	
		
	</colgroup>
	<tr>
        <td bgcolor="#00cc00">
            <p align="center">
            <font color="white"><b><span style="font-size:9pt;">번호</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">제목</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">작성일시</span></b></font></p>
        </td>


    </tr>
    
    <c:choose>
    <c:when test="${empty requestScope.list}">
	   <tr>
        <td colspan="5">
            <p align="center"><b><span style="font-size:9pt;">공지사항이 없습니다.</span></b></p>
        </td>
    </tr>
    </c:when>
    <c:otherwise>
	<c:forEach items="${requestScope.list}" var="noticeDto">
		    <tr onmouseover="this.style.background='#eaeaea'"
		        onmouseout="this.style.background='white'">
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${noticeDto.getNoticeBoardNum()}</span></p>
		        </td>
		        <td bgcolor="">
					<p><span style="font-size:9pt;">
					<a href="frontNotice?command=noticeRead&noticeBoardNum=${noticeDto.getNoticeBoardNum()}">
					  ${noticeDto.getNoticeBoardSubject()}
					</a>
					</span></p>
		        </td>
		        
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		           ${noticeDto.getDate()}</span></p>
		        </td>
		    
		    </tr>
    </c:forEach>
	</c:otherwise>
    </c:choose>
</table>
<hr>
<div align=right>
<span style="font-size:9pt;">&lt;<a href="${path}/notice/NoticeInsert.html">글쓰기</a>&gt;</span></div>














