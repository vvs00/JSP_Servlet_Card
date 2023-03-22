<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객게시판</title>
<style type="text/css">
#customerBoardList td {
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
	<div id="Cboard">
	<div id="listbox">
		<h1 style="color: orange; min-width: 1000px; margin:auto;">고객 게시판</h1>
	</div>
	<br><br>
		<table id="customerBoardList">
			<tr>
				<th style="width: 50px;">번호</th>
				<th>제목</th>
				<th style="width: 100px;">작성자</th>
				<th style="width: 100px;">작성일</th>
				<th style="width: 50px;">조회</th>
			</tr>
			<c:forEach var="list" items="${CustomerBoardlist}">
				<tr>
					<td>${list.num }</td>

					<c:if test="${list.blevel==0 }">

						<c:if test="${list.blind eq 'n' && list.deleted eq 'n' }">
							<td style="text-align: left"><a
								href="CustomerBoard?command=cutomerBoardView&num=${list.num}">${list.title }</a></td>
						</c:if>


						<c:if test="${list.blind eq 'y' }">
							<td style="text-align: left; color: red;">"운영자에 의해 블라인드 처리된
								글입니다." 
								<c:if test="${loginUser.lev eq 'b' }">
									<a href="CustomerBoard?command=blindRelease&num=${list.num}"
										style="color: blue;"> &nbsp;&nbsp;&nbsp; >>블라인드 해제하기</a>
								</c:if>
							</td>
						</c:if>

						<c:if test="${list.deleted eq 'y' }">
							<td style="text-align: left; color: red;">"작성자가 삭제한 글입니다." 
							<c:if test="${loginUser.lev eq 'b' }">
									<a href="CustomerBoard?command=cutomerBoardView&num=${list.num}"
										style="color: blue;"> &nbsp;&nbsp;&nbsp; >>글확인하기</a>
							</c:if>
							</td>
						</c:if>

						<td>${list.userid }</td>
						<td><fmt:formatDate value="${list.date }"
								pattern="yyyy-MM-dd hh:mm" /></td>
						<td>${list.readcount }</td>
					</c:if>

					<c:if test="${list.blevel>0 }">

						<c:if test="${list.blind eq 'n' && list.deleted eq 'n'}">
							<td style="text-align: left"><a
								href="CustomerBoard?command=cutomerBoardView&num=${list.num}">
									<c:forEach begin="1" end="${list.blevel}">
										<span style="padding-left: 15px"></span>
									</c:forEach> [RE]${list.title }
							</a></td>
						</c:if>

						<c:if test="${list.blind eq 'y' }">
							<td style="text-align: left; color: red;">"운영자에 의해 블라인드 처리된
								글입니다." <c:if test="${loginUser.lev eq 'b' }">
									<a href="CustomerBoard?command=blindRelease&num=${list.num}"
										style="color: blue;"> &nbsp;&nbsp;&nbsp; >>블라인드 해제하기</a>
								</c:if>
							</td>
						</c:if>

						<c:if test="${list.deleted eq 'y' }">
							<td style="text-align: left; color: red;">"작성자가 삭제한 글입니다." <c:if
									test="${loginUser.lev eq 'b' }">
									<a
										href="CustomerBoard?command=cutomerBoardView&num=${list.num}"
										style="color: blue;"> &nbsp;&nbsp;&nbsp; >>글확인하기</a>
								</c:if>
							</td>
						</c:if>


						<td>${list.userid }</td>
						<td><fmt:formatDate value="${list.date }"
								pattern="yyyy-MM-dd hh:mm" /></td>
						<td>${list.readcount }</td>
					</c:if>

				</tr>
			</c:forEach>

		</table>
	</div>
	<div id="buttons"
		style="width: 1140px; margin: auto; text-align: center;">
		
		<br>
		<br> <input type="button" value="글쓰기"
			onclick="location.href='CustomerBoard?command=CustomerBoardWriteForm'">
		<br><br><br>
	</div>
	
		<jsp:include page="../footer.html"></jsp:include>
	
</body>
</html>