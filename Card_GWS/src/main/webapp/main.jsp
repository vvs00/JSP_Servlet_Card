<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ProJect Team 6 Card</title>

<!-- 제이쿼리  -->
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="04_event/card_script/card.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		getImgSize();
	});
	
	function getImgSize() {
		// querySelectorAll: 이름을 가진 전체 노드를 배열로 갖고온다.
		const imgContainer = document.querySelectorAll('#img_2_body');
	
		imgContainer.forEach(e => {
			let height = e.offsetHeight;
			let width = e.offsetWidth;
			
			if (height > width) 
				e.className = 'vrtclImage';
			else
				e.className = 'hrzntImage';
		});
	}
</script>


<link rel="stylesheet" type="text/css" href="01_main/main_css/main.css">
</head>
<body>

	<!-- 헤더 -->
	<%@ include file="header.jsp"%>
	<!--// 헤더 -->



	<div id="body">
		<div id="slid_back">
			<div id="slid_img">
				<div id="banner"> 
					<img id="slid" src="https://ai.esmplus.com/zkzkzj/TEAM6/slide_01.png">
					<img id="slid" src="https://ai.esmplus.com/zkzkzj/TEAM6/slide_02.png">
					<img id="slid" src="https://ai.esmplus.com/zkzkzj/TEAM6/slide_03.png"> 
					<img id="slid" src="https://ai.esmplus.com/zkzkzj/TEAM6/slide_04.png">
				</div>
			</div>
		</div>

		<div style="margin-top: 40px">
			<img id="point" src="img/left.png" onclick="banner_prev();">
			<img id="point" src="img/right.png" onclick="banner_next();">
		</div>

		<div id="text">

			<div id="board">
				<h1>Q&A</h1>
				<c:forEach var="customer" items="${customerList}" end="2">
					<div style="margin-top: 5px">
						<a href="CustomerBoard?command=cutomerBoardView&num=${customer.num}">
							<p style="font-size: 20px">
								[
								<fmt:formatDate value="${customer.date}" 
								pattern="yyyy-MM-dd hh:mm" />
								]
								&nbsp; &nbsp; ${customer.title}
							</p>
						</a>
					</div>
				</c:forEach>
			</div>

			<div id="board">
				<h1>NOTICE</h1>

				<c:forEach var="notice" items="${noticeList}" end="2">
					<div id="sex" style="margin-top: 5px">
						<a href="notice?command=noticeBoardView&num=${notice.num}">
							<p style="font-size: 20px">
								[
								<fmt:formatDate value="${notice.writedate}"
									pattern="yyyy-MM-dd hh:mm" />
								] &nbsp; &nbsp; ${notice.title}
							</p>
						</a>
					</div>
				</c:forEach>
			</div>
		</div>


		<div id="popular_body">
			<div id="popular_back">
				
					<div id="popular">
						<img id="cardback" src="img/cardback_2.jpg">
						<c:forEach var="card" items="${cardList}" end="4">
							<div id="card_section" onclick="open_win('card?command=card_view&num=${card.num}', 'view')">
								<div id="img_section">
								<div id="img_2_body">
									<img id="img_2" src="img/${card.img}">
								</div>
								</div>
								<p style="margin-left: 30px">${card.name}</p>
							</div>
						</c:forEach>
					</div>
				

				<div id="popular_line">
					<div id="popular">
						<img id="cardback" src="img/cardback_1.jpg">
						<c:forEach var="event" items="${eventList}" end="4">
							<div id="card_section" onclick="open_win('event?command=event_view&num=${event.eventNum}', 'view')">
								
								<div id="img_section">
								<div id="img_2_body">
									<img id="img_2" src="img/${event.eventCardImg}">
								</div>
								</div>
								<p style="margin-left: 30px">${event.eventName}</p>
							</div>
						</c:forEach>
					</div>
				</div>

			</div>
		</div>

		<div id="our">

			<p style="font-size: 40px">OUR INFORMATION</p>

			<p>카드의 새로운 문화를 선도하는 브랜드가 되도록 노력하겠습니다.</p>

		</div>



		<div id="information">

			<div id="info_list" onclick="location.href='intro?command=intropage'">
				<img id="img_3" src="img/company.png">
				<h3>회사소개</h3>
				<p>정직함에서 시작합니다.</p>
				<p align="center" style="line-height: 30px">
					누구나 인정하며,<br> 누구나 즐길 수 있는, <br> 카드문화를 선도하겠습니다.
				</p>
			</div>

			<div id="info_list"
				onclick="location.href='CustomerBoard?command=CustomerBoardList'">
				<img id="img_3" src="img/client.png">
				<h3>고객센터</h3>
				<p>고객님들의 소리를 듣겠습니다.</p>
				<p align="center" style="line-height: 30px">
					고객님들께서 많이 하시는 질문입니다.<br> 문의전에 참고 부탁드리며, <br>카드를 사용하시다 어려운
					점이 있다면 말씀해주세요.
				</p>
			</div>

			<div id="info_list" onclick="location.href='card?command=card_list'">
				<img id="img_3" src="img/money.png">
				<h3>카드안내</h3>
				<p>우리는 카드를 쓰고, 카드에 대해 씁니다.</p>
				<p align="center" style="line-height: 30px">
					다양한 카드만을 제공하는 것이 아닌, <br> 여러카드사의 카드를 한눈에 비교하고 싶을 때, <br>마음껏
					방문해주세요.
				</p>
			</div>
		</div>

		
		<div id="img_back">

			<div id="img">
				<img id="img" src="img/blurb_1.jpg">
			</div>
		</div>
		

	</div>



	<script src="main.js"></script>
	<jsp:include page="footer.html"></jsp:include>
</body>
</html>