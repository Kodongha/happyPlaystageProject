<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
table {
	margin: auto;
	padding: 40px;
}

h3 {
	text-align: center;
}

h5 {
	text-align: left;
}

#findid1 {
	width: 550PX;
	text-align: center;
	display: inline-block;
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
	width: 500px;
	margin-right: auto;
	margin-left: auto;
}

label {
	font-weight: bold;
}

#success {
	position: relative;
	vertical-align: top;
	width: 40%;
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
	float: right;
}

#findpassword {
	width: 550PX;
	text-align: left;
	display: inline-block;
	height: 100px;
}

#t1 {
	width: 400px;
	height: 30px;
	border-radius: 5px;
}

#t2 {
	width: 400px;
	height: 30px;
	border-radius: 5px;
}

h2 {
	font-size: large;
}

#returnBtn{
	position: relative;
	vertical-align: top;
	width: 40%;
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
	float: left;
}
</style>
<script>
	$(function(){
		$("#success").click(function(){
			var t2 = $("#authNumber").val();
			if(!t2){
				$("#authNumber").focus();
				alert("인증번호를 입력해 주세요.");
			} else {
				$("#auth").submit();
			}
		});

		$("#returnBtn").click(function(){
			location.href = 'login.jsp';
		});

	});
	<%
	String loginFlag = (String) request.getAttribute("flag");
	if(loginFlag!= null && loginFlag.equals("N")){%>
		alert("인증번호가 틀렸습니다.");
	<%} else if(loginFlag!= null && loginFlag.equals("Y")){%>
		alert("임시 패스워드를 메일로 전송하였습니다.");
		location.href="/happyPlaystage/views/account/login.jsp";
	<%} %>
</script>
</head>
<body>
<jsp:include page="/views/common/header.jsp" />
	<div class="findpassword" id="findpassword">
		<h2>비밀번호 찾기</h2>
		<hr>
	</div>
	<form action="<%=request.getContextPath()%>/fp.acc" method="post" id="auth">
		<div class="findId" id="findid2">
			<table>
				<tr>
					<td>
						<input class="form-control" id="receiver" type="email" name="receiver" value="<%=request.getParameter("email") %>" readonly="readonly">
						<h6>가입시 사용한 이메일 주소를 입력해주시면 비밀번호 재설정 링크를 보내드립니다.<br>
							카카오톡, 구글로 가입하신 경우 비밀번호 찾기가 불가능 합니다.</h6>
					</td>
				</tr>
				<tr>
					<td>
						<h5>인증번호 입력</h5>
						<input class="form-control" id="authNumber" type="text" name="authNumber"placeholder="인증번호 입력">
					</td>
				<tr>
					<td>
						<button id="returnBtn" type="button" class="btn btn-default btn-lg btn-block">취소</button>
						<button id="success" type="button" class="btn btn-default btn-lg btn-block">확인</button>
					</td>
				</tr>
			</table>
		</div>
	</form>
<jsp:include page="/views/common/footer.jsp" />
</body>
</html>