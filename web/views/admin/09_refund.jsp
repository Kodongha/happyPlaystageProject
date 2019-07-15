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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ=="
	crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

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

<!--
회원관리내역-->#text1 {
	width: 180px;
	height: 30px;
	margin-left: 70px;
}

#search {
	border: 1px solid gray;
	width: 1200px;
	height: 150px;
	margin-left: 50px;
	border-top-left-radius: 8px;
	border-top-right-radius: 8px;
	border-bottom-left-radius: 8px;
	border-bottom-right-radius: 8px;
}

#userno {
	width: 100px;
	margin-left: 10px;
	margin-top: 30px;
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

#assent {
	background: red;
	width: 100px;
	margin-left: 0px;
	margin-bottom: 30px;
}

#leave {
	width: 100px;
	margin-left: 100px;
	margin-top: -30px;
}

.col-sm-2 {
	width: 100px;
	margin-top: 25px;
}

#selects {
	width: 100px;
	margin-left: 319px;
	margin-top: -10px;
}

#searchbutton {
	margin-left: 1100px;
	margin-top: -10px;
}

.button {
	width: 40px;
	background: E6E6E6;
	border: none;
	border-radius: 6px 6px 6px 6px;
}

#jungsan {
	width: 400px;
	margin-left: 500px;
	margin-top: -140px;
}

#condition {
	width: 400px;
	margin-left: 551px;
	margin-top: -100px;
}
.tables{
margin-top: 70px;

}
</style>

</head>
<body>
	<jsp:include page="/views/common/header.jsp" />
	<div id="center" class="fram">
		<!-- 타이틀 -->
		<h2 id="text1">
			<strong>환불</strong>

		</h2>
		<!-- 회원관리내역과 검색창 사이의 선 -->
		<div id="line"></div>
		<br>

		<!--검색영역 -->
		<div id="search">

			<label id="userno">회원번호</label>
			<div id="input">
				<input class="form-control" id="ex1" type="text"
					style="width: 250px;">
			</div>
			<label id="userno">회원명</label>
			<div id="input">
				<input class="form-control" id="ex1" type="text"
					style="width: 250px;">
			</div>



			<button type="button" class="btn btn-warning" id="searchbutton">검색</button>






			<div id="jungsan">
				<label id="userno">환불기간</label>
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
		</div>

		<div id="condition">
			<label id="userno">처리상태</label>
		</div>
		<div class="col-sm-2" id="selects">
			<select class="form-control" id="selects">
				<option>Y</option>
				<option>N</option>
			</select>
		</div>

		<div class="tables">
			<table class="table">
				<thead>
					<tr>
						<th>회원번호</th>
						<th>회원명</th>
						<th>은행명</th>
						<th>계좌</th>
						<th>예금주</th>
						<th>금액</th>
						<th>수수료</th>
						<th>정산금액</th>
						<th>처리상태</th>
						<th>정산</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>00001</td>
						<td>안정웅</td>
						<td>국민</td>
						<td>352685-02-55685</td>
								<td>안정웅</td>
						<td>55,000</td>
				
						<td>5500</td>
						<td>49,500</td>
						<td>Y</td>
						<td><input type="button" value="환불" class="button"></td>
					<tr>
						<td>00002</td>
						<td>고동하</td>
						<td>국민</td>
						<td>352685-02-55685</td>
											<td>고동하</td>
						<td>55,000</td>
	
						<td>5500</td>
						<td>49,500</td>
						<td>Y</td>
						<td><input type="button" value="환불" class="button"></td>
					<tr>
						<td>00003</td>
						<td>하민희</td>
						<td>국민</td>
						<td>352685-02-55685</td>
							<td>하민희</td>
						<td>55,000</td>
						<td>5500</td>
						<td>49,500</td>
						<td>Y</td>
						<td><input type="button" value="환불" class="button"></td>
				</tbody>
			</table>



</div>
		</div>









		<jsp:include page="/views/common/footer.jsp" />
</body>
</html>