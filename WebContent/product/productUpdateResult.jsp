<%@ page info="상품 수정하기" contentType="text/html;charset=UTF-8" %>

<HTML>
<HEAD>
<link rel="stylesheet" href="css/style.css">

<SCRIPT >
function checkValid() {
	var f = window.document.updateForm;
	if ( f.pname.value == "" ) {
		alert( "상품이름을 입력해 주세요." );
		f.pname.focus();
		return false;
	}
	if ( f.price.value == "" ) {
		alert( "가격을 입력해 주세요." );
		f.price.focus();
		return false;
	}
	if ( f.info.value == "" ) {
        alert( "상품 설명을 입력해 주세요." );
        f.info.focus();
        return false;
    }
}

</SCRIPT>

</HEAD>

<BODY>


<form name=updateForm method=post action="../ShoppingMallMVCExam/product?command=productUpdate" onSubmit="return checkValid()" method="post" enctype="multipart/form-data">
    <input type="hidden" name="command" value="productUpdate" >
    <input type='hidden' name='pno' value="${dto.pno}">
	<table align="center" cellpadding="5" cellspacing="1" width="600" border="1">
    <tr>
        <td width="1220" height="20" colspan="2" bgcolor="#00cc00">
            <p align="center"><font color="white" size="3"><b>  상품 수정하기</b></font></p>
        </td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">상품이름</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="pname" size="30" value="${dto.pname}"></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">가격</span></b></p>
        </td>
        <td width="450" height="20" ><b><span style="font-size:9pt;">
		<input type=text name="price" size="30" value="${dto.price}"></span></b></td>
    </tr>
    <tr>
    <td width="100" height="20" >
			<p align="right"><b><span style="font-size:9pt;">재고수량</span></b></p>
		</td>
        <td width="100" height="20"><b><span style="font-size:9pt;">
        <input type=text name="stock" size="30" value="${dto.stock}"></span></b></td>
    </tr>
    <tr>
    <td width="100" height="20" >
			<p align="right"><b><span style="font-size:9pt;">카테고리</span></b></p>
		</td>
        <td width="100" height="20"><b><span style="font-size:9pt;">
        <input type=text name="category" size="30" value="${dto.category}"></span></b></td>
    </tr>
    <tr>
    <td width="100" height="20" >
			<p align="right"><b><span style="font-size:9pt;">브랜드</span></b></p>
		</td>
        <td width="100" height="20"><b><span style="font-size:9pt;">
        <input type=text name="brand" size="30" value="${dto.brand}"></span></b></td>
    </tr>
    
    
    <tr rowspan=2>
    	<td width="100" height="20">
            <p align="right"><b><span style="font-size:9pt;">상품사진</span></b></p>
        </td>
        <td width="450" height="20" colspan="2">
        	<img src="${pageContext.request.contextPath}/product/save/${requestScope.dto.photo}" alt="이미지" />
        	<b><span style="font-size:9pt;">
        		 <input type="file" name="file" maxlength="60" size="40">
        	</b>
        </td>
    </tr>
    
    <tr>
        <td width="150" height="20" >
            <p align="right"><b><span style="font-size:9pt;">내 용</span></b></p>
        </td>
        <td width="450" height="20" ><b><span style="font-size:9pt;">
		<textarea name="info" cols="50" rows="10">${dto.info}</textarea></span></b></td>
    </tr>
    <tr>
        <td width="450" height="20" colspan="2" align="center"><b><span style="font-size:9pt;">
		<input type="submit" value="수정하기"> <input type="reset" value="다시쓰기"></span></b></td>
    </tr>
</table>
</form>
<hr>
<div align=right><span style="font-size:9pt;"><a href="../ShoppingMallMVCExam/product?command=productSelectAll">리스트로 돌아가기</a></span></div>
</BODY>
</HTML>







