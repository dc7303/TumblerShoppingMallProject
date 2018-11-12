<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
    
    <link rel="stylesheet" href="css/basic.css">
    <link rel="stylesheet" href="css/shop.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

  </head>
  <body>

<%@ include file="../nav.jsp" %>
       <div
				class="module_list_product_default extend_five extend_thumbnail_square">
				
				<table class="list">
				<tr>
					<c:forEach items="${list}" var="productDTO"  begin="0" end="${fn:length(list)}"  varStatus="status">
								<c:if test = "${status.index % 5 == 0}">
									</tr><tr>
								</c:if>
												<td class="item">
													<a href="frontProduct?command=productDetail&pno=${list[status.index].productNum}">
														<div class="thumbnail ">
			 													<img src='img/${list[status.index].productPicture}' style="width:100%">
														</div> 
														<strong class="title" title="빨대 세척솔"> ${list[status.index].productName}</strong>
														<div class="area_price">
															<strong class="price"><span class="number">${list[status.index].productPrice}</span>
															<span class="currency">원</span></strong>
														</div>
													</a>
													<a href="frontBasket?command=basketInsert&pno=${list[status.index].productNum}">장바구니에 담기</a>
												</td>
								</c:forEach>					
						</tr>
				</table>
			</div>

<%@ include file="../footer.jsp" %>
  </body>
</html>


