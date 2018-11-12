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
  <script type="text/javascript" src="${applicationScope.conPath }/lib/jquery-3.3.1.min.js"></script>
  
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
        
         $('input[type=button]').on("click", function(){
           if($(this).attr('name') == 'goMyPageBtn'){
             location.href = href='frontOrder?command=orderByUserId&basongFlag=use';
           }else {
             location.href = "index.html";
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
      padding-bottom:150px;
      padding-left:400px;
      padding-right:400px;
    }
    .successMsg {
      width:100%;
      height:200px;
      margin-left:auto;
      margin-right:auto;
      margin-top:70px;
      text-align:center;
      font-size:18px;
      border-bottom:1px solid #6e6e6e;
    }
    
    .msgTop {
      margin-top:50px;
    }
    .msgTop>hr {
      border:solid 1.5px #6e6e6e;
    }
    
    .msgSubject {
      font-size:30px;
      font-weight:bold;
      color:#333;
    }
  </style>
</head>

<body>
<jsp:include page="../nav.jsp"/>

<div class="main">
  <div class = "msgTop">
    <span class="msgSubject">주문완료</span><br/>
  <hr/>
  </div>
  <div class="successMsg">
    저희 상품을 구매해주셔서 감사합니다.<br/><br/>
    항상 좋은 상품으로 모시겠습니다.<br/><br/>
    <input type = "button" value = "메인페이지" name="goMainBtn"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type = "button" value="마이페이지" name="goMyPageBtn"/>
  </div>
</div>

    <jsp:include page="../footer.jsp"/>
</body>

</html>