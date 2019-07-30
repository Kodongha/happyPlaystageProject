<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
 import="java.util.*, com.kh.hp.account.model.vo.*"%>

<%
	ArrayList<ReviewMainVO> list = (ArrayList<ReviewMainVO>) request.getAttribute("reviewMainVOList");
	System.out.println("list::" + list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="/views/common/header.jsp" />

<div class="reviewZone"></div>
	<br>


	<h2 align="center">리뷰ZONE</h2>
		<div class="ui link cards">
		<%for(ReviewMainVO reviewMainVO : list) { %>
			<div class="card" align="center">

				<div class="image" style="width: 290px; height: 210px">
					<img src="<%=request.getContextPath() %>/images/profilePhotos/<%=reviewMainVO.getChangeNm() %>" style="width:100%; height: 100%">
				</div>
				<div class="content">
					<div class="hallNm"><%=reviewMainVO.getHallNm() %></div>
					<div class="address"><%=reviewMainVO.getAddress() %></div>
				</div>
				<div class="extra content">
					<span class="rating">
						<%for(int i=0; i<reviewMainVO.getRating(); i++) {%>
							
						<%} %>
					</span>
					<span>
						<i class="reviewContent"></i><%=reviewMainVO.getReviewContent() %>
					</span>
				</div>
			</div>
			<%} %>
		</div>
</body>
</html>