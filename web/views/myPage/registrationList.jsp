<?xml version="1.0" encoding="UTF-8" ?>
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
.reg-information {
	margin-left: auto;
	margin-right: auto;
}
.btns {
	width:100%;
	height:100%;
	border-radius:0px;
	font-weight:bold;
}
#editBtn, #detailBtn {
	color:black;
}
#tableList {
	width:45%;
}
</style>
<SCRIPT type="text/javascript">
	$(function(){
		$("#editBtn").click(function(){
			console.log("aa");
			location.href = '<%=request.getContextPath()%>/moveModifyRentForm.up';
		});
	});

</SCRIPT>

</head>
<body>
	<jsp:include page="/views/common/header.jsp" />
	<br>
	<h2 align="center">
		<b>대관 등록 내역</b>
	</h2>
	<br>

	<% for(int i=0; i<list.size(); i++) { %>
	<div id="tableList">
	<table id="list"> <!-- style="margin: auto;" -->
		<tr>
			<td><%=list.get(i).getRentSeq()%>&nbsp;&nbsp; <%=list.get(i).getHallNm() %></td>
		</tr>
		<tr>
			<td colspan="5"><img src="/happyPlaystage/images/rent/rent1.jpg"></td>
		</tr>
		<tr>
			<td colspan="2"><button class="btns btn btn-warning" id="editBtn">수정</button></td>
			<td colspan="2"><button class="btns btn btn-warning" id="detailBtn">보기</button></td>
			<td colspan="1"><button class="btns btn btn-default" id="deleteBtn">삭제</button></td>
		</tr>
	</table>
	</div>
	<br>
	<% } %>

	<script>
		$(function(){
			$("#tableList:nth-child(2n+1)").css("float:right");
		});
	</script>

	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>