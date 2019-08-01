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

<!-- semantic ui -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
<script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>

<title>회원 탈퇴</title>

<style>
body {
	background-color: #f5f5f5;
}

#mainArea {
	width: 50%;
	height: 400px;
	background-color: white;
	margin: 0 auto;
	margin-top: 50px;
}

#mainArea input {
	width: 70%;
}
#btn1 {
	background-color:#f5c242;
	color:#303030;
}
#btn1:hover {
	background-color:#ffc430;
	color:black;
}
.btns {
	width:200px;
}
</style>

</head>
<body>
	<jsp:include page="/views/common/header.jsp" />
	<br>
	<h2 align="center"><b>서비스 탈퇴</b></h2>

	<form action="<%=request.getContextPath()%>/updateLeaveTF.mp" method="post">
		<div id="mainArea">
			<div id="inputArea">
			 	<div id="inputs" align="center">
			 		<div id="idForm">
					<label for="userEmail">아이디</label><br>
					<h3 name="userEmail"><b><%=mypageInfo.getUserEmail()%></b></h3>
					</div>
					<br>
					<label for="pwd1">비밀번호</label><br>
					<input type="password" class="form-control" name="pwd1" id="pwd1" required>
					<br>
					<label for="pwd2">비밀번호 확인</label><br>
					<input type="password" class="form-control" name="pwd2"id="pwd2" required>
					<div id="alerts">

					<div class="container">
					<div class="alert alert-success" id="alert-success">비밀번호가 일치합니다.</div>
					<div class="alert alert-danger" id="alert-danger">비밀번호가 일치하지 않습니다.</div>
					</div>
					</div>
			</div>
			</div>
			<br><br><br>
			<div align="center">
				<button type="reset" class="ui secondary basic button btns" onclick="goMyPage();"> 취소하기 </button>&nbsp;&nbsp;&nbsp;
				<button type="submit" class="ui secondary button btns" id="btn1"> 탈퇴하기 </button>
			</div>
		</div>
 	</form>

	<script>
	$(function(){
        $("#alert-success").hide();
        $("#alert-danger").hide();
        $("input").keyup(function(){
            var pwd1=$("#pwd1").val();
            var pwd2=$("#pwd2").val();
            if(pwd1 != "" || pwd2 != ""){
                if(pwd1 == pwd2){
                    $("#alert-success").show();
                    $("#alert-danger").hide();
                    $("#btn1").removeAttr("disabled");
                }else{
                    $("#alert-success").hide();
                    $("#alert-danger").show();
                    $("#btn1").attr("disabled", "disabled");
                }
            }
        });
    });
	</script>

	<script>
		function goMyPage(){
			location.href="<%=request.getContextPath()%>/myPage.mp";
		}
	</script>

	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>