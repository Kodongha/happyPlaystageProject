<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>

<title>Insert title here</title>
<style>
#center {
	/* 	border: 1px solid black; */
	width: 1024px;
	height: 450px;
	margin: auto;
}

#line {
	border: 0.5px solid gray;
	width: 1024px;
	margin: auto;
}
#text1 {
	width: 180px;
	height: 30px;
	margin-left: 70px;
}

#unit {
	margin-left: 900px;
	margin-top:20px;
}

#search {
	border: 1px solid gray;
	width: 1000px;
	height: 80px;
	margin-left: 5px;
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
	margin-left: 900px;
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
			<strong>매출현황</strong>

		</h2>
		<!-- 회원관리내역과 검색창 사이의 선 -->
		<div id="line"></div>
		<!--검색영역 -->
		<div id="search">

			<div id="users1">
				<label id="userno">매출기간</label>
				<div id="input">
					<input class="form-control" id="ex1" type="text" style="width: 100px;">
				</div>
				<div id="wave">~</div>
				<div id="input1">
					<input class="form-control" id="ex1" type="text" style="width: 100px;">
				</div>
			</div>
			<button type="button" class="btn btn-warning" id="searchbutton">검색</button>
		</div>
		<label id="unit">(단위:만원)</label>

		<div class="container">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>구분</th>
						<th>1월</th>
						<th>2월</th>
						<th>3월</th>
						<th>4월</th>
						<th>5월</th>
						<th>6월</th>
						<th>7월</th>
						<th>8월</th>
						<th>9월</th>
						<th>10월</th>
						<th>11월</th>
						<th>12월</th>
						<th>합계</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>2019</td>
						<td>3,000</td>
						<td>3,000</td>
						<td>3,000</td>
						<td>3,000</td>
						<td>3,000</td>
						<td>3,000</td>
						<td>3,000</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td>21,000</td>
					<tr>
						<td>2018</td>
						<td>3,000</td>
						<td>3,000</td>
						<td>3,000</td>
						<td>3,000</td>
						<td>3,000</td>
						<td>3,000</td>
						<td>3,000</td>
						<td>3,000</td>
						<td>3,000</td>
						<td>3,000</td>
						<td>3,000</td>
						<td>3,000</td>
						<td>36,000</td>
					<tr>
						<td>2017</td>
						<td>3,000</td>
						<td>3,000</td>
						<td>3,000</td>
						<td>3,000</td>
						<td>3,000</td>
						<td>3,000</td>
						<td>3,000</td>
						<td>3,000</td>
						<td>3,000</td>
						<td>3,000</td>
						<td>3,000</td>
						<td>3,000</td>
						<td>36,000</td>
				</tbody>
			</table>
		</div>
	</div>
	<!-- 그래프 들어갈 자리 -->
	<div class="container">
		<canvas id="myChart"></canvas>
	</div>

	<script>
	var ctx = document.getElementById('myChart').getContext('2d');
	var chart = new Chart(ctx, {
	    // The type of chart we want to create
	    type: 'line',
	    // The data for our dataset
	    data: {
	        labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
	        datasets: [{
	            label: 'My First dataset',
	            backgroundColor: 'rgb(255, 99, 132)',
	            borderColor: 'rgb(255, 99, 132)',
	            data: [0, 10, 5, 2, 20, 30, 45]
	        }]
	    },
	    // Configuration options go here
	    options: {}
	});
	</script>

	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>