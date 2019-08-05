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

<link href="/happyPlaystage/css/common/all.min.css" rel="stylesheet">
<script src="/happyPlaystage/js/common/all.min.js"></script>


<script type="text/javascript" src="/happyPlaystage/js/common/jquery.oLoader.min.js"></script>
<title>Insert title here</title>
<style>
	.ui.cards {
		padding-left: 8%;
	}
</style>
</head>
<body>
<jsp:include page="/views/common/header.jsp" />



<hr>
	<div class="container" align="center" id='containerDiv'>
		<div class="ui link cards" align="center">
			<%for(RentListVO rentListVO : list) { %>
			<div class="card" align="center" style="width:260px;">
				<input type="hidden" value="<%=rentListVO.getRentSeq() %>" id="rentSeq">
				<div class="image" style="width: 260px; height: 210px">
					<img src="<%=request.getContextPath() %>/images/profilePhotos/<%=rentListVO.getChangeNm() %>" style="width:100%; height: 100%">
				</div>
				<div class="content">
					<div class="header"><%=rentListVO.getHallNm() %></div>
					<div class="description"><%=rentListVO.getAddress() %></div>
				</div>
				<div class="extra content">
					<span class="right floated">
						<i class="far fa-calendar-alt"></i>&nbsp;&nbsp; <%=rentListVO.getRentEnrollDt() %>
					</span>
					<span style="float:left">
						<i class="far fa-credit-card"></i>&nbsp;&nbsp; <%=rentListVO.getRentPrice() %> ￦ / 일
					</span>
				</div>
			</div>
			<%} %>

			<%if(list.size() == 0){ %>
			<div class="container" style="padding-top: 10%; padding-bottom: 20%;">
				<i class="fas fa-ban" style="width: 200px; height: 200px;"></i>
				<h1 style="padding-top: 5%;">검색 결과가 없습니다.</h1>
			</div>
			<%} %>
		</div>
	</div>
	<script>
		var currentPage = 1;

		$('.cards .image').dimmer({
			  on: 'hover'
		});

		$(function(){
			$('.card').click(function(){
				var rentSeqVal = $(this).children('#rentSeq').val();
				location.href = "<%=request.getContextPath() %>/MoveRentDetail.rt?rentSeq=" + rentSeqVal;
			});
		});


		/* 로딩바 */
		$('#right_panel').oLoader({
			  backgroundColor: '#fff',
			  fadeInTime: 500,
			  fadeLevel: 0.8,
			  image: '/happyPlaystage/images/ownageLoader/loader3.gif',
			  style: 3,
			  imagePadding: 5,
			  imageBgColor: '#fe0',
			  hideAfter: 1500,
			  type:'post'
			});
		$(window).scroll(function (){
			if($(window).scrollTop() == ($(document).height() - $(window).height())){
				currentPage++;

				$.ajax({
					url:'moveRentListAjax.rt?searchString=<%=request.getParameter("searchString")%>',
					data:{type:"ajax", currentPage:currentPage},
					type:"post",
					success:function(data){
						console.log("succ");

						var $linkDiv = $(".link");

						for(var key in data){
							var $input = $('<input type="hidden" value="" id="rentSeq">');
							var $carDiv = $("<div class='card' align='center' style='width: 260px;'>");
							var $imageDiv = $('<div class="image" style="width: 260px; height: 210px">');
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
							$input.val(data[key].rentSeq);

							$span.append($i);
							$span.append(data[key].rentPrice);
							$extraDiv.append($span);
							$extraDiv.append($rightSpan);
							$carDiv.append($imageDiv);
							$contentDiv.append($headDiv);
							$contentDiv.append($descriptionDiv);
							$carDiv.append($contentDiv);
							$imageDiv.append($img);
							$carDiv.append($input);
							$carDiv.append($extraDiv);
							$carDiv.append($extraDiv);
							$linkDiv.append($carDiv);
						}

						$('.cards .image').dimmer({
							  on: 'hover'
				});

						$(function(){
							$('.card').click(function(){
								var rentSeqVal = $(this).children('#rentSeq').val();
								location.href = "<%=request.getContextPath() %>/MoveRentDetail.rt?rentSeq=" + rentSeqVal;
							});
						});
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