<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
  <script type="text/javascript" src="${applicationScope.conPath }/lib/jquery-3.3.1.min.js"></script>
  
    <script>
    /*
    $(function(){
        $.ajax({
            url:"signCheck",
            type:"post",
            dataType:"text",
            success:function(result){
                var str = "";
                if(result == ""){
                    str += "<a href='#' onclick='windowSignIn()'>로그인&nbsp</a><a>/</a>";
                    str += "<a href='#' onclick='windowSignUp()'>&nbsp;회원가입</a>";
                    $("#sign").html(str);
                } else {
                    str += "<a href='frontOrder?command=orderByUserId&basongFlag=use'>마이페이지</a>"
                        str += "<a>/</a>"
                        str += "<a href='frontUserInfo?command=userSignOut'>&nbsp;로그아웃</a>"
                        $("#sign").html(str);
                }
            },
            error:function(err){
                alert(err);
            }
            
            });
        });
        
    function windowSignIn(){
        window.open('user/signIn.jsp', 'signIn', 'width=550 height=500')
    }
    
    function windowSignUp(){
        window.open('user/signUp.jsp', 'signup', 'width=550 height=500')
    }
    */
    $(function(){
      $('#backBtn').on('click', function(){
        history.back();
      });
    });
        </script>
  <style>
  .w3-sidebar a {font-family: "Roboto", sans-serif}
  body,h1,h2,h3,h4,h5,h6,.w3-wide {font-family: "Montserrat", sans-serif;}

  .main {
    padding-top:135px;
    padding-bottom:250px;
    padding-left:300px;
    padding-right:300px;
  }
    
  .buyTop>hr {
    margin-top:20px;
    border:solid 2px #6e6e6e;
  }
  
  .buyTop>img {
    padding-top:20px;
  }
  
  .orderInfoTable {
    border:2px solid #333;
    width:100%;
    text-align:center;
  }
  
  .orderInfoTable th {
    background-color:#333;
    color:lightgrey;
    border:1px solid #333;  
  }
  
  
  .tableName {
    font-weight:bold;
    font-size:17px;
    padding-right:260px;
  }
  
  .tableInImg{
    float:left;
    width:100px;
    height:100px;
    margin-right:30px;
    margin-left:20px;
  }
  
  .optionInfoT {
    text-align:left;
    padding-top:10px;
  }
  
  .basongInfoTable {
    width:100%;
    border-bottom:1px solid #333;
    border-top:3px solid #333;
  }
  
  .basongInfoTable th {
    background-color:#FAFAFA;
    height:80px;
    text-align:left;
    padding-left:30px;
  }
  
  .basongInfoTable td {
    background-color:#FAFAFA;
    height:80px;
    padding-left:20px;
  }
  
  .commentBottom {
    color:#32B8FF;
    font-size:12px;
  }
  
  .totalPriceT {
    margin-top:15px;
    border:3px solid #333;
    width:100%;
    height:90px;
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
  
  .payBtn {
    float:right;
    padding-right:10px;
  }
  .backBtn {
    float:right;
    padding-top:1px;
  }
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
    * 상품수량 및 옵션병경은 상품상세 또는 장바구니에서 가능합니다.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="이전 페이지" id="backBtn"/>
    <br/><br/>
    <form action = "" method = "">
    <c:choose>
      <c:when test="${param.flag == 'buyNow' }">
	    <table class ="orderInfoTable">
	      <tr>
	        <th>상품/옵션정보</th>
	        <th>수량</th>
	        <th>상품금액</th>
	        <th>할인금액</th>
	        <th>배송비</th>
	      </tr>
	      <tr>
	        <td class="optionInfoT">
	          <img src = "${applicationScope.conPath }/img/1.jpg" class="tableInImg"/>
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
	  </c:when>
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
           ${param.proPrice * param.amount }
         </fmt:formatNumber>&nbsp;&nbsp;</span> 원</td>
        </tr>
      </table><br/>
      <a href = ""><img src = "${applicationScope.conPath }/img/buyForm/btn_backpage.png" class="backBtn"/></a>
      <a href = ""><img src = "${applicationScope.conPath }/img/buyForm/btn_payment.png" class="payBtn"/></a>
    </form>
  </div>
</div>



<jsp:include page="../footer.jsp"/>
</body>
</html>