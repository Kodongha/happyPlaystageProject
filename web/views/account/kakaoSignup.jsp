<%@page import="com.kh.hp.account.model.vo.KakaoTokenMngVO"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	HashMap<String, Object> userInfoMap = (HashMap<String, Object>) request.getAttribute("userInfoMap");
	KakaoTokenMngVO kakaoTokenMngVO = (KakaoTokenMngVO) userInfoMap.get("kakaoTokenMngVO");
	System.out.println("kakaoTokenMngVO::" + kakaoTokenMngVO);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

<!-- 리스트 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
div.form-group {
	border: 1px solid #999;
	height: 550px;
	width: 500px;
	padding: 40px 10px 0px 130px;
	border-radius: 10px;
}

.form-group {
	width: 300px;
	height: 50px;
	margin: 0 auto;
}

#signUpBtn a {
	text-decoration: none;
}

h2 {
	text-align: center;
	padding: 20px;
}

#signUpBtn {
	position: relative;
	vertical-align: top;
	width: 100%;
	height: 40px;
	padding: 0;
	font-size: 15px;
	color: black;
	text-align: center;
	text-shadow: 0 1px 2px rgba(0, 0, 0, 0.25);
	background: #FFBF00;
	border: 0;
	border-bottom: 2px solid #FFBF00;
	border-radius: 5px;
	cursor: pointer;
	-webkit-box-shadow: inset 0 -2px #FFBF00;
	box-shadow: inset 0 -2px #FFBF00;
}

input.form-control {
	display: inline-block;
	width: 210px;
	height: 30px;
}

a {
	color: white;
}

table tr td {
	width: 400px;
	padding: 5px;
}

table {
	text-align: left;
}

#inj {
	width: 100px;
}

#injbu {
	width: 100px;
	height: 25px;
}

#hr {
	border-bottom: 1px solid #999;
}

#kakao-login-btn{


}
</style>
<script type="text/javascript">
	//아이디 중복
	$(function(){
		$("#idCheck").click(function(){
			var userEmail = $("#userEmail").val();

			$.ajax({
				url:"<%=request.getContextPath()%>/idCheck.acc",
				type:"post",
				data:{userEmail:userEmail},
				success:function(data){
					console.log(data);
					if(data === "fail"){
						alert("중복된 이메일 입니다.")
					}else{
						alert("사용 가능합니다.")
					}
				},
				error:function(){
					console.log("실패!")
				}
			});
		});
	});

</script>
</head>
<body>
	<jsp:include page="/views/common/header.jsp" />

	<h2>
		<b>카카오 추가 입력 사항</b>
	</h2>

	<form action="<%=request.getContextPath()%>/kakaoSignUp.acc" method="post" name="fr" onsubmit="return check()">
		<div class="form-group">
			<table>
				<tr>
					<td>
						<%if(userInfoMap.get("hasEmail").equals("true")) {%>
						<input class="form-control" id="userEmail" type="email" name="userEmail" placeholder="이메일" value="<%=userInfoMap.get("email")%>" readonly="readonly">
						<%} else { %>
						<input class="form-control" id="userEmail" type="email" name="userEmail" placeholder="이메일">
						<%} %>
					</td>
					<td>
						<%if(!userInfoMap.get("hasEmail").equals("true")) {%>
						<input type="button" value="중복확인" onclick="idCheck" id="idCheck">
						<%}%>
					<td>
				</tr>
				<tr>
					<td><input class="form-control" id="userNm" type="text" name="userNm" placeholder="이름"></td>
				</tr>
				<tr>
					<td><input class="form-control" id="userPhone" type="tel"
						name="userPhone" placeholder="연락처"></td>
				</tr>
				<tr>
					<td><input class="form-control" id="inputdefault"
						type="password" name="cNumber" placeholder="인증번호 6자리 숫자 입력"></td>
					<td id="inj"><input id="injbu" type="button" value="인증번호 받기"></td>
				</tr>
				<tr>
					<td id="hr"><input type="checkbox" name="all"
						class="check-all"> 아래 약관에 모두 동의합니다.</td>
				</tr>
				<tr>
					<td><input type="checkbox" class="ab" id="ab1" name="ab1">
						서비스 이용약관(필수)</td>
				</tr>
				<tr>
					<td><input type="checkbox" class="ab" id="ab2" name="ab2">
						개인정보 처리 방침(필수)</td>
				</tr>
				<tr>
					<td>
						<button id="signUpBtn" type="submit" class="btn btn-default btn-lg btn-block">
							<a>회원가입</a>
						</button>
					</td>
				</tr>
			</table>
		</div>

		<input type="hidden" name="userNick" value="<%=userInfoMap.get("nickname") %>">
		<input type="hidden" name="accessToken" value="<%=userInfoMap.get("accessToken")%>">
		<input type="hidden" name="refreshToken" value="<%=userInfoMap.get("refreshToken")%>">
		<input type="hidden" name="kakaoUnqId" value="<%=userInfoMap.get("id")%>">
		<input type="hidden" name="mailTf" value="<%=userInfoMap.get("hasEmail")%>">

	</form>
	<jsp:include page="/views/common/footer.jsp" />

</body>
</html>