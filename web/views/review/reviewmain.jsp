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

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
<script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>

<script type="text/javascript" src="/happyPlaystage/js/common/jquery.oLoader.min.js"></script>






<style>
	.ui.cards {
    padding-left: 14%;
	}
	#search {
		text-align:center;
	}
</style>

</head>
<body>
<jsp:include page="/views/common/header.jsp" />

<%-- <div class="reviewZone"></div>
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
		</div> --%>
		
	<h2 align="center">리뷰ZONE</h2>
	<p align="center">이용자들의 생생한 후기를 만나보세요</p>
<hr>

	<div class="container" align="center" id='containerDiv'>
		<div class="ui link cards">
			<%for(ReviewMainVO reviewMainVO : list) { %>
			<div class="card" align="center">
			
				<input type="hidden" value="422" id="rentSeq">
				<div class="image" style="width: 290px; height: 210px">
					<img src="<%=request.getContextPath() %>/images/profilePhotos/<%=reviewMainVO.getChangeNm() %>" style="width:100%; height: 100%">
				</div>
				<div class="content">
					<div class="hallNm"><h3><%=reviewMainVO.getHallNm() %></h3></div>
					<div class="address"><%=reviewMainVO.getAddress() %></div>
				</div>
				<div class="extra content">
					<span class="rating">
					<%for(int i=0; i<reviewMainVO.getRating(); i++) {%>
							★
					<%} %>
					</span>
					<span>
						<i class="reviewContent"></i><%=reviewMainVO.getReviewContent() %>
					</span>
				</div>
			</div>
				<%} %>
		</div>
</div>

		
		
		
		
</body>
</html>