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
	width: 250px;
	height: 30px;
	margin-left: 70px;
}

.Subject {
	text-align: center;
}

.Contents {
	text-align: center;
}

#question {
	border: 1px solid lightgray;
	width: 1200px;
	height: 150px;
	border-top-left-radius: 8px;
	border-top-right-radius: 8px;
	border-bottom-left-radius: 8px;
	border-bottom-right-radius: 8px;
}
#searchbutton{
margin-left:1200px;
}
</style>

</head>
<body>
<jsp:include page="/views/common/header.jsp" />
	<div id="center" class="fram">
		<!-- 타이틀 -->
		<h2 id="text1">
			<strong>1:1문의등록 상세</strong>

		</h2>
		<!-- 회원관리내역과 검색창 사이의 선 -->
		<div id="line"></div>

		<br> <br>

		<div class="container">
			<table class="table">
				<thead>
				</thead>
				<tbody>
					<tr>
						<td class="Contents">
							<div id="question">
							여기는 문의글 내용 !!!!!<br>
							여기는 문의글 내용 !!!!!<br>
							여기는 문의글 내용 !!!!!<br>
							여기는 문의글 내용 !!!!!<br>
							
							</div>
						</td>
					</tr>
					<tr>
						<td class="Contents">

							<div class="form-group">
								<textarea class="form-control" rows="10" id="comment"></textarea>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
			<button type="button" class="btn btn-warning" id="searchbutton">등록</button>
	</div>
	
<jsp:include page="/views/common/footer.jsp" />
</body>
</html>