<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NOTICE BOARD</title>
<style type="text/css">
	#noticeBoardView th{
		width:100px;
	}
	#noticeBoardView td{
		text-align:center;
	}
	#nvboard{
		width:1140px;
		margin:auto;
	}
</style>
</head>
<body>
<div id="nvboard">
	<table id="noticeBoardView">
		<tr>			 
			<th>번호</th>
			<td style="width:50px">${nbVO.num}</td>

			<th>제목</th>
			<td>${nbVO.title}</td>

			<th>작성자</th>
			<td style="width:50px">${nbVO.userid}</td>

			<th>조회수</th>
			<td style="width:50px">${nbVO.readcount }</td>
			
			<th>작성일</th>
			<td style="width:100px"><fmt:formatDate value="${nbVO.writedate}" pattern="yyyy-MM-dd hh:mm" /></td>
		<tr>			
			<th>내용</th>
			
			<td colspan="9" style="height:600px">
				${nbVO.content}
			</td>
		</tr>
	</table>
	</div>
	
	<div id="buttons" style="text-align:center">
		<c:if test="${loginUser.userid eq nbVO.userid}">
			<input type="button" value="수정하기" onclick="location.href='notice?command=NoticeBoardUpdateForm&num=${nbVO.num}'">
			<input type="button" value="삭제하기" onclick="if(confirm('삭제하시겠습니까?')){location.href='notice?command=NoticeBoardDelete&num=${nbVO.num}'}">
		</c:if>
		<input type="button" value="글 목록으로 돌아가기" onclick="location.href='notice?command=noticeBoardList'">
	</div>
	<br>
	<br>
	<jsp:include page="../footer.html"></jsp:include>
</body>
</html>