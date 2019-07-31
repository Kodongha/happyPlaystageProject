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
		$("button[name=editBtn]").click(function(){
			console.log("aa");
			var rentSeqVal = $(this).next().val();
			location.href = '<%=request.getContextPath()%>/moveModifyRentForm.up?rentSeq=' + rentSeqVal;
		});

		$('.detailBtn').click(function(){
			var rentSeqVal = $(this).next().val();
			location.href = '<%=request.getContextPath()%>/MoveRentDetail.rt?rentSeq=' + rentSeqVal;
		});

		$('.deleteBtn').click(function(){
			var rentSeqVal = $(this).next().val();
			location.href = '<%=request.getContextPath()%>/deleteRent.rt?rentSeq=' + rentSeqVal;
//			var rentSeqVal = $(this).parents("#tableList > #rentSeqInput").css("color","red");
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
			<td colspan="2">
				<button class="btns btn btn-warning" id="editBtn" name="editBtn">수정</button>
				<input type="hidden" id="rentSeqInput" value="<%=list.get(i).getRentSeq()%>">
			</td>
			<td colspan="2">
				<button class="btns btn btn-warning detailBtn" id="detailBtn" name="detailBtn">보기</button>
				<input type="hidden" id="rentSeqInput" value="<%=list.get(i).getRentSeq()%>">
			</td>
			<td colspan="1">
				<button class="btns btn btn-default deleteBtn" id="deleteBtn" name="deleteBtn">삭제</button>
				<input type="hidden" id="rentSeqInput" value="<%=list.get(i).getRentSeq()%>">
			</td>
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