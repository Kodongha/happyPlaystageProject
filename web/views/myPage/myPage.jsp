<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="com.kh.hp.account.model.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	UserVO user = (UserVO) session.getAttribute("user");
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
	height: 650px;
	background-color: white;
	margin: 0 auto;
	margin-top: 50px;
}

#imgArea {
	width: 100px;
	height: 100px;
	background-image: url("../../images/myPage/person.png");
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
				<b><%=user.getUserNick()%></b>
			</h3>
		</div>
		<button type="button" class="btn btn-default">프로필 사진 변경</button>
		<hr style="width: 750px;">
		<div align="center">
			<table id="infoForm">
				<tr>
					<th>이메일</th><td><%= user.getUserEmail() %></td>
				</tr>
				<tr>
					<th>비밀번호</th><td><p onclick="goRevisePwd()" id="revisePwd">변경하기</p></td>
				</tr>
				<tr>
					<th>이름</th><td><%= user.getUserNm() %></td>
				</tr>
				<tr>
					<th>연락처</th>
					<td>
						<% if (user.getUserPhone() == null) { %>
						<p>휴대폰 정보 없음</p>
						<% } else { %>
						<%=	user.getUserPhone() %>
						<% } %>
					</td>
				</tr>
			</table>
		</div>
		<hr style="width: 750px;">
		<span onclick="goReviseForm()" id="revise" align="center">내 정보 수정하기</span>&nbsp;&nbsp;/&nbsp;
		<span onclick="goWithdrawForm()" id="withdraw" align="center">서비스 탈퇴하기</span>

		<script>
			function goRevisePwd(){
				location.href="views/myPage/revise.jsp";
			}
			function goReviseForm(){
				location.href="<%=request.getContextPath()%>/views/myPage/revise.jsp";
			}
			function goWithdrawForm(){
				location.href="views/myPage/revise.jsp";
			}

		</script>



	</div>





	<jsp:include page="/views/common/footer.jsp" />
	<%-- 	<script>
	function goMyPage(){
		location.href="<%=request.getContextPath()%>
		/views/myPage/myPage.jsp";
		}
	</script> --%>

</body>
</html>