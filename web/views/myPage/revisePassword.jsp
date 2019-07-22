<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="com.kh.hp.myPage.model.vo.MyPageUserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MyPageUserVO mypageInfo = (MyPageUserVO) request.getAttribute("mypageInfo");
%>
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
	#btn1 {
		width:200pt;
		height:35pt;
		background-color:white;
		border:1px solid gray;
		color:gray;
	}
	#btn2 {
		width:200pt;
		height:35pt;
		background-color:#ffd014;
		border:0px;
		color:gray;
	}
</style>
</head>
<body>
	<jsp:include page="/views/common/header.jsp" />
	<h1 align=center>비밀번호 변경</h1>
<form action="<%=request.getContextPath()%>/updatePwd.mp" method="post">
	<fieldset class="revisepassword">
		<div>
			<h4>현재 비밀번호</h4>
			<input type="text" style="width:400pt; height:30px;" name="originPwd">
			<h4>새 비밀번호</h4>
			<input type="text" style="width:400pt; height:30px" name="changePwd1">
			<h4>새 비밀번호 확인</h4>
			<input type="text" style="width:400pt; height:30px" name="changePwd2">
		</div>
		<br>
		<div>
			<input type=reset value="취소" id="btn1" onclick="goRevisePage();">
			<input type=submit value="확인" id="btn2">
	  	</div>
	</fieldset>
</form>

<script>
	function goRevisePage(){
		location.href="<%=request.getContextPath()%>/revise.mp";
	}
</script>

	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>