<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style>
<!-- 고쳐야 할것 :목록 중앙정렬, h태그와 텍스트상자사이 거리 좁히기-->
	div { text-align: center; }
	
	.revisepassword {
		width:600px;
		height:400px;
		margin-left:auto;
		margin-right:auto;
	}
	
	.btn {
		margin:auto;
	}
	
</style>
</head>
<body>
	<jsp:include page="/views/common/header.jsp" />
	<h1 align=center>비밀번호 변경</h1>
	<fieldset class="revisepassword">
		<div>
			<h4>현재 비밀번호</h4>
			<input type="text" style="width:400pt; height:30px;">
			<h4>새 비밀번호</h4>
			<input type="text" style="width:400pt; height:30px">
			<h4>새 비밀번호 확인</h4>
			<input type="text" style="width:400pt; height:30px">
		</div>
		<br>
		<div>
			<input type=button style="width:200pt; height:35pt; background-color:white; border:1px solid gray; color:gray; " value="취소">
			<input type=button style="width:200pt; height:35pt; background-color:#ffd014; border:0px; color:gray;" value="확인">
	  	</div>
	</fieldset>
	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>