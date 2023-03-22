<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- 
Developed by SGW on 26th DEC 2022
page: 30mins , JavaScript: 3hrs , CSS : 2hrs
-->

<html>
<head>
<title>이용약관 페이지(SGW_Terms.jsp)</title>
<meta charset="UTF-8">
<link rel="stylesheet" href="00_member/css/terms.css">
<script defer src="00_member/script/terms.js"></script>
</head>

<body>
	<div class="wrap">
		<div class="logo">
			<h2>(주)TEAM 6 금융그룹 회원가입</h2>
		</div>
		<div class="contents">
			<form action="#" method="POST" id="form__wrap">
				<div class="terms__check__all">
					<input type="checkbox" name="checkAll" id="checkAll"> <label
						for="checkAll">(주)TEAM 6 금융그룹 회원가입 이용약관,
						개인정보 수집 및 이용, <br>프로모션 정보 수신(선택)에 모두 동의합니다.
					</label>
				</div>
				<ul class="terms__list">
					<li class="terms__box">
						<div class="input__check">
							<input type="checkbox" name="agreement" id="termsOfService"
								value="termsOfService" required> <label
								for="termsOfService" class="required">(주)TEAM 6 금융그룹 회원가입
								이용약관 동의</label>
						</div>
						<div class="terms__content">(주)TEAM 6 금융그룹 서비스 및 제품(이하
							‘서비스’)을 이용해 주셔서 감사합니다. 본 약관은 다양한 (주)TEAM 6 금융그룹 서비스의 이용과 관련하여 (주)TEAM 6 금융그룹 회원가입 서비스를 제공하는
							(주)TEAM 6 금융그룹(이하 ‘TEAM 6’)와 이를 이용하는 (주)TEAM 6 금융그룹 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를
							설명하며, 아울러 여러분의 TEAM 6 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다. TEAM 6 서비스를
							이용하시거나 TEAM 6 서비스 회원으로 가입하실 경우 여러분은 본 약관 및 관련 운영 정책을 확인하거나 동의하게 되므로,
							잠시 시간을 내시어 주의 깊게 살펴봐 주시기 바랍니다.</div>
					</li>
					<li class="terms__box">
						<div class="input__check">
							<input type="checkbox" name="agreement" id="privacyPolicy"
								value="privacyPolicy" required> <label
								for="privacyPolicy" class="required">개인정보 수집 및 이용 동의</label>
						</div>
						<div class="terms__content">개인정보보호법에 따라 TEAM 6에 회원가입 신청하시는 분께
							수집하는 개인정보의 항목, 개인정보의 수집 및 이용목적, 개인정보의 보유 및 이용기간, 동의 거부권 및 동의 거부 시
							불이익에 관한 사항을 안내 드리오니 자세히 읽은 후 동의하여 주시기 바랍니다.1. 수집하는 개인정보 이용자는
							회원가입을 하지 않아도 카드검색, 대출금리 보기 등 대부분의 TEAM 6 서비스를 회원과 동일하게 이용할 수 있습니다.
							이용자가 카드, 대출, 보험 등과 같이 개인화 혹은 회원제 서비스를 이용하기 위해 회원가입을 할 경우,
							TEAM 6는 서비스 이용을 위해 필요한 최소한의 개인정보를 수집합니다.</div>
					</li>
					<li class="terms__box">
						<div class="input__check">
							<input type="checkbox" name="agreement" id="allowPromotions"
								value="allowPromotions"> <label
								for="allowPromotions">프로모션 정보 수신 동의</label>
						</div>
						<div class="terms__content">TEAM 6에서 제공하는 이벤트/혜택 등 다양한 정보를
							휴대전화(TEAM 6앱 알림 또는 문자), 이메일로 받아보실 수 있습니다. 일부 서비스(별도 회원 체계로 운영하거나 TEAM 6
							가입 이후 추가 가입하여 이용하는 서비스 등)의 경우, 개별 서비스에 대해 별도 수신 동의를 받을 수 있으며,
							이때에도 수신 동의에 대해 별도로 안내하고 동의를 받습니다.</div>
					</li>
				</ul>
				<button type="submit" class="next-button" disabled onclick="location.replace('member?command=signupform');">확인</button>
			</form>
		</div>
	</div>
</body>
</html>
