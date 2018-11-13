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
  
  td, th {
   padding: 7px;
   font-size: 15px;
}
   
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
       
        padding-top : 20px;
        margin-left: 20%;
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
  .formDiv td{
        margin: 5px;
  }
  
  
.setbutton {
      height: 30px; 
      width: 60px; 
      background-color: #333; 
      color: white;}
  
  </style>
</head>

<body>

<jsp:include page="../nav.jsp"/>

<div class="main">
    <!-- 좌측메뉴 -->
    <div class = "left">
      <jsp:include page="../orderInfo/myPageLeft.jsp"/>
    </div>
      
      <div class="formDiv">
      <center>
      <form method="post" action="   frontUserInfo" ">
         <table cellspacing="0" text-align="center">        
            <caption>         
               <h3>회원정보수정</h3>
            </caption>
            <input type="hidden" name="command" value="userUpdate">
            <tr>
               <td>Name</td>
               <td><input type="text" name="userName" value="${dto.userName}"/></td>
            </tr>
            <tr>
               <td>Password</td>
               <td><input type="password" name="userPwd" value="${dto.userPwd}"/></td>
            </tr>
            <tr>
               <td>생일</td>
               <td><input type="text" name="userBirth" value="${dto.userBirth}"/></td>
            </tr>

            <tr>
               <td>전화번호</td>
               <td><input type="text" name="userPhone" value="${dto.userPhone}"/></td>
            </tr>
            <tr>
               <td>주소</td>
               <td><input type="text" name="userAddr" value="${dto.userAddr}"/></td>
            </tr>
            <tr>
               <td>Email</td>
               <td><input type="text" name="userEmail" value="${dto.userEmail}"/></td>
            </tr>
            <tr>
               <td colspan="2" style="text-align: center; ">
               <input class="setbutton" type="submit" value="수정" /> 
               <input class="setbutton" type="reset" value="취소"  />
               </td>
            </tr>
         </table>
      </form>
       </center>
   </div>
</div>


<jsp:include page="../footer.jsp"/>
</body>
</html>