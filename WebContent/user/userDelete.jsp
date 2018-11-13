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
  <link rel="stylesheet" href="${applicationScope.conPath }/css/common.css">
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
  
  .formDiv{
  		padding-top:135px;
  		width:600px;
  		hieght:100%;
  		margin: auto;
  		text-align:center;
   		line-height: 200%;
   		font-family: "Roboto", sans-serif;
  }
  
  .formDiv input{
   		 margin: 8px 0;
   		 box-sizing: border-box;
   		 border : 1px solid #333;
  }
  </style>
</head>

<body>

<jsp:include page="../nav.jsp"/>

<div class="main">
    <div class = "left">
      <jsp:include page="../orderInfo/myPageLeft.jsp"/>
    </div>
    <div class = "center"></div>
    
    		<div class="formDiv">
	    	<h1>비밀번호를 입력해주세요</h1>
    		<br>
    		<form method="post" action="../frontUserInfo?command=userDelete">
    		
    		비밀번호 <input type="password" name="password">
    		<input type="submit"  value="삭제">
    		</form>
    		</div>
   </div>
</div>


<jsp:include page="../footer.jsp"/>
</body>
</html>