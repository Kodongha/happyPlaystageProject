<%@page import="com.kh.hp.account.model.vo.ReviewSearchVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<% ArrayList<ReviewSearchVO> ReviewSearchVO = (ArrayList<ReviewSearchVO>) request.getAttribute("ReviewSearchVO");  %>
		
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

<title>리뷰</title>


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

#area {
	border: 2px solid black;
	width: 1000px;
	height: 100PX;
	margin: auto;
}

#area1 {
	border: 1px solid black;
	width: 600px;
	height: 50px;
	margin-left: 240px;
	margin-top: -45px;
}

#Information {
	font-weight: bold;
	font-size: 30px;
	margin-left: 10px;
	margin-top: 25px;
}

#searchbutton {
	margin-left: 900px;
	margin-top: -70px;
}
</style>

</head>
<body>
	<jsp:include page="/views/common/header.jsp" />

	<h2 id="text1" align="center">
		<strong>리뷰</strong>

	</h2>
	<br>
	<!-- 회원관리내역과 검색창 사이의 선 -->
	<div id="line"></div>
	<br>

	<form action="<%=request.getContextPath()%>/reviewSh.acc" method="post">
		<div id="area">
			<div id="Information">
				예약번호 : &nbsp; <input type="text" placeholder="예약 번호" name="search"
					id="search" style="width: 60%">
			</div>
					<input type="submit" class="btn btn-warning" id="searchbutton" value="등록">
		</div>
		</form>
		
		<br><br>
		<div class="container">
	
			<table class="table table-hover">
				<thead>
					<tr style="background-color: #FACC2E;" align="center">
						<td>예약 번호</td>
						<td>공연장 명</td>
						<td>주소</td>
						<td>사용 날짜</td>
					</tr>
				
				</thead>
				<% for(int i=0; i<ReviewSearchVO.size(); i++) { %>
				<tr align="center">
					<td><%= ReviewSearchVO.get(i).getPropSeq()%></td>
					<td><%= ReviewSearchVO.get(i).getHallNm() %></td>
					<td><%= ReviewSearchVO.get(i).getAddress()%></td>
					<td><%= ReviewSearchVO.get(i).getUseStartDt()%> ~ <%= ReviewSearchVO.get(i).getUseEndDt()%></td>
				</tr>
				<% } %>
			</table>
</div>	
	

	
	
	<br><br><br><br><br><br><br><br>
	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>