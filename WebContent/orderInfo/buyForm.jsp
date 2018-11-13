<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<head>
    <title>Product Infomation</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${applicationScope.conPath }/css/basic.css">
  <link rel="stylesheet" href="${applicationScope.conPath }/css/main01.css">
  <link rel="stylesheet" href="${applicationScope.conPath }/css/font-roboto.css">
  <link rel="stylesheet" href="${applicationScope.conPath }/css/font-montserrat.css">
  <link rel="stylesheet" href="${applicationScope.conPath }/css/font-montserrat-02.css">
  <link rel="stylesheet" href="${applicationScope.conPath }/css/buyForm.css">
  <link rel="stylesheet" href="${applicationScope.conPath }/css/common.css"> 
  <script type="text/javascript" src="${applicationScope.conPath }/lib/jquery-3.3.1.min.js"></script>
  
    <script>
    $(function(){
      $('#backBtn').on('click', function(){
        history.back();
      });
      
      $('.backBtn').on('click', function(){
        history.back();
      });
      
      $('.payBtn').on('click', function(){
        if($('input[name=flag]').val() == 'buyNow'){
          $('form[name=orderInputT]').attr('action', '../frontOrder?command=orderInsert');
          $('form[name=orderInputT]').submit();
        }else {
          $('form[name=orderInputT]').attr('action', 'frontOrder?command=orderInsertByBasket');
          $('form[name=orderInputT]').submit();
        }
      });
    });
        </script>
  <style>
  .w3-sidebar a {font-family: "Roboto", sans-serif}
  body,h1,h2,h3,h4,h5,h6,.w3-wide {font-family: "Montserrat", sans-serif;}
  </style>
</head>

<body>
<jsp:include page="../nav.jsp"/>

<div class="main">
  <div class = "buyTop">
    <img src = "${applicationScope.conPath }/img/buyForm/buy_top_text.png"/>
    <hr/><br/>
  </div>
  <div class = "buyProTable">
    <span class= tableName>주문상품 확인</span>
    * 상품수량 및 옵션병경은 상품상세 또는 장바구니에서 가능합니다.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="button" value="이전 페이지" id="backBtn"/>
    <br/><br/>
    <form action = "" method = "post" name = "orderInputT">
       <table class ="orderInfoTable">
         <tr>
           <th>상품/옵션정보</th>
           <th>수량</th>
           <th>상품금액</th>
           <th>할인금액</th>
           <th>배송비</th>
         </tr>
     <c:choose>
        <c:when test="${param.flag == 'buyNow' }">
         <tr>
           <td class="optionInfoT">
             <img src = "${applicationScope.conPath }/img/${param.proPicture }" class="tableInImg"/>
             <strong class = "optionProName">${param.proName }</strong><br/><br/>
             ${param.option }
           </td>
           <td>
             ${param.amount }
           </td>
           <td>
             <fmt:formatNumber>${param.proPrice * param.amount }</fmt:formatNumber>원
           </td>
           <td>0원</td>
           <td>무료배송</td>
         </tr>
       </table>
          <input type = "hidden" name="proNum" value = "${param.proNum }"/>
           <input type = "hidden" name="amount" value = "${param.amount }"/>
           <input type = "hidden" name="option" value = "${param.option }"/>
     </c:when>
     <c:otherwise>
        <c:set var="i" value="0"></c:set>
     	<c:forEach items="${list}" var="item">
     	<tr>
           <td class="optionInfoT">
             <img src = "${applicationScope.conPath }/img/${item.productDto.productPicture}" class="tableInImg"/>
             <strong class = "optionProName">${item.productDto.productName}</strong><br/><br/>
             ${item.basketOption}
           </td>
           <td>
             ${item.getBasketQuantity()}
           </td>
           <td>
           		
             <fmt:formatNumber>${item.basketPrice}</fmt:formatNumber>원
           </td>
           <td>0원</td>
           <td>무료배송</td>
         </tr>           			
     		<c:set var ="i" value = "${i + item.basketPrice }"/>
     	</c:forEach>
     
     </c:otherwise>
    </c:choose>
    <br/><br/><br/>
    <span class="tableName">배송지 정보 입력</span>
    <c:set value="${sessionScope.userDTO }" var="userDTO"/>
      <table class="basongInfoTable">
        <tr>
          <th>받으시는 분</th>
          <td><input type = "text" name = "userName" value = "${userDTO.getUserName() }"/></td>
        </tr>
        <tr>
          <th>주소</th>
          <td><input type = "text" name = "basongAddr" value = "${userDTO.getUserAddr() }" size = "50px"/></td>
        </tr>
        <tr>
          <th>휴대전화</th>
          <td><input type = "text" name = "basongPhone"value = "${userDTO.getUserPhone() }"/></td>
        </tr>
        <tr>
          <th>택배회사</th>
          <td><input type = "text" name = "company"value = "경동택배"/></td>
        </tr>
        <tr>
        <tr>
          <th>배송시요구사항</th>
          <td>
            <input type = "text" name = "comment" size = "50px"/><br/>
            <sapn class = "commentBottom">* 특정한 배송일을 지정하고자 할 경우 판매자와 연락하여 배송일을 확인해주시기 바랍니다.</sapn>
          </td>
        </tr>
      </table>
      <table class="totalPriceT">
        <tr>
         <th>총 합계</th>
         <td><span class = "totalPrice">
         <fmt:formatNumber>
           <c:choose>
        	<c:when test="${param.flag == 'buyNow' }">
           ${param.proPrice * param.amount }
           </c:when>
				<c:otherwise>
           			${i}
           		</c:otherwise>
           </c:choose>
         </fmt:formatNumber>&nbsp;&nbsp;</span> 원</td>
        </tr>
      </table><br/>
      <!-- 단일주문인지, 장바구니 주문인지 파악하기 위한 flag 설정 -->
      <input type = "hidden" name = "flag" value ="${param.flag }"/>
      <a href = "#"><img src = "${applicationScope.conPath }/img/buyForm/btn_backpage.png" class="backBtn"/></a>
      <a href = "#"><img src = "${applicationScope.conPath }/img/buyForm/btn_payment.png" class="payBtn"/></a>
    </form>
  </div>
</div>



<jsp:include page="../footer.jsp"/>
</body>
</html>