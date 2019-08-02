<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="com.kh.hp.myPage.model.vo.MyPageUserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	MyPageUserVO mypageInfo = (MyPageUserVO) request.getAttribute("mypageInfo");
	String flag = request.getParameter("flag");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<!-- semantic ui -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
<script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>

<!-- jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<title>Insert title here</title>
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
#inputArea {
	padding-top : 50px;
}
#alerts {
	width:70%;
}

</style>
<SCRIPT type="text/javascript">
	$(function(){
		<%if(flag != null && flag.equals("N")){ %>
			alert("비밀번호가 일치하지 않습니다.");
		<%} %>
	});

</SCRIPT>
</head>
<body>
	<jsp:include page="/views/common/header.jsp" />
	<br>
	<h2 align="center"><b>비밀번호 변경하기</b></h2>

	<form action="<%=request.getContextPath()%>/updatePwd.mp" method="post">
		<div id="mainArea" align="center">
			<div id="inputArea">
			<div id="inputs">
					<label for="originPwd">현재 비밀번호</label><br>
					<input type="password" class="form-control" name="originPwd" id="originPwd" required>
					<br>
					<label for="newPwd1">새 비밀번호</label><br>
					<input type="password" class="form-control" name="newPwd1" id="newPwd1" required>
					<br>
					<label for="newPwd2">새 비밀번호 재입력</label><br>
					<input type="password" class="form-control" name="newPwd2"id="newPwd2" required>
					</div>
					<div id="alerts">
					<div class="alert alert-success" id="alert-success">비밀번호가 일치합니다.</div>
					<div class="alert alert-danger" id="alert-danger">비밀번호가 일치하지 않습니다.</div>
					</div>
			</div>
			<br>
			<div id="btns" align="center">
				<button type="reset" class="ui button" onclick="goRevisePage();"> 취소하기 </button>&nbsp;&nbsp;&nbsp;
				<button type="submit" class="ui secondary button" id="btn1"> 변경하기 </button>
			</div>
			</div>
		</div>
	</form>

	<script type="text/javascript">
    $(function(){
        $("#alert-success").hide();
        $("#alert-danger").hide();
        $("#newPwd2").keyup(function(){
            var newPwd1=$("#newPwd1").val();
            var newPwd2=$("#newPwd2").val();
            if(newPwd1 != "" || newPwd2 != ""){
                if(newPwd1 == newPwd2){
                    $("#alert-success").show();
                    $("#alert-danger").hide();
                    $("#btn1").removeAttr("disabled");
                }else{
                	if(newPwd2 == null){
                    	$("#alert-success").hide();
                    	$("#alert-danger").hide();
                    	$("#btn1").attr("disabled", "disabled");
                	}else {
                		$("#alert-success").hide();
                    	$("#alert-danger").show();
                    	$("#btn1").attr("disabled", "disabled");
                	}

                }
            }
         });
    });
</script>

	<script>
	/* 취소하기 버튼 눌렀을 때 */
	function goRevisePage(){
		location.href="<%=request.getContextPath()%>/revise.mp";
		}
	</script>

	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>