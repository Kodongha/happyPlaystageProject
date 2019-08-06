<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,  com.kh.hp.admin.model.vo.*"%>

<%



	%> 
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

	width: 1024px;
	height: 768px;
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

#option1 {
	width: 150px;
}

.name {
	text-align: center;
}

#searchbutton {
	margin-left: 950px;
}
#area1{
margin-left:-10px;

}
</style>

</head>
<body>
	<jsp:include page="/views/common/header.jsp" />

	<div id="center" class="fram">
		<!-- 타이틀 -->
		<h2 id="text1">
			<strong>공지사항등록</strong>

		</h2>
		<!-- 회원관리내역과 검색창 사이의 선 -->
		<div id="line"></div>

		<br> <br>
			<form action="<%= request.getContextPath() %>/noticeWirte.ad" method="get">
		<div class="container" id=area1>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th width="100px" class="name" ></th>
						<th width="180px"><select class="form-control" id="option1" name = "noticeCate">
								<option>선택</option>
								<option>안내</option>
								<option>중요</option>
								<option>긴급</option>
						</select></th>
						<th class="name"><input type="text" size="100px" name = "noticeTitle" style="border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px;"></th>

					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="3" height="450px">

							<div class="form-group">
								<textarea class="form-control" cols="10" rows="25" id="content" name = "noticeContent" style="border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px;"
> </textarea>
							</div>

						</td>
				</tbody>
			</table>
		</div>

		<button type="submit" class="btn btn-warning" id="searchbutton">등록</button>
	</form>
	</div>

	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>