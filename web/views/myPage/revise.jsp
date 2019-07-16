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
<title>마이페이지</title>
<style>
	.btn1 { text-align: center; }

	#first {
		margin-left:46.4%;
		border:1.5px solid lightgray;
		background:white;
		height:40px;
	}
	.switch {
	  position: absolute;
	  display: inline-block;
	  width: 60px;
	  height: 30px;

	}


	.slider {
	  position: absolute;
	  cursor: pointer;
	  top: 0;
	  left: 0;
	  right: 0;
	  bottom: 0;
	  background-color: #ccc;
	  -webkit-transition: .4s;
	  transition: .4s;

	}

	.slider:before {
	  position: absolute;
	  content: "";
	  height: 26px;
	  width: 26px;
	  left: 4px;
	  bottom: 4px;
	  background-color: white;
	  -webkit-transition: .4s;
	  transition: .4s;

	}

	input:checked + .slider {
	  background-color: #2196F3;

	}

	input:checked + .slider:before {
	  -webkit-transform: translateX(26px);
	  -ms-transform: translateX(26px);
	  transform: translateX(26px);
	}

	/* Rounded sliders */
	.slider.round {
	  border-radius: 34px;
	}

	.slider.round:before {
	  border-radius: 50%;
	}

	#revise {
		border:0px;
		background:white;
		text-decoration: underline;
	}

	#out {
		border:0px;
		background:white;
		text-decoration: underline;
	}
	.information {
		margin-left:auto;
		margin-right:auto;
		width:550px;
	}
	.information-detail {
		font-size:20px;
		text-align:center;
	}
	.information-detail2 {
		font-size:20px;
		text-align:left;
	}
	#google {
		width:30px;
		height:30px;
	}
	#kakao {
		width:22px;
		height:22px;
	}
</style>
</head>
<body>
<jsp:include page="/views/common/header.jsp" />
	<h1 align=center style="color:gray">마이페이지</h1>
	<div class="btn1">
	<img src="../../images/myPage/person.png">
	</div>
	<h3 align=center><%= user.getUserNick() %></h3>
	<button id="first"><strong>프로필사진변경</strong></button>
	<br><br>
	<hr>
	<br>
		<form action="<%=request.getContextPath() %>/updateUser.mp" method="post">
		<table class="information">
			<tr>
				<td class="information-detail">이름</td>
				<td class="information-detail2"><%=user.getUserNm() %></td>
			</tr>
			<tr>
				<td class="information-detail">닉네임</td>
				<td class="information-detail2"><input type="text" placeholder="닉네임을 입력하세요."></td>
			</tr>
			<tr>
				<td class="information-detail">이메일</td>
				<td class="information-detail2"><input type="text" placeholder="이메일을 입력하세요."></td>
			</tr>
			<tr>
				<td class="information-detail">연락처정보</td>
				<td class="information-detail2"><input type="text" placeholder="연락처정보를 입력하세요."></td>
			</tr>
			<tr></tr>
			<tr>
				<td class="information-detail">이메일연동</td>
				<td><img src="../../images/myPage/google.png" id="google">구글</td>
				<td class="information-detail2">
				<label class="switch">
  					<input type="checkbox" checked>
  					<span class="slider round"></span>
				</label><br>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><img src="../../images/myPage/kakao.png" id="kakao">카카오</td>
				<td class="information-detail2">
				<label class="switch">
  					<input type="checkbox" checked>
  					<span class="slider round"></span>
				</label><br>
				</td>
			</tr>
			<tr class="information-detail">
			<td colspan="3" align="center"><h6>1개의 SNS연동만 가능하며, 연동된 소셜계정은 해제가 불가합니다</h6></td>
			</tr>
		</table>
		<hr>
			<div class="btn1">
			<input type="reset" style="WIDTH:180pt; height:25pt; background-color:#777; border:0px; color:white;  border-radius: 6px;" value="취소">
			<input type="submit" style="width:180pt; height:25pt; background-color:#ff471a; border:0px; color:white;  border-radius: 6px;" value="확인">
  			</div>
  		</form>
  		<jsp:include page="/views/common/footer.jsp" />
</body>
</html>