<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<head>
    <title>Product Infomation</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/basic.css">
  <link rel="stylesheet" href="${applicationScope.conPath }/css/main01.css">
  <link rel="stylesheet" href="${applicationScope.conPath }/css/font-roboto.css">
  <link rel="stylesheet" href="${applicationScope.conPath }/css/font-montserrat.css">
  <link rel="stylesheet" href="${applicationScope.conPath }/css/font-montserrat-02.css">
  <link rel="stylesheet" href="${applicationScope.conPath }/css/productRead.css">
  <link rel="stylesheet" href="${applicationScope.conPath }/css/common.css">
  <script type="text/javascript" src="${applicationScope.conPath }/lib/jquery-3.3.1.min.js"></script>
  
    <script>
    $(function(){
        $('a[name=btn]').on('click', function(){
          if($(this).attr('class')=='goBuy'){
            if($('input[name=userId]').val() == null || $('input[name=userId]').val() == ""){
              alert("로그인 후 사용해주세요.")
            }else if ($('select[name=option]').val()=='0') {
              alert('옵션을 선택핵주세요');
            }else{
              $(this).parent().attr("action", "orderInfo/buyForm.jsp");
              $('input[name=flag]').attr("value", "buyNow");
              $(this).parent().submit();
            }
          }else if($(this).attr('class')=='goBasket'){
            if($('input[name=userId]').val() == null || $('input[name=userId]').val() == ""){
              alert("로그인 후 사용해주세요.")
            }else{
              $(this).parent().attr("action", "frontBasket?command=basketSelectAll");
              $(this).parent().submit();
            }
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
  <c:set value="${requestScope.dto }" var="proDTO"/>
  <c:set value="${sessionScope.userDTO }" var = "userDTO"/>
  <div class ="readTop">
    <span class = "readBrand">${proDTO.getProductBrand() }</span><br/>
    <span class = "readProName">${proDTO.getProductName() }</span><br/>
    <span class = "readInfo">${proDTO.getProductInfo() }</span><br/>
    <hr/><br/>
  </div>
  <div class = "readCenter">
    <img src = "${applicationScope.conPath }/img/1.jpg" class= "readImg"/>
    <span class = "freeDel">무료배송</span><br/><br/><br/>
    <span class = "readListName">판매가</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <span class = "readPrice"><fmt:formatNumber>${proDTO.getProductPrice() }</fmt:formatNumber>원</span>
    <br/><br/>
    <span class = "readListName">카드혜택안내</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href = "#" class="readListName">혜택 알아보기</a><br/>
    <hr/>
    <form action = "" method = "post">
	    <span class = "readListName">옵션</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    <select name = "option">
	      <option value = "0">선택하세요</option>
	      <option value = "기본">기본</option>
	    </select><br/><br/>
	    <span class = "readListName">주문수량</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    <select name = "amount">
	      <c:forEach begin="1" end="10" var="i">
	        <option value = "${i }">${i }</option>
	      </c:forEach>
	    </select><br/><br/>
	    <span class = "readListName">관련 EVENT</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    <a href = "#" class ="eventMessage">현재 진행중인 이벤트가 없습니다.</a><br/><br/>
	    <hr/>
	      <span class = "readListName">
	        주문 후 배송은 1~2일 정도 소요되며, 공휴일 또는 명절이 겹쳐있을 경우 지연될 수 있습니다.
	      </span>
	    <hr/>
	    <input type = "hidden" name = "proNum" value="${proDTO.getProductNum() }"/>
	    <input type = "hidden" name = "proName" value="${proDTO.getProductName() }"/>
	    <input type = "hidden" name = "proInfo" value="${proDTO.getProductInfo() }"/>
	    <input type = "hidden" name = "proPrice" value="${proDTO.getProductPrice() }"/>
	    <input type = "hidden" name = "proPicture" value="${proDTO.getProductPicture() }"/>
	    <input type = "hidden" name = "proBrand" value="${proDTO.getProductBrand() }"/>
        <input type = "hidden" name = "proQuantity" value="${proDTO.getProductQuantity() }"/>
	    <input type = "hidden" name = "userId" value="${userDTO.getUserId() }"/>
	    <input type = "hidden" name = "flag" value = ""/>
        <a href = "#" name = "btn" class = "goBasket"><img src = "${applicationScope.conPath }/img/proReadBtn/btn_basket.png"/></a>
	    <a href = "#" name = "btn" class = "goBuy"><img src = "${applicationScope.conPath }/img/proReadBtn/btn_buy_now.png"/></a>
    </form>
  </div>
</div>

    <jsp:include page="../footer.jsp"/>
</body>

</html>