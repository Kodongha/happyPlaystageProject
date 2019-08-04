<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.kh.hp.admin.model.vo.* "%>

<%
	ArrayList<SetRegPermissionsVO> SetRegPermissionsVOList = (ArrayList<SetRegPermissionsVO>) request
			.getAttribute("SetRegPermissionsVOList");

	PageInfo pi = (PageInfo) request.getAttribute("pi");
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
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

#users1 {
	width: 500px;
	height: 150px;
	margin-left: 50px;
}

#users4 {
	width: 100px;
	height: 150px;
	margin-left: 700px;
	margin-top: -150px;
}

#users5 {
	width: 100px;
	height: 150px;
	margin-left: 800px;
	margin-top: -150px;
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

#select {
	width: 100px;
	margin-left: -15px;
	margin-top: 25px;
}

#searchbutton {
	margin-left: 330px;
	margin-top: 40px;
}

.button {
	width: 35px;
	background: E6E6E6;
	border: none;
	border-radius: 6px 6px 6px 6px;
}

.button:hover {
	background: darkgray;
}

tbody>tr:hover {
	background: #e6f2ff;
}

tbody>tr:active {
	background: #cce6ff;
}

.pagingArea {
	margin-top: -300px;
	margin-left: 600px;
}
</style>

</head>
<body>
	<jsp:include page="/views/common/header.jsp" />
	<div id="center" class="fram">
		<!-- 타이틀 -->
		<h2 id="text1">
			<strong>대관 등록 권한 설정</strong>

		</h2>
		<!-- 회원관리내역과 검색창 사이의 선 -->
		<div id="line"></div>
		<br>

		<!--검색영역 -->
		<form action="<%=request.getContextPath() %>/searchSetReg.ad" method="get">
			<div id="search">
				<div id="users1">
					<label id="userno">회원번호</label>
					<div id="input">
						<input class="form-control" id="userSeq1" name ="userSeq1" type="text"
							style="width: 100px;">
					</div>
					<div id="wave">~</div>
					<div id="input1">
						<input class="form-control" id="userSeq2" name="userSeq2" type="text"
							style="width: 100px;">
					</div>

					<label id="userno">회원명</label>
					<div id="input">
						<input class="form-control" id="userNm" name ="userNm" type="text"
							style="width: 250px;">
					</div>
				</div>



				<div id="users4">
					<label id="userno">등록구분</label>
				</div>
				<div id="users5">
					<div class="col-sm-2" id="select">
						<select class="form-control" id="userGradeStatus"  name= "userGradeStatus" style="width: 100px">
							<option>선택</option>
							<option>승인대기</option>
							<option>승인완료</option>
						</select>
					</div>
					<button type="submit" class="btn btn-warning" id="searchbutton">검색</button>
				</div>
			</div>
		</form>
		<br> <br>

		<div class="container">

			<table class="table">
				<thead>
					<tr>
						<th>회원번호</th>
						<th>이름</th>
						<th>연락처</th>
						<th>공연장등록증첨부파일</th>
						<th>등록구분</th>
						<th>승인유무</th>
					</tr>

				</thead>

				<tbody>
					<%
							for (SetRegPermissionsVO SetRegPermissions : SetRegPermissionsVOList) {
						%>
					<tr>
						<td><%=SetRegPermissions.getUserSeq()%></td>
						<td><%=SetRegPermissions.getUserNm()%></td>
						<td><%=SetRegPermissions.getUserPhone()%></td>
						<td><%=SetRegPermissions.getOriginNm()%></td>
						<%
								if (SetRegPermissions.getUserGradeCd() == 1) {
							%>
						<td>승인대기</td>
						<%
								} else {
							%>
						<td>승인완료</td>
						<%
								}
							%>



						<td><input type="button" value="O" class="button"
							onclick="location.href='<%=request.getContextPath()%>/updateSetReg.ad?userSeq=<%=SetRegPermissions.getUserSeq() %>'">
							<input type="button" value="X" class="button"
							onclick="location.href='<%=request.getContextPath()%>/cancelSetReg.ad?userSeq=<%=SetRegPermissions.getUserSeq() %>'">
						</td>
					</tr>
					<%
							}
						%>
				</tbody>
			</table>
		</div>

	</div>
	<%-- <div class="pagingArea">
		<button
			onclick="location.href='<%=request.getContextPath()%>/selectAllUser.ad?currentPage=1'"><<</button>

		<%
			if (currentPage <= 1) {
		%>
		<button disabled><</button>
		<%
			} else {
		%>
		<button
			onclick="location.href='<%=request.getContextPath()%>/selectAllUser.ad?currentPage=<%=currentPage - 1%>'"><</button>
		<%
			}
		%>

		<%
			for (int p = startPage; p <= endPage; p++) {
				if (currentPage == p) {
		%>
		<button disabled><%=p%></button>
		<%
			} else {
		%>
		<button
			onclick="location.href='<%=request.getContextPath()%>/selectAllUser.ad?currentPage=<%=p%>'"><%=p%></button>
		<%
			}
			}
		%>

		<%
			if (currentPage >= maxPage) {
		%>
		<button disabled>></button>
		<%
			} else {
		%>
		<button
			onclick="location.href='<%=request.getContextPath()%>/selectAllUser.ad?currentPage=<%=currentPage + 1%>'">></button>
		<%
			}
		%>

		<button
			onclick="location.href='<%=request.getContextPath()%>/selectAllUser.ad?currentPage=<%=maxPage%>'">>></button>
	</div> --%>
	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>