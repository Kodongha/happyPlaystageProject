<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="com.kh.hp.myPage.model.vo.MyPageUserVO"%>
<%@page import="com.kh.hp.account.model.vo.UserVO"%>
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

<link href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css" rel="stylesheet">
<script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>

<style>
body {
	background-color: #ebebeb;
}

#mainArea {
	width: 70%;
	height: 800px;
	background-color: white;
	margin: 0 auto;
	margin-top: 50px;
}

#imgArea {
	width: 100px;
	height: 100px;
	<%if(mypageInfo.getChangeNm() == null || mypageInfo.getChangeNm().equals("")){%>
	background-image: url("images/myPage/person.png");
	<%} else {%>
	background-image: url("<%=request.getContextPath() + "/images/myPage/myProfile/" + mypageInfo.getChangeNm()%>");
	<%}%>
	background-size: 100% 100%;
	border-radius:70px;
}
table {
	width: 50%;
	height: 300px;
	text-align: center;
}
#infoForm th {
	width: 50%;
	height: 70px;

}
#infoForm td {
	width: 50%;
	height: 70px;
	text-align:center;
}
#revisePwd:hover, #revise:hover, #withdraw:hover {
	cursor:pointer;
	text-decoration:underline;
}
</style>

<style>
  	.toggle.ios, .toggle-on.ios, .toggle-off.ios { border-radius: 20px; }
  	.toggle.ios .toggle-handle { border-radius: 20px; }
</style>

<title>마이페이지</title>
</head>
<body>
	<jsp:include page="/views/common/header.jsp" />
	<br>
	<h2 align="center"><b>마이페이지</b></h2>

	<div id="mainArea" align="center">
		<br>
		<br>
		<div id="imgArea"></div>
		<div>
			<h3>
				<b><%=mypageInfo.getUserNick()%></b>
			</h3>
		</div>
		<hr style="width: 750px;">
		<div align="center">
			<table id="infoForm">
				<tr>
					<td><b>이메일</b></td>
					<td><%= mypageInfo.getUserEmail() %></td>
				</tr>
				<tr>
					<td><b>회원등급</b></td>
					<td>
						<% if(mypageInfo.getUserGradeCd() == 1) { %>
							일반 사용자
						<% } else if(mypageInfo.getUserGradeCd() == 2) { %>
							대관가능 사용자
						<% } else { %>
							관리자
						<% } %>
					</td>
				</tr>
				<tr>
					<td><b>이름</b></td>
					<td><%= mypageInfo.getUserNm() %></td>
				</tr>
				<tr>
					<td><b>연락처</b></td>
					<td>
						<% if (mypageInfo.getUserPhone() == null) { %>
						<p>휴대폰 정보 없음</p>
						<% } else { %>
						<%=	mypageInfo.getUserPhone() %>
						<% } %>
					</td>
				</tr>
				<tr>
					<td><b>SNS 연동 여부</b></td>
					<td rowspan="2">
						<% if (mypageInfo.getSnsCd() == 1) { %>
						<img src="images/myPage/kakaolink_btn_small.png" width="40px" height="40px">
						<input type="checkbox" data-toggle="toggle" data-style="ios" checked="checked" disabled="disabled">
						<%} else { %>
						<img src="images/myPage/kakaolink_btn_small.png" width="40px" height="40px">
						<input type="checkbox" data-toggle="toggle" data-style="ios" disabled="disabled">
						<% } %>

					</td>
				</tr>
			</table>
		</div>
		<hr style="width: 750px;">
		<span onclick="goReviseForm()" id="revise" align="center">내 정보 수정하기</span>&nbsp;&nbsp;/&nbsp;
		<span onclick="goWithdrawForm()" id="withdraw" align="center">서비스 탈퇴하기</span>
		<script>
			function goReviseForm(){
 				location.href="<%=request.getContextPath() %>/revise.mp";
			}
			function goWithdrawForm(){
				location.href="<%=request.getContextPath() %>/withdrawal.mp";
			}

		</script>

	</div>

	<jsp:include page="/views/common/footer.jsp" />

</body>
</html>