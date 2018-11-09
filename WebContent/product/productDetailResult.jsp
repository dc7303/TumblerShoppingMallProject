<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script language=javascript>
function sendUpdate(){//수정폼
	document.requestForm.command.value ="productUpdateForm";
	document.requestForm.submit();
}

function sendDelete(){//관리자일시 삭제
	
	document.requestForm.command.value ="productDelete";
	document.requestForm.submit();
}
</script>
</head>
<body>
<h1>productSelectByProductNum요청 결과 page입니다.</h1>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}" scope="application"/>


<table align="center" cellpadding="5" cellspacing="2" width="600" border='1'>
    <tr>
        <td width="1220" height="20" colspan="4" bgcolor="#00cc00">
            <p align="center"><font color="white" size="3"><b>
             상품 자세히보기</b></font></p>
        </td>
    </tr>
    <tr>
        <td width="100" height="20" >
            <p align="right"><b><span style="font-size:9pt;">상품번호</span></b></p>
        </td>
        <td width="450" height="20" colspan="3">
        	<span style="font-size:9pt;"><b>${dto.pno}</b></span>
        </td>
    </tr>
    <tr>
        <td width="100" height="20" >
            <p align="right"><b><span style="font-size:9pt;">등록일</span></b></p>
        </td>
        <td width="300" height="20">
        	<span style="font-size:9pt;"><b>${requestScope.dto.regdt}</b></span>
        </td>
        <td width="100" height="20" >
			<p align="right"><b><span style="font-size:9pt;">재고수량</span></b></p>
		</td>
        <td width="300" height="20">
			<p><span style="font-size:9pt;"></span>${requestScope.dto.stock}</p>
		</td>
    </tr>
    <tr>
        <td width="100" height="20">
            <p align="right"><b><span style="font-size:9pt;">상품이름</span></b></p>
        </td>
        <td width="450" height="20">
        	<span style="font-size:9pt;"><b>${requestScope.dto.pname}</b></span>
        </td>
        <td width="100" height="20">
        	<p align="right"><b><span style="font-size:9pt;">가격</span></b></p>
        </td>
        <td width="450" height="20" >
        	<span style="font-size:9pt;"><b>${requestScope.dto.price}</b></span>
        </td>
        
        
       
    </tr>
    
    <tr>
		<td width="100" height="200" valign="top">
            <p align="right"><b><span style="font-size:9pt;">사진</span></b></p>
        </td>
        <td width="450" height="200" valign="top" colspan="3">
        	<img src="${pageContext.request.contextPath}/product/save/${requestScope.dto.photo}" alt="이미지" />
        </td>	
    </tr>
    
    <tr>
		<td width="100" height="200" valign="top">
            <p align="right"><b><span style="font-size:9pt;">설명</span></b></p>
        </td>
		<!-- 브라우저에 글 내용을 뿌려줄 때는 개행문자(\n)가 <br>태그로 변환된 문자열을 보여줘야 한다. -->
        <td width="450" height="200" valign="top" colspan="3">
        <span style="font-size:9pt;"><b><pre>${requestScope.dto.info}</pre></b></span></td>
    </tr>
    
     
    
    <tr>       
    <form name="requestForm" method=post action="../ShoppingMallMVCExam/product">

        <td height="20" colspan="4" align="center" valign="middle">
			<!-- 수정시 필요한 데이터들을 hidden으로 숨겨놓고 폼 데이터로 보내준다. -->
				<input type=hidden name="pno" value="${dto.pno}">
				<input type=hidden name="command" value=""> <!-- 수정,삭제는 각각 command가 다르기때문 -->
				<input type=button value="수정하기" onClick="sendUpdate()">
				<input type=button value="삭제하기" onClick="sendDelete()">
    </form>
			
		</td>
    </tr>
</table>
<hr>
<div align=right><span style="font-size:9pt;"><a href="../ShoppingMallMVCExam/product?command=productSelectAll">리스트로 돌아가기</a></span></div>


</body>
</html>