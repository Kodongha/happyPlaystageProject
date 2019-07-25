<%@page import="com.kh.hp.myPage.model.vo.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	AhnLevelupVO responseUserVO = (AhnLevelupVO) request.getAttribute("responseUserVO");
%>
<!DOCTYPE html>   
<html>
<head>
<title>대관 관련 등업 신청</title>
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
		<form action="<%=request.getContextPath()%>/levelUpInfo" method="post">
			<h3>대관 관련 등업 신청</h3>
			<table class="table table-condensed" style="width:600px; height:400px; vertical-align:middle">
				<tr>
					<td id="lev1" name="id">아이디</td>
					<td id="lev1"><%= responseUserVO.getUserEmail() %></td>
					<td id="lev1"></td>
				</tr>
				<tr>
					<td id="lev1">이름</td>
					<td id="lev1" name="name"><%= responseUserVO.getUserNm() %></td>
					<td id="lev1"></td>
				</tr>
				<tr>
					<td id="lev1">닉네임</td>
					<td id="lev1" name="nick"><%= responseUserVO.getUserNick() %></td>
					<td id="lev1"></td>
				</tr>
				<tr>
					<td id="lev1">이메일</td>
					<td id="lev1" name="email"><%= responseUserVO.getUserEmail() %></td>
					<td id="lev1"></td>
				</tr>
				<tr>
					<td id="lev1" name="phone">연락처</td>
					<td id="lev1" ><%= responseUserVO.getUserPhone() %></td>
					<td id="lev1"></td>
				</tr>
				<tr>
					<td id="lev1">공연장 등록증</td>
					<td id="lev1" name="filePath">
						<input type="text" id="perfomer" name="filePath">
						<input type="button" id="imgBtn" name="filePath" style="width:50pt; height:20pt; border:0px; color:black; border-radius: 3px;" value="첨부">
						<input type="file" id="upload" name="filePath">
					</td>
					<td id="lev1"></td>
				</tr>
				<tr>
					<td id="lev1"></td>
					<td id="lev1"></td>
					<td id="lev1"><input type="button" name="filePath" style="width:100pt; height:30pt; background-color:#ffd014; border:0px; color:black; border-radius: 3px; float:right;" value="신청" onclick="location.href='<%=request.getContextPath() %>/levelUpInfo'"></td>
				</tr>
			</table>
		</form>
	</div>
	<script>
		$("#upload").hide();
		$("#imgBtn").click(function(){
			$("#upload").click();
		});
		
		$("#upload").change(function(){
			$("#perfomer").val($("#upload").val());
		});
	</script>
<jsp:include page="/views/common/footer.jsp" />
</body>
</html>
