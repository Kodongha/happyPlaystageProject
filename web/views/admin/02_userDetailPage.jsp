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
	width: 1300px;
	margin: auto;
}

#text1 {
	width: 500px;
	height: 30px;
	margin-left: 70px;
}

#inner {
	width: 1000px;
	height: 700px;
	margin: auto;
}

#Enrollment{
	background:lightgray;
	width: 1000px;
	height: 300px;
	margin: auto;


}

</style>

</head>
<body>
	<jsp:include page="/views/common/header.jsp" />
	<div id="center" class="fram">
		<!-- 타이틀 -->
		<h2 id="text1">
			<strong>회원 관리 내역 상세</strong>

		</h2>
		<!-- 회원관리내역과 검색창 사이의 선 -->
		<div id="line"></div>
		<div id="inner">

			<br> <br>
			<div class="Membership" >
				<form class="form-horizontal" action="/action_page.php">
					<div class="form-group">
						<label class="control-label col-sm-2" for="userId">회원번호:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="userId" name="userId" style="width:500px;">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="nikName">닉네임:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="nikName"
								name="nikName"  style="width:500px;">
						</div>
					</div>
					<form class="form-horizontal" action="/action_page.php">
						<div class="form-group">
							<label class="control-label col-sm-2" for="name">이름:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="name" name="name"  style="width:500px;">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2" for="phone">연락처:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="phone" name="phone"  style="width:500px;">
							</div>
						</div>
						<form class="form-horizontal" action="/action_page.php">
							<div class="form-group">
								<label class="control-label col-sm-2" for="email">이메일:</label>
								<div class="col-sm-10">
									<input type="email" class="form-control" id="email"
										name="email"  style="width:500px;">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="file">첨부파일:</label>
								<div class="col-sm-10">
									<input type="file" id="ex_filename" class="upload-hidden">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="pwd">대관등록승인여부:</label>
								<div class="col-sm-10">
									<div class="col-sm-2" id="select" style="width: 100px;">
										<select class="form-control" id="gender1">
											<option>Y</option>
											<option>N</option>
										</select>
									</div>
								</div>
								<br>
							</div>
							<div  align="center" ><label>대관등록내역</label></div>
							<div id="Enrollment" ></div>
							<br>
<br>
<br>

							<div  align="center" ><label>대관사용내역</label></div>
							<div id="Enrollment" ></div>
						</form>
					</form>
				</form>
			</div>
		</div>

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



	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>



