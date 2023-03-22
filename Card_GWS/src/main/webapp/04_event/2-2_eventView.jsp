<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 상세보기</title>
<script type="text/javascript" src="03_card/card_script/card.js"></script>
<style type="text/css">
#event th {
	width: 200px;
}
</style>

</head>
<body>
	<div>
		<table id="event">

			<tr>
				<td style="text-align: center" colspan="2"><img
					src="./img/${event.eventSpotImg}" style="width: 100%;"></td>
			</tr>
			<tr>
				<th>이벤트 기간</th>
				<td>${event.eventCal}</td>
			</tr>
			<tr>
				<th>이벤트 혜택</th>
				<td>${event.eventBen}</td>
			</tr>
			<tr>
				<th>이벤트 대상</th>
				<td>${event.eventTar}</td>
			</tr>
			<tr>
				<th>이벤트 적립</th>
				<td>${event.eventPay}</td>
			</tr>

		</table>
		<br> <br>
		<div style="text-align: center">
				<input type="button" onclick="window.close();" value="창닫기">
			<c:if test="${loginUser.lev eq 'b' }">
				<input type="button" onclick="location.href='event?command=events_update_form&num=${event.eventNum}'" value="수정">
				<input type="button" onclick="location.href='event?command=events_delete&num=${event.eventNum}'" value="삭제">
			</c:if>
		</div>
	</div>

</body>
</html>