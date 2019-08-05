<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.kh.hp.admin.model.vo.RealTimeVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	ArrayList<RealTimeVO> realTimeVOs = (ArrayList<RealTimeVO>) request.getAttribute("realTimeVOs");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
	.table>tbody>tr>td{
		vertical-align: middle;
	}

</style>
<script type="text/javascript">
	$(function(){
		$('button[name=searchbutton]').click(function(){
			location.href = '<%=request.getContextPath() %>/moveRealTimeAdminConversation.ad?roomSeq=' + $(this).next().val();
		});
	});
</script>
</head>
<body>
	<jsp:include page="/views/common/header.jsp" />
	<div class="container">
		<!-- 타이틀 -->
		<h2><strong>1:1문의등록</strong></h2>
		<hr>
		<!-- 회원관리내역과 검색창 사이의 선 -->
		<div id="line"></div>
		<br><br>
		<div class="container">
			<table class="table" >

				<%for(RealTimeVO realTimeVO : realTimeVOs){%>
					<tr>
						<td class="Contents" align="center"><%=realTimeVO.getUserNick() %></td>
						<%if(realTimeVO.getRcvMsg() != null){ %>
						<td class="Contents" align="center"><%=realTimeVO.getRcvMsg() %></td>
						<%} else {%>
						<td class="Contents" align="center">[ 답변 완료 ]</td>
						<%} %>
						<td class="Contents" align="center"><%=sdf.format(realTimeVO.getLastRcvDate()) %></td>
						<td class="Contents" align="center">
							<%if(realTimeVO.getStatus() == 1){ %>
							<button type="button" class="btn btn-primary" id="searchbutton" name="searchbutton">답변대기</button>
							<%} else { %>
							<button type="button" class="btn" style="background: lightgray">답변완료</button>
							<%} %>
							<input type="hidden" name="roomSeq" id="roomSeq" value="<%=realTimeVO.getRoomSeq() %>">
						</td>
					</tr>
				<%}%>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</table>
		</div>

	</div>


	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>