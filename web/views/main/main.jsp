<%@page import="com.kh.hp.account.model.vo.ReviewMainVO"%>
<%@page import="com.kh.hp.main.model.vo.MainRentVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<MainRentVO> responseMainRentVOList = (ArrayList<MainRentVO>) request.getAttribute("responseMainRentVOList");
	ArrayList<ReviewMainVO> reviewMainVOList = (ArrayList<ReviewMainVO>) request.getAttribute("reviewMainVOList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
<script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>

<!-- 아이콘 -->
<link href="/happyPlaystage/css/common/all.min.css" rel="stylesheet">
<script src="/happyPlaystage/js/common/all.min.js"></script>

<style>
   #picture {
      width:100%;
   }
   #text4 {
      color: #ffb300;
   }
   #text5 {
      color:white;
   }
   #d4 {
      text-align: center;
      font-size: 23px;
   }
   .btns {
      width:300px;
   }
   .ui.cards {
    padding-left: 8%;
}
</style>

</head>
<body>
<jsp:include page="/views/common/header.jsp" />

   <div class="container">
      <div id="myCarousel" class="carousel slide" data-ride="carousel">
         <!-- Indicators -->
         <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
         </ol>

         <!-- Wrapper for slides -->
         <div id="picture">
            <div class="carousel-inner introPic">
               <div class="item active">
                  <img src="/happyPlaystage/images/main/main1.jpg"
                     style="height: 400px; width: 100%">
               </div>

               <div class="item">
                  <img src="/happyPlaystage/images/main/main2.jpg"
                     style="height: 400px; width: 100%">
               </div>

               <div class="item"
                  style="height: 400px; width: 100%; background-image: url(/happyPlaystage/images/main/main3.jpg)">
                  <div id="d4">
                     <br>
                     <br>
                     <br>
                     <br>
                     <br>
                     <p id="text4">
                        <b>우리에게 꼭 맞는 공연장이 필요할땐!</b>
                     </p>
                     <p id="text5">
                        <b>Happy Playstage에서 쉽게 예약하고 등록해 보세요.</b>
                     </p>
                     <br>
                     <br>
                     <div class="container">
                        <button type="button" class="btn btn-warning btns">
                           <b>공연장 찾아보기</b>
                        </button>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <button type="button" class="btn btn-warning btns">
                           <b>공연장 등록하기</b>
                        </button>
                     </div>
                     <br>
                     <br>
                  </div>
                  <!-- <img src="../../images/main/main2.jpg" style="height:400px;  width:100%"> -->
               </div>
            </div>
         </div>
         <!-- Left and right controls -->
         <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span> <span
            class="sr-only">Previous</span>
         </a> <a class="right carousel-control" href="#myCarousel"
            data-slide="next"> <span
            class="glyphicon glyphicon-chevron-right"></span> <span
            class="sr-only">Next</span>
         </a>
      </div>
   </div>

	<!-- 새로 등록된 공간 -->
	<hr>
	<br>
	<br>
	<div>
		<h2 align="center">
			<b>새로 등록된 공간!</b>
		</h2>
	</div>
	<br>
	<br>
	<!-- 카드 -->

	<div class="container" align="center">
		<div class="ui link cards">
			<%for(MainRentVO mainRentVO : responseMainRentVOList) { %>
			<div class="card" align="center" style="width:260px;">
				<div class="image" style="width: 260px; height: 210px">
					<img src="<%=request.getContextPath() %>/images/profilePhotos/<%=mainRentVO.getChangeNm() %>" style="width:100%; height: 100%">
				</div>
				<div class="content">
					<div class="header"><%=mainRentVO.getHallNm() %></div>
					<div class="description"><%=mainRentVO.getAddress() %></div>
				</div>
				<div class="extra content">
					<span class="right floated">
						<i class="far fa-calendar-alt"></i>&nbsp;&nbsp; <%=mainRentVO.getRentEnrollDt() %>
					</span>
					<span  style="float:left">
						<i class="far fa-credit-card"></i>&nbsp;&nbsp; <%=mainRentVO.getRentPrice() %> ￦ / 일
					</span>
				</div>
			</div>
			<%} %>
		</div>
	</div>

	<hr>
	<br>
	<br>
	<!-- 리뷰 -->
	<div>
		<h2 align="center">
			<b>Review</b>
		</h2>
	</div>
	<br>
	<br>
	<!-- 카드 -->
	<div class="container" align="center" id='containerDiv'>
		<div class="ui link cards">
			<%for(ReviewMainVO reviewMainVO : reviewMainVOList) { %>
			<div class="card" align="center" style="width:260px;">

				<div class="image" style="width: 260px; height: 210px">
					<img src="<%=request.getContextPath() %>/images/profilePhotos/<%=reviewMainVO.getChangeNm() %>" style="width:100%; height: 100%">
				</div>
				<div class="content">
					<div class="hallNm"><h3><%=reviewMainVO.getHallNm() %></h3></div>
					<div class="address"><%=reviewMainVO.getAddress() %></div>
					<br><br>
					<span>
						<b>[ <i class="reviewContent"></i><%=reviewMainVO.getReviewContent() %> ]</b>
					</span>
				</div>
				<div class="extra content">
					<span class="rating">
					<%for(int i=0; i<reviewMainVO.getRating(); i++) {%>
							<span style="color:#e6bb00;">★</span>
					<%} %>
					</span>

				</div>
			</div>
			<%} %>
		</div>
	</div>
   <script>
$('.special.cards .image').dimmer({
     on: 'hover'
   });
</script>

<br><br>


<jsp:include page="/views/common/footer.jsp" />
</body>
</html>