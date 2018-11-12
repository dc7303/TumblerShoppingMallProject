<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>
    <title>My Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${applicationScope.conPath }/css/basic.css">
  <link rel="stylesheet" href="${applicationScope.conPath }/css/main01.css">
  <link rel="stylesheet" href="${applicationScope.conPath }/css/font-roboto.css">
  <link rel="stylesheet" href="${applicationScope.conPath }/css/font-montserrat.css">
  <link rel="stylesheet" href="${applicationScope.conPath }/css/font-montserrat-02.css">
  <script type="text/javascript" src="${applicationScope.conPath }/lib/jquery-3.3.1.min.js"></script>
  
 
  <style>
  .w3-sidebar a {font-family: "Roboto", sans-serif}
  body,h1,h2,h3,h4,h5,h6,.w3-wide {font-family: "Montserrat", sans-serif;}
   
   a{
     text-decoration:none;
   }
 
  .left {
    width:20%;
    height:100%;
    float:left;
    padding-left:10px;
    padding-right:90px;
  }
  
  .main {
    padding-top:135px;
    padding-bottom:200px;
  }
  
  .center {
    float:left;
    height:100%;
  }
  
  </style>
</head>

<body>

<jsp:include page="../nav.jsp"/>

<div class="main">
    <!-- 좌측메뉴 -->
    <div class = "left">
      <jsp:include page="myPageLeft.jsp"/>
    </div>
    
    <!-- 
    전송된 파라미터 basongFlag 값에 따라 센터 include가 달라진다. 
    no: 지난 총내역 조회, use: 현재 배송진행중인 구매내역
    -->
    <div class = "center"></div>
      <c:choose>
        <c:when test ="${param.basongFlag == 'use' }">
          <jsp:include page="orderListCenter.jsp"/>
        </c:when>
        <c:when test ="${param.basongFlag == 'no' }">
          <jsp:include page="totalOrderListCenter.jsp"/>
        </c:when>
      </c:choose>
    </div>
</div>


<jsp:include page="../footer.jsp"/>
</body>
</html>