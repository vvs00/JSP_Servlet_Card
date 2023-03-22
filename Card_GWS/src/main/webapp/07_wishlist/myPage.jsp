
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="07_wishlist/css/shopping.css">
<link rel="stylesheet" type="text/css" href="07_wishlist/css/myPage.css">
</head>
<body>

	<div id="wrap">
		<h1 id="title">마이페이지</h1>
		<div id="wishList">
			<c:choose>
				<c:when test="${loginUser != null}">
					<div id="mypage_div">
						<input class="mypagebutton" type="button"
							onclick="location.href='Wishlist?command=wishlist'" value="장바구니">
						<input class="mypagebutton" type="button"
							onclick="location.href='member?command=modifyform&userid=${loginUser.userid}'"
							value="개인정보수정">
					</div>
				</c:when>
				<c:otherwise>
					<h1>현재 로그인되어있지 않습니다.</h1>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<jsp:include page="../footer.html"></jsp:include>

</body>