<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kh.hp.account.model.vo.*"%>
    
    <%
	ArrayList<ReviewMainVO> list = 
			(ArrayList<ReviewMainVO>) request.getAttribute("list");
    %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ=="
	crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<style>
#mainframe {

	widht: 1024px;
	height: 1000px;
}
#viewzone {
/* 	border: 1px solid black; */
	width: 1030px;
	height: 600px;
	margin:auto;
}
#viewzone-left{
/* border: 1px solid red; */
	width: 500px;
	height: 600px;
}
#left-1{
;
	border: 1px solid gray;
	width: 500px;
	height: 300px;
}
#left-1-tite{

	width: 380px;
	font-size:25px;
	margin-left:50px;
	margin-top:20px;
}
#left-1-address{
	/* border: 1px solid black; */
	width: 380px;
	margin-left:50px;
	margin-top:10px;
}
#left-1-grade{
	/* border: 1px solid black; */
	width: 380px;
	margin-left:50px;
	margin-top:10px;
}
#left-1-line{
	width: 390px;
	margin-left:50px;
	margin-top:10px;
}
#left-1-contens{
	border:1px solid black;
	width: 390px;
	height:120px;
	margin-left:50px;
	margin-top:10px;

}
#left-2{

	border: 1px solid gray;
	width: 500px;
		height: 300px;
	margin-top:30px;
}
#left-2-tite{

	width: 380px;
	font-size:25px;
	margin-left:50px;
	margin-top:20px;
}
#left-2-address{
	/* border: 1px solid black; */
	width: 380px;
	margin-left:50px;
	margin-top:10px;
}
#left-2-grade{
	/* border: 1px solid black; */
	width: 380px;
	margin-left:50px;
	margin-top:10px;
}
#left-2-line{
	width: 390px;
	margin-left:50px;
	margin-top:10px;
}
#left-2-contens{
	border:1px solid black;
	width: 390px;
	height:120px;
	margin-left:50px;
	margin-top:10px;

}
#viewzone-right{
/* 	border: 1px solid blue; */
	width: 500px;
	height: 600px;
	margin-top:-600px;
	margin-left:500px;
}
#right-1{

	border: 1px solid gray;
	width: 500px;
		height: 300px;
	margin-left:30px;
}
#right-1-tite{

	width: 380px;
	font-size:25px;
	margin-left:50px;
	margin-top:20px;
}
#right-1-address{
	/* border: 1px solid black; */
	width: 380px;
	margin-left:50px;
	margin-top:10px;
}
#right-1-grade{
	/* border: 1px solid black; */
	width: 380px;
	margin-left:50px;
	margin-top:10px;
}
#right-1-line{
	width: 390px;
	margin-left:50px;
	margin-top:10px;
}
#right-1-contens{
	border:1px solid black;
	width: 390px;
	height:120px;
	margin-left:50px;
	margin-top:10px;

}
#right-2{
	border: 1px solid gray;
	width: 500px;
		height: 300px;
	margin-left:30px;
	margin-top:30px;
}
#right-2-tite{

	width: 380px;
	font-size:25px;
	margin-left:50px;
	margin-top:20px;
}
#right-2-address{
	/* border: 1px solid black; */
	width: 380px;
	margin-left:50px;
	margin-top:10px;
}
#right-2-grade{
	/* border: 1px solid black; */
	width: 380px;
	margin-left:50px;
	margin-top:10px;
}
#right-2-line{
	width: 390px;
	margin-left:50px;
	margin-top:10px;
}
#right-2-contens{
	border:1px solid black;
	width: 390px;
	height:120px;
	margin-left:50px;
	margin-top:10px;

}





</style>
</head>
<body>
<jsp:include page="/views/common/header.jsp" />
	<div class="outer" id=mainframe>
		<div align="center">
			<h1>
				<strong>리뷰ZONE</strong>
			</h1>
			<br>
		</div>
		<divid="viewzone" >
			<div id="viewzone-left">
				<div id=left-1>
					<div id="left-1-tite"  style="font-weight: bold">마리아 칼라스 홀</div>
					<div id="left-1-address" >서울시 강남구 역삼동 111-1</div>
					<div id="left-1-grade" >★★★★</div>
					<div id="left-1-line"><hr  style="border:solid 0.5px black"></div>
					<div id="left-1-contens">50석 규모의 소규모 공연장. 좌석 간 간격도 넓고 쾌적해서 프라이빗한 공연장 느낌. 천고가 낮긴 하지만 1인 공연의 경우 큰 문제가 되지 않으며 무대와 좌석간의 거리가 가까워 공연자의 표정까지 충분히 느껴짐</div>
				</div>
				<div id=left-2>
					<div id="left-2-tite"  style="font-weight: bold">마리아 칼라스 홀</div>
					<div id="left-2-address" >서울시 강남구 역삼동 111-1</div>
					<div id="left-2-grade" >★★★★</div>
					<div id="left-2-line"><hr  style="border:solid 0.5px black"></div>
					<div id="left-2-contens">50석 규모의 소규모 공연장. 좌석 간 간격도 넓고 쾌적해서 프라이빗한 공연장 느낌. 천고가 낮긴 하지만 1인 공연의 경우 큰 문제가 되지 않으며 무대와 좌석간의 거리가 가까워 공연자의 표정까지 충분히 느껴짐</div>
				</div>
			
			</div>
			<div id="viewzone-right">
				<div id=right-1>
				<div id="right-1-tite"  style="font-weight: bold">마리아 칼라스 홀</div>
					<div id="right-1-address" >서울시 강남구 역삼동 111-1</div>
					<div id="right-1-grade" >★★★★</div>
					<div id="right-1-line"><hr  style="border:solid 0.5px black"></div>
					<div id="right-1-contens">50석 규모의 소규모 공연장. 좌석 간 간격도 넓고 쾌적해서 프라이빗한 공연장 느낌. 천고가 낮긴 하지만 1인 공연의 경우 큰 문제가 되지 않으며 무대와 좌석간의 거리가 가까워 공연자의 표정까지 충분히 느껴짐</div>
				</div>
				<div id=right-2>
				<div id="right-1-tite"  style="font-weight: bold">마리아 칼라스 홀</div>
				<div id="right-1-address" >서울시 강남구 역삼동 111-1</div>
					<div id="right-1-grade" >★★★★</div>
					<div id="right-1-line"><hr  style="border:solid 0.5px black"></div>
					<div id="right-1-contens">50석 규모의 소규모 공연장. 좌석 간 간격도 넓고 쾌적해서 프라이빗한 공연장 느낌. 천고가 낮긴 하지만 1인 공연의 경우 큰 문제가 되지 않으며 무대와 좌석간의 거리가 가까워 공연자의 표정까지 충분히 느껴짐</div>
				</div>
			
			</div>
		</div>
		
		
		
		
		
	</div>

<jsp:include page="/views/common/footer.jsp" />
</body>
</html>