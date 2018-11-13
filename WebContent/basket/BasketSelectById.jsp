<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="${applicationScope.conPath }/css/basket.css">
<script src="${conPath}/lib/jquery-3.3.1.min.js"></script>
  <link rel="stylesheet" type="text/css" href="css/basic.css">
  <link rel="stylesheet" href="css/main01.css">
  <link rel="stylesheet" href="css/font-roboto.css">
  <link rel="stylesheet" href="css/font-montserrat.css">
  <link rel="stylesheet" href="css/font-montserrat-02.css">
  <link rel="stylesheet" href="${applicationScope.conPath }/css/common.css">

<script>
$(function(){
	$('#totalBuy').on('click', function(){
		location.href="frontBasket?command=basketByUserID&flag=pay"
        /* $('form[name=basket]').attr('action', 'orderInfo/buyForm.jsp');
        $('form[name=basket]').submit(); */
	});	
});
</script>

<style>
  
  
  .tableDiv {
    padding-top:150px;
    padding-bottom:200px;
    padding-left:50px;
    padding-right:50px;
  }
  
  .proName {
    font-size:15px;
    font-weight:bold;
  }
  
  .proOption {
    font-size:12px;
    color:grey;
  }
  
  
  .totalPriceT {
    margin-top:15px;
    border:3px solid #333;
    width:100%;
    height:90px;
  }
  
  .nameDiv>hr{
    margin-top:10px;
    margin-bottom:10px;
  }
  
  .totalPriceT th {
    background-color:#333;
    color:lightgrey;
    font-size:20px;
    width:200px;
    text-align:left;
    padding-left:15px;
  }
  
  .totalPriceT td {
    background-color:#FAFAFA;
    text-align:right;
    padding-right:30px;
  }
  
  .totalPrice {
    color:blue;
    font-size:30px;
    font-weight:bolder;
  }
  
  .totalBuy {
    float:right;
    padding-top:1px;
  }
</style>
</head>
<body>
<jsp:include page="../nav.jsp"/>
<form name="basket" method='post' action="">
<div class="tableDiv">
   <table class="tableForm">
	       <tr>
	        <th>상품정보</th>           
	        <th>상품수량</th>
	        <th>금액</th>
	        <th>배송비</th>
	        <th>삭제</th>
	    	</tr>
	    <c:set var = "i" value = "0"/>
       	<c:forEach items="${requestScope.list}" var="basketdto">
       	<input type = "hidden" name="proNum" value = "${basketdto.productDto.productNum}"/>
       	<input type = "hidden" name="proName" value = "${basketdto.productDto.productName}"/>
       	<input type = "hidden" name="proPhoto" value = "${basketdto.productDto.productPicture}"/>
       	<input type = "hidden" name="basketPrice" value = "${basketdto.getBasketPrice()}"/>
 		<input type = "hidden" name="amount" value = "${basketdto.getBasketQuantity()}"/>
       	<input type = "hidden" name="option" value = "${basketdto.basketOption}"/>
       <tr>
       	<td>
           <div class="productDiv">
                <div class="imgDiv">
                    <img src="${conPath}/img/${basketdto.productDto.productPicture}">
                </div>
                <div class="nameDiv" style="padding:15px;">
                    <span class="proName">${basketdto.productDto.productName}</span>
                    <hr/>
                    <span class="proOption">${basketdto.basketOption}</span>
                </div>
            </div>          
        </td>   
        <td class="countDiv">
           <div>
            <input class="countInput" type="text" value="${basketdto.getBasketQuantity()}">
            <p/>
            <button type="button" class="">수정</button>
            </div>
        </td>               
        <td class="priceDiv">
 			${basketdto.getBasketPrice()}
         </td>
        <td class="deliveryDiv">
            무료
        </td>
        <td class="orderDiv">
           <div>
	           <button type="button" id="deleteBtn"  class="deletebutton">삭제</button>
            </div>
        </td>
       </tr>
       
    
       <c:set var = "i" value ="${i + basketdto.getBasketPrice()  }"/>
 	</c:forEach>
  	 </table>
  	 <table class="totalPriceT">
        <tr>
         <th>총 합계</th>
         <td><span class = "totalPrice">
         <fmt:formatNumber>
            ${i }
         </fmt:formatNumber>&nbsp;&nbsp;</span> 원</td>
        </tr>
      </table><br/>

  	 	<a href = "#"><img src = "${applicationScope.conPath }/img/buyForm/btn_payment.png" class="totalBuy" id="totalBuy"/></a>
    </div>
    </form>
    
    <jsp:include page="../footer.jsp"/>
    
</body>
</html>
