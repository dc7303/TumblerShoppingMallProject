<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<head>
    <title>Product Infomation</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../css/basic.css">
  <link rel="stylesheet" href="../css/main01.css">
  <link rel="stylesheet" href="../css/font-roboto.css">
  <link rel="stylesheet" href="../css/font-montserrat.css">
  <link rel="stylesheet" href="../css/font-montserrat-02.css">
  <script type="text/javascript" src="../lib/jquery-3.3.1.min.js"></script>
  
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
    margin-top:10px;
    border:solid 2px #6e6e6e;
  }
  
  .buyTop>img {
    padding-top:20px;
  }
  </style>
</head>

<body>
<jsp:include page="../nav.jsp"/>

<div class="main">
  <div class = "buyTop">
    <img src = "../img/buyForm/buy_top_text.png"/>
    <hr/><br/>
  </div>
  <div>
    <span>주문상품 확인</span>
  </div>
</div>



<jsp:include page="../footer.jsp"/>
</body>
</html>