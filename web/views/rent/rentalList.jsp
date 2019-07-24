<%@page import="com.kh.hp.rent.model.vo.PageInfo"%>
<%@page import="com.kh.hp.rent.model.vo.RentListVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	ArrayList<RentListVO> list = (ArrayList<RentListVO>) request.getAttribute("list");
	PageInfo pi = (PageInfo) request.getAttribute("pi");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
<script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>

<style>
	.ui.cards {
    padding-left: 14%;
	}
	#search {
		text-align:center;
	}
</style>

<title>Insert title here</title>
</head>
<body>
<jsp:include page="/views/common/header.jsp" />

<div id="search">

	<label for="location">지역</label>
<div class="ui compact menu">
  <div class="ui simple dropdown item" name="location">
    지역
    <i class="dropdown icon"></i>
    <div class="menu">
      <div class="item">Choice 1</div>
      <div class="item">Choice 2</div>
      <div class="item">Choice 3</div>
    </div>
   </div>
    &nbsp;&nbsp;&nbsp;&nbsp;
  </div>
  &nbsp;&nbsp;&nbsp;&nbsp;
  	<label for="date">이용일</label>
	<input type="date" name="date">
	<label for="price">가격</label>
	<input type="number" name="price">  ~  <input type="number">
	<div>
		<button class="ui yellow button">필터</button>
	</div>

</div>
<hr>
	<div class="container" align="center">
		<div class="ui link cards">
			<%for(RentListVO rentListVO : list) { %>
			<div class="card" align="center">
				<div class="image" style="width: 290px; height: 210px">
					<img src="<%=request.getContextPath() %>/images/profilePhotos/<%=rentListVO.getChangeNm() %>" style="width:100%; height: 100%">
				</div>
				<div class="content">
					<div class="header"><%=rentListVO.getHallNm() %></div>
					<div class="description"><%=rentListVO.getAddress() %></div>
				</div>
				<div class="extra content">
					<span class="right floated"><%=rentListVO.getRentEnrollDt() %></span>
					<span>
						<i class="user icon"></i> <%=rentListVO.getRentPrice() %>
					</span>
				</div>
			</div>
			<%} %>
		</div>
	</div>
	<script>
		var currentPage = 1;

		$('.special.cards .image').dimmer({
			  on: 'hover'
		});

		$(window).scroll(function (){
			if($(window).scrollTop() == ($(document).height() - $(window).height())){
				currentPage++;
				$.ajax({
					url:"moveRentListAjax.rt",
					data:{type:"ajax", currentPage:currentPage},
					type:"post",
					success:function(data){
						console.log("succ");

						var $linkDiv = $(".link");

						for(var key in data){
							var $carDiv = $("<div class='card' align='center'>");
							var $imageDiv = $('<div class="image" style="width: 290px; height: 210px">');
							var $img = $('<img src="" style="width:100%; height: 100%">');
							var $contentDiv = $('<div class="content">');
							var $headDiv = $('<div class="header"></div>');
							var $descriptionDiv = $('<div class="description"></div>');
							var $extraDiv = $('<div class="extra content">');
							var $rightSpan = $('<span class="right floated"></span>');
							var $span = $('<span>');
							var $i = $('<i class="user icon"></i>');
							$img.attr("src", "<%=request.getContextPath()%>/images/profilePhotos/" + data[key].changeNm);
							$headDiv.text(data[key].hallNm);
							$descriptionDiv.text(data[key].address);
							$rightSpan.text(data[key].rentEnrollDt);


							$span.append($i);
							$span.append(data[key].rentPrice);
							$extraDiv.append($span);
							$extraDiv.append($rightSpan);
							$carDiv.append($imageDiv);
							$contentDiv.append($headDiv);
							$contentDiv.append($descriptionDiv);
							$carDiv.append($contentDiv);
							$imageDiv.append($img);
							$carDiv.append($extraDiv);
							$linkDiv.append($carDiv);
						}

					},
					error:function(){
						console.log("fail");
					}
				})
			}
		});

	</script>

<jsp:include page="/views/common/footer.jsp" />
</body>
</html>