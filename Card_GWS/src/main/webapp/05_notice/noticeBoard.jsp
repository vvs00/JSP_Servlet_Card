<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항게시판</title>
<style type="text/css">
#noticeBoardList td {
	text-align: center;
}

#Cboard {
	width: 1140px;
	margin: auto;
}
#listbox {
	font-size: 50px;
	font-weight: 600;
	line-height: 50px;
	text-align: center;
	line-height: 140px;
}

</style>
</head>
<body>
	<div id="Cboard" align="center">
	<div id="listbox">
		<h1 style="color: orange; min-width: 1000px; margin:auto;">NOTICE</h1>
	</div>
	<br><br>
		<table id="noticeBoardList">
			<tr>
			<c:if test="${loginUser.lev eq 'b'}">
				<td colspan="4" style="border: white; text-align: right"><a href="notice?command=noticeBoardWriteForm">게시글 등록</a></td>
			</c:if>
			</tr>
			<tr>
				<th style="width: 50px;">번호</th>
				<th>제목</th>
				<th style="width: 100px;">작성자</th>
				<th style="width: 100px;">작성일</th>
				<th style="width: 50px;">조회</th>
			</tr>
			<c:forEach var="list" items="${list}">
				<tr>
					<td>${list.num }</td>
					<td style="text-align:left">&nbsp;&nbsp;
						<a href="notice?command=noticeBoardView&num=${list.num }">${list.title }</a>					
					</td>
					<td>${list.userid }</td>
					<td><fmt:formatDate value="${list.writedate }" pattern="yyyy-MM-dd hh:mm" /></td>
					<td>${list.readcount }</td>
				</tr>
			</c:forEach>
		</table>
	</div>	
	<br><br><br>
		<jsp:include page="../footer.html"></jsp:include>
</body>
</html>

