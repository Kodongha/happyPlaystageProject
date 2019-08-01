<%@page import="java.util.GregorianCalendar"%>
<%@page import="com.kh.hp.rent.model.vo.RentPropVO"%>
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
<%@page import="com.kh.hp.myPage.model.vo.AhnUsingInfoVO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	ArrayList<AhnUsingInfoVO> list = (ArrayList<AhnUsingInfoVO>) request.getAttribute("list");
	System.out.println("list : " + list);
	ArrayList<Object> rentInfos = (ArrayList<Object>) request.getAttribute("rentInfos");
	RentBasicVO rentBasicVO = (RentBasicVO) rentInfos.get(0);
	ArrayList<CautionsVO> cautionsVOList = (ArrayList<CautionsVO>) rentInfos.get(1);
	ArrayList<FacInfoVO> facInfoVOList = (ArrayList<FacInfoVO>) rentInfos.get(2);
	ArrayList<RentImgVO> rentImgVOList = (ArrayList<RentImgVO>) rentInfos.get(3);
	ArrayList<RentDetVO> rentDetVOList = (ArrayList<RentDetVO>) rentInfos.get(4);
	ArrayList<RentCloseVO> rentCloseVOList = (ArrayList<RentCloseVO>) rentInfos.get(5);
	ArrayList<RentRefundTypeVO> rentRefundTypeVOList = (ArrayList<RentRefundTypeVO>) rentInfos.get(6);
	ArrayList<RentPropVO> rentPropVOList = (ArrayList<RentPropVO>) rentInfos.get(7);

	/* 데이터 가공 */
	String detailIntro = rentBasicVO.getHallDetIntro().replace("\r\n", "<br>");

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	String dateStr = sdf.format(rentBasicVO.getRentEnrollDt());

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<!-- bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<!-- 캘린더 -->
<script type="text/javascript" src="/happyPlaystage/js/common/moment.min.js"></script>
<link rel="stylesheet" href="/happyPlaystage/css/common/daterangepicker.min.css">
<script type="text/javascript" src="/happyPlaystage/js/common/jquery.daterangepicker.min.js"></script>

<style>
div {
		margin:auto;
	}
	
	thead tr {
    background-color: gray;
  
  } 
  td {
    border: 1px solid lightgray;
  }
  
  label {
  	margin-left:auto;
  	margin-right:auto;
  }
  
  tbody tr:nth-child(1) {
    background-color: #b4b4b4;
  }
  
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

<script type="text/javascript">
	$(function(){
		$("#proposeBtn").click(function(){
			$("#propForm").submit();
			/*
			if($("#schedule")){
				$("#schedule").focus();
			} else {
				if($("#headCount")){
					$("#headCount").focus();
				} else {

				}
			}
 			*/
		});
	});
</script>

</head>
<body>
	<jsp:include page="/views/common/header.jsp" />
	<div class="thumb-crop">
		<img class="auto" src="<%=request.getContextPath() %>/images/profilePhotos/<%=rentImgVOList.get(0).getChangeNm() %>" alt="<%=rentImgVOList.get(0).getOriginNm() %>">
	</div>
	
	<br><br>
	
	<table style="width:790px; height:113px; text-align:center; margin:auto; border-collapse: collapse;">
		<tr>
		<td>공연장 고유번호</td>
		<td>상호명</td>
		<td>사용일자</td>
		<td>사용공간 이름</td>
		</tr>
		<tr>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		</tr>
		<tr>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		</tr>
		<tr>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		</tr>
	</table>
	
	<hr>
	
	<div class="container" style="margin-top: 3%;">
		<div class="form-group">
			<h1><%=rentBasicVO.getHallNm() %></h1>
			<h3 style="margin-bottom: 0%">
				<%=rentBasicVO.getHallSimIntro() %><br>
			</h3>
			<h4 style="margin-top: 1%"> <%=dateStr %></h4>

			<br><br>

			<!-- 이미지 -->
			<div class="container" style="width: 70%; float: left">
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

<!-- 결제창 -->
			<div class="container" style="width: 30%; height:510px; background: white; float: right;">
				<br>
				<label style="float: left;"><b>세부공간 선택</b></label><label style="color:red; float: right;"><b>필수선택</b></label>
				<br>
				<hr style="border: solid 1px blue; width: 100%">
				<p align="center">예약을 하시려면 호스트의 승인이 필요합니다. <br>
				승인 후에 호스트가 결제방법을 안내드립니다 !</p>

				<div class="radio" align="center">
					<%for(int i=0; i<rentDetVOList.size(); i++){%>
						<%if(i==0){ %>
						<label><input type="radio" name="rentDetail" checked="checked"><%=rentDetVOList.get(i).getDetAddress() %></label>
						<%} else {%>
						<label><input type="radio" name="rentDetail"><%=rentDetVOList.get(i).getDetAddress() %></label>
						<%} %>
						<label style="color:blue;">&#8361; &nbsp; <%=rentDetVOList.get(i).getRentPrice() %></label> <label style="color:#c2c2c2">/ <%=rentBasicVO.getUseTimeUnit() %></label>
					<%} %>
				</div>
				<div class="container-fluid" style="width:100%; padding: 3% 3% 3% 3%; margin-top: 5%">
					<div class="container" align="center" style="width:100%; height:150px;">
						<img src="<%=request.getContextPath() %>/images/profilePhotos/<%=rentImgVOList.get(0).getChangeNm() %>" alt="<%=rentImgVOList.get(0).getOriginNm() %>" style="object-fit: cover; width: 90%">
					</div>
					<form action="<%=request.getContextPath() %>/movePropose.rt" method="post" id="propForm" name="propForm" autocomplete="off">
						<div>
							<hr>
								<p class="text-muted"> ·  최소 <%=rentBasicVO.getMinRsvTm() %>시간 부터</p>
							<hr>
							<p class="text-muted">* 날짜 선택</p>
							<input name="schedule" class="form-control" id="schedule" placeholder="날짜를 선택하세요.">
							<br>
							<p class="text-muted">* 인원 입력</p>
							<input class="form-control" name="headCount" id="headCount" type="number" step="10" style="width: 100%" placeholder="인원을 입력하세요."/>
							<br>
							<button type="button" class="btn btn-success" id="proposeBtn" style="width: 100%; float: right;">신청</button>
							<script type="text/javascript">
								$('#schedule').dateRangePicker({
									startDate: new Date(),
									selectForward: true,
									autoClose: true,
									showDateFilter: function(time, date)
									{
										return '<div style="padding:0 5px;">\
													<span style="font-weight:bold">'+date+'</span>\
												</div>';
									},
									beforeShowDay: function(t)
									{
										/* var valid = !(t.getDay() == 0 || t.getDay() == 6);  //disable saturday and sunday */
										var date = new Date('2019-07-28');
										/* dateDiff(t, '2019-07-28') */

										<%if(rentPropVOList.size() > 0){ %>
										var valid = !(
												<%
												SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
												String strDate = "";
												for(int i=0; i<rentPropVOList.size(); i++){
													for(int j=0; j<rentPropVOList.get(i).getDiffDate()+1; j++){
														Calendar cal = new GregorianCalendar();
														cal.setTime(rentPropVOList.get(i).getUseStartDt());
														cal.add(Calendar.DAY_OF_YEAR, j);%>
													dateDiff(t, '<%=fm.format(cal.getTime())%>')
													<%if(i == rentPropVOList.size() -1 && j == rentPropVOList.get(i).getDiffDate()){%>
													<%} else {%>||<%}}}%>
													);

										<%} else {%>
										valid = !('');
										<%}%>

										var _class = '';
										var _tooltip = valid ? '' : 'sold out';
										return [valid,_class,_tooltip];
									}
								});

								function dateDiff(_date1, _date2) {
								    var diffDate_1 = _date1 instanceof Date ? _date1 : new Date(_date1);
								    var diffDate_2 = _date2 instanceof Date ? _date2 : new Date(_date2);

								    diffDate_1 = new Date(diffDate_1.getFullYear(), diffDate_1.getMonth()+1, diffDate_1.getDate());
								    diffDate_2 = new Date(diffDate_2.getFullYear(), diffDate_2.getMonth()+1, diffDate_2.getDate());

								    var diff = Math.abs(diffDate_2.getTime() - diffDate_1.getTime());
								    diff = Math.ceil(diff / (1000 * 3600 * 24));
								    if(diff == 0){
									    return true;
								    } else {
								    	return false;
								    }
								}
							</script>
						</div>
						<input type="hidden" name="rentSeq" id="rentSeq" value="<%=rentBasicVO.getRentSeq() %>">
					</form>
				</div>
			</div>


			<!-- 극장 소개 -->
			<div class="container" style="width: 70%; float: left">
				<h2 style="margin-top: 3%">극장 소개</h2>
				<p class="form-control-static" style="width: 70%"><%=detailIntro %></p>

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
</div>


	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>