<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카드 수정</title>
<script type="text/javascript" src="03_card/card_script/card.js"></script>
<link rel="stylesheet" type="text/css"
	href="03_card/card_css/cardlist.css">
</head>
<body style="background-color: #d3d3d3">
	<div>
		<div id="write_form">
			<form action="card" method="get" id="writing_box">
				<p id="write_title">카드 정보 수정</p>
				<input type="hidden" name="command" value="card_update"> <input
					type="hidden" name="num" value="${card.num}"> <input
					type="hidden" name="img" value="${card.img}">
				<div id="write_outbox">
					<table border="1" id="write_table">
						<tr>
							<th>카드 이미지</th>
							<td style="text-align: left"><input style="margin-left:11px;" type="file" size="30" name="newimg"></td>
						</tr>
						<tr>
							<th>카드 이름</th>
							<td style="text-align: left"><input style="margin-left:11px;"  type="text" size="30" name="name"
								value="${card.name}"></td>
						</tr>
						<tr>
							<th>요약 해택</th>
							<td><input type="text" size="50" name="info"
								value="${card.info}"></td>
						</tr>

						<tr>
							<th>공지</th>
							<td><input type="text" size="50" name="notice"
								value="${card.notice}"></td>
						</tr>
						<tr>
							<th>연회비</th>
							<td><input type="text" size="50" name="dues"
								value="${card.dues}"></td>
						</tr>
						<tr>
							<th>기준 실적</th>
							<td><input type="text" size="50" name="performance"
								value="${card.performance}"></td>
						</tr>
						<tr>
							<th>카드 해택</th>
							<td><input type="text" size="50" name="benefits"
								value="${card.benefits}"></td>
						</tr>
						<tr>
						</tr>
					</table>
				</div>
				<div id="write_buttoncan">
					<br> <br> <input id="write_button"  type="submit" value="등록" > <input id="write_button" 
						type="reset" value="다시 작성"> <input id="write_button"  type="button"
						onclick="history.go(-1);" value="목록">
				</div>
			</form>
		</div>
	</div>
</body>
</html>
