<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
 import="java.util.*, com.kh.hp.account.model.vo.*"%>
    
  <%--   <%
	ArrayList<ReviewMainVO> list = 
			(ArrayList<ReviewMainVO>) request.getAttribute("list");
    %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/views/common/header.jsp" />

<div class="reviewZone"></div>
	<br>
	
	
	<h2 align="center">리뷰ZONE</h2>
		<div class="ui link cards">
		<%-- 	<%for(ReviewMainVO ReviewMainVO : list) { %> --%>
			<div class="card" align="center">
				
				<div class="image" style="width: 290px; height: 210px">
					<img src=<%-- "<%=request.getContextPath() %>/images/profilePhotos/<%=ReviewMainVO.getChangeNm() %>" --%> style="width:100%; height: 100%">
				</div>
				<div class="content">
					<div class="hallNm"><%-- <%=ReviewMainVO.getHallNm() %> --%></div>
					<div class="address"><%-- <%=ReviewMainVO.getAddress() %> --%></div>
				</div>
				<div class="extra content">
					<span class="rating"><%-- <%=ReviewMainVO.getRating() %> --%></span>
					<span>
						<i class="reviewContent"></i> <%-- <%=ReviewMainVO.getReviewContent() %> --%>
					</span>
				</div>
			</div>
			<%-- <%} %> --%>
		</div>
</body>
</html>