<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script 
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<style>
	div {margin:auto;}
	#lev1{vertical-align: middle;}
</style>
<body>
<jsp:include page="/views/common/header.jsp" />
<br><br>
	<div style="width:600px; height:500px; ">
		<form>
			<h3>대관 관련 등업 신청</h3>
			<table class="table table-condensed" style="width:600px; height:400px; vertical-align:middle">
					<tr>
						<td id="lev1">아이디</td>
						<td id="lev1">HP@naver.com</td>
						<td id="lev1"></td>
					</tr>
					<tr>
						<td id="lev1">이름</td>
						<td id="lev1">홍길동</td>
						<td id="lev1"></td>
					</tr>
					<tr>
						<td id="lev1">닉네임</td>
						<td id="lev1">NINANO</td>
						<td id="lev1"></td>
					</tr>
					<tr>
						<td id="lev1">이메일</td>
						<td id="lev1">12345@naver.com</td>
						<td id="lev1"></td>
					</tr>
					<tr>
						<td id="lev1">연락처</td>
						<td id="lev1">010-4159-7898</td>
						<td id="lev1"></td>
					</tr>
					<tr>
						<td id="lev1">공연장 등록증</td>
						<td id="lev1"><input type="text" name="perfomer"><button>이미지첨부</button></td>
						<td id="lev1"></td>
					</tr>
					<tr>
						<td id="lev1"></td>
						<td id="lev1"></td>
						<td id="lev1"><input type=button style="width:100pt; height:30pt; background-color:#ffd014; border:0px; color:black; border-radius: 3px; float:right;" value="신청"></td>
					</tr>
			</table>
		</form>
	</div>
<jsp:include page="/views/common/footer.jsp" />
</body>
</html>
