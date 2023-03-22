<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 정보 수정</title>
<link rel="stylesheet" type="text/css"
	href="03_card/card_css/cardlist.css">
<script type="text/javascript" src="03_card/card_script/card.js"></script>
</head>
<body style="background-color: #d3d3d3">
	<div>
		<div id="write_form">
			<form action="event" name="frm" method="get" id="writing_box">
				<p id="write_title">이벤트 정보 수정</p>
				<input type="hidden" name="command" value="events_update"> <input
					type="hidden" name="num" value="${list.eventNum}"> <input
					type="hidden" name="eventCardImg" value="${list.eventCardImg}">
				<input type="hidden" name="eventSpotImg"
					value="${list.eventSpotImg}">
				<div id="write_outbox">
					<table border="1" id="write_table">
						<tr>
							<th>이벤트 카드 이미지</th>
							<td style="text-align: left"><input
								style="margin-left: 4px;" type="file" size="30"
								name="newCardImg"></td>
						</tr>
						<tr>
							<th>이벤트 이미지</th>
							<td style="text-align: left"><input
								style="margin-left: 4px;" type="file" size="30"
								name="newSpotImg"></td>
						</tr>
						<tr>
							<th>이벤트 카드 이름</th>
							<td><input type="text" size="50" name="eventName"
								value="${list.eventName}"></td>
						</tr>

						<tr>
							<th>이벤트 혜택 요약</th>
							<td><input type="text" size="50" name="eventInfo"
								value="${list.eventInfo}"></td>
						</tr>

						<tr>
							<th>이벤트 기간</th>
							<td><input type="text" size="50" name="eventCal"
								value="${list.eventCal}"></td>
						</tr>

						<tr>
							<th>이벤트 혜택</th>
							<td><textarea rows="5" cols="50" name="eventBen">${list.eventBen}</textarea>
						</tr>

						<tr>
							<th>이벤트 대상</th>
							<td><textarea rows="5" cols="50" name="eventTar">${list.eventTar}</textarea>
						</tr>

						<tr>
							<th>포인트 지급 예정일</th>
							<td><textarea rows="5" cols="50" name="eventPay">${list.eventPay}</textarea>
						</tr>


					</table>
				</div>
				<div id="write_buttoncan">
					<input id="write_button" type="submit" value="등록"> <input
						id="write_button" type="reset" value="다시 작성"> <input
						id="write_button" type="button" onclick="history.go(-1);"
						value="목록">
				</div>
			</form>
		</div>
	</div>
</body>
</html>