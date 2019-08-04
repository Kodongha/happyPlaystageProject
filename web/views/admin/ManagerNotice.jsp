<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,  com.kh.hp.admin.model.vo.*"%>
<%
	ArrayList<NoticeVO> Noticelist = (ArrayList<NoticeVO>) request.getAttribute("Noticelist");


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

<title>Insert title here</title>


<style>
#center {
	/*    border: 1px solid black; */
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

#area {
	border: 1px solid gray;
	width: 1200px;
	height: 150px;
	margin-left: 50px;
	border-top-left-radius: 8px;
	border-top-right-radius: 8px;
	border-bottom-left-radius: 8px;
	border-bottom-right-radius: 8px;
}

#users1 {
	width: 500px;
	height: 150px;
	margin-left: 50px;
}

#users2 {
	width: 100px;
	height: 150px;
	margin-left: 480px;
	margin-top: -150px;
}

#users3 {
	width: 100px;
	height: 150px;
	margin-left: 570px;
	margin-top: -150px;
}

#users4 {
	width: 100px;
	height: 150px;
	margin-left: 150px;
	margin-top: -150px;
}

#users5 {
	width: 100px;
	height: 150px;
	margin-left: 200px;
	margin-top: -150px;
}

#userno {
	width: 100px;
	margin-left: 10px;
	margin-top: 30px;
}

#userno1 {
	width: 100px;
	margin-left: -50px;
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

#select {
	width: 100px;
	margin-left: -15px;
	margin-top: 25px;
}

#searchbutton {
	margin-left: 330px;
	margin-top: 40px;
}

.pagingArea {
	margin-top: -100px;
	margin-left: 600px;
}

tbody>tr:hover {
	background: #e6f2ff;
}

tboydy>tr:active {
	background: #cce6ff;
}

#writebutton {
	margin-left: 1080px;
}
</style>

</head>
<body>
	<jsp:include page="/views/common/header.jsp" />
	<div id="center" class="fram">

		<h2 id="text1">
			<strong>공지사항-관리자</strong>

		</h2>

		<div id="line"></div>
		<br>

		<form action="<%=request.getContextPath()%>/noticeSearch.ad" method="get">
			<div id="area">
				<div id="users1">
					<label id="userno">검색</label>
					<div id="input">
						<input class="form-control"  name="search" type="text" style="width: 250px;">
					</div>
				</div>

				<div id="users2"></div>

				<div id="users3">
					<div class="col-sm-2"></div>



					<div id="users4">
						<label id="userno1">공지유무</label>
					</div>


					<div id="users5">
						<div class="col-sm-2" id="select">
							<select class="form-control" id="noticeCate" name="cate" style="width: 100px">
								<option>선택</option>
								<option>안내</option>
								<option>중요</option>
								<option>긴급</option>
							</select>
						</div>
						<button type="submit" class="btn btn-warning" id="searchbutton">검색</button>
					</div>
				</div>
			</div>
		</form>
		
		<br> <br>
		<form action="<%=request.getContextPath()%>/selectNotice.ad"
			method="get" id="userSearchForm">
			<div class="container">
				<table class="table">
					<thead>
						<tr>
							<th>번호</th>
							<th>구분</th>
							<th>제목</th>
							<th>작성일</th>
						</tr>
						<%
							for (NoticeVO Notice : Noticelist) {
						%>
					</thead>
					<tbody>
						<tr
							onclick="location.href='<%=request.getContextPath()%>/detailNotice.ad?noticeSeq=<%=Notice.getNoticeSeq()%>'">
							<td><%=Notice.getNoticeSeq()%></td>
							<td><%=Notice.getNoticeCate()%></td>
							<td><%=Notice.getNoticeTitile()%></td>
							<td><%=Notice.getNoticeWrDt()%></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
				</div>
		</form>
		<button type="button" class="btn btn-warning" id="writebutton"
			onclick="location.href='<%=request.getContextPath()%>/views/admin/10_noticeWirte.jsp'">등록</button>

	</div>

	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>