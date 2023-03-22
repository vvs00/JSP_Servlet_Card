<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notice 게시글 수정하기</title>
</head>
<body>
	<div id="writeForm" style="width: 1140px; margin: auto;">
		<form method="post" action="notice">
			<input type="hidden" name="command" value="noticeBoardUpdate">
			<input type="hidden" name="userid" value="${loginUser.userid }">
			<input type="hidden" name="num" value="${nbVO.num }">
			<table>
				<tr>
					<th style="width: 200px;">제목</th>
					<td><input type="text" name="title" size="120"
						value=${nbVO.title }></td>
				</tr>
				<tr>
					<th style="width: 200px;">내용</th>
					<td><textarea rows="20" cols="130" name="content">${nbVO.content }</textarea></td>
				</tr>
			</table>
			<br> <br>
			<div id="buttons" style="text-align: center">
				<input type="submit" value="글 수정"> <input type="reset"
					value="글 다시쓰기"> <input type="button" value="글 목록으로 돌아가기"
					onclick="location.href='notice?command=noticeBoardList'">
			</div>
		</form>
	</div>

	<jsp:include page="../footer.html"></jsp:include>
</body>
</html>