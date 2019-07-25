<%@page import="com.kh.hp.rent.model.vo.RentBasicVO"%>
<%@page import="com.kh.hp.rent.model.vo.RentDetVO"%>
<%@page import="com.kh.hp.rent.model.vo.RentImgVO"%>
<%@page import="com.kh.hp.rent.model.vo.FacInfoVO"%>
<%@page import="com.kh.hp.rent.model.vo.CautionsVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Object> rentInfos = (ArrayList<Object>) request.getAttribute("rentInfos");
	RentBasicVO rentBasicVO = (RentBasicVO) rentInfos.get(0);
	ArrayList<CautionsVO> cautionsVOList = (ArrayList<CautionsVO>) rentInfos.get(1);
	ArrayList<FacInfoVO> facInfoVOList = (ArrayList<FacInfoVO>) rentInfos.get(2);
	ArrayList<RentImgVO> rentImgVOList = (ArrayList<RentImgVO>) rentInfos.get(3);
	ArrayList<RentDetVO> rentDetVOList = (ArrayList<RentDetVO>) rentInfos.get(4);

	String detailIntro = rentBasicVO.getHallDetIntro().replace("\r\n", "<br>");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<style type="text/css">
	h1, h2{
		font-weight: bold;
	}
</style>

</head>
<body>
	<jsp:include page="/views/common/header.jsp" />
<div style="max-width: 100%; height: 200px; margin-top: -15%; overflow: hidden;">
	<img src="<%=request.getContextPath() %>/images/profilePhotos/<%=rentImgVOList.get(0).getChangeNm() %>" alt="<%=rentImgVOList.get(0).getOriginNm() %>" style="max-width: initial;">
</div>

	<div class="container" style="margin-top: 3%;">
		<div class="form-group">
			<h1 style="width: 40%"><%=rentBasicVO.getHallNm() %></h1><label style="float: right"><%=rentBasicVO.getRentEnrollDt() %></label>
			<h3><%=rentBasicVO.getHallSimIntro() %></h3><br><br>

			<!-- 이미지 -->
			<div class="container">
				<div id="myCarousel" class="carousel slide" data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<%for(int i=0; i<rentImgVOList.size(); i++) {
							if(i == 0){%>
								<li data-target="#myCarousel" data-slide-to="<%=i %>" class="active"></li>

							<%} else { %>
								<li data-target="#myCarousel" data-slide-to="<%=i %>"></li>
							<%} %>
						<%} %>
					</ol>

					<!-- Wrapper for slides -->
					<div class="carousel-inner" >

						<%for(int i=0; i<rentImgVOList.size(); i++) {
							if(i == 0){%>
							<div class="item active">
								<img src="<%=request.getContextPath() %>/images/profilePhotos/<%=rentImgVOList.get(i).getChangeNm() %>" alt="<%=rentImgVOList.get(i).getOriginNm() %>" style="width: 100%; height: 510px;">
							</div>
							<%} else { %>
							<div class="item">
								<img src="<%=request.getContextPath() %>/images/profilePhotos/<%=rentImgVOList.get(i).getChangeNm() %>" alt="<%=rentImgVOList.get(i).getOriginNm() %>" style="width: 100%; height: 510px;">
							</div>
							<%} %>
						<%} %>

					</div>
					<!-- Left and right controls -->
					<a class="left carousel-control" href="#myCarousel" data-slide="prev">
						<span class="glyphicon glyphicon-chevron-left"></span>
						<span class="sr-only">Previous</span>
					</a>
					<a class="right carousel-control" href="#myCarousel" data-slide="next">
						<span class="glyphicon glyphicon-chevron-right"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
			</div>

			<br><br>

			<!-- 극장 소개 -->
			<h2>극장 소개</h2>
			<p class="text-muted"><%=detailIntro %></p>

			<br><br>

			<h2>영업 시간 : <%=rentBasicVO.getAvailStartTm() %> ~ <%=rentBasicVO.getAvailEndTm() %></h2>

			<br><br>

			<h2>휴무일</h2>

			<br><br>

			<h2>시설안내</h2><br>
			<%for(FacInfoVO facInfoVO : facInfoVOList){%>
			<p class="text-muted"><b><%=facInfoVO.getFacInfoNo() %>. <%=facInfoVO.getFacInfoContent() %></b></p>
			<hr>
			<%} %>

			<br><br>

			<h2>예약시 주의사항</h2><br>
			<%for(CautionsVO cautionsVO : cautionsVOList){%>
			<p class="text-muted"><b><%=cautionsVO.getCautionNo() %>. <%=cautionsVO.getCautionContent() %></b></p>
			<hr>
			<%} %>



		</div>
	</div>



	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>