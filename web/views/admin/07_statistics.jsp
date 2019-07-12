<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ=="
	crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<title>Insert title here</title>


<style>
#center {
	/* 	border: 1px solid black; */
	width: 1300px;
	height: 800px;
	margin: auto;
}

#line {
	border: 0.5px solid gray;
	width: 1300px;
	margin: auto;
}
#text1 {
	width: 180px;
	height: 30px;
	margin-left: 70px;
}


#search {
	border: 1px solid gray;
	width: 1200px;
	height: 80px;
	margin-left: 50px;
	margin-top: 30px;
	border-top-left-radius: 8px;
	border-top-right-radius: 8px;
	border-bottom-left-radius: 8px;
	border-bottom-right-radius: 8px;
}

#users1 {
	width: 500px;
	height: 150px;
	margin-left: 50px;
	margin-top: 30px;
}

#users5 {
	width: 100px;
	height: 150px;
	margin-left: 100px;
	margin-top: -110px;
}

#input {
	width: 110px;
	margin-left: 100px;
	margin-top: -32px;
}

#input1 {
	width: 110px;
	margin-left: 250px;
	margin-top: -26px;
}

#wave {
	width: 10px;
	margin-left: 220px;
	margin-top: -28px;
}

#searchbutton {
	margin-left: 1100px;
	margin-top: -300px;
}

.button {
	width: 40px;
	background: E6E6E6;
	border: none;
	border-radius: 6px 6px 6px 6px;
}

.container{
margin-top:30px;
}
</style>

</head>
<body>
<jsp:include page="/views/common/header.jsp" />
	<div id="center" class="fram">
		<!-- 타이틀 -->
		<h2 id="text1">
			<strong>회원통계</strong>

		</h2>
		<!-- 회원관리내역과 검색창 사이의 선 -->
		<div id="line"></div>
		<!--검색영역 -->
		<div id="search">

			<div id="users1">
				<label id="userno">기간</label>
				<div id="input">
					<input class="form-control" id="ex1" type="text"
						style="width: 100px;">
				</div>
				<div id="wave">~</div>
				<div id="input1">
					<input class="form-control" id="ex1" type="text"
						style="width: 100px;">
				</div>
			</div>
			<button type="button" class="btn btn-warning" id="searchbutton">검색</button>
		</div>

	<!-- 그래프 들어갈 자리 -->	

	</div>


<jsp:include page="/views/common/footer.jsp" />
</body>
</html>