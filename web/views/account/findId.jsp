<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
table {
	margin: auto;
	padding: 40px;
}

h3 {
	text-align: center;
}

h5 {
	text-align: center;
}

#findid1 {
	width: 700PX;
	text-align: center;
	display: inline-block;
	height: 100px;
}

body {
	text-align: center;
}

td.td1 {
	text-align: right;
}

td {
	padding: 5px;
}

#findid2 {
	padding: 20px;
	border: 1px solid black;
	width: 700px;
	margin-right: auto;
	margin-left: auto;
}

label {
	font-weight: bold;
}

h4 {
	text-align: left;
	font-size: large;
}

.form-control {
	border-radius:
}
</style>
<script>
	function check() {
		if (fr.userName.value == "") {
			fr.userName.focus();
			alert("이름을 입력하세요.");
		}
		if (fr.userPhone.value == "") {
			fr.userPhone.focus();
			alert("핸드폰 번호를 입력하세요.");
		}
		if (fr.ph2.value == "") {
			fr.ph2.focus();
			alert("이름을 입력하세요.");
		}

		return false;
	};
</script>
</head>


<body>
	<jsp:include page="/views/common/header.jsp" />
	<div class="findId" id="findid1">
		<h4>아이디 찾기</h4>
		<hr>
	</div>

	<form action="<%=request.getContextPath()%>/findId.acc" method="post"
		name="fr">
		<div class="findId" id="findid2">
			<h3>회원정보에 등록한 휴대전화로 인증</h3>
			<h5>회원정보에 등록한 휴대전화 번호와 입력한 휴대전화 번호가 같아야, 인증번호를 받을 수 있습니다.</h5>


			<table>



				<tr>
					<td class="td1"><label> 이름 :</label></td>

					<td><input name="userName" class="form-control" id="userName"
						type="text" placeholder="이름을 입력 하세요"></td>
				</tr>
				<tr>
					<td class="td1"><label>휴대 전화 :</label></td>

					<td><input name="userPhone" class="form-control"
						id="userPhone" type="tel" placeholder="전화번호를 입력 하세요"></td>
					<td id="inj"><input id="ph2" type="button" value="인증번호 받기"
						name="ph2"></td>
				</tr>


				<tr>
					<td>
					<td><input class="form-control" id="t4" type="password"
						placeholder="인증번호 6자리 입력"></td>
				</tr>

				<tr>

					<td>
					<td><button name="fd" id="fd">아이디 찾기</button></td>
				</tr>

			</table>





		</div>
	</form>
	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>