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

<script>
$(function(){
	$('#totalBuy').on('click', function(){
		location.href="frontBasket?command=basketByUserId&flag=pay"
        /* $('form[name=basket]').attr('action', 'orderInfo/buyForm.jsp');
        $('form[name=basket]').submit(); */
	});	
});
</script>
</head>
<body>
<jsp:include page="../nav.jsp"/>
<form name="basket" method='post' action="">
<div class="tableDiv">
   <table class="tableForm">
	       <tr>
	        <th>상품</th>           
	        <th>수량</th>
	        <th>금액</th>
	        <th>배송</th>
	        <th>주문</th>
	    	</tr>
       	<c:forEach items="${requestScope.list}" var="basketdto">
       	<input type = "hidden" name="proNum" value = "${basketdto.productDto.productNum}"/>
       	<input type = "hidden" name="proName" value = "${basketdto.productDto.productName}"/>
       	<input type = "hidden" name="proPhoto" value = "${basketdto.productDto.productPicture}"/>
       	<input type = "hidden" name="proPrice" value = "${param.productPrice }"/>
 		<input type = "hidden" name="amount" value = "${basketdto.getBasketQuantity()}"/>
       	<input type = "hidden" name="option" value = "${basketdto.basketOption}"/>
       <tr>
       	<td>
           <div class="productDiv">
                <div class="imgDiv">
                    <img src="${conPath}/img/${basketdto.productDto.productPicture}">
                </div>
                <div class="nameDiv" style="padding:15px;">
                    <span>${basketdto.productDto.productName}</span>
                    <hr>
                    <span>${basketdto.basketOption}</span>
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
            배송비 무료
        </td>
        <td class="orderDiv">
           <div>
              <button type="submit" id="buyBtn" class="buybutton">구매</button>
				<br>
	           <button type="button" id="deleteBtn"  class="deletebutton">삭제</button>
            </div>
        </td>
       </tr>
 	</c:forEach>
  	 </table>
  	 <div class="total">
  	 </div>
  	 			<a href = "#"><img src = "${applicationScope.conPath }/img/buyForm/btn_payment.png" class="payBtn" id="payBtn"/></a>
  	   	 	  <button type="submit" class="totalBuy" id="totalBuy" >모두 구매</button>
    </div>
    </form>
    
    <jsp:include page="../footer.jsp"/>
    
</body>
</html>
