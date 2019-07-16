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
	table {margin-top:auto;}
</style>

<body>
<jsp:include page="/views/common/header.jsp" />
	<div style="width:700px; height:500px;">
		<form>
			<h3>대관 관련 등업 신청</h3>
			<table class="table table-condensed" style="width:700px; height:400px;">
					<tr>
						<td>아이디</td>
						<td>jogn@naver.com</td>
						<td></td>
					</tr>
					<tr>
						<td>이름</td>
						<td>홍길동</td>
						<td></td>
					</tr>
					<tr>
						<td>닉네임</td>
						<td>NINANO</td>
						<td></td>
					</tr>
					<tr>
						<td>이메일</td>
						<td>3837479@naver.com</td>
						<td></td>
					</tr>
					<tr>
						<td>연락처</td>
						<td>010-4159-7898</td>
						<td></td>
					</tr>
					<tr>
						<td>공연장 등록증</td>
						<td><input type="text" name="perfomer"><button>이미지첨부</button></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td><input type=button style="width:100pt; height:35pt; background-color:#ffd014; border:0px; color:black; border-radius: 3px;" value="신청"></td>
					</tr>
			</table>
		</form>
	</div>
	
<jsp:include page="/views/common/footer.jsp" />
</body>
</html>
