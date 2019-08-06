<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.hp.myPage.model.vo.*, java.util.*"%>
<%
 ArrayList<AhnApplyInfoVO> list = (ArrayList<AhnApplyInfoVO>)request.getAttribute("list");
//AhnUsingInfoVO responseUserVO = (AhnUsingInfoVO) request.getAttribute("responseUserVO");
	PageInfo pi = (PageInfo) request.getAttribute("pi");
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<!-- 캘린더 -->
<script type="text/javascript" src="/happyPlaystage/js/common/moment.min.js"></script>
<link rel="stylesheet" href="/happyPlaystage/css/common/daterangepicker.min.css">
<script type="text/javascript" src="/happyPlaystage/js/common/jquery.daterangepicker.min.js"></script>

<!-- 결재 -->
<script src="https://cdn.bootpay.co.kr/js/bootpay-3.0.2.min.js" type="application/javascript"></script>
<title>대관 신청 내역</title>
<style>
	div {
		margin: auto;
	}
	#hallInfo tbody > tr:hover {
		cursor: pointer;
		background: #e6f2ff;
	}

	#hallInfo tbody > tr:active {
		background: #cce6ff;
	}
	th {
		text-align: center;
	}
</style>
<SCRIPT type="text/javascript">

	$(function(){

		// 결제 버튼 클릭 시
		$('button[name=paymentBtn]').click(function(){

			var rentSeq = $(this).parents('tr').children().eq(0).html();
			var hallNm = $(this).parents('tr').children().eq(2).html();
			var propSeq = $(this).parents('tr').children().eq(1).html();
			var propTrxSeq = 'rentOrder' + '_' + $(this).parents('tr').children().eq(1).html();
			var rentSeq = $(this).parents('tr').children().eq(1).html();
			var price = $(this).parents('tr').children().eq(4).html();
			var count = 1;
			var cat1 = '대관';

			console.log(hallNm);
			console.log(propSeq);
			console.log(price);

			BootPay.request({
				price: '100', //실제 결제되는 가격
				application_id: "5d46b3114f74b4002b051f99",
				name: 'Happy Playstage', //결제창에서 보여질 이름
				pg: 'danal',
				method: 'card', //결제수단, 입력하지 않으면 결제수단 선택부터 화면이 시작합니다.
				show_agree_window: 1, // 부트페이 정보 동의 창 보이기 여부
				items: [
					{
						item_name: hallNm, //상품명
						qty: count, //수량
						unique: rentSeq, //해당 상품을 구분짓는 primary key
						price: 100, //상품 단가
						cat1: cat1, // 대표 상품의 카테고리 상, 50글자 이내
					}
				],
				order_id: propTrxSeq, //고유 주문번호로, 생성하신 값을 보내주셔야 합니다.
			}).error(function (data) {
				//결제 진행시 에러가 발생하면 수행됩니다.
				console.log('error');
				console.log(data);
			}).cancel(function (data) {
				//결제가 취소되면 수행됩니다.
				console.log('cancel');
				console.log(data);
			}).ready(function (data) {
				// 가상계좌 입금 계좌번호가 발급되면 호출되는 함수입니다.
				console.log('ready');
				console.log(data);
			}).confirm(function (data) {
				//결제가 실행되기 전에 수행되며, 주로 재고를 확인하는 로직이 들어갑니다.
				//주의 - 카드 수기결제일 경우 이 부분이 실행되지 않습니다.
				console.log('confirm');
				console.log(data);
				var enable = true; // 재고 수량 관리 로직 혹은 다른 처리
				if (enable) {
					this.transactionConfirm(data); // 조건이 맞으면 승인 처리를 한다.
				} else {
					this.removePaymentWindow(); // 조건이 맞지 않으면 결제 창을 닫고 결제를 승인하지 않는다.
				}
			}).close(function (data) {
			    // 결제창이 닫힐때 수행됩니다. (성공,실패,취소에 상관없이 모두 수행됨)
			    console.log('close');
			    console.log(data);
			}).done(function (data) {
				//결제가 정상적으로 완료되면 수행됩니다
				//비즈니스 로직을 수행하기 전에 결제 유효성 검증을 하시길 추천합니다.
				console.log('done');
				console.log(data);

				console.log('승인 완료?');
				paymentTrx(propSeq, data.receipt_id, data.status, data.amount);
			});
		});

		function paymentTrx(propSeq, receipt_id, status, amount) {

			console.log('paymentTrx in');

			$.ajax({
				url: 'payComplete.my',
				data: {propSeq:propSeq, receipt_id:receipt_id, status:status, amount:amount},
				method: 'POST',
				async: false,
				success: function(data){
					console.log("succ");
					if(data > 0){
						alert("결제되었습니다.");
						location.reload();
					} else {
						alert("결제가 실패되었습니다.");
					}
				},
				error: function(){
					console.log("error");
				}
			});
		}
	});
</SCRIPT>
</head>
<body>
<jsp:include page="/views/common/header.jsp" />
	<h2 align="center"><b>대관 신청 내역</b></h2>
	<br>
	<form action="<%=request.getContextPath() %>/searchApplyInfo" method="post">
	<div class="tab1" style="width:650px;">
	<table align="center">
		<thead>
		<tr>
			<th id="rentSeq" style="text-align:left">공연장 고유번호</th>
			<th id="hallNm" style="text-align:left">공연장 이름</th>
			<th id="useDt" style="text-align:left">일자</th>
			<th></th>
		</tr>
		</thead>
		<tbody>
		<tr>
			<td style="padding-right:3%"><input class="form-control" id="rentSeq" type="text" name="rentSeq"></td>
			<td style="padding-right:3%"><input class="form-control" id="hallNm" type="text" name="hallNm"></td>
			<td style="padding-right:3%"><input class="form-control" id="cusClosedate" type="text" name="cusClosedate"></td>
			<td style="padding-right:3%"><button type="submit" class="btn btn-warning">검색</button></td>
		</tr>
		</tbody>
	</table>
	<!-- 캘린더를 파라미터로 가져와서 split으로 자르는법
	if(cusClosedate != null && !cusClosedate.equals("")) {
				String[] temp = cusClosedate.split(" to ");
				cusCloseStart = Date.valueOf(temp[0]);
				cusCloseEnd = Date.valueOf(temp[1]);
			} -->
	</div>
	</form>
	<br>

	<hr>

	<br>
	<div class="tab2" style="width:790px;">
	<!-- <table style="width:790px; height:60px; text-align:center; margin:auto; border-collapse: collapse;" id="hallInfo"> -->
	<table id="hallInfo" class="table" style="text-align: center">
		<thead>
		<tr>
		<th>공연장 번호</th>
		<th>신청번호</th>
		<th>공연장</th>
		<th>사용 일자</th>
		<th>가격</th>
		<th>상태</th>
		<th>처리</th>
		</tr>
		</thead>
		<tbody>
		<% for(int i = 0; i < list.size(); i++){%>
			<tr>
			<td onclick="location.href='<%=request.getContextPath()%>/applyInfoDetail?rentSeq=<%=list.get(i).getRentSeq() %>&hallNm=<%=list.get(i).getHallNm()%>&useStart=<%=list.get(i).getUseStartDt()%>&useEnd=<%=list.get(i).getUseEndDt()%>&propStatus=<%=list.get(i).getPropStatus()%>'"><%= list.get(i).getRentSeq() %></td>
			<td onclick="location.href='<%=request.getContextPath()%>/applyInfoDetail?rentSeq=<%=list.get(i).getRentSeq() %>&hallNm=<%=list.get(i).getHallNm()%>&useStart=<%=list.get(i).getUseStartDt()%>&useEnd=<%=list.get(i).getUseEndDt()%>&propStatus=<%=list.get(i).getPropStatus()%>'"><%= list.get(i).getPropSeq() %></td>
			<td onclick="location.href='<%=request.getContextPath()%>/applyInfoDetail?rentSeq=<%=list.get(i).getRentSeq() %>&hallNm=<%=list.get(i).getHallNm()%>&useStart=<%=list.get(i).getUseStartDt()%>&useEnd=<%=list.get(i).getUseEndDt()%>&propStatus=<%=list.get(i).getPropStatus()%>'"><%= list.get(i).getHallNm() %></td>
			<td onclick="location.href='<%=request.getContextPath()%>/applyInfoDetail?rentSeq=<%=list.get(i).getRentSeq() %>&hallNm=<%=list.get(i).getHallNm()%>&useStart=<%=list.get(i).getUseStartDt()%>&useEnd=<%=list.get(i).getUseEndDt()%>&propStatus=<%=list.get(i).getPropStatus()%>'"><%= list.get(i).getUseStartDt() %> ~ <%= list.get(i).getUseEndDt() %></td>
			<td onclick="location.href='<%=request.getContextPath()%>/applyInfoDetail?rentSeq=<%=list.get(i).getRentSeq() %>&hallNm=<%=list.get(i).getHallNm()%>&useStart=<%=list.get(i).getUseStartDt()%>&useEnd=<%=list.get(i).getUseEndDt()%>&propStatus=<%=list.get(i).getPropStatus()%>'"><%= list.get(i).getPayAmount() %> ￦</td>
			<td onclick="location.href='<%=request.getContextPath()%>/applyInfoDetail?rentSeq=<%=list.get(i).getRentSeq() %>&hallNm=<%=list.get(i).getHallNm()%>&useStart=<%=list.get(i).getUseStartDt()%>&useEnd=<%=list.get(i).getUseEndDt()%>&propStatus=<%=list.get(i).getPropStatus()%>'"><%= list.get(i).getPropStatus() %></td>
			<td>
			<% if(list.get(i).getPropStatus().equals("승인")){ %>
				<button class="paymentBtn" id="paymentBtn" name="paymentBtn" style="width:31pt; height:15pt; background-color:white; border:0.5px solid black; color:black; border-radius: 3px;">결제</button> <button type="submit" style="width:31pt; height:15pt; background-color:white; border:0.5px solid black; color:black; border-radius: 3px;" onclick="location.href='<%=request.getContextPath()%>/payRefund?propSeq=<%=list.get(i).getPropSeq() %>&payAmount=<%=list.get(i).getPayAmount()%>'">취소</button>
			<% } else if(list.get(i).getPropStatus().equals("신청")) {%>
			<button class="cancleBtn" type="submit" style="width:31pt; height:15pt; background-color:white; border:0.5px solid black; color:black; border-radius: 3px;"onclick="location.href='<%=request.getContextPath()%>/applyInfoChange?propSeq=<%=list.get(i).getPropSeq() %>'">취소</button>
			<% } %>
			</td>
			</tr>
		<% } %>
		</tbody>
	</table>
	</div>
	<%-- 페이징처리 --%>
	<% if(maxPage >= 2) { %>
		<div class="pagingArea" align="center">
			<button onclick="location.href='<%=request.getContextPath()%>/applyInfo1?currentPage=1'"><<</button>

			<% if(currentPage <= 1){ %>
			<button disabled><</button>
			<% }else { %>
			<button onclick="location.href='<%=request.getContextPath()%>/applyInfo1?currentPage=<%=currentPage - 1%>'"><</button>
			<% } %>

			<% for(int p = startPage; p <= endPage; p++){
				if(currentPage == p){
			%>
					<button disabled><%= p %></button>
			<% } else { %>
					<button onclick="location.href='<%=request.getContextPath()%>/applyInfo1?currentPage=<%=p%>'"><%= p %></button>
			<%
				}
			   }
			%>

			<% if(currentPage >= maxPage){ %>
			<button disabled>></button>
			<% }else{ %>
			<button onclick="location.href='<%=request.getContextPath()%>/applyInfo1?currentPage=<%=currentPage + 1 %>'">></button>
			<% } %>

			<button onclick="location.href='<%=request.getContextPath()%>/applyInfo1?currentPage=<%=maxPage%>'">>></button>
		</div>
		<% } %>
	<script type="text/javascript">
		$('#cusClosedate').dateRangePicker();
	</script>
	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>