<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- 
Developed by SGW on 25th DEC 2022
page: 30mins , JavaScript: 5hrs , CSS : 1hrs
-->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입페이지</title>

<link rel="stylesheet" href="00_member/css/memberJoin.css">
<script type="text/javascript" src="00_member/script/jquery-3.6.3.min.js"></script>

</head>
<body>

<form id="join_form" name="join_form" method="post" action="member">
    <input type="hidden" name="command" value="signup">
    
    <div id="container" role="main">
        <div id="content">
            <div class="join_content">
                <div class="row_group">
                
                    <div class="join_row">
                	<br><br><br><br>
                    <h1>(주)TEAM 6 금융그룹 회원가입</h1>
                    <br>
                        <h3 class="join_title"><label for="id">아이디</label></h3>
                        <span class="ps_box int_id">
							<input type="text" id="userid" name="userid" class="input_id" title="ID" maxlength="20"></span>                        
                        <span class="error_next_box" id="checkId"></span><br>
              
                       
                    </div>
                    <div class="join_row">
                        <h3 class="join_title"><label for="pswd1">비밀번호</label></h3>
                        <span class="ps_box int_pass" id="pswd1Img">
							<input type="password" id="pwd" name="pwd" class="int" title="비밀번호 입력" maxlength="20" onkeyup="pwReg()">
                            <span class="lbl"></span>
                            <span id="pswd1Span" class="step_txt"></span>
                            </span>
                       <span class="error_next_box" id="pwResult1"></span>

                        <h3 class="join_title"><label for="pswd2">비밀번호 재확인</label></h3>
                        <span class="ps_box int_pass_check" id="pswd2Img">
							<input type="password" id="pswd2" name="pwd2" class="int" title="비밀번호 재확인 입력" maxlength="20" onkeyup="pwCheck()">
						</span>
                        <span class="error_next_box" id="pwResult2"></span>
                    </div>
                </div>
                <div class="row_group">
                    <div class="join_row">
                        <h3 class="join_title"><label for="name">이름</label></h3>
                        <span class="ps_box box_right_space">
							<input type="text" id="name" name="name" title="이름" class="int" maxlength="40" onkeyup="nameCheck()">
						</span>
                        <span class="error_next_box" id="nameResult"></span>
                    </div>
                    <div class="join_row join_sex">
                        <h3 class="join_title"><label for="gender">성별<span class="terms_choice">(선택)</span></label></h3>
                        <div class="ps_box gender_code">
                            <select id="gender" name="gender" class="sel" aria-label="성별">
                                <option value="" selected>성별</option>
                                        <option value="M">남자</option>
                                        <option value="F">여자</option>
                            </select>
                        </div>
                    </div>
                    <span class="error_next_box" id="genderMsg" style="display:none" aria-live="assertive"></span>
                    <div class="join_row join_email">
                        <h3 class="join_title"><label for="email">이메일<span class="terms_choice">(선택)</span></label></h3>
                        <span class="ps_box int_email box_right_space">
							<input type="text" id="email" name="email" placeholder="선택입력" aria-label="선택입력" class="int" maxlength="100">
						</span>
                    </div>
                    <span class="error_next_box" id="emailMsg" style="display:none" aria-live="assertive"></span>
                </div>
                    <!-- // 기본적으로 모든 회원가입시 a등급으로 일반회원으로 가입함 b등급은 관리자 -->
                    <input type="hidden" id="lev" name="lev" value="a" checked>
                </div>
                <div class="btn_area">
                  <button type="submit" id="btnJoin" class="btn_type btn_primary" onclick="return SignupCheck()"><span>가입하기</span></button>
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
	if (document.join_form.userid.value.length < 4) {
		alert("아이디는 4글자 이상 입력하세요.");
		return false;
	}
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
	$('.input_id').focusout(function(){
		let userId = $('.input_id').val();
		$.ajax({
			url : "idcheck",
			type : "post",
			data : {userId: userId},
			dataType : 'json',
			success : function(result){
				if(result == 0){
					$("#checkId").html('이미 사용중인 ID입니다.');
					$("#checkId").attr('color','red');
				} else{
					$("#checkId").html('사용할 수 있는 ID입니다.');
					$("#checkId").attr('color','blue');
				} 
			},
			error : function(){
				alert("초비상! 코드오류발생 SGW에게 문의!");
			}
		})
		 
	})
 </script>

</body>
</html>