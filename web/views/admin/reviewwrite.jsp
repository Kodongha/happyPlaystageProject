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

<title>Insert title here</title>


<style>
#line {
	border: 0.5px solid gray;
	width: 1024px;
	margin: auto;
}

#text1 {
	width: 180px;
	height: 30px;
	margin: auto;
}

#h4 {
	margin-left: 250px;
}

#area {
	width: 1000px;
	height: 100px;
	margin: auto;
}
</style>

</head>
<body>
	<jsp:include page="/views/common/header.jsp" />

	<h2 id="text1" align="center">
		<strong>리뷰등록</strong>

	</h2>
	<br>
	<h4 id="h4">리뷰를 등록해주세요</h4>
	<!-- 회원관리내역과 검색창 사이의 선 -->
	<div id="line"></div>
	<br>
	<div id="area">
		<div class="Information">
			<form>
				<div class="form-group">
					<label for="usr">공연장명</label> <input type="text"
						class="form-control" id="usr">
				</div>
				<br>
				<br>
				<div class="form-group">
					<label for="comment">공연장이용소감</label>
					<textarea class="form-control" rows="5" id="comment"></textarea>
				</div>
				<br>
				<br>
				<div class="form-group">
					<label for="comment">이미지를 추가해 주세요</label> <input type="file"
						id="ex_filename" class="upload-hidden">
				</div>
				<br>
				<br>
				<div class="form-group">
					<label for="comment">별점</label>
					<p>★★★</p>
				</div>
			</form>
		</div>
		<br>
		<br>
		<button type="button" class="btn btn-danger" style="width: 49%;">취소</button>
		<button type="submit" class="btn btn-success"
			style="width: 49%; float: right;">다음</button>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>



	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>