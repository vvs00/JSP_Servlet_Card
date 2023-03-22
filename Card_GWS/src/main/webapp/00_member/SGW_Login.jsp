<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="00_member/css/login.css">
<title>로그인</title>
</head>
<body>
	
	<div id="container" class="container">
		<div class="content">
			<div class="login_wrap">
				<form id="frmNIDLogin" name="frmNIDLogin" target="_top" action="member" method="POST">
					<input type="hidden" name="command" value="login">
					<br><br>
                    <div><h2>(주)TEAM 6 금융그룹 통합로그인</h2><br></div>
                    <br><br>
					<ul class="panel_wrap">
						<li class="panel_item" style="display: block;">
							<div class="panel_inner">
								<div class="id_pw_wrap">
									<div class="input_row" id="id_line">
										<div class="icon_cell" id="id_cell">
											<span class="icon_id"> <span class="blind">아이디</span></span>
										</div>
										<input type="text" id="id" name="userid" placeholder="아이디"
											title="아이디" class="input_text" maxlength="41" value="">
									</div>
									<div class="input_row" id="pw_line">
										<div class="icon_cell" id="pw_cell">
											<span class="icon_pw"> <span class="blind">비밀번호</span></span>
										</div>
										<input type="password" id="pw" name="pwd" placeholder="비밀번호" title="비밀번호" class="input_text" maxlength="16">
										
									</div>
								</div>
								
								<div class="btn_login_wrap">
								<div align="center"><span style="color:red"><c:if test="${message ne null}">${message} </c:if></span>
									<br><br><br>
								</div>
									<button type="submit" class="btn_login" id="log.login">
										<span class="btn_text" onclick="return LoginCheck()">로그인</span>
									</button>

								</div>
							</div>
						</li>
					</ul>
				</form>
			</div>
		</div>
		</div>
<script>
		function LoginCheck() {
	if (document.frmNIDLogin.userid.value.length == 0) {
		alert("아이디를 입력하여주세요.");
		return false;
	}
	else if (document.frmNIDLogin.pwd.value.length == "") {
		alert("비밀번호를 입력하세요.");
		return false;
	}
	return true;
    }
    
</script>
</body>
</html>