<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<head>
    <title>Product Infomation</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/basic.css">
  <link rel="stylesheet" href="css/main01.css">
  <link rel="stylesheet" href="css/font-roboto.css">
  <link rel="stylesheet" href="css/font-montserrat.css">
  <link rel="stylesheet" href="css/font-montserrat-02.css">
  <script type="text/javascript" src="lib/jquery-3.3.1.min.js"></script>
  
    <script>
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
        
          $('a[name=btn]').on('click', function(){
            if($(this).attr('class')=='goBuy'){
              if($('input[name=userId]').val() == null || $('input[name=userId]').val() == ""){
                alert("로그인 후 사용해주세요.")
              }else if ($('select[name=option]').val()=='0') {
                alert('옵션을 선택핵주세요');
              }else{
                $(this).parent().attr("action", "product/buyForm.jsp");
                $(this).parent().submit();
              }
            }else if($(this).attr('class')=='goBasket'){
              if($('input[name=userId]').val() == null || $('input[name=userId]').val() == ""){
                alert("로그인 후 사용해주세요.")
              }else{
                $(this).parent().attr("action", "product/basketForm.jsp");
                $(this).parent().submit();
              }
            }
          });
        });
        
    function windowSignIn(){
        window.open('user/signIn.jsp', 'signIn', 'width=550 height=500')
    }
    
    function windowSignUp(){
        window.open('user/signUp.jsp', 'signup', 'width=550 height=500')
    }
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
  
  .readTop {
    padding-top:30px;
  }
  
  .readBrand {
    color:#AE905E;
    font-size:25px;
  }
  
  .readProName {
    color:#333;
    font-size:35px;
    font-weight:bold ;
  }
  
  .readInfo {
    color:#a0a0a0;
  }
  
  .readImg {
    width:450px;
    height:550px;
    float:left;
    padding-right: 100px;
  }
  
  .freeDel {
    font-size:10px;
    border:1px solid #a0a0a0;
  }
  
  .readListName {
    color:#6e6e6e;
  }
  
  .readPrice {
    font-size:25px;
    font-weight:bold;
  }
  
  .readTop>hr {
    border:solid 1.5px #6e6e6e;
  }
  
  .readCenter>hr {
    margin-left:448px;
  }
  
  .eventMessage {
    color:#32B8FF;
  }
  
  .goBasket {
    float:left;
    padding-left:140px;
  }
  
  .goBuy {
    float:right;
  }
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
    <img src = "img/1.jpg" class= "readImg"/>
    <span class = "freeDel">무료배송</span><br/><br/><br/>
    <span class = "readListName">판매가</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <span class = "readPrice"><fmt:formatNumber>${proDTO.getProductPrice() }</fmt:formatNumber>원</span>
    <br/><br/>
    <span class = "readListName">카드혜택안내</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href = "#">혜택 알아보기</a><br/>
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
        <a href = "#" name = "btn" class = "goBasket"><img src = "img/proReadBtn/btn_basket.png"/></a>
	    <a href = "#" name = "btn" class = "goBuy"><img src = "img/proReadBtn/btn_buy_now.png"/></a>
    </form>
  </div>
</div>

    <jsp:include page="../footer.jsp"/>
</body>

</html>