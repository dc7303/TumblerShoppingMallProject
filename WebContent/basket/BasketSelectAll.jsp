<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

\${pageContext.request.contextPath} = ${pageContext.request.contextPath}

<c:set var="path" value="${pageContext.request.contextPath}" scope="application"/>


<table>
<caption>공지사항</caption>

	<tr>
        <td bgcolor="#00cc00">
            <p align="center">
            <font color="white"><b><span >장바구니번호</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span >상품번호</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span >유저아이디</span></b></font></p>
        </td>
         <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span >옵션</span></b></font></p>
        </td>
         <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span >수량</span></b></font></p>
        </td>
         <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span >총가격</span></b></font></p>
        </td>
        
        


    </tr>
    
    <c:choose>
    <c:when test="${empty requestScope.list}">
	   <tr>
        <td colspan="5">
            <p align="center"><b><span>내용 없습니다.</span></b></p>
        </td>
    </tr>
    </c:when>
    <c:otherwise>
	<c:forEach items="${requestScope.list}" var="basketdto">
		  		<tr>
		        <td bgcolor="">
		            <p align="center"><span>
		            ${basketdto.getBasketNum()}</span></p>
		        </td>
		        <td bgcolor="">
					<p><span>
		
					  ${basketdto.getProductNum()}
					
					</span></p>
		        </td>
		        
		        <td bgcolor="">
		            <p align="center"><span >
		           ${basketdto.getUserId()}</span></p>
		        </td>
		         
		        <td bgcolor="">
		            <p align="center"><span>
		           ${basketdto.getBasketOption()}</span></p>
		        </td>
		         
		        <td bgcolor="">
		            <p align="center"><span>
		           ${basketdto.getBasketQuantity()}</span></p>
		        </td>
		         
		        <td bgcolor="">
		            <p align="center"><span>
		           ${basketdto.getBasketPrice()}</span></p>
		        </td>
		    
		    </tr>
    </c:forEach>
	</c:otherwise>
    </c:choose>
</table>
<hr>
<div align=right>
<span style="font-size:9pt;">&lt;<a href="frontBasket?command=basketInsert">삽입</a>&gt;</span></div>

<div align=right>
<span style="font-size:9pt;">&lt;<a href="frontBasket?command=basketUpdate">수정</a>&gt;</span></div>


