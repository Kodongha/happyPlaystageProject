<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="com.kh.hp.rent.model.vo.RentImgVO"%>
<%@page import="com.kh.hp.myPage.model.vo.RegistListVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<RegistListVO> list = (ArrayList<RegistListVO>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<title>Insert title here</title>
<style>
 #sel1 {
 	width: 90%;
 }
 #tt {
 	text-align:center;
 }
</style>

</head>
<body>
	<jsp:include page="/views/common/header.jsp" />
	<br>
	<h2 align="center">
		<b>대관 등록 내역</b>
	</h2>
	<br>
	<form action="<%=request.getContextPath() %>/registUserList.mp" method="get">
      	 <div class="container" align="center">
      	 	<select class="form-control" id="sel1">
   				<option selected disabled>[등록날짜 : 공연장명] 공연장을 선택하세요.</option>
   				<% for(int i=0; i<list.size(); i++) { %>
   				<option value="<%=list.get(i).getRentSeq()%>" id="option<%=0%>">
   					<%=list.get(i).getRentEnrollDt()%> : <%=list.get(i).getHallNm()%>
   				</option>
   				<% } %>
   			</select>
      	 </div>
    </form>
	<div class="container" style="padding-top :5%;" id="proposeListDiv">
		<table class="table" id="proposeListTable">
			<thead id="tt">
			<tr>
				<th style="width:50px;">예약 번호</th>
				<th style="width:60px;">예약자</th>
				<th style="width:120px;">핸드폰 번호</th>
				<th>이메일</th>
				<th style="width:110px;">기간</th>
				<th style="width:50px;">인원</th>
				<th>요청사항</th>
				<th style="width:90px;">공연 계획서</th>
				<th style="width:100px;">신청 날짜</th>
				<th>승인여부</th>
				<th></th>
			</tr>
			</thead>
			<tbody></tbody>
		</table>
	</div>

  	<script>
  		$(function(){
			// 첫 페이지 로딩 때, 테이블 숨기기
  			$('#proposeListDiv').hide();

			// 수락 버튼
  			$(document).on('click', '#confirmBtn', function(){
  				var confirmTf = confirm('해당 신청자를 수락하시겠습니까?');
  				var propSeq = $(this).parents('tbody').children().children().eq(0).text();

  				$.ajax({
  					url:'proposeConfirm.mp',
  					data:{propSeq: propSeq},
  					type:'post',
  					success: function(data){
  						parent.location.reload();
  					},
  					error: function(){
  						console.log("error");
  					}
  				});


  			});

  			// 거절 버튼
  			$(document).on('click', '#rejectBtn', function(){
  				var confirmTf = confirm('해당 신청자를 거절하시겠습니까?');
  				var propSeq = $(this).parents('tbody').children().children().eq(0).text();

  				$.ajax({
  					url:'proposeReject.mp',
  					data:{propSeq: propSeq},
  					type:'post',
  					success: function(data){
  						location.reload();
  					},
  					error: function(){
  						console.log("error");
  					}
  				});
  			});

  			// selectbox 변경될 때마다 값 불러오기
  			$('#sel1').change(function(){

  				var rentSeq = $(this).val();

  				$.ajax({
  					url:'registUserList.mp',
  					data:{rentSeq: rentSeq},
  					type:'post',
  					success: function(data){
  						console.log(data);

  						$('#proposeListTable tbody').remove();


  						var proposeListTable = $('#proposeListTable');
  						var $tbody = $('<tbody/>', {align:'center'})

  						for(var key in data){
	  						var $tr = $('<tr/>');
	  						var $userSeqTd = $('<td/>');
	  						var $propNmTd = $('<td/>');
	  						var $propPhoneTd = $('<td/>');
	  						var $propEmailTd = $('<td/>');
	  						var $startDateAndEndDateTd = $('<td/>');
	  						var $propHeadCountTd = $('<td/>');
	  						var $propReqContentTd = $('<td/>');
	  						var $attchTd = $('<td/>');
	  						var $propDtTd = $('<td/>');
	  						var $confirmBtnTd = $("<td/>");
	  						var $rejectBtnTd = $("<td/>");

	  						var $confirmBtn = $('<button/>', {class : 'btn btn-success', id:'confirmBtn', name:"confirmBtn", text:"수락"});
	  						var $rejectBtn = $('<button/>', {class : 'btn btn-danger', id:'rejectBtn', name:"rejectBtn", text:"거절"});

  							$userSeqTd.text(data[key].propSeq);
  							$propNmTd.text(data[key].propNm);
  							$propPhoneTd.text(data[key].propPhone);
  							$propEmailTd.text(data[key].propEmail);
  							$startDateAndEndDateTd.text(data[key].useStartDt + " ~ " + data[key].useEndDt);
  							$propHeadCountTd.text(data[key].propHeadCount);
  							$propReqContentTd.text(data[key].propReqContent);
  							$attchTd.text(data[key].userSeq);
  							$propDtTd.text(data[key].propDt);
  							$confirmBtnTd.append($confirmBtn);
  							$rejectBtnTd.append($rejectBtn);

  							$tr.append($userSeqTd);
  							$tr.append($propNmTd);
  							$tr.append($propPhoneTd);
  							$tr.append($propEmailTd);
  							$tr.append($startDateAndEndDateTd);
  							$tr.append($propHeadCountTd);
  							$tr.append($propReqContentTd);
  							$tr.append($attchTd);
  							$tr.append($propDtTd);
  							$tr.append($confirmBtnTd);
  							$tr.append($rejectBtnTd);
	  						$tbody.append($tr);
						}
  						proposeListTable.append($tbody);

  						$('#proposeListDiv').show()
  					},
  					error: function(){
  						console.log(error);
  					}
  				});
  			});
  		});
	</script>


 	<br><br>
	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>