<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="a_00_member.DAO.MemberDAO" %>



<!DOCTYPE html>
<html>
<head>
<title>회원탈퇴(SGW_Delete.jsp)</title>
<link rel="stylesheet" href="00_member/css/memberJoin.css">
</head>
<body>

    <form id="deleteform" name="deleteform" method="post" action="member" onsubmit="return checkPwd()">
    <input type="hidden" name="command" value="delete">
    <div id="container" role="main">
        <div id="content">
            <div class="join_content">
                <div class="row_group">
                    <div class="join_row">
                    <h1>(주)TEAM 6 금융그룹 회원탈퇴</h1>
                        <h3 class="join_title"><label for="id">아이디</label></h3>
							<h2>${loginUser.userid}</h2>
							<input type="hidden" name="userid" value="${loginUser.userid }">
                    </div>
                    <div class="join_row">
                        <h3 class="join_title"><label for="pswd1">비밀번호</label></h3>
                        <span class="ps_box int_pass" id="pswd1Img">
							<input type="password" id="pwd" name="pwd" class="int" title="비밀번호 입력" maxlength="20">
                            </span>
                    </div>
                </div>
                

                <div class="btn_area double">
                        <span><a href="#" id="btnCancel" class="btn_type btn_default" role="button" onclick="location.replace('index.jsp');">취소</a></span>
                        <!-- <span><a href="#" id="btnDelete" type="submit" class="btn_type btn_primary" role="button" >회원탈퇴</a></span> -->
                        <span class="btn_type btn_primary"><button type="submit" style="background:#03c75a; font-size:1em; font-color:white">회원탈퇴</button></span>
                </div>
               ${msg}   
              
            </div>
        </div>
    </div>
</form>

</body>
<script>
	function checkPwd(){
		pwd = document.getElementById('pwd');
		
		if(pwd.value == ""){
			alert('비밀번호를 입력하여 주세요.');
			return;
		}

	}
</script>
</html>