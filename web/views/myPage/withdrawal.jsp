<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="com.kh.hp.myPage.model.vo.MyPageUserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MyPageUserVO mypageInfo = (MyPageUserVO) request.getAttribute("mypageInfo");
%>
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
	#btn1{
		width:200pt;
		height:35pt;
		background-color:white;
		border:1px solid gray;
		color:gray; "
	}
	#btn2 {
		 width:200pt;
		 height:35pt;
		 background-color:#ffd014;
		 border:0px;
		 color:gray;"
	}
</style>
</head>
<body>
	<jsp:include page="/views/common/header.jsp" />
	<h1 align=center>회원탈퇴</h1>
	<form action="<%=request.getContextPath()%>/updateLeaveTF.mp" method="post">
	<fieldset class="withdrawal">
		<div id="withdrawal-detail">
			<h4>아이디</h4>
			<input type="text" style="width:400pt; height:30px;" name="userId">
			<h4>비밀번호</h4>
			<input type="password" style="width:400pt; height:30px" name="userPwd1">
			<h4>비밀번호 확인</h4>
			<input type="password" style="width:400pt; height:30px" name="userPwd2">
		</div>
		<br>
		<div>
			<input type=reset id="btn1" value="취소" onclick="goMyPage();">
			<input type=submit id="btn2" value="회원탈퇴">
	  	</div>
	</fieldset>
	</form>

	<script>
		function goMyPage(){
			location.href="<%=request.getContextPath() %>/myPage.mp";
		}
	</script>

	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>