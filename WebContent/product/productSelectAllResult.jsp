<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>product selectAll 요청 결과 page입니다.</h1>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="path" value="${pageContext.request.contextPath}" scope="application"/>


<table align="center" border="0" cellpadding="5" cellspacing="2" width="100%" bordercolordark="white" bordercolorlight="black">
<caption>상품 LIST</caption>
	<colgroup>
		<col width="7%"/>
		<col width="20%"/>
		<col width="13%"/>
		<col width="10%"/>
		<col width="10%"/>
		<col width="10%"/>
		<col width="10%"/>
		<col width="5%"/>
		<col width="30%"/>
	</colgroup>
	<tr>
        <td bgcolor="#00cc00">
            <p align="center">
            <font color="white"><b><span style="font-size:12pt;">상품번호</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:12pt;">상품이름</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:12pt;">상품정보</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:12pt;">상품가격</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:12pt;">카테고리</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:12pt;">사진</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:12pt;">브랜드</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:12pt;">재고량</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:12pt;">등록일</span></b></font></p>
        </td>
    </tr>
    
    <c:choose>
    <c:when test="${empty requestScope.list}">
	   <tr>
        <td colspan="5">
            <p align="center"><b><span style="font-size:9pt;">등록된 상품이 없습니다.</span></b></p>
        </td>
    </tr>
    </c:when>
    <c:otherwise>
	<c:forEach items="${requestScope.list}" var="productDTO">
		    <tr onmouseover="this.style.background='#eaeaea'"
		        onmouseout="this.style.background='white'">
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${productDTO.pno}</span></p>
		        </td>
		        <td bgcolor="">
					<p><span style="font-size:9pt;">
					<a href="product?command=productDetail&pno=${productDTO.pno}">
					  ${productDTO.pname}
					</a>
					</span></p>
		        </td>
		        
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${productDTO.info}</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            <fmt:formatNumber value="${productDTO.price}"/></span></p>
		        </td>
		        
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${productDTO.category}</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${productDTO.photo}</span></p>
		        </td>
		        
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${productDTO.brand}</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${productDTO.stock}</span></p>
		        </td>
		        
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${productDTO.regdt}</span></p>
		    </tr>
    </c:forEach>
	</c:otherwise>
    </c:choose>
</table>
<hr>
<div align=right>
<!-- 검색 -->
<form name="search" action="../ShoppingMallMVCExam/product?command=productSelectBy" method="post" align="center">

 <select name="keyType">
   <option value="0">--선택--</option>
   <option value="pno">상품번호</option>
   <option value="pname">상품이름</option>
   <option value="category">카테고리</option>
   <option value="brand">브랜드</option>
 </select>
 
<input type="text" name="keyWord"/>
<input type="submit" value="검색" />  

</form>
<span style="font-size:9pt;" align="right"><a href="${path}/product/productInsertForm.html">상품등록하기</a></span></div>



</body>
</html>