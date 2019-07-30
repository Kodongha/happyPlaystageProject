<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.kh.hp.admin.model.vo.* "%>

<%
ArrayList<InspectionListVO> InspectionListVOList = (ArrayList<InspectionListVO>) request
.getAttribute("InspectionListVOList");

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
	margin-left: 100px;
	margin-top: -150px;
}

#users5 {
	width: 100px;
	height: 150px;
	margin-left: 200px;
	margin-top: -150px;
}

#searchtitle {
	width: 100px;
	margin-left: 10px;
	margin-top: 30px;
}

#condition {
	width: 100px;
	margin-left: 10px;
	margin-top: 30px;
}

#approval {
	width: 100px;
	margin-left: 23px;
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

#select1 {
	width: 110px;
	margin-left: -15px;
}

#select2 {
	width: 110px;
	margin-left: -15px;
}

#searchbutton {
	margin-left: 330px;
	margin-top: 40px;
}
.pagingArea{
margin-top: -100px;
margin-left: 600px;
}
</style>

</head>
<body>
	<jsp:include page="/views/common/header.jsp" />
	<div id="center" class="fram">
		<!-- 타이틀 -->
		<h2 id="text1">
			<strong>대관 등록 검수 리스트</strong>

		</h2>
		<!-- 회원관리내역과 검색창 사이의 선 -->
		<div id="line"></div>
		<br>

		<!--검색영역 -->
		<div id="search">
			<div id="users1">
				<label id="searchtitle">공연장명</label>
				<div id="input">
					<input class="form-control" id="ex1" type="text"
						style="width: 250px;">
				</div>


				<label id="searchtitle">회원명</label>
				<div id="input">
					<input class="form-control" id="ex1" type="text"
						style="width: 250px;">
				</div>

			</div>

			<div id="users2">
				<label id="condition" style="width: 100px">검수상태</label>

			</div>

			<div id="users3">
				<div class="col-sm-2">
					<select class="form-control" id="select1">
						<option>선택</option>
						<option>검수대기</option>
						<option>검수완료</option>
					</select>
				</div>



				<div id="users4">


					<button type="button" class="btn btn-warning" id="searchbutton">검색</button>

				</div>
			</div>

			<br>
			<br>
			<div class="container">

				<table class="table">
					<thead>
						<tr>
							<th>대관고유번호</th>
							<th>공연장명</th>
							<th>이메일</th>
							<th>연락처</th>
							<th>공연장등록증첨부파일</th>
							<th>검수상태</th>
						</tr>
						<%
									for (InspectionListVO  InspectionList : InspectionListVOList) {
								%>
					</thead>
					<tbody>
						<tr>
						<tr onclick="location.href='<%=request.getContextPath()%>/detailInspection.ad?rentSeq=<%=InspectionList.getRentSeq() %>'">
							<td><%=InspectionList.getRentSeq() %></td>
							<td><%=InspectionList.getHallNm() %></td>
							<td><%=InspectionList.getUserEmail() %></td>
							<td><%=InspectionList.getUserPhone() %></td>
							<td><%=InspectionList.getOriginNm() %></td>

							<%if(InspectionList.getInspTf() == 'Y'){%>
							<td>검수완료</td>
						<%} else {%>
							<td>검수대기</td>
						<%} %>

						</tr>
						<% } %>

					</tbody>
				</table>
			</div>



		</div>

	</div>
	<div class="pagingArea">
			<button onclick="location.href='<%=request.getContextPath()%>/inspectionList.ad?currentPage=1'"><<</button>

			<% if(currentPage <= 1){ %>
			<button disabled><</button>
			<% }else { %>
			<button onclick="location.href='<%=request.getContextPath()%>/inspectionList.ad?currentPage=<%=currentPage - 1%>'"><</button>
			<% } %>

			<% for(int p = startPage; p <= endPage; p++){
				if(currentPage == p){
			%>
					<button disabled><%= p %></button>
			<% } else { %>
					<button onclick="location.href='<%=request.getContextPath()%>/inspectionList.ad?currentPage=<%=p%>'"><%= p %></button>
			<%
				}
			   }
			%>

			<% if(currentPage >= maxPage){ %>
			<button disabled>></button>
			<% }else{ %>
			<button onclick="location.href='<%=request.getContextPath()%>/inspectionList.ad?currentPage=<%=currentPage + 1%>'">></button>
			<% } %>

			<button onclick="location.href='<%=request.getContextPath()%>/inspectionList.ad?currentPage=<%=maxPage%>'">>></button>
		</div>
	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>