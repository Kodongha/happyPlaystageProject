<%@page import="com.kh.hp.serviceCenter.model.vo.PageInfo"%>
<%@page import="com.kh.hp.serviceCenter.model.vo.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<Notice> list = (ArrayList<Notice>) request.getAttribute("list");
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
<title>공지사항</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<!-- 폰트 -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans&display=swap"
	rel="stylesheet">

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
	border: 3px solid #f5b342;
	/* margin-left:10%; */
	margin: auto;
}

#notice {
	width: 80%;
	padding-left: 45px;
}

.panel-group {
	width: 87%;
	margin: auto;
}
/* #d1 {
	font-size:15px;
	padding:15px;
	padding-left:45px;
	padding-top:20px;
} */
#noticeForm {
	padding: 15px;
	padding-top: 25px;
}

#noticeLabel {
	padding-left: 45px;
}
</style>

</head>
<body>
	<jsp:include page="/views/common/header.jsp" />
	<h3 id="header">
		<b>공지사항</b>
	</h3>
	<hr>
	<div id="search">
		<div class="container">
			<form action="<%=request.getContextPath()%>/searchNotice.sc"
				method="get" id="noticeForm">
				<label for="notice" id="noticeLabel">공지사항 검색</label>
				<!-- <div id="d1">공지사항 검색</div> -->
				<div class="input-group" id="notice">
					<input type="text" class="form-control" placeholder="검색어를 입력해주세요."
						name="searchValue">
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
		<%
			for (int i = 0; i < list.size(); i++) {
		%>
		<div class="panel-group" id="accordion">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<span>[<%=list.get(i).getNoticeCate()%>]
						</span>&nbsp;&nbsp;&nbsp; <a data-toggle="collapse"
							data-parent="#accordion" href="#content<%=i%>"><%=list.get(i).getNoticeTitle()%></a>
					</h4>
				</div>
				<div id="content<%=i%>" class="panel-collapse collapse">
					<div class="panel-body"><%=list.get(i).getNoticeContent()%></div>
				</div>
			</div>
		</div>
		<%
			}
		%>
	</div>
	<br>
	<%-- 페이징처리 --%>
	<div class="pagingArea" align="center">
		<!-- 가장 첫 페이지로 이동 -->
		<button
			onclick="location.href='<%=request.getContextPath()%>/notice.sc?currentPage=1'"><<</button>

		<!-- 이전페이지 -->
		<%
			if (currentPage <= 1) {
		%>
		<button disabled><</button>
		<%
			} else {
		%>
		<button
			onclick="location.href='<%=request.getContextPath()%>/notice.sc?currentPage=<%=currentPage - 1%>'"><</button>
		<%
			}
		%>

		<!-- 숫자 버튼 -->
		<div class="container">
			<ul class="pagination">
				<%
					for (int p = startPage; p <= endPage; p++) {
						if (currentPage == p) {
				%>
				<li><a><%=p%></a></li>
				<%
					} else {
				%>
				<li><a href="<%=request.getContextPath()%>/notice.sc?currentPage=<%=p%>"><%=p%></a></li>
				<%
					}
					}
				%>
			</ul>
		</div>

		<!-- 다음 페이지 -->
		<%
			if (currentPage >= maxPage) {
		%>
		<button disabled>></button>
		<%
			} else {
		%>
		<button
			onclick="location.href='<%=request.getContextPath()%>/notice.sc?currentPage=<%=currentPage + 1%>'">></button>
		<%
			}
		%>

		<!-- 가장 마지막 페이지로 이동 -->
		<button
			onclick="location.href='<%=request.getContextPath()%>/notice.sc?currentPage=<%=maxPage%>'">>></button>

	</div>


	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>