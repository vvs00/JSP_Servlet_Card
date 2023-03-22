<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <link rel="stylesheet" type="text/css" href="css/shopping.css">
   <link rel="stylesheet" type="text/css" href="css/header.css">
</head>
<body>
   <div id="header">
      <div id="header_wrap">
      
         <a href ="main"> 
          <img id="logo" src="https://ai.esmplus.com/zkzkzj/TEAM6/%EB%A1%9C%EA%B3%A02.png" alt="로고">
         </a>
         
         <div id="div_login">
         	<c:if test="${loginUser == null}">
            <a href="member?command=login">로그인</a>
            <span style="display:inline-block;width:1px; height:20px;background-color:#8c6239;vertical-align:middle;"></span>
            <a href="member?command=terms">회원가입</a>
         	</c:if>
         	<c:if test="${loginUser != null}">
         	<div style="font-size:20px;">${loginUser.name }님 환영합니다!</div> 
            <a href="Wishlist?command=myPageAction">마이페이지</a>
            <span style="display:inline-block;width:1px; height:20px;background-color:#8c6239;vertical-align:middle;"></span>
         	<a href="member?command=logout">로그아웃</a>
         	</c:if>
         </div>
         <div id="div_menu">
            <a class="nav-link" href="intro?command=intropage" style="padding-left:0px;">회사소개</a>
            <a class="nav-link" href="card?command=card_list">신용카드</a>
            <a class="nav-link" href="event?command=events_list">이벤트</a>
            <a class="nav-link" href="notice?command=noticeBoardList">공지사항</a>
            <a class="nav-link" href="CustomerBoard?command=CustomerBoardList">고객 게시판</a>
         </div>
      </div>
   </div>
</body>
</html>