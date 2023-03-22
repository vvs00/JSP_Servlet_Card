<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객게시판</title>
<style type="text/css">
	#customerBoardView th{
		width:100px;
	}
	#customerBoardView td{
		text-align:center;
	}
	#cvboard{
		width:1140px;
		margin:auto;
	}
</style>
</head>

<body>
	
		<div id="cvboard">
	<table id="customerBoardView">
		<tr>			 
			<th>번호</th>
			<td style="width:50px">${cbVO.num}</td>

			<th>제목</th>
			<td>${cbVO.title}</td>

			<th>작성자</th>
			<td style="width:50px">${cbVO.userid}</td>

			<th>조회수</th>
			<td style="width:50px">${cbVO.readcount }</td>
			
			<th>작성일</th>
			<td style="width:100px"><fmt:formatDate value="${cbVO.date}" pattern="yyyy-MM-dd hh:mm" /></td>
		<tr>			
			<th>내용</th>
			
			<td colspan="9" style="height:600px">
				${cbVO.content}
			</td>
		</tr>
	</table>
	</div>
	
	<div id="buttons" style="text-align:center">
		<input type="button" value="댓글달기" onclick="location.href='CustomerBoard?command=CustomerBoardReplyForm&num=${cbVO.num}'">
		<c:if test="${loginUser.lev eq 'b' && cbVO.deleted ne 'y' }">
			<input type="button" value="블라인드하기" onclick="if(confirm('블라인드처리 하시겠습니까?')){location.href='CustomerBoard?command=CustomerBoardBlind&num=${cbVO.num}'}">
		</c:if>
		<c:if test="${loginUser.userid eq cbVO.userid}">
			<input type="button" value="수정하기" onclick="location.href='CustomerBoard?command=CustomerBoardUpdateForm&num=${cbVO.num}'">
			<input type="button" value="삭제하기" onclick="if(confirm('삭제하시겠습니까?')){location.href='CustomerBoard?command=CustomerBoardDelete&num=${cbVO.num}'}">
		</c:if>
		<input type="button" value="글 목록으로 돌아가기" onclick="location.href='CustomerBoard?command=CustomerBoardList'">
	</div>
	<br>
	<br>
	<jsp:include page="../footer.html"></jsp:include>

</body>
</html>