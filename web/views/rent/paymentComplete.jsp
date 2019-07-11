<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<style>
	#btn1 {
		color:black;
	}
	.btns {
		 width:37%;
		 height:45px;
		 font-weight:bold;
	}
</style>

</head>
<body>
	<jsp:include page="/views/common/header.jsp" />

	<br><br><br><br><br><br>
	<h3 align="center"><b>고객님이 요청하신 공연장의 결제가 완료되었습니다.</b></h3>
	<br><br><br><br>
	<div class="container" align="center">
		<button type="button" class="btn btn-warning btns" id="btn1">대관 신청 내역으로 이동</button>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button type="button" class="btn btn-danger btns" id="btn2">메인으로 이동</button>
	</div>
	<br><br>
	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>