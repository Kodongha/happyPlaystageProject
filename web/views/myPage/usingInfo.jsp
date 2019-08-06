<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.hp.myPage.model.vo.*, java.util.*"%>
<%
 ArrayList<AhnUsingInfoVO> list = (ArrayList<AhnUsingInfoVO>)request.getAttribute("list");
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

<title>대관 사용 내역</title>
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
</head>
<body>
<jsp:include page="/views/common/header.jsp" />
	<h2 align="center"><b>대관 사용 내역</b></h2>
	<br>
	<form action="<%=request.getContextPath()%>/searchUsingInfo" method="post">
	<div class="tab1" style="width:650px;">
	<table align="center">
		<thead>
		<tr>
			<th id="rentSeq" name="rentSeq" style="text-align:left">공연장 고유번호</th>
			<th id="hallNm" name="hallNm" style="text-align:left">공연장 이름</th>
			<th id="useDt" name="useDt" style="text-align:left">일자</th>
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
		<th id="tab1">공연장 고유번호</th>
		<th id="tab1">상호명</th>
		<th id="tab1">사용일자</th>
		<th id="tab1">사용공간 이름</th>
		</tr>
		</thead>
		<tbody>
		<% for(int i = 0; i < list.size(); i++){ %>
			<tr onclick="location.href='<%=request.getContextPath()%>/usingInfoDetail?rentSeq=<%=list.get(i).getRentSeq() %>&hallNm=<%=list.get(i).getHallNm()%>&useStart=<%=list.get(i).getUseStartDt()%>&useEnd=<%=list.get(i).getUseEndDt()%>'">
			<td id="tab2"><%= list.get(i).getRentSeq() %></td>
			<td id="tab2"><%= list.get(i).getCompNm() %></td>
			<td id="tab2"><%= list.get(i).getUseStartDt() %> ~ <%= list.get(i).getUseEndDt() %></td>
			<td id="tab2"><%= list.get(i).getHallNm() %></td>
			</tr>
		<% } %>

		<%-- <tr>
		<td id="tab2"><%= list.get(0).getRentSeq() %></td>
		<td id="tab2"><%= list.get(0).getPropNm() %></td>
		<td id="tab2"><%= list.get(0).getUseStartDt() %></td>
		<td id="tab2"><%= list.get(0).getPropNm() %></td>
		</tr>
		<tr>
		<td id="tab2"></td>
		<td id="tab2"></td>
		<td id="tab2"></td>
		<td id="tab2"></td>
		</tr>
		<tr>
		<td id="tab2"></td>
		<td id="tab2"></td>
		<td id="tab2"></td>
		<td id="tab2"></td>
		</tr> --%>
		</tbody>
	</table>
	</div>
	<%-- 페이징처리 --%>
	<% if(maxPage >= 2) { %>
		<div class="pagingArea" align="center">
			<button onclick="location.href='<%=request.getContextPath()%>/usingInfo?currentPage=1'"><<</button>

			<% if(currentPage <= 1){ %>
			<button disabled><</button>
			<% }else { %>
			<button onclick="location.href='<%=request.getContextPath()%>/usingInfo?currentPage=<%=currentPage - 1%>'"><</button>
			<% } %>

			<% for(int p = startPage; p <= endPage; p++){
				if(currentPage == p){
			%>
					<button disabled><%= p %></button>
			<% } else { %>
					<button onclick="location.href='<%=request.getContextPath()%>/usingInfo?currentPage=<%=p%>'"><%= p %></button>
			<%
				}
			   }
			%>

			<% if(currentPage >= maxPage){ %>
			<button disabled>></button>
			<% }else{ %>
			<button onclick="location.href='<%=request.getContextPath()%>/usingInfo?currentPage=<%=currentPage + 1 %>'">></button>
			<% } %>

			<button onclick="location.href='<%=request.getContextPath()%>/usingInfo?currentPage=<%=maxPage%>'">>></button>
		</div>
		<% } %>
		<script type="text/javascript">
		$('#cusClosedate').dateRangePicker();
	</script>
	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>