<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카드 등록</title>
<script type="text/javascript" src="03_card/card_script/card.js"></script>
<link rel="stylesheet" type="text/css" href="03_card/card_css/cardlist.css">
</head>
<body style="background-color: #d3d3d3">
	<div>
		<div id="write_form">
			<form action="card" name="frm" method="get" id="writing_box">
				<p id="write_title">
					카드 등록 <input type="hidden" name="command" value="card_write">
				</p>
				<div id="write_outbox">
					<table border="1" id="write_table">
						<tr></tr>
						<tr>
							<td>이미지</td>
							<td style="text-align: left"><input style="margin-left:20px;" type="file" name="img"></td>
						</tr>
						<tr>
							<td>카드 번호</td>
							<td style="text-align: left"><input style="margin-left:20px;" type="text" size="5" name="num"></td>
						</tr>
						<tr>
							<td>카드 이름</td>
							<td><input type="text" size="50" name="name"></td>
						</tr>
						<tr>
							<td>요약 혜택</td>
							<td><input type="text" size="50" name="info"></td>
						</tr>

						<tr>
							<td>공지</td>
							<td><input type="text" size="50" name="notice"></td>
						</tr>
						<tr>
							<td>연회비</td>
							<td><input type="text" size="50" name="dues"></td>
						</tr>
						<tr>
							<td>기준 실적</td>
							<td><input type="text" size="50" name="performance"></td>
						</tr>
						<tr>
							<td>카드 혜택</td>
							<td><textarea rows="10" cols="50" name="benefits"></textarea></td>
						</tr>
					</table>
				</div>
				<div id="write_buttoncan">
					<br> <br> <input id="write_button" style="margin-right: 50px;" type="submit" value="등록"> <input
						id="write_button" style="margin-right: 50px;" type="reset"
						value="다시 작성"> <input id="write_button" type="button"
						onclick="close_win()" value="닫기">
				</div>
			</form>
		</div>
	</div>
</body>
</html>