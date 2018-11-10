<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>
    <title>결제 내역 조회</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/basic.css">
  <link rel="stylesheet" href="css/main01.css">
  <link rel="stylesheet" href="css/font-roboto.css">
  <link rel="stylesheet" href="css/font-montserrat.css">
  <link rel="stylesheet" href="css/font-montserrat-02.css">
  <script type="text/javascript" src="lib/jquery-3.3.1.min.js"></script>

  
  <style>
  .w3-sidebar a {font-family: "Roboto", sans-serif}
  body,h1,h2,h3,h4,h5,h6,.w3-wide {font-family: "Montserrat", sans-serif;}

 
  .left {
    width:20%;
    height:100%;
    float:left;
    padding-left:10px;
    padding-right:90px;
  }
  
  .main {
    padding-top:135px;
    padding-bottom:100px;
  }
  
  .center {
    float:left;
    height:100%;
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
        <!--로그아웃 연걸 -->
        <a href="#" onclick="window.open('userinfo/signUp.jsp', 'signup', 'width=550 height=500')">
        &nbsp;로그아웃
        </a>
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
    <!-- 좌측메뉴 -->
    <div class = "left">
      <jsp:include page="orderListLeft.jsp"/>
    </div>
    
    <!-- 전송된 파라미터 search 값에 따라 센터 include가 달라진다. -->
    <div class = "center"></div>
      <c:choose>
        <c:when test ="${param.search == 'order' }">
          <jsp:include page="orderListCenter.jsp"/>
        </c:when>
        <c:when test ="${param.search == 'totalOrder' }">
          <jsp:include page="totalOrderListCenter.jsp"/>
        </c:when>
      </c:choose>
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