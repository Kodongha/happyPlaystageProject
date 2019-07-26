<%@page import="com.kh.hp.rent.model.vo.DetFacAndRentDetFacVO"%>
<%@page import="com.kh.hp.rent.model.vo.RentPropVO"%>
<%@page import="com.kh.hp.rent.model.vo.RentDetVO"%>
<%@page import="com.kh.hp.rent.model.vo.RentDetFacVO"%>
<%@page import="com.kh.hp.rent.model.vo.RentImgVO"%>
<%@page import="com.kh.hp.rent.model.vo.CautionsVO"%>
<%@page import="com.kh.hp.rent.model.vo.RentBasicVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Object> rentInfoList = (ArrayList<Object>) request.getAttribute("rentInfoList");

	RentBasicVO rentBasicVO = (RentBasicVO) rentInfoList.get(0);
	ArrayList<CautionsVO> cautionsVOList = (ArrayList<CautionsVO>) rentInfoList.get(1);
	ArrayList<RentImgVO> rentImgVOList = (ArrayList<RentImgVO>) rentInfoList.get(2);
	ArrayList<DetFacAndRentDetFacVO> rentDetFacVOList = (ArrayList<DetFacAndRentDetFacVO>) rentInfoList.get(3);
	ArrayList<RentDetVO> rentDetVOList = (ArrayList<RentDetVO>) rentInfoList.get(4);
	RentPropVO rentPropVO = (RentPropVO) rentInfoList.get(5);

	System.out.println("view in");
	System.out.println(rentBasicVO);
	System.out.println(cautionsVOList);
	System.out.println(rentImgVOList);
	System.out.println(rentDetFacVOList);
	System.out.println(rentDetVOList);
	System.out.println(rentPropVO);
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

<!-- 아이콘 -->
<link href="/happyPlaystage/css/common/all.min.css" rel="stylesheet">
<script src="/happyPlaystage/js/common/all.min.js"></script>
<style type="text/css">
	h1, h2, h4 {
		font-weight: bold;
	}
	.detFacIcon {
		font-size: 4em;
		color: black;
		align-content: center;
		display: table-cell;
    	vertical-align: middle;
    	display:inline;
    	float: left;
    	padding: 2% 2% 2% 2%;
		background:white;
	}

	.necessary {
		color: red;
	}
</style>
</head>
<body>
	<jsp:include page="/views/common/header.jsp" />

	<div class="container" style="margin-top: 3%;">
		<div class="form-group">
			<h1>예약 공간</h1>
			<hr>
			<div class="container" style="width: 40%; float: left">
				<img src="<%=request.getContextPath() %>/images/profilePhotos/<%=rentImgVOList.get(0).getChangeNm() %>" alt="<%=rentImgVOList.get(0).getOriginNm() %>" style="object-fit: cover; width: 90%">
			</div>
			<div class="container" style="width: 60%; background: white; float: right;">
				<h2><%=rentBasicVO.getHallNm() %></h2>
				<hr>
				<h3><%=rentBasicVO.getHallSimIntro() %></h3>
			</div>
		</div>
	</div>

	<div class="container">
		<hr>
		<h4 style="display:inline;">예약 가능 인원</h4>
		<p class="text-muted" style="display:inline; padding-left: 5%;">최소 1명 ~ <%=rentDetVOList.get(0).getMaxHeadCount() %>명</p>
		<hr>
	</div>

	<!-- 시설 세부항목 -->
	<div class="container">
		<div class="container">
			<%for(int i=0; i<rentDetFacVOList.size(); i++) {%>
			<div class="detFacIcon" align="center" id="detFacIcon_<%=rentDetFacVOList.get(i).getDetFacSeq() %>">
				<div style="display:inline;" align="center">
					<i class="detFacIconITag <%=rentDetFacVOList.get(i).getDetFacImgPath() %>" style="width: 90px; height: 50px;"></i>
					<div>
						<label style="font-size: 12px;"><%=rentDetFacVOList.get(i).getDetFacNm() %></label>
					</div>
				</div>
			</div>
			<%} %>
		</div>
	</div>


	<form action="">
		<div class="container" style="padding-top: 5%">

			<h2>예약 정보</h2>
			<hr>
			<h4 style="display:inline;">예약 날짜</h4>
			<p class="text-muted" style="display:inline; padding-left: 5%;"><%=rentPropVO.getUseStartDt() %> ~ <%=rentPropVO.getUseEndDt() %></p>
			<br><br>
			<h4 style="display:inline;">예약 인원</h4>
			<p class="text-muted" style="display:inline; padding-left: 5%;"><%=rentPropVO.getPropHeadCount() %> 명</p>
	 	</div>

	 	<div class="container" style="padding-top: 5%">
			<h2>예약자 정보</h2>
			<hr>
			<!-- 예약자 -->
			<h4 style="display:inline;"><label class="necessary">*</label>예약자</h4>
			<input type="text" class="form-control">
			<br><br>

			<!-- 휴대폰 -->
			<h4 style="display:inline;"><label class="necessary">*</label>휴대폰</h4><br>
			<select class="form-control" name="rentPhone1" id="rentPhone1" style="width: 100px; min-width: 100px; display:inline; margin: 0 2% 0 0">
				<option>010</option>
				<option>011</option>
				<option>016</option>
				<option>017</option>
				<option>019</option>
			</select>
			<label>-</label>
			<input id="rentPhone2" type="tel" class="form-control" name="rentPhone2" style="width: 100px; min-width: 100px; display:inline; margin: 0 2% 0 2%">
			<label>-</label>
			<input id="rentPhone3" type="tel" class="form-control" name="rentPhone3" style="width: 100px; min-width: 100px; display:inline; margin: 0 2% 0 2%">
			<br><br><br>

			<!-- 이메일 -->
			<h4 style="display:inline;"><label class="necessary">*</label>이메일</h4>
			<input type="email" class="form-control">
			<br>

			<!-- 요청사항 -->
			<h4 style="display:inline;"><label class="necessary">*</label>요청사항</h4>
			<textarea class="form-control" rows="5" name="hallDetIntro" id="hallDetIntro" placeholder="공연장 상세 소개를 입력해주세요." style="resize:none"></textarea>
			<br>
			<h4 style="display:inline;"><label class="necessary">*</label>공연 계획서 첨부</h4>

			<!-- 공연 계획서 첨부 -->
			<div class="form-group">
				<input type="text" class="col-sm-10 col-xs-10 form-control" name="hallRegisCerPath" id="hallRegisCerPath" placeholder="공연계획서를 첨부해주세요." style="width: 80%" readonly="readonly">
				<button type="button" id="hallRegisCerPathAddBtn" class="col-sm-2 col-xs-2 btn btn btn-primary" style="width: 15%; float: right;">첨부</button>
			</div>



		</div>
	</form>

	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>