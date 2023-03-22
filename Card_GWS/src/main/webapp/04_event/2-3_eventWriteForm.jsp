<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 등록 입니다</title>
<script type="text/javascript" src="03_card/card_script/card.js"></script>
<link rel="stylesheet" type="text/css"
	href="03_card/card_css/cardlist.css">
</head>
<body style="background-color: #d3d3d3">
	<div>
		<div id="write_form">
			<form action="event" name="frm" method="get" id="writing_box">
				<p id="write_title">
					새로운 이벤트 등록 <input type="hidden" name="command" value="events_write">
				</p>
				<div id="write_outbox">
					<table border="1" id="write_table">
						<tr></tr>
						<tr>
							<th>이벤트 번호</th>
							<td style="text-align: left"><input
								style="margin-left: 40px;" size="5" name="eventNum"></td>
						</tr>
						<tr>
							<th>카드 이미지</th>
							<td style="text-align: left"><input
								style="margin-left: 40px;" type="file" size="30"
								name="eventCardImg"></td>
						</tr>

						<tr>
							<th>이벤트 이미지</th>
							<td style="text-align: left"><input
								style="margin-left: 40px;" type="file" size="30"
								name="eventSpotImg"></td>
						</tr>


						<tr>
							<th>이벤트 카드 명칭</th>
							<td><input type="text" size="30"
								name="eventName"></td>
						</tr>
						<tr>
							<th>이벤트 요약 설명</th>
							<td><input type="text" size="30" name="eventInfo"></td>
						</tr>
						<tr>
							<th>이벤트 기간</th>
							<td><input type="text" size="30" name="eventCal"></td>
						</tr>
						<tr>
							<th>이벤트 혜택</th>
							<td><input type="text" size="30" name="eventBen"></td>
						</tr>
						<tr>
							<th>이벤트 대상</th>
							<td><input type="text" size="30" name="eventTar"></td>
						</tr>
						<tr>
							<th>포인트 지급 예정일</th>
							<td><input type="text" size="30" name="eventPay"></td>
						</tr>
					</table>
				</div>
				<div id="write_buttoncan">
					<input id="write_button" type="submit" value="등록"> <input
						id="write_button" type="reset" value="다시 작성"> <input
						id="write_button" type="button" onclick="close_win()" value="닫기">
				</div>
			</form>
		</div>
	</div>
</body>
</html>