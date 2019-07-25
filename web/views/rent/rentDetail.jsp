<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.kh.hp.rent.model.vo.RentRefundTypeVO"%>
<%@page import="com.kh.hp.rent.model.vo.RentCloseVO"%>
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
	ArrayList<RentCloseVO> rentCloseVOList = (ArrayList<RentCloseVO>) rentInfos.get(5);
	ArrayList<RentRefundTypeVO> rentRefundTypeVOList = (ArrayList<RentRefundTypeVO>) rentInfos.get(6);



	Calendar cal = Calendar.getInstance();
	cal.setTime(rentBasicVO.getRentEnrollDt());
	int dayNum = cal.get(Calendar.DAY_OF_WEEK) ;
	String day = "";
	switch(dayNum){
    case 1:
        day = "일";
        break ;
    case 2:
        day = "월";
        break ;
    case 3:
        day = "화";
        break ;
    case 4:
        day = "수";
        break ;
    case 5:
        day = "목";
        break ;
    case 6:
        day = "금";
        break ;
    case 7:
        day = "토";
        break ;
	}
	day += "요일";

	/* 데이터 가공 */
	String detailIntro = rentBasicVO.getHallDetIntro().replace("\r\n", "<br>");

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
	String dateStr = sdf.format(rentBasicVO.getRentEnrollDt());
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
	h1, h2 {
		font-weight: bold;
	}

	.thumb-crop {
	  margin-top: -1%;
	  display:inline-block;

	  position: relative;
	  width: 100%;
	  height: 350px;
	  border: 1px solid #000;
	  overflow: hidden;
	}
	.thumb-crop img {
	  position: absolute;
	  left: 50%;
	  top: 50%;
	  height: 100%;
	  width: auto;
	  -webkit-transform: translate(-50%,-50%);
	      -ms-transform: translate(-50%,-50%);
	          transform: translate(-50%,-50%);
	}

	.thumb-crop .portrait {
	  width: 100%;
	  height: auto;
	}

	.thumb-crop .auto {
	  width: auto;
	  height: auto;
	}
</style>

</head>
<body>
	<jsp:include page="/views/common/header.jsp" />
	<div class="thumb-crop">
		<img class="auto" src="<%=request.getContextPath() %>/images/profilePhotos/<%=rentImgVOList.get(0).getChangeNm() %>" alt="<%=rentImgVOList.get(0).getOriginNm() %>">
	</div>

	<div class="container" style="margin-top: 3%;">
		<div class="form-group">
			<h1><%=rentBasicVO.getHallNm() %></h1>
			<h3 style="margin-bottom: 0%">
				<%=rentBasicVO.getHallSimIntro() %><br>
			</h3>
			<h4 style="margin-top: 1%"> <%=dateStr %></h4>

			<br><br>


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
			<p class="form-control-static"><%=detailIntro %></p>

			<br><br>

			<!-- 영업시간 -->
			<h2 style="display: inline;">영업 시간 : </h2>
			<h3 style="display: inline;"><%=rentBasicVO.getAvailStartTm() %> ~ <%=rentBasicVO.getAvailEndTm() %></h3>

			<br><br><br><br>

			<!-- 휴무일 -->
			<h2 style="display: inline;">휴무일 : </h2>
			<h3 style="display: inline;"><%=rentCloseVOList.get(0).getRegCloseNm() %></h3>

			<br><br><br><br>

			<!-- 시설안내 -->
			<h2>시설안내</h2><br>
			<%for(FacInfoVO facInfoVO : facInfoVOList){%>
			<p class="text-muted"><b><%=facInfoVO.getFacInfoNo() %>. <%=facInfoVO.getFacInfoContent() %></b></p>
			<hr>
			<%} %>

			<br><br>

			<!-- 주의사항 -->
			<h2>예약시 주의사항</h2><br>
			<%for(CautionsVO cautionsVO : cautionsVOList){%>
			<p class="text-muted"><b><%=cautionsVO.getCautionNo() %>. <%=cautionsVO.getCautionContent() %></b></p>
			<hr>
			<%} %>

			<br><br>

			<!-- 환불 규정 -->
			<h2 style="display: inline;">환불 규정 안내</h2><br>
			<h5 style="color:red; ">* 이용당일(첫 날) 이후에 환불 관련 사항은 호스트에게 직접 문의하셔야 합니다.</h5>
			<br>

			<div class="contains">
				<table class="table table-condensed" style="width: 50%">
					<tr>
						<th><p class="text-muted"><b>이용 전 일자</b></p></th>
						<th><p class="text-muted"><b>환불 %</b></p></th>
					</tr>
				<%for(int i=rentRefundTypeVOList.size()-1; i >= -1; i--){ %>

						<tr>
							<%if(i == -1){ %>
								<td><p class="text-muted">이용 당일</p></td>
							<%} else if(i == 0){%>
								<td><p class="text-muted">이용 전날</p></td>
							<%} else {%>
								<td><p class="text-muted">이용 <%=rentRefundTypeVOList.get(i).getDtCd() %>일 전</p></td>
							<%} %>

							<%if(i != -1){ %>
								<td><p class="text-muted">총 금액의 <%=rentRefundTypeVOList.get(i).getRefundDeductPer() %>% 환불</p></td>
							<%} else {%>
								<td><p class="text-muted">환불 불가</p></td>
							<%} %>

						</tr>

				<%} %>
				</table>
			</div>

			<br><br>

			<!-- 회사 소개 -->
			<h2>업체 정보</h2><br>

			<table class="table" style="width: 50%">
				<tr>
					<td><label>대표자</label></td>
					<td><%=rentBasicVO.getCeoNm()%></td>
				</tr>
				<tr>
					<td><label>상호명</label></td>
					<td><%=rentBasicVO.getCompNm() %></td>
				</tr>
				<tr>
					<td><label>전화번호</label></td>
					<td><%=rentBasicVO.getRentMainTel() %></td>
				</tr>
				<tr>
					<td><label>주소</label></td>
					<td><%=rentBasicVO.getAddress() %></td>
				</tr>
				<tr>
					<td><label>웹사이트</label></td>
					<td><%=rentBasicVO.getWebsite() %></td>
				</tr>
			</table>





			<br>

			<div id="map" style="width:500px;height:400px;"></div>
			<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=ea861fadd8d5b486bbcd4ae127c3404d&libraries=services"></script>
			<script type="text/javascript">
				//지도를 미리 생성
				var mapContainer = document.getElementById('map'), // 지도를 표시할 div
				    mapOption = {
				        center: new daum.maps.LatLng(37.537187, 127.005476), // 지도의 중심좌표
				        level: 5 // 지도의 확대 레벨
				    };



				var map = new daum.maps.Map(mapContainer, mapOption);
				//주소-좌표 변환 객체를 생성
				var geocoder = new daum.maps.services.Geocoder();
				var callback = function(result, status) {
				    if (status === kakao.maps.services.Status.OK) {
				    	var map_result = result[0]; //첫번째 결과의 값을 활용

                        // 해당 주소에 대한 좌표를 받아서
                        var coords = new daum.maps.LatLng(map_result.y, map_result.x);
                        // 지도를 보여준다.
                        mapContainer.style.display = "block";
                        map.relayout();
                        // 지도 중심을 변경한다.
                        map.setCenter(coords);
                        // 마커를 결과값으로 받은 위치로 옮긴다.
                        marker.setPosition(coords);

				    }
				};
				geocoder.addressSearch('<%=rentBasicVO.getAddress() %>', callback);

				//마커를 미리 생성
				var marker = new daum.maps.Marker({
				    position: new daum.maps.LatLng(37.537187, 127.005476),
				    map: map
				});

			</script>

			<script type="text/javascript">

			</script>

		</div>
	</div>



	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>