<%@page import="java.util.ArrayList"%>
<%@page import="com.kh.hp.serviceCenter.model.vo.FaQVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<FaQVO> list = (ArrayList<FaQVO>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자주묻는질문</title>
<!-- 아코디언메뉴 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<!-- 폰트 -->
<link href="https://fonts.googleapis.com/css?family=Open+Sans&display=swap" rel="stylesheet">

<style>
body {
	font-family: 'Open Sans', sans-serif;
}

#header {
	text-align: center;
}

#search {
	width: 78%;
	height: 130px;
	border: 3px solid #3479ba;
	/* margin-left:10%; */
	margin: auto;
}

.search1 {
	width: 60%;
	/* padding-left: 45px; */
}

.panel-group {
	width: 87%;
	margin: auto;
}
.form-group {
	width: 20%;
}

</style>


</head>
<body>
<jsp:include page="/views/common/header.jsp" />
	<h3 id="header">
		<b>자주 묻는 질문</b>
	</h3>
	<hr>
	<div id="search">
		<div class="container" style="margin:30px 0 0 15px;">
			<form action="/action_page.php">
						<div class="form-group search col-sm-5">
							<label for="sel1">카테고리 선택</label>
							<select class="form-control" id="sel1">
								<option>전체</option>
								<option>회원</option>
								<option>예약 및 결제</option>
								<option>취소 및 환불</option>
								<option>공간이용 및 후기</option>
								<option>기타</option>
							</select>
						</div>
					</form>
					<label for="sel2">도움말 검색</label>
					<div class="input-group search col-sm-7 search1" id="sel2">
					<input type="text" class="form-control" placeholder="검색어를 입력해주세요."
						name="search">
					<div class="input-group-btn">
						<button class="btn btn-default" type="submit">
							<i class="glyphicon glyphicon-search"></i>&nbsp; 검색
						</button>
					</div>
				</div>

			</form>
		</div>
	</div>
	<br>
	<div class="container">

		<%for(int i=0; i<list.size(); i++){ %>
		<div class="panel-group" id="accordion">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<span><%= list.get(i).getFnqCate() %></span>&nbsp;&nbsp;&nbsp;
						<a data-toggle="collapse" data-parent="#accordion" href="#content<%=i %>" id="title"><%= list.get(i).getFnqQuestion() %></a>
					</h4>
				</div>
				<div id="content<%=i %>" class="panel-collapse collapse">
					<div class="panel-body"><%= list.get(i).getFnqAnswer() %></div>
				</div>
			</div>
		</div>
		<%} %>
	</div>

<jsp:include page="/views/common/footer.jsp" />

</body>
</html>