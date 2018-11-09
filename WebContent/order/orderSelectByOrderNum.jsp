<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    table {
        border:1px solid black;
    }
    
    tr, th, td{
        border:1px solid black;
        text-align:center;
    }
    
    th {
        background-color:lightblue;
    }
</style>
</head>
<body>
    <table>
        <tr>
            <th>주문번호</th>
            <th>유저아이디</th>
            <th>주문일</th>
            <th>가격</th>
            <th>기타</th>
            <th>디테일번호</th>
            <th>상품번호</th>
            <th>상세가격</th>
            <th>옵션</th>
            <th>수량</th>
            <th>상세주문일</th>
            <th>배송번호</th>
            <th>배송회사</th>
            <th>송장번호</th>
            <th>배송주소</th>
            <th>휴대폰번호</th>
            <th>배송시작일</th>
            <th>배송상태</th>
        </tr>
        <c:forEach items = "${requestScope.orderDTO }" var = "orderDTO">
            <tr>
               <td>${orderDTO.getOrderNum() }</td>
               <td>${orderDTO.getOrderUserId() }</td>
               <td>${orderDTO.getOrderDate() }</td>p
               <td>${orderDTO.getOrderPrice() }</td>
               <td>${orderDTO.getOrderComment() }</td>
               <td>${orderDTO.getDetailDTO().getOrderDetailNum() }</td>
               <td>${orderDTO.getDetailDTO().getProductNum() }</td>
               <td>${orderDTO.getDetailDTO().getOrderDetailPrice() }</td>
               <td>${orderDTO.getDetailDTO().getOrderDetailQuantity() }</td>
               <td>${orderDTO.getDetailDTO().getOrderDetailOption() }</td>
               <td>${orderDTO.getDetailDTO().getOrderDetailDate() }</td>
               <td>${orderDTO.getBasongDTO().getBasongNum() }</td>
               <td>${orderDTO.getBasongDTO().getBasongCompany() }</td>
               <td>${orderDTO.getBasongDTO().getBasongInvoiceNum() }</td>
               <td>${orderDTO.getBasongDTO().getBasongAddr() }</td>
               <td>${orderDTO.getBasongDTO().getBasongPhone() }</td>
               <td>${orderDTO.getBasongDTO().getBasongDate() }</td>
               <td>${orderDTO.getBasongDTO().getBasongStatus() }</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>