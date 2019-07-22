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

<style>
body {
	background-color: #ebebeb;
}

#mainArea {
	width: 70%;
	height: 640px;
	background-color: white;
	margin: 0 auto;
	margin-top: 50px;
}

#imgArea {
	width: 100px;
	height: 100px;
	background-image: url("images/myPage/person.png");
	background-size: 100% 100%;
}
table {
	width: 50%;
	height: 300px;
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

<title>마이페이지</title>
</head>
<body>
	<jsp:include page="/views/common/header.jsp" />
	<br>
	<h2 align="center">
		<b>마이페이지</b>
	</h2>

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
					<th>이메일</th><td><%= mypageInfo.getUserEmail() %></td>
				</tr>
				<tr>
					<th>회원등급</th>
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
					<th>이름</th><td><%= mypageInfo.getUserNm() %></td>
				</tr>
				<tr>
					<th>연락처</th>
					<td>
						<% if (mypageInfo.getUserPhone() == null) { %>
						<p>휴대폰 정보 없음</p>
						<% } else { %>
						<%=	mypageInfo.getUserPhone() %>
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