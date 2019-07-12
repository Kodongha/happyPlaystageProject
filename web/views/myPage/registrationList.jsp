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
	.reg-information {
		margin-left:auto;
		margin-right:auto;
	}
</style>
</head>
<body>
<jsp:include page="/views/common/header.jsp" />
	<h1 align=center>대관 등록 내역</h1>
	<table class="reg-information">
	<tr>
	<td>
	<div>
	<h5>공간고유번호</h5>
	<h5>공간이름</h5>
	<img src="/semi/image/person.png"><br>
	<input type=button style="width:200pt; height:35pt; background-color:#ffd014; border:0px; color:black; border-radius: 3px;" value="수정">
	<input type=button style="width:200pt; height:35pt; background-color:white; border:1px solid gray; color:black; border-radius: 3px;" value="보기">
	</div>
	</td>
	<td>
	<div>
	<h5>공간고유번호</h5>
	<h5>공간이름</h5>
	<img src="/semi/image/person.png"><br>
	<input type=button style="width:200pt; height:35pt; background-color:#ffd014; border:0px; color:black; border-radius: 3px;" value="수정">
	<input type=button style="width:200pt; height:35pt; background-color:white; border:1px solid gray; color:black; border-radius: 3px;" value="보기">
	</div>
	</td>
	</tr>
	<tr>
	<td>
	<div>
	<h5>공간고유번호</h5>
	<h5>공간이름</h5>
	<img src="/semi/image/person.png"><br>
	<input type=button style="width:200pt; height:35pt; background-color:#ffd014; border:0px; color:black; border-radius: 3px;" value="수정">
	<input type=button style="width:200pt; height:35pt; background-color:white; border:1px solid gray; color:black; border-radius: 3px;" value="보기">
	</div>
	</td>
	<td>
	<div>
	<h5>공간고유번호</h5>
	<h5>공간이름</h5>
	<img src="/semi/image/kakao.png"><br>
	<input type=button style="width:200pt; height:35pt; background-color:#ffd014; border:0px; color:black; border-radius: 3px;" value="수정">
	<input type=button style="width:200pt; height:35pt; background-color:white; border:1px solid gray; color:black; border-radius: 3px;" value="보기">
	</div>
	</td>
	</tr>
	</table>
	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>