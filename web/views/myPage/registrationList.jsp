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
 	width: 95%;
 	float:left;
 }
 #searchBtn {
 	width: 5%;
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
	<form action="<%=request.getContextPath() %>/registUserList.mp" method="post">
      	 <div class="container">
      	 	<select class="form-control" id="sel1" onchange="sendValue()">
   				<option selected disabled>[등록날짜 : 공연장명] 공연장을 선택하세요.</option>
   				<% for(int i=0; i<list.size(); i++) { %>
   				<option value="<%=list.get(i).getRentSeq()%>">
   					<%=list.get(i).getRentEnrollDt()%> : <%=list.get(i).getHallNm()%> : <%=list.get(i).getRentSeq()%>
   				</option>
   				<% } %>
   			</select>
   			<button class="btn btn-default" type="submit" id="searchBtn"><i class="glyphicon glyphicon-search "></i></button>
      	 </div>
       	 <input type="hidden" name="rentSeq" id="rentSeq">
    </form>

  	<script>
  			function sendValue(){
  	 			var value = $("#sel1 option:selected").val();
  	 			console.log(value);

  	 			var rentSeq = $("#rentSeq").val();
  	 			console.log("rentSeq.val() : " + rentSeq);
  	 			rentSeq = value;
  	 			console.log("afterrentSeq : " + rentSeq);
  	 		}
	</script>


 	<br><br>
	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>