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

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
<script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>

<style>
body {
	background-color: #ebebeb;
}

#mainArea {
	width: 70%;
	height: 750px;
	background-color: white;
	margin: 0 auto;
	margin-top: 50px;
}

#imgArea {
	width: 100px;
	height: 100px;
	border-radius: 70px;
}

#profileImg {
	width: 100px;
	height: 100px;
	border-radius: 70px;
	border: 1px solid red;
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
	text-align: center;
}

#revisePwd:hover, #withdraw:hover {
	cursor: pointer;
	text-decoration: underline;
}

input {
	text-align: center;
}

#btn1 {
	background-color: #f5c242;
	color: #303030;
}

#btn1:hover {
	background-color: #ffc430;
	color: black;
}

.btns {
	width: 180px;
}
</style>

<title>내 정보 수정</title>

</head>
<body>
	<jsp:include page="/views/common/header.jsp" />
	<br>
	<h2 align="center">
		<b>내 정보 수정</b>
	</h2>
	<div id="mainArea" align="center">
	<br><br>
	<form action="<%=request.getContextPath()%>/changeProfile.mp" method="post" encType="multipart/form-data">
		<div id="imgArea" algin="center">
			<img id="profileImg">
		</div>
		<br>
		<button type="submit" class="btn btn-default">프로필 사진 변경</button>
	</form>
		<br><br>
		<form action="<%=request.getContextPath()%>/updateUser.mp" method="post">
			<div id="profile">
				<h3>
					<input type="text" class="form-control" value="<%=mypageInfo.getUserNick()%>" style="width: 200px;" name="userNick" required>
				</h3>
			</div>
			<hr style="width: 750px;">
			<div align="center">
				<table id="infoForm">
					<tr>
						<th>이메일</th>
						<td><%=mypageInfo.getUserEmail()%></td>
					</tr>
					<tr>
						<th>이름</th>
						<td><input type="text" class="form-control"
							value="<%=mypageInfo.getUserNm()%>" name="userNm" required></td>
					</tr>
					<tr>
						<th>연락처</th>
						<td><input type="text" class="form-control"
							value="<%=mypageInfo.getUserPhone()%>" name="userPhone"
							required></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><p onclick="goRevisePwd()" id="revisePwd">변경하기</p></td>
					</tr>
				</table>
			</div>
			<hr style="width: 750px;">
			<button type="reset" class="ui button btns" onclick="goMyPage();">취소하기</button>&nbsp;&nbsp;&nbsp;
			<button type="submit" class="ui secondary button btns" id="btn1">변경하기</button>
	</div>

	<div id="fileArea">
		<input type="file" id="upload" name="upload" onchange="loadImg(this)">
	</div>
		</form>

	<script>
         $(function(){
            $("#fileArea").hide();

            $("#imgArea").click(function(){
               $("#upload").click();
            });
         });

         function loadImg(value){
         if(value.files && value.files[0]) {
            var reader = new FileReader();

            reader.onload = function(e) {
               $("#profileImg").attr("src", e.target.result);
            }

            reader.readAsDataURL(value.files[0]);
         }
       }
      </script>


	<script>
		function goRevisePwd(){
			location.href="<%=request.getContextPath()%>/reviseaPwd.mp";
		}
		function goMyPage(){
			location.href="<%=request.getContextPath()%>/myPage.mp";
		}
	</script>

	<jsp:include page="/views/common/footer.jsp" />

</body>
</html>