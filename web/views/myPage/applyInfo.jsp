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

<title>대관 신청 내역</title>
<style>
	div {
		margin:auto;
	}
	#tab1{
		background-color: darkgray;
		 border: 1px solid lightgray;
	}
	#tab2 {
	 border: 1px solid lightgray;
  } 
</style>
</head>
<body>
<jsp:include page="/views/common/header.jsp" />
	<h1 align=center style="color:gray">대관 신청 내역</h1>
	<form action="<%=request.getContextPath() %>/searchApplyInfo" method="post">
	<div class="tab1" style="width:650px;border:1.5px solid black">
	<table align="center">
		<tr>
			<td id="rentSeq" name="rentSeq">공연장 고유번호</td>
			<td id="propNm" name="propNm">공연장 이름</td>
			<td id="useStartDt" name="useStartDt">일자</td>
			<td></td>
		</tr>
		<tr>
			<td><input type="text" name="rentSeq"></td>
			<td><input type="text" name="propNm"></td>
			<td>
				<input name="cusClosedate" id="cusClosedate">			
			</td>
			<td><input type="submit"></td>
		</tr>
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
	
	<table style="width:790px; height:113px; text-align:center; margin:auto; border-collapse: collapse;">
		<tr>
		<td id="tab1">신청 공연장 고유번호</td>
		<td id="tab1">공연장 이름</td>
		<td id="tab1">사용할 일자</td>
		<td id="tab1">신청 상태</td>
		</tr>
		<% for(int i = 0; i < list.size(); i++){
			
			%>
			<tr>
			<td id="tab2"><%= list.get(i).getRentSeq() %></td>
			<td id="tab2"><%= list.get(i).getHallNm() %></td>
			<td id="tab2"><%= list.get(i).getUseStartDt() %> ~ <%= list.get(i).getUseEndDt() %></td>
			<td id="tab2"><%= list.get(i).getPropStatus() %></td>
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
	</table>
	</div>
	<%-- 페이징처리 --%>
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
	<script type="text/javascript">
		$('#cusClosedate').dateRangePicker();
	</script>		
	<jsp:include page="/views/common/footer.jsp" />
</body>
</html> 