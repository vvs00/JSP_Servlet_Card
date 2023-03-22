<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정페이지(SGW_Modify.jsp)</title>

<link rel="stylesheet" href="00_member/css/memberJoin.css">
<script type="text/javascript" src="#"></script>
</head>
<body>

	<form name="join_form" method="post" action="member">
		<input type="hidden" name="command" value="modify">
		<div id="container" role="main">
			<div id="content">
				<div class="join_content">
					<div class="row_group">

						<div class="join_row">
							<h1>(주)TEAM 6 금융그룹 회원정보수정</h1>
							<h3 class="join_title">
								<label for="id">아이디</label>
							</h3>
							<h2>${member.userid}</h2>
							<input type="hidden" name="userid" value="${loginUser.userid }">
						</div>

						<div class="join_row">
							<h3 class="join_title">
								<label for="pswd1">비밀번호</label>
							</h3>
							<span class="ps_box int_pass" id="pswd1Img"> <input
								type="password" id="pwd" name="pwd" class="int" title="비밀번호 입력"
								maxlength="20" onkeyup="pwReg()"> <span class="lbl"></span>
								<span id="pswd1Span" class="step_txt"></span>
							</span> <span class="error_next_box" id="pwResult1"></span>

							<h3 class="join_title">
								<label for="pswd2">비밀번호 재확인</label>
							</h3>
							<span class="ps_box int_pass_check" id="pswd2Img"> <input
								type="password" id="pswd2" name="pwd2" class="int"
								title="비밀번호 재확인 입력" maxlength="20" onkeyup="pwCheck()">
							</span> <span class="error_next_box" id="pwResult2"></span>
						</div>
					</div>

					<div class="row_group">
						<div class="join_row">
							<h3 class="join_title">
								<label for="name">이름</label>
							</h3>
							<h2>${member.name}</h2>
							<input type="hidden" name="name" value="${loginUser.name }">
						</div>


						<div class="join_row join_sex">
							<h3 class="join_title">
								<label for="gender">성별</label>
							</h3>
							<div class="ps_box gender_code">
								<select id="gender" name="gender" class="sel" aria-label="성별">
									<option value="" selected>성별</option>
									<option value="m">남자</option>
									<option value="f">여자</option>
								</select>
							</div>
						</div>
						<div class="join_row join_email">
							<h3 class="join_title">
								<label for="email">이메일<span class="terms_choice">(선택)</span></label>
							</h3>
							<span class="ps_box int_email box_right_space"> <input
								type="text" id="email" name="email" class="int" maxlength="100"
								value="${member.email}">
							</span>
						</div>
						<input type="hidden" id="lev" name="lev" value="a" checked>
						<!-- // 관리자등급인 b만 회원등급메뉴가 보임 -->
						<c:if test="${loginUser.lev =='b' }">
						<div class="join_row join_sex">
							<h3 class="join_title">
								<label for="gender">회원등급</label>
							</h3>
							<div class="ps_box gender_code">
								<select id="gender" name="lev" class="sel" aria-label="회원등급">
									<option value="" selected>회원등급</option>
									<option value="a">일반회원</option>
									<option value="b">관리자</option>
								</select>
							</div>
						</div>
						</c:if>
						
					</div>
				</div>


				<div class="btn_area double">
					<span><a href="#" id="btnCancel" class="btn_type btn_default" role="button" onclick="location.href='member?command=deleteform';">회원탈퇴</a></span>
					<!-- <span><a href="#" id="btnAgree" type="submit" class="btn_type btn_primary" role="submit" onclick="return SignupCheck()">정보수정</a></span> -->
					<span class="btn_type btn_primary"><button style="background:#03c75a; font-size:1em; font-color:white" type="submit" onclick="return SignupCheck()">수정하기</button></span>
				</div>


			</div>
		</div>

	</form>

	<script>
	function pwReg(){
		let pwd = document.getElementById("pwd").value;
		let pwResult1 = document.getElementById("pwResult1");
		
		let num = pwd.search(/[0-9]/);
		let eng = pwd.search(/[a-z]/);
		let spe = pwd.search(/[~!@#$%^&*|\\\'\":l\/?]/);
		let spc = pwd.search(/\s/);
		
		console.log('숫자 :' + num);
		console.log('영문 :' + eng);
		console.log('특수문자 :' + spe);
		console.log('공백 :' + spc);
		
		if(pwd.length < 4 || pwd.length > 16){
			pwResult1.style.color = "#ff0000";
			pwResult1.innerHTML = "비밀번호는 4자리에서 16자리 이내로 입력해주세요"
			return false;
		}else if(pwd.search(/\s/) != -1){
			pwResult1.style.color = "#ff0000";
			pwResult1.innerHTML = "비밀번호는 공백없이 입력해주세요 "
				return false;
		}
		else if(num< 0 || eng < 0 ){
			pwResult1.style.color = "#ff0000";
			pwResult1.innerHTML = "영문, 숫자를 혼합하여 입력해주세요."
				return false;
		}
		
		else{
			pwResult1.style.color = "#0000ff";
			pwResult1.innerHTML = "사용가능한 비밀번호입니다"
			return true;
		}
		
	}
	
function pwCheck(){
	let pwd = document.getElementById("pwd").value;
	let pswd2 = document.getElementById("pswd2").value;
	let pwResult2 = document.getElementById("pwResult2");
	
	if(pwd == pswd2){
		pwResult2.style.color = "#0000ff";
		pwResult2.innerHTML = "비밀번호가 일치합니다"
		return true;
} else{
	pwResult2.style.color = "#ff0000";
	pwResult2.innerHTML = "비밀번호가 일치하지 않습니다"
	return false;
	}
}	

function SignupCheck() {
	if (document.join_form.pwd.value.length < 4) {
		alert("비밀번호는 4자리 이상 입력하세요.");
		return false;
	}
	if (document.join_form.pwd.value != document.join_form.pwd2.value) {
		alert("비밀번호가 일치하지 않습니다.");
		return false;
	}
	if (document.join_form.name.value.length == 0) {
		alert("실명을 입력하여 주세요");
		return false;
	}
	
	return true;
    }
    
</script>
</body>
</html>