<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 게시판</title>
<link rel="stylesheet" type="text/css"
	href="03_card/card_css/cardlist.css">
<script type="text/javascript" src="03_card/card_script/card.js"></script>
<script type="text/javascript" src="04_event/card_script/card.js"></script>
<script type="text/javascript">
	
</script>
</head>
<body>
	<div id="event_box" style="font-size: 50px">
		<h1 style="color: orange; min-width: 1400px;">EVENT LIST</h1>
	</div>

	<div id="cardline">
		<div id="eventlist">
			<c:forEach var="event" items="${eventlist}">
				<div id="event">
					<div id="cardcontainer"
						onclick="open_win('event?command=events_view&num=${event.eventNum}', 'view')">
						<img id="cardimg" src="./img/${event.eventCardImg}">
					</div>
					<p style="font-size: 30px; font-weight: 1000;">${event.eventName}</p>
					<p>${event.eventInfo}</p>
					<p>${event.eventBen}</p>
				</div>
			</c:forEach>
		</div>
	</div>
	<div style="display: flex; justify-content: center;">
		<c:if test="${loginUser.lev eq 'b' }">
			<div id="card_write"
				style="text-align: center; margin-bottom: 20px; margin-right: 30px;"
				onclick="open_win('event?command=events_write_form')">새로운 이벤트
				등록</div>
		</c:if>
	</div>

	<jsp:include page="../footer.html"></jsp:include>
</body>
</html>
