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
	div {
		margin:auto;
	}
	#tab1{
		background-color: darkgray;
		 border: 1px solid lightgray;
	}
	#tab2 {
	 border: 1px solid lightgray;
  } 
</style>
</head>
<body>
<jsp:include page="/views/common/header.jsp" />
	<h1 align=center style="color:gray">대관 사용 내역</h1>
	
	<div class="tab1" style="width:650px;border:1.5px solid black">
	<table align="center">
		<tr>
			<td>공연장 고유번호</td>
			<td>공연장 이름</td>
			<td>일자</td>
			<td></td>
		</tr>
		<tr>
			<td><input type="text"></td>
			<td><input type="text"></td>
			<td><input type="text"></td>
			<td><input type="submit"></td>
		</tr>
	</table>
	</div>
	<br>
	
	<hr>
	
	<br>
	<div class="tab2" style="width:790px;">
	
	<table style="width:790px; height:113px; text-align:center; margin:auto; border-collapse: collapse;">
		<tr>
		<td id="tab1">공연장 고유번호</td>
		<td id="tab1">상호명</td>
		<td id="tab1">사용일자</td>
		<td id="tab1">사용공간 이름</td>
		</tr>
		<tr>
		<td id="tab2"></td>
		<td id="tab2"></td>
		<td id="tab2"></td>
		<td id="tab2"></td>
		</tr>
		<tr>
		<td id="tab2"></td>
		<td id="tab2"></td>
		<td id="tab2"></td>
		<td id="tab2"></td>
		</tr>
		<tr>
		<td id="tab2"></td>
		<td id="tab2"></td>
		<td id="tab2"></td>
		<td id="tab2"></td>
		</tr>
	</table>
	</div>
	<jsp:include page="/views/common/footer.jsp" />
</body>
</html> 