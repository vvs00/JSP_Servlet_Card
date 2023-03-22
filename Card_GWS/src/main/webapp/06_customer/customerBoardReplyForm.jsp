<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글달기</title>
</head>
<body>
	<div id="writeForm" style="width: 1140px; margin: auto;">
		<form method="post" action="CustomerBoard">
			<input type="hidden" name="command" value="CustomerBoardReplywrite">
			<input type="hidden" name="num" value="${param.num}"> <input
				type="hidden" name="userid" value="${loginUser.userid }">
			<table>
				<tr>
					<th style="width: 200px;">제목</th>
					<td><input type="text" name="title" size="120"></td>
				</tr>
				<tr>
					<th style="width: 200px;">내용</th>
					<td><textarea rows="20" cols="130" name="content"></textarea></td>
				</tr>
			</table>
			<br> <br>
			<div id="buttons" style="text-align: center">
				<input type="submit" value="댓글 등록"> <input type="reset"
					value="다시쓰기"> <input type="button" value="글 목록으로 돌아가기"
					onclick="location.href='CustomerBoard?command=CustomerBoardList'">
			</div>
		</form>
	</div>
	<jsp:include page="../footer.html"></jsp:include>
</body>
</html>