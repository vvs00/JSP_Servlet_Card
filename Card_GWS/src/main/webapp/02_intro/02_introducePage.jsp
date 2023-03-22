<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>T6Card 소개</title>
<style>
body {
	
}

#container {
	width: 1420px;
	height: 970px;
	margin: auto;
	padding-top: 30px;
	padding-bottom: 30px;
	text-align: left;
}

#contact_map {
	width: 800px;
	height: 500px;
}

#contact_map iframe {
	width: 100%;
	height: 100%;
	border: 0;
}

#addInfo td {
	height: 50px;
	padding-left: 0px;
}
</style>
</head>
<body>
	<div id="brandinfo"
		style="background: url(https://ai.esmplus.com/zkzkzj/TEAM6/intro-bg3.png); background-size: cover; background-position-y: bottom;">
		<div id="container">
			<div>
				<h1
					style="margin-top: 30px; font-size: 3.5rem; color: rgb(41, 39, 37);">회사소개</h1>

				<h2
					style="margin-top: 30px; font-size: 2.2rem; color: rgb(41, 39, 37);">TEAM6
					인사말</h2>
				<p
					style="font-size: 1.13rem; color: rgb(41, 39, 37); line-height: 45px;">
					고객님께 감사하고, 이웃과 함께하는 "TEAM 6"가 되겠습니다.<br> 우리 "TEAM 6 CARD"의
					이번프로젝트는 지난 2022년 탄생한 이후 지속적인 변화와 웹페이지 개발을 통해<br> 고객 여러분께 보다
					많은, 보다 나은 즐거움과 감동의 가치를 전달하기 위한 노력을 해오고 있습니다.<br> 앞으로도 그동안의 성공
					노하우를 쌓고싶은 마음을 바탕으로한 "TEAM 6"만의 브랜드로,<br> 더욱 더 특별한 경쟁력으로 고객
					여러분께 다가갈 것입니다.<br> "TEAM 6 CARD"가 추구하는 '생각'은 끊임없이 변화를 구하며<br>
					고객 가치와 행복, 맛깔스러운 혜택을 제공하는 것입니다.<br> <br> 누구나 즐겁게 즐길 수 있는
					매운 혜택 카드를 소개하고,<br> 무엇보다도 고객의 이득과 만족을 최우선 가치로 여기며,<br>
					신용카드의 새로운 문화를 주도하는 NO.1 브랜드가 되도록 노력하겠습니다.<br> <br> "TEAM
					6 CARD"<br>
				</p>
				<h2
					style="margin-top: 30px; font-size: 2.2rem; color: rgb(41, 39, 37);">HONEST
					CARD FOR YOU</h2>
				<p
					style="font-size: 1.13rem; color: rgb(41, 39, 37); line-height: 45px;">
					"TEAM 6 CARD"는 정직함에서 시작합니다. 고객에게 감동을 줄 때까지 우리는 계속 나아갈 것입니다.<br>
				</p>
			</div>
		</div>
	</div>

	<div id="container">
		<h1
			style="margin-top: 30px; font-size: 3.5rem; color: rgb(41, 39, 37);">오시는길</h1>

		<h2
			style="margin-top: 10px; font-size: 2.2rem; color: rgb(41, 39, 37);">DIRECTIONS
			인사말</h2>

		<div id="map" style="text-align: center;">
			<iframe
				src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d25401.12513699486!2d126.965308979
				10156!3d37.268091900000016!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b431e8d19c
				277%3A0xceb17aba7af9e33d!2z7J207KCg7Lu07ZOo7YSw7JWE7Yq47ZWZ7JuQ!5e0!3m2!1sko!2skr!4v1671947249016!5m2!1sko!2skr"
				width="1140" height="400" style="border: 0;" allowfullscreen=""
				loading="lazy" referrerpolicy="no-referrer-when-downgrade">
			</iframe>
			<div id="addInfo">
				<br>
				<h3
					style="margin-top: 10px; font-size: 1.8rem; color: rgb(41, 39, 37); text-align: left">(주)TEAM6</h3>
				<hr>
				<table style="text-align: left">
					<tr>
						<td style="width: 400px">주소</td>
						<td style="width: 720px">경기도 수원시 매산로1가 11-9 3층 이젠컴퓨터아카데미</td>
					</tr>
					<tr>
						<td>대표번호</td>
						<td>070-6666-6666</td>
					</tr>
					<tr>
						<td>대표 E-MAIL</td>
						<td>TEAM6_CARD@naver.com</td>
					</tr>
				</table>
				<hr>
			</div>
		</div>

	</div>
	<jsp:include page="../footer.html"></jsp:include>
</body>
</html>