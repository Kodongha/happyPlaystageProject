<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

<!-- 리스트 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>

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

<script>
	//체크박스 all
	$(document).ready(function() {
		$('.check-all').click(function() {
			$('.ab').prop('checked', this.checked);
		});
	});

	//유효성
	function check() {
		if (fr.userPwd.value != fr.userPwd2.value) {
			alert("비밀번호를 다르게 입력하셨습니다.");
			return false;
		}

		if (fr.userEmail.value == "" || fr.userPwd.value == ""
				|| fr.userPwd2.value == "" || fr.userNm.value == ""
				|| fr.userNick.value == "" || fr.userPhone.value == ""
				|| fr.ab1.checked == false || fr.ab2.checked == false) {
			alert("모두 입력하세요.");
			if (fr.userEmail.value == "") {
				fr.userEmail.focus();
			}
			if (fr.userPwd.value == "") {
				fr.userPwd.focus();
			}
			if (fr.userPwd2.value == "") {
				fr.userPwd2.focus();
			}
			if (fr.userNm.value == "") {
				fr.userNm.focus();
			}
			if (fr.userNick.value == "") {
				fr.userNick.focus();
			}
			if (fr.userPhone.value == "") {
				fr.userPhone.focus();
			}
			if (fr.ab1.checked){

			}
			if (fr.ab2.checked){

			}

			console.log(fr.ab1.checked);

			return false;

		} else {
			return true;
		}

	};

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
		<b>회원가입</b>
	</h2>

	<form action="<%=request.getContextPath()%>/signUp.acc" method="post"
		name="fr" onsubmit="return check()">
		<div class="form-group">
			<table>
				<tr>
					<td><input class="form-control" id="userEmail" type="email"
						name="userEmail" placeholder="이메일"></td>
					<td><input type="button" value="중복확인" onclick="idCheck"
						id="idCheck">
					<td>
				</tr>
				<tr>
					<td><input class="form-control" id="userPwd" type="password"
						name="userPwd" placeholder="비밀번호"></td>
				</tr>
				<tr>
					<td><input class="form-control" id="userPwd2" type="password"
						name="userPwd2" placeholder="비밀번호 확인"></td>
				</tr>
				<tr>
					<td><input class="form-control" id="userNm" type="text"
						name="userNm" placeholder="이름"></td>
				</tr>
				<tr>
					<td><input class="form-control" id="userNick" type="text"
						name="userNick" placeholder="닉네임"></td>
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
						<button id="signUpBtn" type="submit"
							class="btn btn-default btn-lg btn-block">
							<a>회원가입</a>
						</button>
					</td>

				</tr>
			</table>
				<div>
					<a id="kakao-login-btn"></a>
   					 <a href="http://developers.kakao.com/logout"></a>

				</div>
		</div>

	</form>
 	<script type='text/javascript'>

        // 사용할 앱의 JavaScript 키를 설정해 주세요.
        Kakao.init('d371ecdcb455e35b072949c209feab4b');
        // 카카오 로그인 버튼을 생성합니다.
        Kakao.Auth.createLoginButton({
          container: '#kakao-login-btn',
          success: function(authObj) {
            alert(JSON.stringify(authObj));
          },
          fail: function(err) {
             alert(JSON.stringify(err));
          }
        });

    </script>
	<jsp:include page="/views/common/footer.jsp" />

</body>
</html>