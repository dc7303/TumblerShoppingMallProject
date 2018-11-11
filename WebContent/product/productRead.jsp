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


  <div class="container">
    <div class="header_menu_bar">

      <span id="logo">
        <a href="#none" >
           Tumbler 
        </a>
      </span>

      <span id="sign" >
      </span>

    <br><br>

      <span>
        <!--notice.jsp 연걸 -->
        <a href="#none">공지사항  </a>
      </span>

      <span>
        <!--productlist.jsp 연걸 -->
        <a href="#none">  PRODUCT  </a>
      </span>

      <span>
          <!-- mypage.jsp 연걸 -->
        <a href="#none">  마이페이지  </a>
      </span>

      <span>
        <a href="#none">  Q'n'A 게시판  </a>
      </span>
    </div>


<div class="main">
  <c:set value="${requestScope.dto }" var="proDTO"/>
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
    <span class = "readListName">옵션</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <select name = "option">
      <option value = "0">선택하세요</option>
      <option value = "1">기본</option>
    </select><br/><br/>
    <span class = "readListName">주문수량</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <select>
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
    <a href = "#" class = "goBasket"><img src = "img/proReadBtn/btn_basket.png"/></a>
    <a href = "#" class = "goBuy"><img src = "img/proReadBtn/btn_buy_now.png"/></a>
  </div>
</div>



        <div class="footer">
            <div class="border">

                <hr class="hr01">

            <div class="section_01">
            <dl>
                <dt>쇼핑 및 알아보기</dt>
                <dd>머그</dd>
                <dd>글라스</dd>
                <dd>플라스틱텀블러</dd>
                <dd>스테인리스텀블러</dd>
                <dd>보온병</dd>

            </dl>
            </div>

            <div>
            <dl>
                <dt>Tumbler</dt>
                <dd>매장 찾기</dd>
                <dd>커스텀 주문</dd>
                <dd>특가 제품</dd>
                <dd>주문 상태</dd>
                <dd>쇼핑 도움말</dd>
            </dl>
            </div>

            <div>

            <dl>
                <dt>비즈니스</dt>
                <dd>Tumbler와 비즈니스</dd>
                <dd>비즈니스를 위한 제품 쇼핑하기</dd>
            </dl>
            </div>

            <div>
            <dl>
                <dt>계정</dt>
                <dd>Tumbler ID 관리</dd>
                <dd>Tumbler 계정</dd>
                <dd>Tumbler.com</dd>
            </dl>

            </div>

            <div>
            <dl>
                <dt>Tumbler 정보</dt>
                <dd>Newsroom</dd>
                <dd>채용 안내</dd>
                <dd>이벤트</dd>
                <dd>Tumbler 연락처</dd>
            </dl>
            </div>
        <div class="footer_nav">

            <hr class="hr02">
            <p class="nav_com">Copyright © 2018 Tumbler Inc. 모든 권리 보유.개인정보 처리방침 약관 판매 및 환불 법적 고지 사이트 맵</p>
            <p class="nav_com">사업자등록번호 : 000-00-00000 | 통신판매업신고번호 : 제 2018-경기판교-123456호 | 대표이사 : 지 성 | 주소 : 경기도 분당 판교 | 대표전화 : 00-000-0000</p>
        </div>
        </div>
    </div>

    </div>
</body>
</html>