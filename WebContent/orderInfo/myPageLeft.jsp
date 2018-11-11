<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴</title>

<script type="text/javascript">
  $(function(){
    $(document).on('click', 'a', function(){
      //basongFlag를 파라미터값으로 넘겨 줄때 use를 넘겨주면 배송완료 된 것을 제외한 주문내역을 출력시켜준다.
      if($(this).text() == '주문/배송조회'){
        //use : 배송완료 상태는 제외하고 조회한다.
        location.href = "frontOrder?command=orderByUserId&basongFlag=use" ;
      }else if($(this).text() == '총 구매내역'){
        //no : 배송완료 상태 포함 전체 조회.
        location.href = "frontOrder?command=orderByUserId&basongFlag=no";
      }
      
    });
  });
</script>
<style>

    .leftList {
        font-size:10px;
    }
</style>
</head>
<body>
  <div class = "leftMenu"></div>
    <h3>My Page</h3>
    <hr color = "#333"/>
    <h5>나의 쇼핑내역</h5>
    <a href = "#" class = "leftList">주문/배송조회</a><br/>
    <a href = "#" class = "leftList">주문취소 신청</a><br/>
    <a href = "#" class = "leftList">총 구매내역</a>
    
    <hr/>
    <h5>나의 장바구니</h5>
    <a href = "#" class = "leftList">장바구니 조회</a><br/>
    
    <hr/>
    <h5>회원 정보</h5> 
    <a href = "#" class = "leftList">회원정보 수정</a><br/>
    <a href = "#" class = "leftList">회원탈퇴</a><br/>
    
    


</body>
</html>