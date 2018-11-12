<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <script>
    $(function(){
      $(document).on("click", 'input[value=배송조회]', function(){
        var formTarget = "basongSearch";
        var basongForm = $(this).parent();//배송조회 폼이름
        window.open('', formTarget, 'width=550, height=500, resizable=no');
        basongForm.submit();
      });
      
      $(document).on("click", ".orderInfo", function(){
        var formTarget = "orderInfo";
        var orderForm = $(this).parent();
        window.open('', formTarget, 'width=550, height=500, resizable=no');
        orderForm.submit();
      });
    });
       
  </script>

  <style>
  
  .orderListT {
    border-top:2px solid #333;
    border-bottom:1px solid #333;
  }
  
  th {
    background-color:#333;
    color:lightgrey;
  }
  
  td {
    text-align:center;
    height:60px;
  }
  
  .failList {
    height:300px;
    text-align:center;
  }
  
  .px11{
    font-size:11px;
  }
  </style>
<title>Insert title here</title>
</head>
<body>
<h3>총 결제내역</h3>
<p style="color:grey">고객님께서 주문하신 총 결제 내역입니다.<br/>
주문 정보를 자세히 보시려면 '주문상품정보'에서 상품명을 클릭해주세요.<br/><br/></p>
  <div>
	<table class = "orderListT">
	  <tr>
	   <th width ="120px">주문일자</th>
	   <th width ="300px">주문상품정보</th>
	   <th width ="120px">상품 금액(수량)</th>
	   <th width ="100px">배송비</th>
	   <th width ="100px">배송상태</th>
	  </tr>
	    <!-- 
	    논리 연산자 주문이력이 있을 때 또는 배송상태가 배송완료가 아닐 때.  
	    조건에 만족하지 않을 시 구매내역이 존재하지 않는다고 표시해준다.
	    -->
	    <!-- 결과 테이블 논리연산자에 따라 입력 시작 -->
		<c:choose>
		<c:when test = "${not empty requestScope.orderList  }">
			<c:forEach items="${requestScope.orderList }" var ="orderList">
		        <tr>
		            <td>${orderList.getOrderDate() }</td>
                    <td>
                        <c:set value = "${orderList.getDetailDTO() }" var = "deatilInfo"/>
                        <form name = "orderForm" action ="orderInfo/orderInfo.jsp" method = "post" target ="orderInfo">
                          <a href = "#" class="orderInfo"><strong>${orderList.getProDTO().getProductName() }</strong></a><br/>
                          <input type = "hidden" name = "orderNum" value = "${orderList.getOrderNum() }"/>
                          <input type = "hidden" name = "picture" value = "${orderList.getProDTO().getProductPicture() }"/>
                          <input type = "hidden" name = "proName" value ="${orderList.getProDTO().getProductName() }"/>
                          <input type = "hidden" name = "detailPrice" value = "${deatilInfo.getOrderDetailPrice() }"/>
                          <input type = "hidden" name = "detailQuantity" value = "${deatilInfo.getOrderDetailQuantity() }"/>
                          <input type = "hidden" name = "detailOption" value = "${deatilInfo.getOrderDetailOption() }"/>
                          <input type = "hidden" name = "detailDate" value = "${deatilInfo.getOrderDetailDate() }"/>
                        </form>
                        <p class = "px11">옵션:${orderList.getDetailDTO().getOrderDetailOption() }</p>
                    </td>
		            <td>
                        <strong><fmt:formatNumber> ${orderList.getOrderPrice() }</fmt:formatNumber>원</strong><br/>
                        <p class = "px11">(구매수량:${orderList.getDetailDTO().getOrderDetailQuantity() })</p>
		            </td>
		            <td>무료</td>
                    <td>
                      <c:set value="${orderList.getBasongDTO().getBasongStatus() }" var ="basongStatus"/>
                      <c:choose>
                        <c:when test="${basongStatus eq 0 }">
                          <strong>배송준비</strong>
                        </c:when>
                        <c:when test="${basongStatus eq 1 }">
                          <strong>배송시작</strong><br/>
                          <p class = "px11">송장번호:</p>
                          ${orderList.getBasongDTO().getBasongInvoiceNum()}
                        </c:when>
                        <c:when test="${basongStatus eq 2 }">
                          <strong>배송중</strong><br/>
                          <p class = "px11">송장번호:<br/>
                          ${orderList.getBasongDTO().getBasongInvoiceNum()}</p>
                        </c:when>
                        <c:when test="${basongStatus eq 3 }">
                          <strong>배송완료</strong><br/>
                        </c:when>
                        <c:otherwise/>
                      </c:choose>
                    </td>
		        </tr>
		    </c:forEach>
	    </c:when>
	      <c:otherwise>
	        <tr>
	          <td colspan="5" class = "failList">
	            구매내역이 존재하지 않습니다.
	          </td>
	        </tr>
	      </c:otherwise>
	 </c:choose><!-- 테이블 입력 끝 -->
	 
  </div>
</table>
</body>
</html>