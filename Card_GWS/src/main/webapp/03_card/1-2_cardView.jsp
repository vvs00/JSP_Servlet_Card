<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카드 상세 페이지</title>
<script type="text/javascript" src="03_card/card_script/card.js"></script>
<script>
var message = "<c:out value='${alertMessage}'/>";
if(message != ''){
   alert(message);
}</script>
<link rel="stylesheet" type="text/css"
	href="03_card/card_css/cardlist.css">
</head>
<body id="viewbody">
	<div id="blank"></div>
	<div id="map">
		<div id="mapinfo">
			<div id="cardinfo">
				<form action="card" method="get" id="cardview">
					<input type="hidden" name=command value="card_delete">
					<c:forEach var="card" items="${cardlist}">
						<div style="align-items: center;">
							<div id="viewimg">
								<img src="./img/${card.img}">
								<p id="cardname">${card.name}</p>
							</div>
							<div>
								<p style="display: inline; font-size: 20px; font-weight: 1000;">공지 :</p>
								<p style="display: inline; font-style: italic;">${card.notice}</p>
								<br>
								<br>
								<p style="display: inline; font-size: 20px; font-weight: 1000;">연회비 :</p>
								<p style="display: inline; font-style: italic;">${card.dues}</p>
								<br>
								<br>
								<p style="display: inline; font-size: 20px; font-weight: 1000;">기준 실적 :</p>
								<p style="display: inline; font-style: italic;">${card.performance}</p>
								<br>
								<br>
								<p style="display: inline; font-size: 20px; font-weight: 1000;">카드 해택 :</p>
								<p style="display: inline; font-style: italic;">${card.benefits}</p>
							</div>
						</div>
						<div id="buttoncan">
							<input type="button" value="장바구니" id="cardbutton" onclick="location.href='Wishlist?command=wishlistAdd&num=${card.num}'">
							<c:if test="${loginUser.lev =='b' }">
								<input id="cardbutton" type="button"
									onclick="location.href='card?command=card_update_form&num=${card.num}'"
									value="수정">
								<input id="cardbutton" type="button"
									onclick="location.href='card?command=card_delete&num=${card.num}'"
									value="삭제">
							</c:if>
						</div>
					</c:forEach>
				</form>
			</div>
		</div>
	</div>
</body>
</html>