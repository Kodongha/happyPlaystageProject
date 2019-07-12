<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style>
<!-- 고쳐야 할것 :목록 중앙정렬, h태그와 텍스트상자사이 거리 좁히기-->
	div { text-align: center; }
	
	.withdrawal {
		width:600px;
		height:400px;
		margin-left:auto;
		margin-right:auto;
	}
</style>
</head>
<body>
	<jsp:include page="/views/common/header.jsp" />
	<h1 align=center>회원탈퇴</h1>
	<fieldset class="withdrawal">
		<div id="withdrawal-detail">
			<h4>아이디</h4>
			<input type="text" style="width:400pt; height:30px;">
			<h4>비밀번호</h4>
			<input type="text" style="width:400pt; height:30px">
			<h4>비밀번호 확인</h4>
			<input type="text" style="width:400pt; height:30px">
		</div>
		<br>
		<div>
			<input type=button style="width:200pt; height:35pt; background-color:white; border:1px solid gray; color:gray; " value="취소">
			<input type=button style="width:200pt; height:35pt; background-color:#ffd014; border:0px; color:gray;" value="회원탈퇴">
	  	</div>
	</fieldset>
	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>