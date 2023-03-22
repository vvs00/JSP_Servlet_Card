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
<link rel="stylesheet" type="text/css" href="07_wishlist/css/wishlist.css">
<title>장바구니-wishlist</title>
</head>
<!-- 연정 추가 -->
<script>
var message = "<c:out value='${alertMessage}'/>";
if(message != ''){
	alert(message);
}

function deleteConfirm(cardnum){
	if(confirm('정말 삭제하시겠습니까?')){
		window.location.href = "Wishlist?command=wishlistDelete&num="+cardnum;	
	}
}


</script>
<!-- 연정 추가 -->
<body>

	<div id="wrap">
		<h1 id="title">My WishList</h1>
		<div id="wishList" >
			<c:choose>
				<c:when test="${loginUser != null}">
					<c:forEach var="card" items="${cardlist}">
						<div class="card">
							<img alt="이미지" src="./img/${card.img}">
							<p class="cardname">${card.name}</p>
							<p>${card.info}</p>
							<p>${card.notice}</p>
							<p>${card.dues}</p>
							<p>${card.performance}</p>
							<input style="" class="delbutton" type="button" onclick="deleteConfirm(${card.num});"
							value="삭제">
							<br><br><br><br><br>
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<h1>현재 로그인되어있지 않습니다.</h1>
				</c:otherwise>
			</c:choose>
		</div>
	</div>

	<jsp:include page="../footer.html"></jsp:include>

</body>
</html>