<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>카드 리스트</title>
<link rel="stylesheet" type="text/css"
	href="03_card/card_css/cardlist.css">
<script type="text/javascript" src="03_card/card_script/card.js"></script>


</head>
<body>
	<div id="listbox">
		<h1 style="color: orange; min-width: 1400px;">T6CARD LIST</h1>
	</div>
	<div id=list_background>
		<div id="cardline">
			<div id="cardlist">
				<c:forEach var="card" items="${cardlist}">
					<div id="card">
						<div id="cardcontainer"
							onclick="open_win('card?command=card_view&num=${card.num}', 'view')">
							<img id="cardimg" src="./img/${card.img}">
						</div>
						<p style="font-size: 30px; font-weight: 1000;">${card.name}</p>
						<p>${card.info}</p>
					</div>
				</c:forEach>
			</div>
		</div>
		<div style="display: flex; justify-content: center;">
			<c:if test="${loginUser.lev =='b' }">
				<div id="card_write"
					onclick="open_win('card?command=card_write_form')">카드 등록</div>
			</c:if>
		</div>
	</div>
	<jsp:include page="../footer.html"></jsp:include>

</body>
</html>