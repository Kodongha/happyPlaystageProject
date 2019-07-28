<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회사소개</title>
<!-- 폰트 -->
<link href="https://fonts.googleapis.com/css?family=Open+Sans&display=swap" rel="stylesheet">
<!-- 버튼 -->


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<style type="text/css">
body {
	font-family: 'Open Sans', sans-serif;
}

#d1 {
	width: 100%;
	height: 330px;
	background-image: url(../../images/serviceCenter/1.PNG);
	background-size: 100% 100%;
}

#d2 {
	width: 100%;
	height: 190px;
	padding: 50px;
}

#d3 {
	width: 100%;
	height: 330px;
	background-image: url(../../images/serviceCenter/2.PNG);
	background-size: 100% 100%;
}

#d4 {
	text-align: center;
	font-size: 23px;
}

#text1 {
	font-size: 20px;
	padding-top: 100px;
}

#text2 {
	font-size: 50px;
}

#text3 {
	font-size: 25px;
	padding: 150px;
	padding-left: 650px;
}

#text4 {
	color: #ffb300;
}
#text6 {
	font-weight:bold;
	font-size:28px;
	font-family: 'Open Sans', sans-serif;
}
.text {
	font-weight: bold;
	color: white;
	margin-left: 70px;
}
.btns {
	width:45%;
	height:50px;
}
.btns:hover{
	background: #ffbf47;
}
</style>
</head>
<body>
<jsp:include page="/views/common/header.jsp" />
	<div class="container">
		<div id="d1">
			<div id="text1" class="text">공연장이 필요할 땐</div>
			<div id="text2" class="text">Happy Playstage</div>
		</div>
		<div id="d2">
			<p id="text6">
				공연장을 시간단위로<br>예약하세요.
			</p>
			<em>"다양한 크기의 공연장을 등록하고 대관할 수 있습니다."</em>
		</div>
		<br>
		<br>
		<div id="d3">
			<div id="text3" class="text">색다른 무대, 취향 저격 공연장</div>
		</div>
		<br>
		<br>
		<div id="d4">
			<p id="text4">
				<b>우리에게 꼭 맞는 공연장이 필요할땐!</b>
			</p>
			<p id="text5">
				<b>Happy Playstage에서 쉽게 예약하고 등록해 보세요.</b>
			</p>
			<br>
			<div class="container">
				<button type="button" class="btn btn-outline-dark btns" onclick="location.href='<%=request.getContextPath()%>/moveRentList.rt'">공연장 찾아보기</button>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="button" class="btn btn-outline-dark btns" onclick="location.href='<%=request.getContextPath()%>/MoveRentEnroll.rt'">공연장 등록하기</button>
			</div>
			<br><br>
		</div>
	</div>
	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>