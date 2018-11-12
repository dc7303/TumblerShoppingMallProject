	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
   
    <style>
        
    <style>
        @import url('https://fonts.googleapis.com/css?family=Nanum+Gothic');
        @import url(http://fonts.googleapis.com/earlyaccess/notosanskr.css);



        table {
            text-align: center;
            font-family: 'Noto Sans','Nanum Gothic';
            color: #222;
        }

        hr{
            border: 0.5px solid #333;
        }
        /* 상품박스 */
        .productDiv{
             width: 300px;
            height: 100%;
        }

        .imgDiv{
            float:left;

        }
        .imgDiv img{
            width: 100px;
            height: 100px;
        }
        .nameDiv{
            text-align: center;
            padding-top: 10px;
            height: 100px;
        }
        /* 수량 */
        .countDiv{
            width:100px;
            height:100%;
        }

        .countDiv div{
            margin: 30px;
        }
        .countInput{
            width:40px;
        }
        /* 가격 */
        .priceDiv{
            width:100px;
        }
        /* 배달 */
        .deliveryDiv{
            width:100px;
        }
        /* 주문 */
        .orderDiv{
            width:100px;
            height:100%;
        }
        .orderDiv div{
            width:50px;
            padding: 25px;
            margin-top: 10px;
        }

        .updatebutton {height: 35px;
    		width:50px;
    		background-color: #fff;
    		color: black;

        }

        .buybutton {height: 35px;
    		width:50px;
    		background-color: #444;
    		color: white;

        }

        .deletebutton {height: 35px;
    		width:50px;
    		background-color: #444;
    		color: white;
        }

    </style>
</head>
<body>
   <table>
       <tr>
        <td>상품</td>           
        <td>수량</td>
        <td>금액</td>
        <td>배송</td>
        <td>주문</td>
       </tr>
       	<c:forEach items="${requestScope.list}" var="basketdto">
       <tr>
        <td>
           <div class="productDiv">
                
                <div class="imgDiv">
                    <img src="${conPath}/${basketdto.productDto.productPicture}">
                </div>
               
                <div class="nameDiv">
                    ${basketdto.productDto.productName}
                    <hr>
                    ${basketdto.basketOption}
                </div>
            </div>          
        </td>   
        <td class="countDiv">
           <div>
            <input class="countInput" type="text" value="${basketdto.getBasketQuantity()}">
            <p/>
            <button type="button" class="">수정</button>
            </div>
        </td>               
        <td class="priceDiv">
 			${basketdto.getBasketPrice()}
         </td>
        <td class="deliveryDiv">
            배송비 무료
        </td>
        <td class="orderDiv">
           <div>
              <button type="button" class="buybutton">구매</button>
            <p/>
            <button type="button" class="deletebutton">삭제</button>
            </div>
        </td>
       </tr>
 </c:forEach>
       
   </table>
    
</body>
</html>

<!-- 수정전  --><!-- 
<div align=right>
<span style="font-size:9pt;">&lt;<a href="frontBasket?command=basketInsert">삽입</a>&gt;</span></div>

<div align=right>
<span style="font-size:9pt;">&lt;<a href="frontBasket?command=basketUpdate">수정</a>&gt;</span></div>
 -->

