<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="com.kh.hp.myPage.model.vo.MyPageUserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	MyPageUserVO mypageInfo = (MyPageUserVO) request.getAttribute("mypageInfo");
	System.out.println(mypageInfo.getSnsCd());
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
	<%if(mypageInfo.getSnsCd() == 0){%>
	text-decoration: underline;
	cursor: pointer;
	<%} else { %>
	cursor: pointer;
	text-decoration: line-through;
	<%} %>
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

<SCRIPT type="text/javascript">
	function loadImg(value){
		console.log("haha");
		if(value.files && value.files[0]){
			var reader = new FileReader();

			reader.onload = function(e){
				$("#profileImg").attr("src", e.target.result);
			}
			reader.readAsDataURL(value.files[0]);
		}
	}

	$(function(){
		$('#fileArea').hide();

		$('#changePhotoBtn').click(function(){

			$('#profilePhoto').click();

		});

		$('#profilePhoto').change(function(){

			var photoForm = $("#photoForm")[0];
			var photoFormData = new FormData(photoForm);


			console.log(photoForm);

			$.ajax({
				url:'chageProfilePhoto.my',
				processData: false,
				contentType: false,
				data: photoFormData,
				type: 'POST',
				success: function(data){
					console.log("succ");
					if(data > 0){

					} else {
						alert("사진 변경에 실패하였습니다.");
					}
				},
				error: function(error){
					console.log("error");
				}
			});
		});

	});

</SCRIPT>
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
	<div id="imgArea" algin="center">
		<%if(mypageInfo.getChangeNm() == null || mypageInfo.getChangeNm().equals("")){%>
		<img id="profileImg" src="images/myPage/person.png">
		<%} else {%>
		<img id="profileImg" src="<%=request.getContextPath() + "/images/myPage/myProfile/" + mypageInfo.getChangeNm()%>">
		<%}%>
	</div>
	<br>
	<button class="btn btn-default" id="changePhotoBtn">프로필 사진 변경</button>

	<FORM id="photoForm" action="<%=request.getContextPath() %>/changePhoto.my" method="post" enctype="multipart/form-data">
		<div id="fileArea">
			<INPUT type="file" id="profilePhoto" name="profilePhoto" onchange="loadImg(this);" />
		</div>
	</FORM>

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
						<%if(mypageInfo.getSnsCd() == 0){%>
						<td><p onclick="goRevisePwd()" id="revisePwd" >변경하기</p></td>
						<%} else { %>
						<td><p id="revisePwd" >변경하기</p></td>
						<%} %>
					</tr>
				</table>
			</div>
			<hr style="width: 750px;">
			<button type="reset" class="ui button btns" onclick="goMyPage();">취소하기</button>&nbsp;&nbsp;&nbsp;
			<button type="submit" class="ui secondary button btns" id="btn1">변경하기</button>
		</form>
	</div>

	<!-- <script>

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

      </script> -->

	<% if(mypageInfo.getSnsCd() == 1) { %>
	<script>
		$("#revisePwd").attr("onclick", null);
	</script>
	<% } %>

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