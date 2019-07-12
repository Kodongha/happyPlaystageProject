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
	
	thead tr {
    background-color: gray;
  
  } 
  td {
    border: 1px solid lightgray;
  }
  
  label {
  	margin-left:auto;
  	margin-right:auto;
  }
  
  tbody tr:nth-child(1) {
    background-color: #b4b4b4;
  }
</style>
</head>
<body>
<jsp:include page="/views/common/header.jsp" />
	<h1 align=center>대관 사용 내역 검색결과</h1>

	<br>
	<hr>
	<br>
	
	<div style="width:790px;">
	
	<table style="width:790px; height:113px; text-align:center; margin:auto; border-collapse: collapse;">
		<tr>
		<td>공연장 고유번호</td>
		<td>상호명</td>
		<td>사용일자</td>
		<td>사용공간 이름</td>
		</tr>
		<tr>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		</tr>
		<tr>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		</tr>
		<tr>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		</tr>
	</table>
	</div>
	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>